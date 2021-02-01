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
/* loaded from: classes3.dex */
public class ApkInstallCheckManager {

    /* renamed from: a  reason: collision with root package name */
    private Future f9062a;

    /* renamed from: b  reason: collision with root package name */
    private File f9063b;
    private final ExecutorService c;
    private PackageManager d;
    private final f e;
    private volatile boolean f;
    private final Callable<PackageInfo> g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Holder {
        INSTANCE;
        
        private ApkInstallCheckManager mInstance = new ApkInstallCheckManager();

        Holder() {
        }

        ApkInstallCheckManager getInstance() {
            return this.mInstance;
        }
    }

    private ApkInstallCheckManager() {
        this.c = Executors.newSingleThreadExecutor();
        this.f = false;
        this.g = new Callable<PackageInfo>() { // from class: com.kwad.sdk.core.diskcache.ApkInstallCheckManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public PackageInfo call() {
                PackageInfo a2;
                synchronized (ApkInstallCheckManager.class) {
                    if (ApkInstallCheckManager.this.f9063b != null && ApkInstallCheckManager.this.f9063b.exists()) {
                        for (File file : ApkInstallCheckManager.this.b(ApkInstallCheckManager.this.f9063b)) {
                            if (file.getName().endsWith(".apk") && a.a().a(file.getAbsolutePath()) != null && (a2 = ApkInstallCheckManager.this.a(file)) != null) {
                                ApkInstallCheckManager.this.e.a(file);
                                return a2;
                            }
                        }
                        return null;
                    }
                }
                return null;
            }
        };
        this.e = new com.kwad.sdk.core.download.c.a();
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        try {
            this.f9063b = ad.c(KsAdSDKImpl.get().getContext());
            this.d = KsAdSDKImpl.get().getContext().getPackageManager();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo a(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if ((file.isDirectory() ? false : true) && file.exists()) {
                PackageInfo packageArchiveInfo = this.d.getPackageArchiveInfo(file.getPath(), 65);
                try {
                    if (this.d.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                } catch (Exception e) {
                }
                return packageArchiveInfo;
            }
            return null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
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
        if (listFiles != null) {
            arrayList.addAll(Arrays.asList(listFiles));
            a(arrayList);
        }
        return arrayList;
    }

    public void b() {
        if (this.f && this.f9063b != null && this.f9063b.exists()) {
            if (this.f9062a == null || this.f9062a.isDone()) {
                this.f9062a = this.c.submit(this.g);
            }
        }
    }
}
