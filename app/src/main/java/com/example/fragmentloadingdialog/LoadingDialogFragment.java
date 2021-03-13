package com.example.fragmentloadingdialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;

public class LoadingDialogFragment extends DialogFragment {

    public static final String TAG = "LOADING_DIALOG";
    View fragmentView;

    public static LoadingDialogFragment newInstance(boolean cancelable) {
        Bundle args = new Bundle();
        args.putBoolean("CANCELABLE", cancelable);
        LoadingDialogFragment fragment = new LoadingDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static LoadingDialogFragment newInstance() {
        Bundle args = new Bundle();
        args.putBoolean("CANCELABLE", true);
        LoadingDialogFragment fragment = new LoadingDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.loading_layout, container, false);

        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setCancelable(getArguments().getBoolean("CANCELABLE"));
        getDialog().setCanceledOnTouchOutside(getArguments().getBoolean("CANCELABLE"));
        ImageView imv = fragmentView.findViewById(R.id.imv);
        Glide.with(this).asGif().load(R.drawable.tenor).into(imv);


        if (!getArguments().getBoolean("CANCELABLE")) {
            new CountDownTimer(6000, 6000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    dismiss();
                }
            }.start();
        }

    }

    @Override
    public int getTheme() {
        return R.style.DialogTheme;
    }
}
