package com.mofamulu.tieba.tail;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ MoreMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MoreMapActivity moreMapActivity) {
        this.a = moreMapActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.a.m) {
            this.a.o.r(z);
        } else if (compoundButton == this.a.n) {
            this.a.o.s(z);
        }
    }
}
