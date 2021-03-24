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
    public ImageView f34226a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34227b;

    /* renamed from: c  reason: collision with root package name */
    public View f34228c;

    /* renamed from: d  reason: collision with root package name */
    public a f34229d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.view.a f34230e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f34231f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34232g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f34233h;
    public Drawable i;
    public int j;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public float f34235b;

        /* renamed from: c  reason: collision with root package name */
        public String f34236c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34237d;

        public a() {
            this.f34235b = -1.0f;
            this.f34237d = false;
        }

        public void a() {
            if (!this.f34237d || this.f34235b < 0.0f) {
                AdDownloadProgressBar.this.f34227b.setText(this.f34236c);
                return;
            }
            AdDownloadProgressBar.this.f34227b.setText(this.f34236c);
            if (AdDownloadProgressBar.this.f34230e != null) {
                AdDownloadProgressBar.this.f34226a.setImageDrawable(AdDownloadProgressBar.this.f34230e);
                AdDownloadProgressBar.this.f34230e.a(this.f34235b);
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
        this.f34229d = new a();
        a();
    }

    private void a() {
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
        this.f34227b = (TextView) findViewById(R.id.ksad_status_tv);
        this.f34228c = findViewById(R.id.ksad_click_mask);
        this.f34226a = (ImageView) findViewById(R.id.ksad_progress_bg);
        setRadius(ao.a(getContext(), 2.0f));
        this.f34228c.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
    }

    private void c() {
        this.f34227b.setCompoundDrawablePadding(0);
        this.f34227b.setCompoundDrawables(null, null, null, null);
    }

    private void d() {
        setDrawableBounds(this.f34231f);
        setDrawableBounds(this.f34232g);
        setDrawableBounds(this.f34233h);
        setDrawableBounds(this.i);
        this.f34227b.setCompoundDrawablePadding(this.j);
        this.f34227b.setCompoundDrawables(this.f34231f, this.f34232g, this.f34233h, this.i);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, int i) {
        this.f34231f = drawable;
        this.f34232g = drawable2;
        this.f34233h = drawable3;
        this.i = drawable4;
        this.j = i;
        d();
    }

    public void a(String str, float f2) {
        this.f34229d.f34237d = true;
        this.f34229d.f34236c = str;
        this.f34229d.f34235b = f2;
        this.f34229d.a();
        c();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        View view = this.f34228c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setProgressDrawable(@ColorInt int i) {
        this.f34226a.setBackgroundColor(i);
        super.setBackground(null);
        super.setForeground(null);
    }

    public void setText(String str) {
        this.f34229d.f34237d = false;
        this.f34229d.f34236c = str;
        this.f34229d.a();
        d();
    }

    public void setTextColor(@ColorInt int i) {
        this.f34227b.setTextColor(i);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.f34227b.setIncludeFontPadding(z);
    }

    public void setTextSize(float f2) {
        this.f34227b.setTextSize(f2);
    }

    public void setTextTypeface(Typeface typeface) {
        this.f34227b.getPaint().setTypeface(typeface);
    }
}
