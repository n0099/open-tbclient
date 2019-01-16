package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    String iDD;
    Class iDE;
    a iDF;
    private String iDG;
    ClassLoader iDt = null;
    int ixJ;
    String name;
    private static boolean dow = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] iDH = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void set(int i, String str);

        String zy(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.ixJ = -1;
        this.ixJ = i;
        this.name = str;
        this.iDE = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dow) {
            if (this.iDF == null) {
                try {
                    this.iDF = new b();
                } catch (Throwable th) {
                    dow = false;
                }
            } else {
                str = this.iDF.zy(hVar.iDS);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dow) {
            this.iDF.set(hVar.iDS, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.iDU);
    }

    public int getModifiers() {
        if (this.ixJ == -1) {
            this.ixJ = zv(0);
        }
        return this.ixJ;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zu(1);
        }
        return this.name;
    }

    public Class cdB() {
        if (this.iDE == null) {
            this.iDE = zw(2);
        }
        return this.iDE;
    }

    public String cdC() {
        if (this.iDD == null) {
            this.iDD = cdB().getName();
        }
        return this.iDD;
    }

    private ClassLoader cdD() {
        if (this.iDt == null) {
            this.iDt = getClass().getClassLoader();
        }
        return this.iDt;
    }

    String zu(int i) {
        int i2 = 0;
        int indexOf = this.iDG.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.iDG.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.iDG.length();
        }
        return this.iDG.substring(i2, indexOf);
    }

    int zv(int i) {
        return Integer.parseInt(zu(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zw(int i) {
        return org.aspectj.a.b.b.b(zu(i), cdD());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zx(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zu(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cdD());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference iDI;

        public b() {
            cdF();
        }

        @Override // org.aspectj.a.b.f.a
        public String zy(int i) {
            String[] cdE = cdE();
            if (cdE == null) {
                return null;
            }
            return cdE[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] cdE = cdE();
            if (cdE == null) {
                cdE = cdF();
            }
            cdE[i] = str;
        }

        private String[] cdE() {
            return (String[]) this.iDI.get();
        }

        private String[] cdF() {
            String[] strArr = new String[3];
            this.iDI = new SoftReference(strArr);
            return strArr;
        }
    }
}
