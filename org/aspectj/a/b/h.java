package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.reflect.Modifier;
/* loaded from: classes4.dex */
class h {
    static h nas = new h();
    static h nat;
    static h nau;
    boolean naj = true;
    boolean nak = true;
    boolean nal = false;
    boolean nam = false;
    boolean nan = false;
    boolean nao = true;
    boolean nap = true;
    boolean naq = true;
    int nar;

    h() {
    }

    static {
        nas.naj = true;
        nas.nak = false;
        nas.nal = false;
        nas.nam = false;
        nas.nan = true;
        nas.nao = false;
        nas.nap = false;
        nas.nar = 0;
        nat = new h();
        nat.naj = true;
        nat.nak = true;
        nat.nal = false;
        nat.nam = false;
        nat.nan = false;
        nas.nar = 1;
        nau = new h();
        nau.naj = false;
        nau.nak = true;
        nau.nal = false;
        nau.nam = true;
        nau.nan = false;
        nau.naq = false;
        nau.nar = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ri(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String MX(int i) {
        if (this.nam) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(HanziToPinyin.Token.SEPARATOR).toString();
        }
        return "";
    }

    String Rj(String str) {
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
            return Rj(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.naj);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nan);
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
            if (!this.nak) {
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
        if (this.nal && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
