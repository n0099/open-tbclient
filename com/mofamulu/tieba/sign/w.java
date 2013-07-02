package com.mofamulu.tieba.sign;

import android.widget.CompoundButton;
/* loaded from: classes.dex */
class w implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ v a;
    private final /* synthetic */ au b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, au auVar) {
        this.a = vVar;
        this.b = auVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.b.e = z;
    }
}
