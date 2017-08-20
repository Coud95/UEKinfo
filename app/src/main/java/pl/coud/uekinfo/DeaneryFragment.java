package pl.coud.uekinfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeaneryFragment extends Fragment {
    Spinner spinner;
    WebView webView;
    public DeaneryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deanery, container, false);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        webView = (WebView) view.findViewById(R.id.webView);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.deanery_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected = parentView.getItemAtPosition(position).toString();
                switch(selected) {
                    case "Wydział Ekonomii i Stosunków Międzynarodowych":
                        webView.loadUrl("http://uek.krakow.pl/pl/uczelnia/wydzialy/wydzial-ekonomii-i-stosunkow-miedzynarodowych/wydzial/dziekanat.html");
                        break;
                    case "Wydział Finansów i Prawa":
                        webView.loadUrl("http://uek.krakow.pl/pl/uczelnia/wydzialy/wydzial-finansow-i-prawa/wydzial/dziekanat.html");
                        break;
                    case "Wydział Gospodarki i Administracji Publicznej":
                        webView.loadUrl("http://gap.uek.krakow.pl/o-wydziale/dziekanat/");
                        break;
                    case "Wydział Towaroznawstwa":
                        webView.loadUrl("http://uek.krakow.pl/pl/uczelnia/wydzialy/wydzial-towaroznawstwa/wydzial/dziekanat.html");
                        break;
                    case "Wydział Zarządzania":
                        webView.loadUrl("http://uek.krakow.pl/pl/uczelnia/wydzialy/wydzial-zarzadzania/wydzial/dziekanat.html");
                        break;
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
        return view;
    }
}
