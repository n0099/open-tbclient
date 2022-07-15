package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d {
    public static void a(@NonNull final File file, boolean z, @Nullable final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.b.a("ExceptionCollector", "upload()" + Thread.currentThread());
        final f fVar = new f();
        fVar.e = ao.e();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", com.kwad.sdk.crash.utils.f.a(file.getName()));
        fVar.g = new JSONObject(hashMap).toString();
        fVar.i = o.e(file.getName());
        fVar.k = file;
        new l<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            @NonNull
            public static GetUploadTokenResult a(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public c createRequest() {
                return new c(ao.e(), f.this.c, StatConstants.VALUE_TYPE_ZIP);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ GetUploadTokenResult parseData(String str) {
                return a(str);
            }
        }.request(new m<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            public static void a(@NonNull c cVar, int i, String str) {
                com.kwad.sdk.core.d.b.a("ExceptionCollector", "onError errorCode=" + i + "errorMsg=" + str + "url=" + cVar.getUrl());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) {
                com.kwad.sdk.core.d.b.a("ExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    f fVar2 = f.this;
                    fVar2.j = getUploadTokenResult.uploadToken;
                    b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void a() {
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void b() {
                            com.kwad.sdk.core.d.b.a("ExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (r4) {
                                o.d(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                a((c) gVar, i, str);
            }
        });
    }
}
