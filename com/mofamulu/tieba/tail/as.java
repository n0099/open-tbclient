package com.mofamulu.tieba.tail;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import java.util.List;
/* loaded from: classes.dex */
class as implements AdapterView.OnItemClickListener {
    final /* synthetic */ ar a;
    private final /* synthetic */ List b;
    private final /* synthetic */ EditText c;
    private final /* synthetic */ Dialog d;
    private final /* synthetic */ Activity e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar, List list, EditText editText, Dialog dialog, Activity activity) {
        this.a = arVar;
        this.b = list;
        this.c = editText;
        this.d = dialog;
        this.e = activity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = (String) this.b.get(i);
        int selectionStart = this.c.getSelectionStart();
        int selectionEnd = this.c.getSelectionEnd();
        if (selectionStart > -1 && selectionEnd > -1) {
            this.c.getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd), str, 0, str.length());
        } else {
            this.c.append(str);
        }
        this.d.dismiss();
        this.c.requestFocus();
        com.baidu.tieba.util.aa.b(this.e, this.c);
    }
}
