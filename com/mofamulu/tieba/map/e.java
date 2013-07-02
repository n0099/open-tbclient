package com.mofamulu.tieba.map;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ FreeJumpByMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FreeJumpByMapActivity freeJumpByMapActivity) {
        this.a = freeJumpByMapActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
