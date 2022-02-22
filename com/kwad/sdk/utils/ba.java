package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes4.dex */
public class ba {

    /* renamed from: d  reason: collision with root package name */
    public View f58143d;

    /* renamed from: c  reason: collision with root package name */
    public Point f58142c = new Point();
    public Rect a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f58141b = new Rect();

    public ba(View view) {
        this.f58143d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f58143d.getGlobalVisibleRect(this.a, this.f58142c);
        Point point = this.f58142c;
        if (point.x == 0 && point.y == 0 && this.a.height() == this.f58143d.getHeight() && this.f58141b.height() != 0 && Math.abs(this.a.top - this.f58141b.top) > this.f58143d.getHeight() / 2) {
            this.a.set(this.f58141b);
        }
        this.f58141b.set(this.a);
        return globalVisibleRect;
    }
}
