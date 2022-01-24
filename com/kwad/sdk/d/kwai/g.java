package com.kwad.sdk.d.kwai;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends b implements com.kwad.sdk.widget.d {
    @NonNull
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f56697b;

    /* renamed from: c  reason: collision with root package name */
    public c f56698c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f56699d;

    /* renamed from: e  reason: collision with root package name */
    public KSFrameLayout f56700e;

    /* renamed from: f  reason: collision with root package name */
    public KSFrameLayout f56701f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f56702g;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f56704i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f56705j;
    @NonNull
    public KsAdVideoPlayConfig k;
    public ImageView l;
    public com.kwad.sdk.core.download.a.b m;
    public com.kwad.sdk.d.a.c n;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public boolean f56703h = false;
    public final a.InterfaceC2118a o = new a.InterfaceC2118a() { // from class: com.kwad.sdk.d.kwai.g.2
        @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC2118a
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
            aVar2.f56111g = aVar;
            aVar2.f56106b = i3;
            com.kwad.sdk.core.download.a.a.a(new a.C2106a(bb.a(g.this.f56705j)).a(g.this.f56699d).a(g.this.m).a(i4).a(z).c(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.d.kwai.g.2.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    g.this.f();
                }
            }));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f56704i;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f56704i.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(this.f56699d, ceil, null);
                it.remove();
                return;
            }
        }
    }

    private void e() {
        ImageView imageView;
        int i2;
        String a;
        this.f56703h = this.k.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.a.a.aa(this.f56697b).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.l;
            i2 = 8;
        } else {
            this.l.setImageDrawable(null);
            KSImageLoader.loadImage(this.l, a2, this.f56699d);
            imageView = this.l;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        int C = com.kwad.sdk.core.config.b.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.a(this.f56697b));
            a = (b2 == null || !b2.exists()) ? null : b2.getAbsolutePath();
        } else {
            a = C == 0 ? com.kwad.sdk.core.response.a.a.a(this.f56697b) : com.kwad.sdk.core.videocache.b.a.a(this.a).a(com.kwad.sdk.core.response.a.a.a(this.f56697b));
        }
        if (TextUtils.isEmpty(a)) {
            return;
        }
        this.f56705j.a(new c.a(this.f56699d).a(a).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.f56699d))).a(this.f56699d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f56699d, System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.f56705j.setVideoSoundEnable(this.f56703h);
        this.n.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.d.kwai.g.1

            /* renamed from: b  reason: collision with root package name */
            public boolean f56706b = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j2) {
                g.this.a(j2);
                for (a.b bVar : g.this.f56698c.f56665h) {
                    bVar.a(j2);
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(g.this.f56699d);
                if (g.this.f56698c.f56659b != null) {
                    g.this.f56698c.f56659b.onVideoPlayStart();
                }
                for (a.b bVar : g.this.f56698c.f56665h) {
                    bVar.b_();
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (!this.f56706b) {
                    this.f56706b = true;
                    com.kwad.sdk.core.report.d.a(g.this.f56699d, System.currentTimeMillis(), 0);
                }
                for (a.b bVar : g.this.f56698c.f56665h) {
                    bVar.e();
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(g.this.f56699d);
                if (g.this.f56698c.f56659b != null) {
                    g.this.f56698c.f56659b.onVideoPlayEnd();
                }
                for (a.b bVar : g.this.f56698c.f56665h) {
                    bVar.f();
                }
            }
        });
        this.f56705j.setController(this.n);
        this.f56701f.setClickable(true);
        new com.kwad.sdk.widget.f(this.f56701f.getContext(), this.f56701f, this);
        this.f56701f.addView(this.f56705j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f56698c.f56659b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.f56698c = cVar;
        this.f56702g = cVar.f56660c;
        this.k = cVar.f56664g;
        AdTemplate adTemplate = cVar.a;
        this.f56699d = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56697b = j2;
        List<Integer> S = com.kwad.sdk.core.response.a.a.S(j2);
        this.f56704i = S;
        com.kwad.sdk.core.video.videoview.b bVar = this.f56698c.f56666i;
        this.f56705j = bVar;
        bVar.setTag(S);
        com.kwad.sdk.d.a.c cVar2 = new com.kwad.sdk.d.a.c(this.a, this.f56699d, this.f56705j);
        this.n = cVar2;
        cVar2.setDataFlowAutoStart(this.k.isDataFlowAutoStart());
        this.n.setAdClickListener(this.o);
        this.n.j();
        this.m = this.f56698c.f56661d;
        e();
        float dimension = q().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.f56701f.a(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        this.f56698c.a(view, false, 3, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f56698c.a)) {
            this.f56698c.a(view, false, 3, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56700e = (KSFrameLayout) m().findViewById(R.id.ksad_container);
        this.f56701f = (KSFrameLayout) m().findViewById(R.id.ksad_video_container);
        this.l = (ImageView) m().findViewById(R.id.ksad_video_first_frame_container);
        this.f56701f.setVisibility(4);
        this.a = q();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
    }
}
