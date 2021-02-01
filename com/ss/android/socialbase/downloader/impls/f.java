package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class f implements com.ss.android.socialbase.downloader.i.f {
    @Override // com.ss.android.socialbase.downloader.i.f
    public com.ss.android.socialbase.downloader.i.e v(String str, List<com.ss.android.socialbase.downloader.g.e> list) throws IOException {
        OkHttpClient eGi = com.ss.android.socialbase.downloader.downloader.b.eGi();
        if (eGi == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder head = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.g.e eVar : list) {
                head.addHeader(eVar.a(), com.ss.android.socialbase.downloader.m.d.f(eVar.b()));
            }
        }
        final Call newCall = eGi.newCall(head.build());
        final Response execute = newCall.execute();
        if (execute == null) {
            throw new IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.m.a.a(2097152)) {
            execute.close();
        }
        return new com.ss.android.socialbase.downloader.i.e() { // from class: com.ss.android.socialbase.downloader.impls.f.1
            @Override // com.ss.android.socialbase.downloader.i.e
            public String a(String str2) {
                return execute.header(str2);
            }

            @Override // com.ss.android.socialbase.downloader.i.e
            public int b() throws IOException {
                return execute.code();
            }

            @Override // com.ss.android.socialbase.downloader.i.e
            public void c() {
                if (newCall != null && !newCall.isCanceled()) {
                    newCall.cancel();
                }
            }
        };
    }
}
