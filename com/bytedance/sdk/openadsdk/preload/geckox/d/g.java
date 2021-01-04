package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.a.k;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends k<UpdatePackage, Pair<Uri, UpdatePackage>> {
    private int d = 0;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.preload.a.k
    /* renamed from: a */
    public Pair<Uri, UpdatePackage> b() {
        UpdatePackage g = g();
        List<String> urlList = g.getFullPackage().getUrlList();
        int i = this.d;
        this.d = i + 1;
        return new Pair<>(Uri.parse(urlList.get(i)), g);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.k
    protected boolean a(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "full update failed and retry", th);
        if (this.d >= g().getFullPackage().getUrlList().size()) {
            return false;
        }
        return (th instanceof com.bytedance.sdk.openadsdk.preload.geckox.b.a) || (th instanceof com.bytedance.sdk.openadsdk.preload.geckox.b.b);
    }
}
