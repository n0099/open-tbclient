package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.ksad.download.f;
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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f55656g;
    public Future a;

    /* renamed from: b  reason: collision with root package name */
    public File f55657b;

    /* renamed from: d  reason: collision with root package name */
    public PackageManager f55659d;

    /* renamed from: e  reason: collision with root package name */
    public final f f55660e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f55661f;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f55658c = b.k();

    /* renamed from: h  reason: collision with root package name */
    public final Callable<PackageInfo> f55662h = new Callable<PackageInfo>() { // from class: com.kwad.sdk.core.diskcache.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public PackageInfo call() {
            PackageInfo a;
            synchronized (a.class) {
                if (a.this.f55657b != null && a.this.f55657b.exists()) {
                    for (File file : a.this.b(a.this.f55657b)) {
                        if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && com.kwad.sdk.core.a.a().a(file.getAbsolutePath()) != null && (a = a.this.a(file)) != null) {
                            a.this.f55660e.a(file);
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
        this.f55661f = false;
        this.f55660e = new com.kwad.sdk.core.download.b.a(context);
        try {
            this.f55657b = aq.c(context);
            this.f55659d = context.getPackageManager();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.f55661f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo a(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageInfo packageArchiveInfo = this.f55659d.getPackageArchiveInfo(file.getPath(), 65);
                    if (this.f55659d.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        return null;
    }

    public static a a(@NonNull Context context) {
        if (f55656g == null) {
            synchronized (a.class) {
                if (f55656g == null) {
                    f55656g = new a(context);
                }
            }
        }
        return f55656g;
    }

    private void a(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
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

    public void a() {
        File file;
        if (this.f55661f && (file = this.f55657b) != null && file.exists()) {
            Future future = this.a;
            if (future == null || future.isDone()) {
                this.a = this.f55658c.submit(this.f55662h);
            }
        }
    }
}
