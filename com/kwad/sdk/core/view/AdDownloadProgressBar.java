package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class AdDownloadProgressBar extends d {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f34965a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34966b;

    /* renamed from: c  reason: collision with root package name */
    public View f34967c;

    /* renamed from: d  reason: collision with root package name */
    public a f34968d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.view.a f34969e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f34970f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34971g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f34972h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f34973i;
    public int j;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public float f34975b;

        /* renamed from: c  reason: collision with root package name */
        public String f34976c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34977d;

        public a() {
            this.f34975b = -1.0f;
            this.f34977d = false;
        }

        public void a() {
            if (!this.f34977d || this.f34975b < 0.0f) {
                AdDownloadProgressBar.this.f34966b.setText(this.f34976c);
                return;
            }
            AdDownloadProgressBar.this.f34966b.setText(this.f34976c);
            if (AdDownloadProgressBar.this.f34969e != null) {
                AdDownloadProgressBar.this.f34965a.setImageDrawable(AdDownloadProgressBar.this.f34969e);
                AdDownloadProgressBar.this.f34969e.a(this.f34975b);
            }
        }
    }

    public AdDownloadProgressBar(@NonNull Context context) {
        this(context, null);
    }

    public AdDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f34968d = new a();
        a();
    }

    private void a() {
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
        this.f34966b = (TextView) findViewById(R.id.ksad_status_tv);
        this.f34967c = findViewById(R.id.ksad_click_mask);
        this.f34965a = (ImageView) findViewById(R.id.ksad_progress_bg);
        setRadius(ao.a(getContext(), 2.0f));
        this.f34967c.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
    }

    private void c() {
        this.f34966b.setCompoundDrawablePadding(0);
        this.f34966b.setCompoundDrawables(null, null, null, null);
    }

    private void d() {
        setDrawableBounds(this.f34970f);
        setDrawableBounds(this.f34971g);
        setDrawableBounds(this.f34972h);
        setDrawableBounds(this.f34973i);
        this.f34966b.setCompoundDrawablePadding(this.j);
        this.f34966b.setCompoundDrawables(this.f34970f, this.f34971g, this.f34972h, this.f34973i);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, int i2) {
        this.f34970f = drawable;
        this.f34971g = drawable2;
        this.f34972h = drawable3;
        this.f34973i = drawable4;
        this.j = i2;
        d();
    }

    public void a(String str, float f2) {
        this.f34968d.f34977d = true;
        this.f34968d.f34976c = str;
        this.f34968d.f34975b = f2;
        this.f34968d.a();
        c();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        View view = this.f34967c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setProgressDrawable(@ColorInt int i2) {
        this.f34965a.setBackgroundColor(i2);
        super.setBackground(null);
        super.setForeground(null);
    }

    public void setText(String str) {
        this.f34968d.f34977d = false;
        this.f34968d.f34976c = str;
        this.f34968d.a();
        d();
    }

    public void setTextColor(@ColorInt int i2) {
        this.f34966b.setTextColor(i2);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.f34966b.setIncludeFontPadding(z);
    }

    public void setTextSize(float f2) {
        this.f34966b.setTextSize(f2);
    }

    public void setTextTypeface(Typeface typeface) {
        this.f34966b.getPaint().setTypeface(typeface);
    }
}
