package com.bytedance.sdk.openadsdk.preload.geckox.d.b.b;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.h;
/* loaded from: classes5.dex */
public class b extends com.bytedance.sdk.openadsdk.preload.b.d<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> bVar, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start check patch zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar = (com.bytedance.sdk.openadsdk.preload.geckox.buffer.a) pair.first;
        aVar.b(0L);
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        try {
            h.a(new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.a(aVar), updatePackage.getPatch().getMd5());
            return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>>) pair);
        } catch (Throwable th) {
            throw new com.bytedance.sdk.openadsdk.preload.geckox.b.b("check patch zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
