package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes11.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int peE;
    ClassLoader qbF = null;
    String qbO;
    Class qbP;
    a qbQ;
    private String qbR;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.peE = -1;
        this.peE = i;
        this.name = str;
        this.qbP = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.qbQ == null) {
                try {
                    this.qbQ = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.qbQ.get(hVar.qcc);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.qbQ.set(hVar.qcc, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.qce);
    }

    public int eEz() {
        if (this.peE == -1) {
            this.peE = Si(0);
        }
        return this.peE;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Sh(1);
        }
        return this.name;
    }

    public Class eEA() {
        if (this.qbP == null) {
            this.qbP = Sj(2);
        }
        return this.qbP;
    }

    public String eEB() {
        if (this.qbO == null) {
            this.qbO = eEA().getName();
        }
        return this.qbO;
    }

    private ClassLoader eEC() {
        if (this.qbF == null) {
            this.qbF = getClass().getClassLoader();
        }
        return this.qbF;
    }

    String Sh(int i) {
        int i2 = 0;
        int indexOf = this.qbR.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.qbR.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.qbR.length();
        }
        return this.qbR.substring(i2, indexOf);
    }

    int Si(int i) {
        return Integer.parseInt(Sh(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Sj(int i) {
        return org.aspectj.a.b.b.b(Sh(i), eEC());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Sk(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Sh(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eEC());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class b implements a {
        private SoftReference qbS;

        public b() {
            eEE();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eED = eED();
            if (eED == null) {
                return null;
            }
            return eED[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eED = eED();
            if (eED == null) {
                eED = eEE();
            }
            eED[i] = str;
        }

        private String[] eED() {
            return (String[]) this.qbS.get();
        }

        private String[] eEE() {
            String[] strArr = new String[3];
            this.qbS = new SoftReference(strArr);
            return strArr;
        }
    }
}
