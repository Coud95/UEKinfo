package pl.coud.uekinfo;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WiFiFragment extends Fragment {
    TextView eduroam;

    public WiFiFragment() {
        // Required empty public constructor
    }

    public static Spanned fromHtml(String source) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(source);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wifi, container, false);
        eduroam = (TextView) view.findViewById(R.id.eduroam);
        eduroam.setText(fromHtml("Nazwa sieci bezprzewodowej SSID:<br>" +
                "<b>eduroam</b><br>" +
                "Typ zabezpieczeń:<br>" +
                "<b>WPA enterprise lub WPA2 enterprise</b><br>" +
                "Szyfrowanie:<br>" +
                "<b>TKIP (WPA) lub AES-CCMP (WPA2)</b><br>" +
                "Metoda uwierzytelniania:<br>" +
                "<b>TTLS</b><br>" +
                "Uwierzytelnianie (faza 2):<br>" +
                "<b>PAP</b><br>" +
                " Nazwa użytkownika:<br>" +
                "<b>s+numer_indeksu@wizard.uek.krakow.pl</b><br>" +
                "( np. s203379@wizard.uek.krakow.pl )<br>" +
                "Hasło:<br>" +
                "<b>zgodne z kontem w systemie wizard</b><br>" +
                "Zaleca się stosowanie szyfrowania:<br>" +
                "<b>WPA2 (AES)</b>"));
        return view;
    }

}
