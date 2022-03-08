package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.i.b;
import com.kwad.sdk.utils.aq;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class ApkCacheManager {
    public Future a;

    /* renamed from: b  reason: collision with root package name */
    public File f54215b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f54216c;

    /* renamed from: d  reason: collision with root package name */
    public final Callable<Void> f54217d;

    /* loaded from: classes7.dex */
    public enum Holder {
        INSTANCE;
        
        public ApkCacheManager mInstance = new ApkCacheManager();

        Holder() {
        }

        public ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    public ApkCacheManager() {
        this.f54216c = b.j();
        this.f54217d = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.f54215b != null && ApkCacheManager.this.f54215b.exists() && !ApkCacheManager.this.c()) {
                        for (File file : ApkCacheManager.this.d(ApkCacheManager.this.f54215b)) {
                            if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                                ApkCacheManager.this.c(file);
                                if (ApkCacheManager.this.c()) {
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                }
            }
        };
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        try {
            this.f54215b = aq.c(KsAdSDKImpl.get().getContext());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
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
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i2 = 0; i2 < length; i2++) {
                j2 += listFiles[i2].isDirectory() ? b(listFiles[i2]) : listFiles[i2].length();
            }
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    c(file2);
                }
            } else if (!file.exists()) {
                return;
            }
            file.delete();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        File file = this.f54215b;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.f54215b.listFiles();
        return listFiles.length <= 5 || (listFiles.length <= 10 && a(this.f54215b) <= 400);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> d(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        a(arrayList);
        return arrayList;
    }

    public void b() {
        File file = this.f54215b;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.a;
        if (future == null || future.isDone()) {
            this.a = this.f54216c.submit(this.f54217d);
        }
    }
}
