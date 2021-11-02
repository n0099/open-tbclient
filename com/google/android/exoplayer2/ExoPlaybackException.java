package com.google.android.exoplayer2;

import b.i.b.a.i0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes11.dex */
public final class ExoPlaybackException extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int rendererIndex;
    public final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExoPlaybackException(int i2, String str, Throwable th, int i3) {
        super(str, th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, th, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = i2;
        this.rendererIndex = i3;
    }

    public static ExoPlaybackException createForRenderer(Exception exc, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, exc, i2)) == null) ? new ExoPlaybackException(1, null, exc, i2) : (ExoPlaybackException) invokeLI.objValue;
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iOException)) == null) ? new ExoPlaybackException(0, null, iOException, -1) : (ExoPlaybackException) invokeL.objValue;
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, runtimeException)) == null) ? new ExoPlaybackException(2, null, runtimeException, -1) : (ExoPlaybackException) invokeL.objValue;
    }

    public Exception getRendererException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a.f(this.type == 1);
            return (Exception) getCause();
        }
        return (Exception) invokeV.objValue;
    }

    public IOException getSourceException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a.f(this.type == 0);
            return (IOException) getCause();
        }
        return (IOException) invokeV.objValue;
    }

    public RuntimeException getUnexpectedException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a.f(this.type == 2);
            return (RuntimeException) getCause();
        }
        return (RuntimeException) invokeV.objValue;
    }
}
