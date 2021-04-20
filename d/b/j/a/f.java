package d.b.j.a;

import com.baidu.cesium.a.i;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: d  reason: collision with root package name */
    public b f64334d;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f64335a;

        /* renamed from: b  reason: collision with root package name */
        public Method f64336b;

        /* renamed from: c  reason: collision with root package name */
        public Method f64337c;

        public b() {
            d();
        }

        public final long b(Object obj) {
            try {
                return ((Long) this.f64337c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final void d() {
            try {
                this.f64335a = Class.forName(i.a(c.a()), true, Object.class.getClassLoader());
                this.f64336b = i.b(this.f64335a, i.a(c.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f64337c = i.b(this.f64335a, i.a(c.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void f(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.f64336b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final Object g() {
            return this.f64335a.newInstance();
        }
    }

    public f(int i, int i2) {
        this.f64331a = 32;
        this.f64332b = i;
        this.f64333c = i2;
        this.f64334d = new b();
    }

    @Override // d.b.j.a.e
    public com.baidu.cesium.a.b b(byte[] bArr, int i, int i2) {
        long j;
        try {
            Object g2 = this.f64334d.g();
            this.f64334d.f(g2, bArr, i, i2);
            j = this.f64334d.b(g2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return com.baidu.cesium.a.b.a(new long[]{j});
    }
}
