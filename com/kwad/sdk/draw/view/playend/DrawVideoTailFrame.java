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
/* loaded from: classes6.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public AdBaseFrameLayout f34626a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34627b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f34628c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f34629d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsAppDownloadListener f34630e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f34631f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f34632g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34633h;
    public TextView i;
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

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.f34631f = (ImageView) findViewById(R.id.ksad_video_cover);
        this.f34632g = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.f34633h = (ImageView) findViewById(R.id.ksad_app_icon);
        this.i = (TextView) findViewById(R.id.ksad_app_name);
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
                DrawVideoTailFrame.this.m.a(a.w(DrawVideoTailFrame.this.f34628c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.m.a(a.a(DrawVideoTailFrame.this.f34627b), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DrawVideoTailFrame.this.m.a(a.w(DrawVideoTailFrame.this.f34628c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DrawVideoTailFrame.this.m.a(a.b(), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.m;
                drawDownloadProgressBar.a(i + "%", i);
            }
        };
    }

    public void a() {
        b bVar = this.f34629d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f34630e;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.f34630e = appDownloadListener;
            this.f34629d.a(appDownloadListener);
        }
    }

    public void a(AdTemplate adTemplate) {
        this.f34627b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f34628c = j;
        AdInfo.AdMaterialInfo.MaterialFeature E = a.E(j);
        String str = E.coverUrl;
        this.r.a(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = E.width;
            int i2 = E.height;
            if (i > 0 && i > i2) {
                int c2 = ao.c(getContext());
                if (getWidth() != 0) {
                    c2 = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.f34631f.getLayoutParams();
                layoutParams.width = c2;
                layoutParams.height = (int) (c2 * (i2 / i));
            }
            KSImageLoader.loadImage(this.f34631f, str, this.f34627b);
        }
        if (a.y(this.f34628c)) {
            KSImageLoader.loadAppIcon(this.f34633h, a.o(this.f34628c), this.f34627b, 11);
            this.i.setText(a.q(this.f34628c));
            float u = a.u(this.f34628c);
            if (u >= 3.0f) {
                this.j.setScore(u);
                this.j.setVisibility(0);
            }
            this.k.setText(a.t(this.f34628c));
            this.l.setText(a.n(this.f34628c));
            this.f34632g.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.o.setText(a.n(this.f34628c));
            this.p.setText(a.w(this.f34628c));
            this.f34632g.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.m.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        b bVar = this.f34629d;
        if (bVar == null || (ksAppDownloadListener = this.f34630e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.f34629d, view == this.m);
        com.kwad.sdk.core.download.b.a.a(getContext(), this.f34627b, new a.InterfaceC0379a() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                if (DrawVideoTailFrame.this.q != null) {
                    DrawVideoTailFrame.this.q.onAdClicked();
                }
                com.kwad.sdk.core.report.b.a(DrawVideoTailFrame.this.f34627b, 2, DrawVideoTailFrame.this.f34626a.getTouchCoords());
            }
        }, this.f34629d);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f34626a = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.q = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        this.f34629d = bVar;
    }
}
