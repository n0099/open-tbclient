package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader iCm = null;
    String iCw;
    Class iCx;
    a iCy;
    private String iCz;
    int iwC;
    String name;
    private static boolean dnJ = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] iCA = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void set(int i, String str);

        String zw(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.iwC = -1;
        this.iwC = i;
        this.name = str;
        this.iCx = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dnJ) {
            if (this.iCy == null) {
                try {
                    this.iCy = new b();
                } catch (Throwable th) {
                    dnJ = false;
                }
            } else {
                str = this.iCy.zw(hVar.iCL);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dnJ) {
            this.iCy.set(hVar.iCL, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.iCN);
    }

    public int getModifiers() {
        if (this.iwC == -1) {
            this.iwC = zt(0);
        }
        return this.iwC;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zs(1);
        }
        return this.name;
    }

    public Class ccT() {
        if (this.iCx == null) {
            this.iCx = zu(2);
        }
        return this.iCx;
    }

    public String ccU() {
        if (this.iCw == null) {
            this.iCw = ccT().getName();
        }
        return this.iCw;
    }

    private ClassLoader ccV() {
        if (this.iCm == null) {
            this.iCm = getClass().getClassLoader();
        }
        return this.iCm;
    }

    String zs(int i) {
        int i2 = 0;
        int indexOf = this.iCz.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.iCz.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.iCz.length();
        }
        return this.iCz.substring(i2, indexOf);
    }

    int zt(int i) {
        return Integer.parseInt(zs(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zu(int i) {
        return org.aspectj.a.b.b.b(zs(i), ccV());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zv(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zs(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), ccV());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference iCB;

        public b() {
            ccX();
        }

        @Override // org.aspectj.a.b.f.a
        public String zw(int i) {
            String[] ccW = ccW();
            if (ccW == null) {
                return null;
            }
            return ccW[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] ccW = ccW();
            if (ccW == null) {
                ccW = ccX();
            }
            ccW[i] = str;
        }

        private String[] ccW() {
            return (String[]) this.iCB.get();
        }

        private String[] ccX() {
            String[] strArr = new String[3];
            this.iCB = new SoftReference(strArr);
            return strArr;
        }
    }
}
