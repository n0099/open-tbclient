package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes6.dex */
public class an {

    /* renamed from: d  reason: collision with root package name */
    public View f36753d;

    /* renamed from: c  reason: collision with root package name */
    public Point f36752c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f36750a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f36751b = new Rect();

    public an(View view) {
        this.f36753d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f36753d.getGlobalVisibleRect(this.f36750a, this.f36752c);
        Point point = this.f36752c;
        if (point.x == 0 && point.y == 0 && this.f36750a.height() == this.f36753d.getHeight() && this.f36751b.height() != 0 && Math.abs(this.f36750a.top - this.f36751b.top) > this.f36753d.getHeight() / 2) {
            this.f36750a.set(this.f36751b);
        }
        this.f36751b.set(this.f36750a);
        return globalVisibleRect;
    }
}
