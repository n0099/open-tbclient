package com.bytedance.sdk.openadsdk.preload.geckox.i;

import com.baidubce.AbstractBceClient;
import d.b.c.a.b.a0;
import d.b.c.a.b.b0;
import d.b.c.a.b.v;
import d.b.c.a.b.x;
import d.b.c.a.b.y;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public y f30906a;

    /* renamed from: b  reason: collision with root package name */
    public y f30907b;

    public a() {
        y.b bVar = new y.b();
        bVar.a(10L, TimeUnit.SECONDS);
        bVar.d(10L, TimeUnit.SECONDS);
        bVar.f(10L, TimeUnit.SECONDS);
        this.f30906a = bVar.c();
        y.b bVar2 = new y.b();
        bVar2.a(10L, TimeUnit.SECONDS);
        bVar2.d(30L, TimeUnit.SECONDS);
        bVar2.f(30L, TimeUnit.SECONDS);
        this.f30907b = bVar2.c();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.i.b
    public c a(String str, String str2) throws Exception {
        b0 b2 = b0.b(x.a(AbstractBceClient.DEFAULT_CONTENT_TYPE), str2);
        a0.a aVar = new a0.a();
        aVar.e(str);
        aVar.d(b2);
        d.b.c.a.b.c a2 = this.f30906a.c(aVar.p()).a();
        return new c(a(a2.w()), a2.r() == 200 ? a2.x().s() : null, a2.r(), a2.t());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.i.b
    public void a(String str, long j, com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.b bVar) throws Exception {
        Exception e2;
        int i2;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                a0.a aVar = new a0.a();
                aVar.a();
                aVar.e(str);
                d.b.c.a.b.c a2 = this.f30907b.c(aVar.p()).a();
                i2 = a2.r();
                try {
                    bufferedInputStream = new BufferedInputStream(a2.x().q());
                } catch (Exception e3) {
                    e2 = e3;
                }
            } catch (Exception e4) {
                e2 = e4;
                i2 = 0;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read != -1) {
                    bVar.write(bArr, 0, read);
                } else {
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream);
                    return;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            throw new RuntimeException("downloadFile failed, code: " + i2 + ", url:" + str + ", caused by:" + e2.getMessage(), e2);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream2);
            throw th;
        }
    }

    private Map<String, String> a(v vVar) {
        if (vVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : vVar.g()) {
            hashMap.put(str, vVar.c(str));
        }
        return hashMap;
    }
}
