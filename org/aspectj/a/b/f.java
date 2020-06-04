package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    int mEb;
    ClassLoader nBF = null;
    String nBO;
    Class nBP;
    a nBQ;
    private String nBR;
    String name;
    private static boolean apG = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nBS = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mEb = -1;
        this.mEb = i;
        this.name = str;
        this.nBP = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (apG) {
            if (this.nBQ == null) {
                try {
                    this.nBQ = new b();
                } catch (Throwable th) {
                    apG = false;
                }
            } else {
                str = this.nBQ.get(hVar.nCd);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (apG) {
            this.nBQ.set(hVar.nCd, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nCf);
    }

    public int dOI() {
        if (this.mEb == -1) {
            this.mEb = Ke(0);
        }
        return this.mEb;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Kd(1);
        }
        return this.name;
    }

    public Class dOJ() {
        if (this.nBP == null) {
            this.nBP = Kf(2);
        }
        return this.nBP;
    }

    public String dOK() {
        if (this.nBO == null) {
            this.nBO = dOJ().getName();
        }
        return this.nBO;
    }

    private ClassLoader dOL() {
        if (this.nBF == null) {
            this.nBF = getClass().getClassLoader();
        }
        return this.nBF;
    }

    String Kd(int i) {
        int i2 = 0;
        int indexOf = this.nBR.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nBR.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nBR.length();
        }
        return this.nBR.substring(i2, indexOf);
    }

    int Ke(int i) {
        return Integer.parseInt(Kd(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Kf(int i) {
        return org.aspectj.a.b.b.b(Kd(i), dOL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Kg(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Kd(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dOL());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nBT;

        public b() {
            dON();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dOM = dOM();
            if (dOM == null) {
                return null;
            }
            return dOM[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dOM = dOM();
            if (dOM == null) {
                dOM = dON();
            }
            dOM[i] = str;
        }

        private String[] dOM() {
            return (String[]) this.nBT.get();
        }

        private String[] dON() {
            String[] strArr = new String[3];
            this.nBT = new SoftReference(strArr);
            return strArr;
        }
    }
}
