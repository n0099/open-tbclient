package com.mofamulu.tieba.ch;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ MoreVipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(MoreVipActivity moreVipActivity) {
        this.a = moreVipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.r.x().c();
        this.a.o.setText(R.string.vip_cleared);
    }
}
