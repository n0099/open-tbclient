package com.kwad.components.ad.interstitial.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class TransViewPager extends com.kwad.sdk.widget.d {
    public float jd;
    @SlideType
    public int je;
    public Map<Integer, e> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.je = 0;
    }

    private void a(View view2, View view3, float f) {
        if (this.je == 0 && f != 0.0f) {
            float f2 = this.jd;
            if (f2 != 0.0f) {
                if (f > f2) {
                    this.je = 1;
                } else {
                    this.je = 2;
                }
            }
        }
        if (this.je == 1 && view3 != null) {
            if (f > 0.5d || f <= 0.0f) {
                view3.setTranslationX((1.0f - f) * 240.0f);
            } else {
                view3.setTranslationX(240.0f * f);
            }
        }
        if (this.je == 2 && view2 != null) {
            if (f > 0.5d || f < 0.0f) {
                view2.setTranslationX((1.0f - f) * (-240.0f));
            } else {
                view2.setTranslationX((-240.0f) * f);
            }
        }
        this.jd = f;
        if (f == 0.0f) {
            this.je = 0;
        }
    }

    public final e F(int i) {
        return this.map.get(Integer.valueOf(i));
    }

    public final void a(int i, e eVar) {
        this.map.put(Integer.valueOf(i), eVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i, float f, int i2) {
        a(F(i), F(i + 1), f);
        super.onPageScrolled(i, f, i2);
    }
}
