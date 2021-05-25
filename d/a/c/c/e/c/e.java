package d.a.c.c.e.c;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e extends d.a.c.e.r.c {
    public static Handler o = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public CoderException f38328c;

    /* renamed from: d  reason: collision with root package name */
    public SocketMessage f38329d;

    /* renamed from: g  reason: collision with root package name */
    public g f38332g;
    public SocketMessageTask l;
    public long m;
    public long n;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f38330e = 0;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f38331f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38333h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f38334i = 0;
    public int j = 0;
    public long k = 0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.A();
        }
    }

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.f38329d = null;
        this.f38332g = null;
        this.l = null;
        if (socketMessage != null && socketMessageTask != null) {
            this.l = socketMessageTask;
            this.f38329d = socketMessage;
            this.f38332g = gVar;
            return;
        }
        throw new InvalidParameterException("SenderData msg null");
    }

    public final void A() {
        g gVar = this.f38332g;
        if (gVar == null || !this.f38333h) {
            return;
        }
        gVar.B(this);
    }

    @Override // d.a.c.e.r.f0
    public void a(int i2) {
        o.removeCallbacks(u());
        x(i2);
    }

    @Override // d.a.c.e.r.f0
    public void b() {
        if (this.k == 0) {
            this.k = System.currentTimeMillis();
        }
        int cmd = this.f38329d.getCmd();
        int length = e() != null ? e().length : 0;
        long clientLogID = this.f38329d.getClientLogID();
        int i2 = this.f38330e;
        i.b("SenderData", cmd, clientLogID, i2, "StartSend", 0, "SenderData: start send size = " + length);
        o.removeCallbacks(u());
        if (this.l.getTimeOut() != null) {
            o.postDelayed(u(), this.l.getTimeOut().b());
        }
        z();
    }

    @Override // d.a.c.e.r.f0
    public void c() {
        int i2;
        int cmd = this.f38329d.getCmd();
        if (e() != null) {
            i2 = e().length;
            this.f38329d.setEncodedBinarySize(i2);
        } else {
            i2 = 0;
        }
        long clientLogID = this.f38329d.getClientLogID();
        int i3 = this.f38330e;
        i.b("SenderData", cmd, clientLogID, i3, "FinishSend", 0, "SenderData: finish send  size = " + i2);
        if (!this.l.b()) {
            o.removeCallbacks(u());
        }
        y();
    }

    @Override // d.a.c.e.r.c
    public byte[] d() {
        if (this.k == 0) {
            this.k = System.currentTimeMillis();
        }
        this.f38328c = null;
        d.a.c.c.e.c.j.b f2 = d.a.c.c.e.c.j.b.f();
        this.f38330e = f.a().b();
        SocketMessage socketMessage = this.f38329d;
        if (socketMessage != null) {
            socketMessage.setSquencedId(this.f38330e);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            SocketMessage socketMessage2 = this.f38329d;
            long clientLogID = socketMessage2 == null ? -1L : socketMessage2.getClientLogID();
            String valueOf = String.valueOf(this.f38330e & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = "cmd";
            SocketMessage socketMessage3 = this.f38329d;
            objArr[1] = Integer.valueOf(socketMessage3 == null ? -1 : socketMessage3.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return f2.e(this.f38329d, this.f38330e, this.l.c(), this.l.getNeedEncrypt());
        } catch (CoderException e2) {
            this.f38328c = e2;
            return null;
        }
    }

    public int g() {
        int i2 = this.j + 1;
        this.j = i2;
        return i2;
    }

    public int h() {
        int i2 = this.f38334i + 1;
        this.f38334i = i2;
        return i2;
    }

    public boolean i() {
        return this.l.d();
    }

    public void j() {
        o.removeCallbacks(u());
    }

    public int k() {
        SocketMessage socketMessage = this.f38329d;
        if (socketMessage != null) {
            return socketMessage.getCmd();
        }
        return 0;
    }

    public int l() {
        int retry = this.l.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    public SocketMessage m() {
        return this.f38329d;
    }

    public int n() {
        return this.l.getPriority();
    }

    public int o() {
        return this.j;
    }

    public int p() {
        return this.f38334i;
    }

    public int q() {
        return this.f38330e;
    }

    public CoderException r() {
        return this.f38328c;
    }

    public long s() {
        return this.k;
    }

    public SocketMessageTask t() {
        return this.l;
    }

    public final Runnable u() {
        if (this.f38331f == null) {
            this.f38331f = new a();
        }
        return this.f38331f;
    }

    public boolean v() {
        return this.l.b();
    }

    public void w() {
        j();
        this.f38333h = false;
    }

    public final void x(int i2) {
        g gVar = this.f38332g;
        if (gVar == null || !this.f38333h) {
            return;
        }
        gVar.y(i2, this);
    }

    public final void y() {
        g gVar = this.f38332g;
        if (gVar == null || !this.f38333h) {
            return;
        }
        gVar.z(this);
    }

    public final void z() {
        g gVar = this.f38332g;
        if (gVar == null || !this.f38333h) {
            return;
        }
        gVar.A(this);
    }
}
