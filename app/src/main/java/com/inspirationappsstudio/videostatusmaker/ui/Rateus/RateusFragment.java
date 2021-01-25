package com.inspirationappsstudio.videostatusmaker.ui.Rateus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.inspirationappsstudio.videostatusmaker.R;

public class RateusFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_rateus, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);

        return root;
    }
}