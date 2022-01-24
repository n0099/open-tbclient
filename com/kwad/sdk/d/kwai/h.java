package com.kwad.sdk.d.kwai;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class h extends b {

    /* renamed from: g  reason: collision with root package name */
    public static int f56707g = 4;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c f56708b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f56709c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f56710d;

    /* renamed from: e  reason: collision with root package name */
    public a f56711e = new a();

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56712f;

    /* loaded from: classes3.dex */
    public static class a {
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56715b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56716c;
    }

    public static void a(Context context, a aVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.a;
        String au = com.kwad.sdk.core.response.a.a.au(adInfo);
        if (TextUtils.isEmpty(au)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadWithRadius(imageView, au, adTemplate, f56707g);
        }
        TextView textView = aVar.f56715b;
        TextView textView2 = aVar.f56716c;
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.u(adInfo)) ? com.kwad.sdk.core.response.a.a.u(adInfo) : !TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText) ? adInfo.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        textView2.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
    }

    private void a(final com.kwad.sdk.d.a.b bVar) {
        this.f56712f = new com.kwad.sdk.core.download.a.b(this.f56710d, null, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.d.kwai.h.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                bVar.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                bVar.a(com.kwad.sdk.core.response.a.a.A(h.this.f56709c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                bVar.a(com.kwad.sdk.core.response.a.a.a(h.this.f56710d), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                bVar.a(com.kwad.sdk.core.response.a.a.A(h.this.f56709c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                bVar.a(com.kwad.sdk.core.response.a.a.m(h.this.f56709c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                bVar.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    public static void b(Context context, a aVar, AdInfo adInfo, AdTemplate adTemplate) {
        TextView textView = aVar.f56715b;
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.t(adInfo)) ? com.kwad.sdk.core.response.a.a.t(adInfo) : !TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText) ? adInfo.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        String au = com.kwad.sdk.core.response.a.a.au(adInfo);
        ImageView imageView = aVar.a;
        if (TextUtils.isEmpty(au)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadWithRadius(imageView, au, adTemplate, f56707g);
            imageView.setVisibility(0);
        }
        aVar.f56716c.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.f56708b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f56710d = adTemplate;
        this.f56709c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56711e.a = (ImageView) this.f56708b.f56662e.findViewById(R.id.ksad_app_icon);
        this.f56711e.f56715b = (TextView) this.f56708b.f56662e.findViewById(R.id.ksad_app_title);
        this.f56711e.f56716c = (TextView) this.f56708b.f56662e.findViewById(R.id.ksad_app_desc);
        if (com.kwad.sdk.core.response.a.a.B(this.f56709c)) {
            b(this.a, this.f56711e, this.f56709c, this.f56710d);
            a(this.f56708b.f56662e);
        } else {
            a(this.a, this.f56711e, this.f56709c, this.f56710d);
        }
        this.f56708b.f56662e.a(com.kwad.sdk.core.response.a.a.A(this.f56709c), 0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.a = q();
    }
}
