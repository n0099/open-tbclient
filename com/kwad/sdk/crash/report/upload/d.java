package com.kwad.sdk.crash.report.upload;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d {
    public static void a(final File file, boolean z, final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "upload()" + Thread.currentThread());
        final f fVar = new f();
        fVar.aid = ar.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", com.kwad.sdk.crash.utils.f.df(file.getName()));
        fVar.aif = new JSONObject(hashMap).toString();
        fVar.aig = o.getExtension(file.getName());
        fVar.aii = file;
        new m() { // from class: com.kwad.sdk.crash.report.upload.d.1
            public static GetUploadTokenResult de(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: wW */
            public c createRequest() {
                return new c(ar.getDeviceId(), f.this.aib, StatConstants.VALUE_TYPE_ZIP);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ BaseResultData parseData(String str) {
                return de(str);
            }
        }.request(new n() { // from class: com.kwad.sdk.crash.report.upload.d.2
            public static void a(c cVar, int i, String str) {
                com.kwad.sdk.core.e.b.d("ExceptionCollector", "onError errorCode=" + i + "errorMsg=" + str + "url=" + cVar.getUrl());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(c cVar, GetUploadTokenResult getUploadTokenResult) {
                com.kwad.sdk.core.e.b.d("ExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    f fVar2 = f.this;
                    fVar2.aih = getUploadTokenResult.uploadToken;
                    b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void wU() {
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void wV() {
                            com.kwad.sdk.core.e.b.d("ExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (r4) {
                                o.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(g gVar, int i, String str) {
                a((c) gVar, i, str);
            }
        });
    }
}
