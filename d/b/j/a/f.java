package d.b.j.a;

import com.baidu.cesium.a.i;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: d  reason: collision with root package name */
    public b f63634d;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f63635a;

        /* renamed from: b  reason: collision with root package name */
        public Method f63636b;

        /* renamed from: c  reason: collision with root package name */
        public Method f63637c;

        public b() {
            d();
        }

        public final long b(Object obj) {
            try {
                return ((Long) this.f63637c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final void d() {
            try {
                this.f63635a = Class.forName(i.a(c.a()), true, Object.class.getClassLoader());
                this.f63636b = i.b(this.f63635a, i.a(c.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f63637c = i.b(this.f63635a, i.a(c.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void f(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.f63636b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final Object g() {
            return this.f63635a.newInstance();
        }
    }

    public f(int i, int i2) {
        this.f63631a = 32;
        this.f63632b = i;
        this.f63633c = i2;
        this.f63634d = new b();
    }

    @Override // d.b.j.a.e
    public com.baidu.cesium.a.b b(byte[] bArr, int i, int i2) {
        long j;
        try {
            Object g2 = this.f63634d.g();
            this.f63634d.f(g2, bArr, i, i2);
            j = this.f63634d.b(g2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return com.baidu.cesium.a.b.a(new long[]{j});
    }
}
