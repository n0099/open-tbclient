package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int kqy;
    ClassLoader kwc = null;
    String kwl;
    Class kwm;
    a kwn;
    private String kwo;
    String name;
    private static boolean eUt = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] kwp = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void aP(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.kqy = -1;
        this.kqy = i;
        this.name = str;
        this.kwm = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eUt) {
            if (this.kwn == null) {
                try {
                    this.kwn = new b();
                } catch (Throwable th) {
                    eUt = false;
                }
            } else {
                str = this.kwn.get(hVar.kwA);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eUt) {
            this.kwn.aP(hVar.kwA, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.kwC);
    }

    public int cPj() {
        if (this.kqy == -1) {
            this.kqy = EQ(0);
        }
        return this.kqy;
    }

    public String getName() {
        if (this.name == null) {
            this.name = EP(1);
        }
        return this.name;
    }

    public Class cPk() {
        if (this.kwm == null) {
            this.kwm = ER(2);
        }
        return this.kwm;
    }

    public String cPl() {
        if (this.kwl == null) {
            this.kwl = cPk().getName();
        }
        return this.kwl;
    }

    private ClassLoader cPm() {
        if (this.kwc == null) {
            this.kwc = getClass().getClassLoader();
        }
        return this.kwc;
    }

    String EP(int i) {
        int i2 = 0;
        int indexOf = this.kwo.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.kwo.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.kwo.length();
        }
        return this.kwo.substring(i2, indexOf);
    }

    int EQ(int i) {
        return Integer.parseInt(EP(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class ER(int i) {
        return org.aspectj.a.b.b.b(EP(i), cPm());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] ES(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(EP(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cPm());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference kwq;

        public b() {
            cPo();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] cPn = cPn();
            if (cPn == null) {
                return null;
            }
            return cPn[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aP(int i, String str) {
            String[] cPn = cPn();
            if (cPn == null) {
                cPn = cPo();
            }
            cPn[i] = str;
        }

        private String[] cPn() {
            return (String[]) this.kwq.get();
        }

        private String[] cPo() {
            String[] strArr = new String[3];
            this.kwq = new SoftReference(strArr);
            return strArr;
        }
    }
}
