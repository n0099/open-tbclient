package d.a.q.g.a;

import com.baidu.helios.common.cc.n;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class e extends d {

    /* renamed from: d  reason: collision with root package name */
    public b f63685d;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f63686a;

        /* renamed from: b  reason: collision with root package name */
        public Method f63687b;

        /* renamed from: c  reason: collision with root package name */
        public Method f63688c;

        public b() {
            d();
        }

        public final long b(Object obj) {
            try {
                return ((Long) this.f63688c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new n.a("");
            }
        }

        public final void d() {
            try {
                this.f63686a = Class.forName(n.a(h.a()), true, Object.class.getClassLoader());
                this.f63687b = n.b(this.f63686a, n.a(h.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f63688c = n.b(this.f63686a, n.a(h.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void f(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f63687b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
                throw new n.a("");
            }
        }

        public final Object g() {
            return this.f63686a.newInstance();
        }
    }

    public e(int i2, int i3) {
        this.f63682a = 32;
        this.f63683b = i2;
        this.f63684c = i3;
        this.f63685d = new b();
    }

    @Override // d.a.q.g.a.d
    public com.baidu.helios.common.cc.a b(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object g2 = this.f63685d.g();
            this.f63685d.f(g2, bArr, i2, i3);
            j = this.f63685d.b(g2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return com.baidu.helios.common.cc.a.a(new long[]{j});
    }
}
