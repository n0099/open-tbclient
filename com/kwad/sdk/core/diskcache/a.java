package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.ksad.download.f;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class a {
    public static volatile a VW;
    public File VP;
    public PackageManager VT;
    public final f VU;
    public volatile boolean VV;
    public final Runnable VX = new Runnable() { // from class: com.kwad.sdk.core.diskcache.a.1
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (a.class) {
                if (a.this.VP != null && a.this.VP.exists()) {
                    for (File file : a.this.j(a.this.VP)) {
                        if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && com.kwad.sdk.core.a.rD().bm(file.getAbsolutePath()) != null && a.this.k(file) != null) {
                            a.this.VU.c(file);
                        }
                    }
                }
            }
        }
    };

    public a(@NonNull Context context) {
        this.VV = false;
        this.VU = new com.kwad.sdk.core.download.a.a(context);
        try {
            File cZ = as.cZ(context);
            this.VP = cZ;
            cZ.mkdirs();
            this.VT = context.getPackageManager();
        } catch (Throwable th) {
            b.printStackTrace(th);
        }
        this.VV = true;
    }

    public static a bn(@NonNull Context context) {
        if (VW == null) {
            synchronized (a.class) {
                if (VW == null) {
                    VW = new a(context);
                }
            }
        }
        return VW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> j(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        n(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo k(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageInfo packageArchiveInfo = this.VT.getPackageArchiveInfo(file.getPath(), 65);
                    if (this.VT.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e) {
                b.printStackTrace(e);
            }
        }
        return null;
    }

    private void n(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
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

    public final void sI() {
        File file;
        if (this.VV && (file = this.VP) != null && file.exists()) {
            g.schedule(this.VX, 10L, TimeUnit.SECONDS);
        }
    }
}
