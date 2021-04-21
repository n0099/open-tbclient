package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends b {
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a(a aVar, File file, List<String> list) {
        super.a(aVar, file, list);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a() {
        for (String str : this.f29901f) {
            List<File> b2 = com.bytedance.sdk.openadsdk.preload.geckox.utils.d.b(new File(this.f29900e, str));
            if (b2 != null && b2.size() > this.f29899d.b()) {
                for (File file : b2.subList(0, b2.size() - this.f29899d.b())) {
                    boolean b3 = com.bytedance.sdk.openadsdk.preload.geckox.a.c.b(file.getAbsolutePath());
                    if (this.f29899d.c() != null) {
                        this.f29899d.c().a(file.getName(), b3);
                    }
                }
            }
        }
    }
}
