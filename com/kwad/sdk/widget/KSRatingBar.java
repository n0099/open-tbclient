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
/* loaded from: classes8.dex */
public class KSRatingBar extends LinearLayout {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56573b;

    /* renamed from: c  reason: collision with root package name */
    public int f56574c;

    /* renamed from: d  reason: collision with root package name */
    public int f56575d;

    /* renamed from: e  reason: collision with root package name */
    public a f56576e;

    /* renamed from: f  reason: collision with root package name */
    public float f56577f;

    /* renamed from: g  reason: collision with root package name */
    public float f56578g;

    /* renamed from: h  reason: collision with root package name */
    public float f56579h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f56580i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f56581j;
    public Drawable k;
    public int l;
    public boolean m;

    /* loaded from: classes8.dex */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.ksad_clickable, R.attr.ksad_halfstart, R.attr.ksad_starCount, R.attr.ksad_starEmpty, R.attr.ksad_starFill, R.attr.ksad_starHalf, R.attr.ksad_starImageHeight, R.attr.ksad_starImagePadding, R.attr.ksad_starImageWidth, R.attr.ksad_totalStarCount});
        this.k = obtainStyledAttributes.getDrawable(5);
        this.f56580i = obtainStyledAttributes.getDrawable(3);
        this.f56581j = obtainStyledAttributes.getDrawable(4);
        this.f56577f = obtainStyledAttributes.getDimension(8, 60.0f);
        this.f56578g = obtainStyledAttributes.getDimension(6, 120.0f);
        this.f56579h = obtainStyledAttributes.getDimension(7, 15.0f);
        this.f56574c = obtainStyledAttributes.getInteger(9, 5);
        this.f56575d = obtainStyledAttributes.getInteger(2, 5);
        this.a = obtainStyledAttributes.getBoolean(0, true);
        this.f56573b = obtainStyledAttributes.getBoolean(1, false);
        for (int i2 = 0; i2 < this.f56574c; i2++) {
            ImageView a2 = a(context, this.m);
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    KSRatingBar kSRatingBar;
                    float indexOfChild;
                    a aVar;
                    float indexOfChild2;
                    if (KSRatingBar.this.a) {
                        if (!KSRatingBar.this.f56573b) {
                            KSRatingBar kSRatingBar2 = KSRatingBar.this;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.f56576e != null) {
                                KSRatingBar.this.f56576e.a(KSRatingBar.this.indexOfChild(view) + 1.0f);
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
                        if (KSRatingBar.this.f56576e != null) {
                            if (KSRatingBar.this.l % 2 == 0) {
                                aVar = KSRatingBar.this.f56576e;
                                indexOfChild2 = KSRatingBar.this.indexOfChild(view) + 1.0f;
                            } else {
                                aVar = KSRatingBar.this.f56576e;
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
        setStar(this.f56575d);
    }

    private ImageView a(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f56577f), Math.round(this.f56578g)));
        imageView.setPadding(0, 0, Math.round(this.f56579h), 0);
        imageView.setImageDrawable(z ? this.f56580i : this.f56581j);
        return imageView;
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i2 = kSRatingBar.l;
        kSRatingBar.l = i2 + 1;
        return i2;
    }

    public void setImagePadding(float f2) {
        this.f56579h = f2;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.f56576e = aVar;
    }

    public void setStar(float f2) {
        int i2 = (int) f2;
        float floatValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Integer.toString(i2))).floatValue();
        int i3 = this.f56574c;
        float f3 = i2 > i3 ? i3 : i2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        for (int i4 = 0; i4 < f3; i4++) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.f56581j);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.k);
            int i5 = this.f56574c;
            while (true) {
                i5--;
                if (i5 < 1.0f + f3) {
                    return;
                }
                ((ImageView) getChildAt(i5)).setImageDrawable(this.f56580i);
            }
        } else {
            int i6 = this.f56574c;
            while (true) {
                i6--;
                if (i6 < f3) {
                    return;
                }
                ((ImageView) getChildAt(i6)).setImageDrawable(this.f56580i);
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f56580i = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f56581j = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.k = drawable;
    }

    public void setStarImageHeight(float f2) {
        this.f56578g = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f56577f = f2;
    }

    public void setTotalStarCount(int i2) {
        this.f56574c = i2;
    }

    public void setmClickable(boolean z) {
        this.a = z;
    }
}
