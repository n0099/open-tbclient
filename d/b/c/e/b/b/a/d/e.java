package d.b.c.e.b.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {

    /* renamed from: a  reason: collision with root package name */
    public char f42380a;

    public e(char c2) {
        this.f42380a = c2;
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
                                        return Boolean.valueOf(((byte) this.f42380a) == 0);
                                    } else if (a2 == String.class) {
                                        return String.valueOf(this.f42380a);
                                    } else {
                                        if (a2 == char[].class) {
                                            return String.valueOf(this.f42380a).toCharArray();
                                        }
                                        if (a2 == byte[].class) {
                                            try {
                                                return d.b.c.e.p.c.e(String.valueOf(this.f42380a), 0);
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                                return null;
                                            }
                                        }
                                        return null;
                                    }
                                }
                                return Character.valueOf(this.f42380a);
                            }
                            return Double.valueOf(this.f42380a);
                        }
                        return Float.valueOf(this.f42380a);
                    }
                    return Long.valueOf(this.f42380a);
                }
                return Integer.valueOf(this.f42380a);
            }
            return Short.valueOf((short) this.f42380a);
        }
        return Byte.valueOf((byte) this.f42380a);
    }
}
