package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    int miX;
    String name;
    String nfD;
    Class nfE;
    a nfF;
    private String nfG;
    ClassLoader nfu = null;
    private static boolean gwr = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nfH = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.miX = -1;
        this.miX = i;
        this.name = str;
        this.nfE = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (gwr) {
            if (this.nfF == null) {
                try {
                    this.nfF = new b();
                } catch (Throwable th) {
                    gwr = false;
                }
            } else {
                str = this.nfF.get(hVar.nfS);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (gwr) {
            this.nfF.set(hVar.nfS, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nfU);
    }

    public int dGA() {
        if (this.miX == -1) {
            this.miX = Jr(0);
        }
        return this.miX;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Jq(1);
        }
        return this.name;
    }

    public Class dGB() {
        if (this.nfE == null) {
            this.nfE = Js(2);
        }
        return this.nfE;
    }

    public String dGC() {
        if (this.nfD == null) {
            this.nfD = dGB().getName();
        }
        return this.nfD;
    }

    private ClassLoader dGD() {
        if (this.nfu == null) {
            this.nfu = getClass().getClassLoader();
        }
        return this.nfu;
    }

    String Jq(int i) {
        int i2 = 0;
        int indexOf = this.nfG.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nfG.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nfG.length();
        }
        return this.nfG.substring(i2, indexOf);
    }

    int Jr(int i) {
        return Integer.parseInt(Jq(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Js(int i) {
        return org.aspectj.a.b.b.b(Jq(i), dGD());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Jt(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Jq(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dGD());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nfI;

        public b() {
            dGF();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dGE = dGE();
            if (dGE == null) {
                return null;
            }
            return dGE[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dGE = dGE();
            if (dGE == null) {
                dGE = dGF();
            }
            dGE[i] = str;
        }

        private String[] dGE() {
            return (String[]) this.nfI.get();
        }

        private String[] dGF() {
            String[] strArr = new String[3];
            this.nfI = new SoftReference(strArr);
            return strArr;
        }
    }
}
