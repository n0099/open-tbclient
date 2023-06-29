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
/* loaded from: classes10.dex */
public class KSRatingBar extends LinearLayout {
    public boolean aqM;
    public int aqN;
    public int aqO;
    public a aqP;
    public float aqQ;
    public float aqR;
    public float aqS;
    public Drawable aqT;
    public Drawable aqU;
    public Drawable aqV;
    public boolean aqW;
    public boolean xE;
    public int y;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.aqW = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e65));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.kwad.sdk.R.styleable.ksad_KSRatingBar);
        this.aqV = obtainStyledAttributes.getDrawable(5);
        this.aqT = obtainStyledAttributes.getDrawable(3);
        this.aqU = obtainStyledAttributes.getDrawable(4);
        this.aqQ = obtainStyledAttributes.getDimension(8, 60.0f);
        this.aqR = obtainStyledAttributes.getDimension(6, 120.0f);
        this.aqS = obtainStyledAttributes.getDimension(7, 15.0f);
        this.aqN = obtainStyledAttributes.getInteger(9, 5);
        this.aqO = obtainStyledAttributes.getInteger(2, 5);
        this.xE = obtainStyledAttributes.getBoolean(0, true);
        this.aqM = obtainStyledAttributes.getBoolean(1, false);
        for (int i = 0; i < this.aqN; i++) {
            ImageView v = v(context, this.aqW);
            v.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (KSRatingBar.this.xE) {
                        if (!KSRatingBar.this.aqM) {
                            KSRatingBar kSRatingBar = KSRatingBar.this;
                            kSRatingBar.setStar(kSRatingBar.indexOfChild(view2) + 1.0f);
                            if (KSRatingBar.this.aqP != null) {
                                a unused = KSRatingBar.this.aqP;
                                KSRatingBar.this.indexOfChild(view2);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.y % 2 == 0) {
                            KSRatingBar kSRatingBar2 = KSRatingBar.this;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view2) + 1.0f);
                        } else {
                            KSRatingBar kSRatingBar3 = KSRatingBar.this;
                            kSRatingBar3.setStar(kSRatingBar3.indexOfChild(view2) + 0.5f);
                        }
                        if (KSRatingBar.this.aqP != null) {
                            int i2 = KSRatingBar.this.y % 2;
                            a unused2 = KSRatingBar.this.aqP;
                            KSRatingBar.this.indexOfChild(view2);
                            KSRatingBar.e(KSRatingBar.this);
                        }
                    }
                }
            });
            addView(v);
        }
        setStar(this.aqO);
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.y;
        kSRatingBar.y = i + 1;
        return i;
    }

    private ImageView v(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aqQ), Math.round(this.aqR)));
        imageView.setPadding(0, 0, Math.round(this.aqS), 0);
        imageView.setImageDrawable(z ? this.aqT : this.aqU);
        return imageView;
    }

    public void setImagePadding(float f) {
        this.aqS = f;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aqP = aVar;
    }

    public void setStar(float f) {
        int i = (int) f;
        float floatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.aqN;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.aqU);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.aqV);
            int i4 = this.aqN;
            while (true) {
                i4--;
                if (i4 < 1.0f + f2) {
                    return;
                }
                ((ImageView) getChildAt(i4)).setImageDrawable(this.aqT);
            }
        } else {
            int i5 = this.aqN;
            while (true) {
                i5--;
                if (i5 < f2) {
                    return;
                }
                ((ImageView) getChildAt(i5)).setImageDrawable(this.aqT);
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aqT = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aqU = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aqV = drawable;
    }

    public void setStarImageHeight(float f) {
        this.aqR = f;
    }

    public void setStarImageWidth(float f) {
        this.aqQ = f;
    }

    public void setTotalStarCount(int i) {
        this.aqN = i;
    }

    public void setmClickable(boolean z) {
        this.xE = z;
    }
}
