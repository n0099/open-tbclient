package com.mofamulu.tieba.tail;

import android.widget.CompoundButton;
/* loaded from: classes.dex */
class o implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ n a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, int i) {
        this.a = nVar;
        this.b = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MoreEmotionsActivity moreEmotionsActivity;
        moreEmotionsActivity = this.a.a;
        ((c) moreEmotionsActivity.m.get(this.b)).c = z;
    }
}
