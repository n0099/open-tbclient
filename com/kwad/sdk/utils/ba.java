package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes3.dex */
public class ba {

    /* renamed from: d  reason: collision with root package name */
    public View f60217d;

    /* renamed from: c  reason: collision with root package name */
    public Point f60216c = new Point();
    public Rect a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f60215b = new Rect();

    public ba(View view) {
        this.f60217d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f60217d.getGlobalVisibleRect(this.a, this.f60216c);
        Point point = this.f60216c;
        if (point.x == 0 && point.y == 0 && this.a.height() == this.f60217d.getHeight() && this.f60215b.height() != 0 && Math.abs(this.a.top - this.f60215b.top) > this.f60217d.getHeight() / 2) {
            this.a.set(this.f60215b);
        }
        this.f60215b.set(this.a);
        return globalVisibleRect;
    }
}
