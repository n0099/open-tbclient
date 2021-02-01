package com.kwad.sdk.feed.a.a.b.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RCPVADFrameLayout;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private RCPVADFrameLayout f9816b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private AdTemplate g;
    private AdInfo h;
    private com.kwad.sdk.core.download.b.b i;
    private KsAppDownloadListener j;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.kwad.sdk.core.report.b.a(this.g, i, this.f9816b.getTouchCoords());
    }

    private KsAppDownloadListener e() {
        if (this.j == null) {
            this.j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.a.a.b.a.a.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    a.this.f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    a.this.f.setText(com.kwad.sdk.core.response.b.a.w(a.this.h));
                    a.this.f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    a.this.f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_finish));
                    a.this.f.setText(com.kwad.sdk.core.response.b.a.a(a.this.g));
                    a.this.f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    a.this.f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    a.this.f.setText(com.kwad.sdk.core.response.b.a.w(a.this.h));
                    a.this.f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    a.this.f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_finish));
                    a.this.f.setText(com.kwad.sdk.core.response.b.a.b());
                    a.this.f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    a.this.f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    a.this.f.setText("下载中..." + i + "%");
                    a.this.f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f.getLayoutParams();
                    layoutParams.width = ao.a(a.this.o(), 76.0f);
                    a.this.f.setLayoutParams(layoutParams);
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
        String x = com.kwad.sdk.core.response.b.c.x(this.g);
        if (ag.a(x)) {
            this.c.setVisibility(8);
        } else {
            this.c.setText(x);
            this.c.setVisibility(0);
        }
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) this.f10454a).d).a(com.kwad.sdk.core.response.b.c.q(this.g)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.d);
        String v = com.kwad.sdk.core.response.b.c.v(this.g);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.g)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.e.setText(v);
        this.f.setTextColor(o().getResources().getColor(R.color.ksad_feed_covert_idle));
        this.f.setText(com.kwad.sdk.core.response.b.a.w(this.h));
        this.f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.width = -2;
        this.f.setLayoutParams(layoutParams);
        if (com.kwad.sdk.core.response.b.a.y(this.h) && this.i != null) {
            this.i.a(e());
        }
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
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
        this.f9816b = (RCPVADFrameLayout) b(R.id.ksad_feed_item_root);
        this.c = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f = (TextView) b(R.id.ksad_ad_convert_btn);
        this.d = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.e = (TextView) b(R.id.ksad_feed_item_author_name);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final int i = 0;
        if (view == this.d) {
            i = 55;
        } else if (view == this.e) {
            i = 82;
        } else if (view == this.f) {
            i = 83;
        }
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.g, new a.InterfaceC1092a() { // from class: com.kwad.sdk.feed.a.a.b.a.a.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1092a
            public void a() {
                a.this.a(i);
            }
        }, this.i);
    }
}
