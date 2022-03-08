package com.kwad.sdk.d.kwai;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class h extends b {

    /* renamed from: g  reason: collision with root package name */
    public static int f55224g = 4;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c f55225b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f55226c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f55227d;

    /* renamed from: e  reason: collision with root package name */
    public a f55228e = new a();

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55229f;

    /* loaded from: classes8.dex */
    public static class a {
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55232b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55233c;
    }

    public static void a(Context context, a aVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.a;
        String au = com.kwad.sdk.core.response.a.a.au(adInfo);
        if (TextUtils.isEmpty(au)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadWithRadius(imageView, au, adTemplate, f55224g);
        }
        TextView textView = aVar.f55232b;
        TextView textView2 = aVar.f55233c;
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.u(adInfo)) ? com.kwad.sdk.core.response.a.a.u(adInfo) : !TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText) ? adInfo.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        textView2.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
    }

    private void a(final com.kwad.sdk.d.a.b bVar) {
        this.f55229f = new com.kwad.sdk.core.download.a.b(this.f55227d, null, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.d.kwai.h.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                bVar.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                bVar.a(com.kwad.sdk.core.response.a.a.A(h.this.f55226c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                bVar.a(com.kwad.sdk.core.response.a.a.a(h.this.f55227d), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                bVar.a(com.kwad.sdk.core.response.a.a.A(h.this.f55226c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                bVar.a(com.kwad.sdk.core.response.a.a.m(h.this.f55226c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                bVar.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    public static void b(Context context, a aVar, AdInfo adInfo, AdTemplate adTemplate) {
        TextView textView = aVar.f55232b;
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.t(adInfo)) ? com.kwad.sdk.core.response.a.a.t(adInfo) : !TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText) ? adInfo.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        String au = com.kwad.sdk.core.response.a.a.au(adInfo);
        ImageView imageView = aVar.a;
        if (TextUtils.isEmpty(au)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadWithRadius(imageView, au, adTemplate, f55224g);
            imageView.setVisibility(0);
        }
        aVar.f55233c.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.f55225b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f55227d = adTemplate;
        this.f55226c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f55228e.a = (ImageView) this.f55225b.f55179e.findViewById(R.id.ksad_app_icon);
        this.f55228e.f55232b = (TextView) this.f55225b.f55179e.findViewById(R.id.ksad_app_title);
        this.f55228e.f55233c = (TextView) this.f55225b.f55179e.findViewById(R.id.ksad_app_desc);
        if (com.kwad.sdk.core.response.a.a.B(this.f55226c)) {
            b(this.a, this.f55228e, this.f55226c, this.f55227d);
            a(this.f55225b.f55179e);
        } else {
            a(this.a, this.f55228e, this.f55226c, this.f55227d);
        }
        this.f55225b.f55179e.a(com.kwad.sdk.core.response.a.a.A(this.f55226c), 0);
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
