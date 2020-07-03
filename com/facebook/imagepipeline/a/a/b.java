package com.facebook.imagepipeline.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.searchbox.http.HttpManager;
import com.baidubce.http.Headers;
import com.facebook.imagepipeline.g.e;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.ak;
import com.facebook.imagepipeline.producers.c;
import com.facebook.imagepipeline.producers.k;
import com.facebook.imagepipeline.producers.t;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes12.dex */
public class b extends c<a> {
    private Context mContext;
    private volatile Call.Factory mQN;
    private volatile Executor mQO;

    /* loaded from: classes12.dex */
    public static class a extends t {
        public long mQU;
        public long mQV;
        public long responseTime;

        public a(k<e> kVar, ak akVar) {
            super(kVar, akVar);
        }
    }

    public b(OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
    }

    public b(Call.Factory factory, Executor executor) {
        this.mQN = factory;
        this.mQO = executor;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.af
    /* renamed from: a */
    public a b(k<e> kVar, ak akVar) {
        return new a(kVar, akVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.af
    public void a(a aVar, af.a aVar2) {
        aVar.mQU = SystemClock.elapsedRealtime();
        Uri uri = aVar.getUri();
        dCp();
        try {
            Request.Builder builder = new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(uri.toString()).get();
            com.facebook.imagepipeline.common.a dFc = aVar.dGl().dFY().dFc();
            if (dFc != null) {
                builder.addHeader(Headers.RANGE, dFc.dCO());
            }
            Map<String, String> dGp = aVar.dGp();
            if (dGp == null) {
                builder.addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 4.4.2; Nexus 5 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
            } else {
                if (!dGp.containsKey("User-Agent")) {
                    builder.addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 4.4.2; Nexus 5 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
                }
                for (Map.Entry<String, String> entry : dGp.entrySet()) {
                    builder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            a(aVar, aVar2, builder.build());
        } catch (Exception e) {
            aVar2.G(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.c, com.facebook.imagepipeline.producers.af
    /* renamed from: a */
    public void b(a aVar, int i) {
        aVar.mQV = SystemClock.elapsedRealtime();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.c, com.facebook.imagepipeline.producers.af
    /* renamed from: b */
    public Map<String, String> a(a aVar, int i) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(aVar.responseTime - aVar.mQU));
        hashMap.put("fetch_time", Long.toString(aVar.mQV - aVar.responseTime));
        hashMap.put("total_time", Long.toString(aVar.mQV - aVar.mQU));
        hashMap.put("image_size", Integer.toString(i));
        return hashMap;
    }

    protected void a(final a aVar, final af.a aVar2, Request request) {
        final Call newCall = this.mQN.newCall(request);
        aVar.dGl().a(new com.facebook.imagepipeline.producers.e() { // from class: com.facebook.imagepipeline.a.a.b.1
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dCq() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    b.this.mQO.execute(new Runnable() { // from class: com.facebook.imagepipeline.a.a.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            newCall.cancel();
                        }
                    });
                } else {
                    newCall.cancel();
                }
            }
        });
        newCall.enqueue(new Callback() { // from class: com.facebook.imagepipeline.a.a.b.2
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                aVar.responseTime = SystemClock.elapsedRealtime();
                ResponseBody body = response.body();
                try {
                    if (!response.isSuccessful()) {
                        b.this.a(call, new IOException("Unexpected HTTP code " + response), aVar2);
                        return;
                    }
                    com.facebook.imagepipeline.common.a QO = com.facebook.imagepipeline.common.a.QO(response.header(Headers.CONTENT_RANGE));
                    if (QO != null && (QO.from != 0 || QO.to != Integer.MAX_VALUE)) {
                        aVar.c(QO);
                        aVar.Jo(8);
                    }
                    long contentLength = body.contentLength();
                    aVar2.g(body.byteStream(), (int) (contentLength >= 0 ? contentLength : 0L));
                } catch (Exception e) {
                    b.this.a(call, e, aVar2);
                } finally {
                    body.close();
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                b.this.a(call, iOException, aVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Call call, Exception exc, af.a aVar) {
        if (call.isCanceled()) {
            aVar.dzd();
        } else {
            aVar.G(exc);
        }
    }

    private void dCp() {
        if (this.mQO == null) {
            synchronized (this) {
                if (this.mQO == null) {
                    OkHttpClient okHttpClient = HttpManager.newHttpManager(this.mContext).getOkHttpClient();
                    this.mQN = okHttpClient;
                    this.mQO = okHttpClient.dispatcher().executorService();
                }
            }
        }
    }
}
