package com.mofamulu.tieba.tail;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ MoreOthersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MoreOthersActivity moreOthersActivity) {
        this.a = moreOthersActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.a.q) {
            this.a.y.k(z);
            com.mofamulu.tieba.ch.a.a();
        } else if (compoundButton == this.a.r) {
            this.a.y.n(z);
        } else if (compoundButton == this.a.s) {
            this.a.y.o(z);
        } else if (compoundButton == this.a.t) {
            this.a.y.q(z);
        } else if (compoundButton == this.a.u) {
            this.a.y.p(z);
        } else if (compoundButton == this.a.v) {
            this.a.y.l(z);
        } else if (compoundButton == this.a.w) {
            this.a.y.m(z);
        }
    }
}
