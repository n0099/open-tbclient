package d.o.a.e.b.i;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f67039a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f67040b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f67041c;

    /* renamed from: d  reason: collision with root package name */
    public long f67042d;

    /* renamed from: e  reason: collision with root package name */
    public int f67043e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f67044f;

    /* renamed from: g  reason: collision with root package name */
    public int f67045g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f67040b = atomicLong;
        this.f67045g = 0;
        this.f67039a = j;
        atomicLong.set(j);
        this.f67041c = j;
        if (j2 >= j) {
            this.f67042d = j2;
        } else {
            this.f67042d = -1L;
        }
    }

    public long a() {
        return this.f67040b.get() - this.f67039a;
    }

    public void b(int i) {
        this.f67043e = i;
    }

    public void c(long j) {
        if (j >= this.f67039a) {
            this.f67040b.set(j);
        }
    }

    public long d() {
        long j = this.f67042d;
        if (j >= this.f67039a) {
            return (j - k()) + 1;
        }
        return -1L;
    }

    public void e(int i) {
        this.f67045g = i;
    }

    public void f(long j) {
        this.f67040b.addAndGet(j);
    }

    public long g() {
        return this.f67039a;
    }

    public void h(long j) {
        if (j >= this.f67039a) {
            this.f67042d = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f67042d = j;
        }
    }

    public long i() {
        return this.f67040b.get();
    }

    public void j(long j) {
        if (j >= this.f67040b.get()) {
            this.f67041c = j;
        }
    }

    public long k() {
        l lVar = this.f67044f;
        if (lVar != null) {
            long s = lVar.s();
            if (s > this.f67041c) {
                return s;
            }
        }
        return this.f67041c;
    }

    public long l() {
        return this.f67042d;
    }

    public int m() {
        return this.f67043e;
    }

    public void n() {
        this.f67045g++;
    }

    public void o() {
        this.f67045g--;
    }

    public int p() {
        return this.f67045g;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", g());
        jSONObject.put("cu", i());
        jSONObject.put("en", l());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f67039a + ",\t currentOffset=" + this.f67040b + ",\t currentOffsetRead=" + k() + ",\t endOffset=" + this.f67042d + '}';
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f67040b = atomicLong;
        this.f67045g = 0;
        this.f67039a = iVar.f67039a;
        atomicLong.set(iVar.f67040b.get());
        this.f67041c = this.f67040b.get();
        this.f67042d = iVar.f67042d;
        this.f67043e = iVar.f67043e;
    }

    public i(JSONObject jSONObject) {
        this.f67040b = new AtomicLong();
        this.f67045g = 0;
        this.f67039a = jSONObject.optLong("st");
        h(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        j(i());
    }
}
