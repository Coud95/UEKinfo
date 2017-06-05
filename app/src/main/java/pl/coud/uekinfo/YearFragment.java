package pl.coud.uekinfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple {@link Fragment} subclass.
 */
public class YearFragment extends Fragment {
    PDFView pdfView;

    public YearFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_year, container, false);
        pdfView = (PDFView) view.findViewById(R.id.pdf);
        pdfView.fromAsset("ZR_26_2016.pdf").load();
        return view;
    }

}
