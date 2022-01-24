package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes3.dex */
public class ba {

    /* renamed from: d  reason: collision with root package name */
    public View f57976d;

    /* renamed from: c  reason: collision with root package name */
    public Point f57975c = new Point();
    public Rect a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f57974b = new Rect();

    public ba(View view) {
        this.f57976d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f57976d.getGlobalVisibleRect(this.a, this.f57975c);
        Point point = this.f57975c;
        if (point.x == 0 && point.y == 0 && this.a.height() == this.f57976d.getHeight() && this.f57974b.height() != 0 && Math.abs(this.a.top - this.f57974b.top) > this.f57976d.getHeight() / 2) {
            this.a.set(this.f57974b);
        }
        this.f57974b.set(this.a);
        return globalVisibleRect;
    }
}
