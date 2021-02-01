package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.contentalliance.a.a, ap.a {
    private static boolean o = false;

    /* renamed from: a  reason: collision with root package name */
    private ap f8602a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f8603b;
    private boolean c;
    private String d;
    private long e;
    private com.kwad.sdk.contentalliance.detail.video.a f;
    private KsFragment g;
    private Context h;
    private SlidePlayViewPager i;
    private g j;
    private AdTemplate m;
    private final int n;
    private f p;
    private c.d q;
    private c k = null;
    private boolean l = false;
    private AtomicBoolean r = new AtomicBoolean(false);
    private com.kwad.sdk.contentalliance.a.c s = new com.kwad.sdk.contentalliance.a.d() { // from class: com.kwad.sdk.contentalliance.detail.video.b.3
        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void d() {
            b.this.g();
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void f() {
            com.kwad.sdk.core.d.a.a("DetailPlayModule", "onDestroyView mCurrentPosition" + b.this.n);
            b.this.q();
            b.this.f.b(b.this.q);
            b.this.f.k();
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void g() {
            com.kwad.sdk.core.d.a.a("DetailPlayModule", "onDestroy mCurrentPosition=" + b.this.n);
            b.this.q();
            b.this.f.b(b.this.q);
            b.this.f.b(b.this.p);
            b.this.v();
            b.this.f.k();
        }
    };
    private List<a> t = new ArrayList();
    private List<com.kwad.sdk.core.i.c> u = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        boolean a();
    }

    public b(KsFragment ksFragment, SlidePlayViewPager slidePlayViewPager, DetailVideoView detailVideoView, final AdTemplate adTemplate, int i) {
        this.g = ksFragment;
        this.h = this.g.getContext();
        this.i = slidePlayViewPager;
        this.m = adTemplate;
        this.n = i;
        if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.d = com.kwad.sdk.core.response.b.a.a(j);
            this.e = com.kwad.sdk.core.response.b.a.k(j);
        } else {
            PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
            this.d = com.kwad.sdk.core.response.b.d.b(k);
            this.e = com.kwad.sdk.core.response.b.d.k(k);
        }
        this.j = new g(ksFragment.getContext());
        this.f = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        n();
        this.j = new g(ksFragment.getContext());
        this.f.a(new c.e() { // from class: com.kwad.sdk.contentalliance.detail.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                al.a().b(b.this.m);
                if (b.this.c && b.this.g.isResumed() && ao.a(b.this.f8603b, 70)) {
                    b.this.f.f();
                }
            }
        });
        this.p = new f() { // from class: com.kwad.sdk.contentalliance.detail.video.b.2
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i2, int i3) {
                super.a(i2, i3);
                com.kwad.sdk.core.report.e.b(adTemplate, i2, i3);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                super.d();
                al.a().c(b.this.m);
            }
        };
        this.f.a(this.p);
        this.f.a(t());
        this.f8603b = (ViewGroup) detailVideoView.getParent().getParent();
    }

    @Nullable
    private com.kwai.video.ksvodplayerkit.d.b a(int i, int i2) {
        List<AdTemplate> data = this.i.getData();
        if (data == null || i < 0 || i >= data.size()) {
            return null;
        }
        AdTemplate adTemplate = data.get(i);
        if (adTemplate == null) {
            return null;
        }
        String l = com.kwad.sdk.core.response.b.c.l(adTemplate);
        if (ag.a(l)) {
            return null;
        }
        return new com.kwai.video.ksvodplayerkit.d.f(l, String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)), i2);
    }

    private void a(boolean z) {
        if (z) {
            for (com.kwad.sdk.core.i.c cVar : this.u) {
                cVar.c_();
            }
            r();
            return;
        }
        for (com.kwad.sdk.core.i.c cVar2 : this.u) {
            cVar2.b();
        }
        s();
    }

    private void n() {
        com.kwad.sdk.core.d.a.a("DetailPlayModule", "createPlayerAndPrepare()");
        this.f.a(new d.a().a(o()).a(this.m.mVideoPlayerStatus).a(new c(this.e)).a());
        al.a().a(this.m);
        this.f.e();
        al.a().d(this.m);
    }

    private String o() {
        return com.kwad.sdk.core.config.c.l() ? com.kwad.sdk.core.videocache.c.a.a(this.h.getApplicationContext()).a(this.d) : this.d;
    }

    private void p() {
        if (this.f8602a == null) {
            this.f8602a = new ap(this);
        }
        this.f8602a.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f8602a == null) {
            return;
        }
        this.f8602a.removeCallbacksAndMessages(null);
        this.f8602a = null;
    }

    private void r() {
        if (this.l) {
            return;
        }
        this.j.a();
        this.l = true;
    }

    private void s() {
        this.j.b();
        this.l = false;
    }

    private c.d t() {
        if (this.q == null) {
            this.q = new c.d() { // from class: com.kwad.sdk.contentalliance.detail.video.b.4
                @Override // com.kwad.sdk.core.video.a.c.d
                public boolean a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
                    if (b.this.c && i == 10209 && com.kwad.sdk.core.config.c.ag() && 2 == cVar.o()) {
                        b.this.u();
                        return false;
                    }
                    return false;
                }
            };
        }
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.r.get()) {
            return;
        }
        this.r.set(true);
        for (int i = 2; i < 5; i++) {
            int i2 = this.n + i;
            com.kwai.video.ksvodplayerkit.d.b a2 = a(i2, 1000 - i2);
            if (a2 != null) {
                com.kwai.video.ksvodplayerkit.d.c.a().a(a2);
                com.kwad.sdk.core.d.a.a("DetailPlayModule", "在当前页" + this.n + "添加预加载任务preLoadPosition=" + i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.kwad.sdk.core.video.a.c a2 = this.f.a();
        if (a2 == null || a2.o() != 2) {
            return;
        }
        com.kwai.video.ksvodplayerkit.d.c.a().b();
    }

    public void a(float f) {
        if (this.f != null) {
            this.f.a(f);
        }
    }

    public void a(long j) {
        this.f.a(j);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what != 1) {
            if (message.what == 2) {
                m.a();
                o = false;
            }
        } else if (this.g == null) {
        } else {
            boolean z = (this.g.isResumed() && !this.g.isAllFragmentIsHidden() && this.g.isVisible()) ? false : true;
            if (!ao.a((View) this.f8603b, 50, false) || z) {
                if (!o) {
                    com.kwad.sdk.core.d.a.a("DetailPlayModule", "sendEmptyMessageDelayed(MSG_UPDATE_SESSION_ID)");
                    this.f8602a.sendEmptyMessageDelayed(2, 300000L);
                    o = true;
                }
                a(false);
                if (this.f.i()) {
                    g();
                }
            } else {
                if (o) {
                    com.kwad.sdk.core.d.a.a("DetailPlayModule", "removeMessages(MSG_UPDATE_SESSION_ID)");
                    this.f8602a.removeMessages(2);
                    o = false;
                }
                if (this.k == null) {
                    this.k = new c(this.e, System.currentTimeMillis());
                    this.f.a(this.k);
                }
                a(true);
                if (!this.f.i()) {
                    e();
                }
            }
            this.f8602a.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void a(a aVar) {
        this.t.add(aVar);
    }

    public void a(e eVar) {
        this.f.a(eVar);
    }

    public void a(com.kwad.sdk.core.i.c cVar) {
        this.u.add(cVar);
    }

    public boolean a() {
        return this.f.i();
    }

    public void b(a aVar) {
        this.t.remove(aVar);
    }

    public void b(e eVar) {
        this.f.b(eVar);
    }

    public void b(com.kwad.sdk.core.i.c cVar) {
        this.u.remove(cVar);
    }

    public boolean b() {
        return this.f.d();
    }

    public int c() {
        return this.f.b();
    }

    public com.kwad.sdk.contentalliance.a.c d() {
        return this.s;
    }

    public void e() {
        if (this.c && this.g.isResumed()) {
            boolean z = false;
            for (a aVar : this.t) {
                z = z || aVar.a();
            }
            if (z) {
                return;
            }
            this.f.h();
        }
    }

    public void f() {
        this.f.c(new d.a().a(o()).a(this.m.mVideoPlayerStatus).a(new c(this.e)).a());
    }

    public void g() {
        if (this.c) {
            this.f.j();
        }
    }

    public void h() {
        this.f.g();
    }

    public void i() {
        q();
        if (this.f != null) {
            this.f.p();
            this.f.k();
        }
        this.l = false;
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void j() {
        com.kwad.sdk.core.d.a.a("DetailPlayModule", "becomesAttachedOnPageSelected mCurrentPosition=" + this.n);
        p();
        this.c = true;
        if (this.f.a() == null) {
            n();
        }
        this.f.f();
        r();
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void k() {
        com.kwad.sdk.core.d.a.a("DetailPlayModule", "becomesDetachedOnPageSelected mCurrentPosition=" + this.n);
        q();
        this.c = false;
        this.k = null;
        this.f.k();
        s();
        v();
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void l() {
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void m() {
    }
}
