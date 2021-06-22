package d.a.j.a;

import com.baidu.cesium.a.i;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class f extends e {

    /* renamed from: d  reason: collision with root package name */
    public b f43880d;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f43881a;

        /* renamed from: b  reason: collision with root package name */
        public Method f43882b;

        /* renamed from: c  reason: collision with root package name */
        public Method f43883c;

        public b() {
            d();
        }

        public final long b(Object obj) {
            try {
                return ((Long) this.f43883c.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final void d() {
            try {
                this.f43881a = Class.forName(i.a(c.a()), true, Object.class.getClassLoader());
                this.f43882b = i.b(this.f43881a, i.a(c.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f43883c = i.b(this.f43881a, i.a(c.c()), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void f(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f43882b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final Object g() {
            return this.f43881a.newInstance();
        }
    }

    public f(int i2, int i3) {
        this.f43877a = 32;
        this.f43878b = i2;
        this.f43879c = i3;
        this.f43880d = new b();
    }

    @Override // d.a.j.a.e
    public com.baidu.cesium.a.b b(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object g2 = this.f43880d.g();
            this.f43880d.f(g2, bArr, i2, i3);
            j = this.f43880d.b(g2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return com.baidu.cesium.a.b.a(new long[]{j});
    }
}
