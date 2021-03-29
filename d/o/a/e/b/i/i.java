package d.o.a.e.b.i;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f67044a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f67045b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f67046c;

    /* renamed from: d  reason: collision with root package name */
    public long f67047d;

    /* renamed from: e  reason: collision with root package name */
    public int f67048e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f67049f;

    /* renamed from: g  reason: collision with root package name */
    public int f67050g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f67045b = atomicLong;
        this.f67050g = 0;
        this.f67044a = j;
        atomicLong.set(j);
        this.f67046c = j;
        if (j2 >= j) {
            this.f67047d = j2;
        } else {
            this.f67047d = -1L;
        }
    }

    public long a() {
        return this.f67045b.get() - this.f67044a;
    }

    public void b(int i) {
        this.f67048e = i;
    }

    public void c(long j) {
        if (j >= this.f67044a) {
            this.f67045b.set(j);
        }
    }

    public long d() {
        long j = this.f67047d;
        if (j >= this.f67044a) {
            return (j - k()) + 1;
        }
        return -1L;
    }

    public void e(int i) {
        this.f67050g = i;
    }

    public void f(long j) {
        this.f67045b.addAndGet(j);
    }

    public long g() {
        return this.f67044a;
    }

    public void h(long j) {
        if (j >= this.f67044a) {
            this.f67047d = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f67047d = j;
        }
    }

    public long i() {
        return this.f67045b.get();
    }

    public void j(long j) {
        if (j >= this.f67045b.get()) {
            this.f67046c = j;
        }
    }

    public long k() {
        l lVar = this.f67049f;
        if (lVar != null) {
            long s = lVar.s();
            if (s > this.f67046c) {
                return s;
            }
        }
        return this.f67046c;
    }

    public long l() {
        return this.f67047d;
    }

    public int m() {
        return this.f67048e;
    }

    public void n() {
        this.f67050g++;
    }

    public void o() {
        this.f67050g--;
    }

    public int p() {
        return this.f67050g;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", g());
        jSONObject.put("cu", i());
        jSONObject.put("en", l());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f67044a + ",\t currentOffset=" + this.f67045b + ",\t currentOffsetRead=" + k() + ",\t endOffset=" + this.f67047d + '}';
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f67045b = atomicLong;
        this.f67050g = 0;
        this.f67044a = iVar.f67044a;
        atomicLong.set(iVar.f67045b.get());
        this.f67046c = this.f67045b.get();
        this.f67047d = iVar.f67047d;
        this.f67048e = iVar.f67048e;
    }

    public i(JSONObject jSONObject) {
        this.f67045b = new AtomicLong();
        this.f67050g = 0;
        this.f67044a = jSONObject.optLong("st");
        h(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        j(i());
    }
}
