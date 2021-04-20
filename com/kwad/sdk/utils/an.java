package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes6.dex */
public class an {

    /* renamed from: d  reason: collision with root package name */
    public View f37043d;

    /* renamed from: c  reason: collision with root package name */
    public Point f37042c = new Point();

    /* renamed from: a  reason: collision with root package name */
    public Rect f37040a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public Rect f37041b = new Rect();

    public an(View view) {
        this.f37043d = view;
    }

    public boolean a() {
        boolean globalVisibleRect = this.f37043d.getGlobalVisibleRect(this.f37040a, this.f37042c);
        Point point = this.f37042c;
        if (point.x == 0 && point.y == 0 && this.f37040a.height() == this.f37043d.getHeight() && this.f37041b.height() != 0 && Math.abs(this.f37040a.top - this.f37041b.top) > this.f37043d.getHeight() / 2) {
            this.f37040a.set(this.f37041b);
        }
        this.f37041b.set(this.f37040a);
        return globalVisibleRect;
    }
}
