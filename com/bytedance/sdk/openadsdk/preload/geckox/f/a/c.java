package com.bytedance.sdk.openadsdk.preload.geckox.f.a;

import com.facebook.common.util.UriUtil;
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
    public InputStream a(File file, String str) throws IOException {
        File file2 = new File(file, UriUtil.LOCAL_RESOURCE_SCHEME + File.separator + str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "NormalFileLoader, file:", file2.getAbsolutePath());
            return new FileInputStream(file2.getCanonicalFile());
        }
        throw new IOException("file not found");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.f.a.a
    public boolean b(File file, String str) throws IOException {
        return new File(file, UriUtil.LOCAL_RESOURCE_SCHEME + File.separator + str).exists();
    }
}
