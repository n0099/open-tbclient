package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nMm = new h();
    static h nMn;
    static h nMo;
    boolean nMd = true;
    boolean nMe = true;
    boolean nMf = false;
    boolean nMg = false;
    boolean nMh = false;
    boolean nMi = true;
    boolean nMj = true;
    boolean nMk = true;
    int nMl;

    h() {
    }

    static {
        nMm.nMd = true;
        nMm.nMe = false;
        nMm.nMf = false;
        nMm.nMg = false;
        nMm.nMh = true;
        nMm.nMi = false;
        nMm.nMj = false;
        nMm.nMl = 0;
        nMn = new h();
        nMn.nMd = true;
        nMn.nMe = true;
        nMn.nMf = false;
        nMn.nMg = false;
        nMn.nMh = false;
        nMm.nMl = 1;
        nMo = new h();
        nMo.nMd = false;
        nMo.nMe = true;
        nMo.nMf = false;
        nMo.nMg = true;
        nMo.nMh = false;
        nMo.nMk = false;
        nMo.nMl = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String So(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Oa(int i) {
        if (this.nMg) {
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
        return b(cls, cls.getName(), this.nMd);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nMh);
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
            if (!this.nMe) {
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
        if (this.nMf && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
