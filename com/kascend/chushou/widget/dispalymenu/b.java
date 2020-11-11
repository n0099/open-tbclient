package com.kascend.chushou.widget.dispalymenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected ViewGroup f4268a;
    protected View b;
    protected View c;
    protected int d;
    protected int e;

    public abstract int a(int i, int i2);

    public abstract void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6);

    public abstract void a(ArrayList<Animator> arrayList, ArrayList<Animator> arrayList2, AnimatorSet animatorSet, int i, int i2);

    public abstract int b(int i, int i2);

    public abstract void b(boolean z, int i, int i2, int i3, int i4);

    public abstract int c(int i, int i2);

    public abstract int ej(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, View view, View view2, int i, int i2) {
        this.f4268a = viewGroup;
        this.b = view;
        this.c = view2;
        this.d = i;
        this.e = i2;
    }
}
