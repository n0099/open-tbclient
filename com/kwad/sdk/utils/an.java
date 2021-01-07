package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public class an {
    private View d;
    public Point c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f11104a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f11105b = new Rect();

    public an(View view) {
        this.d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.d.getGlobalVisibleRect(this.f11104a, this.c);
        if (this.c.x == 0 && this.c.y == 0 && this.f11104a.height() == this.d.getHeight() && this.f11105b.height() != 0 && Math.abs(this.f11104a.top - this.f11105b.top) > this.d.getHeight() / 2) {
            this.f11104a.set(this.f11105b);
        }
        this.f11105b.set(this.f11104a);
        return globalVisibleRect;
    }
}
