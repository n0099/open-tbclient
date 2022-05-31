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
/* loaded from: classes5.dex */
public class g extends b implements com.kwad.sdk.widget.d {
    @NonNull
    public Context a;
    public AdInfo b;
    public c c;
    public AdTemplate d;
    public KSFrameLayout e;
    public KSFrameLayout f;
    public Dialog g;
    public List<Integer> i;
    public com.kwad.sdk.core.video.videoview.b j;
    @NonNull
    public KsAdVideoPlayConfig k;
    public ImageView l;
    public com.kwad.sdk.core.download.a.b m;
    public com.kwad.sdk.d.a.c n;
    @Nullable
    public boolean h = false;
    public final a.InterfaceC0308a o = new a.InterfaceC0308a() { // from class: com.kwad.sdk.d.kwai.g.2
        @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0308a
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
            com.kwad.sdk.core.download.a.a.a(new a.C0296a(bb.a(g.this.j)).a(g.this.d).a(g.this.m).a(i3).a(z).c(true).a(aVar2).a(new a.b() { // from class: com.kwad.sdk.d.kwai.g.2.1
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
                com.kwad.sdk.core.report.a.b(this.d, ceil, null);
                it.remove();
                return;
            }
        }
    }

    private void e() {
        ImageView imageView;
        int i;
        String a;
        this.h = this.k.isVideoSoundEnable();
        String a2 = com.kwad.sdk.core.response.a.a.aa(this.b).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.l;
            i = 8;
        } else {
            this.l.setImageDrawable(null);
            KSImageLoader.loadImage(this.l, a2, this.d);
            imageView = this.l;
            i = 0;
        }
        imageView.setVisibility(i);
        int C = com.kwad.sdk.core.config.b.C();
        if (C < 0) {
            File b = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.a(this.b));
            a = (b == null || !b.exists()) ? null : b.getAbsolutePath();
        } else {
            a = C == 0 ? com.kwad.sdk.core.response.a.a.a(this.b) : com.kwad.sdk.core.videocache.b.a.a(this.a).a(com.kwad.sdk.core.response.a.a.a(this.b));
        }
        if (TextUtils.isEmpty(a)) {
            return;
        }
        this.j.a(new c.a(this.d).a(a).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.d))).a(this.d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(this.d, System.currentTimeMillis())).a(), (Map<String, String>) null);
        this.j.setVideoSoundEnable(this.h);
        this.n.setVideoPlayCallback(new a.b() { // from class: com.kwad.sdk.d.kwai.g.1
            public boolean b = false;

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j) {
                g.this.a(j);
                for (a.b bVar : g.this.c.h) {
                    bVar.a(j);
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.report.a.i(g.this.d);
                if (g.this.c.b != null) {
                    g.this.c.b.onVideoPlayStart();
                }
                for (a.b bVar : g.this.c.h) {
                    bVar.b_();
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (!this.b) {
                    this.b = true;
                    com.kwad.sdk.core.report.d.a(g.this.d, System.currentTimeMillis(), 0);
                }
                for (a.b bVar : g.this.c.h) {
                    bVar.e();
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.report.a.j(g.this.d);
                if (g.this.c.b != null) {
                    g.this.c.b.onVideoPlayEnd();
                }
                for (a.b bVar : g.this.c.h) {
                    bVar.f();
                }
            }
        });
        this.j.setController(this.n);
        this.f.setClickable(true);
        new com.kwad.sdk.widget.f(this.f.getContext(), this.f, this);
        this.f.addView(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.c.b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.c = cVar;
        this.g = cVar.c;
        this.k = cVar.g;
        AdTemplate adTemplate = cVar.a;
        this.d = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.b = j;
        List<Integer> S = com.kwad.sdk.core.response.a.a.S(j);
        this.i = S;
        com.kwad.sdk.core.video.videoview.b bVar = this.c.i;
        this.j = bVar;
        bVar.setTag(S);
        com.kwad.sdk.d.a.c cVar2 = new com.kwad.sdk.d.a.c(this.a, this.d, this.j);
        this.n = cVar2;
        cVar2.setDataFlowAutoStart(this.k.isDataFlowAutoStart());
        this.n.setAdClickListener(this.o);
        this.n.j();
        this.m = this.c.d;
        e();
        float dimension = q().getResources().getDimension(R.dimen.obfuscated_res_0x7f070367);
        this.f.a(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        this.c.a(view2, false, 3, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.c.a)) {
            this.c.a(view2, false, 3, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.e = (KSFrameLayout) m().findViewById(R.id.obfuscated_res_0x7f091024);
        this.f = (KSFrameLayout) m().findViewById(R.id.obfuscated_res_0x7f091129);
        this.l = (ImageView) m().findViewById(R.id.obfuscated_res_0x7f091139);
        this.f.setVisibility(4);
        this.a = q();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
    }
}
