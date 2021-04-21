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
    public ImageView f34611a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34612b;

    /* renamed from: c  reason: collision with root package name */
    public View f34613c;

    /* renamed from: d  reason: collision with root package name */
    public a f34614d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.view.a f34615e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f34616f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34617g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f34618h;
    public Drawable i;
    public int j;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public float f34620b;

        /* renamed from: c  reason: collision with root package name */
        public String f34621c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34622d;

        public a() {
            this.f34620b = -1.0f;
            this.f34622d = false;
        }

        public void a() {
            if (!this.f34622d || this.f34620b < 0.0f) {
                AdDownloadProgressBar.this.f34612b.setText(this.f34621c);
                return;
            }
            AdDownloadProgressBar.this.f34612b.setText(this.f34621c);
            if (AdDownloadProgressBar.this.f34615e != null) {
                AdDownloadProgressBar.this.f34611a.setImageDrawable(AdDownloadProgressBar.this.f34615e);
                AdDownloadProgressBar.this.f34615e.a(this.f34620b);
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
        this.f34614d = new a();
        a();
    }

    private void a() {
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
        this.f34612b = (TextView) findViewById(R.id.ksad_status_tv);
        this.f34613c = findViewById(R.id.ksad_click_mask);
        this.f34611a = (ImageView) findViewById(R.id.ksad_progress_bg);
        setRadius(ao.a(getContext(), 2.0f));
        this.f34613c.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
    }

    private void c() {
        this.f34612b.setCompoundDrawablePadding(0);
        this.f34612b.setCompoundDrawables(null, null, null, null);
    }

    private void d() {
        setDrawableBounds(this.f34616f);
        setDrawableBounds(this.f34617g);
        setDrawableBounds(this.f34618h);
        setDrawableBounds(this.i);
        this.f34612b.setCompoundDrawablePadding(this.j);
        this.f34612b.setCompoundDrawables(this.f34616f, this.f34617g, this.f34618h, this.i);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, int i) {
        this.f34616f = drawable;
        this.f34617g = drawable2;
        this.f34618h = drawable3;
        this.i = drawable4;
        this.j = i;
        d();
    }

    public void a(String str, float f2) {
        this.f34614d.f34622d = true;
        this.f34614d.f34621c = str;
        this.f34614d.f34620b = f2;
        this.f34614d.a();
        c();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        View view = this.f34613c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setProgressDrawable(@ColorInt int i) {
        this.f34611a.setBackgroundColor(i);
        super.setBackground(null);
        super.setForeground(null);
    }

    public void setText(String str) {
        this.f34614d.f34622d = false;
        this.f34614d.f34621c = str;
        this.f34614d.a();
        d();
    }

    public void setTextColor(@ColorInt int i) {
        this.f34612b.setTextColor(i);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.f34612b.setIncludeFontPadding(z);
    }

    public void setTextSize(float f2) {
        this.f34612b.setTextSize(f2);
    }

    public void setTextTypeface(Typeface typeface) {
        this.f34612b.getPaint().setTypeface(typeface);
    }
}
