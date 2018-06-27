package org.aspectj.a.b;

import com.baidu.ar.util.SystemInfoUtil;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int hNa;
    ClassLoader hSV = null;
    String hTf;
    Class hTg;
    a hTh;
    private String hTi;
    String name;
    private static boolean cMq = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hTj = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void as(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hNa = -1;
        this.hNa = i;
        this.name = str;
        this.hTg = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cMq) {
            if (this.hTh == null) {
                try {
                    this.hTh = new b();
                } catch (Throwable th) {
                    cMq = false;
                }
            } else {
                str = this.hTh.get(hVar.hTu);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cMq) {
            this.hTh.as(hVar.hTu, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hTw);
    }

    public int getModifiers() {
        if (this.hNa == -1) {
            this.hNa = wO(0);
        }
        return this.hNa;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wN(1);
        }
        return this.name;
    }

    public Class bPR() {
        if (this.hTg == null) {
            this.hTg = wP(2);
        }
        return this.hTg;
    }

    public String bPS() {
        if (this.hTf == null) {
            this.hTf = bPR().getName();
        }
        return this.hTf;
    }

    private ClassLoader bPT() {
        if (this.hSV == null) {
            this.hSV = getClass().getClassLoader();
        }
        return this.hSV;
    }

    String wN(int i) {
        int i2 = 0;
        int indexOf = this.hTi.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hTi.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hTi.length();
        }
        return this.hTi.substring(i2, indexOf);
    }

    int wO(int i) {
        return Integer.parseInt(wN(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wP(int i) {
        return org.aspectj.a.b.b.b(wN(i), bPT());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wQ(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wN(i), SystemInfoUtil.COLON);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bPT());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hTk;

        public b() {
            bPV();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] bPU = bPU();
            if (bPU == null) {
                return null;
            }
            return bPU[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void as(int i, String str) {
            String[] bPU = bPU();
            if (bPU == null) {
                bPU = bPV();
            }
            bPU[i] = str;
        }

        private String[] bPU() {
            return (String[]) this.hTk.get();
        }

        private String[] bPV() {
            String[] strArr = new String[3];
            this.hTk = new SoftReference(strArr);
            return strArr;
        }
    }
}
