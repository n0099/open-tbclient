package com.repackage;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class bi0 implements kj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final oi0 a;

    public bi0(@NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oi0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = oi0Var;
    }

    @Override // com.repackage.kj0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) zx0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        ai0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.repackage.kj0
    public void b(long j, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            AdDownloadAction adDownloadAction = this.a.c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            oi0 oi0Var = this.a;
            oi0Var.c = AdDownloadStatus.DOWNLOADING;
            oi0Var.h = file;
            oi0Var.q.e = j;
            ai0.b().f(adDownloadAction, this.a);
            ei0.a().update(this.a);
            ei0.a().c(this.a);
        }
    }

    @Override // com.repackage.kj0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            ai0.b().f(AdDownloadAction.PAUSE, this.a);
            xi0.f().h(this.a, "notify_type_pause");
            ei0.a().c(this.a);
        }
    }

    @Override // com.repackage.kj0
    public void d(@Nullable wi0 wi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wi0Var) == null) {
            oi0 oi0Var = this.a;
            oi0Var.c = AdDownloadStatus.FAILED;
            oi0Var.i = 0.0f;
            oi0Var.j = 0.0f;
            ai0.b().g(AdDownloadAction.FAIL, this.a, wi0Var);
            xi0.f().h(this.a, "notify_type_stop");
            ei0.a().c(this.a);
        }
    }

    @Override // com.repackage.kj0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                oi0 oi0Var = this.a;
                oi0Var.d = qj0.a(oi0Var.h);
            }
            if (qj0.e(this.a.h)) {
                PackageInfo packageArchiveInfo = dh0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    oi0 oi0Var2 = this.a;
                    oi0Var2.o = packageArchiveInfo.versionName;
                    oi0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                oi0 oi0Var3 = this.a;
                oi0Var3.c = AdDownloadStatus.COMPLETED;
                oi0Var3.i = 1.0f;
                oi0Var3.j = 1.0f;
                ai0.b().f(AdDownloadAction.COMPLETE, this.a);
                pj0.a().b(this.a);
                xi0.f().i(this.a);
                ei0.a().c(this.a);
                oi0 oi0Var4 = this.a;
                qj0.d(oi0Var4.h, oi0Var4.a());
                return;
            }
            oi0 oi0Var5 = this.a;
            oi0Var5.c = AdDownloadStatus.FAILED;
            oi0Var5.i = 0.0f;
            oi0Var5.j = 0.0f;
            ai0.b().f(AdDownloadAction.FAIL, this.a);
            ei0.a().c(this.a);
        }
    }
}
