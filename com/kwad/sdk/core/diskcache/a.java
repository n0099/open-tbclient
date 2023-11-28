package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.d;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class a {
    public static PackageInfo a(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 65);
                    if (packageManager.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e) {
                c.printStackTrace(e);
            }
        }
        return null;
    }

    public static void aT(final Context context) {
        g.schedule(new ay() { // from class: com.kwad.sdk.core.diskcache.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                d xC;
                synchronized (a.class) {
                    File cL = aw.cL(context);
                    if (!cL.exists()) {
                        return;
                    }
                    for (File file : a.n(cL)) {
                        if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && com.kwad.sdk.core.a.Ai().cF(file.getAbsolutePath()) != null && a.a(context, file) != null && (xC = com.kwad.sdk.c.xA().xC()) != null) {
                            xC.g(file);
                        }
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    public static List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        t(arrayList);
        return arrayList;
    }

    public static void t(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
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
