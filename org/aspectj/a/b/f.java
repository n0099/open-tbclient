package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes16.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    ClassLoader pLH = null;
    String pLQ;
    Class pLR;
    a pLS;
    private String pLT;
    int ptP;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.ptP = -1;
        this.ptP = i;
        this.name = str;
        this.pLR = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.pLS == null) {
                try {
                    this.pLS = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.pLS.get(hVar.pMe);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.pLS.set(hVar.pMe, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.pMg);
    }

    public int eEz() {
        if (this.ptP == -1) {
            this.ptP = Sb(0);
        }
        return this.ptP;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Sa(1);
        }
        return this.name;
    }

    public Class eEA() {
        if (this.pLR == null) {
            this.pLR = Sc(2);
        }
        return this.pLR;
    }

    public String eEB() {
        if (this.pLQ == null) {
            this.pLQ = eEA().getName();
        }
        return this.pLQ;
    }

    private ClassLoader eEC() {
        if (this.pLH == null) {
            this.pLH = getClass().getClassLoader();
        }
        return this.pLH;
    }

    String Sa(int i) {
        int i2 = 0;
        int indexOf = this.pLT.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.pLT.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.pLT.length();
        }
        return this.pLT.substring(i2, indexOf);
    }

    int Sb(int i) {
        return Integer.parseInt(Sa(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Sc(int i) {
        return org.aspectj.a.b.b.b(Sa(i), eEC());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Sd(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Sa(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eEC());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static final class b implements a {
        private SoftReference pLU;

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
            return (String[]) this.pLU.get();
        }

        private String[] eEE() {
            String[] strArr = new String[3];
            this.pLU = new SoftReference(strArr);
            return strArr;
        }
    }
}
