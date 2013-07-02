package com.mofamulu.tieba.sign;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ MoreSignActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MoreSignActivity moreSignActivity) {
        this.a = moreSignActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.showDialog(R.id.sign_more_rand_delay);
    }
}
