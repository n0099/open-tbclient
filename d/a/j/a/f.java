package d.a.j.a;

import com.baidu.cesium.a.i;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: d  reason: collision with root package name */
    public b f40096d;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f40097a;

        /* renamed from: b  reason: collision with root package name */
        public Method f40098b;

        /* renamed from: c  reason: collision with root package name */
        public Method f40099c;

        public b() {
            d();
        }

        public final long b(Object obj) {
            try {
                return ((Long) this.f40099c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final void d() {
            try {
                this.f40097a = Class.forName(i.a(c.a()), true, Object.class.getClassLoader());
                this.f40098b = i.b(this.f40097a, i.a(c.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f40099c = i.b(this.f40097a, i.a(c.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void f(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f40098b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final Object g() {
            return this.f40097a.newInstance();
        }
    }

    public f(int i2, int i3) {
        this.f40093a = 32;
        this.f40094b = i2;
        this.f40095c = i3;
        this.f40096d = new b();
    }

    @Override // d.a.j.a.e
    public com.baidu.cesium.a.b b(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object g2 = this.f40096d.g();
            this.f40096d.f(g2, bArr, i2, i3);
            j = this.f40096d.b(g2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return com.baidu.cesium.a.b.a(new long[]{j});
    }
}
