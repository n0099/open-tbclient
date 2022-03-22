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
/* loaded from: classes7.dex */
public class KSRatingBar extends LinearLayout {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41454b;

    /* renamed from: c  reason: collision with root package name */
    public int f41455c;

    /* renamed from: d  reason: collision with root package name */
    public int f41456d;

    /* renamed from: e  reason: collision with root package name */
    public a f41457e;

    /* renamed from: f  reason: collision with root package name */
    public float f41458f;

    /* renamed from: g  reason: collision with root package name */
    public float f41459g;

    /* renamed from: h  reason: collision with root package name */
    public float f41460h;
    public Drawable i;
    public Drawable j;
    public Drawable k;
    public int l;
    public boolean m;

    /* loaded from: classes7.dex */
    public interface a {
        void a(float f2);
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 1;
        this.m = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c8a));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040309, R.attr.obfuscated_res_0x7f040314, R.attr.obfuscated_res_0x7f040327, R.attr.obfuscated_res_0x7f040328, R.attr.obfuscated_res_0x7f040329, R.attr.obfuscated_res_0x7f04032a, R.attr.obfuscated_res_0x7f04032b, R.attr.obfuscated_res_0x7f04032c, R.attr.obfuscated_res_0x7f04032d, R.attr.obfuscated_res_0x7f040349});
        this.k = obtainStyledAttributes.getDrawable(5);
        this.i = obtainStyledAttributes.getDrawable(3);
        this.j = obtainStyledAttributes.getDrawable(4);
        this.f41458f = obtainStyledAttributes.getDimension(8, 60.0f);
        this.f41459g = obtainStyledAttributes.getDimension(6, 120.0f);
        this.f41460h = obtainStyledAttributes.getDimension(7, 15.0f);
        this.f41455c = obtainStyledAttributes.getInteger(9, 5);
        this.f41456d = obtainStyledAttributes.getInteger(2, 5);
        this.a = obtainStyledAttributes.getBoolean(0, true);
        this.f41454b = obtainStyledAttributes.getBoolean(1, false);
        for (int i = 0; i < this.f41455c; i++) {
            ImageView a2 = a(context, this.m);
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    KSRatingBar kSRatingBar;
                    float indexOfChild;
                    a aVar;
                    float indexOfChild2;
                    if (KSRatingBar.this.a) {
                        if (!KSRatingBar.this.f41454b) {
                            KSRatingBar kSRatingBar2 = KSRatingBar.this;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.f41457e != null) {
                                KSRatingBar.this.f41457e.a(KSRatingBar.this.indexOfChild(view) + 1.0f);
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
                        if (KSRatingBar.this.f41457e != null) {
                            if (KSRatingBar.this.l % 2 == 0) {
                                aVar = KSRatingBar.this.f41457e;
                                indexOfChild2 = KSRatingBar.this.indexOfChild(view) + 1.0f;
                            } else {
                                aVar = KSRatingBar.this.f41457e;
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
        setStar(this.f41456d);
    }

    private ImageView a(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f41458f), Math.round(this.f41459g)));
        imageView.setPadding(0, 0, Math.round(this.f41460h), 0);
        imageView.setImageDrawable(z ? this.i : this.j);
        return imageView;
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.l;
        kSRatingBar.l = i + 1;
        return i;
    }

    public void setImagePadding(float f2) {
        this.f41460h = f2;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.f41457e = aVar;
    }

    public void setStar(float f2) {
        int i = (int) f2;
        float floatValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.f41455c;
        float f3 = i > i2 ? i2 : i;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        for (int i3 = 0; i3 < f3; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.j);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.k);
            int i4 = this.f41455c;
            while (true) {
                i4--;
                if (i4 < 1.0f + f3) {
                    return;
                }
                ((ImageView) getChildAt(i4)).setImageDrawable(this.i);
            }
        } else {
            int i5 = this.f41455c;
            while (true) {
                i5--;
                if (i5 < f3) {
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

    public void setStarImageHeight(float f2) {
        this.f41459g = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f41458f = f2;
    }

    public void setTotalStarCount(int i) {
        this.f41455c = i;
    }

    public void setmClickable(boolean z) {
        this.a = z;
    }
}
