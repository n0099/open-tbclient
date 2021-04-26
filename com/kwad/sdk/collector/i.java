package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.core.network.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        List<AppStatusRules.Target> uploadTargets;
        if (Build.VERSION.SDK_INT >= 19 && (uploadTargets = appStatusRules.getUploadTargets()) != null) {
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            ArrayList arrayList = new ArrayList();
            for (AppStatusRules.Target target : uploadTargets) {
                ArrayList<String> paths = target.getPaths();
                if (paths != null) {
                    String packageName = target.getPackageName();
                    if (new File(file, packageName).exists()) {
                        for (String str : paths) {
                            String a2 = a(str);
                            int i2 = 0;
                            if (str.endsWith(AppStatusRules.SUFFIX_ALL_CHILDREN)) {
                                File[] listFiles = new File(file, str.replace(AppStatusRules.SUFFIX_ALL_CHILDREN, "")).listFiles();
                                if (listFiles != null && listFiles.length > 0) {
                                    int length = listFiles.length;
                                    while (i2 < length) {
                                        File file2 = listFiles[i2];
                                        if (file2.isFile()) {
                                            a(context, appStatusRules, packageName, file2, arrayList);
                                        }
                                        i2++;
                                    }
                                }
                            } else if (str.endsWith(AppStatusRules.SUFFIX_ALL_FILE)) {
                                File[] listFiles2 = new File(file, str.substring(0, str.lastIndexOf("/"))).listFiles();
                                String replace = str.replace(AppStatusRules.SUFFIX_ALL_FILE, "");
                                int length2 = listFiles2.length;
                                while (i2 < length2) {
                                    File file3 = listFiles2[i2];
                                    if (file3.isFile() && file3.getAbsolutePath().contains(replace)) {
                                        a(context, appStatusRules, packageName, file3, arrayList);
                                    }
                                    i2++;
                                }
                            } else if (a2 == null || !a2.startsWith(AppStatusRules.SUFFIX_ALL_FILE)) {
                                a(context, appStatusRules, packageName, new File(file, str), arrayList);
                            }
                        }
                    }
                }
            }
            ArrayList<UploadEntry> readFailureListFromLocal = UploadEntry.readFailureListFromLocal(context);
            if (readFailureListFromLocal != null) {
                arrayList.addAll(readFailureListFromLocal);
                HashSet hashSet = new HashSet(arrayList);
                arrayList.clear();
                arrayList.addAll(hashSet);
            }
            a(context, arrayList);
        }
    }

    public static void a(Context context, AppStatusRules appStatusRules, String str, File file, ArrayList<UploadEntry> arrayList) {
        if ((file.exists() && file.isFile()) && file.length() <= appStatusRules.obtainUploadConfigFileMaxSize()) {
            arrayList.add(new UploadEntry(context, str, file));
        }
    }

    @RequiresApi(api = 19)
    public static void a(final Context context, final ArrayList<UploadEntry> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        new com.kwad.sdk.core.network.i<com.kwad.sdk.collector.b.b, CollectResponse>() { // from class: com.kwad.sdk.collector.i.1
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
            public com.kwad.sdk.collector.b.b b() {
                return new com.kwad.sdk.collector.b.b(arrayList);
            }
        }.a(new j<com.kwad.sdk.collector.b.b, CollectResponse>() { // from class: com.kwad.sdk.collector.i.2
            private synchronized void a() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((UploadEntry) it.next()).cleanTempFile();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.b bVar) {
                super.a((AnonymousClass2) bVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.b bVar, int i2, String str) {
                super.a((AnonymousClass2) bVar, i2, str);
                UploadEntry.saveFailureListToLocal(context, arrayList);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.b bVar, @NonNull CollectResponse collectResponse) {
                super.a((AnonymousClass2) bVar, (com.kwad.sdk.collector.b.b) collectResponse);
                a();
            }
        });
    }
}
