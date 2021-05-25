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
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class a extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f33185f;

    /* renamed from: g  reason: collision with root package name */
    public RatioFrameLayout f33186g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33187h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f33188i;
    public com.kwad.sdk.core.download.b.b j;
    public ImageView k;
    public List<Integer> l;
    public com.kwad.sdk.core.video.videoview.b m;
    public j n;
    public DownloadProgressView o;
    public boolean p;

    public a(@NonNull Context context) {
        super(context);
        this.p = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.l;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.l.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f33198a, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar, boolean z) {
        if (bVar != null) {
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f33199b);
            this.n.setAutoRelease(false);
            AdVideoPlayerViewCache.a().a(a2, this.m);
            com.kwad.sdk.core.download.b.a.b(an.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f33198a, new a.InterfaceC0364a() { // from class: com.kwad.sdk.feed.widget.a.4
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                public void a() {
                    a.this.k();
                }
            }, this.j, z);
        }
    }

    private void e() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.m(this.f33199b));
        textView.setText(com.kwad.sdk.core.response.b.a.u(this.f33199b));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void f() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_app_icon);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.o(this.f33199b));
        imageView.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.b.a.n(this.f33199b), ((com.kwad.sdk.feed.widget.base.a) this).f33198a, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.m(this.f33199b));
        this.o.a(((com.kwad.sdk.feed.widget.base.a) this).f33198a);
        this.o.setOnClickListener(this);
        com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f33198a, null, this.o.getAppDownloadListener());
        this.j = bVar;
        bVar.c(this.o.getAppDownloadListener());
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        this.p = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.b.a.Q(this.f33199b).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.k;
            i2 = 8;
        } else {
            this.k.setImageDrawable(null);
            KSImageLoader.loadImage(this.k, a2, ((com.kwad.sdk.feed.widget.base.a) this).f33198a);
            imageView = this.k;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.l = com.kwad.sdk.core.response.b.a.I(this.f33199b);
        com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(this.f33201d);
        this.m = bVar;
        bVar.setTag(this.l);
        String a3 = com.kwad.sdk.core.response.b.a.a(this.f33199b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        this.m.a(new c.a().a(a3).b(com.kwad.sdk.core.response.b.d.b(com.kwad.sdk.core.response.b.c.h(((com.kwad.sdk.feed.widget.base.a) this).f33198a))).a(((com.kwad.sdk.feed.widget.base.a) this).f33198a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(com.kwad.sdk.core.response.b.a.i(this.f33199b), System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.m.setVideoSoundEnable(this.p);
        j jVar = new j(this.f33201d, ((com.kwad.sdk.feed.widget.base.a) this).f33198a, this.m);
        this.n = jVar;
        jVar.setVideoPlayCallback(new a.InterfaceC0371a() { // from class: com.kwad.sdk.feed.widget.a.2
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
            public void a() {
                com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) a.this).f33198a);
                if (a.this.m == null || a.this.m.getParent() != a.this.f33186g) {
                    return;
                }
                a.this.m.setVideoSoundEnable(a.this.p);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
            public void a(long j) {
                a.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
            public void b() {
                com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) a.this).f33198a);
            }
        });
        this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.m.setController(this.n);
        if (this.f33186g.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.f33186g;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.f33186g.setTag(null);
        }
        this.f33186g.addView(this.m);
        this.f33186g.setTag(this.m);
        this.f33186g.setClickable(true);
        this.f33186g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!a.this.m.d()) {
                    a aVar = a.this;
                    aVar.a(aVar.m, false);
                    return;
                }
                a.this.m.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.b(com.kwad.sdk.core.response.b.a.i(a.this.f33199b), System.currentTimeMillis()));
                a.this.m.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f33185f.setText(com.kwad.sdk.core.response.b.a.m(this.f33199b));
        this.f33188i.a(adTemplate);
        if (com.kwad.sdk.core.response.b.a.v(this.f33199b)) {
            f();
        } else {
            e();
        }
        this.f33187h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f33185f = (TextView) findViewById(R.id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.f33186g = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.f33187h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.k = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.f33188i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.o = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void d() {
        super.d();
        if (this.p) {
            com.kwad.sdk.utils.b.a().a(false);
            if (com.kwad.sdk.utils.b.a().b()) {
                this.p = false;
                this.m.setVideoSoundEnable(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33187h) {
            l();
        } else {
            a(this.m, view == this.o);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar;
        super.onWindowFocusChanged(z);
        if (!z || (bVar = this.m) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) bVar.getParent();
        if (this.m.getParent() != this.f33186g) {
            viewGroup.removeView(this.m);
            if (this.f33186g.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.f33186g;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.f33186g.setTag(null);
            }
            this.f33186g.addView(this.m);
            this.f33186g.setTag(this.m);
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f33199b);
            this.m.setVideoSoundEnable(this.p);
            this.n.setVideoPlayCallback(new a.InterfaceC0371a() { // from class: com.kwad.sdk.feed.widget.a.1
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
                public void a() {
                    com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) a.this).f33198a);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
                public void a(long j) {
                    a.this.a(j);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0371a
                public void b() {
                    com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) a.this).f33198a);
                }
            });
            this.n.n();
            this.n.setAutoRelease(true);
            AdVideoPlayerViewCache.a().a(a2);
        }
    }
}
