package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.utils.r;
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
        List<com.kwad.sdk.collector.model.e> a = b.rp().a(uploadTargets, obtainUploadConfigFileMaxSize, file.getAbsolutePath() + "/");
        List<UploadEntryNative> aO = aO(context);
        if (aO != null) {
            a.addAll(aO);
            HashSet hashSet = new HashSet(a);
            a.clear();
            a.addAll(hashSet);
        }
        b(context, a);
    }

    public static List<UploadEntryNative> aO(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (file.exists()) {
            try {
                return r.dD(com.kwad.sdk.crash.utils.g.F(file));
            } catch (IOException unused) {
                return null;
            }
        }
        return null;
    }

    public static void aP(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    public static void b(final Context context, final List<com.kwad.sdk.collector.model.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new m<com.kwad.sdk.collector.kwai.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            @NonNull
            public static CollectResponse bj(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: rt */
            public com.kwad.sdk.collector.kwai.b createRequest() {
                return new com.kwad.sdk.collector.kwai.b(list);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ CollectResponse parseData(String str) {
                return bj(str);
            }
        }.request(new n<com.kwad.sdk.collector.kwai.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.kwai.b bVar) {
                super.onStartRequest(bVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull com.kwad.sdk.collector.kwai.b bVar, int i, String str) {
                super.onError(bVar, i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.sdk.collector.kwai.b bVar, @NonNull CollectResponse collectResponse) {
                super.onSuccess(bVar, collectResponse);
                ru();
            }

            private synchronized void ru() {
                j.aP(context);
            }
        });
    }
}
