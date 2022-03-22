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
/* loaded from: classes7.dex */
public class g extends b implements com.kwad.sdk.widget.d {
    @NonNull
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f40281b;

    /* renamed from: c  reason: collision with root package name */
    public c f40282c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f40283d;

    /* renamed from: e  reason: collision with root package name */
    public KSFrameLayout f40284e;

    /* renamed from: f  reason: collision with root package name */
    public KSFrameLayout f40285f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f40286g;
    public List<Integer> i;
    public com.kwad.sdk.core.video.videoview.b j;
    @NonNull
    public KsAdVideoPlayConfig k;
    public ImageView l;
    public com.kwad.sdk.core.download.a.b m;
    public com.kwad.sdk.d.a.c n;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public boolean f40287h = false;
    public final a.InterfaceC1968a o = new a.InterfaceC1968a() { // from class: com.kwad.sdk.d.kwai.g.2
        @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1968a
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
            aVar2.f39737g = aVar;
            aVar2.f39732b = i2;
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(bb.a(g.this.j)).a(g.this.f40283d).a(g.this.m).a(i3).a(z).c(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.d.kwai.g.2.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    g.this.f();
                }
            }));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.i;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.i.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(this.f40283d, ceil, null);
                it.remove();
                return;
            }
        }
    }

    private void e() {
        ImageView imageView;
        int i;
        String a;
        this.f40287h = this.k.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.a.a.aa(this.f40281b).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.l;
            i = 8;
        } else {
            this.l.setImageDrawable(null);
            KSImageLoader.loadImage(this.l, a2, this.f40283d);
            imageView = this.l;
            i = 0;
        }
        imageView.setVisibility(i);
        int C = com.kwad.sdk.core.config.b.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.a(this.f40281b));
            a = (b2 == null || !b2.exists()) ? null : b2.getAbsolutePath();
        } else {
            a = C == 0 ? com.kwad.sdk.core.response.a.a.a(this.f40281b) : com.kwad.sdk.core.videocache.b.a.a(this.a).a(com.kwad.sdk.core.response.a.a.a(this.f40281b));
        }
        if (TextUtils.isEmpty(a)) {
            return;
        }
        this.j.a(new c.a(this.f40283d).a(a).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.f40283d))).a(this.f40283d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f40283d, System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.j.setVideoSoundEnable(this.f40287h);
        this.n.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.d.kwai.g.1

            /* renamed from: b  reason: collision with root package name */
            public boolean f40288b = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j) {
                g.this.a(j);
                for (a.b bVar : g.this.f40282c.f40253h) {
                    bVar.a(j);
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(g.this.f40283d);
                if (g.this.f40282c.f40247b != null) {
                    g.this.f40282c.f40247b.onVideoPlayStart();
                }
                for (a.b bVar : g.this.f40282c.f40253h) {
                    bVar.b_();
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (!this.f40288b) {
                    this.f40288b = true;
                    com.kwad.sdk.core.report.d.a(g.this.f40283d, System.currentTimeMillis(), 0);
                }
                for (a.b bVar : g.this.f40282c.f40253h) {
                    bVar.e();
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(g.this.f40283d);
                if (g.this.f40282c.f40247b != null) {
                    g.this.f40282c.f40247b.onVideoPlayEnd();
                }
                for (a.b bVar : g.this.f40282c.f40253h) {
                    bVar.f();
                }
            }
        });
        this.j.setController(this.n);
        this.f40285f.setClickable(true);
        new com.kwad.sdk.widget.f(this.f40285f.getContext(), this.f40285f, this);
        this.f40285f.addView(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f40282c.f40247b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.f40282c = cVar;
        this.f40286g = cVar.f40248c;
        this.k = cVar.f40252g;
        AdTemplate adTemplate = cVar.a;
        this.f40283d = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f40281b = j;
        List<Integer> S = com.kwad.sdk.core.response.a.a.S(j);
        this.i = S;
        com.kwad.sdk.core.video.videoview.b bVar = this.f40282c.i;
        this.j = bVar;
        bVar.setTag(S);
        com.kwad.sdk.d.a.c cVar2 = new com.kwad.sdk.d.a.c(this.a, this.f40283d, this.j);
        this.n = cVar2;
        cVar2.setDataFlowAutoStart(this.k.isDataFlowAutoStart());
        this.n.setAdClickListener(this.o);
        this.n.j();
        this.m = this.f40282c.f40249d;
        e();
        float dimension = q().getResources().getDimension(R.dimen.obfuscated_res_0x7f07035d);
        this.f40285f.a(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        this.f40282c.a(view, false, 3, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f40282c.a)) {
            this.f40282c.a(view, false, 3, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40284e = (KSFrameLayout) m().findViewById(R.id.obfuscated_res_0x7f091059);
        this.f40285f = (KSFrameLayout) m().findViewById(R.id.obfuscated_res_0x7f09115e);
        this.l = (ImageView) m().findViewById(R.id.obfuscated_res_0x7f09116e);
        this.f40285f.setVisibility(4);
        this.a = q();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
    }
}
