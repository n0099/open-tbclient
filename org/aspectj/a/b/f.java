package org.aspectj.a.b;

import com.baidu.mobstat.Config;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int jNb;
    ClassLoader jSJ = null;
    String jST;
    Class jSU;
    a jSV;
    private String jSW;
    String name;
    private static boolean eyc = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] jSX = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        String Db(int i);

        void aM(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.jNb = -1;
        this.jNb = i;
        this.name = str;
        this.jSU = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eyc) {
            if (this.jSV == null) {
                try {
                    this.jSV = new b();
                } catch (Throwable th) {
                    eyc = false;
                }
            } else {
                str = this.jSV.Db(hVar.jTi);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eyc) {
            this.jSV.aM(hVar.jTi, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.jTk);
    }

    public int getModifiers() {
        if (this.jNb == -1) {
            this.jNb = CY(0);
        }
        return this.jNb;
    }

    public String getName() {
        if (this.name == null) {
            this.name = CX(1);
        }
        return this.name;
    }

    public Class cCI() {
        if (this.jSU == null) {
            this.jSU = CZ(2);
        }
        return this.jSU;
    }

    public String cCJ() {
        if (this.jST == null) {
            this.jST = cCI().getName();
        }
        return this.jST;
    }

    private ClassLoader cCK() {
        if (this.jSJ == null) {
            this.jSJ = getClass().getClassLoader();
        }
        return this.jSJ;
    }

    String CX(int i) {
        int i2 = 0;
        int indexOf = this.jSW.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.jSW.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.jSW.length();
        }
        return this.jSW.substring(i2, indexOf);
    }

    int CY(int i) {
        return Integer.parseInt(CX(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class CZ(int i) {
        return org.aspectj.a.b.b.b(CX(i), cCK());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Da(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(CX(i), Config.TRACE_TODAY_VISIT_SPLIT);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cCK());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference jSY;

        public b() {
            cCM();
        }

        @Override // org.aspectj.a.b.f.a
        public String Db(int i) {
            String[] cCL = cCL();
            if (cCL == null) {
                return null;
            }
            return cCL[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aM(int i, String str) {
            String[] cCL = cCL();
            if (cCL == null) {
                cCL = cCM();
            }
            cCL[i] = str;
        }

        private String[] cCL() {
            return (String[]) this.jSY.get();
        }

        private String[] cCM() {
            String[] strArr = new String[3];
            this.jSY = new SoftReference(strArr);
            return strArr;
        }
    }
}
