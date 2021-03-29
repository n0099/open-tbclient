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
/* loaded from: classes6.dex */
public abstract class a extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f34901f;

    /* renamed from: g  reason: collision with root package name */
    public RatioFrameLayout f34902g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34903h;
    public KsLogoView i;
    public com.kwad.sdk.core.download.b.b j;
    public TextProgressBar k;
    public TextView l;
    public ImageView m;
    public List<Integer> n;
    public com.kwad.sdk.core.video.videoview.b o;
    public j p;
    public View q;
    public boolean r;
    public KsAppDownloadListener s;

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
                a.this.l.setText(com.kwad.sdk.core.response.b.a.w(a.this.f34914b));
                a.this.l.setVisibility(0);
                a.this.k.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                a.this.l.setVisibility(8);
                a.this.k.setVisibility(0);
                a.this.k.a(com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) a.this).f34913a), a.this.k.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                a.this.l.setText(com.kwad.sdk.core.response.b.a.w(a.this.f34914b));
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
        List<Integer> list = this.n;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.n.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f34913a, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        if (bVar != null) {
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f34914b);
            this.p.setAutoRelease(false);
            AdVideoPlayerViewCache.a().a(a2, this.o);
            com.kwad.sdk.core.download.b.a.b(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f34913a, new a.InterfaceC0379a() { // from class: com.kwad.sdk.feed.widget.a.5
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    a.this.k();
                }
            }, this.j);
        }
    }

    private void f() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f34914b));
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f34914b));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.q(this.f34914b));
        KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f34914b), ((com.kwad.sdk.feed.widget.base.a) this).f34913a, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f34914b));
        TextView textView = (TextView) findViewById(R.id.ksad_app_download_before);
        this.l = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f34914b));
        this.l.setVisibility(0);
        this.l.setOnClickListener(this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 11.0f));
        this.k.a(-1, -45056);
        this.k.setVisibility(8);
        this.k.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.j = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f34913a, null, this.s);
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        this.r = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.b.a.U(this.f34914b).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.m;
            i = 8;
        } else {
            this.m.setImageDrawable(null);
            KSImageLoader.loadImage(this.m, a2, ((com.kwad.sdk.feed.widget.base.a) this).f34913a);
            imageView = this.m;
            i = 0;
        }
        imageView.setVisibility(i);
        this.n = com.kwad.sdk.core.response.b.a.M(this.f34914b);
        com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(this.f34916d);
        this.o = bVar;
        bVar.setTag(this.n);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.f34914b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.o.a(new d.a().a(a3).a(((com.kwad.sdk.feed.widget.base.a) this).f34913a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f34914b), System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.o.setVideoSoundEnable(this.r);
        j jVar = new j(this.f34916d, ((com.kwad.sdk.feed.widget.base.a) this).f34913a, this.o);
        this.p = jVar;
        jVar.setVideoPlayCallback(new a.InterfaceC0392a() { // from class: com.kwad.sdk.feed.widget.a.2
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void a() {
                com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) a.this).f34913a);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void a(long j) {
                a.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
            public void b() {
                com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) a.this).f34913a);
            }
        });
        this.p.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.o.setController(this.p);
        if (this.f34902g.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.f34902g;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.f34902g.setTag(null);
        }
        this.f34902g.addView(this.o);
        this.f34902g.setTag(this.o);
        this.f34902g.setClickable(true);
        this.f34902g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!a.this.o.d()) {
                    a aVar = a.this;
                    aVar.a(aVar.o);
                    return;
                }
                a.this.o.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(a.this.f34914b), System.currentTimeMillis()));
                a.this.o.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f34901f.setText(com.kwad.sdk.core.response.b.a.n(this.f34914b));
        this.i.a(adTemplate);
        if (com.kwad.sdk.core.response.b.a.y(this.f34914b)) {
            g();
        } else {
            f();
        }
        this.f34903h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f34901f = (TextView) findViewById(R.id.ksad_ad_desc);
        this.q = findViewById(R.id.ksad_app_download_cover);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.f34902g = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.f34903h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.m = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void d() {
        super.d();
        if (this.r) {
            com.kwad.sdk.utils.b.a().a(false);
            if (com.kwad.sdk.utils.b.a().b()) {
                this.r = false;
                this.o.setVideoSoundEnable(false);
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void e() {
        super.e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34903h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.j, view == this.q);
        a(this.o);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar;
        super.onWindowFocusChanged(z);
        if (!z || (bVar = this.o) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) bVar.getParent();
        if (this.o.getParent() != this.f34902g) {
            viewGroup.removeView(this.o);
            if (this.f34902g.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.f34902g;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.f34902g.setTag(null);
            }
            this.f34902g.addView(this.o);
            this.f34902g.setTag(this.o);
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f34914b);
            this.o.setVideoSoundEnable(this.r);
            this.p.setVideoPlayCallback(new a.InterfaceC0392a() { // from class: com.kwad.sdk.feed.widget.a.1
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
                public void a() {
                    com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) a.this).f34913a);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
                public void a(long j) {
                    a.this.a(j);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0392a
                public void b() {
                    com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) a.this).f34913a);
                }
            });
            this.p.m();
            this.p.setAutoRelease(true);
            AdVideoPlayerViewCache.a().a(a2);
        }
    }
}
