package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int imH;
    String imI;
    Class imJ;
    a imK;
    private String imL;
    ClassLoader imx = null;
    String name;
    private static boolean dmu = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] imM = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ar(int i, String str);

        String zy(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.imH = -1;
        this.imH = i;
        this.name = str;
        this.imJ = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dmu) {
            if (this.imK == null) {
                try {
                    this.imK = new b();
                } catch (Throwable th) {
                    dmu = false;
                }
            } else {
                str = this.imK.zy(hVar.imX);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dmu) {
            this.imK.ar(hVar.imX, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.imZ);
    }

    public int getModifiers() {
        if (this.imH == -1) {
            this.imH = zv(0);
        }
        return this.imH;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zu(1);
        }
        return this.name;
    }

    public Class bSc() {
        if (this.imJ == null) {
            this.imJ = zw(2);
        }
        return this.imJ;
    }

    public String bSd() {
        if (this.imI == null) {
            this.imI = bSc().getName();
        }
        return this.imI;
    }

    private ClassLoader bSe() {
        if (this.imx == null) {
            this.imx = getClass().getClassLoader();
        }
        return this.imx;
    }

    String zu(int i) {
        int i2 = 0;
        int indexOf = this.imL.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.imL.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.imL.length();
        }
        return this.imL.substring(i2, indexOf);
    }

    int zv(int i) {
        return Integer.parseInt(zu(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zw(int i) {
        return org.aspectj.a.b.b.b(zu(i), bSe());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zx(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zu(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bSe());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference imN;

        public b() {
            bSg();
        }

        @Override // org.aspectj.a.b.f.a
        public String zy(int i) {
            String[] bSf = bSf();
            if (bSf == null) {
                return null;
            }
            return bSf[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ar(int i, String str) {
            String[] bSf = bSf();
            if (bSf == null) {
                bSf = bSg();
            }
            bSf[i] = str;
        }

        private String[] bSf() {
            return (String[]) this.imN.get();
        }

        private String[] bSg() {
            String[] strArr = new String[3];
            this.imN = new SoftReference(strArr);
            return strArr;
        }
    }
}
