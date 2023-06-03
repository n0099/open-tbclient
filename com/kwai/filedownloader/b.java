package com.kwai.filedownloader;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.s;
/* loaded from: classes10.dex */
public final class b implements s.a, s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long asm;
    public long asn;
    public long aso;
    public int asp;
    public int asq;
    public long mStartTime;

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
        this.asq = 1000;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void U(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.asq <= 0) {
            return;
        }
        boolean z = true;
        if (this.asm != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.asm;
            if (uptimeMillis >= this.asq || (this.asp == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.asn) / uptimeMillis);
                this.asp = i;
                this.asp = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.asn = j;
            this.asm = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public final void end(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.aso;
        this.asm = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.asp = (int) j2;
    }

    @Override // com.kwai.filedownloader.s.a
    public final int getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.asp : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.asp = 0;
            this.asm = 0L;
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public final void start(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.mStartTime = SystemClock.uptimeMillis();
            this.aso = j;
        }
    }
}
