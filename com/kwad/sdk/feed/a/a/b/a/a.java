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
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RCPVADFrameLayout f35464b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35465c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f35466d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35467e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35468f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f35469g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f35470h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35471i;
    public KsAppDownloadListener j;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.kwad.sdk.core.report.b.a(this.f35469g, i2, this.f35464b.getTouchCoords());
    }

    private KsAppDownloadListener e() {
        if (this.j == null) {
            this.j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.a.a.b.a.a.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    a.this.f35468f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    a.this.f35468f.setText(com.kwad.sdk.core.response.b.a.w(a.this.f35470h));
                    a.this.f35468f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35468f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f35468f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    a.this.f35468f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_finish));
                    a.this.f35468f.setText(com.kwad.sdk.core.response.b.a.a(a.this.f35469g));
                    a.this.f35468f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35468f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f35468f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    a.this.f35468f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    a.this.f35468f.setText(com.kwad.sdk.core.response.b.a.w(a.this.f35470h));
                    a.this.f35468f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35468f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f35468f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    a.this.f35468f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_finish));
                    a.this.f35468f.setText(com.kwad.sdk.core.response.b.a.b());
                    a.this.f35468f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35468f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f35468f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    a.this.f35468f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    TextView textView = a.this.f35468f;
                    textView.setText("下载中..." + i2 + "%");
                    a.this.f35468f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35468f.getLayoutParams();
                    layoutParams.width = ao.a(a.this.o(), 76.0f);
                    a.this.f35468f.setLayoutParams(layoutParams);
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
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a).f36712i;
        this.f35469g = adTemplate;
        this.f35470h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f35471i = ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a).f35454b;
        String x = com.kwad.sdk.core.response.b.c.x(this.f35469g);
        if (ag.a(x)) {
            textView = this.f35465c;
            i2 = 8;
        } else {
            this.f35465c.setText(x);
            textView = this.f35465c;
            i2 = 0;
        }
        textView.setVisibility(i2);
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a).f36707d).a(com.kwad.sdk.core.response.b.c.q(this.f35469g)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f35466d);
        String v = com.kwad.sdk.core.response.b.c.v(this.f35469g);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.f35469g)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.f35467e.setText(v);
        this.f35468f.setTextColor(o().getResources().getColor(R.color.ksad_feed_covert_idle));
        this.f35468f.setText(com.kwad.sdk.core.response.b.a.w(this.f35470h));
        this.f35468f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
        ViewGroup.LayoutParams layoutParams = this.f35468f.getLayoutParams();
        layoutParams.width = -2;
        this.f35468f.setLayoutParams(layoutParams);
        if (com.kwad.sdk.core.response.b.a.y(this.f35470h) && (bVar = this.f35471i) != null) {
            bVar.a(e());
        }
        this.f35466d.setOnClickListener(this);
        this.f35467e.setOnClickListener(this);
        this.f35468f.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.download.b.b bVar = this.f35471i;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35464b = (RCPVADFrameLayout) b(R.id.ksad_feed_item_root);
        this.f35465c = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f35468f = (TextView) b(R.id.ksad_ad_convert_btn);
        this.f35466d = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.f35467e = (TextView) b(R.id.ksad_feed_item_author_name);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final int i2 = view == this.f35466d ? 55 : view == this.f35467e ? 82 : view == this.f35468f ? 83 : 0;
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35469g, new a.InterfaceC0379a() { // from class: com.kwad.sdk.feed.a.a.b.a.a.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                a.this.a(i2);
            }
        }, this.f35471i);
    }
}
