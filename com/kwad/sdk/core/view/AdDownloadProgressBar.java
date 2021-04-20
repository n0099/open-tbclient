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
/* loaded from: classes6.dex */
public class AdDownloadProgressBar extends d {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f34516a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34517b;

    /* renamed from: c  reason: collision with root package name */
    public View f34518c;

    /* renamed from: d  reason: collision with root package name */
    public a f34519d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.view.a f34520e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f34521f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34522g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f34523h;
    public Drawable i;
    public int j;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public float f34525b;

        /* renamed from: c  reason: collision with root package name */
        public String f34526c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34527d;

        public a() {
            this.f34525b = -1.0f;
            this.f34527d = false;
        }

        public void a() {
            if (!this.f34527d || this.f34525b < 0.0f) {
                AdDownloadProgressBar.this.f34517b.setText(this.f34526c);
                return;
            }
            AdDownloadProgressBar.this.f34517b.setText(this.f34526c);
            if (AdDownloadProgressBar.this.f34520e != null) {
                AdDownloadProgressBar.this.f34516a.setImageDrawable(AdDownloadProgressBar.this.f34520e);
                AdDownloadProgressBar.this.f34520e.a(this.f34525b);
            }
        }
    }

    public AdDownloadProgressBar(@NonNull Context context) {
        this(context, null);
    }

    public AdDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34519d = new a();
        a();
    }

    private void a() {
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
        this.f34517b = (TextView) findViewById(R.id.ksad_status_tv);
        this.f34518c = findViewById(R.id.ksad_click_mask);
        this.f34516a = (ImageView) findViewById(R.id.ksad_progress_bg);
        setRadius(ao.a(getContext(), 2.0f));
        this.f34518c.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
    }

    private void c() {
        this.f34517b.setCompoundDrawablePadding(0);
        this.f34517b.setCompoundDrawables(null, null, null, null);
    }

    private void d() {
        setDrawableBounds(this.f34521f);
        setDrawableBounds(this.f34522g);
        setDrawableBounds(this.f34523h);
        setDrawableBounds(this.i);
        this.f34517b.setCompoundDrawablePadding(this.j);
        this.f34517b.setCompoundDrawables(this.f34521f, this.f34522g, this.f34523h, this.i);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, int i) {
        this.f34521f = drawable;
        this.f34522g = drawable2;
        this.f34523h = drawable3;
        this.i = drawable4;
        this.j = i;
        d();
    }

    public void a(String str, float f2) {
        this.f34519d.f34527d = true;
        this.f34519d.f34526c = str;
        this.f34519d.f34525b = f2;
        this.f34519d.a();
        c();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        View view = this.f34518c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setProgressDrawable(@ColorInt int i) {
        this.f34516a.setBackgroundColor(i);
        super.setBackground(null);
        super.setForeground(null);
    }

    public void setText(String str) {
        this.f34519d.f34527d = false;
        this.f34519d.f34526c = str;
        this.f34519d.a();
        d();
    }

    public void setTextColor(@ColorInt int i) {
        this.f34517b.setTextColor(i);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.f34517b.setIncludeFontPadding(z);
    }

    public void setTextSize(float f2) {
        this.f34517b.setTextSize(f2);
    }

    public void setTextTypeface(Typeface typeface) {
        this.f34517b.getPaint().setTypeface(typeface);
    }
}
