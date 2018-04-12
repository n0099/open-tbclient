package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hzB = new h();
    static h hzC;
    static h hzD;
    int hzA;
    boolean hzs = true;
    boolean hzt = true;
    boolean hzu = false;
    boolean hzv = false;
    boolean hzw = false;
    boolean hzx = true;
    boolean hzy = true;
    boolean hzz = true;

    h() {
    }

    static {
        hzB.hzs = true;
        hzB.hzt = false;
        hzB.hzu = false;
        hzB.hzv = false;
        hzB.hzw = true;
        hzB.hzx = false;
        hzB.hzy = false;
        hzB.hzA = 0;
        hzC = new h();
        hzC.hzs = true;
        hzC.hzt = true;
        hzC.hzu = false;
        hzC.hzv = false;
        hzC.hzw = false;
        hzB.hzA = 1;
        hzD = new h();
        hzD.hzs = false;
        hzD.hzt = true;
        hzD.hzu = false;
        hzD.hzv = true;
        hzD.hzw = false;
        hzD.hzz = false;
        hzD.hzA = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wL(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wq(int i) {
        if (this.hzv) {
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
        return b(cls, cls.getName(), this.hzs);
    }

    public String d(Class cls, String str) {
        return b(cls, str, this.hzw);
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
            if (!this.hzt) {
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
        if (this.hzu && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
