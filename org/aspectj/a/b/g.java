package org.aspectj.a.b;

import com.baidu.mobstat.Config;
/* loaded from: classes5.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    Class jSZ;
    int line;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.jSZ = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int cCN() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(cCN()).toString();
    }
}
