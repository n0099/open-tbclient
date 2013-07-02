package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Activity activity) {
        this.a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity.a(this.a, bg.c().d(), (String) null);
    }
}
