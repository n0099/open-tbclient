package d.a.r0.a;

import android.content.Context;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.a.r0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f64372a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64373b;

    /* renamed from: c  reason: collision with root package name */
    public long f64374c;

    /* renamed from: d  reason: collision with root package name */
    public long f64375d;

    /* renamed from: e  reason: collision with root package name */
    public long f64376e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64377f;

    /* renamed from: g  reason: collision with root package name */
    public int f64378g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f64379a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64380b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f64381c = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

        /* renamed from: d  reason: collision with root package name */
        public long f64382d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f64383e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64384f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f64385g = 1000;

        public b c() {
            if (this.f64379a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f64379a = context;
            return this;
        }

        public a j(boolean z) {
            this.f64380b = z;
            return this;
        }

        public a k(int i2) {
            if (i2 <= 0) {
                i2 = 0;
            }
            if (i2 >= 1000) {
                i2 = 1000;
            }
            this.f64385g = i2;
            return this;
        }

        public a l(boolean z) {
            this.f64384f = z;
            return this;
        }

        public a m(int i2) {
            this.f64382d = i2 * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f64381c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f64383e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f64372a;
    }

    public final boolean b() {
        return this.f64373b;
    }

    public final long c() {
        return this.f64374c;
    }

    public final long d() {
        return this.f64375d;
    }

    public final long e() {
        return this.f64376e;
    }

    public final boolean f() {
        return this.f64377f;
    }

    public final int g() {
        return this.f64378g;
    }

    public b(a aVar) {
        this.f64372a = aVar.f64379a;
        this.f64373b = aVar.f64380b;
        this.f64374c = aVar.f64381c;
        this.f64375d = aVar.f64382d;
        this.f64377f = aVar.f64384f;
        this.f64376e = aVar.f64383e;
        this.f64378g = aVar.f64385g;
    }
}
