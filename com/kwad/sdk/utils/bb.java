package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public final class bb {
    public View d;
    public Point c = new Point();
    public Rect a = new Rect();
    public Rect b = new Rect();

    public bb(View view2) {
        this.d = view2;
    }

    public final boolean a() {
        boolean globalVisibleRect = this.d.getGlobalVisibleRect(this.a, this.c);
        Point point = this.c;
        if (point.x == 0 && point.y == 0 && this.a.height() == this.d.getHeight() && this.b.height() != 0 && Math.abs(this.a.top - this.b.top) > this.d.getHeight() / 2) {
            this.a.set(this.b);
        }
        this.b.set(this.a);
        return globalVisibleRect;
    }
}
