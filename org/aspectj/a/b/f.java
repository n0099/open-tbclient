package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes3.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int pTr;
    String qvF;
    Class qvG;
    a qvH;
    private String qvI;
    ClassLoader qvw = null;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.pTr = -1;
        this.pTr = i;
        this.name = str;
        this.qvG = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.qvH == null) {
                try {
                    this.qvH = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.qvH.get(hVar.qvT);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.qvH.set(hVar.qvT, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.qvV);
    }

    public int eLB() {
        if (this.pTr == -1) {
            this.pTr = Sy(0);
        }
        return this.pTr;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Sx(1);
        }
        return this.name;
    }

    public Class eLC() {
        if (this.qvG == null) {
            this.qvG = Sz(2);
        }
        return this.qvG;
    }

    public String eLD() {
        if (this.qvF == null) {
            this.qvF = eLC().getName();
        }
        return this.qvF;
    }

    private ClassLoader eLE() {
        if (this.qvw == null) {
            this.qvw = getClass().getClassLoader();
        }
        return this.qvw;
    }

    String Sx(int i) {
        int i2 = 0;
        int indexOf = this.qvI.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.qvI.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.qvI.length();
        }
        return this.qvI.substring(i2, indexOf);
    }

    int Sy(int i) {
        return Integer.parseInt(Sx(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Sz(int i) {
        return org.aspectj.a.b.b.b(Sx(i), eLE());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] SA(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Sx(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eLE());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements a {
        private SoftReference qvJ;

        public b() {
            eLG();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eLF = eLF();
            if (eLF == null) {
                return null;
            }
            return eLF[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eLF = eLF();
            if (eLF == null) {
                eLF = eLG();
            }
            eLF[i] = str;
        }

        private String[] eLF() {
            return (String[]) this.qvJ.get();
        }

        private String[] eLG() {
            String[] strArr = new String[3];
            this.qvJ = new SoftReference(strArr);
            return strArr;
        }
    }
}
