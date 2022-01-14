package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class DownloadProgressView extends FrameLayout {
    public TextProgressBar a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57981b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f57982c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f57983d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f57984e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f57985f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f57986g;

    /* renamed from: h  reason: collision with root package name */
    public int f57987h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f57988i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f57989j;
    public String k;
    public final KsAppDownloadListener l;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i3) {
                DownloadProgressView.this.f57981b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView.this.a.a(com.kwad.sdk.core.response.a.a.a(), i3);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f57981b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.f57983d));
                DownloadProgressView.this.f57981b.setVisibility(0);
                DownloadProgressView.this.a.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DownloadProgressView.this.f57981b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(downloadProgressView.f57982c), DownloadProgressView.this.a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f57981b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.f57983d));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DownloadProgressView.this.f57981b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.m(downloadProgressView.f57983d), DownloadProgressView.this.a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i3) {
                DownloadProgressView.this.f57981b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(i3, downloadProgressView.k), i3);
            }
        };
        a(context, attributeSet, i2);
        a(context);
    }

    public void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_progress_layout, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.a = textProgressBar;
        textProgressBar.setTextDimen(this.f57987h);
        this.a.a(this.f57985f, this.f57986g);
        this.a.setProgressDrawable(this.f57988i);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.f57981b = textView;
        textView.setTextColor(this.f57984e);
        this.f57981b.setTextSize(0, this.f57987h);
        this.f57981b.setVisibility(0);
        this.f57981b.setBackground(this.f57989j);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    @SuppressLint({"CustomViewStyleable"})
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.f57984e = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -45056);
        this.f57985f = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.f57986g = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -45056);
        this.f57987h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.a.kwai.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.f57988i = drawable;
        if (drawable == null) {
            this.f57988i = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.f57989j = drawable2;
        if (drawable2 == null) {
            this.f57989j = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
        }
        String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.k = string;
        if (string == null) {
            this.k = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    public void a(AdInfo adInfo, int i2, int i3) {
        TextProgressBar textProgressBar;
        String a;
        if (i2 == 0) {
            this.f57981b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
            return;
        }
        if (i2 != 2) {
            if (i2 != 7) {
                if (i2 == 8) {
                    this.f57981b.setVisibility(8);
                    this.a.setVisibility(0);
                    textProgressBar = this.a;
                    a = com.kwad.sdk.core.response.a.a.a(this.f57982c);
                    i3 = this.a.getMax();
                } else if (i2 != 11) {
                    if (i2 != 12) {
                        return;
                    }
                    this.f57981b.setVisibility(8);
                    this.a.setVisibility(0);
                    this.a.a(com.kwad.sdk.core.response.a.a.m(adInfo), this.a.getMax());
                    return;
                }
            }
            this.f57981b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
            this.f57981b.setVisibility(0);
            this.a.setVisibility(8);
            return;
        }
        this.f57981b.setVisibility(8);
        this.a.setVisibility(0);
        textProgressBar = this.a;
        a = com.kwad.sdk.core.response.a.a.a(i3, this.k);
        textProgressBar.a(a, i3);
    }

    public void a(AdTemplate adTemplate) {
        this.f57982c = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57983d = j2;
        this.f57981b.setText(com.kwad.sdk.core.response.a.a.A(j2));
        this.a.setVisibility(8);
        this.f57981b.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.l;
    }
}
