package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes3.dex */
public class ba {

    /* renamed from: d  reason: collision with root package name */
    public View f57931d;

    /* renamed from: c  reason: collision with root package name */
    public Point f57930c = new Point();
    public Rect a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f57929b = new Rect();

    public ba(View view) {
        this.f57931d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f57931d.getGlobalVisibleRect(this.a, this.f57930c);
        Point point = this.f57930c;
        if (point.x == 0 && point.y == 0 && this.a.height() == this.f57931d.getHeight() && this.f57929b.height() != 0 && Math.abs(this.a.top - this.f57929b.top) > this.f57931d.getHeight() / 2) {
            this.a.set(this.f57929b);
        }
        this.f57929b.set(this.a);
        return globalVisibleRect;
    }
}
