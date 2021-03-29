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
    public ImageView f34227a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34228b;

    /* renamed from: c  reason: collision with root package name */
    public View f34229c;

    /* renamed from: d  reason: collision with root package name */
    public a f34230d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.view.a f34231e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f34232f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34233g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f34234h;
    public Drawable i;
    public int j;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public float f34236b;

        /* renamed from: c  reason: collision with root package name */
        public String f34237c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34238d;

        public a() {
            this.f34236b = -1.0f;
            this.f34238d = false;
        }

        public void a() {
            if (!this.f34238d || this.f34236b < 0.0f) {
                AdDownloadProgressBar.this.f34228b.setText(this.f34237c);
                return;
            }
            AdDownloadProgressBar.this.f34228b.setText(this.f34237c);
            if (AdDownloadProgressBar.this.f34231e != null) {
                AdDownloadProgressBar.this.f34227a.setImageDrawable(AdDownloadProgressBar.this.f34231e);
                AdDownloadProgressBar.this.f34231e.a(this.f34236b);
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
        this.f34230d = new a();
        a();
    }

    private void a() {
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
        this.f34228b = (TextView) findViewById(R.id.ksad_status_tv);
        this.f34229c = findViewById(R.id.ksad_click_mask);
        this.f34227a = (ImageView) findViewById(R.id.ksad_progress_bg);
        setRadius(ao.a(getContext(), 2.0f));
        this.f34229c.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
    }

    private void c() {
        this.f34228b.setCompoundDrawablePadding(0);
        this.f34228b.setCompoundDrawables(null, null, null, null);
    }

    private void d() {
        setDrawableBounds(this.f34232f);
        setDrawableBounds(this.f34233g);
        setDrawableBounds(this.f34234h);
        setDrawableBounds(this.i);
        this.f34228b.setCompoundDrawablePadding(this.j);
        this.f34228b.setCompoundDrawables(this.f34232f, this.f34233g, this.f34234h, this.i);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, int i) {
        this.f34232f = drawable;
        this.f34233g = drawable2;
        this.f34234h = drawable3;
        this.i = drawable4;
        this.j = i;
        d();
    }

    public void a(String str, float f2) {
        this.f34230d.f34238d = true;
        this.f34230d.f34237c = str;
        this.f34230d.f34236b = f2;
        this.f34230d.a();
        c();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        View view = this.f34229c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setProgressDrawable(@ColorInt int i) {
        this.f34227a.setBackgroundColor(i);
        super.setBackground(null);
        super.setForeground(null);
    }

    public void setText(String str) {
        this.f34230d.f34238d = false;
        this.f34230d.f34237c = str;
        this.f34230d.a();
        d();
    }

    public void setTextColor(@ColorInt int i) {
        this.f34228b.setTextColor(i);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.f34228b.setIncludeFontPadding(z);
    }

    public void setTextSize(float f2) {
        this.f34228b.setTextSize(f2);
    }

    public void setTextTypeface(Typeface typeface) {
        this.f34228b.getPaint().setTypeface(typeface);
    }
}
