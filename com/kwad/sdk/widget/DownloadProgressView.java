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
/* loaded from: classes5.dex */
public class DownloadProgressView extends FrameLayout {
    public TextProgressBar a;
    public TextView b;
    public AdTemplate c;
    public AdInfo d;
    @ColorInt
    public int e;
    @ColorInt
    public int f;
    @ColorInt
    public int g;
    public int h;
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
                DownloadProgressView.this.b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView.this.a.a(com.kwad.sdk.core.response.a.a.a(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.d));
                DownloadProgressView.this.b.setVisibility(0);
                DownloadProgressView.this.a.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DownloadProgressView.this.b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(downloadProgressView.c), DownloadProgressView.this.a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.d));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DownloadProgressView.this.b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.m(downloadProgressView.d), DownloadProgressView.this.a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                DownloadProgressView.this.b.setVisibility(8);
                DownloadProgressView.this.a.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(i2, downloadProgressView.k), i2);
            }
        };
        a(context, attributeSet, i);
        a(context);
    }

    public void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0412, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091092);
        this.a = textProgressBar;
        textProgressBar.setTextDimen(this.h);
        this.a.a(this.f, this.g);
        this.a.setProgressDrawable(this.i);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091089);
        this.b = textView;
        textView.setTextColor(this.e);
        this.b.setTextSize(0, this.h);
        this.b.setVisibility(0);
        this.b.setBackground(this.j);
        findViewById(R.id.obfuscated_res_0x7f091053).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    @SuppressLint({"CustomViewStyleable"})
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040349, R.attr.obfuscated_res_0x7f040356, R.attr.obfuscated_res_0x7f04035b, R.attr.obfuscated_res_0x7f04035d, R.attr.obfuscated_res_0x7f040362, R.attr.obfuscated_res_0x7f040363, R.attr.obfuscated_res_0x7f04036f});
        this.e = obtainStyledAttributes.getColor(3, -45056);
        this.f = obtainStyledAttributes.getColor(1, -1);
        this.g = obtainStyledAttributes.getColor(2, -45056);
        this.h = obtainStyledAttributes.getDimensionPixelSize(4, com.kwad.sdk.a.kwai.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        this.i = drawable;
        if (drawable == null) {
            this.i = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bdb);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
        this.j = drawable2;
        if (drawable2 == null) {
            this.j = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bda);
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
            this.b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
            return;
        }
        if (i != 2) {
            if (i != 7) {
                if (i == 8) {
                    this.b.setVisibility(8);
                    this.a.setVisibility(0);
                    textProgressBar = this.a;
                    a = com.kwad.sdk.core.response.a.a.a(this.c);
                    i2 = this.a.getMax();
                } else if (i != 11) {
                    if (i != 12) {
                        return;
                    }
                    this.b.setVisibility(8);
                    this.a.setVisibility(0);
                    this.a.a(com.kwad.sdk.core.response.a.a.m(adInfo), this.a.getMax());
                    return;
                }
            }
            this.b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
            this.b.setVisibility(0);
            this.a.setVisibility(8);
            return;
        }
        this.b.setVisibility(8);
        this.a.setVisibility(0);
        textProgressBar = this.a;
        a = com.kwad.sdk.core.response.a.a.a(i2, this.k);
        textProgressBar.a(a, i2);
    }

    public void a(AdTemplate adTemplate) {
        this.c = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.d = j;
        this.b.setText(com.kwad.sdk.core.response.a.a.A(j));
        this.a.setVisibility(8);
        this.b.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.l;
    }
}
