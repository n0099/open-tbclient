package com.mofamulu.tieba.ch;

import android.view.View;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ MoreVipActivity a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(MoreVipActivity moreVipActivity, boolean z) {
        this.a = moreVipActivity;
        this.b = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b) {
            this.a.q.setVisibility(0);
            this.a.s.c(this.a);
            return;
        }
        this.a.c("请先以VIP帐号登录再使用云端服务。");
    }
}
