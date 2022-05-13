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
public class fj0 implements lk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final rj0 a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fj0 a;

        public a(fj0 fj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fj0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pk0.c(this.a.a.h);
            }
        }
    }

    public fj0(@NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rj0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rj0Var;
    }

    @Override // com.repackage.lk0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) wy0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        ej0.b().e(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.repackage.lk0
    public void b(long j, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            AdDownloadAction adDownloadAction = this.a.c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            rj0 rj0Var = this.a;
            rj0Var.c = AdDownloadStatus.DOWNLOADING;
            rj0Var.h = file;
            rj0Var.q.d = j;
            ej0.b().e(adDownloadAction, this.a);
            hj0.a().update(this.a);
            hj0.a().c(this.a);
        }
    }

    @Override // com.repackage.lk0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            ej0.b().e(AdDownloadAction.PAUSE, this.a);
            yj0.f().h(this.a, "notify_type_pause");
            hj0.a().c(this.a);
        }
    }

    @Override // com.repackage.lk0
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            rj0 rj0Var = this.a;
            rj0Var.c = AdDownloadStatus.NONE;
            rj0Var.i = 0.0f;
            rj0Var.j = 0.0f;
            ej0.b().e(AdDownloadAction.FAIL, this.a);
            yj0.f().h(this.a, "notify_type_stop");
            hj0.a().c(this.a);
        }
    }

    @Override // com.repackage.lk0
    public void onSuccess(int i) {
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                rj0 rj0Var = this.a;
                rj0Var.d = pk0.a(rj0Var.h);
            }
            if (this.a.h != null && (packageArchiveInfo = ki0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128)) != null) {
                rj0 rj0Var2 = this.a;
                rj0Var2.o = packageArchiveInfo.versionName;
                rj0Var2.n = packageArchiveInfo.versionCode;
            }
            AdAppStateManager.instance().register(this.a);
            rj0 rj0Var3 = this.a;
            rj0Var3.c = AdDownloadStatus.COMPLETED;
            rj0Var3.i = 1.0f;
            rj0Var3.j = 1.0f;
            ej0.b().e(AdDownloadAction.COMPLETE, this.a);
            ok0.a().b(this.a);
            yj0.f().i(this.a);
            hj0.a().c(this.a);
            c01.a(new a(this), "ad_auto_install", 3, 1000L);
        }
    }
}
