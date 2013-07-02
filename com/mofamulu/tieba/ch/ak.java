package com.mofamulu.tieba.ch;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ MoreNickActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(MoreNickActivity moreNickActivity) {
        this.a = moreNickActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.showDialog(R.id.delay_outof_wifi);
    }
}
