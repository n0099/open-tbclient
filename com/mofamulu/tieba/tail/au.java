package com.mofamulu.tieba.tail;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
/* loaded from: classes.dex */
class au implements AdapterView.OnItemClickListener {
    final /* synthetic */ at a;
    private final /* synthetic */ TextView b;
    private final /* synthetic */ List c;
    private final /* synthetic */ Dialog d;
    private final /* synthetic */ EditText e;
    private final /* synthetic */ Activity f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, TextView textView, List list, Dialog dialog, EditText editText, Activity activity) {
        this.a = atVar;
        this.b = textView;
        this.c = list;
        this.d = dialog;
        this.e = editText;
        this.f = activity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            an.b = null;
            this.b.setText("无尾巴");
        } else {
            an.b = (an) this.c.get(i - 1);
            this.b.setText(an.b.c);
        }
        this.d.dismiss();
        this.e.requestFocus();
        com.baidu.tieba.util.aa.b(this.f, this.e);
    }
}
