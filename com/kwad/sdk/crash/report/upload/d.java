package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d {
    public static void a(@NonNull final File file, boolean z, @Nullable final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "upload()" + Thread.currentThread());
        final f fVar = new f();
        fVar.aGC = av.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", g.fk(file.getName()));
        fVar.aGE = new JSONObject(hashMap).toString();
        fVar.aGF = q.getExtension(file.getName());
        fVar.aGH = file;
        new l<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @NonNull
            public static GetUploadTokenResult fj(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ GetUploadTokenResult parseData(String str) {
                return fj(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: GU */
            public c createRequest() {
                return new c(av.getDeviceId(), f.this.aGA, "zip");
            }
        }.request(new o<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            public static void a(@NonNull c cVar, int i, String str) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "onError errorCode=" + i + "errorMsg=" + str + "url=" + cVar.getUrl());
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar2, int i, String str) {
                a((c) fVar2, i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (!getUploadTokenResult.isResultOk()) {
                    return;
                }
                f fVar2 = f.this;
                fVar2.aGG = getUploadTokenResult.uploadToken;
                b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                    @Override // com.kwad.sdk.crash.report.upload.a
                    public final void GS() {
                        CountDownLatch countDownLatch2 = countDownLatch;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                        }
                    }

                    @Override // com.kwad.sdk.crash.report.upload.a
                    public final void GT() {
                        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                        CountDownLatch countDownLatch2 = countDownLatch;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (r4) {
                            q.delete(file.getPath());
                        }
                    }
                });
            }
        });
    }
}
