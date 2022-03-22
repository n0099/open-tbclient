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
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class DownloadProgressView extends FrameLayout {
    public TextProgressBar a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f41428b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f41429c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f41430d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f41431e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f41432f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f41433g;

    /* renamed from: h  reason: collision with root package name */
    public int f41434h;
    public Drawable i;
    public Drawable j;
    public String k;
    public final KsAppDownloadListener l;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                DownloadProgressView.this.f41428b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView.this.a.a(com.kwad.sdk.core.response.a.a.a(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f41428b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.f41430d));
                DownloadProgressView.this.f41428b.setVisibility(0);
                DownloadProgressView.this.a.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DownloadProgressView.this.f41428b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(downloadProgressView.f41429c), DownloadProgressView.this.a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f41428b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.f41430d));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DownloadProgressView.this.f41428b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.m(downloadProgressView.f41430d), DownloadProgressView.this.a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                DownloadProgressView.this.f41428b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(i2, downloadProgressView.k), i2);
            }
        };
        a(context, attributeSet, i);
        a(context);
    }

    public void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d042d, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f0910c7);
        this.a = textProgressBar;
        textProgressBar.setTextDimen(this.f41434h);
        this.a.a(this.f41432f, this.f41433g);
        this.a.setProgressDrawable(this.i);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0910be);
        this.f41428b = textView;
        textView.setTextColor(this.f41431e);
        this.f41428b.setTextSize(0, this.f41434h);
        this.f41428b.setVisibility(0);
        this.f41428b.setBackground(this.j);
        findViewById(R.id.obfuscated_res_0x7f091088).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    @SuppressLint({"CustomViewStyleable"})
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040307, R.attr.obfuscated_res_0x7f04030f, R.attr.obfuscated_res_0x7f040310, R.attr.obfuscated_res_0x7f040311, R.attr.obfuscated_res_0x7f040312, R.attr.obfuscated_res_0x7f040313, R.attr.obfuscated_res_0x7f04031f});
        this.f41431e = obtainStyledAttributes.getColor(3, -45056);
        this.f41432f = obtainStyledAttributes.getColor(1, -1);
        this.f41433g = obtainStyledAttributes.getColor(2, -45056);
        this.f41434h = obtainStyledAttributes.getDimensionPixelSize(4, com.kwad.sdk.a.kwai.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        this.i = drawable;
        if (drawable == null) {
            this.i = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080baa);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
        this.j = drawable2;
        if (drawable2 == null) {
            this.j = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ba9);
        }
        String string = obtainStyledAttributes.getString(5);
        this.k = string;
        if (string == null) {
            this.k = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    public void a(AdInfo adInfo, int i, int i2) {
        TextProgressBar textProgressBar;
        String a;
        if (i == 0) {
            this.f41428b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
            return;
        }
        if (i != 2) {
            if (i != 7) {
                if (i == 8) {
                    this.f41428b.setVisibility(8);
                    this.a.setVisibility(0);
                    textProgressBar = this.a;
                    a = com.kwad.sdk.core.response.a.a.a(this.f41429c);
                    i2 = this.a.getMax();
                } else if (i != 11) {
                    if (i != 12) {
                        return;
                    }
                    this.f41428b.setVisibility(8);
                    this.a.setVisibility(0);
                    this.a.a(com.kwad.sdk.core.response.a.a.m(adInfo), this.a.getMax());
                    return;
                }
            }
            this.f41428b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
            this.f41428b.setVisibility(0);
            this.a.setVisibility(8);
            return;
        }
        this.f41428b.setVisibility(8);
        this.a.setVisibility(0);
        textProgressBar = this.a;
        a = com.kwad.sdk.core.response.a.a.a(i2, this.k);
        textProgressBar.a(a, i2);
    }

    public void a(AdTemplate adTemplate) {
        this.f41429c = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f41430d = j;
        this.f41428b.setText(com.kwad.sdk.core.response.a.a.A(j));
        this.a.setVisibility(8);
        this.f41428b.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.l;
    }
}
