package com.mofamulu.tieba.dslv.lock;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ LockPatternActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LockPatternActivity lockPatternActivity) {
        this.a = lockPatternActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(0);
    }
}
