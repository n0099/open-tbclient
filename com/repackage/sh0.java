package com.repackage;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class sh0 implements yi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ei0 a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sh0 a;

        public a(sh0 sh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sh0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cj0.c(this.a.a.h);
            }
        }
    }

    public sh0(@NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ei0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ei0Var;
    }

    @Override // com.repackage.yi0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) jx0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        rh0.b().e(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.repackage.yi0
    public void b(long j, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            AdDownloadAction adDownloadAction = this.a.c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            ei0 ei0Var = this.a;
            ei0Var.c = AdDownloadStatus.DOWNLOADING;
            ei0Var.h = file;
            ei0Var.q.d = j;
            rh0.b().e(adDownloadAction, this.a);
            uh0.a().update(this.a);
            uh0.a().c(this.a);
        }
    }

    @Override // com.repackage.yi0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            rh0.b().e(AdDownloadAction.PAUSE, this.a);
            li0.f().h(this.a, "notify_type_pause");
            uh0.a().c(this.a);
        }
    }

    @Override // com.repackage.yi0
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ei0 ei0Var = this.a;
            ei0Var.c = AdDownloadStatus.NONE;
            ei0Var.i = 0.0f;
            ei0Var.j = 0.0f;
            rh0.b().e(AdDownloadAction.FAIL, this.a);
            li0.f().h(this.a, "notify_type_stop");
            uh0.a().c(this.a);
        }
    }

    @Override // com.repackage.yi0
    public void onSuccess(int i) {
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                ei0 ei0Var = this.a;
                ei0Var.d = cj0.a(ei0Var.h);
            }
            if (this.a.h != null && (packageArchiveInfo = xg0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128)) != null) {
                ei0 ei0Var2 = this.a;
                ei0Var2.o = packageArchiveInfo.versionName;
                ei0Var2.n = packageArchiveInfo.versionCode;
            }
            AdAppStateManager.instance().register(this.a);
            ei0 ei0Var3 = this.a;
            ei0Var3.c = AdDownloadStatus.COMPLETED;
            ei0Var3.i = 1.0f;
            ei0Var3.j = 1.0f;
            rh0.b().e(AdDownloadAction.COMPLETE, this.a);
            bj0.a().b(this.a);
            li0.f().i(this.a);
            uh0.a().c(this.a);
            py0.a(new a(this), "ad_auto_install", 3, 1000L);
        }
    }
}
