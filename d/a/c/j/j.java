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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44789a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements PatchManager.PatchInstallObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f44790a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PackageInfo f44791b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f44792c;

        public a(f fVar, PackageInfo packageInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, packageInfo, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44790a = fVar;
            this.f44791b = packageInfo;
            this.f44792c = z;
        }

        @Override // com.baidu.titan.sdk.pm.PatchManager.PatchInstallObserver
        public void onPatchInstalled(int i2, Bundle bundle) {
            LoaderHead createFromJson;
            PatchMetaInfo createFromPatch;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bundle) == null) {
                int i3 = (i2 == 0 || i2 == 1) ? 0 : -1;
                String str = "install-resut:" + i2;
                f fVar = this.f44790a;
                if (fVar != null) {
                    fVar.a(this.f44791b.packageName, i3, str);
                }
                Log.d(TitanDownloadService.TAG, "patch install result code = " + i3);
                if (i3 == 0) {
                    j.c(this.f44791b);
                }
                if (this.f44792c) {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1754036473, "Ld/a/c/j/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1754036473, "Ld/a/c/j/j;");
                return;
            }
        }
        f44789a = d.a.c.j.a.f44765a;
    }

    public static void b(Context context, f fVar, PackageInfo packageInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, fVar, packageInfo, Boolean.valueOf(z)}) == null) {
            if (f44789a) {
                Log.d(TitanDownloadService.TAG, "install file: " + packageInfo.filePath);
            }
            PatchManager.getInstance().installPatch(Uri.fromFile(new File(packageInfo.filePath)), null, new a(fVar, packageInfo, z));
        }
    }

    public static void c(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, packageInfo) == null) {
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
}
