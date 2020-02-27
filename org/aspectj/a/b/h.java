package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nKm = new h();
    static h nKn;
    static h nKo;
    boolean nKd = true;
    boolean nKe = true;
    boolean nKf = false;
    boolean nKg = false;
    boolean nKh = false;
    boolean nKi = true;
    boolean nKj = true;
    boolean nKk = true;
    int nKl;

    h() {
    }

    static {
        nKm.nKd = true;
        nKm.nKe = false;
        nKm.nKf = false;
        nKm.nKg = false;
        nKm.nKh = true;
        nKm.nKi = false;
        nKm.nKj = false;
        nKm.nKl = 0;
        nKn = new h();
        nKn.nKd = true;
        nKn.nKe = true;
        nKn.nKf = false;
        nKn.nKg = false;
        nKn.nKh = false;
        nKm.nKl = 1;
        nKo = new h();
        nKo.nKd = false;
        nKo.nKe = true;
        nKo.nKf = false;
        nKo.nKg = true;
        nKo.nKh = false;
        nKo.nKk = false;
        nKo.nKl = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String So(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String NU(int i) {
        if (this.nKg) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(HanziToPinyin.Token.SEPARATOR).toString();
        }
        return "";
    }

    String Sp(String str) {
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
            return Sp(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.nKd);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nKh);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(N(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.nKe) {
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
        if (this.nKf && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
