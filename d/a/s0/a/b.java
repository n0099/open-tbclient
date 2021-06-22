package d.a.s0.a;

import android.content.Context;
import d.a.s0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f68206a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68207b;

    /* renamed from: c  reason: collision with root package name */
    public long f68208c;

    /* renamed from: d  reason: collision with root package name */
    public long f68209d;

    /* renamed from: e  reason: collision with root package name */
    public long f68210e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68211f;

    /* renamed from: g  reason: collision with root package name */
    public int f68212g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f68213a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f68214b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f68215c = 30000;

        /* renamed from: d  reason: collision with root package name */
        public long f68216d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f68217e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68218f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f68219g = 1000;

        public b c() {
            if (this.f68213a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f68213a = context;
            return this;
        }

        public a j(boolean z) {
            this.f68214b = z;
            return this;
        }

        public a k(int i2) {
            if (i2 <= 0) {
                i2 = 0;
            }
            if (i2 >= 1000) {
                i2 = 1000;
            }
            this.f68219g = i2;
            return this;
        }

        public a l(boolean z) {
            this.f68218f = z;
            return this;
        }

        public a m(int i2) {
            this.f68216d = i2 * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f68215c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f68217e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f68206a;
    }

    public final boolean b() {
        return this.f68207b;
    }

    public final long c() {
        return this.f68208c;
    }

    public final long d() {
        return this.f68209d;
    }

    public final long e() {
        return this.f68210e;
    }

    public final boolean f() {
        return this.f68211f;
    }

    public final int g() {
        return this.f68212g;
    }

    public b(a aVar) {
        this.f68206a = aVar.f68213a;
        this.f68207b = aVar.f68214b;
        this.f68208c = aVar.f68215c;
        this.f68209d = aVar.f68216d;
        this.f68211f = aVar.f68218f;
        this.f68210e = aVar.f68217e;
        this.f68212g = aVar.f68219g;
    }
}
