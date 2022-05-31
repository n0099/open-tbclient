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
/* loaded from: classes5.dex */
public class a extends FrameLayout {
    @NonNull
    public AdTemplate a;
    public boolean b;
    public AdInfo c;
    public KsInterstitialAd.AdInteractionListener d;
    @NonNull
    public Context e;
    public com.kwad.sdk.d.kwai.b f;
    public com.kwad.sdk.d.kwai.c g;
    public ViewGroup h;
    public KsAdVideoPlayConfig i;
    public Dialog j;

    public a(@NonNull Context context) {
        this(context, null);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.e = context;
    }

    private b a(Context context, AdInfo adInfo, com.kwad.sdk.d.kwai.c cVar) {
        boolean a = cVar.a(this.e, adInfo);
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
        cVar.b = this.d;
        cVar.c = this.j;
        cVar.d = new com.kwad.sdk.core.download.a.b(adTemplate);
        cVar.g = this.i;
        cVar.f = this.b;
        cVar.i = new com.kwad.sdk.core.video.videoview.b(this.e);
        cVar.e = a(this.e, com.kwad.sdk.core.response.a.d.j(this.a), cVar);
        return cVar;
    }

    public void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, boolean z) {
        this.a = adTemplate;
        this.c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        adTemplate.realShowType = 2;
        this.i = ksAdVideoPlayConfig;
        this.j = dialog;
        this.b = z;
        this.d = adInteractionListener;
        this.g = a();
        if (this.f == null) {
            com.kwad.sdk.d.kwai.b b = b();
            this.f = b;
            b.c(this.h);
            this.f.a(this.g);
        }
    }

    @NonNull
    public com.kwad.sdk.d.kwai.b b() {
        com.kwad.sdk.d.kwai.b bVar = new com.kwad.sdk.d.kwai.b();
        bVar.a((Presenter) new com.kwad.sdk.d.kwai.d());
        if (com.kwad.sdk.core.response.a.a.P(this.c)) {
            bVar.a((Presenter) new g());
        }
        bVar.a((Presenter) new h());
        bVar.a((Presenter) new e());
        if (com.kwad.sdk.core.response.a.a.D(this.c)) {
            bVar.a((Presenter) new com.kwad.sdk.d.kwai.a());
        }
        if (this.g.a(getContext())) {
            bVar.a((Presenter) new f());
        }
        return bVar;
    }

    public void c() {
        this.f.g();
    }

    public void d() {
        this.f.h();
    }

    public void e() {
        com.kwad.sdk.d.kwai.b bVar = this.f;
        if (bVar != null) {
            bVar.j();
        }
    }

    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d042a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        com.kwad.sdk.d.kwai.c cVar = this.g;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g.c();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.d = adInteractionListener;
        com.kwad.sdk.d.kwai.c cVar = this.g;
        if (cVar != null) {
            cVar.b = adInteractionListener;
        }
    }
}
