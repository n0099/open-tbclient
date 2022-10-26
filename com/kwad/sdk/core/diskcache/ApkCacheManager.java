package com.kwad.sdk.core.diskcache;

import com.baidu.nps.utils.Constant;
import com.kwad.sdk.core.threads.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import com.kwad.sdk.utils.as;
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
    public Future VO;
    public File VP;
    public final ExecutorService VQ;
    public final Callable VR;

    /* loaded from: classes7.dex */
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
        this.VQ = b.vq();
        this.VR = new Callable() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: sH */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.VP != null && ApkCacheManager.this.VP.exists() && !ApkCacheManager.this.sF()) {
                        for (File file : ApkCacheManager.this.j(ApkCacheManager.this.VP)) {
                            if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                                ApkCacheManager.this.i(file);
                                if (ApkCacheManager.this.sF()) {
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
        if (((d) ServiceProvider.get(d.class)).getContext() == null) {
            return;
        }
        try {
            this.VP = as.cZ(((d) ServiceProvider.get(d.class)).getContext());
        } catch (Throwable unused) {
        }
    }

    public /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    private int g(File file) {
        return (int) ((((float) h(file)) / 1000.0f) / 1000.0f);
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private long h(File file) {
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                j += listFiles[i].isDirectory() ? h(listFiles[i]) : listFiles[i].length();
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        i(file2);
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
    public List j(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        n(arrayList);
        return arrayList;
    }

    private void n(List list) {
        Collections.sort(list, new Comparator() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            public static int a(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return a((File) obj, (File) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sF() {
        File file = this.VP;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.VP.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && g(this.VP) <= 400;
        }
        return true;
    }

    public final void sG() {
        File file = this.VP;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.VO;
        if (future == null || future.isDone()) {
            this.VO = this.VQ.submit(this.VR);
        }
    }
}
