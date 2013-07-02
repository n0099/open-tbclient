package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Activity activity) {
        this.a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.a, FrsActivity.class);
        intent.putExtra("name", "咔咔_嘎嘎的窝");
        this.a.startActivity(intent);
    }
}
