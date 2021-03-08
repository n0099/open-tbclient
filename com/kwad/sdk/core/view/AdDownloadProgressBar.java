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
/* loaded from: classes3.dex */
public class AdDownloadProgressBar extends d {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f6305a;
    private TextView b;
    private View c;
    private a d;
    private com.kwad.sdk.core.view.a e;
    private Drawable f;
    private Drawable g;
    private Drawable h;
    private Drawable i;
    private int j;

    /* loaded from: classes3.dex */
    private class a {
        private float b;
        private String c;
        private boolean d;

        private a() {
            this.b = -1.0f;
            this.d = false;
        }

        void a() {
            if (!this.d || this.b < 0.0f) {
                AdDownloadProgressBar.this.b.setText(this.c);
                return;
            }
            AdDownloadProgressBar.this.b.setText(this.c);
            if (AdDownloadProgressBar.this.e != null) {
                AdDownloadProgressBar.this.f6305a.setImageDrawable(AdDownloadProgressBar.this.e);
                AdDownloadProgressBar.this.e.a(this.b);
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
        this.d = new a();
        a();
    }

    private void a() {
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.ksad_status_tv);
        this.c = findViewById(R.id.ksad_click_mask);
        this.f6305a = (ImageView) findViewById(R.id.ksad_progress_bg);
        setRadius(ao.a(getContext(), 2.0f));
        this.c.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
    }

    private void c() {
        this.b.setCompoundDrawablePadding(0);
        this.b.setCompoundDrawables(null, null, null, null);
    }

    private void d() {
        setDrawableBounds(this.f);
        setDrawableBounds(this.g);
        setDrawableBounds(this.h);
        setDrawableBounds(this.i);
        this.b.setCompoundDrawablePadding(this.j);
        this.b.setCompoundDrawables(this.f, this.g, this.h, this.i);
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, int i) {
        this.f = drawable;
        this.g = drawable2;
        this.h = drawable3;
        this.i = drawable4;
        this.j = i;
        d();
    }

    public void a(String str, float f) {
        this.d.d = true;
        this.d.c = str;
        this.d.b = f;
        this.d.a();
        c();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (this.c != null) {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public void setProgressDrawable(@ColorInt int i) {
        this.f6305a.setBackgroundColor(i);
        super.setBackground(null);
        super.setForeground(null);
    }

    public void setText(String str) {
        this.d.d = false;
        this.d.c = str;
        this.d.a();
        d();
    }

    public void setTextColor(@ColorInt int i) {
        this.b.setTextColor(i);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.b.setIncludeFontPadding(z);
    }

    public void setTextSize(float f) {
        this.b.setTextSize(f);
    }

    public void setTextTypeface(Typeface typeface) {
        this.b.getPaint().setTypeface(typeface);
    }
}
