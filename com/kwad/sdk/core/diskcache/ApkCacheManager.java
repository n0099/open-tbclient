package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aw;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes10.dex */
public class ApkCacheManager {
    public Future aiU;
    public File aru;
    public final ExecutorService arv;
    public final Callable<Void> arw;

    /* loaded from: classes10.dex */
    public enum Holder {
        INSTANCE;
        
        public ApkCacheManager mInstance = new ApkCacheManager((byte) 0);

        public final ApkCacheManager getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    public ApkCacheManager() {
        this.arv = GlobalThreadPools.EB();
        this.arw = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: BI */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.aru != null && ApkCacheManager.this.aru.exists() && !ApkCacheManager.this.BG()) {
                        for (File file : ApkCacheManager.this.n(ApkCacheManager.this.aru)) {
                            if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                                ApkCacheManager.this.h(file);
                                if (ApkCacheManager.this.BG()) {
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
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        try {
            this.aru = aw.cL(((f) ServiceProvider.get(f.class)).getContext());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BG() {
        File file = this.aru;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.aru.listFiles();
        if (listFiles.length > 5) {
            if (listFiles.length > 10 || l(this.aru) > 400) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void BH() {
        File file = this.aru;
        if (file != null && file.exists()) {
            Future future = this.aiU;
            if (future == null || future.isDone()) {
                this.aiU = this.arv.submit(this.arw);
            }
        }
    }

    public /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        h(file2);
                    }
                    file.delete();
                } else if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    private int l(File file) {
        return (int) ((((float) m(file)) / 1000.0f) / 1000.0f);
    }

    private long m(File file) {
        long length;
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            int length2 = listFiles.length;
            for (int i = 0; i < length2; i++) {
                if (listFiles[i].isDirectory()) {
                    length = m(listFiles[i]);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        t(arrayList);
        return arrayList;
    }

    private void t(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            public static int c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    if (file.lastModified() == file2.lastModified()) {
                        return 0;
                    }
                    return 1;
                }
                return -1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return c(file, file2);
            }
        });
    }
}
