package com.mofamulu.tieba.tail;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    private final /* synthetic */ EditText a;
    private final /* synthetic */ EditText b;
    private final /* synthetic */ bg c;
    private final /* synthetic */ Activity d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(EditText editText, EditText editText2, bg bgVar, Activity activity, boolean z, String str) {
        this.a = editText;
        this.b = editText2;
        this.c = bgVar;
        this.d = activity;
        this.e = z;
        this.f = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String editable = this.a.getText().toString();
        String editable2 = this.b.getText().toString();
        if (!this.c.e(false)) {
            if (editable2.length() > 1000 || editable2.contains("#(") || editable2.contains("@") || editable2.split("\n").length > 15) {
                Toast.makeText(this.d, this.d.getString(R.string.tail_toolong_hint), 1).show();
                return;
            }
        } else if (bg.c().x().a.optInt(bg.a(), 0) == 0) {
            com.mofamulu.tieba.ch.a.a = 63;
            com.mofamulu.tieba.ch.a.a();
            this.d.setResult(1);
            this.d.finish();
            return;
        }
        if (this.e) {
            this.c.b(this.f, TailListActivity.k, editable, editable2);
        } else {
            this.c.a(this.f, TailListActivity.k, editable, editable2);
        }
        this.d.setResult(1);
        this.d.finish();
    }
}
