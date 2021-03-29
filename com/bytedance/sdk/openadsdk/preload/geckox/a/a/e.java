package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends b {
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a(a aVar, File file, List<String> list) {
        super.a(aVar, file, list);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a() {
        for (String str : this.f30208f) {
            List<File> b2 = com.bytedance.sdk.openadsdk.preload.geckox.utils.d.b(new File(this.f30207e, str));
            if (b2 != null && b2.size() > this.f30206d.b()) {
                for (File file : b2.subList(0, b2.size() - this.f30206d.b())) {
                    boolean b3 = com.bytedance.sdk.openadsdk.preload.geckox.a.c.b(file.getAbsolutePath());
                    if (this.f30206d.c() != null) {
                        this.f30206d.c().a(file.getName(), b3);
                    }
                }
            }
        }
    }
}
