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
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class DownloadProgressView extends FrameLayout {
    public TextView HT;
    @ColorInt
    public int HU;
    @ColorInt
    public int HV;
    @ColorInt
    public int HW;
    public int HX;
    public Drawable HY;
    public Drawable HZ;
    public String Ia;
    public final KsAppDownloadListener cx;
    public TextProgressBar dh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    public final void ai(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo dP = e.dP(adTemplate);
        this.mAdInfo = dP;
        this.HT.setText(com.kwad.sdk.core.response.b.a.aE(dP));
        this.dh.setVisibility(8);
        this.HT.setVisibility(0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(l.wrapContextIfNeed(context), attributeSet, i);
        this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i2) {
                DownloadProgressView.this.HT.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView.this.dh.e(com.kwad.sdk.core.response.b.a.DX(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DownloadProgressView.this.HT.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.q(i2, downloadProgressView.Ia), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.HT.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
                DownloadProgressView.this.HT.setVisibility(0);
                DownloadProgressView.this.dh.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.HT.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.bX(downloadProgressView.mAdTemplate), DownloadProgressView.this.dh.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.HT.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.HT.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.ac(downloadProgressView.mAdInfo), DownloadProgressView.this.dh.getMax());
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.HU = obtainStyledAttributes.getColor(3, -117146);
        this.HV = obtainStyledAttributes.getColor(1, -1);
        this.HW = obtainStyledAttributes.getColor(2, -117146);
        this.HX = obtainStyledAttributes.getDimensionPixelSize(4, com.kwad.sdk.d.a.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        this.HY = drawable;
        if (drawable == null) {
            this.HY = getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080e75);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
        this.HZ = drawable2;
        if (drawable2 == null) {
            this.HZ = getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080e74);
        }
        String string = obtainStyledAttributes.getString(5);
        this.Ia = string;
        if (string == null) {
            this.Ia = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    private void initView() {
        l.inflate(getContext(), com.baidu.tieba.R.layout.obfuscated_res_0x7f0d04bf, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09140b);
        this.dh = textProgressBar;
        textProgressBar.setTextDimen(this.HX);
        this.dh.setTextColor(this.HV, this.HW);
        this.dh.setProgressDrawable(this.HY);
        TextView textView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0913e1);
        this.HT = textView;
        textView.setTextColor(this.HU);
        this.HT.setTextSize(0, this.HX);
        this.HT.setVisibility(0);
        this.HT.setBackground(this.HZ);
        findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09136c).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.cx;
    }
}
