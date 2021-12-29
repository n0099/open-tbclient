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
    public TextView f60268b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f60269c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f60270d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f60271e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f60272f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f60273g;

    /* renamed from: h  reason: collision with root package name */
    public int f60274h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f60275i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f60276j;

    /* renamed from: k  reason: collision with root package name */
    public String f60277k;
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
                DownloadProgressView.this.f60268b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView.this.a.a(com.kwad.sdk.core.response.a.a.a(), i3);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f60268b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.f60270d));
                DownloadProgressView.this.f60268b.setVisibility(0);
                DownloadProgressView.this.a.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DownloadProgressView.this.f60268b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(downloadProgressView.f60269c), DownloadProgressView.this.a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f60268b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.f60270d));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DownloadProgressView.this.f60268b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.m(downloadProgressView.f60270d), DownloadProgressView.this.a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i3) {
                DownloadProgressView.this.f60268b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(i3, downloadProgressView.f60277k), i3);
            }
        };
        a(context, attributeSet, i2);
        a(context);
    }

    public void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_progress_layout, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.a = textProgressBar;
        textProgressBar.setTextDimen(this.f60274h);
        this.a.a(this.f60272f, this.f60273g);
        this.a.setProgressDrawable(this.f60275i);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.f60268b = textView;
        textView.setTextColor(this.f60271e);
        this.f60268b.setTextSize(0, this.f60274h);
        this.f60268b.setVisibility(0);
        this.f60268b.setBackground(this.f60276j);
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
        this.f60271e = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -45056);
        this.f60272f = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.f60273g = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -45056);
        this.f60274h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.a.kwai.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.f60275i = drawable;
        if (drawable == null) {
            this.f60275i = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.f60276j = drawable2;
        if (drawable2 == null) {
            this.f60276j = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
        }
        String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.f60277k = string;
        if (string == null) {
            this.f60277k = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    public void a(AdInfo adInfo, int i2, int i3) {
        TextProgressBar textProgressBar;
        String a;
        if (i2 == 0) {
            this.f60268b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
            return;
        }
        if (i2 != 2) {
            if (i2 != 7) {
                if (i2 == 8) {
                    this.f60268b.setVisibility(8);
                    this.a.setVisibility(0);
                    textProgressBar = this.a;
                    a = com.kwad.sdk.core.response.a.a.a(this.f60269c);
                    i3 = this.a.getMax();
                } else if (i2 != 11) {
                    if (i2 != 12) {
                        return;
                    }
                    this.f60268b.setVisibility(8);
                    this.a.setVisibility(0);
                    this.a.a(com.kwad.sdk.core.response.a.a.m(adInfo), this.a.getMax());
                    return;
                }
            }
            this.f60268b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
            this.f60268b.setVisibility(0);
            this.a.setVisibility(8);
            return;
        }
        this.f60268b.setVisibility(8);
        this.a.setVisibility(0);
        textProgressBar = this.a;
        a = com.kwad.sdk.core.response.a.a.a(i3, this.f60277k);
        textProgressBar.a(a, i3);
    }

    public void a(AdTemplate adTemplate) {
        this.f60269c = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f60270d = j2;
        this.f60268b.setText(com.kwad.sdk.core.response.a.a.A(j2));
        this.a.setVisibility(8);
        this.f60268b.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.l;
    }
}
