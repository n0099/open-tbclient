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
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RCPVADFrameLayout f35208b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35209c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35210d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35211e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35212f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f35213g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f35214h;
    public com.kwad.sdk.core.download.b.b i;
    public KsAppDownloadListener j;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.kwad.sdk.core.report.b.a(this.f35213g, i, this.f35208b.getTouchCoords());
    }

    private KsAppDownloadListener e() {
        if (this.j == null) {
            this.j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.a.a.b.a.d.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    d.this.f35212f.setText(com.kwad.sdk.core.response.b.a.w(d.this.f35214h));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    d.this.f35212f.setText(com.kwad.sdk.core.response.b.a.a(d.this.f35213g));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    d.this.f35212f.setText(com.kwad.sdk.core.response.b.a.w(d.this.f35214h));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    d.this.f35212f.setText(com.kwad.sdk.core.response.b.a.b());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    TextView textView = d.this.f35212f;
                    textView.setText("下载中..." + i + "%");
                }
            };
        }
        return this.j;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i;
        com.kwad.sdk.core.download.b.b bVar;
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36392a).i;
        this.f35213g = adTemplate;
        this.f35214h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36392a;
        this.i = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f35178b;
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f36387d).a(com.kwad.sdk.core.response.b.c.q(this.f35213g)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f35209c);
        String v = com.kwad.sdk.core.response.b.c.v(this.f35213g);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.f35213g)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.f35210d.setText(v);
        String x = com.kwad.sdk.core.response.b.c.x((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36392a).i);
        if (ag.a(x)) {
            textView = this.f35211e;
            i = 8;
        } else {
            this.f35211e.setText(x);
            textView = this.f35211e;
            i = 0;
        }
        textView.setVisibility(i);
        this.f35212f.setText(com.kwad.sdk.core.response.b.a.w(this.f35214h));
        if (com.kwad.sdk.core.response.b.a.y(this.f35214h) && (bVar = this.i) != null) {
            bVar.a(e());
        }
        this.f35209c.setOnClickListener(this);
        this.f35210d.setOnClickListener(this);
        this.f35212f.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.download.b.b bVar = this.i;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35208b = (RCPVADFrameLayout) b(R.id.ksad_feed_item_root);
        this.f35209c = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.f35210d = (TextView) b(R.id.ksad_feed_item_author_name);
        this.f35211e = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f35212f = (TextView) b(R.id.ksad_ad_convert_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final int i = view == this.f35209c ? 55 : view == this.f35210d ? 82 : view == this.f35212f ? 83 : 0;
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35213g, new a.InterfaceC0396a() { // from class: com.kwad.sdk.feed.a.a.b.a.d.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
            public void a() {
                d.this.a(i);
            }
        }, this.i);
    }
}
