package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public class an {
    private View d;
    public Point c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f11103a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f11104b = new Rect();

    public an(View view) {
        this.d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.d.getGlobalVisibleRect(this.f11103a, this.c);
        if (this.c.x == 0 && this.c.y == 0 && this.f11103a.height() == this.d.getHeight() && this.f11104b.height() != 0 && Math.abs(this.f11103a.top - this.f11104b.top) > this.d.getHeight() / 2) {
            this.f11103a.set(this.f11104b);
        }
        this.f11104b.set(this.f11103a);
        return globalVisibleRect;
    }
}
