package d.o.a.e.b.i;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f67277a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f67278b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f67279c;

    /* renamed from: d  reason: collision with root package name */
    public long f67280d;

    /* renamed from: e  reason: collision with root package name */
    public int f67281e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f67282f;

    /* renamed from: g  reason: collision with root package name */
    public int f67283g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f67278b = atomicLong;
        this.f67283g = 0;
        this.f67277a = j;
        atomicLong.set(j);
        this.f67279c = j;
        if (j2 >= j) {
            this.f67280d = j2;
        } else {
            this.f67280d = -1L;
        }
    }

    public long a() {
        return this.f67278b.get() - this.f67277a;
    }

    public void b(int i2) {
        this.f67281e = i2;
    }

    public void c(long j) {
        if (j >= this.f67277a) {
            this.f67278b.set(j);
        }
    }

    public long d() {
        long j = this.f67280d;
        if (j >= this.f67277a) {
            return (j - k()) + 1;
        }
        return -1L;
    }

    public void e(int i2) {
        this.f67283g = i2;
    }

    public void f(long j) {
        this.f67278b.addAndGet(j);
    }

    public long g() {
        return this.f67277a;
    }

    public void h(long j) {
        if (j >= this.f67277a) {
            this.f67280d = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f67280d = j;
        }
    }

    public long i() {
        return this.f67278b.get();
    }

    public void j(long j) {
        if (j >= this.f67278b.get()) {
            this.f67279c = j;
        }
    }

    public long k() {
        l lVar = this.f67282f;
        if (lVar != null) {
            long s = lVar.s();
            if (s > this.f67279c) {
                return s;
            }
        }
        return this.f67279c;
    }

    public long l() {
        return this.f67280d;
    }

    public int m() {
        return this.f67281e;
    }

    public void n() {
        this.f67283g++;
    }

    public void o() {
        this.f67283g--;
    }

    public int p() {
        return this.f67283g;
    }

    public JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", g());
        jSONObject.put("cu", i());
        jSONObject.put("en", l());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f67277a + ",\t currentOffset=" + this.f67278b + ",\t currentOffsetRead=" + k() + ",\t endOffset=" + this.f67280d + '}';
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f67278b = atomicLong;
        this.f67283g = 0;
        this.f67277a = iVar.f67277a;
        atomicLong.set(iVar.f67278b.get());
        this.f67279c = this.f67278b.get();
        this.f67280d = iVar.f67280d;
        this.f67281e = iVar.f67281e;
    }

    public i(JSONObject jSONObject) {
        this.f67278b = new AtomicLong();
        this.f67283g = 0;
        this.f67277a = jSONObject.optLong("st");
        h(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        j(i());
    }
}
