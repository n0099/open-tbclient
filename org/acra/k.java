package org.acra;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes.dex */
class k implements FilenameFilter {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".stacktrace");
    }
}
