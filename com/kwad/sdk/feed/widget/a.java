package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class a extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public a.b a;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55435f;

    /* renamed from: g  reason: collision with root package name */
    public RatioFrameLayout f55436g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55437h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f55438i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55439j;
    public ImageView k;
    public List<Integer> l;
    public com.kwad.sdk.core.video.videoview.b m;
    public j n;
    public DownloadProgressView o;
    public boolean p;
    public volatile boolean q;
    public com.kwad.sdk.widget.k r;
    public final a.InterfaceC2107a s;

    public a(@NonNull Context context) {
        super(context);
        this.p = false;
        this.q = false;
        this.r = new com.kwad.sdk.widget.k() { // from class: com.kwad.sdk.feed.widget.a.1
            @Override // com.kwad.sdk.widget.k
            public void a() {
                m.c(((com.kwad.sdk.feed.widget.base.a) a.this).f55445b);
            }
        };
        this.a = new a.b() { // from class: com.kwad.sdk.feed.widget.a.2
            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j2) {
                a.this.a(j2);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                a.this.q = false;
                com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) a.this).f55445b);
                if (a.this.m == null || a.this.m.getParent() != a.this.f55436g) {
                    return;
                }
                a.this.m.setVideoSoundEnable(a.this.p);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (a.this.q) {
                    return;
                }
                a.this.q = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) a.this).f55445b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) a.this).f55445b);
            }
        };
        this.s = new a.InterfaceC2107a() { // from class: com.kwad.sdk.feed.widget.a.3
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC2107a
            public void a(int i2, z.a aVar) {
                int i3;
                int i4 = 2;
                boolean z = false;
                if (i2 == 1) {
                    i3 = 13;
                } else if (i2 == 2) {
                    i3 = 82;
                } else if (i2 != 3) {
                    i3 = 108;
                } else {
                    i3 = 83;
                    i4 = 1;
                    z = true;
                }
                p.a aVar2 = new p.a();
                aVar2.f54628g = aVar;
                aVar2.f54623b = i3;
                com.kwad.sdk.core.download.a.a.a(new a.C2095a(bb.a(a.this.m)).a(((com.kwad.sdk.feed.widget.base.a) a.this).f55445b).a(a.this.f55439j).a(i4).a(z).c(true).e(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.feed.widget.a.3.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        a.this.l();
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.l;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.l.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f55445b, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar, boolean z) {
        if (bVar != null) {
            String a = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f55446c);
            this.n.setAutoRelease(false);
            int i2 = z ? 1 : 2;
            AdVideoPlayerViewCache.a().a(a, this.m);
            com.kwad.sdk.core.download.a.a.a(new a.C2095a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f55445b).a(this.f55439j).a(z).a(i2).e(true).a(new a.b() { // from class: com.kwad.sdk.feed.widget.a.5
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.k();
                }
            }));
        }
    }

    private void d() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        textView.setText(com.kwad.sdk.core.response.a.a.A(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_app_icon);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.a.a.t(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        imageView.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.a.a.au(((com.kwad.sdk.feed.widget.base.a) this).f55446c), ((com.kwad.sdk.feed.widget.base.a) this).f55445b, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        this.o.a(((com.kwad.sdk.feed.widget.base.a) this).f55445b);
        this.o.setOnClickListener(this);
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f55445b, null, this.o.getAppDownloadListener());
        this.f55439j = bVar;
        bVar.c(this.o.getAppDownloadListener());
        this.f55439j.a((DialogInterface.OnShowListener) this);
        this.f55439j.a((DialogInterface.OnDismissListener) this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        this.p = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).f55446c).a();
        if (TextUtils.isEmpty(a)) {
            imageView = this.k;
            i2 = 8;
        } else {
            this.k.setImageDrawable(null);
            KSImageLoader.loadImage(this.k, a, ((com.kwad.sdk.feed.widget.base.a) this).f55445b);
            imageView = this.k;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.l = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).f55446c);
        com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).f55448e);
        this.m = bVar;
        bVar.setVisibleListener(this.r);
        this.m.setTag(this.l);
        String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f55446c);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        this.m.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).f55445b).a(a2).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).f55445b))).a(((com.kwad.sdk.feed.widget.base.a) this).f55445b.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this).f55445b)).a(), (Map<String, String>) null);
        this.m.setVideoSoundEnable(this.p);
        j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f55448e, ((com.kwad.sdk.feed.widget.base.a) this).f55445b, this.m);
        this.n = jVar;
        jVar.setVideoPlayCallback(this.a);
        this.n.setAdClickListener(this.s);
        this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.m.setController(this.n);
        if (this.f55436g.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.f55436g;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.f55436g.setTag(null);
        }
        this.f55436g.addView(this.m);
        this.f55436g.setTag(this.m);
        this.f55436g.setClickable(true);
        this.f55436g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!a.this.m.d()) {
                    a aVar = a.this;
                    aVar.a(aVar.m, false);
                    return;
                }
                m.b(((com.kwad.sdk.feed.widget.base.a) a.this).f55445b);
                a.this.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) a.this).f55445b));
                a.this.m.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f55435f.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        this.f55438i.a(adTemplate);
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f55446c)) {
            g();
        } else {
            d();
        }
        this.f55437h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        m.a(((com.kwad.sdk.feed.widget.base.a) this).f55445b);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f55435f = (TextView) findViewById(R.id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.f55436g = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.f55437h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.k = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.f55438i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.o = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.core.j.d
    public void e() {
        super.e();
        if (this.p) {
            com.kwad.sdk.utils.b.a(getContext()).a(false);
            if (com.kwad.sdk.utils.b.a(getContext()).a()) {
                this.p = false;
                this.m.setVideoSoundEnable(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55437h) {
            m();
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
        if (this.m.getParent() != this.f55436g) {
            viewGroup.removeView(this.m);
            if (this.f55436g.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.f55436g;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.f55436g.setTag(null);
            }
            this.f55436g.addView(this.m);
            this.f55436g.setTag(this.m);
            String a = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f55446c);
            this.m.setVideoSoundEnable(this.p);
            this.n.setVideoPlayCallback(this.a);
            this.n.setAdClickListener(this.s);
            this.n.getAdTemplate().mAdWebVideoPageShowing = false;
            this.n.p();
            this.n.setAutoRelease(true);
            AdVideoPlayerViewCache.a().a(a);
        }
    }
}
