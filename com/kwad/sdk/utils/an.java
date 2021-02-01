package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes3.dex */
public class an {
    private View d;
    public Point c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f10806a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f10807b = new Rect();

    public an(View view) {
        this.d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.d.getGlobalVisibleRect(this.f10806a, this.c);
        if (this.c.x == 0 && this.c.y == 0 && this.f10806a.height() == this.d.getHeight() && this.f10807b.height() != 0 && Math.abs(this.f10806a.top - this.f10807b.top) > this.d.getHeight() / 2) {
            this.f10806a.set(this.f10807b);
        }
        this.f10807b.set(this.f10806a);
        return globalVisibleRect;
    }
}
