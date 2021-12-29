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
    public static volatile a f57847g;
    public Future a;

    /* renamed from: b  reason: collision with root package name */
    public File f57848b;

    /* renamed from: d  reason: collision with root package name */
    public PackageManager f57850d;

    /* renamed from: e  reason: collision with root package name */
    public final f f57851e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f57852f;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f57849c = b.k();

    /* renamed from: h  reason: collision with root package name */
    public final Callable<PackageInfo> f57853h = new Callable<PackageInfo>() { // from class: com.kwad.sdk.core.diskcache.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public PackageInfo call() {
            PackageInfo a;
            synchronized (a.class) {
                if (a.this.f57848b != null && a.this.f57848b.exists()) {
                    for (File file : a.this.b(a.this.f57848b)) {
                        if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && com.kwad.sdk.core.a.a().a(file.getAbsolutePath()) != null && (a = a.this.a(file)) != null) {
                            a.this.f57851e.a(file);
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
        this.f57852f = false;
        this.f57851e = new com.kwad.sdk.core.download.b.a(context);
        try {
            this.f57848b = aq.c(context);
            this.f57850d = context.getPackageManager();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.f57852f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo a(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageInfo packageArchiveInfo = this.f57850d.getPackageArchiveInfo(file.getPath(), 65);
                    if (this.f57850d.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
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
        if (f57847g == null) {
            synchronized (a.class) {
                if (f57847g == null) {
                    f57847g = new a(context);
                }
            }
        }
        return f57847g;
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
        if (this.f57852f && (file = this.f57848b) != null && file.exists()) {
            Future future = this.a;
            if (future == null || future.isDone()) {
                this.a = this.f57849c.submit(this.f57853h);
            }
        }
    }
}
