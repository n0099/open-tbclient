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
/* loaded from: classes6.dex */
public class fi0 implements nj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final si0 a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi0 a;

        public a(fi0 fi0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tj0.c(this.a.a.h);
            }
        }
    }

    public fi0(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {si0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = si0Var;
    }

    @Override // com.repackage.nj0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) ay0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        ei0.b().e(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.repackage.nj0
    public void b(long j, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            AdDownloadAction adDownloadAction = this.a.c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            si0 si0Var = this.a;
            si0Var.c = AdDownloadStatus.DOWNLOADING;
            si0Var.h = file;
            si0Var.q.e = j;
            ei0.b().e(adDownloadAction, this.a);
            ii0.a().update(this.a);
            ii0.a().c(this.a);
        }
    }

    @Override // com.repackage.nj0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            ei0.b().e(AdDownloadAction.PAUSE, this.a);
            aj0.f().h(this.a, "notify_type_pause");
            ii0.a().c(this.a);
        }
    }

    @Override // com.repackage.nj0
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            si0 si0Var = this.a;
            si0Var.c = AdDownloadStatus.FAILED;
            si0Var.i = 0.0f;
            si0Var.j = 0.0f;
            ei0.b().e(AdDownloadAction.FAIL, this.a);
            aj0.f().h(this.a, "notify_type_stop");
            ii0.a().c(this.a);
        }
    }

    @Override // com.repackage.nj0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                si0 si0Var = this.a;
                si0Var.d = tj0.a(si0Var.h);
            }
            if (tj0.e(this.a.h)) {
                PackageInfo packageArchiveInfo = hh0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    si0 si0Var2 = this.a;
                    si0Var2.o = packageArchiveInfo.versionName;
                    si0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                si0 si0Var3 = this.a;
                si0Var3.c = AdDownloadStatus.COMPLETED;
                si0Var3.i = 1.0f;
                si0Var3.j = 1.0f;
                ei0.b().e(AdDownloadAction.COMPLETE, this.a);
                sj0.a().b(this.a);
                aj0.f().i(this.a);
                ii0.a().c(this.a);
                gz0.a(new a(this), "ad_auto_install", 3, 1000L);
                return;
            }
            si0 si0Var4 = this.a;
            si0Var4.c = AdDownloadStatus.FAILED;
            si0Var4.i = 0.0f;
            si0Var4.j = 0.0f;
            ei0.b().e(AdDownloadAction.FAIL, this.a);
            ii0.a().c(this.a);
        }
    }
}
