package com.kwad.sdk.d.kwai;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class h extends b {

    /* renamed from: g  reason: collision with root package name */
    public static int f40289g = 4;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c f40290b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f40291c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f40292d;

    /* renamed from: e  reason: collision with root package name */
    public a f40293e = new a();

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40294f;

    /* loaded from: classes7.dex */
    public static class a {
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f40297b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f40298c;
    }

    public static void a(Context context, a aVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.a;
        String au = com.kwad.sdk.core.response.a.a.au(adInfo);
        if (TextUtils.isEmpty(au)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080b9a);
            KSImageLoader.loadWithRadius(imageView, au, adTemplate, f40289g);
        }
        TextView textView = aVar.f40297b;
        TextView textView2 = aVar.f40298c;
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.u(adInfo)) ? com.kwad.sdk.core.response.a.a.u(adInfo) : !TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText) ? adInfo.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        textView2.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
    }

    private void a(final com.kwad.sdk.d.a.b bVar) {
        this.f40294f = new com.kwad.sdk.core.download.a.b(this.f40292d, null, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.d.kwai.h.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                bVar.a(com.kwad.sdk.core.response.a.a.b(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                bVar.a(com.kwad.sdk.core.response.a.a.A(h.this.f40291c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                bVar.a(com.kwad.sdk.core.response.a.a.a(h.this.f40292d), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                bVar.a(com.kwad.sdk.core.response.a.a.A(h.this.f40291c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                bVar.a(com.kwad.sdk.core.response.a.a.m(h.this.f40291c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                bVar.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    public static void b(Context context, a aVar, AdInfo adInfo, AdTemplate adTemplate) {
        TextView textView = aVar.f40297b;
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.t(adInfo)) ? com.kwad.sdk.core.response.a.a.t(adInfo) : !TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText) ? adInfo.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        String au = com.kwad.sdk.core.response.a.a.au(adInfo);
        ImageView imageView = aVar.a;
        if (TextUtils.isEmpty(au)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080b9a);
            KSImageLoader.loadWithRadius(imageView, au, adTemplate, f40289g);
            imageView.setVisibility(0);
        }
        aVar.f40298c.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.f40290b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f40292d = adTemplate;
        this.f40291c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f40293e.a = (ImageView) this.f40290b.f40250e.findViewById(R.id.obfuscated_res_0x7f091036);
        this.f40293e.f40297b = (TextView) this.f40290b.f40250e.findViewById(R.id.obfuscated_res_0x7f09103a);
        this.f40293e.f40298c = (TextView) this.f40290b.f40250e.findViewById(R.id.obfuscated_res_0x7f091031);
        if (com.kwad.sdk.core.response.a.a.B(this.f40291c)) {
            b(this.a, this.f40293e, this.f40291c, this.f40292d);
            a(this.f40290b.f40250e);
        } else {
            a(this.a, this.f40293e, this.f40291c, this.f40292d);
        }
        this.f40290b.f40250e.a(com.kwad.sdk.core.response.a.a.A(this.f40291c), 0);
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
