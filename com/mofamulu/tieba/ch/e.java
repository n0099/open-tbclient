package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final Activity a;
    final Class b;

    public e(Activity activity, Class cls) {
        this.a = activity;
        this.b = cls;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.startActivity(new Intent(this.a, this.b));
    }
}
