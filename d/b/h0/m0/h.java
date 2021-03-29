package d.b.h0.m0;

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
    public boolean f50322b;

    /* renamed from: c  reason: collision with root package name */
    public long f50323c;

    /* renamed from: d  reason: collision with root package name */
    public long f50324d;

    /* renamed from: e  reason: collision with root package name */
    public long f50325e;

    /* renamed from: f  reason: collision with root package name */
    public long f50326f;

    /* renamed from: g  reason: collision with root package name */
    public long f50327g;

    /* renamed from: h  reason: collision with root package name */
    public long f50328h;
    public long i;
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
        this.i = 0L;
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
        if (d.b.b.e.p.k.isEmpty(str) || d.b.b.e.p.k.isEmpty(str2)) {
            return;
        }
        this.E.put(str, str2);
    }

    public void c() {
        m mVar = (m) k.d().e(this.f50321a);
        if (mVar != null) {
            mVar.b(this);
        }
    }

    public void d(int i) {
        m mVar = (m) k.d().e(this.f50321a);
        if (mVar != null) {
            mVar.c(this, i);
        }
    }

    public void e(boolean z) {
        m mVar = (m) k.d().e(this.f50321a);
        if (mVar != null) {
            mVar.d(this, z);
        }
    }

    public h(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.i = 0L;
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
        this.f50321a = i;
        this.s = z;
        if (z) {
            this.r = responsedMessage.getDownSize();
            this.A = responsedMessage.getOrginalMessage().getClientLogID();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
            d.b.b.c.i.a aVar = responsedMessage.performanceData;
            this.w = aVar.k;
            this.x = aVar.l;
            this.t = aVar.i;
            this.u = aVar.j;
        } else {
            this.q = responsedMessage.getDownSize();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
        }
        this.f50323c = j;
        this.f50324d = j4;
        this.f50325e = j2;
        this.o = j3;
        this.m = j5;
        this.f50322b = !responsedMessage.hasError();
        d.b.b.c.i.a aVar2 = responsedMessage.performanceData;
        this.f50326f = aVar2.f41560a;
        this.f50327g = aVar2.f41561b;
        this.f50328h = aVar2.f41562c;
        this.i = aVar2.f41563d;
        this.j = aVar2.f41564e;
        this.k = aVar2.f41565f;
        this.l = aVar2.f41566g;
        long j7 = aVar2.f41567h;
        this.n = j7;
        this.n = j7 + (responsedMessage.getProcessTime() - responsedMessage.getStartTime());
        this.v = responsedMessage.getError();
        this.y = z2;
        this.p = j6;
    }
}
