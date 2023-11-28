package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes10.dex */
public final class bp {
    public View aPw;
    public Point aPv = new Point();
    public Rect aPt = new Rect();
    public Rect aPu = new Rect();

    public bp(View view2) {
        this.aPw = view2;
    }

    public final boolean LP() {
        boolean globalVisibleRect = this.aPw.getGlobalVisibleRect(this.aPt, this.aPv);
        Point point = this.aPv;
        if (point.x == 0 && point.y == 0 && this.aPt.height() == this.aPw.getHeight() && this.aPu.height() != 0 && Math.abs(this.aPt.top - this.aPu.top) > this.aPw.getHeight() / 2) {
            this.aPt.set(this.aPu);
        }
        this.aPu.set(this.aPt);
        return globalVisibleRect;
    }
}
