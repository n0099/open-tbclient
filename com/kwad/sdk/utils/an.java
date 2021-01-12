package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes4.dex */
public class an {
    private View d;
    public Point c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f10804a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f10805b = new Rect();

    public an(View view) {
        this.d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.d.getGlobalVisibleRect(this.f10804a, this.c);
        if (this.c.x == 0 && this.c.y == 0 && this.f10804a.height() == this.d.getHeight() && this.f10805b.height() != 0 && Math.abs(this.f10804a.top - this.f10805b.top) > this.d.getHeight() / 2) {
            this.f10804a.set(this.f10805b);
        }
        this.f10805b.set(this.f10804a);
        return globalVisibleRect;
    }
}
