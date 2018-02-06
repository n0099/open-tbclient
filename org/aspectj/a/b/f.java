package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    private String imA;
    ClassLoader imm = null;
    int imw;
    String imx;
    Class imy;
    a imz;
    String name;
    private static boolean dmD = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] imB = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ar(int i, String str);

        String zx(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.imw = -1;
        this.imw = i;
        this.name = str;
        this.imy = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dmD) {
            if (this.imz == null) {
                try {
                    this.imz = new b();
                } catch (Throwable th) {
                    dmD = false;
                }
            } else {
                str = this.imz.zx(hVar.imM);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dmD) {
            this.imz.ar(hVar.imM, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.imO);
    }

    public int getModifiers() {
        if (this.imw == -1) {
            this.imw = zu(0);
        }
        return this.imw;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zt(1);
        }
        return this.name;
    }

    public Class bRY() {
        if (this.imy == null) {
            this.imy = zv(2);
        }
        return this.imy;
    }

    public String bRZ() {
        if (this.imx == null) {
            this.imx = bRY().getName();
        }
        return this.imx;
    }

    private ClassLoader bSa() {
        if (this.imm == null) {
            this.imm = getClass().getClassLoader();
        }
        return this.imm;
    }

    String zt(int i) {
        int i2 = 0;
        int indexOf = this.imA.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.imA.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.imA.length();
        }
        return this.imA.substring(i2, indexOf);
    }

    int zu(int i) {
        return Integer.parseInt(zt(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zv(int i) {
        return org.aspectj.a.b.b.b(zt(i), bSa());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zw(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zt(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bSa());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference imC;

        public b() {
            bSc();
        }

        @Override // org.aspectj.a.b.f.a
        public String zx(int i) {
            String[] bSb = bSb();
            if (bSb == null) {
                return null;
            }
            return bSb[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ar(int i, String str) {
            String[] bSb = bSb();
            if (bSb == null) {
                bSb = bSc();
            }
            bSb[i] = str;
        }

        private String[] bSb() {
            return (String[]) this.imC.get();
        }

        private String[] bSc() {
            String[] strArr = new String[3];
            this.imC = new SoftReference(strArr);
            return strArr;
        }
    }
}
