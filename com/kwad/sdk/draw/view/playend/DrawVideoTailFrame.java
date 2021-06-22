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
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public AdBaseFrameLayout f35379a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35380b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f35381c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f35382d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsAppDownloadListener f35383e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35384f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f35385g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35386h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f35387i;
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
        this.f35384f = (ImageView) findViewById(R.id.ksad_video_cover);
        this.f35385g = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.f35386h = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f35387i = (TextView) findViewById(R.id.ksad_app_name);
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
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DrawVideoTailFrame.this.m.a(a.w(DrawVideoTailFrame.this.f35381c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.m.a(a.a(DrawVideoTailFrame.this.f35380b), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DrawVideoTailFrame.this.m.a(a.w(DrawVideoTailFrame.this.f35381c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DrawVideoTailFrame.this.m.a(a.b(), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.m;
                drawDownloadProgressBar.a(i2 + "%", i2);
            }
        };
    }

    public void a() {
        b bVar = this.f35382d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f35383e;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.f35383e = appDownloadListener;
            this.f35382d.a(appDownloadListener);
        }
    }

    public void a(AdTemplate adTemplate) {
        this.f35380b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f35381c = j;
        AdInfo.AdMaterialInfo.MaterialFeature E = a.E(j);
        String str = E.coverUrl;
        this.r.a(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i2 = E.width;
            int i3 = E.height;
            if (i2 > 0 && i2 > i3) {
                int c2 = ao.c(getContext());
                if (getWidth() != 0) {
                    c2 = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.f35384f.getLayoutParams();
                layoutParams.width = c2;
                layoutParams.height = (int) (c2 * (i3 / i2));
            }
            KSImageLoader.loadImage(this.f35384f, str, this.f35380b);
        }
        if (a.y(this.f35381c)) {
            KSImageLoader.loadAppIcon(this.f35386h, a.o(this.f35381c), this.f35380b, 11);
            this.f35387i.setText(a.q(this.f35381c));
            float u = a.u(this.f35381c);
            if (u >= 3.0f) {
                this.j.setScore(u);
                this.j.setVisibility(0);
            }
            this.k.setText(a.t(this.f35381c));
            this.l.setText(a.n(this.f35381c));
            this.f35385g.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.o.setText(a.n(this.f35381c));
            this.p.setText(a.w(this.f35381c));
            this.f35385g.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.m.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        b bVar = this.f35382d;
        if (bVar == null || (ksAppDownloadListener = this.f35383e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.f35382d, view == this.m);
        com.kwad.sdk.core.download.b.a.a(getContext(), this.f35380b, new a.InterfaceC0382a() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                if (DrawVideoTailFrame.this.q != null) {
                    DrawVideoTailFrame.this.q.onAdClicked();
                }
                com.kwad.sdk.core.report.b.a(DrawVideoTailFrame.this.f35380b, 2, DrawVideoTailFrame.this.f35379a.getTouchCoords());
            }
        }, this.f35382d);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f35379a = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.q = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        this.f35382d = bVar;
    }
}
