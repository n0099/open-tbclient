package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hyf = new h();
    static h hyg;
    static h hyh;
    boolean hxW = true;
    boolean hxX = true;
    boolean hxY = false;
    boolean hxZ = false;
    boolean hya = false;
    boolean hyb = true;
    boolean hyc = true;
    boolean hyd = true;
    int hye;

    h() {
    }

    static {
        hyf.hxW = true;
        hyf.hxX = false;
        hyf.hxY = false;
        hyf.hxZ = false;
        hyf.hya = true;
        hyf.hyb = false;
        hyf.hyc = false;
        hyf.hye = 0;
        hyg = new h();
        hyg.hxW = true;
        hyg.hxX = true;
        hyg.hxY = false;
        hyg.hxZ = false;
        hyg.hya = false;
        hyf.hye = 1;
        hyh = new h();
        hyh.hxW = false;
        hyh.hxX = true;
        hyh.hxY = false;
        hyh.hxZ = true;
        hyh.hya = false;
        hyh.hyd = false;
        hyh.hye = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wg(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xp(int i) {
        if (this.hxZ) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wh(String str) {
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
            return wh(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.hxW);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.hya);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(o(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.hxX) {
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
        if (this.hxY && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
