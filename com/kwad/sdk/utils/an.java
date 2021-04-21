package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes6.dex */
public class an {

    /* renamed from: d  reason: collision with root package name */
    public View f37138d;

    /* renamed from: c  reason: collision with root package name */
    public Point f37137c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f37135a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f37136b = new Rect();

    public an(View view) {
        this.f37138d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f37138d.getGlobalVisibleRect(this.f37135a, this.f37137c);
        Point point = this.f37137c;
        if (point.x == 0 && point.y == 0 && this.f37135a.height() == this.f37138d.getHeight() && this.f37136b.height() != 0 && Math.abs(this.f37135a.top - this.f37136b.top) > this.f37138d.getHeight() / 2) {
            this.f37135a.set(this.f37136b);
        }
        this.f37136b.set(this.f37135a);
        return globalVisibleRect;
    }
}
