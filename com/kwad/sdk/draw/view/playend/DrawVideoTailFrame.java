package com.kwad.sdk.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes3.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    public AdBaseFrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f56809b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f56810c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f56811d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsAppDownloadListener f56812e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56813f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f56814g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f56815h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f56816i;

    /* renamed from: j  reason: collision with root package name */
    public AppScoreView f56817j;
    public TextView k;
    public TextView l;
    public DrawDownloadProgressBar m;
    public ViewGroup n;
    public TextView o;
    public TextView p;
    public KsDrawAd.AdInteractionListener q;
    public KsLogoView r;

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        a(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.f56813f = (ImageView) findViewById(R.id.ksad_video_cover);
        this.f56814g = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.f56815h = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f56816i = (TextView) findViewById(R.id.ksad_app_name);
        this.f56817j = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.k = (TextView) findViewById(R.id.ksad_app_download_count);
        this.l = (TextView) findViewById(R.id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.m = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.n = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.o = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.p = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.r = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new c() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                super.a(i2);
                DrawVideoTailFrame.this.m.a(a.a(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DrawVideoTailFrame.this.m.a(a.A(DrawVideoTailFrame.this.f56810c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.m.a(a.a(DrawVideoTailFrame.this.f56809b), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DrawVideoTailFrame.this.m.a(a.A(DrawVideoTailFrame.this.f56810c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DrawVideoTailFrame.this.m.a(a.m(DrawVideoTailFrame.this.f56810c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.m;
                drawDownloadProgressBar.a(i2 + "%", i2);
            }
        };
    }

    public void a() {
        b bVar = this.f56811d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f56812e;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.f56812e = appDownloadListener;
            this.f56811d.a(appDownloadListener);
        }
    }

    public void a(AdTemplate adTemplate) {
        this.f56809b = adTemplate;
        AdInfo j2 = d.j(adTemplate);
        this.f56810c = j2;
        AdInfo.AdMaterialInfo.MaterialFeature J = a.J(j2);
        String str = J.coverUrl;
        this.r.a(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i2 = J.width;
            int i3 = J.height;
            if (i2 > 0 && i2 > i3) {
                int c2 = com.kwad.sdk.a.kwai.a.c(getContext());
                if (getWidth() != 0) {
                    c2 = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.f56813f.getLayoutParams();
                layoutParams.width = c2;
                layoutParams.height = (int) (c2 * (i3 / i2));
            }
            KSImageLoader.loadImage(this.f56813f, str, this.f56809b);
        }
        if (a.B(this.f56810c)) {
            KSImageLoader.loadAppIcon(this.f56815h, a.au(this.f56810c), this.f56809b, 11);
            this.f56816i.setText(a.t(this.f56810c));
            float x = a.x(this.f56810c);
            if (x >= 3.0f) {
                this.f56817j.setScore(x);
                this.f56817j.setVisibility(0);
            }
            this.k.setText(a.w(this.f56810c));
            this.l.setText(a.s(this.f56810c));
            this.f56814g.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.o.setText(a.s(this.f56810c));
            this.p.setText(a.A(this.f56810c));
            this.f56814g.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.m.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        b bVar = this.f56811d;
        if (bVar == null || (ksAppDownloadListener = this.f56812e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.a.a.a(new a.C2106a(getContext()).a(this.f56809b).a(this.f56811d).a(view == this.m ? 1 : 2).a(view == this.m).a(new a.b() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (DrawVideoTailFrame.this.q != null) {
                    DrawVideoTailFrame.this.q.onAdClicked();
                }
                com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.f56809b, 2, DrawVideoTailFrame.this.a.getTouchCoords());
            }
        }));
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.a = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.q = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        this.f56811d = bVar;
    }
}
