package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hzA;
    static h hzy = new h();
    static h hzz;
    boolean hzp = true;
    boolean hzq = true;
    boolean hzr = false;
    boolean hzs = false;
    boolean hzt = false;
    boolean hzu = true;
    boolean hzv = true;
    boolean hzw = true;
    int hzx;

    h() {
    }

    static {
        hzy.hzp = true;
        hzy.hzq = false;
        hzy.hzr = false;
        hzy.hzs = false;
        hzy.hzt = true;
        hzy.hzu = false;
        hzy.hzv = false;
        hzy.hzx = 0;
        hzz = new h();
        hzz.hzp = true;
        hzz.hzq = true;
        hzz.hzr = false;
        hzz.hzs = false;
        hzz.hzt = false;
        hzy.hzx = 1;
        hzA = new h();
        hzA.hzp = false;
        hzA.hzq = true;
        hzA.hzr = false;
        hzA.hzs = true;
        hzA.hzt = false;
        hzA.hzw = false;
        hzA.hzx = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wL(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wp(int i) {
        if (this.hzs) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wM(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    String b(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            return new StringBuffer().append(b(componentType, componentType.getName(), z)).append("[]").toString();
        } else if (z) {
            return wM(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String n(Class cls) {
        return b(cls, cls.getName(), this.hzp);
    }

    public String d(Class cls, String str) {
        return b(cls, str, this.hzt);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(n(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.hzq) {
                if (clsArr.length == 0) {
                    stringBuffer.append("()");
                    return;
                } else {
                    stringBuffer.append("(..)");
                    return;
                }
            }
            stringBuffer.append("(");
            a(stringBuffer, clsArr);
            stringBuffer.append(")");
        }
    }

    public void c(StringBuffer stringBuffer, Class[] clsArr) {
        if (this.hzr && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
