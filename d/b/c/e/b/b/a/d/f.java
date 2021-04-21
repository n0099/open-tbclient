package d.b.c.e.b.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {

    /* renamed from: a  reason: collision with root package name */
    public Double f42381a;

    public f(double d2) {
        this.f42381a = Double.valueOf(d2);
    }

    @Override // d.b.c.e.b.b.a.d.h
    public Object a(d.b.c.e.b.b.a.e.c cVar) {
        Class<?> a2 = cVar.a();
        if (a2 != Byte.class && a2 != Byte.TYPE) {
            if (a2 != Short.class && a2 != Short.TYPE) {
                if (a2 != Integer.class && a2 != Integer.TYPE) {
                    if (a2 != Long.class && a2 != Long.TYPE) {
                        if (a2 != Float.class && a2 != Float.TYPE) {
                            if (a2 != Double.class && a2 != Double.TYPE) {
                                if (a2 != Character.class && a2 != Character.TYPE) {
                                    if (a2 == Boolean.class || a2 == Boolean.TYPE) {
                                        return Boolean.valueOf(this.f42381a.byteValue() == 0);
                                    } else if (a2 == String.class) {
                                        return String.valueOf(this.f42381a);
                                    } else {
                                        if (a2 == char[].class) {
                                            return String.valueOf(this.f42381a).toCharArray();
                                        }
                                        if (a2 == byte[].class) {
                                            try {
                                                return d.b.c.e.p.c.e(String.valueOf(this.f42381a), 0);
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                                return null;
                                            }
                                        }
                                        return null;
                                    }
                                }
                                return Character.valueOf((char) this.f42381a.intValue());
                            }
                            return Double.valueOf(this.f42381a.doubleValue());
                        }
                        return Float.valueOf(this.f42381a.floatValue());
                    }
                    return Long.valueOf(this.f42381a.longValue());
                }
                return Integer.valueOf(this.f42381a.intValue());
            }
            return Short.valueOf(this.f42381a.shortValue());
        }
        return Byte.valueOf(this.f42381a.byteValue());
    }
}
