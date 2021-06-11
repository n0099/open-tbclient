package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.aegon.httpdns.HttpDnsResolver;
import com.kuaishou.aegon.httpdns.ResolveFinishedInfo;
import com.kuaishou.aegon.httpdns.ResolvedIP;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements b {
    public c() {
        HttpDnsResolver.setLogger(new HttpDnsResolver.a() { // from class: com.kwai.video.ksvodplayerkit.HttpDns.c.1
            @Override // com.kuaishou.aegon.httpdns.HttpDnsResolver.a
            public void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo) {
            }
        });
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.b
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HttpDnsResolver.updateConfig(str);
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.b
    @NonNull
    public List<f> b(String str) {
        if (TextUtils.isEmpty(str) || com.kwai.video.ksvodplayerkit.c.a.a(str)) {
            return new ArrayList();
        }
        List<ResolvedIP> resolve = HttpDnsResolver.resolve(str);
        ArrayList arrayList = new ArrayList();
        if (resolve != null && !resolve.isEmpty()) {
            for (ResolvedIP resolvedIP : resolve) {
                if (resolvedIP != null) {
                    f fVar = new f(resolvedIP.mHost, resolvedIP.mIP, ResolverType.HTTP, resolvedIP.mTtl);
                    fVar.f37984d = resolvedIP.mResolver;
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }
}
