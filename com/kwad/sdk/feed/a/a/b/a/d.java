package com.kwad.sdk.feed.a.a.b.a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.RCPVADFrameLayout;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RCPVADFrameLayout f35583b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35584c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35585d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35586e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35587f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f35588g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f35589h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35590i;
    public KsAppDownloadListener j;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.kwad.sdk.core.report.b.a(this.f35588g, i2, this.f35583b.getTouchCoords());
    }

    private KsAppDownloadListener e() {
        if (this.j == null) {
            this.j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.a.a.b.a.d.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    d.this.f35587f.setText(com.kwad.sdk.core.response.b.a.w(d.this.f35589h));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    d.this.f35587f.setText(com.kwad.sdk.core.response.b.a.a(d.this.f35588g));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    d.this.f35587f.setText(com.kwad.sdk.core.response.b.a.w(d.this.f35589h));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    d.this.f35587f.setText(com.kwad.sdk.core.response.b.a.b());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    TextView textView = d.this.f35587f;
                    textView.setText("下载中..." + i2 + "%");
                }
            };
        }
        return this.j;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i2;
        com.kwad.sdk.core.download.b.b bVar;
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a).f36810i;
        this.f35588g = adTemplate;
        this.f35589h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a;
        this.f35590i = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35552b;
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f36805d).a(com.kwad.sdk.core.response.b.c.q(this.f35588g)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f35584c);
        String v = com.kwad.sdk.core.response.b.c.v(this.f35588g);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.f35588g)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.f35585d.setText(v);
        String x = com.kwad.sdk.core.response.b.c.x((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a).f36810i);
        if (ag.a(x)) {
            textView = this.f35586e;
            i2 = 8;
        } else {
            this.f35586e.setText(x);
            textView = this.f35586e;
            i2 = 0;
        }
        textView.setVisibility(i2);
        this.f35587f.setText(com.kwad.sdk.core.response.b.a.w(this.f35589h));
        if (com.kwad.sdk.core.response.b.a.y(this.f35589h) && (bVar = this.f35590i) != null) {
            bVar.a(e());
        }
        this.f35584c.setOnClickListener(this);
        this.f35585d.setOnClickListener(this);
        this.f35587f.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.download.b.b bVar = this.f35590i;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35583b = (RCPVADFrameLayout) b(R.id.ksad_feed_item_root);
        this.f35584c = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.f35585d = (TextView) b(R.id.ksad_feed_item_author_name);
        this.f35586e = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f35587f = (TextView) b(R.id.ksad_ad_convert_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final int i2 = view == this.f35584c ? 55 : view == this.f35585d ? 82 : view == this.f35587f ? 83 : 0;
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35588g, new a.InterfaceC0382a() { // from class: com.kwad.sdk.feed.a.a.b.a.d.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                d.this.a(i2);
            }
        }, this.f35590i);
    }
}
