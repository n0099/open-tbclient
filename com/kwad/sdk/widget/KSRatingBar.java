package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import java.math.BigDecimal;
/* loaded from: classes5.dex */
public class KSRatingBar extends LinearLayout {
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public a e;
    public float f;
    public float g;
    public float h;
    public Drawable i;
    public Drawable j;
    public Drawable k;
    public int l;
    public boolean m;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 1;
        this.m = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c13));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040349, R.attr.obfuscated_res_0x7f040367, R.attr.obfuscated_res_0x7f04037e, R.attr.obfuscated_res_0x7f04037f, R.attr.obfuscated_res_0x7f040380, R.attr.obfuscated_res_0x7f040381, R.attr.obfuscated_res_0x7f040382, R.attr.obfuscated_res_0x7f040383, R.attr.obfuscated_res_0x7f040384, R.attr.obfuscated_res_0x7f04039e});
        this.k = obtainStyledAttributes.getDrawable(5);
        this.i = obtainStyledAttributes.getDrawable(3);
        this.j = obtainStyledAttributes.getDrawable(4);
        this.f = obtainStyledAttributes.getDimension(8, 60.0f);
        this.g = obtainStyledAttributes.getDimension(6, 120.0f);
        this.h = obtainStyledAttributes.getDimension(7, 15.0f);
        this.c = obtainStyledAttributes.getInteger(9, 5);
        this.d = obtainStyledAttributes.getInteger(2, 5);
        this.a = obtainStyledAttributes.getBoolean(0, true);
        this.b = obtainStyledAttributes.getBoolean(1, false);
        for (int i = 0; i < this.c; i++) {
            ImageView a2 = a(context, this.m);
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (KSRatingBar.this.a) {
                        if (!KSRatingBar.this.b) {
                            KSRatingBar kSRatingBar = KSRatingBar.this;
                            kSRatingBar.setStar(kSRatingBar.indexOfChild(view2) + 1.0f);
                            if (KSRatingBar.this.e != null) {
                                a unused = KSRatingBar.this.e;
                                KSRatingBar.this.indexOfChild(view2);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.l % 2 == 0) {
                            KSRatingBar kSRatingBar2 = KSRatingBar.this;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view2) + 1.0f);
                        } else {
                            KSRatingBar kSRatingBar3 = KSRatingBar.this;
                            kSRatingBar3.setStar(kSRatingBar3.indexOfChild(view2) + 0.5f);
                        }
                        if (KSRatingBar.this.e != null) {
                            int i2 = KSRatingBar.this.l % 2;
                            a unused2 = KSRatingBar.this.e;
                            KSRatingBar.this.indexOfChild(view2);
                            KSRatingBar.e(KSRatingBar.this);
                        }
                    }
                }
            });
            addView(a2);
        }
        setStar(this.d);
    }

    private ImageView a(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f), Math.round(this.g)));
        imageView.setPadding(0, 0, Math.round(this.h), 0);
        imageView.setImageDrawable(z ? this.i : this.j);
        return imageView;
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.l;
        kSRatingBar.l = i + 1;
        return i;
    }

    public void setImagePadding(float f) {
        this.h = f;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.e = aVar;
    }

    public void setStar(float f) {
        int i = (int) f;
        float floatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.c;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.j);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.k);
            int i4 = this.c;
            while (true) {
                i4--;
                if (i4 < 1.0f + f2) {
                    return;
                }
                ((ImageView) getChildAt(i4)).setImageDrawable(this.i);
            }
        } else {
            int i5 = this.c;
            while (true) {
                i5--;
                if (i5 < f2) {
                    return;
                }
                ((ImageView) getChildAt(i5)).setImageDrawable(this.i);
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.i = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.j = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.k = drawable;
    }

    public void setStarImageHeight(float f) {
        this.g = f;
    }

    public void setStarImageWidth(float f) {
        this.f = f;
    }

    public void setTotalStarCount(int i) {
        this.c = i;
    }

    public void setmClickable(boolean z) {
        this.a = z;
    }
}
