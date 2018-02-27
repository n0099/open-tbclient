package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h imA = new h();
    static h imB;
    static h imC;
    boolean imr = true;
    boolean ims = true;
    boolean imt = false;
    boolean imu = false;
    boolean imv = false;
    boolean imw = true;
    boolean imx = true;
    boolean imy = true;
    int imz;

    h() {
    }

    static {
        imA.imr = true;
        imA.ims = false;
        imA.imt = false;
        imA.imu = false;
        imA.imv = true;
        imA.imw = false;
        imA.imx = false;
        imA.imz = 0;
        imB = new h();
        imB.imr = true;
        imB.ims = true;
        imB.imt = false;
        imB.imu = false;
        imB.imv = false;
        imA.imz = 1;
        imC = new h();
        imC.imr = false;
        imC.ims = true;
        imC.imt = false;
        imC.imu = true;
        imC.imv = false;
        imC.imy = false;
        imC.imz = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wZ(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zz(int i) {
        if (this.imu) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String xa(String str) {
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
            return xa(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.imr);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.imv);
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
            if (!this.ims) {
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
        if (this.imt && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
