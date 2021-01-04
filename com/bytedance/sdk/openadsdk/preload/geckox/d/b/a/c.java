package com.bytedance.sdk.openadsdk.preload.geckox.d.b.a;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;
/* loaded from: classes4.dex */
public class c extends com.bytedance.sdk.openadsdk.preload.a.d<Pair<File, UpdatePackage>, Pair<String, Long>> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.a.b<Pair<String, Long>> bVar, Pair<File, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start active full zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        File parentFile = ((File) pair.first).getParentFile();
        long version = ((UpdatePackage) pair.second).getVersion();
        File file = new File(parentFile.getParentFile(), version + "");
        com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
        if (!parentFile.renameTo(file)) {
            throw new RuntimeException("active full zip file failed:" + parentFile.getAbsolutePath());
        }
        return bVar.a((com.bytedance.sdk.openadsdk.preload.a.b<Pair<String, Long>>) new Pair<>(((UpdatePackage) pair.second).getChannel(), Long.valueOf(version)));
    }
}
