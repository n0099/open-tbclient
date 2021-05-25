package d.a.q.g.a;

import com.baidu.helios.common.cc.n;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class e extends d {

    /* renamed from: d  reason: collision with root package name */
    public b f64198d;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f64199a;

        /* renamed from: b  reason: collision with root package name */
        public Method f64200b;

        /* renamed from: c  reason: collision with root package name */
        public Method f64201c;

        public b() {
            d();
        }

        public final long b(Object obj) {
            try {
                return ((Long) this.f64201c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new n.a("");
            }
        }

        public final void d() {
            try {
                this.f64199a = Class.forName(n.a(h.a()), true, Object.class.getClassLoader());
                this.f64200b = n.b(this.f64199a, n.a(h.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f64201c = n.b(this.f64199a, n.a(h.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void f(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f64200b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
                throw new n.a("");
            }
        }

        public final Object g() {
            return this.f64199a.newInstance();
        }
    }

    public e(int i2, int i3) {
        this.f64195a = 32;
        this.f64196b = i2;
        this.f64197c = i3;
        this.f64198d = new b();
    }

    @Override // d.a.q.g.a.d
    public com.baidu.helios.common.cc.a b(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object g2 = this.f64198d.g();
            this.f64198d.f(g2, bArr, i2, i3);
            j = this.f64198d.b(g2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return com.baidu.helios.common.cc.a.a(new long[]{j});
    }
}
