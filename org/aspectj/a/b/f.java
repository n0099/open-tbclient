package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    String iDE;
    Class iDF;
    a iDG;
    private String iDH;
    ClassLoader iDu = null;
    int ixK;
    String name;
    private static boolean dox = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] iDI = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void set(int i, String str);

        String zy(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.ixK = -1;
        this.ixK = i;
        this.name = str;
        this.iDF = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dox) {
            if (this.iDG == null) {
                try {
                    this.iDG = new b();
                } catch (Throwable th) {
                    dox = false;
                }
            } else {
                str = this.iDG.zy(hVar.iDT);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dox) {
            this.iDG.set(hVar.iDT, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.iDV);
    }

    public int getModifiers() {
        if (this.ixK == -1) {
            this.ixK = zv(0);
        }
        return this.ixK;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zu(1);
        }
        return this.name;
    }

    public Class cdB() {
        if (this.iDF == null) {
            this.iDF = zw(2);
        }
        return this.iDF;
    }

    public String cdC() {
        if (this.iDE == null) {
            this.iDE = cdB().getName();
        }
        return this.iDE;
    }

    private ClassLoader cdD() {
        if (this.iDu == null) {
            this.iDu = getClass().getClassLoader();
        }
        return this.iDu;
    }

    String zu(int i) {
        int i2 = 0;
        int indexOf = this.iDH.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.iDH.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.iDH.length();
        }
        return this.iDH.substring(i2, indexOf);
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
        private SoftReference iDJ;

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
            return (String[]) this.iDJ.get();
        }

        private String[] cdF() {
            String[] strArr = new String[3];
            this.iDJ = new SoftReference(strArr);
            return strArr;
        }
    }
}
