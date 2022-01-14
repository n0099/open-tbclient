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
    public boolean f58011b;

    /* renamed from: c  reason: collision with root package name */
    public int f58012c;

    /* renamed from: d  reason: collision with root package name */
    public int f58013d;

    /* renamed from: e  reason: collision with root package name */
    public a f58014e;

    /* renamed from: f  reason: collision with root package name */
    public float f58015f;

    /* renamed from: g  reason: collision with root package name */
    public float f58016g;

    /* renamed from: h  reason: collision with root package name */
    public float f58017h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f58018i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f58019j;
    public Drawable k;
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
        this.k = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.f58018i = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.f58019j = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.f58015f = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.f58016g = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.f58017h = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.f58012c = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.f58013d = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.a = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.f58011b = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i2 = 0; i2 < this.f58012c; i2++) {
            ImageView a2 = a(context, this.m);
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    KSRatingBar kSRatingBar;
                    float indexOfChild;
                    a aVar;
                    float indexOfChild2;
                    if (KSRatingBar.this.a) {
                        if (!KSRatingBar.this.f58011b) {
                            KSRatingBar kSRatingBar2 = KSRatingBar.this;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.f58014e != null) {
                                KSRatingBar.this.f58014e.a(KSRatingBar.this.indexOfChild(view) + 1.0f);
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
                        if (KSRatingBar.this.f58014e != null) {
                            if (KSRatingBar.this.l % 2 == 0) {
                                aVar = KSRatingBar.this.f58014e;
                                indexOfChild2 = KSRatingBar.this.indexOfChild(view) + 1.0f;
                            } else {
                                aVar = KSRatingBar.this.f58014e;
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
        setStar(this.f58013d);
    }

    private ImageView a(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f58015f), Math.round(this.f58016g)));
        imageView.setPadding(0, 0, Math.round(this.f58017h), 0);
        imageView.setImageDrawable(z ? this.f58018i : this.f58019j);
        return imageView;
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i2 = kSRatingBar.l;
        kSRatingBar.l = i2 + 1;
        return i2;
    }

    public void setImagePadding(float f2) {
        this.f58017h = f2;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.f58014e = aVar;
    }

    public void setStar(float f2) {
        int i2 = (int) f2;
        float floatValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Integer.toString(i2))).floatValue();
        int i3 = this.f58012c;
        float f3 = i2 > i3 ? i3 : i2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        for (int i4 = 0; i4 < f3; i4++) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.f58019j);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.k);
            int i5 = this.f58012c;
            while (true) {
                i5--;
                if (i5 < 1.0f + f3) {
                    return;
                }
                ((ImageView) getChildAt(i5)).setImageDrawable(this.f58018i);
            }
        } else {
            int i6 = this.f58012c;
            while (true) {
                i6--;
                if (i6 < f3) {
                    return;
                }
                ((ImageView) getChildAt(i6)).setImageDrawable(this.f58018i);
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f58018i = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f58019j = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.k = drawable;
    }

    public void setStarImageHeight(float f2) {
        this.f58016g = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f58015f = f2;
    }

    public void setTotalStarCount(int i2) {
        this.f58012c = i2;
    }

    public void setmClickable(boolean z) {
        this.a = z;
    }
}
