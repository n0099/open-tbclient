package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes6.dex */
public class an {

    /* renamed from: d  reason: collision with root package name */
    public View f36754d;

    /* renamed from: c  reason: collision with root package name */
    public Point f36753c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f36751a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f36752b = new Rect();

    public an(View view) {
        this.f36754d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f36754d.getGlobalVisibleRect(this.f36751a, this.f36753c);
        Point point = this.f36753c;
        if (point.x == 0 && point.y == 0 && this.f36751a.height() == this.f36754d.getHeight() && this.f36752b.height() != 0 && Math.abs(this.f36751a.top - this.f36752b.top) > this.f36754d.getHeight() / 2) {
            this.f36751a.set(this.f36752b);
        }
        this.f36752b.set(this.f36751a);
        return globalVisibleRect;
    }
}
