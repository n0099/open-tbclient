package com.bytedance.sdk.openadsdk.preload.geckox.d;

import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
/* loaded from: classes5.dex */
public class a extends com.bytedance.sdk.openadsdk.preload.b.a<UpdatePackage, UpdatePackage> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.a
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage) {
        int packageType = updatePackage.getPackageType();
        if (packageType != 0) {
            if (packageType == 1) {
                return "branch_single_file";
            }
            throw new RuntimeException("unknow file type: " + packageType);
        }
        return "branch_zip";
    }
}
