package d.a.j.a;

import com.baidu.cesium.a.i;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class f extends e {

    /* renamed from: d  reason: collision with root package name */
    public b f43777d;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f43778a;

        /* renamed from: b  reason: collision with root package name */
        public Method f43779b;

        /* renamed from: c  reason: collision with root package name */
        public Method f43780c;

        public b() {
            d();
        }

        public final long b(Object obj) {
            try {
                return ((Long) this.f43780c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final void d() {
            try {
                this.f43778a = Class.forName(i.a(c.a()), true, Object.class.getClassLoader());
                this.f43779b = i.b(this.f43778a, i.a(c.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f43780c = i.b(this.f43778a, i.a(c.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void f(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f43779b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final Object g() {
            return this.f43778a.newInstance();
        }
    }

    public f(int i2, int i3) {
        this.f43774a = 32;
        this.f43775b = i2;
        this.f43776c = i3;
        this.f43777d = new b();
    }

    @Override // d.a.j.a.e
    public com.baidu.cesium.a.b b(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object g2 = this.f43777d.g();
            this.f43777d.f(g2, bArr, i2, i3);
            j = this.f43777d.b(g2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return com.baidu.cesium.a.b.a(new long[]{j});
    }
}
