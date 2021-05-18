package com.bytedance.sdk.openadsdk.preload.geckox.d;

import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.bytedance.sdk.openadsdk.preload.b.j;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends j<UpdatePackage, UpdatePackage> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.j
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage) {
        UpdatePackage.Package patch = updatePackage.getPatch();
        if (patch == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        List<String> urlList = patch.getUrlList();
        if (urlList == null || urlList.isEmpty()) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
        return SchemeDescPatchListener.PATCH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.j
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage, Throwable th, String str) {
        if (SchemeDescPatchListener.PATCH.equals(str)) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        throw new RuntimeException("full update failed, caused by:" + th.getMessage(), th);
    }
}
