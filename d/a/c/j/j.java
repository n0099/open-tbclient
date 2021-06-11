package d.a.c.j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.titan.sdk.internal.util.Files;
import com.baidu.titan.sdk.loader.LoaderHead;
import com.baidu.titan.sdk.loader.LoaderManager;
import com.baidu.titan.sdk.pm.PatchInstallInfo;
import com.baidu.titan.sdk.pm.PatchManager;
import com.baidu.titan.sdk.pm.PatchMetaInfo;
import com.baidu.titan.sdk.pm.TitanPaths;
import java.io.File;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42877a = d.a.c.j.a.f42853a;

    /* loaded from: classes.dex */
    public static class a implements PatchManager.PatchInstallObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f42878a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PackageInfo f42879b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f42880c;

        public a(f fVar, PackageInfo packageInfo, boolean z) {
            this.f42878a = fVar;
            this.f42879b = packageInfo;
            this.f42880c = z;
        }

        @Override // com.baidu.titan.sdk.pm.PatchManager.PatchInstallObserver
        public void onPatchInstalled(int i2, Bundle bundle) {
            LoaderHead createFromJson;
            PatchMetaInfo createFromPatch;
            int i3 = (i2 == 0 || i2 == 1) ? 0 : -1;
            String str = "install-resut:" + i2;
            f fVar = this.f42878a;
            if (fVar != null) {
                fVar.a(this.f42879b.packageName, i3, str);
            }
            Log.d(TitanDownloadService.TAG, "patch install result code = " + i3);
            if (i3 == 0) {
                j.c(this.f42879b);
            }
            if (this.f42880c) {
                return;
            }
            int loadState = LoaderManager.getInstance().getLoadState();
            if (loadState == -4 || loadState == -1) {
                File headFile = TitanPaths.getHeadFile();
                if (!headFile.exists() || (createFromJson = LoaderHead.createFromJson(Files.getFileStringContent(headFile))) == null || (createFromPatch = PatchMetaInfo.createFromPatch(new PatchInstallInfo(TitanPaths.getPatchDir(createFromJson.patchHash)).getPatchFile())) == null || createFromPatch.loadPolicy != 1) {
                    return;
                }
                LoaderManager.getInstance().loadInTime();
            }
        }
    }

    public static void b(Context context, f fVar, PackageInfo packageInfo, boolean z) {
        if (f42877a) {
            Log.d(TitanDownloadService.TAG, "install file: " + packageInfo.filePath);
        }
        PatchManager.getInstance().installPatch(Uri.fromFile(new File(packageInfo.filePath)), null, new a(fVar, packageInfo, z));
    }

    public static void c(PackageInfo packageInfo) {
        h d2 = h.d();
        if (packageInfo != null) {
            long j = packageInfo.updateVersion;
            if (j != 0) {
                d2.j(j);
                Context appContext = AppRuntime.getAppContext();
                if (appContext != null) {
                    try {
                        android.content.pm.PackageInfo packageInfo2 = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                        if (packageInfo2 != null) {
                            d2.h(packageInfo2.versionCode);
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            int i2 = packageInfo.errNo;
            if (i2 == 0 || i2 == -2) {
                d2.i(System.currentTimeMillis());
            }
        }
        d2.k();
    }
}
