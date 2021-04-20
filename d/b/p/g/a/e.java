package d.b.p.g.a;

import com.baidu.helios.common.cc.n;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class e extends d {

    /* renamed from: d  reason: collision with root package name */
    public b f65102d;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f65103a;

        /* renamed from: b  reason: collision with root package name */
        public Method f65104b;

        /* renamed from: c  reason: collision with root package name */
        public Method f65105c;

        public b() {
            d();
        }

        public final long b(Object obj) {
            try {
                return ((Long) this.f65105c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new n.a("");
            }
        }

        public final void d() {
            try {
                this.f65103a = Class.forName(n.a(h.a()), true, Object.class.getClassLoader());
                this.f65104b = n.b(this.f65103a, n.a(h.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f65105c = n.b(this.f65103a, n.a(h.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void f(Object obj, byte[] bArr, int i, int i2) {
            try {
                this.f65104b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception unused) {
                throw new n.a("");
            }
        }

        public final Object g() {
            return this.f65103a.newInstance();
        }
    }

    public e(int i, int i2) {
        this.f65099a = 32;
        this.f65100b = i;
        this.f65101c = i2;
        this.f65102d = new b();
    }

    @Override // d.b.p.g.a.d
    public com.baidu.helios.common.cc.a b(byte[] bArr, int i, int i2) {
        long j;
        try {
            Object g2 = this.f65102d.g();
            this.f65102d.f(g2, bArr, i, i2);
            j = this.f65102d.b(g2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return com.baidu.helios.common.cc.a.a(new long[]{j});
    }
}
