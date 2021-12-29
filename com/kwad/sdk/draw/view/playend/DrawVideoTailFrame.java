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
    public AdTemplate f58986b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f58987c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f58988d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsAppDownloadListener f58989e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58990f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f58991g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58992h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f58993i;

    /* renamed from: j  reason: collision with root package name */
    public AppScoreView f58994j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f58995k;
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
        this.f58990f = (ImageView) findViewById(R.id.ksad_video_cover);
        this.f58991g = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.f58992h = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f58993i = (TextView) findViewById(R.id.ksad_app_name);
        this.f58994j = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f58995k = (TextView) findViewById(R.id.ksad_app_download_count);
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
                DrawVideoTailFrame.this.m.a(a.A(DrawVideoTailFrame.this.f58987c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.m.a(a.a(DrawVideoTailFrame.this.f58986b), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DrawVideoTailFrame.this.m.a(a.A(DrawVideoTailFrame.this.f58987c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DrawVideoTailFrame.this.m.a(a.m(DrawVideoTailFrame.this.f58987c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.m;
                drawDownloadProgressBar.a(i2 + "%", i2);
            }
        };
    }

    public void a() {
        b bVar = this.f58988d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f58989e;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.f58989e = appDownloadListener;
            this.f58988d.a(appDownloadListener);
        }
    }

    public void a(AdTemplate adTemplate) {
        this.f58986b = adTemplate;
        AdInfo j2 = d.j(adTemplate);
        this.f58987c = j2;
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
                ViewGroup.LayoutParams layoutParams = this.f58990f.getLayoutParams();
                layoutParams.width = c2;
                layoutParams.height = (int) (c2 * (i3 / i2));
            }
            KSImageLoader.loadImage(this.f58990f, str, this.f58986b);
        }
        if (a.B(this.f58987c)) {
            KSImageLoader.loadAppIcon(this.f58992h, a.au(this.f58987c), this.f58986b, 11);
            this.f58993i.setText(a.t(this.f58987c));
            float x = a.x(this.f58987c);
            if (x >= 3.0f) {
                this.f58994j.setScore(x);
                this.f58994j.setVisibility(0);
            }
            this.f58995k.setText(a.w(this.f58987c));
            this.l.setText(a.s(this.f58987c));
            this.f58991g.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.o.setText(a.s(this.f58987c));
            this.p.setText(a.A(this.f58987c));
            this.f58991g.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.m.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        b bVar = this.f58988d;
        if (bVar == null || (ksAppDownloadListener = this.f58989e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.a.a.a(new a.C2083a(getContext()).a(this.f58986b).a(this.f58988d).a(view == this.m ? 1 : 2).a(view == this.m).a(new a.b() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (DrawVideoTailFrame.this.q != null) {
                    DrawVideoTailFrame.this.q.onAdClicked();
                }
                com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.f58986b, 2, DrawVideoTailFrame.this.a.getTouchCoords());
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
        this.f58988d = bVar;
    }
}
