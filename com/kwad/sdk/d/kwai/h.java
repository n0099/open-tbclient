package com.kwad.sdk.d.kwai;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class h extends b {
    public static int g = 4;
    public Context a;
    public c b;
    public AdInfo c;
    public AdTemplate d;
    public a e = new a();
    public com.kwad.sdk.core.download.a.b f;

    /* loaded from: classes5.dex */
    public static class a {
        public ImageView a;
        public TextView b;
        public TextView c;
    }

    public static void a(Context context, a aVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.a;
        String au = com.kwad.sdk.core.response.a.a.au(adInfo);
        if (TextUtils.isEmpty(au)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080b9f);
            KSImageLoader.loadWithRadius(imageView, au, adTemplate, g);
        }
        TextView textView = aVar.b;
        TextView textView2 = aVar.c;
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.u(adInfo)) ? com.kwad.sdk.core.response.a.a.u(adInfo) : !TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText) ? adInfo.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        textView2.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
    }

    private void a(final com.kwad.sdk.d.a.b bVar) {
        this.f = new com.kwad.sdk.core.download.a.b(this.d, null, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.d.kwai.h.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                bVar.a(com.kwad.sdk.core.response.a.a.b(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                bVar.a(com.kwad.sdk.core.response.a.a.A(h.this.c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                bVar.a(com.kwad.sdk.core.response.a.a.a(h.this.d), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                bVar.a(com.kwad.sdk.core.response.a.a.A(h.this.c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                bVar.a(com.kwad.sdk.core.response.a.a.m(h.this.c), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                bVar.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    public static void b(Context context, a aVar, AdInfo adInfo, AdTemplate adTemplate) {
        TextView textView = aVar.b;
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.t(adInfo)) ? com.kwad.sdk.core.response.a.a.t(adInfo) : !TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText) ? adInfo.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        String au = com.kwad.sdk.core.response.a.a.au(adInfo);
        ImageView imageView = aVar.a;
        if (TextUtils.isEmpty(au)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080b9f);
            KSImageLoader.loadWithRadius(imageView, au, adTemplate, g);
            imageView.setVisibility(0);
        }
        aVar.c.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.d = adTemplate;
        this.c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.e.a = (ImageView) this.b.e.findViewById(R.id.obfuscated_res_0x7f091030);
        this.e.b = (TextView) this.b.e.findViewById(R.id.obfuscated_res_0x7f091034);
        this.e.c = (TextView) this.b.e.findViewById(R.id.obfuscated_res_0x7f09102b);
        if (com.kwad.sdk.core.response.a.a.B(this.c)) {
            b(this.a, this.e, this.c, this.d);
            a(this.b.e);
        } else {
            a(this.a, this.e, this.c, this.d);
        }
        this.b.e.a(com.kwad.sdk.core.response.a.a.A(this.c), 0);
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
