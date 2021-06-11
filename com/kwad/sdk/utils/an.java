package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes7.dex */
public class an {

    /* renamed from: d  reason: collision with root package name */
    public View f37511d;

    /* renamed from: c  reason: collision with root package name */
    public Point f37510c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f37508a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f37509b = new Rect();

    public an(View view) {
        this.f37511d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f37511d.getGlobalVisibleRect(this.f37508a, this.f37510c);
        Point point = this.f37510c;
        if (point.x == 0 && point.y == 0 && this.f37508a.height() == this.f37511d.getHeight() && this.f37509b.height() != 0 && Math.abs(this.f37508a.top - this.f37509b.top) > this.f37511d.getHeight() / 2) {
            this.f37508a.set(this.f37509b);
        }
        this.f37509b.set(this.f37508a);
        return globalVisibleRect;
    }
}
