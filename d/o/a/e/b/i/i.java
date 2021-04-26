package d.o.a.e.b.i;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f66548a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f66549b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f66550c;

    /* renamed from: d  reason: collision with root package name */
    public long f66551d;

    /* renamed from: e  reason: collision with root package name */
    public int f66552e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f66553f;

    /* renamed from: g  reason: collision with root package name */
    public int f66554g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f66549b = atomicLong;
        this.f66554g = 0;
        this.f66548a = j;
        atomicLong.set(j);
        this.f66550c = j;
        if (j2 >= j) {
            this.f66551d = j2;
        } else {
            this.f66551d = -1L;
        }
    }

    public long a() {
        return this.f66549b.get() - this.f66548a;
    }

    public void b(int i2) {
        this.f66552e = i2;
    }

    public void c(long j) {
        if (j >= this.f66548a) {
            this.f66549b.set(j);
        }
    }

    public long d() {
        long j = this.f66551d;
        if (j >= this.f66548a) {
            return (j - k()) + 1;
        }
        return -1L;
    }

    public void e(int i2) {
        this.f66554g = i2;
    }

    public void f(long j) {
        this.f66549b.addAndGet(j);
    }

    public long g() {
        return this.f66548a;
    }

    public void h(long j) {
        if (j >= this.f66548a) {
            this.f66551d = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f66551d = j;
        }
    }

    public long i() {
        return this.f66549b.get();
    }

    public void j(long j) {
        if (j >= this.f66549b.get()) {
            this.f66550c = j;
        }
    }

    public long k() {
        l lVar = this.f66553f;
        if (lVar != null) {
            long s = lVar.s();
            if (s > this.f66550c) {
                return s;
            }
        }
        return this.f66550c;
    }

    public long l() {
        return this.f66551d;
    }

    public int m() {
        return this.f66552e;
    }

    public void n() {
        this.f66554g++;
    }

    public void o() {
        this.f66554g--;
    }

    public int p() {
        return this.f66554g;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", g());
        jSONObject.put("cu", i());
        jSONObject.put("en", l());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f66548a + ",\t currentOffset=" + this.f66549b + ",\t currentOffsetRead=" + k() + ",\t endOffset=" + this.f66551d + '}';
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f66549b = atomicLong;
        this.f66554g = 0;
        this.f66548a = iVar.f66548a;
        atomicLong.set(iVar.f66549b.get());
        this.f66550c = this.f66549b.get();
        this.f66551d = iVar.f66551d;
        this.f66552e = iVar.f66552e;
    }

    public i(JSONObject jSONObject) {
        this.f66549b = new AtomicLong();
        this.f66554g = 0;
        this.f66548a = jSONObject.optLong("st");
        h(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        j(i());
    }
}
