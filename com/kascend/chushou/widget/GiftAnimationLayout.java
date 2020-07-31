package com.kascend.chushou.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.kascend.chushou.a;
import tv.chushou.zues.widget.gift.view.GiftFrameLayout;
/* loaded from: classes6.dex */
public class GiftAnimationLayout extends LinearLayout {
    private int a;
    private int b;

    public GiftAnimationLayout(Context context) {
        this(context, null);
    }

    public GiftAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 2;
        this.b = 1;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, a.k.GiftAnimationLayout);
                this.a = typedArray.getInteger(a.k.GiftAnimationLayout_layoutCount, 2);
                this.b = typedArray.getInteger(a.k.GiftAnimationLayout_viewtype, 1);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
        a(context);
    }

    private void a(Context context) {
        setBackgroundColor(0);
        setOrientation(1);
        for (int i = 0; i < this.a; i++) {
            GiftFrameLayout giftFrameLayout = new GiftFrameLayout(context, null, this.b);
            giftFrameLayout.setVisibility(4);
            addView(giftFrameLayout);
        }
    }

    public void setLayoutDefaultBg(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < getChildCount()) {
                ((GiftFrameLayout) getChildAt(i3)).setLayoutDefaultBg(i);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
