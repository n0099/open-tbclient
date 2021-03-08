package com.bytedance.sdk.openadsdk.preload.geckox.d;

import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
/* loaded from: classes6.dex */
public class a extends com.bytedance.sdk.openadsdk.preload.b.a<UpdatePackage, UpdatePackage> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.preload.b.a
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage) {
        int packageType = updatePackage.getPackageType();
        switch (packageType) {
            case 0:
                return "branch_zip";
            case 1:
                return "branch_single_file";
            default:
                throw new RuntimeException("unknow file type: " + packageType);
        }
    }
}
