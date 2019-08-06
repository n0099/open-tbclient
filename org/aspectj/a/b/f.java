package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int kob;
    ClassLoader ktJ = null;
    String ktS;
    Class ktT;
    a ktU;
    private String ktV;
    String name;
    private static boolean eSN = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] ktW = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void aP(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.kob = -1;
        this.kob = i;
        this.name = str;
        this.ktT = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eSN) {
            if (this.ktU == null) {
                try {
                    this.ktU = new b();
                } catch (Throwable th) {
                    eSN = false;
                }
            } else {
                str = this.ktU.get(hVar.kuh);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eSN) {
            this.ktU.aP(hVar.kuh, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.kuj);
    }

    public int cOx() {
        if (this.kob == -1) {
            this.kob = EM(0);
        }
        return this.kob;
    }

    public String getName() {
        if (this.name == null) {
            this.name = EL(1);
        }
        return this.name;
    }

    public Class cOy() {
        if (this.ktT == null) {
            this.ktT = EN(2);
        }
        return this.ktT;
    }

    public String cOz() {
        if (this.ktS == null) {
            this.ktS = cOy().getName();
        }
        return this.ktS;
    }

    private ClassLoader cOA() {
        if (this.ktJ == null) {
            this.ktJ = getClass().getClassLoader();
        }
        return this.ktJ;
    }

    String EL(int i) {
        int i2 = 0;
        int indexOf = this.ktV.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.ktV.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.ktV.length();
        }
        return this.ktV.substring(i2, indexOf);
    }

    int EM(int i) {
        return Integer.parseInt(EL(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class EN(int i) {
        return org.aspectj.a.b.b.b(EL(i), cOA());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] EO(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(EL(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cOA());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference ktX;

        public b() {
            cOC();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] cOB = cOB();
            if (cOB == null) {
                return null;
            }
            return cOB[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aP(int i, String str) {
            String[] cOB = cOB();
            if (cOB == null) {
                cOB = cOC();
            }
            cOB[i] = str;
        }

        private String[] cOB() {
            return (String[]) this.ktX.get();
        }

        private String[] cOC() {
            String[] strArr = new String[3];
            this.ktX = new SoftReference(strArr);
            return strArr;
        }
    }
}
