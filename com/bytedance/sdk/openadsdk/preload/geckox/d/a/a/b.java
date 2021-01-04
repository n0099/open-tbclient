package com.bytedance.sdk.openadsdk.preload.geckox.d.a.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.a.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends d<Pair<Uri, UpdatePackage>, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> {
    private com.bytedance.sdk.openadsdk.preload.geckox.b d;
    private File e;

    public static String a(UpdatePackage updatePackage, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("url empty, channel:" + updatePackage.getChannel());
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            throw new RuntimeException("url path illegal, url:" + str);
        }
        String substring = str.substring(lastIndexOf + 1);
        if (TextUtils.isEmpty(substring)) {
            throw new RuntimeException("url path illegal, url:" + str);
        }
        return substring;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.preload.a.d
    public void a(Object... objArr) {
        super.a(objArr);
        this.d = (com.bytedance.sdk.openadsdk.preload.geckox.b) objArr[0];
        this.e = (File) objArr[1];
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[CONST_STR, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.a.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> bVar, Pair<Uri, UpdatePackage> pair) throws Throwable {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start download full single file channel:", ((UpdatePackage) pair.second).getChannel());
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        String uri = ((Uri) pair.first).toString();
        long length = updatePackage.getFullPackage().getLength();
        File file = new File(this.e, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel() + File.separator + updatePackage.getVersion() + "--updating");
        file.mkdirs();
        com.bytedance.sdk.openadsdk.preload.geckox.buffer.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl.a.a(this.d.a(), new File(file, "res" + File.separator + a(updatePackage, uri)), length);
        try {
            this.d.h().a(uri, length, new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.b(a2));
            try {
                try {
                    return bVar.a((com.bytedance.sdk.openadsdk.preload.a.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>>) new Pair<>(a2, updatePackage));
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                try {
                    a2.e();
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "DownloadFullSingleFile-release:", e2);
                }
            }
        } catch (Throwable th) {
            a2.e();
            throw new com.bytedance.sdk.openadsdk.preload.geckox.b.a("download full single file failed! url:" + uri + ", channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
