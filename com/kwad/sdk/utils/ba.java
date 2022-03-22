package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes7.dex */
public class ba {

    /* renamed from: d  reason: collision with root package name */
    public View f41380d;

    /* renamed from: c  reason: collision with root package name */
    public Point f41379c = new Point();
    public Rect a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f41378b = new Rect();

    public ba(View view) {
        this.f41380d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f41380d.getGlobalVisibleRect(this.a, this.f41379c);
        Point point = this.f41379c;
        if (point.x == 0 && point.y == 0 && this.a.height() == this.f41380d.getHeight() && this.f41378b.height() != 0 && Math.abs(this.a.top - this.f41378b.top) > this.f41380d.getHeight() / 2) {
            this.a.set(this.f41378b);
        }
        this.f41378b.set(this.a);
        return globalVisibleRect;
    }
}
