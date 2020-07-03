package com.kascend.chushou.player.ui.pk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MutiTextHorizontalMarqueeView extends HorizontalMarqueeView {
    private int u;
    private int v;
    private int w;

    public MutiTextHorizontalMarqueeView(Context context) {
        this(context, null);
    }

    public MutiTextHorizontalMarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MutiTextHorizontalMarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(String str, int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7, int i8) {
        b();
        TextView textView = new TextView(this.a);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setTextSize(2, i2);
        if (z) {
            textView.setShadowLayer(i5, i6, i7, i8);
        }
        n(textView, i3, i4);
        textView.measure(0, 0);
        this.u = textView.getMeasuredWidth();
        this.v = i3;
        this.w = i4;
        int ceil = (int) Math.ceil((this.b + this.u) / ((this.u + this.v) + this.w));
        for (int i9 = 0; i9 < ceil; i9++) {
            TextView textView2 = new TextView(this.a);
            textView2.setText(str);
            textView2.setTextColor(i);
            textView2.setTextSize(2, i2);
            if (z) {
                textView2.setShadowLayer(i5, i6, i7, i8);
            }
            n(textView2, i3, i4);
        }
    }

    @Override // com.kascend.chushou.player.ui.pk.HorizontalMarqueeView
    protected void c() {
        if (this.f == 1) {
            this.g = this.d;
            this.h = 0;
            this.i = ((this.d - this.w) - this.u) - this.b;
            this.j = 0;
            this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
            return;
        }
        this.g = -this.b;
        this.h = 0;
        this.i = this.v + this.u;
        this.j = 0;
        this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
    }

    @Override // com.kascend.chushou.player.ui.pk.HorizontalMarqueeView
    protected void e() {
        if (this.n) {
            this.g = this.o;
            this.h = this.p;
            this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
        } else if (this.f == 1) {
            this.g = (this.d + this.v) - this.b;
            this.h = 0;
            this.i = ((this.d - this.w) - this.u) - this.b;
            this.j = 0;
            this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
        } else {
            this.g = -this.w;
            this.h = 0;
            this.i = this.v + this.u;
            this.j = 0;
            this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
        }
    }
}
