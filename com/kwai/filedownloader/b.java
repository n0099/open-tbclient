package com.kwai.filedownloader;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.s;
/* loaded from: classes5.dex */
public final class b implements s.a, s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 1000;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = 0;
            this.a = 0L;
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.d = SystemClock.uptimeMillis();
            this.c = j;
        }
    }

    @Override // com.kwai.filedownloader.s.a
    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.d <= 0) {
            return;
        }
        long j2 = j - this.c;
        this.a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.e = (int) j2;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.f <= 0) {
            return;
        }
        boolean z = true;
        if (this.a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.a;
            if (uptimeMillis >= this.f || (this.e == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.b) / uptimeMillis);
                this.e = i;
                this.e = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.b = j;
            this.a = SystemClock.uptimeMillis();
        }
    }
}
