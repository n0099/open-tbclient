package org.aspectj.a.b;

import com.baidu.mobstat.Config;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int jNa;
    ClassLoader jSI = null;
    String jSS;
    Class jST;
    a jSU;
    private String jSV;
    String name;
    private static boolean eyb = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] jSW = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        String Db(int i);

        void aM(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.jNa = -1;
        this.jNa = i;
        this.name = str;
        this.jST = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eyb) {
            if (this.jSU == null) {
                try {
                    this.jSU = new b();
                } catch (Throwable th) {
                    eyb = false;
                }
            } else {
                str = this.jSU.Db(hVar.jTh);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eyb) {
            this.jSU.aM(hVar.jTh, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.jTj);
    }

    public int getModifiers() {
        if (this.jNa == -1) {
            this.jNa = CY(0);
        }
        return this.jNa;
    }

    public String getName() {
        if (this.name == null) {
            this.name = CX(1);
        }
        return this.name;
    }

    public Class cCI() {
        if (this.jST == null) {
            this.jST = CZ(2);
        }
        return this.jST;
    }

    public String cCJ() {
        if (this.jSS == null) {
            this.jSS = cCI().getName();
        }
        return this.jSS;
    }

    private ClassLoader cCK() {
        if (this.jSI == null) {
            this.jSI = getClass().getClassLoader();
        }
        return this.jSI;
    }

    String CX(int i) {
        int i2 = 0;
        int indexOf = this.jSV.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.jSV.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.jSV.length();
        }
        return this.jSV.substring(i2, indexOf);
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
        private SoftReference jSX;

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
            return (String[]) this.jSX.get();
        }

        private String[] cCM() {
            String[] strArr = new String[3];
            this.jSX = new SoftReference(strArr);
            return strArr;
        }
    }
}
