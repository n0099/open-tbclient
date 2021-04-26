package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.k;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.util.List;
/* loaded from: classes5.dex */
public class h extends k<UpdatePackage, Pair<Uri, UpdatePackage>> {

    /* renamed from: d  reason: collision with root package name */
    public int f30882d = 0;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.k
    /* renamed from: a */
    public Pair<Uri, UpdatePackage> b() {
        UpdatePackage g2 = g();
        List<String> urlList = g2.getPatch().getUrlList();
        int i2 = this.f30882d;
        this.f30882d = i2 + 1;
        return new Pair<>(Uri.parse(urlList.get(i2)), g2);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.k
    public boolean a(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "patch update failed", th);
        if (this.f30882d >= g().getPatch().getUrlList().size()) {
            return false;
        }
        return (th instanceof com.bytedance.sdk.openadsdk.preload.geckox.b.a) || (th instanceof com.bytedance.sdk.openadsdk.preload.geckox.b.b);
    }
}
