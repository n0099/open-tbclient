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
    public boolean aQX;
    public boolean aQY;
    public int aQZ;
    public int aRa;
    public a aRb;
    public float aRc;
    public float aRd;
    public float aRe;
    public Drawable aRf;
    public Drawable aRg;
    public Drawable aRh;
    public boolean aRi;
    public int y;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.aRi = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ebc));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.kwad.sdk.R.styleable.ksad_KSRatingBar);
        this.aRh = obtainStyledAttributes.getDrawable(5);
        this.aRf = obtainStyledAttributes.getDrawable(3);
        this.aRg = obtainStyledAttributes.getDrawable(4);
        this.aRc = obtainStyledAttributes.getDimension(8, 60.0f);
        this.aRd = obtainStyledAttributes.getDimension(6, 120.0f);
        this.aRe = obtainStyledAttributes.getDimension(7, 15.0f);
        this.aQZ = obtainStyledAttributes.getInteger(9, 5);
        this.aRa = obtainStyledAttributes.getInteger(2, 5);
        this.aQX = obtainStyledAttributes.getBoolean(0, true);
        this.aQY = obtainStyledAttributes.getBoolean(1, false);
        for (int i = 0; i < this.aQZ; i++) {
            ImageView w = w(context, this.aRi);
            w.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (KSRatingBar.this.aQX) {
                        if (KSRatingBar.this.aQY) {
                            if (KSRatingBar.this.y % 2 == 0) {
                                KSRatingBar kSRatingBar = KSRatingBar.this;
                                kSRatingBar.setStar(kSRatingBar.indexOfChild(view2) + 1.0f);
                            } else {
                                KSRatingBar kSRatingBar2 = KSRatingBar.this;
                                kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view2) + 0.5f);
                            }
                            if (KSRatingBar.this.aRb != null) {
                                if (KSRatingBar.this.y % 2 == 0) {
                                    a unused = KSRatingBar.this.aRb;
                                    KSRatingBar.this.indexOfChild(view2);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                }
                                a unused2 = KSRatingBar.this.aRb;
                                KSRatingBar.this.indexOfChild(view2);
                                KSRatingBar.e(KSRatingBar.this);
                                return;
                            }
                            return;
                        }
                        KSRatingBar kSRatingBar3 = KSRatingBar.this;
                        kSRatingBar3.setStar(kSRatingBar3.indexOfChild(view2) + 1.0f);
                        if (KSRatingBar.this.aRb != null) {
                            a unused3 = KSRatingBar.this.aRb;
                            KSRatingBar.this.indexOfChild(view2);
                        }
                    }
                }
            });
            addView(w);
        }
        setStar(this.aRa);
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.y;
        kSRatingBar.y = i + 1;
        return i;
    }

    public void setImagePadding(float f) {
        this.aRe = f;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aRb = aVar;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aRf = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aRg = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aRh = drawable;
    }

    public void setStarImageHeight(float f) {
        this.aRd = f;
    }

    public void setStarImageWidth(float f) {
        this.aRc = f;
    }

    public void setTotalStarCount(int i) {
        this.aQZ = i;
    }

    public void setmClickable(boolean z) {
        this.aQX = z;
    }

    private ImageView w(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aRc), Math.round(this.aRd)));
        imageView.setPadding(0, 0, Math.round(this.aRe), 0);
        if (z) {
            imageView.setImageDrawable(this.aRf);
        } else {
            imageView.setImageDrawable(this.aRg);
        }
        return imageView;
    }

    public void setStar(float f) {
        int i = (int) f;
        float floatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.aQZ;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.aRg);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.aRh);
            int i4 = this.aQZ;
            while (true) {
                i4--;
                if (i4 >= 1.0f + f2) {
                    ((ImageView) getChildAt(i4)).setImageDrawable(this.aRf);
                } else {
                    return;
                }
            }
        } else {
            int i5 = this.aQZ;
            while (true) {
                i5--;
                if (i5 >= f2) {
                    ((ImageView) getChildAt(i5)).setImageDrawable(this.aRf);
                } else {
                    return;
                }
            }
        }
    }
}
