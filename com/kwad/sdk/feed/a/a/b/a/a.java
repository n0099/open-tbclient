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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RCPVADFrameLayout f35093b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35094c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f35095d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35096e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35097f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f35098g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f35099h;
    public com.kwad.sdk.core.download.b.b i;
    public KsAppDownloadListener j;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.kwad.sdk.core.report.b.a(this.f35098g, i, this.f35093b.getTouchCoords());
    }

    private KsAppDownloadListener e() {
        if (this.j == null) {
            this.j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.a.a.b.a.a.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    a.this.f35097f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    a.this.f35097f.setText(com.kwad.sdk.core.response.b.a.w(a.this.f35099h));
                    a.this.f35097f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35097f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f35097f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    a.this.f35097f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_finish));
                    a.this.f35097f.setText(com.kwad.sdk.core.response.b.a.a(a.this.f35098g));
                    a.this.f35097f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35097f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f35097f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    a.this.f35097f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    a.this.f35097f.setText(com.kwad.sdk.core.response.b.a.w(a.this.f35099h));
                    a.this.f35097f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35097f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f35097f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    a.this.f35097f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_finish));
                    a.this.f35097f.setText(com.kwad.sdk.core.response.b.a.b());
                    a.this.f35097f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35097f.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.f35097f.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    a.this.f35097f.setTextColor(a.this.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                    TextView textView = a.this.f35097f;
                    textView.setText("下载中..." + i + "%");
                    a.this.f35097f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                    ViewGroup.LayoutParams layoutParams = a.this.f35097f.getLayoutParams();
                    layoutParams.width = ao.a(a.this.o(), 76.0f);
                    a.this.f35097f.setLayoutParams(layoutParams);
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
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i;
        this.f35098g = adTemplate;
        this.f35099h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).f35083b;
        String x = com.kwad.sdk.core.response.b.c.x(this.f35098g);
        if (ag.a(x)) {
            textView = this.f35094c;
            i = 8;
        } else {
            this.f35094c.setText(x);
            textView = this.f35094c;
            i = 0;
        }
        textView.setVisibility(i);
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).f36292d).a(com.kwad.sdk.core.response.b.c.q(this.f35098g)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f35095d);
        String v = com.kwad.sdk.core.response.b.c.v(this.f35098g);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.f35098g)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.f35096e.setText(v);
        this.f35097f.setTextColor(o().getResources().getColor(R.color.ksad_feed_covert_idle));
        this.f35097f.setText(com.kwad.sdk.core.response.b.a.w(this.f35099h));
        this.f35097f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
        ViewGroup.LayoutParams layoutParams = this.f35097f.getLayoutParams();
        layoutParams.width = -2;
        this.f35097f.setLayoutParams(layoutParams);
        if (com.kwad.sdk.core.response.b.a.y(this.f35099h) && (bVar = this.i) != null) {
            bVar.a(e());
        }
        this.f35095d.setOnClickListener(this);
        this.f35096e.setOnClickListener(this);
        this.f35097f.setOnClickListener(this);
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
        this.f35093b = (RCPVADFrameLayout) b(R.id.ksad_feed_item_root);
        this.f35094c = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f35097f = (TextView) b(R.id.ksad_ad_convert_btn);
        this.f35095d = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.f35096e = (TextView) b(R.id.ksad_feed_item_author_name);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final int i = view == this.f35095d ? 55 : view == this.f35096e ? 82 : view == this.f35097f ? 83 : 0;
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35098g, new a.InterfaceC0393a() { // from class: com.kwad.sdk.feed.a.a.b.a.a.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                a.this.a(i);
            }
        }, this.i);
    }
}
