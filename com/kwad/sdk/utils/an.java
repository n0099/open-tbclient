package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes7.dex */
public class an {

    /* renamed from: d  reason: collision with root package name */
    public View f37609d;

    /* renamed from: c  reason: collision with root package name */
    public Point f37608c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f37606a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f37607b = new Rect();

    public an(View view) {
        this.f37609d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f37609d.getGlobalVisibleRect(this.f37606a, this.f37608c);
        Point point = this.f37608c;
        if (point.x == 0 && point.y == 0 && this.f37606a.height() == this.f37609d.getHeight() && this.f37607b.height() != 0 && Math.abs(this.f37606a.top - this.f37607b.top) > this.f37609d.getHeight() / 2) {
            this.f37606a.set(this.f37607b);
        }
        this.f37607b.set(this.f37606a);
        return globalVisibleRect;
    }
}
