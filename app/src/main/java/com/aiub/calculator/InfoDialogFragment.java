package com.aiub.calculator;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfoDialogFragment extends DialogFragment implements View.OnClickListener {

    private TextView ok;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      // getDialog().getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ));
        View view = getLayoutInflater().inflate( R.layout.info_fragment, container, false );

       ok=view.findViewById(R.id.ok);
        ok.setOnClickListener( this );
        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.ok)
            dismiss();
    }
}
