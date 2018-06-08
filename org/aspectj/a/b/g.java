package org.aspectj.a.b;

import com.baidu.ar.util.SystemInfoUtil;
/* loaded from: classes2.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    Class hPf;
    int line;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.hPf = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int bPt() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(SystemInfoUtil.COLON).append(bPt()).toString();
    }
}
