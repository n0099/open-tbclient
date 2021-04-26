package d.a.c.e.b.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {

    /* renamed from: a  reason: collision with root package name */
    public boolean f39570a;

    public b(boolean z) {
        this.f39570a = z;
    }

    @Override // d.a.c.e.b.b.a.d.h
    public Object a(d.a.c.e.b.b.a.e.c cVar) {
        Class<?> a2 = cVar.a();
        if (a2 != Boolean.class && a2 != Boolean.TYPE) {
            if (a2 == Short.class || a2 == Short.TYPE) {
                return Short.valueOf((short) (!this.f39570a ? 1 : 0));
            }
            if (a2 == Integer.class || a2 == Integer.TYPE) {
                return Integer.valueOf(!this.f39570a ? 1 : 0);
            }
            if (a2 == Long.class || a2 == Long.TYPE) {
                return Long.valueOf(!this.f39570a ? 1 : 0);
            }
            if (a2 == Float.class || a2 == Float.TYPE) {
                return Float.valueOf(!this.f39570a ? 1 : 0);
            }
            if (a2 == Double.class || a2 == Double.TYPE) {
                return Double.valueOf(!this.f39570a ? 1 : 0);
            }
            if (a2 == Character.class || a2 == Character.TYPE) {
                return Character.valueOf((char) (!this.f39570a ? 1 : 0));
            }
            if (a2 == String.class) {
                return String.valueOf(this.f39570a);
            }
            if (a2 == char[].class) {
                return String.valueOf(this.f39570a).toCharArray();
            }
            if (a2 == byte[].class) {
                try {
                    return d.a.c.e.p.c.e(String.valueOf(this.f39570a), 0);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return Boolean.valueOf(this.f39570a);
    }
}
