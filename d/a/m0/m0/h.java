package d.a.m0.m0;

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
    public boolean f53214b;

    /* renamed from: c  reason: collision with root package name */
    public long f53215c;

    /* renamed from: d  reason: collision with root package name */
    public long f53216d;

    /* renamed from: e  reason: collision with root package name */
    public long f53217e;

    /* renamed from: f  reason: collision with root package name */
    public long f53218f;

    /* renamed from: g  reason: collision with root package name */
    public long f53219g;

    /* renamed from: h  reason: collision with root package name */
    public long f53220h;

    /* renamed from: i  reason: collision with root package name */
    public long f53221i;
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
        this.f53221i = 0L;
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
        m mVar = (m) k.d().e(this.f53213a);
        if (mVar != null) {
            mVar.b(this);
        }
    }

    public void d(int i2) {
        m mVar = (m) k.d().e(this.f53213a);
        if (mVar != null) {
            mVar.c(this, i2);
        }
    }

    public void e(boolean z) {
        m mVar = (m) k.d().e(this.f53213a);
        if (mVar != null) {
            mVar.d(this, z);
        }
    }

    public h(int i2, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.f53221i = 0L;
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
        this.f53213a = i2;
        this.s = z;
        if (z) {
            this.r = responsedMessage.getDownSize();
            this.A = responsedMessage.getOrginalMessage().getClientLogID();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
            d.a.c.c.i.a aVar = responsedMessage.performanceData;
            this.w = aVar.k;
            this.x = aVar.l;
            this.t = aVar.f42059i;
            this.u = aVar.j;
        } else {
            this.q = responsedMessage.getDownSize();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
        }
        this.f53215c = j;
        this.f53216d = j4;
        this.f53217e = j2;
        this.o = j3;
        this.m = j5;
        this.f53214b = !responsedMessage.hasError();
        d.a.c.c.i.a aVar2 = responsedMessage.performanceData;
        this.f53218f = aVar2.f42051a;
        this.f53219g = aVar2.f42052b;
        this.f53220h = aVar2.f42053c;
        this.f53221i = aVar2.f42054d;
        this.j = aVar2.f42055e;
        this.k = aVar2.f42056f;
        this.l = aVar2.f42057g;
        long j7 = aVar2.f42058h;
        this.n = j7;
        this.n = j7 + (responsedMessage.getProcessTime() - responsedMessage.getStartTime());
        this.v = responsedMessage.getError();
        this.y = z2;
        this.p = j6;
    }
}
