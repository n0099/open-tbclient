package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int pSC;
    ClassLoader quU = null;
    String qvd;
    Class qve;
    a qvf;
    private String qvg;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.pSC = -1;
        this.pSC = i;
        this.name = str;
        this.qve = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.qvf == null) {
                try {
                    this.qvf = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.qvf.get(hVar.qvr);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.qvf.set(hVar.qvr, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.qvt);
    }

    public int eLT() {
        if (this.pSC == -1) {
            this.pSC = Sz(0);
        }
        return this.pSC;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Sy(1);
        }
        return this.name;
    }

    public Class eLU() {
        if (this.qve == null) {
            this.qve = SA(2);
        }
        return this.qve;
    }

    public String eLV() {
        if (this.qvd == null) {
            this.qvd = eLU().getName();
        }
        return this.qvd;
    }

    private ClassLoader eLW() {
        if (this.quU == null) {
            this.quU = getClass().getClassLoader();
        }
        return this.quU;
    }

    String Sy(int i) {
        int i2 = 0;
        int indexOf = this.qvg.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.qvg.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.qvg.length();
        }
        return this.qvg.substring(i2, indexOf);
    }

    int Sz(int i) {
        return Integer.parseInt(Sy(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class SA(int i) {
        return org.aspectj.a.b.b.b(Sy(i), eLW());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] SB(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Sy(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eLW());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference qvh;

        public b() {
            eLY();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eLX = eLX();
            if (eLX == null) {
                return null;
            }
            return eLX[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eLX = eLX();
            if (eLX == null) {
                eLX = eLY();
            }
            eLX[i] = str;
        }

        private String[] eLX() {
            return (String[]) this.qvh.get();
        }

        private String[] eLY() {
            String[] strArr = new String[3];
            this.qvh = new SoftReference(strArr);
            return strArr;
        }
    }
}
