package d.a.r0.a;

import android.content.Context;
import d.a.r0.a.f.i;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f68090a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68091b;

    /* renamed from: c  reason: collision with root package name */
    public long f68092c;

    /* renamed from: d  reason: collision with root package name */
    public long f68093d;

    /* renamed from: e  reason: collision with root package name */
    public long f68094e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68095f;

    /* renamed from: g  reason: collision with root package name */
    public int f68096g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f68097a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f68098b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f68099c = 30000;

        /* renamed from: d  reason: collision with root package name */
        public long f68100d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public long f68101e = 10000;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68102f = false;

        /* renamed from: g  reason: collision with root package name */
        public int f68103g = 1000;

        public b c() {
            if (this.f68097a == null) {
                i.b("Context must be not empty!");
                return null;
            }
            return new b(this, (byte) 0);
        }

        public a e(Context context) {
            this.f68097a = context;
            return this;
        }

        public a j(boolean z) {
            this.f68098b = z;
            return this;
        }

        public a k(int i2) {
            if (i2 <= 0) {
                i2 = 0;
            }
            if (i2 >= 1000) {
                i2 = 1000;
            }
            this.f68103g = i2;
            return this;
        }

        public a l(boolean z) {
            this.f68102f = z;
            return this;
        }

        public a m(int i2) {
            this.f68100d = i2 * 60 * 1000;
            return this;
        }

        public a n(long j) {
            this.f68099c = j * 1000;
            return this;
        }

        public a o(long j) {
            this.f68101e = j * 1000;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        return this.f68090a;
    }

    public final boolean b() {
        return this.f68091b;
    }

    public final long c() {
        return this.f68092c;
    }

    public final long d() {
        return this.f68093d;
    }

    public final long e() {
        return this.f68094e;
    }

    public final boolean f() {
        return this.f68095f;
    }

    public final int g() {
        return this.f68096g;
    }

    public b(a aVar) {
        this.f68090a = aVar.f68097a;
        this.f68091b = aVar.f68098b;
        this.f68092c = aVar.f68099c;
        this.f68093d = aVar.f68100d;
        this.f68095f = aVar.f68102f;
        this.f68094e = aVar.f68101e;
        this.f68096g = aVar.f68103g;
    }
}
