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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public AdBaseFrameLayout f33228a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f33229b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f33230c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f33231d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsAppDownloadListener f33232e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33233f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f33234g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33235h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33236i;
    public AppScoreView j;
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
        this.f33233f = (ImageView) findViewById(R.id.ksad_video_cover);
        this.f33234g = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.f33235h = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f33236i = (TextView) findViewById(R.id.ksad_app_name);
        this.j = (AppScoreView) findViewById(R.id.ksad_app_score);
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
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                super.a(i2);
                DrawVideoTailFrame.this.m.a(a.a(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DrawVideoTailFrame.this.m.a(a.u(DrawVideoTailFrame.this.f33230c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.m.a(a.a(DrawVideoTailFrame.this.f33229b), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DrawVideoTailFrame.this.m.a(a.u(DrawVideoTailFrame.this.f33230c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DrawVideoTailFrame.this.m.a(a.j(DrawVideoTailFrame.this.f33230c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.m;
                drawDownloadProgressBar.a(i2 + "%", i2);
            }
        };
    }

    public void a() {
        b bVar = this.f33231d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f33232e;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.f33232e = appDownloadListener;
            this.f33231d.a(appDownloadListener);
        }
    }

    public void a(AdTemplate adTemplate) {
        this.f33229b = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33230c = g2;
        AdInfo.AdMaterialInfo.MaterialFeature C = a.C(g2);
        String str = C.coverUrl;
        this.r.a(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i2 = C.width;
            int i3 = C.height;
            if (i2 > 0 && i2 > i3) {
                int c2 = an.c(getContext());
                if (getWidth() != 0) {
                    c2 = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.f33233f.getLayoutParams();
                layoutParams.width = c2;
                layoutParams.height = (int) (c2 * (i3 / i2));
            }
            KSImageLoader.loadImage(this.f33233f, str, this.f33229b);
        }
        if (a.v(this.f33230c)) {
            KSImageLoader.loadAppIcon(this.f33235h, a.n(this.f33230c), this.f33229b, 11);
            this.f33236i.setText(a.o(this.f33230c));
            float s = a.s(this.f33230c);
            if (s >= 3.0f) {
                this.j.setScore(s);
                this.j.setVisibility(0);
            }
            this.k.setText(a.r(this.f33230c));
            this.l.setText(a.m(this.f33230c));
            this.f33234g.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.o.setText(a.m(this.f33230c));
            this.p.setText(a.u(this.f33230c));
            this.f33234g.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.m.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        b bVar = this.f33231d;
        if (bVar == null || (ksAppDownloadListener = this.f33232e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(getContext(), this.f33229b, new a.InterfaceC0363a() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                if (DrawVideoTailFrame.this.q != null) {
                    DrawVideoTailFrame.this.q.onAdClicked();
                }
                com.kwad.sdk.core.report.b.a(DrawVideoTailFrame.this.f33229b, 2, DrawVideoTailFrame.this.f33228a.getTouchCoords());
            }
        }, this.f33231d, view == this.m);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f33228a = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.q = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        this.f33231d = bVar;
    }
}
