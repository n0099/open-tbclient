package com.kwad.sdk.core.diskcache;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.ksad.download.f;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.a;
import com.kwad.sdk.utils.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class ApkInstallCheckManager {

    /* renamed from: a  reason: collision with root package name */
    public Future f33851a;

    /* renamed from: b  reason: collision with root package name */
    public File f33852b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f33853c;

    /* renamed from: d  reason: collision with root package name */
    public PackageManager f33854d;

    /* renamed from: e  reason: collision with root package name */
    public final f f33855e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f33856f;

    /* renamed from: g  reason: collision with root package name */
    public final Callable<PackageInfo> f33857g;

    /* loaded from: classes6.dex */
    public enum Holder {
        INSTANCE;
        
        public ApkInstallCheckManager mInstance = new ApkInstallCheckManager();

        Holder() {
        }

        public ApkInstallCheckManager getInstance() {
            return this.mInstance;
        }
    }

    public ApkInstallCheckManager() {
        this.f33853c = Executors.newSingleThreadExecutor();
        this.f33856f = false;
        this.f33857g = new Callable<PackageInfo>() { // from class: com.kwad.sdk.core.diskcache.ApkInstallCheckManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public PackageInfo call() {
                PackageInfo a2;
                synchronized (ApkInstallCheckManager.class) {
                    if (ApkInstallCheckManager.this.f33852b != null && ApkInstallCheckManager.this.f33852b.exists()) {
                        for (File file : ApkInstallCheckManager.this.b(ApkInstallCheckManager.this.f33852b)) {
                            if (file.getName().endsWith(".apk") && a.a().a(file.getAbsolutePath()) != null && (a2 = ApkInstallCheckManager.this.a(file)) != null) {
                                ApkInstallCheckManager.this.f33855e.a(file);
                                return a2;
                            }
                        }
                        return null;
                    }
                    return null;
                }
            }
        };
        this.f33855e = new com.kwad.sdk.core.download.c.a();
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        try {
            this.f33852b = ad.c(KsAdSDKImpl.get().getContext());
            this.f33854d = KsAdSDKImpl.get().getContext().getPackageManager();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.f33856f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo a(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageInfo packageArchiveInfo = this.f33854d.getPackageArchiveInfo(file.getPath(), 65);
                    if (this.f33854d.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
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

    public static ApkInstallCheckManager a() {
        return Holder.INSTANCE.getInstance();
    }

    private void a(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkInstallCheckManager.2
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

    public void b() {
        File file;
        if (this.f33856f && (file = this.f33852b) != null && file.exists()) {
            Future future = this.f33851a;
            if (future == null || future.isDone()) {
                this.f33851a = this.f33853c.submit(this.f33857g);
            }
        }
    }
}
