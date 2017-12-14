package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hMR = null;
    int hNb;
    String hNc;
    Class hNd;
    a hNe;
    private String hNf;
    String name;
    private static boolean cqh = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hNg = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ar(int i, String str);

        String yd(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hNb = -1;
        this.hNb = i;
        this.name = str;
        this.hNd = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cqh) {
            if (this.hNe == null) {
                try {
                    this.hNe = new b();
                } catch (Throwable th) {
                    cqh = false;
                }
            } else {
                str = this.hNe.yd(hVar.hNr);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cqh) {
            this.hNe.ar(hVar.hNr, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hNt);
    }

    public int getModifiers() {
        if (this.hNb == -1) {
            this.hNb = ya(0);
        }
        return this.hNb;
    }

    public String getName() {
        if (this.name == null) {
            this.name = xZ(1);
        }
        return this.name;
    }

    public Class bSN() {
        if (this.hNd == null) {
            this.hNd = yb(2);
        }
        return this.hNd;
    }

    public String bSO() {
        if (this.hNc == null) {
            this.hNc = bSN().getName();
        }
        return this.hNc;
    }

    private ClassLoader bSP() {
        if (this.hMR == null) {
            this.hMR = getClass().getClassLoader();
        }
        return this.hMR;
    }

    String xZ(int i) {
        int i2 = 0;
        int indexOf = this.hNf.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hNf.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hNf.length();
        }
        return this.hNf.substring(i2, indexOf);
    }

    int ya(int i) {
        return Integer.parseInt(xZ(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class yb(int i) {
        return org.aspectj.a.b.b.b(xZ(i), bSP());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] yc(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(xZ(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bSP());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hNh;

        public b() {
            bSR();
        }

        @Override // org.aspectj.a.b.f.a
        public String yd(int i) {
            String[] bSQ = bSQ();
            if (bSQ == null) {
                return null;
            }
            return bSQ[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ar(int i, String str) {
            String[] bSQ = bSQ();
            if (bSQ == null) {
                bSQ = bSR();
            }
            bSQ[i] = str;
        }

        private String[] bSQ() {
            return (String[]) this.hNh.get();
        }

        private String[] bSR() {
            String[] strArr = new String[3];
            this.hNh = new SoftReference(strArr);
            return strArr;
        }
    }
}
