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
    public AdBaseFrameLayout f34915a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34916b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f34917c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f34918d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsAppDownloadListener f34919e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f34920f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f34921g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34922h;
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
        this.f34920f = (ImageView) findViewById(R.id.ksad_video_cover);
        this.f34921g = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.f34922h = (ImageView) findViewById(R.id.ksad_app_icon);
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
                DrawVideoTailFrame.this.m.a(a.w(DrawVideoTailFrame.this.f34917c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.m.a(a.a(DrawVideoTailFrame.this.f34916b), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DrawVideoTailFrame.this.m.a(a.w(DrawVideoTailFrame.this.f34917c), DrawVideoTailFrame.this.m.getMax());
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
        b bVar = this.f34918d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f34919e;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.f34919e = appDownloadListener;
            this.f34918d.a(appDownloadListener);
        }
    }

    public void a(AdTemplate adTemplate) {
        this.f34916b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f34917c = j;
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
                ViewGroup.LayoutParams layoutParams = this.f34920f.getLayoutParams();
                layoutParams.width = c2;
                layoutParams.height = (int) (c2 * (i2 / i));
            }
            KSImageLoader.loadImage(this.f34920f, str, this.f34916b);
        }
        if (a.y(this.f34917c)) {
            KSImageLoader.loadAppIcon(this.f34922h, a.o(this.f34917c), this.f34916b, 11);
            this.i.setText(a.q(this.f34917c));
            float u = a.u(this.f34917c);
            if (u >= 3.0f) {
                this.j.setScore(u);
                this.j.setVisibility(0);
            }
            this.k.setText(a.t(this.f34917c));
            this.l.setText(a.n(this.f34917c));
            this.f34921g.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.o.setText(a.n(this.f34917c));
            this.p.setText(a.w(this.f34917c));
            this.f34921g.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.m.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        b bVar = this.f34918d;
        if (bVar == null || (ksAppDownloadListener = this.f34919e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.f34918d, view == this.m);
        com.kwad.sdk.core.download.b.a.a(getContext(), this.f34916b, new a.InterfaceC0393a() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                if (DrawVideoTailFrame.this.q != null) {
                    DrawVideoTailFrame.this.q.onAdClicked();
                }
                com.kwad.sdk.core.report.b.a(DrawVideoTailFrame.this.f34916b, 2, DrawVideoTailFrame.this.f34915a.getTouchCoords());
            }
        }, this.f34918d);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f34915a = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.q = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        this.f34918d = bVar;
    }
}
