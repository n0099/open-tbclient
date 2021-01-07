package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class a extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    private TextView f;
    private RatioFrameLayout g;
    private ImageView h;
    private KsLogoView i;
    private com.kwad.sdk.core.download.b.b j;
    private TextProgressBar k;
    private TextView l;
    private ImageView m;
    private List<Integer> n;
    private com.kwad.sdk.core.video.videoview.b o;
    private j p;
    private View q;
    private boolean r;
    private KsAppDownloadListener s;

    public a(@NonNull Context context) {
        super(context);
        this.r = false;
        this.s = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.widget.a.4
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                a.this.k.a(com.kwad.sdk.core.response.b.a.a(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                a.this.l.setText(com.kwad.sdk.core.response.b.a.w(a.this.f10161b));
                a.this.l.setVisibility(0);
                a.this.k.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                a.this.l.setVisibility(8);
                a.this.k.setVisibility(0);
                a.this.k.a(com.kwad.sdk.core.response.b.a.a(a.this.f10160a), a.this.k.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                a.this.l.setText(com.kwad.sdk.core.response.b.a.w(a.this.f10161b));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                a.this.l.setVisibility(8);
                a.this.k.setVisibility(0);
                a.this.k.a(com.kwad.sdk.core.response.b.a.b(), a.this.k.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                a.this.l.setVisibility(8);
                a.this.k.setVisibility(0);
                a.this.k.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        if (this.n == null || this.n.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.n.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.b.b(this.f10160a, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        if (bVar != null) {
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f10161b);
            this.p.setAutoRelease(false);
            AdVideoPlayerViewCache.a().a(a2, this.o);
            com.kwad.sdk.core.download.b.a.b(ao.a(this), this.f10160a, new a.InterfaceC1105a() { // from class: com.kwad.sdk.feed.widget.a.5
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1105a
                public void a() {
                    a.this.k();
                }
            }, this.j);
        }
    }

    private void f() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f10161b));
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f10161b));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.q(this.f10161b));
        KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f10161b), this.f10160a, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f10161b));
        this.l = (TextView) findViewById(R.id.ksad_app_download_before);
        this.l.setText(com.kwad.sdk.core.response.b.a.w(this.f10161b));
        this.l.setVisibility(0);
        this.l.setOnClickListener(this);
        this.k = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k.setTextDimen(ao.a(getContext(), 11.0f));
        this.k.a(-1, -45056);
        this.k.setVisibility(8);
        this.k.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.j = new com.kwad.sdk.core.download.b.b(this.f10160a, null, this.s);
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.r = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.b.a.U(this.f10161b).a();
        if (TextUtils.isEmpty(a2)) {
            this.m.setVisibility(8);
        } else {
            this.m.setImageDrawable(null);
            KSImageLoader.loadImage(this.m, a2, this.f10160a);
            this.m.setVisibility(0);
        }
        this.n = com.kwad.sdk.core.response.b.a.M(this.f10161b);
        this.o = new com.kwad.sdk.core.video.videoview.b(this.d);
        this.o.setTag(this.n);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.f10161b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.o.a(new d.a().a(a3).a(this.f10160a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f10161b), System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.o.setVideoSoundEnable(this.r);
        this.p = new j(this.d, this.f10160a, this.o);
        this.p.setVideoPlayCallback(new a.InterfaceC1118a() { // from class: com.kwad.sdk.feed.widget.a.2
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1118a
            public void a() {
                com.kwad.sdk.core.report.b.h(a.this.f10160a);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1118a
            public void a(long j) {
                a.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1118a
            public void b() {
                com.kwad.sdk.core.report.b.i(a.this.f10160a);
            }
        });
        this.p.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.o.setController(this.p);
        if (this.g.getTag() != null) {
            this.g.removeView((View) this.g.getTag());
            this.g.setTag(null);
        }
        this.g.addView(this.o);
        this.g.setTag(this.o);
        this.g.setClickable(true);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!a.this.o.d()) {
                    a.this.a(a.this.o);
                    return;
                }
                a.this.o.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(a.this.f10161b), System.currentTimeMillis()));
                a.this.o.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f.setText(com.kwad.sdk.core.response.b.a.n(this.f10161b));
        this.i.a(adTemplate);
        if (com.kwad.sdk.core.response.b.a.y(this.f10161b)) {
            g();
        } else {
            f();
        }
        this.h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected void c() {
        this.f = (TextView) findViewById(R.id.ksad_ad_desc);
        this.q = findViewById(R.id.ksad_app_download_cover);
        this.g = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.g.setRatio(0.56f);
        this.h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.m = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.feed.widget.base.a
    public void d() {
        super.d();
        if (this.r) {
            com.kwad.sdk.utils.b.a().a(false);
            if (com.kwad.sdk.utils.b.a().b()) {
                this.r = false;
                this.o.setVideoSoundEnable(this.r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.feed.widget.base.a
    public void e() {
        super.e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.j, view == this.q);
        a(this.o);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.o == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.o.getParent();
        if (this.o.getParent() != this.g) {
            viewGroup.removeView(this.o);
            if (this.g.getTag() != null) {
                this.g.removeView((View) this.g.getTag());
                this.g.setTag(null);
            }
            this.g.addView(this.o);
            this.g.setTag(this.o);
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f10161b);
            this.o.setVideoSoundEnable(this.r);
            this.p.setVideoPlayCallback(new a.InterfaceC1118a() { // from class: com.kwad.sdk.feed.widget.a.1
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1118a
                public void a() {
                    com.kwad.sdk.core.report.b.h(a.this.f10160a);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1118a
                public void a(long j) {
                    a.this.a(j);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1118a
                public void b() {
                    com.kwad.sdk.core.report.b.i(a.this.f10160a);
                }
            });
            this.p.m();
            this.p.setAutoRelease(true);
            AdVideoPlayerViewCache.a().a(a2);
        }
    }
}
