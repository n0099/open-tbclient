package com.kwad.components.ad.widget;

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
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class DownloadProgressView extends FrameLayout {
    public TextView Cl;
    @ColorInt
    public int Cm;
    @ColorInt
    public int Cn;
    @ColorInt
    public int Co;
    public int Cp;
    public Drawable Cq;
    public Drawable Cr;
    public String Cs;
    public TextProgressBar bZ;
    public final KsAppDownloadListener br;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.br = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.Cl.setText(com.kwad.sdk.core.response.a.a.al(downloadProgressView.mAdInfo));
                DownloadProgressView.this.Cl.setVisibility(0);
                DownloadProgressView.this.bZ.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.Cl.setVisibility(8);
                DownloadProgressView.this.bZ.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.bZ.f(com.kwad.sdk.core.response.a.a.aJ(downloadProgressView.mAdTemplate), DownloadProgressView.this.bZ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.Cl.setText(com.kwad.sdk.core.response.a.a.al(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.Cl.setVisibility(8);
                DownloadProgressView.this.bZ.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.bZ.f(com.kwad.sdk.core.response.a.a.P(downloadProgressView.mAdInfo), DownloadProgressView.this.bZ.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                DownloadProgressView.this.Cl.setVisibility(8);
                DownloadProgressView.this.bZ.setVisibility(0);
                DownloadProgressView.this.bZ.f(com.kwad.sdk.core.response.a.a.uU(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DownloadProgressView.this.Cl.setVisibility(8);
                DownloadProgressView.this.bZ.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.bZ.f(com.kwad.sdk.core.response.a.a.h(i2, downloadProgressView.Cs), i2);
            }
        };
        a(context, attributeSet);
        E(context);
    }

    private void E(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d048e, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091345);
        this.bZ = textProgressBar;
        textProgressBar.setTextDimen(this.Cp);
        this.bZ.setTextColor(this.Cn, this.Co);
        this.bZ.setProgressDrawable(this.Cq);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091315);
        this.Cl = textView;
        textView.setTextColor(this.Cm);
        this.Cl.setTextSize(0, this.Cp);
        this.Cl.setVisibility(0);
        this.Cl.setBackground(this.Cr);
        findViewById(R.id.obfuscated_res_0x7f0912c1).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.kwad.sdk.R.styleable.ksad_DownloadProgressView);
        this.Cm = obtainStyledAttributes.getColor(3, -117146);
        this.Cn = obtainStyledAttributes.getColor(1, -1);
        this.Co = obtainStyledAttributes.getColor(2, -117146);
        this.Cp = obtainStyledAttributes.getDimensionPixelSize(4, com.kwad.sdk.b.kwai.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        this.Cq = drawable;
        if (drawable == null) {
            this.Cq = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e30);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
        this.Cr = drawable2;
        if (drawable2 == null) {
            this.Cr = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e2f);
        }
        String string = obtainStyledAttributes.getString(5);
        this.Cs = string;
        if (string == null) {
            this.Cs = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    public final void F(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo bQ = d.bQ(adTemplate);
        this.mAdInfo = bQ;
        this.Cl.setText(com.kwad.sdk.core.response.a.a.al(bQ));
        this.bZ.setVisibility(8);
        this.Cl.setVisibility(0);
    }

    public final void a(AdInfo adInfo, int i, int i2) {
        if (i == 0) {
            this.Cl.setText(com.kwad.sdk.core.response.a.a.al(adInfo));
        } else if (i == 2) {
            this.Cl.setVisibility(8);
            this.bZ.setVisibility(0);
            this.bZ.f(com.kwad.sdk.core.response.a.a.h(i2, this.Cs), i2);
        } else {
            if (i != 7) {
                if (i == 8) {
                    this.Cl.setVisibility(8);
                    this.bZ.setVisibility(0);
                    this.bZ.f(com.kwad.sdk.core.response.a.a.aJ(this.mAdTemplate), this.bZ.getMax());
                    return;
                } else if (i != 11) {
                    if (i != 12) {
                        return;
                    }
                    this.Cl.setVisibility(8);
                    this.bZ.setVisibility(0);
                    this.bZ.f(com.kwad.sdk.core.response.a.a.P(adInfo), this.bZ.getMax());
                    return;
                }
            }
            this.Cl.setText(com.kwad.sdk.core.response.a.a.al(adInfo));
            this.Cl.setVisibility(0);
            this.bZ.setVisibility(8);
        }
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.br;
    }
}
