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
/* loaded from: classes5.dex */
public abstract class a extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public a.b a;
    public TextView f;
    public RatioFrameLayout g;
    public ImageView h;
    public KsLogoView i;
    public com.kwad.sdk.core.download.a.b j;
    public ImageView k;
    public List<Integer> l;
    public com.kwad.sdk.core.video.videoview.b m;
    public j n;
    public DownloadProgressView o;
    public boolean p;
    public volatile boolean q;
    public com.kwad.sdk.widget.k r;
    public final a.InterfaceC0316a s;

    public a(@NonNull Context context) {
        super(context);
        this.p = false;
        this.q = false;
        this.r = new com.kwad.sdk.widget.k() { // from class: com.kwad.sdk.feed.widget.a.1
            @Override // com.kwad.sdk.widget.k
            public void a() {
                m.c(((com.kwad.sdk.feed.widget.base.a) a.this).b);
            }
        };
        this.a = new a.b() { // from class: com.kwad.sdk.feed.widget.a.2
            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j) {
                a.this.a(j);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                a.this.q = false;
                com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) a.this).b);
                if (a.this.m == null || a.this.m.getParent() != a.this.g) {
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
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) a.this).b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) a.this).b);
            }
        };
        this.s = new a.InterfaceC0316a() { // from class: com.kwad.sdk.feed.widget.a.3
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0316a
            public void a(int i, z.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 13;
                } else if (i == 2) {
                    i2 = 82;
                } else if (i != 3) {
                    i2 = 108;
                } else {
                    i2 = 83;
                    i3 = 1;
                    z = true;
                }
                p.a aVar2 = new p.a();
                aVar2.g = aVar;
                aVar2.b = i2;
                com.kwad.sdk.core.download.a.a.a(new a.C0304a(bb.a(a.this.m)).a(((com.kwad.sdk.feed.widget.base.a) a.this).b).a(a.this.j).a(i3).a(z).c(true).e(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.feed.widget.a.3.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        a.this.l();
                    }
                }));
            }
        };
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
                com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).b, ceil, null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar, boolean z) {
        if (bVar != null) {
            String a = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).c);
            this.n.setAutoRelease(false);
            int i = z ? 1 : 2;
            AdVideoPlayerViewCache.a().a(a, this.m);
            com.kwad.sdk.core.download.a.a.a(new a.C0304a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).b).a(this.j).a(z).a(i).e(true).a(new a.b() { // from class: com.kwad.sdk.feed.widget.a.5
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.k();
                }
            }));
        }
    }

    private void d() {
        findViewById(R.id.obfuscated_res_0x7f090fd4).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090fd3).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091048);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f091046)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).c));
        textView.setText(com.kwad.sdk.core.response.a.a.A(((com.kwad.sdk.feed.widget.base.a) this).c));
        findViewById(R.id.obfuscated_res_0x7f091049).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.obfuscated_res_0x7f090fd3).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090fd4).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff1);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f090ff5)).setText(com.kwad.sdk.core.response.a.a.t(((com.kwad.sdk.feed.widget.base.a) this).c));
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f080bb6);
        KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.a.a.au(((com.kwad.sdk.feed.widget.base.a) this).c), ((com.kwad.sdk.feed.widget.base.a) this).b, 8);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f090fec)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).c));
        this.o.a(((com.kwad.sdk.feed.widget.base.a) this).b);
        this.o.setOnClickListener(this);
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).b, null, this.o.getAppDownloadListener());
        this.j = bVar;
        bVar.c(this.o.getAppDownloadListener());
        this.j.a((DialogInterface.OnShowListener) this);
        this.j.a((DialogInterface.OnDismissListener) this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        this.p = ksAdVideoPlayConfig.isVideoSoundEnable();
        String a = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).c).a();
        if (TextUtils.isEmpty(a)) {
            imageView = this.k;
            i = 8;
        } else {
            this.k.setImageDrawable(null);
            KSImageLoader.loadImage(this.k, a, ((com.kwad.sdk.feed.widget.base.a) this).b);
            imageView = this.k;
            i = 0;
        }
        imageView.setVisibility(i);
        this.l = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).c);
        com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).e);
        this.m = bVar;
        bVar.setVisibleListener(this.r);
        this.m.setTag(this.l);
        String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).c);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        this.m.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).b).a(a2).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).b))).a(((com.kwad.sdk.feed.widget.base.a) this).b.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this).b)).a(), (Map<String, String>) null);
        this.m.setVideoSoundEnable(this.p);
        j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).e, ((com.kwad.sdk.feed.widget.base.a) this).b, this.m);
        this.n = jVar;
        jVar.setVideoPlayCallback(this.a);
        this.n.setAdClickListener(this.s);
        this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.m.setController(this.n);
        if (this.g.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.g;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.g.setTag(null);
        }
        this.g.addView(this.m);
        this.g.setTag(this.m);
        this.g.setClickable(true);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.feed.widget.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.m.d()) {
                    a aVar = a.this;
                    aVar.a(aVar.m, false);
                    return;
                }
                m.b(((com.kwad.sdk.feed.widget.base.a) a.this).b);
                a.this.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) a.this).b));
                a.this.m.a();
            }
        });
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).c));
        this.i.a(adTemplate);
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).c)) {
            g();
        } else {
            d();
        }
        this.h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        m.a(((com.kwad.sdk.feed.widget.base.a) this).b);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090fcf);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091119);
        this.g = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.56f);
        this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fd1);
        this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f091129);
        this.i = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f090fd2);
        this.o = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f090fee);
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
    public void onClick(View view2) {
        if (view2 == this.h) {
            m();
        } else {
            a(this.m, view2 == this.o);
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
        if (this.m.getParent() != this.g) {
            viewGroup.removeView(this.m);
            if (this.g.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.g;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.g.setTag(null);
            }
            this.g.addView(this.m);
            this.g.setTag(this.m);
            String a = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).c);
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
