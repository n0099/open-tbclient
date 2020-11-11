package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int pdb;
    ClassLoader qac = null;
    String qal;
    Class qam;
    a qan;
    private String qao;
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
        this.pdb = -1;
        this.pdb = i;
        this.name = str;
        this.qam = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.qan == null) {
                try {
                    this.qan = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.qan.get(hVar.qaz);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.qan.set(hVar.qaz, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.qaB);
    }

    public int eEy() {
        if (this.pdb == -1) {
            this.pdb = RF(0);
        }
        return this.pdb;
    }

    public String getName() {
        if (this.name == null) {
            this.name = RE(1);
        }
        return this.name;
    }

    public Class eEz() {
        if (this.qam == null) {
            this.qam = RG(2);
        }
        return this.qam;
    }

    public String eEA() {
        if (this.qal == null) {
            this.qal = eEz().getName();
        }
        return this.qal;
    }

    private ClassLoader eEB() {
        if (this.qac == null) {
            this.qac = getClass().getClassLoader();
        }
        return this.qac;
    }

    String RE(int i) {
        int i2 = 0;
        int indexOf = this.qao.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.qao.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.qao.length();
        }
        return this.qao.substring(i2, indexOf);
    }

    int RF(int i) {
        return Integer.parseInt(RE(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class RG(int i) {
        return org.aspectj.a.b.b.b(RE(i), eEB());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] RH(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(RE(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eEB());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference qap;

        public b() {
            eED();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eEC = eEC();
            if (eEC == null) {
                return null;
            }
            return eEC[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eEC = eEC();
            if (eEC == null) {
                eEC = eED();
            }
            eEC[i] = str;
        }

        private String[] eEC() {
            return (String[]) this.qap.get();
        }

        private String[] eED() {
            String[] strArr = new String[3];
            this.qap = new SoftReference(strArr);
            return strArr;
        }
    }
}
