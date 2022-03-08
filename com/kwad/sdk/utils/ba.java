package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes8.dex */
public class ba {

    /* renamed from: d  reason: collision with root package name */
    public View f56493d;

    /* renamed from: c  reason: collision with root package name */
    public Point f56492c = new Point();
    public Rect a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f56491b = new Rect();

    public ba(View view) {
        this.f56493d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f56493d.getGlobalVisibleRect(this.a, this.f56492c);
        Point point = this.f56492c;
        if (point.x == 0 && point.y == 0 && this.a.height() == this.f56493d.getHeight() && this.f56491b.height() != 0 && Math.abs(this.a.top - this.f56491b.top) > this.f56493d.getHeight() / 2) {
            this.a.set(this.f56491b);
        }
        this.f56491b.set(this.a);
        return globalVisibleRect;
    }
}
