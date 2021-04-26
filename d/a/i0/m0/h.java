package d.a.i0.m0;

import com.baidu.adp.framework.message.ResponsedMessage;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class h extends g {
    public long A;
    public long B;
    public long C;
    public long D;
    public HashMap<String, String> E;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48666b;

    /* renamed from: c  reason: collision with root package name */
    public long f48667c;

    /* renamed from: d  reason: collision with root package name */
    public long f48668d;

    /* renamed from: e  reason: collision with root package name */
    public long f48669e;

    /* renamed from: f  reason: collision with root package name */
    public long f48670f;

    /* renamed from: g  reason: collision with root package name */
    public long f48671g;

    /* renamed from: h  reason: collision with root package name */
    public long f48672h;

    /* renamed from: i  reason: collision with root package name */
    public long f48673i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public boolean s;
    public int t;
    public long u;
    public int v;
    public long w;
    public long x;
    public boolean y;
    public long z;

    public h() {
        this.f48673i = 0L;
        this.j = 0L;
        this.n = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = false;
        this.E = new HashMap<>();
    }

    public void b(String str, String str2) {
        if (d.a.c.e.p.k.isEmpty(str) || d.a.c.e.p.k.isEmpty(str2)) {
            return;
        }
        this.E.put(str, str2);
    }

    public void c() {
        m mVar = (m) k.d().e(this.f48665a);
        if (mVar != null) {
            mVar.b(this);
        }
    }

    public void d(int i2) {
        m mVar = (m) k.d().e(this.f48665a);
        if (mVar != null) {
            mVar.c(this, i2);
        }
    }

    public void e(boolean z) {
        m mVar = (m) k.d().e(this.f48665a);
        if (mVar != null) {
            mVar.d(this, z);
        }
    }

    public h(int i2, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.f48673i = 0L;
        this.j = 0L;
        this.n = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = false;
        this.E = new HashMap<>();
        if (responsedMessage == null) {
            return;
        }
        this.f48665a = i2;
        this.s = z;
        if (z) {
            this.r = responsedMessage.getDownSize();
            this.A = responsedMessage.getOrginalMessage().getClientLogID();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
            d.a.c.c.i.a aVar = responsedMessage.performanceData;
            this.w = aVar.k;
            this.x = aVar.l;
            this.t = aVar.f39497i;
            this.u = aVar.j;
        } else {
            this.q = responsedMessage.getDownSize();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
        }
        this.f48667c = j;
        this.f48668d = j4;
        this.f48669e = j2;
        this.o = j3;
        this.m = j5;
        this.f48666b = !responsedMessage.hasError();
        d.a.c.c.i.a aVar2 = responsedMessage.performanceData;
        this.f48670f = aVar2.f39489a;
        this.f48671g = aVar2.f39490b;
        this.f48672h = aVar2.f39491c;
        this.f48673i = aVar2.f39492d;
        this.j = aVar2.f39493e;
        this.k = aVar2.f39494f;
        this.l = aVar2.f39495g;
        long j7 = aVar2.f39496h;
        this.n = j7;
        this.n = j7 + (responsedMessage.getProcessTime() - responsedMessage.getStartTime());
        this.v = responsedMessage.getError();
        this.y = z2;
        this.p = j6;
    }
}
