package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int pSc;
    String quD;
    Class quE;
    a quF;
    private String quG;
    ClassLoader quu = null;
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
        this.pSc = -1;
        this.pSc = i;
        this.name = str;
        this.quE = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.quF == null) {
                try {
                    this.quF = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.quF.get(hVar.quR);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.quF.set(hVar.quR, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.quT);
    }

    public int eLL() {
        if (this.pSc == -1) {
            this.pSc = Sy(0);
        }
        return this.pSc;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Sx(1);
        }
        return this.name;
    }

    public Class eLM() {
        if (this.quE == null) {
            this.quE = Sz(2);
        }
        return this.quE;
    }

    public String eLN() {
        if (this.quD == null) {
            this.quD = eLM().getName();
        }
        return this.quD;
    }

    private ClassLoader eLO() {
        if (this.quu == null) {
            this.quu = getClass().getClassLoader();
        }
        return this.quu;
    }

    String Sx(int i) {
        int i2 = 0;
        int indexOf = this.quG.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.quG.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.quG.length();
        }
        return this.quG.substring(i2, indexOf);
    }

    int Sy(int i) {
        return Integer.parseInt(Sx(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Sz(int i) {
        return org.aspectj.a.b.b.b(Sx(i), eLO());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] SA(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Sx(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eLO());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference quH;

        public b() {
            eLQ();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eLP = eLP();
            if (eLP == null) {
                return null;
            }
            return eLP[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eLP = eLP();
            if (eLP == null) {
                eLP = eLQ();
            }
            eLP[i] = str;
        }

        private String[] eLP() {
            return (String[]) this.quH.get();
        }

        private String[] eLQ() {
            String[] strArr = new String[3];
            this.quH = new SoftReference(strArr);
            return strArr;
        }
    }
}
