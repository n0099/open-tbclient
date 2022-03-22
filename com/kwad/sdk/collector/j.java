package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j {
    public static void a(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

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
        List<com.kwad.sdk.collector.model.e> a = b.a().a(uploadTargets, obtainUploadConfigFileMaxSize, file.getAbsolutePath() + "/");
        List<UploadEntryNative> b2 = b(context);
        if (b2 != null) {
            a.addAll(b2);
            HashSet hashSet = new HashSet(a);
            a.clear();
            a.addAll(hashSet);
        }
        a(context, a);
    }

    @RequiresApi(api = 19)
    public static void a(final Context context, final List<com.kwad.sdk.collector.model.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new com.kwad.sdk.core.network.i<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public CollectResponse b(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.collector.a.b b() {
                return new com.kwad.sdk.collector.a.b(list);
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean c() {
                return false;
            }
        }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            private synchronized void a() {
                j.a(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.a.b bVar) {
                super.a((AnonymousClass2) bVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.a.b bVar, int i, String str) {
                super.a((AnonymousClass2) bVar, i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.a.b bVar, @NonNull CollectResponse collectResponse) {
                super.a((AnonymousClass2) bVar, (com.kwad.sdk.collector.a.b) collectResponse);
                a();
            }
        });
    }

    public static List<UploadEntryNative> b(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (file.exists()) {
            try {
                return t.a(com.kwad.sdk.crash.utils.h.a(file));
            } catch (IOException unused) {
                return null;
            }
        }
        return null;
    }
}
