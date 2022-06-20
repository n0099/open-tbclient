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
public class wh0 implements cj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ii0 a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh0 a;

        public a(wh0 wh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gj0.c(this.a.a.h);
            }
        }
    }

    public wh0(@NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ii0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ii0Var;
    }

    @Override // com.repackage.cj0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) nx0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        vh0.b().e(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.repackage.cj0
    public void b(long j, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            AdDownloadAction adDownloadAction = this.a.c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            ii0 ii0Var = this.a;
            ii0Var.c = AdDownloadStatus.DOWNLOADING;
            ii0Var.h = file;
            ii0Var.q.d = j;
            vh0.b().e(adDownloadAction, this.a);
            yh0.a().update(this.a);
            yh0.a().c(this.a);
        }
    }

    @Override // com.repackage.cj0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            vh0.b().e(AdDownloadAction.PAUSE, this.a);
            pi0.f().h(this.a, "notify_type_pause");
            yh0.a().c(this.a);
        }
    }

    @Override // com.repackage.cj0
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ii0 ii0Var = this.a;
            ii0Var.c = AdDownloadStatus.NONE;
            ii0Var.i = 0.0f;
            ii0Var.j = 0.0f;
            vh0.b().e(AdDownloadAction.FAIL, this.a);
            pi0.f().h(this.a, "notify_type_stop");
            yh0.a().c(this.a);
        }
    }

    @Override // com.repackage.cj0
    public void onSuccess(int i) {
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                ii0 ii0Var = this.a;
                ii0Var.d = gj0.a(ii0Var.h);
            }
            if (this.a.h != null && (packageArchiveInfo = bh0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128)) != null) {
                ii0 ii0Var2 = this.a;
                ii0Var2.o = packageArchiveInfo.versionName;
                ii0Var2.n = packageArchiveInfo.versionCode;
            }
            AdAppStateManager.instance().register(this.a);
            ii0 ii0Var3 = this.a;
            ii0Var3.c = AdDownloadStatus.COMPLETED;
            ii0Var3.i = 1.0f;
            ii0Var3.j = 1.0f;
            vh0.b().e(AdDownloadAction.COMPLETE, this.a);
            fj0.a().b(this.a);
            pi0.f().i(this.a);
            yh0.a().c(this.a);
            ty0.a(new a(this), "ad_auto_install", 3, 1000L);
        }
    }
}
