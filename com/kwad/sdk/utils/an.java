package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes3.dex */
public class an {
    private View d;
    public Point c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f7134a = new Rect();
    public Rect b = new Rect();

    public an(View view) {
        this.d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.d.getGlobalVisibleRect(this.f7134a, this.c);
        if (this.c.x == 0 && this.c.y == 0 && this.f7134a.height() == this.d.getHeight() && this.b.height() != 0 && Math.abs(this.f7134a.top - this.b.top) > this.d.getHeight() / 2) {
            this.f7134a.set(this.b);
        }
        this.b.set(this.f7134a);
        return globalVisibleRect;
    }
}
