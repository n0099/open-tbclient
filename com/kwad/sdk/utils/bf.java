package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes5.dex */
public final class bf {
    public View apj;
    public Point api = new Point();
    public Rect apg = new Rect();
    public Rect aph = new Rect();

    public bf(View view2) {
        this.apj = view2;
    }

    public final boolean AV() {
        boolean globalVisibleRect = this.apj.getGlobalVisibleRect(this.apg, this.api);
        Point point = this.api;
        if (point.x == 0 && point.y == 0 && this.apg.height() == this.apj.getHeight() && this.aph.height() != 0 && Math.abs(this.apg.top - this.aph.top) > this.apj.getHeight() / 2) {
            this.apg.set(this.aph);
        }
        this.aph.set(this.apg);
        return globalVisibleRect;
    }
}
