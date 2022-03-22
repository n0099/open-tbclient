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
/* loaded from: classes7.dex */
public class a extends FrameLayout {
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40222b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f40223c;

    /* renamed from: d  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f40224d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Context f40225e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.d.kwai.b f40226f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.d.kwai.c f40227g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f40228h;
    public KsAdVideoPlayConfig i;
    public Dialog j;

    public a(@NonNull Context context) {
        this(context, null);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40228h = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.f40225e = context;
    }

    private b a(Context context, AdInfo adInfo, com.kwad.sdk.d.kwai.c cVar) {
        boolean a = cVar.a(this.f40225e, adInfo);
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
        cVar.f40247b = this.f40224d;
        cVar.f40248c = this.j;
        cVar.f40249d = new com.kwad.sdk.core.download.a.b(adTemplate);
        cVar.f40252g = this.i;
        cVar.f40251f = this.f40222b;
        cVar.i = new com.kwad.sdk.core.video.videoview.b(this.f40225e);
        cVar.f40250e = a(this.f40225e, com.kwad.sdk.core.response.a.d.j(this.a), cVar);
        return cVar;
    }

    public void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, boolean z) {
        this.a = adTemplate;
        this.f40223c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        adTemplate.realShowType = 2;
        this.i = ksAdVideoPlayConfig;
        this.j = dialog;
        this.f40222b = z;
        this.f40224d = adInteractionListener;
        this.f40227g = a();
        if (this.f40226f == null) {
            com.kwad.sdk.d.kwai.b b2 = b();
            this.f40226f = b2;
            b2.c(this.f40228h);
            this.f40226f.a(this.f40227g);
        }
    }

    @NonNull
    public com.kwad.sdk.d.kwai.b b() {
        com.kwad.sdk.d.kwai.b bVar = new com.kwad.sdk.d.kwai.b();
        bVar.a((Presenter) new com.kwad.sdk.d.kwai.d());
        if (com.kwad.sdk.core.response.a.a.P(this.f40223c)) {
            bVar.a((Presenter) new g());
        }
        bVar.a((Presenter) new h());
        bVar.a((Presenter) new e());
        if (com.kwad.sdk.core.response.a.a.D(this.f40223c)) {
            bVar.a((Presenter) new com.kwad.sdk.d.kwai.a());
        }
        if (this.f40227g.a(getContext())) {
            bVar.a((Presenter) new f());
        }
        return bVar;
    }

    public void c() {
        this.f40226f.g();
    }

    public void d() {
        this.f40226f.h();
    }

    public void e() {
        com.kwad.sdk.d.kwai.b bVar = this.f40226f;
        if (bVar != null) {
            bVar.j();
        }
    }

    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0445;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        com.kwad.sdk.d.kwai.c cVar = this.f40227g;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f40227g.c();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f40224d = adInteractionListener;
        com.kwad.sdk.d.kwai.c cVar = this.f40227g;
        if (cVar != null) {
            cVar.f40247b = adInteractionListener;
        }
    }
}
