package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;
/* loaded from: classes3.dex */
public class KSRatingBar extends LinearLayout {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60300b;

    /* renamed from: c  reason: collision with root package name */
    public int f60301c;

    /* renamed from: d  reason: collision with root package name */
    public int f60302d;

    /* renamed from: e  reason: collision with root package name */
    public a f60303e;

    /* renamed from: f  reason: collision with root package name */
    public float f60304f;

    /* renamed from: g  reason: collision with root package name */
    public float f60305g;

    /* renamed from: h  reason: collision with root package name */
    public float f60306h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f60307i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f60308j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f60309k;
    public int l;
    public boolean m;

    /* loaded from: classes3.dex */
    public interface a {
        void a(float f2);
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 1;
        this.m = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.f60309k = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.f60307i = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.f60308j = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.f60304f = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.f60305g = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.f60306h = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.f60301c = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.f60302d = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.a = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.f60300b = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i2 = 0; i2 < this.f60301c; i2++) {
            ImageView a2 = a(context, this.m);
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    KSRatingBar kSRatingBar;
                    float indexOfChild;
                    a aVar;
                    float indexOfChild2;
                    if (KSRatingBar.this.a) {
                        if (!KSRatingBar.this.f60300b) {
                            KSRatingBar kSRatingBar2 = KSRatingBar.this;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.f60303e != null) {
                                KSRatingBar.this.f60303e.a(KSRatingBar.this.indexOfChild(view) + 1.0f);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.l % 2 == 0) {
                            kSRatingBar = KSRatingBar.this;
                            indexOfChild = kSRatingBar.indexOfChild(view) + 1.0f;
                        } else {
                            kSRatingBar = KSRatingBar.this;
                            indexOfChild = kSRatingBar.indexOfChild(view) + 0.5f;
                        }
                        kSRatingBar.setStar(indexOfChild);
                        if (KSRatingBar.this.f60303e != null) {
                            if (KSRatingBar.this.l % 2 == 0) {
                                aVar = KSRatingBar.this.f60303e;
                                indexOfChild2 = KSRatingBar.this.indexOfChild(view) + 1.0f;
                            } else {
                                aVar = KSRatingBar.this.f60303e;
                                indexOfChild2 = KSRatingBar.this.indexOfChild(view) + 0.5f;
                            }
                            aVar.a(indexOfChild2);
                            KSRatingBar.e(KSRatingBar.this);
                        }
                    }
                }
            });
            addView(a2);
        }
        setStar(this.f60302d);
    }

    private ImageView a(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f60304f), Math.round(this.f60305g)));
        imageView.setPadding(0, 0, Math.round(this.f60306h), 0);
        imageView.setImageDrawable(z ? this.f60307i : this.f60308j);
        return imageView;
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i2 = kSRatingBar.l;
        kSRatingBar.l = i2 + 1;
        return i2;
    }

    public void setImagePadding(float f2) {
        this.f60306h = f2;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.f60303e = aVar;
    }

    public void setStar(float f2) {
        int i2 = (int) f2;
        float floatValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Integer.toString(i2))).floatValue();
        int i3 = this.f60301c;
        float f3 = i2 > i3 ? i3 : i2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        for (int i4 = 0; i4 < f3; i4++) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.f60308j);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.f60309k);
            int i5 = this.f60301c;
            while (true) {
                i5--;
                if (i5 < 1.0f + f3) {
                    return;
                }
                ((ImageView) getChildAt(i5)).setImageDrawable(this.f60307i);
            }
        } else {
            int i6 = this.f60301c;
            while (true) {
                i6--;
                if (i6 < f3) {
                    return;
                }
                ((ImageView) getChildAt(i6)).setImageDrawable(this.f60307i);
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f60307i = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f60308j = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f60309k = drawable;
    }

    public void setStarImageHeight(float f2) {
        this.f60305g = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f60304f = f2;
    }

    public void setTotalStarCount(int i2) {
        this.f60301c = i2;
    }

    public void setmClickable(boolean z) {
        this.a = z;
    }
}
