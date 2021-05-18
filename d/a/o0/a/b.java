package d.a.o0.a;

import android.content.Context;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.a.o0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f64045a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64046b;

    /* renamed from: c  reason: collision with root package name */
    public long f64047c;

    /* renamed from: d  reason: collision with root package name */
    public long f64048d;

    /* renamed from: e  reason: collision with root package name */
    public long f64049e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64050f;

    /* renamed from: g  reason: collision with root package name */
    public int f64051g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f64052a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64053b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f64054c = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

        /* renamed from: d  reason: collision with root package name */
        public long f64055d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f64056e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64057f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f64058g = 1000;

        public b c() {
            if (this.f64052a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f64052a = context;
            return this;
        }

        public a j(boolean z) {
            this.f64053b = z;
            return this;
        }

        public a k(int i2) {
            if (i2 <= 0) {
                i2 = 0;
            }
            if (i2 >= 1000) {
                i2 = 1000;
            }
            this.f64058g = i2;
            return this;
        }

        public a l(boolean z) {
            this.f64057f = z;
            return this;
        }

        public a m(int i2) {
            this.f64055d = i2 * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f64054c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f64056e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f64045a;
    }

    public final boolean b() {
        return this.f64046b;
    }

    public final long c() {
        return this.f64047c;
    }

    public final long d() {
        return this.f64048d;
    }

    public final long e() {
        return this.f64049e;
    }

    public final boolean f() {
        return this.f64050f;
    }

    public final int g() {
        return this.f64051g;
    }

    public b(a aVar) {
        this.f64045a = aVar.f64052a;
        this.f64046b = aVar.f64053b;
        this.f64047c = aVar.f64054c;
        this.f64048d = aVar.f64055d;
        this.f64050f = aVar.f64057f;
        this.f64049e = aVar.f64056e;
        this.f64051g = aVar.f64058g;
    }
}
