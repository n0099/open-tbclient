package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes6.dex */
public class g implements com.ss.android.socialbase.downloader.i.h {
    @Override // com.ss.android.socialbase.downloader.i.h
    public com.ss.android.socialbase.downloader.i.g a(int i, String str, List<com.ss.android.socialbase.downloader.g.e> list) throws IOException {
        OkHttpClient eGu = com.ss.android.socialbase.downloader.downloader.b.eGu();
        if (eGu == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder url = new Request.Builder().url(str);
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.g.e eVar : list) {
                url.addHeader(eVar.a(), com.ss.android.socialbase.downloader.m.d.f(eVar.b()));
            }
        }
        final Call newCall = eGu.newCall(url.build());
        final Response execute = newCall.execute();
        if (execute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody body = execute.body();
        if (body != null) {
            InputStream byteStream = body.byteStream();
            String header = execute.header("Content-Encoding");
            final InputStream gZIPInputStream = (header == null || !"gzip".equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream);
            return new com.ss.android.socialbase.downloader.i.d() { // from class: com.ss.android.socialbase.downloader.impls.g.1
                @Override // com.ss.android.socialbase.downloader.i.g
                public InputStream a() throws IOException {
                    return gZIPInputStream;
                }

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

                @Override // com.ss.android.socialbase.downloader.i.g
                public void d() {
                    try {
                        if (body != null) {
                            body.close();
                        }
                        if (newCall != null && !newCall.isCanceled()) {
                            newCall.cancel();
                        }
                    } catch (Throwable th) {
                    }
                }
            };
        }
        return null;
    }
}
