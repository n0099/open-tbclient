package com.kwad.sdk.d.a;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d.a.b;
import com.kwad.sdk.d.kwai.e;
import com.kwad.sdk.d.kwai.f;
import com.kwad.sdk.d.kwai.g;
import com.kwad.sdk.d.kwai.h;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.af;
/* loaded from: classes8.dex */
public class a extends FrameLayout {
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55147b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f55148c;

    /* renamed from: d  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f55149d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Context f55150e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.d.kwai.b f55151f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.d.kwai.c f55152g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f55153h;

    /* renamed from: i  reason: collision with root package name */
    public KsAdVideoPlayConfig f55154i;

    /* renamed from: j  reason: collision with root package name */
    public Dialog f55155j;

    public a(@NonNull Context context) {
        this(context, null);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f55153h = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.f55150e = context;
    }

    private b a(Context context, AdInfo adInfo, com.kwad.sdk.d.kwai.c cVar) {
        boolean a = cVar.a(this.f55150e, adInfo);
        b.a aVar = new b.a();
        aVar.a(a);
        boolean z = true;
        aVar.b(!cVar.a(context) && com.kwad.sdk.core.config.b.r());
        aVar.a(com.kwad.sdk.core.config.b.s());
        if (com.kwad.sdk.core.response.a.a.K(adInfo) && af.e(context)) {
            z = false;
        }
        aVar.c(z);
        return new b(context, aVar);
    }

    public com.kwad.sdk.d.kwai.c a() {
        com.kwad.sdk.d.kwai.c cVar = new com.kwad.sdk.d.kwai.c();
        AdTemplate adTemplate = this.a;
        cVar.a = adTemplate;
        cVar.f55176b = this.f55149d;
        cVar.f55177c = this.f55155j;
        cVar.f55178d = new com.kwad.sdk.core.download.a.b(adTemplate);
        cVar.f55181g = this.f55154i;
        cVar.f55180f = this.f55147b;
        cVar.f55183i = new com.kwad.sdk.core.video.videoview.b(this.f55150e);
        cVar.f55179e = a(this.f55150e, com.kwad.sdk.core.response.a.d.j(this.a), cVar);
        return cVar;
    }

    public void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, boolean z) {
        this.a = adTemplate;
        this.f55148c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        adTemplate.realShowType = 2;
        this.f55154i = ksAdVideoPlayConfig;
        this.f55155j = dialog;
        this.f55147b = z;
        this.f55149d = adInteractionListener;
        this.f55152g = a();
        if (this.f55151f == null) {
            com.kwad.sdk.d.kwai.b b2 = b();
            this.f55151f = b2;
            b2.c(this.f55153h);
            this.f55151f.a(this.f55152g);
        }
    }

    @NonNull
    public com.kwad.sdk.d.kwai.b b() {
        com.kwad.sdk.d.kwai.b bVar = new com.kwad.sdk.d.kwai.b();
        bVar.a((Presenter) new com.kwad.sdk.d.kwai.d());
        if (com.kwad.sdk.core.response.a.a.P(this.f55148c)) {
            bVar.a((Presenter) new g());
        }
        bVar.a((Presenter) new h());
        bVar.a((Presenter) new e());
        if (com.kwad.sdk.core.response.a.a.D(this.f55148c)) {
            bVar.a((Presenter) new com.kwad.sdk.d.kwai.a());
        }
        if (this.f55152g.a(getContext())) {
            bVar.a((Presenter) new f());
        }
        return bVar;
    }

    public void c() {
        this.f55151f.g();
    }

    public void d() {
        this.f55151f.h();
    }

    public void e() {
        com.kwad.sdk.d.kwai.b bVar = this.f55151f;
        if (bVar != null) {
            bVar.j();
        }
    }

    public int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        com.kwad.sdk.d.kwai.c cVar = this.f55152g;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f55152g.c();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f55149d = adInteractionListener;
        com.kwad.sdk.d.kwai.c cVar = this.f55152g;
        if (cVar != null) {
            cVar.f55176b = adInteractionListener;
        }
    }
}
