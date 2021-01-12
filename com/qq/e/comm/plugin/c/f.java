package com.qq.e.comm.plugin.c;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.az;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class f {
    String A;
    BrowserType B;
    boolean C;
    final com.qq.e.comm.plugin.s.a D;
    private Future<com.qq.e.comm.plugin.s.b> E;

    /* renamed from: a  reason: collision with root package name */
    final com.qq.e.comm.plugin.ad.e f11944a;

    /* renamed from: b  reason: collision with root package name */
    final int f11945b;
    final String c;
    final boolean d;
    final boolean e;
    final String f;
    final boolean g;
    final Boolean h;
    final com.qq.e.comm.plugin.s.c i;
    final boolean j;
    final boolean k;
    final boolean l;
    final String m;
    final int n;
    final int o;
    final com.qq.e.comm.plugin.ad.f p;
    final boolean q;
    final boolean r;
    final boolean s;
    final boolean t;
    final boolean u;
    final boolean v;
    final int w;
    final Context x;
    final int y;
    final com.qq.e.comm.plugin.y.c z;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private com.qq.e.comm.plugin.s.a f11946a;

        /* renamed from: b  reason: collision with root package name */
        private String f11947b;
        private int c;
        private com.qq.e.comm.plugin.ad.f e;
        private boolean j;
        private int d = 0;
        private boolean f = false;
        private boolean g = true;
        private boolean h = false;
        private boolean i = false;
        private boolean k = true;

        public a(com.qq.e.comm.plugin.s.a aVar, View view) {
            this.f11946a = aVar;
            this.c = com.qq.e.comm.plugin.ad.a.a().b(view);
            this.j = aVar.ah() ? false : true;
        }

        public a a(int i) {
            this.d = i;
            return this;
        }

        public a a(com.qq.e.comm.plugin.ad.f fVar) {
            this.e = fVar;
            return this;
        }

        public a a(String str) {
            this.f11947b = str;
            return this;
        }

        public a a(boolean z) {
            this.f = z;
            return this;
        }

        public f a() {
            return new f(this);
        }

        public a b(boolean z) {
            this.g = z;
            return this;
        }

        public a c(boolean z) {
            this.h = z;
            return this;
        }

        public a d(boolean z) {
            this.i = z;
            return this;
        }

        public a e(boolean z) {
            this.j = z;
            return this;
        }

        public a f(boolean z) {
            this.k = z;
            return this;
        }
    }

    private f(a aVar) {
        boolean z = true;
        this.D = aVar.f11946a;
        this.f11944a = this.D.C();
        this.f11945b = this.D.a_();
        this.c = this.D.s();
        this.d = this.D.ah();
        String af = this.D.af();
        this.e = az.b(af);
        this.f = this.e ? af : null;
        this.g = com.qq.e.comm.plugin.util.d.a(this.f11945b);
        if (com.qq.e.comm.plugin.util.b.b(this.D)) {
            this.h = true;
        } else if (com.qq.e.comm.plugin.util.b.c(this.D)) {
            this.h = false;
        } else {
            this.h = null;
        }
        this.i = this.D.l();
        this.j = this.g && this.D.aa();
        this.k = this.D.w();
        this.l = ((this.D instanceof com.qq.e.comm.plugin.rewardvideo.d) && ((com.qq.e.comm.plugin.rewardvideo.d) this.D).ao() == com.qq.e.comm.plugin.rewardvideo.e.PAGE) ? z : false;
        this.m = aVar.f11947b;
        this.n = aVar.c;
        this.o = aVar.d;
        this.p = aVar.e;
        this.q = aVar.f;
        this.r = aVar.g;
        this.s = aVar.h;
        this.t = aVar.i;
        this.u = aVar.k;
        this.v = aVar.j;
        this.w = GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, this.D.B(), 0);
        this.x = GDTADManager.getInstance().getAppContext();
        this.z = new com.qq.e.comm.plugin.y.c().b(this.D.m()).a(this.D.B()).c(this.D.H());
        this.y = 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public com.qq.e.comm.plugin.s.b a() {
        if (this.E == null) {
            return null;
        }
        try {
            return this.E.get();
        } catch (Exception e) {
            return null;
        }
    }

    void a(Future<com.qq.e.comm.plugin.s.b> future) {
        if (future == null) {
            return;
        }
        this.E = future;
    }
}
