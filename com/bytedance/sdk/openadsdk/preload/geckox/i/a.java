package com.bytedance.sdk.openadsdk.preload.geckox.i;

import com.baidubce.AbstractBceClient;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    protected z f7493a = new z.a().d(10, TimeUnit.SECONDS).e(10, TimeUnit.SECONDS).c(d.a()).a(d.b()).f(10, TimeUnit.SECONDS).eqA();

    /* renamed from: b  reason: collision with root package name */
    protected z f7494b = new z.a().d(10, TimeUnit.SECONDS).e(30, TimeUnit.SECONDS).c(d.a()).a(d.b()).f(30, TimeUnit.SECONDS).eqA();

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.i.b
    public c a(String str, String str2) throws Exception {
        com.bytedance.sdk.a.b.b epR = this.f7493a.g(new ab.a().Za(str).a(ac.a(y.YZ(AbstractBceClient.DEFAULT_CONTENT_TYPE), str2)).eqJ()).epR();
        return new c(a(epR.epM()), epR.c() == 200 ? epR.epN().e() : null, epR.c(), epR.d());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.i.b
    public void a(String str, long j, com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.b bVar) throws Exception {
        BufferedInputStream bufferedInputStream;
        int i = 0;
        try {
            com.bytedance.sdk.a.b.b epR = this.f7494b.g(new ab.a().eqG().Za(str).eqJ()).epR();
            i = epR.c();
            bufferedInputStream = new BufferedInputStream(epR.epN().c());
            try {
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, bArr.length);
                        if (read != -1) {
                            bVar.write(bArr, 0, read);
                        } else {
                            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream);
                            return;
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    throw new RuntimeException("downloadFile failed, code: " + i + ", url:" + str + ", caused by:" + e.getMessage(), e);
                }
            } catch (Throwable th) {
                th = th;
                com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream);
            throw th;
        }
    }

    private Map<String, String> a(v vVar) {
        if (vVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : vVar.b()) {
            hashMap.put(str, vVar.a(str));
        }
        return hashMap;
    }
}
