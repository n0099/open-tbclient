package com.bytedance.sdk.openadsdk.preload.geckox.d.b.b;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.l;
import java.io.File;
/* loaded from: classes6.dex */
public class f extends com.bytedance.sdk.openadsdk.preload.b.d<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>, Pair<File, UpdatePackage>> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<File, UpdatePackage>> bVar, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start unzip merged zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar = (com.bytedance.sdk.openadsdk.preload.geckox.buffer.a) pair.first;
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        aVar.b(0L);
        File parentFile = aVar.f().getParentFile();
        try {
            l.a(new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.a(aVar), parentFile.getAbsolutePath(), updatePackage.getChannel());
            aVar.a();
            File file = new File(parentFile, "res");
            com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
            if (!new File(parentFile, updatePackage.getChannel()).renameTo(file)) {
                throw new RuntimeException("rename unzip merged zip file failed:" + parentFile.getAbsolutePath());
            }
            return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<File, UpdatePackage>>) new Pair<>(aVar.f(), updatePackage));
        } catch (Exception e) {
            throw new RuntimeException("unzip merged zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + e.getMessage(), e);
        }
    }
}
