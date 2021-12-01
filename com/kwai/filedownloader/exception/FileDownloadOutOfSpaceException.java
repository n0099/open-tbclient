package com.kwai.filedownloader.exception;

import android.annotation.TargetApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.e.f;
import java.io.IOException;
/* loaded from: classes2.dex */
public class FileDownloadOutOfSpaceException extends IOException {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long breakpointBytes;
    public long freeSpaceBytes;
    public long requiredSpaceBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDownloadOutOfSpaceException(long j2, long j3, long j4) {
        super(f.a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(j2, j3, j4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(9)
    public FileDownloadOutOfSpaceException(long j2, long j3, long j4, Throwable th) {
        super(f.a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)), th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), th};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(j2, j3, j4);
    }

    private void init(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            this.freeSpaceBytes = j2;
            this.requiredSpaceBytes = j3;
            this.breakpointBytes = j4;
        }
    }

    public long getBreakpointBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.breakpointBytes : invokeV.longValue;
    }

    public long getFreeSpaceBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.freeSpaceBytes : invokeV.longValue;
    }

    public long getRequiredSpaceBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.requiredSpaceBytes : invokeV.longValue;
    }
}
