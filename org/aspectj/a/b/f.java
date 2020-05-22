package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    int mCO;
    String nAE;
    Class nAF;
    a nAG;
    private String nAH;
    ClassLoader nAv = null;
    String name;
    private static boolean apG = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nAI = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mCO = -1;
        this.mCO = i;
        this.name = str;
        this.nAF = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (apG) {
            if (this.nAG == null) {
                try {
                    this.nAG = new b();
                } catch (Throwable th) {
                    apG = false;
                }
            } else {
                str = this.nAG.get(hVar.nAT);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (apG) {
            this.nAG.set(hVar.nAT, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nAV);
    }

    public int dOu() {
        if (this.mCO == -1) {
            this.mCO = Kc(0);
        }
        return this.mCO;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Kb(1);
        }
        return this.name;
    }

    public Class dOv() {
        if (this.nAF == null) {
            this.nAF = Kd(2);
        }
        return this.nAF;
    }

    public String dOw() {
        if (this.nAE == null) {
            this.nAE = dOv().getName();
        }
        return this.nAE;
    }

    private ClassLoader dOx() {
        if (this.nAv == null) {
            this.nAv = getClass().getClassLoader();
        }
        return this.nAv;
    }

    String Kb(int i) {
        int i2 = 0;
        int indexOf = this.nAH.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nAH.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nAH.length();
        }
        return this.nAH.substring(i2, indexOf);
    }

    int Kc(int i) {
        return Integer.parseInt(Kb(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Kd(int i) {
        return org.aspectj.a.b.b.b(Kb(i), dOx());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Ke(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Kb(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dOx());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nAJ;

        public b() {
            dOz();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dOy = dOy();
            if (dOy == null) {
                return null;
            }
            return dOy[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dOy = dOy();
            if (dOy == null) {
                dOy = dOz();
            }
            dOy[i] = str;
        }

        private String[] dOy() {
            return (String[]) this.nAJ.get();
        }

        private String[] dOz() {
            String[] strArr = new String[3];
            this.nAJ = new SoftReference(strArr);
            return strArr;
        }
    }
}
