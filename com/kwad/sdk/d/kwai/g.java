package com.kwad.sdk.d.kwai;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
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
/* loaded from: classes8.dex */
public class g extends b implements com.kwad.sdk.widget.d {
    @NonNull
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f55214b;

    /* renamed from: c  reason: collision with root package name */
    public c f55215c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f55216d;

    /* renamed from: e  reason: collision with root package name */
    public KSFrameLayout f55217e;

    /* renamed from: f  reason: collision with root package name */
    public KSFrameLayout f55218f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f55219g;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f55221i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f55222j;
    @NonNull
    public KsAdVideoPlayConfig k;
    public ImageView l;
    public com.kwad.sdk.core.download.a.b m;
    public com.kwad.sdk.d.a.c n;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public boolean f55220h = false;
    public final a.InterfaceC2107a o = new a.InterfaceC2107a() { // from class: com.kwad.sdk.d.kwai.g.2
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
            com.kwad.sdk.core.download.a.a.a(new a.C2095a(bb.a(g.this.f55222j)).a(g.this.f55216d).a(g.this.m).a(i4).a(z).c(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.d.kwai.g.2.1
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
        List<Integer> list = this.f55221i;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f55221i.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(this.f55216d, ceil, null);
                it.remove();
                return;
            }
        }
    }

    private void e() {
        ImageView imageView;
        int i2;
        String a;
        this.f55220h = this.k.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.a.a.aa(this.f55214b).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.l;
            i2 = 8;
        } else {
            this.l.setImageDrawable(null);
            KSImageLoader.loadImage(this.l, a2, this.f55216d);
            imageView = this.l;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        int C = com.kwad.sdk.core.config.b.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.a(this.f55214b));
            a = (b2 == null || !b2.exists()) ? null : b2.getAbsolutePath();
        } else {
            a = C == 0 ? com.kwad.sdk.core.response.a.a.a(this.f55214b) : com.kwad.sdk.core.videocache.b.a.a(this.a).a(com.kwad.sdk.core.response.a.a.a(this.f55214b));
        }
        if (TextUtils.isEmpty(a)) {
            return;
        }
        this.f55222j.a(new c.a(this.f55216d).a(a).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.f55216d))).a(this.f55216d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f55216d, System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.f55222j.setVideoSoundEnable(this.f55220h);
        this.n.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.d.kwai.g.1

            /* renamed from: b  reason: collision with root package name */
            public boolean f55223b = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j2) {
                g.this.a(j2);
                for (a.b bVar : g.this.f55215c.f55182h) {
                    bVar.a(j2);
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(g.this.f55216d);
                if (g.this.f55215c.f55176b != null) {
                    g.this.f55215c.f55176b.onVideoPlayStart();
                }
                for (a.b bVar : g.this.f55215c.f55182h) {
                    bVar.b_();
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (!this.f55223b) {
                    this.f55223b = true;
                    com.kwad.sdk.core.report.d.a(g.this.f55216d, System.currentTimeMillis(), 0);
                }
                for (a.b bVar : g.this.f55215c.f55182h) {
                    bVar.e();
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(g.this.f55216d);
                if (g.this.f55215c.f55176b != null) {
                    g.this.f55215c.f55176b.onVideoPlayEnd();
                }
                for (a.b bVar : g.this.f55215c.f55182h) {
                    bVar.f();
                }
            }
        });
        this.f55222j.setController(this.n);
        this.f55218f.setClickable(true);
        new com.kwad.sdk.widget.f(this.f55218f.getContext(), this.f55218f, this);
        this.f55218f.addView(this.f55222j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f55215c.f55176b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.f55215c = cVar;
        this.f55219g = cVar.f55177c;
        this.k = cVar.f55181g;
        AdTemplate adTemplate = cVar.a;
        this.f55216d = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f55214b = j2;
        List<Integer> S = com.kwad.sdk.core.response.a.a.S(j2);
        this.f55221i = S;
        com.kwad.sdk.core.video.videoview.b bVar = this.f55215c.f55183i;
        this.f55222j = bVar;
        bVar.setTag(S);
        com.kwad.sdk.d.a.c cVar2 = new com.kwad.sdk.d.a.c(this.a, this.f55216d, this.f55222j);
        this.n = cVar2;
        cVar2.setDataFlowAutoStart(this.k.isDataFlowAutoStart());
        this.n.setAdClickListener(this.o);
        this.n.j();
        this.m = this.f55215c.f55178d;
        e();
        float dimension = q().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.f55218f.a(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        this.f55215c.a(view, false, 3, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f55215c.a)) {
            this.f55215c.a(view, false, 3, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55217e = (KSFrameLayout) m().findViewById(R.id.ksad_container);
        this.f55218f = (KSFrameLayout) m().findViewById(R.id.ksad_video_container);
        this.l = (ImageView) m().findViewById(R.id.ksad_video_first_frame_container);
        this.f55218f.setVisibility(4);
        this.a = q();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
    }
}
