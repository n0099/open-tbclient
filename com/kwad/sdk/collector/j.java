package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class j {
    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        long obtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
        List<com.kwad.sdk.collector.model.e> a = b.zA().a(uploadTargets, obtainUploadConfigFileMaxSize, file.getAbsolutePath() + "/");
        List<UploadEntryNative> aL = aL(context);
        if (aL != null) {
            a.addAll(aL);
            HashSet hashSet = new HashSet(a);
            a.clear();
            a.addAll(hashSet);
        }
        b(context, a);
    }

    public static List<UploadEntryNative> aL(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            return t.fP(com.kwad.sdk.crash.utils.h.I(file));
        } catch (IOException unused) {
            return null;
        }
    }

    public static void aM(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (!file.exists()) {
                return;
            }
            file.delete();
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    public static void b(final Context context, final List<com.kwad.sdk.collector.model.e> list) {
        if (list != null && list.size() != 0) {
            new l<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
                @Override // com.kwad.sdk.core.network.l
                public final boolean enableMonitorReport() {
                    return false;
                }

                @NonNull
                public static CollectResponse ck(String str) {
                    CollectResponse collectResponse = new CollectResponse();
                    collectResponse.parseJson(new JSONObject(str));
                    return collectResponse;
                }

                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ CollectResponse parseData(String str) {
                    return ck(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: zF */
                public com.kwad.sdk.collector.a.b createRequest() {
                    return new com.kwad.sdk.collector.a.b(list);
                }
            }.request(new o<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.sdk.collector.a.b bVar) {
                    super.onStartRequest(bVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onError(@NonNull com.kwad.sdk.collector.a.b bVar, int i, String str) {
                    super.onError(bVar, i, str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.sdk.collector.a.b bVar, @NonNull CollectResponse collectResponse) {
                    super.onSuccess(bVar, collectResponse);
                    zG();
                }

                private synchronized void zG() {
                    j.aM(context);
                }
            });
        }
    }
}
