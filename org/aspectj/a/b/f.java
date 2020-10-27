package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int oTG;
    ClassLoader pQI = null;
    String pQR;
    Class pQS;
    a pQT;
    private String pQU;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.oTG = -1;
        this.oTG = i;
        this.name = str;
        this.pQS = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.pQT == null) {
                try {
                    this.pQT = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.pQT.get(hVar.pRf);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.pQT.set(hVar.pRf, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.pRh);
    }

    public int eAJ() {
        if (this.oTG == -1) {
            this.oTG = Rk(0);
        }
        return this.oTG;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Rj(1);
        }
        return this.name;
    }

    public Class eAK() {
        if (this.pQS == null) {
            this.pQS = Rl(2);
        }
        return this.pQS;
    }

    public String eAL() {
        if (this.pQR == null) {
            this.pQR = eAK().getName();
        }
        return this.pQR;
    }

    private ClassLoader eAM() {
        if (this.pQI == null) {
            this.pQI = getClass().getClassLoader();
        }
        return this.pQI;
    }

    String Rj(int i) {
        int i2 = 0;
        int indexOf = this.pQU.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.pQU.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.pQU.length();
        }
        return this.pQU.substring(i2, indexOf);
    }

    int Rk(int i) {
        return Integer.parseInt(Rj(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Rl(int i) {
        return org.aspectj.a.b.b.b(Rj(i), eAM());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Rm(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Rj(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eAM());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference pQV;

        public b() {
            eAO();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eAN = eAN();
            if (eAN == null) {
                return null;
            }
            return eAN[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eAN = eAN();
            if (eAN == null) {
                eAN = eAO();
            }
            eAN[i] = str;
        }

        private String[] eAN() {
            return (String[]) this.pQV.get();
        }

        private String[] eAO() {
            String[] strArr = new String[3];
            this.pQV = new SoftReference(strArr);
            return strArr;
        }
    }
}
