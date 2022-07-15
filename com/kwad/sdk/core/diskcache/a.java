package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.ksad.download.f;
import com.kwad.sdk.core.threads.b;
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
public class a {
    public static volatile a g;
    public Future a;
    public File b;
    public PackageManager d;
    public final f e;
    public volatile boolean f;
    public final ExecutorService c = b.j();
    public final Callable<PackageInfo> h = new Callable<PackageInfo>() { // from class: com.kwad.sdk.core.diskcache.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public PackageInfo call() {
            PackageInfo a;
            synchronized (a.class) {
                if (a.this.b != null && a.this.b.exists()) {
                    for (File file : a.this.b(a.this.b)) {
                        if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && com.kwad.sdk.core.a.a().a(file.getAbsolutePath()) != null && (a = a.this.a(file)) != null) {
                            a.this.e.a(file);
                            return a;
                        }
                    }
                    return null;
                }
                return null;
            }
        }
    };

    public a(@NonNull Context context) {
        this.f = false;
        this.e = new com.kwad.sdk.core.download.a.a(context);
        try {
            File c = ap.c(context);
            this.b = c;
            c.mkdirs();
            this.d = context.getPackageManager();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.a(th);
        }
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo a(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageInfo packageArchiveInfo = this.d.getPackageArchiveInfo(file.getPath(), 65);
                    if (this.d.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
        return null;
    }

    public static a a(@NonNull Context context) {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a(context);
                }
            }
        }
        return g;
    }

    private void a(List<File> list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> b(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        a(arrayList);
        return arrayList;
    }

    public final void a() {
        File file;
        if (this.f && (file = this.b) != null && file.exists()) {
            Future future = this.a;
            if (future == null || future.isDone()) {
                this.a = this.c.submit(this.h);
            }
        }
    }
}
