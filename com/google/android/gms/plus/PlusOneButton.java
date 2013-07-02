package com.google.android.gms.plus;

import android.content.Intent;
import android.view.ViewGroup;
import com.google.android.gms.internal.dz;
/* loaded from: classes.dex */
public final class PlusOneButton extends ViewGroup {
    private final dz a;

    /* loaded from: classes.dex */
    public interface OnPlusOneClickListener {
        void a(Intent intent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        dz dzVar = this.a;
        measureChild(dzVar, i, i2);
        setMeasuredDimension(dzVar.getMeasuredWidth(), dzVar.getMeasuredHeight());
    }

    public void setAnnotation(int i) {
        this.a.setAnnotation(i);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.a.setOnPlusOneClickListener(onPlusOneClickListener);
    }

    public void setSize(int i) {
        this.a.setSize(i);
    }
}
