package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hon = new h();
    static h hoo;
    static h hop;
    boolean hoe = true;
    boolean hof = true;
    boolean hog = false;
    boolean hoh = false;
    boolean hoi = false;
    boolean hoj = true;
    boolean hok = true;
    boolean hol = true;
    int hom;

    h() {
    }

    static {
        hon.hoe = true;
        hon.hof = false;
        hon.hog = false;
        hon.hoh = false;
        hon.hoi = true;
        hon.hoj = false;
        hon.hok = false;
        hon.hom = 0;
        hoo = new h();
        hoo.hoe = true;
        hoo.hof = true;
        hoo.hog = false;
        hoo.hoh = false;
        hoo.hoi = false;
        hon.hom = 1;
        hop = new h();
        hop.hoe = false;
        hop.hof = true;
        hop.hog = false;
        hop.hoh = true;
        hop.hoi = false;
        hop.hol = false;
        hop.hom = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String vw(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wT(int i) {
        if (this.hoh) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String vx(String str) {
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
            return vx(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.hoe);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.hoi);
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
            if (!this.hof) {
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
        if (this.hog && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
