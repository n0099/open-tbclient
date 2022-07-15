package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.core.threads.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import com.kwad.sdk.utils.ap;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public class ApkCacheManager {
    public Future a;
    public File b;
    public final ExecutorService c;
    public final Callable<Void> d;

    /* loaded from: classes5.dex */
    public enum Holder {
        INSTANCE;
        
        public ApkCacheManager mInstance = new ApkCacheManager((byte) 0);

        Holder() {
        }

        public final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    public ApkCacheManager() {
        this.c = b.j();
        this.d = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.b != null && ApkCacheManager.this.b.exists() && !ApkCacheManager.this.c()) {
                        for (File file : ApkCacheManager.this.d(ApkCacheManager.this.b)) {
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
        if (((d) ServiceProvider.a(d.class)).a() == null) {
            return;
        }
        try {
            this.b = ap.c(((d) ServiceProvider.a(d.class)).a());
        } catch (Throwable unused) {
        }
    }

    public /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    private int a(File file) {
        return (int) ((((float) b(file)) / 1000.0f) / 1000.0f);
    }

    public static ApkCacheManager a() {
        return Holder.INSTANCE.getInstance();
    }

    private void a(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            public static int a(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return a(file, file2);
            }
        });
    }

    private long b(File file) {
        File[] listFiles = file.listFiles();
        long j = 0;
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
        if (file != null && file.exists()) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        c(file2);
                    }
                    file.delete();
                } else if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        File file = this.b;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.b.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && a(this.b) <= 400;
        }
        return true;
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

    public final void b() {
        File file = this.b;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.a;
        if (future == null || future.isDone()) {
            this.a = this.c.submit(this.d);
        }
    }
}
