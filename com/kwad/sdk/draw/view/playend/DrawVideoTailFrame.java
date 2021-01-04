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
/* loaded from: classes5.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private AdBaseFrameLayout f10022a;

    /* renamed from: b  reason: collision with root package name */
    private AdTemplate f10023b;
    private AdInfo c;
    @Nullable
    private b d;
    @Nullable
    private KsAppDownloadListener e;
    private ImageView f;
    private ViewGroup g;
    private ImageView h;
    private TextView i;
    private AppScoreView j;
    private TextView k;
    private TextView l;
    private DrawDownloadProgressBar m;
    private ViewGroup n;
    private TextView o;
    private TextView p;
    private KsDrawAd.AdInteractionListener q;
    private KsLogoView r;

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
        inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.f = (ImageView) findViewById(R.id.ksad_video_cover);
        this.g = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.h = (ImageView) findViewById(R.id.ksad_app_icon);
        this.i = (TextView) findViewById(R.id.ksad_app_name);
        this.j = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.k = (TextView) findViewById(R.id.ksad_app_download_count);
        this.l = (TextView) findViewById(R.id.ksad_app_ad_desc);
        this.m = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.m.setTextSize(15);
        this.n = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.o = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.p = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.r = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new c() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DrawVideoTailFrame.this.m.a(a.w(DrawVideoTailFrame.this.c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.m.a(a.a(DrawVideoTailFrame.this.f10023b), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DrawVideoTailFrame.this.m.a(a.w(DrawVideoTailFrame.this.c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DrawVideoTailFrame.this.m.a(a.b(), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                DrawVideoTailFrame.this.m.a(i + "%", i);
            }
        };
    }

    public void a() {
        if (this.d != null) {
            if (this.e != null) {
                this.d.c(this.e);
                return;
            }
            this.e = getAppDownloadListener();
            this.d.a(this.e);
        }
    }

    public void a(AdTemplate adTemplate) {
        this.f10023b = adTemplate;
        this.c = com.kwad.sdk.core.response.b.c.j(adTemplate);
        AdInfo.AdMaterialInfo.MaterialFeature E = a.E(this.c);
        String str = E.coverUrl;
        this.r.a(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = E.width;
            int i2 = E.height;
            if (i > 0 && i > i2) {
                int c = ao.c(getContext());
                if (getWidth() != 0) {
                    c = getWidth();
                }
                float f = i2 / i;
                ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
                layoutParams.width = c;
                layoutParams.height = (int) (f * c);
            }
            KSImageLoader.loadImage(this.f, str, this.f10023b);
        }
        if (a.y(this.c)) {
            KSImageLoader.loadAppIcon(this.h, a.o(this.c), this.f10023b, 11);
            this.i.setText(a.q(this.c));
            float u = a.u(this.c);
            if (u >= 3.0f) {
                this.j.setScore(u);
                this.j.setVisibility(0);
            }
            this.k.setText(a.t(this.c));
            this.l.setText(a.n(this.c));
            this.g.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.o.setText(a.n(this.c));
            this.p.setText(a.w(this.c));
            this.g.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.m.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        if (this.d == null || this.e == null) {
            return;
        }
        this.d.b(this.e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.d, view == this.m);
        com.kwad.sdk.core.download.b.a.a(getContext(), this.f10023b, new a.InterfaceC1064a() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
            public void a() {
                if (DrawVideoTailFrame.this.q != null) {
                    DrawVideoTailFrame.this.q.onAdClicked();
                }
                com.kwad.sdk.core.report.b.a(DrawVideoTailFrame.this.f10023b, 2, DrawVideoTailFrame.this.f10022a.getTouchCoords());
            }
        }, this.d);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f10022a = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.q = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        this.d = bVar;
    }
}
