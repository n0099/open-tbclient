package com.bytedance.sdk.openadsdk.preload.geckox.f.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends a {
    public c(File file) {
        super(file);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    protected InputStream a(File file, String str) throws IOException {
        File file2 = new File(file, "res" + File.separator + str);
        if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            throw new IOException("file not found");
        }
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "NormalFileLoader, file:", file2.getAbsolutePath());
        return new FileInputStream(file2.getCanonicalFile());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    protected boolean b(File file, String str) throws IOException {
        return new File(file, "res" + File.separator + str).exists();
    }
}
