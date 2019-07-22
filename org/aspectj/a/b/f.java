package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int kmV;
    ClassLoader ksD = null;
    String ksM;
    Class ksN;
    a ksO;
    private String ksP;
    String name;
    private static boolean eSG = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] ksQ = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void aP(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.kmV = -1;
        this.kmV = i;
        this.name = str;
        this.ksN = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eSG) {
            if (this.ksO == null) {
                try {
                    this.ksO = new b();
                } catch (Throwable th) {
                    eSG = false;
                }
            } else {
                str = this.ksO.get(hVar.ktb);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eSG) {
            this.ksO.aP(hVar.ktb, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.ktd);
    }

    public int cOc() {
        if (this.kmV == -1) {
            this.kmV = EK(0);
        }
        return this.kmV;
    }

    public String getName() {
        if (this.name == null) {
            this.name = EJ(1);
        }
        return this.name;
    }

    public Class cOd() {
        if (this.ksN == null) {
            this.ksN = EL(2);
        }
        return this.ksN;
    }

    public String cOe() {
        if (this.ksM == null) {
            this.ksM = cOd().getName();
        }
        return this.ksM;
    }

    private ClassLoader cOf() {
        if (this.ksD == null) {
            this.ksD = getClass().getClassLoader();
        }
        return this.ksD;
    }

    String EJ(int i) {
        int i2 = 0;
        int indexOf = this.ksP.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.ksP.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.ksP.length();
        }
        return this.ksP.substring(i2, indexOf);
    }

    int EK(int i) {
        return Integer.parseInt(EJ(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class EL(int i) {
        return org.aspectj.a.b.b.b(EJ(i), cOf());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] EM(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(EJ(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cOf());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference ksR;

        public b() {
            cOh();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] cOg = cOg();
            if (cOg == null) {
                return null;
            }
            return cOg[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aP(int i, String str) {
            String[] cOg = cOg();
            if (cOg == null) {
                cOg = cOh();
            }
            cOg[i] = str;
        }

        private String[] cOg() {
            return (String[]) this.ksR.get();
        }

        private String[] cOh() {
            String[] strArr = new String[3];
            this.ksR = new SoftReference(strArr);
            return strArr;
        }
    }
}
