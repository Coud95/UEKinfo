package pl.coud.uekinfo;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private TextView news;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        news = (TextView) view.findViewById(R.id.news);
        getWebsite();
        return view;
    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String source) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(source);
        }
    }
    private void getWebsite() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();

                try {
                    Document doc = Jsoup.connect("http://uek.krakow.pl/pl/aktualnosci.html").get();
                    Elements wiadomosci = doc.select("div[class=wiadomosc]");
                    int numer = 1;
                    for(Element wiadomosc : wiadomosci) {
                        builder.append("<br><h3>" + numer + ". ").append(wiadomosc.select("div[class=data").text())
                                .append("</h3>" + wiadomosc.select("div[class=tytul").text()).append("<br>");
                        numer++;
                    }

                } catch (IOException e) {
                    builder.append("Problem z połączeniem");
                }
                getActivity().runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        String newsText = builder.toString();
                        news.setText(fromHtml(newsText));
                    }
                });
            }
        }).start();

    }

}
