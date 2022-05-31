package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes6.dex */
public class o59 implements h59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j59 a;
    public i59 b;

    public o59(j59 j59Var, g59 g59Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j59Var, g59Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j59Var;
        i59 i59Var = new i59();
        this.b = i59Var;
        i59Var.k(g59Var);
    }

    @Override // com.repackage.h59
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) {
            this.b.m(downloadException);
            this.b.r(108);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            this.b.m(downloadException);
            this.b.r(108);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.r(107);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.b.s(j);
            this.b.j(z);
            this.b.r(103);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.r(102);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.r(107);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.b.r(105);
            this.b.q(str);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.r(106);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void onDownloadProgress(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            this.b.n(j);
            this.b.o(j2);
            this.b.p(i);
            this.b.r(104);
            this.a.a(this.b);
        }
    }

    @Override // com.repackage.h59
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.r(101);
            this.b.a().h();
        }
    }
}
