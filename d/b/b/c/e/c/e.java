package d.b.b.c.e.c;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e extends d.b.b.e.r.c {
    public static Handler o = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public CoderException f41497c;

    /* renamed from: d  reason: collision with root package name */
    public SocketMessage f41498d;

    /* renamed from: g  reason: collision with root package name */
    public g f41501g;
    public SocketMessageTask l;
    public long m;
    public long n;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f41499e = 0;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f41500f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41502h = true;
    public int i = 0;
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
        this.f41498d = null;
        this.f41501g = null;
        this.l = null;
        if (socketMessage != null && socketMessageTask != null) {
            this.l = socketMessageTask;
            this.f41498d = socketMessage;
            this.f41501g = gVar;
            return;
        }
        throw new InvalidParameterException("SenderData msg null");
    }

    public final void A() {
        g gVar = this.f41501g;
        if (gVar == null || !this.f41502h) {
            return;
        }
        gVar.B(this);
    }

    @Override // d.b.b.e.r.f0
    public void a(int i) {
        o.removeCallbacks(u());
        x(i);
    }

    @Override // d.b.b.e.r.f0
    public void b() {
        if (this.k == 0) {
            this.k = System.currentTimeMillis();
        }
        int cmd = this.f41498d.getCmd();
        int length = e() != null ? e().length : 0;
        long clientLogID = this.f41498d.getClientLogID();
        int i = this.f41499e;
        i.b("SenderData", cmd, clientLogID, i, "StartSend", 0, "SenderData: start send size = " + length);
        o.removeCallbacks(u());
        if (this.l.getTimeOut() != null) {
            o.postDelayed(u(), this.l.getTimeOut().b());
        }
        z();
    }

    @Override // d.b.b.e.r.f0
    public void c() {
        int i;
        int cmd = this.f41498d.getCmd();
        if (e() != null) {
            i = e().length;
            this.f41498d.setEncodedBinarySize(i);
        } else {
            i = 0;
        }
        long clientLogID = this.f41498d.getClientLogID();
        int i2 = this.f41499e;
        i.b("SenderData", cmd, clientLogID, i2, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.l.b()) {
            o.removeCallbacks(u());
        }
        y();
    }

    @Override // d.b.b.e.r.c
    public byte[] d() {
        if (this.k == 0) {
            this.k = System.currentTimeMillis();
        }
        this.f41497c = null;
        d.b.b.c.e.c.j.b f2 = d.b.b.c.e.c.j.b.f();
        this.f41499e = f.a().b();
        SocketMessage socketMessage = this.f41498d;
        if (socketMessage != null) {
            socketMessage.setSquencedId(this.f41499e);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            SocketMessage socketMessage2 = this.f41498d;
            long clientLogID = socketMessage2 == null ? -1L : socketMessage2.getClientLogID();
            String valueOf = String.valueOf(this.f41499e & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = "cmd";
            SocketMessage socketMessage3 = this.f41498d;
            objArr[1] = Integer.valueOf(socketMessage3 == null ? -1 : socketMessage3.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return f2.e(this.f41498d, this.f41499e, this.l.c(), this.l.getNeedEncrypt());
        } catch (CoderException e2) {
            this.f41497c = e2;
            return null;
        }
    }

    public int g() {
        int i = this.j + 1;
        this.j = i;
        return i;
    }

    public int h() {
        int i = this.i + 1;
        this.i = i;
        return i;
    }

    public boolean i() {
        return this.l.d();
    }

    public void j() {
        o.removeCallbacks(u());
    }

    public int k() {
        SocketMessage socketMessage = this.f41498d;
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
        return this.f41498d;
    }

    public int n() {
        return this.l.getPriority();
    }

    public int o() {
        return this.j;
    }

    public int p() {
        return this.i;
    }

    public int q() {
        return this.f41499e;
    }

    public CoderException r() {
        return this.f41497c;
    }

    public long s() {
        return this.k;
    }

    public SocketMessageTask t() {
        return this.l;
    }

    public final Runnable u() {
        if (this.f41500f == null) {
            this.f41500f = new a();
        }
        return this.f41500f;
    }

    public boolean v() {
        return this.l.b();
    }

    public void w() {
        j();
        this.f41502h = false;
    }

    public final void x(int i) {
        g gVar = this.f41501g;
        if (gVar == null || !this.f41502h) {
            return;
        }
        gVar.y(i, this);
    }

    public final void y() {
        g gVar = this.f41501g;
        if (gVar == null || !this.f41502h) {
            return;
        }
        gVar.z(this);
    }

    public final void z() {
        g gVar = this.f41501g;
        if (gVar == null || !this.f41502h) {
            return;
        }
        gVar.A(this);
    }
}
