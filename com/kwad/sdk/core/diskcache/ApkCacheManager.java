package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.utils.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class ApkCacheManager {

    /* renamed from: a  reason: collision with root package name */
    private Future f9058a;

    /* renamed from: b  reason: collision with root package name */
    private File f9059b;
    private final ExecutorService c;
    private final Callable<Void> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Holder {
        INSTANCE;
        
        private ApkCacheManager mInstance = new ApkCacheManager();

        Holder() {
        }

        ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    private ApkCacheManager() {
        this.c = Executors.newSingleThreadExecutor();
        this.d = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.f9059b != null && ApkCacheManager.this.f9059b.exists() && !ApkCacheManager.this.c()) {
                        Iterator it = ApkCacheManager.this.d(ApkCacheManager.this.f9059b).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            File file = (File) it.next();
                            if (file.getName().endsWith(".apk")) {
                                ApkCacheManager.this.c(file);
                                if (ApkCacheManager.this.c()) {
                                    break;
                                }
                            }
                        }
                    }
                }
                return null;
            }
        };
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        try {
            this.f9059b = ad.c(KsAdSDKImpl.get().getContext());
        } catch (Throwable th) {
            a.a(th);
        }
    }

    private int a(File file) {
        return (int) ((((float) b(file)) / 1000.0f) / 1000.0f);
    }

    public static ApkCacheManager a() {
        return Holder.INSTANCE.getInstance();
    }

    private void a(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }
        });
    }

    private long b(File file) {
        long j = 0;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                j += listFiles[i].isDirectory() ? b(listFiles[i]) : listFiles[i].length();
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (!file.isDirectory()) {
                if (file.exists()) {
                    file.delete();
                    return;
                }
                return;
            }
            for (File file2 : file.listFiles()) {
                c(file2);
            }
            file.delete();
        } catch (Exception e) {
            a.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (this.f9059b == null || !this.f9059b.exists()) {
            return false;
        }
        File[] listFiles = this.f9059b.listFiles();
        return listFiles.length <= 5 || (listFiles.length <= 10 && a(this.f9059b) <= 400);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> d(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            arrayList.addAll(Arrays.asList(listFiles));
            a(arrayList);
        }
        return arrayList;
    }

    public void b() {
        if (this.f9059b == null || !this.f9059b.exists()) {
            return;
        }
        if (this.f9058a == null || this.f9058a.isDone()) {
            this.f9058a = this.c.submit(this.d);
        }
    }
}
