package com.kwad.sdk.d.a;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
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
/* loaded from: classes3.dex */
public class a extends FrameLayout {
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56585b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f56586c;

    /* renamed from: d  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f56587d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Context f56588e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.d.kwai.b f56589f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.d.kwai.c f56590g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f56591h;

    /* renamed from: i  reason: collision with root package name */
    public KsAdVideoPlayConfig f56592i;

    /* renamed from: j  reason: collision with root package name */
    public Dialog f56593j;

    public a(@NonNull Context context) {
        this(context, null);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56591h = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.f56588e = context;
    }

    private b a(Context context, AdInfo adInfo, com.kwad.sdk.d.kwai.c cVar) {
        boolean a = cVar.a(this.f56588e, adInfo);
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
        cVar.f56614b = this.f56587d;
        cVar.f56615c = this.f56593j;
        cVar.f56616d = new com.kwad.sdk.core.download.a.b(adTemplate);
        cVar.f56619g = this.f56592i;
        cVar.f56618f = this.f56585b;
        cVar.f56621i = new com.kwad.sdk.core.video.videoview.b(this.f56588e);
        cVar.f56617e = a(this.f56588e, com.kwad.sdk.core.response.a.d.j(this.a), cVar);
        return cVar;
    }

    public void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, boolean z) {
        this.a = adTemplate;
        this.f56586c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        adTemplate.realShowType = 2;
        this.f56592i = ksAdVideoPlayConfig;
        this.f56593j = dialog;
        this.f56585b = z;
        this.f56587d = adInteractionListener;
        this.f56590g = a();
        if (this.f56589f == null) {
            com.kwad.sdk.d.kwai.b b2 = b();
            this.f56589f = b2;
            b2.c(this.f56591h);
            this.f56589f.a(this.f56590g);
        }
    }

    @NonNull
    public com.kwad.sdk.d.kwai.b b() {
        com.kwad.sdk.d.kwai.b bVar = new com.kwad.sdk.d.kwai.b();
        bVar.a((Presenter) new com.kwad.sdk.d.kwai.d());
        if (com.kwad.sdk.core.response.a.a.P(this.f56586c)) {
            bVar.a((Presenter) new g());
        }
        bVar.a((Presenter) new h());
        bVar.a((Presenter) new e());
        if (com.kwad.sdk.core.response.a.a.D(this.f56586c)) {
            bVar.a((Presenter) new com.kwad.sdk.d.kwai.a());
        }
        if (this.f56590g.a(getContext())) {
            bVar.a((Presenter) new f());
        }
        return bVar;
    }

    public void c() {
        this.f56589f.g();
    }

    public void d() {
        this.f56589f.h();
    }

    public void e() {
        com.kwad.sdk.d.kwai.b bVar = this.f56589f;
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
        com.kwad.sdk.d.kwai.c cVar = this.f56590g;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f56590g.c();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f56587d = adInteractionListener;
        com.kwad.sdk.d.kwai.c cVar = this.f56590g;
        if (cVar != null) {
            cVar.f56614b = adInteractionListener;
        }
    }
}
