package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
class e extends b {
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a(a aVar, File file, List<String> list) {
        super.a(aVar, file, list);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a() {
        for (String str : this.f) {
            List<File> b = com.bytedance.sdk.openadsdk.preload.geckox.utils.d.b(new File(this.e, str));
            if (b != null && b.size() > this.d.b()) {
                for (File file : b.subList(0, b.size() - this.d.b())) {
                    boolean b2 = com.bytedance.sdk.openadsdk.preload.geckox.a.c.b(file.getAbsolutePath());
                    if (this.d.c() != null) {
                        this.d.c().a(file.getName(), b2);
                    }
                }
            }
        }
    }
}
