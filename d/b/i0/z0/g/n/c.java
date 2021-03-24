package d.b.i0.z0.g.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import d.b.b.e.m.e;
import d.b.c.m.d;
import d.b.h0.r.q.a2;
import d.b.i0.i2.q.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class c extends d.b.i0.i2.q.b {
    public d.b.c.m.d N0;
    public a2 O0;
    public boolean P0;
    public boolean Q0;
    public CustomMessageListener R0;
    public Runnable S0;

    /* loaded from: classes4.dex */
    public class a implements d.InterfaceC0556d {
        public a() {
        }

        @Override // d.b.c.m.d.InterfaceC0556d
        public void a() {
        }

        @Override // d.b.c.m.d.InterfaceC0556d
        public void b() {
            c.this.startPlay();
        }

        @Override // d.b.c.m.d.InterfaceC0556d
        public boolean c() {
            return false;
        }

        @Override // d.b.c.m.d.InterfaceC0556d
        public void d() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.k {
        public b() {
        }

        @Override // d.b.i0.i2.q.d.k
        public void a(int i, int i2) {
            if (c.this.j0()) {
                return;
            }
            if (i2 >= i) {
                c.this.N0.I(false, false, "NEWINDEX");
            } else if (i == 0 || c.this.U || (i2 * 100) / i < 80 || i <= 15000) {
            } else {
                c cVar = c.this;
                cVar.O0(cVar.O0);
            }
        }
    }

    /* renamed from: d.b.i0.z0.g.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1704c extends CustomMessageListener {
        public C1704c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.c.m.e.b bVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.c.m.e.b) || (bVar = (d.b.c.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || c.this.O0 == null || !d2.equals(c.this.O0.o0())) {
                return;
            }
            d.b.c.m.d dVar = c.this.N0;
            c cVar = c.this;
            dVar.K(cVar.K0(cVar.O0, bVar));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.N0 != null) {
                c cVar = c.this;
                cVar.Q0 = false;
                cVar.N0.L();
                c.this.N0.w();
            }
        }
    }

    public c(Context context, View view) {
        super(context, view);
        this.P0 = false;
        this.R0 = new C1704c(2921395);
        this.S0 = new d();
        p0(true);
        L0();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.b.c.m.a K0(a2 a2Var, d.b.c.m.e.b bVar) {
        int i;
        VideoInfo u1;
        int i2;
        int i3;
        if (a2Var == null || bVar == null) {
            return null;
        }
        int c2 = bVar.c();
        int b2 = bVar.b();
        int a2 = bVar.a();
        int i4 = -1;
        if (a2 != -1) {
            int i5 = c2 != -1 ? (a2 - c2) - 1 : -1;
            if (b2 != -1) {
                i4 = i5;
                i = (b2 - a2) - 1;
                u1 = a2Var.u1();
                if (u1 == null) {
                    int intValue = u1.video_width.intValue();
                    i3 = u1.video_height.intValue();
                    i2 = intValue;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("video_vid", a2Var.o0());
                hashMap.put("video_title", a2Var.x1());
                hashMap.put("forum_id", String.valueOf(a2Var.c0()));
                hashMap.put("forum_name", a2Var.i0());
                hashMap.put("up_distance", String.valueOf(i4));
                hashMap.put("down_distance", String.valueOf(i));
                d.b.c.m.a h2 = d.b.c.m.c.h(3, 0, "1546854828072", a2 + 1, i2, i3);
                h2.a(hashMap);
                return h2;
            }
            i4 = i5;
        }
        i = -1;
        u1 = a2Var.u1();
        if (u1 == null) {
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("video_vid", a2Var.o0());
        hashMap2.put("video_title", a2Var.x1());
        hashMap2.put("forum_id", String.valueOf(a2Var.c0()));
        hashMap2.put("forum_name", a2Var.i0());
        hashMap2.put("up_distance", String.valueOf(i4));
        hashMap2.put("down_distance", String.valueOf(i));
        d.b.c.m.a h22 = d.b.c.m.c.h(3, 0, "1546854828072", a2 + 1, i2, i3);
        h22.a(hashMap2);
        return h22;
    }

    public void L0() {
        d.b.c.m.d dVar = new d.b.c.m.d(this.P, (ViewGroup) C());
        this.N0 = dVar;
        dVar.G(new a());
        q0(new b());
    }

    public void M0() {
    }

    public void N0() {
    }

    public final void O0(a2 a2Var) {
        if (a2Var == null || a2Var.o0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, a2Var.o0()));
    }

    @Override // d.b.i0.i2.q.d
    public int d0() {
        return 1;
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public boolean e0(boolean z) {
        d.b.c.m.d dVar = this.N0;
        if (dVar != null) {
            if (z) {
                if (dVar.r()) {
                    this.Q0 = false;
                    this.N0.L();
                }
            } else if (dVar.r()) {
                this.P0 = true;
                this.N0.F(true);
            }
        }
        return super.e0(z);
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public boolean isPlaying() {
        d.b.c.m.d dVar = this.N0;
        if (dVar == null || !dVar.r()) {
            return super.isPlaying();
        }
        return this.Q0 || this.N0.t();
    }

    @Override // d.b.i0.i2.q.b, d.b.i0.i2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (this.N0.I(false, false, "NEWINDEX")) {
            return;
        }
        startPlay();
    }

    @Override // d.b.i0.i2.q.b, d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public void setData(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        super.setData(a2Var);
        boolean z = this.O0 == a2Var;
        this.O0 = a2Var;
        if (this.N0 != null) {
            if (this.P0 && z) {
                this.P0 = false;
            } else {
                this.N0.B();
            }
        }
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.R0.setTag(this.S);
        MessageManager.getInstance().registerListener(this.R0);
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public void startPlay() {
        d.b.c.m.d dVar = this.N0;
        if (dVar != null && dVar.r()) {
            this.Q0 = true;
            this.N0.E();
            return;
        }
        super.startPlay();
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public void stopPlay() {
        super.stopPlay();
        d.b.c.m.d dVar = this.N0;
        if (dVar == null || !dVar.r()) {
            return;
        }
        e.a().removeCallbacks(this.S0);
        e.a().post(this.S0);
    }
}
