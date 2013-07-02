package com.mofamulu.tieba.tail;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ MoreOthersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MoreOthersActivity moreOthersActivity) {
        this.a = moreOthersActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.showDialog(R.id.psw_mins_container);
    }
}
