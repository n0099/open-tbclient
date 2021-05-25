package d.a.n0.b1.g.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import d.a.c.e.m.e;
import d.a.d.m.d;
import d.a.m0.r.q.a2;
import d.a.n0.k2.q.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class c extends d.a.n0.k2.q.b {
    public d.a.d.m.d O0;
    public a2 P0;
    public boolean Q0;
    public boolean R0;
    public CustomMessageListener S0;
    public Runnable T0;

    /* loaded from: classes4.dex */
    public class a implements d.InterfaceC0517d {
        public a() {
        }

        @Override // d.a.d.m.d.InterfaceC0517d
        public void a() {
            c.this.startPlay();
        }

        @Override // d.a.d.m.d.InterfaceC0517d
        public void b() {
        }

        @Override // d.a.d.m.d.InterfaceC0517d
        public void c() {
        }

        @Override // d.a.d.m.d.InterfaceC0517d
        public boolean d() {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.k {
        public b() {
        }

        @Override // d.a.n0.k2.q.d.k
        public void a(int i2, int i3) {
            if (c.this.h0()) {
                return;
            }
            if (i3 >= i2) {
                c.this.O0.I(false, false, "NEWINDEX");
            } else if (i2 == 0 || c.this.U || (i3 * 100) / i2 < 80 || i2 <= 15000) {
            } else {
                c cVar = c.this;
                cVar.P0(cVar.P0);
            }
        }
    }

    /* renamed from: d.a.n0.b1.g.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1208c extends CustomMessageListener {
        public C1208c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.d.m.e.b bVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.d.m.e.b) || (bVar = (d.a.d.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || c.this.P0 == null || !d2.equals(c.this.P0.o0())) {
                return;
            }
            d.a.d.m.d dVar = c.this.O0;
            c cVar = c.this;
            dVar.K(cVar.L0(cVar.P0, bVar));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.O0 != null) {
                c cVar = c.this;
                cVar.R0 = false;
                cVar.O0.L();
                c.this.O0.w();
            }
        }
    }

    public c(Context context, View view) {
        super(context, view);
        this.Q0 = false;
        this.S0 = new C1208c(2921395);
        this.T0 = new d();
        p0(true);
        M0();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.d.m.a L0(a2 a2Var, d.a.d.m.e.b bVar) {
        int i2;
        VideoInfo w1;
        int i3;
        int i4;
        if (a2Var == null || bVar == null) {
            return null;
        }
        int c2 = bVar.c();
        int b2 = bVar.b();
        int a2 = bVar.a();
        int i5 = -1;
        if (a2 != -1) {
            int i6 = c2 != -1 ? (a2 - c2) - 1 : -1;
            if (b2 != -1) {
                i5 = i6;
                i2 = (b2 - a2) - 1;
                w1 = a2Var.w1();
                if (w1 == null) {
                    int intValue = w1.video_width.intValue();
                    i4 = w1.video_height.intValue();
                    i3 = intValue;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("video_vid", a2Var.o0());
                hashMap.put("video_title", a2Var.z1());
                hashMap.put("forum_id", String.valueOf(a2Var.c0()));
                hashMap.put("forum_name", a2Var.i0());
                hashMap.put("up_distance", String.valueOf(i5));
                hashMap.put("down_distance", String.valueOf(i2));
                d.a.d.m.a h2 = d.a.d.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
                h2.a(hashMap);
                return h2;
            }
            i5 = i6;
        }
        i2 = -1;
        w1 = a2Var.w1();
        if (w1 == null) {
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("video_vid", a2Var.o0());
        hashMap2.put("video_title", a2Var.z1());
        hashMap2.put("forum_id", String.valueOf(a2Var.c0()));
        hashMap2.put("forum_name", a2Var.i0());
        hashMap2.put("up_distance", String.valueOf(i5));
        hashMap2.put("down_distance", String.valueOf(i2));
        d.a.d.m.a h22 = d.a.d.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
        h22.a(hashMap2);
        return h22;
    }

    public void M0() {
        d.a.d.m.d dVar = new d.a.d.m.d(this.P, (ViewGroup) E());
        this.O0 = dVar;
        dVar.G(new a());
        q0(new b());
    }

    public void N0() {
    }

    public void O0() {
    }

    public final void P0(a2 a2Var) {
        if (a2Var == null || a2Var.o0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, a2Var.o0()));
    }

    @Override // d.a.n0.k2.q.d
    public int a0() {
        return 1;
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public boolean isPlaying() {
        d.a.d.m.d dVar = this.O0;
        if (dVar == null || !dVar.r()) {
            return super.isPlaying();
        }
        return this.R0 || this.O0.t();
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public boolean o0(boolean z) {
        d.a.d.m.d dVar = this.O0;
        if (dVar != null) {
            if (z) {
                if (dVar.r()) {
                    this.R0 = false;
                    this.O0.L();
                }
            } else if (dVar.r()) {
                this.Q0 = true;
                this.O0.F(true);
            }
        }
        return super.o0(z);
    }

    @Override // d.a.n0.k2.q.b, d.a.n0.k2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (this.O0.I(false, false, "NEWINDEX")) {
            return;
        }
        startPlay();
    }

    @Override // d.a.n0.k2.q.b, d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public void setData(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        super.setData(a2Var);
        boolean z = this.P0 == a2Var;
        this.P0 = a2Var;
        if (this.O0 != null) {
            if (this.Q0 && z) {
                this.Q0 = false;
            } else {
                this.O0.B();
            }
        }
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.S0.setTag(this.S);
        MessageManager.getInstance().registerListener(this.S0);
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public void startPlay() {
        d.a.d.m.d dVar = this.O0;
        if (dVar != null && dVar.r()) {
            this.R0 = true;
            this.O0.E();
            return;
        }
        super.startPlay();
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public void stopPlay() {
        super.stopPlay();
        d.a.d.m.d dVar = this.O0;
        if (dVar == null || !dVar.r()) {
            return;
        }
        e.a().removeCallbacks(this.T0);
        e.a().post(this.T0);
    }
}
