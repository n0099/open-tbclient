package com.mofamulu.tieba.tail;

import android.view.View;
import com.mofamulu.tieba.dslv.lock.LockPatternActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ MoreOthersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MoreOthersActivity moreOthersActivity) {
        this.a = moreOthersActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.startActivity(LockPatternActivity.b(this.a, this.a.y));
    }
}
