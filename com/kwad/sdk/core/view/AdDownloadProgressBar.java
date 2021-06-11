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
    public ImageView f34867a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34868b;

    /* renamed from: c  reason: collision with root package name */
    public View f34869c;

    /* renamed from: d  reason: collision with root package name */
    public a f34870d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.view.a f34871e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f34872f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34873g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f34874h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f34875i;
    public int j;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public float f34877b;

        /* renamed from: c  reason: collision with root package name */
        public String f34878c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34879d;

        public a() {
            this.f34877b = -1.0f;
            this.f34879d = false;
        }

        public void a() {
            if (!this.f34879d || this.f34877b < 0.0f) {
                AdDownloadProgressBar.this.f34868b.setText(this.f34878c);
                return;
            }
            AdDownloadProgressBar.this.f34868b.setText(this.f34878c);
            if (AdDownloadProgressBar.this.f34871e != null) {
                AdDownloadProgressBar.this.f34867a.setImageDrawable(AdDownloadProgressBar.this.f34871e);
                AdDownloadProgressBar.this.f34871e.a(this.f34877b);
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
        this.f34870d = new a();
        a();
    }

    private void a() {
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
        this.f34868b = (TextView) findViewById(R.id.ksad_status_tv);
        this.f34869c = findViewById(R.id.ksad_click_mask);
        this.f34867a = (ImageView) findViewById(R.id.ksad_progress_bg);
        setRadius(ao.a(getContext(), 2.0f));
        this.f34869c.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
    }

    private void c() {
        this.f34868b.setCompoundDrawablePadding(0);
        this.f34868b.setCompoundDrawables(null, null, null, null);
    }

    private void d() {
        setDrawableBounds(this.f34872f);
        setDrawableBounds(this.f34873g);
        setDrawableBounds(this.f34874h);
        setDrawableBounds(this.f34875i);
        this.f34868b.setCompoundDrawablePadding(this.j);
        this.f34868b.setCompoundDrawables(this.f34872f, this.f34873g, this.f34874h, this.f34875i);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, int i2) {
        this.f34872f = drawable;
        this.f34873g = drawable2;
        this.f34874h = drawable3;
        this.f34875i = drawable4;
        this.j = i2;
        d();
    }

    public void a(String str, float f2) {
        this.f34870d.f34879d = true;
        this.f34870d.f34878c = str;
        this.f34870d.f34877b = f2;
        this.f34870d.a();
        c();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        View view = this.f34869c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setProgressDrawable(@ColorInt int i2) {
        this.f34867a.setBackgroundColor(i2);
        super.setBackground(null);
        super.setForeground(null);
    }

    public void setText(String str) {
        this.f34870d.f34879d = false;
        this.f34870d.f34878c = str;
        this.f34870d.a();
        d();
    }

    public void setTextColor(@ColorInt int i2) {
        this.f34868b.setTextColor(i2);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.f34868b.setIncludeFontPadding(z);
    }

    public void setTextSize(float f2) {
        this.f34868b.setTextSize(f2);
    }

    public void setTextTypeface(Typeface typeface) {
        this.f34868b.getPaint().setTypeface(typeface);
    }
}
