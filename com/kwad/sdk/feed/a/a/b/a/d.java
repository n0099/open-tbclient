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
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private RCPVADFrameLayout f9824b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private AdTemplate g;
    private AdInfo h;
    private com.kwad.sdk.core.download.b.b i;
    private KsAppDownloadListener j;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.kwad.sdk.core.report.b.a(this.g, i, this.f9824b.getTouchCoords());
    }

    private KsAppDownloadListener e() {
        if (this.j == null) {
            this.j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.a.a.b.a.d.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    d.this.f.setText(com.kwad.sdk.core.response.b.a.w(d.this.h));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    d.this.f.setText(com.kwad.sdk.core.response.b.a.a(d.this.g));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    d.this.f.setText(com.kwad.sdk.core.response.b.a.w(d.this.h));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    d.this.f.setText(com.kwad.sdk.core.response.b.a.b());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    d.this.f.setText("下载中..." + i + "%");
                }
            };
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.g = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10454a).i;
        this.h = com.kwad.sdk.core.response.b.c.j(this.g);
        this.i = ((com.kwad.sdk.feed.a.a.a.b) this.f10454a).f9812b;
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) this.f10454a).d).a(com.kwad.sdk.core.response.b.c.q(this.g)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.c);
        String v = com.kwad.sdk.core.response.b.c.v(this.g);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.g)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.d.setText(v);
        String x = com.kwad.sdk.core.response.b.c.x((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10454a).i);
        if (ag.a(x)) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(x);
            this.e.setVisibility(0);
        }
        this.f.setText(com.kwad.sdk.core.response.b.a.w(this.h));
        if (com.kwad.sdk.core.response.b.a.y(this.h) && this.i != null) {
            this.i.a(e());
        }
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.i != null) {
            this.i.b(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9824b = (RCPVADFrameLayout) b(R.id.ksad_feed_item_root);
        this.c = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.d = (TextView) b(R.id.ksad_feed_item_author_name);
        this.e = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f = (TextView) b(R.id.ksad_ad_convert_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final int i = 0;
        if (view == this.c) {
            i = 55;
        } else if (view == this.d) {
            i = 82;
        } else if (view == this.f) {
            i = 83;
        }
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.g, new a.InterfaceC1094a() { // from class: com.kwad.sdk.feed.a.a.b.a.d.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1094a
            public void a() {
                d.this.a(i);
            }
        }, this.i);
    }
}
