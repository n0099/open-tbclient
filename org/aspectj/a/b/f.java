package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    Class nXA;
    a nXB;
    private String nXC;
    ClassLoader nXq = null;
    String nXz;
    int nae;
    String name;
    private static boolean aqY = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nXD = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.nae = -1;
        this.nae = i;
        this.name = str;
        this.nXA = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (aqY) {
            if (this.nXB == null) {
                try {
                    this.nXB = new b();
                } catch (Throwable th) {
                    aqY = false;
                }
            } else {
                str = this.nXB.get(hVar.nXO);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (aqY) {
            this.nXB.set(hVar.nXO, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nXQ);
    }

    public int dTo() {
        if (this.nae == -1) {
            this.nae = Ll(0);
        }
        return this.nae;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Lk(1);
        }
        return this.name;
    }

    public Class dTp() {
        if (this.nXA == null) {
            this.nXA = Lm(2);
        }
        return this.nXA;
    }

    public String dTq() {
        if (this.nXz == null) {
            this.nXz = dTp().getName();
        }
        return this.nXz;
    }

    private ClassLoader dTr() {
        if (this.nXq == null) {
            this.nXq = getClass().getClassLoader();
        }
        return this.nXq;
    }

    String Lk(int i) {
        int i2 = 0;
        int indexOf = this.nXC.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nXC.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nXC.length();
        }
        return this.nXC.substring(i2, indexOf);
    }

    int Ll(int i) {
        return Integer.parseInt(Lk(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Lm(int i) {
        return org.aspectj.a.b.b.b(Lk(i), dTr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Ln(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Lk(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dTr());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nXE;

        public b() {
            dTt();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dTs = dTs();
            if (dTs == null) {
                return null;
            }
            return dTs[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dTs = dTs();
            if (dTs == null) {
                dTs = dTt();
            }
            dTs[i] = str;
        }

        private String[] dTs() {
            return (String[]) this.nXE.get();
        }

        private String[] dTt() {
            String[] strArr = new String[3];
            this.nXE = new SoftReference(strArr);
            return strArr;
        }
    }
}
