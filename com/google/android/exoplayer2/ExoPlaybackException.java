package com.google.android.exoplayer2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes7.dex */
public final class ExoPlaybackException extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int rendererIndex;
    public final int type;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Type {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExoPlaybackException(int i, String str, Throwable th, int i2) {
        super(str, th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, th, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = i;
        this.rendererIndex = i2;
    }

    public static ExoPlaybackException createForRenderer(Exception exc, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, exc, i)) == null) {
            return new ExoPlaybackException(1, null, exc, i);
        }
        return (ExoPlaybackException) invokeLI.objValue;
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iOException)) == null) {
            return new ExoPlaybackException(0, null, iOException, -1);
        }
        return (ExoPlaybackException) invokeL.objValue;
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, runtimeException)) == null) {
            return new ExoPlaybackException(2, null, runtimeException, -1);
        }
        return (ExoPlaybackException) invokeL.objValue;
    }

    public Exception getRendererException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean z = true;
            if (this.type != 1) {
                z = false;
            }
            Assertions.checkState(z);
            return (Exception) getCause();
        }
        return (Exception) invokeV.objValue;
    }

    public IOException getSourceException() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.type == 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            return (IOException) getCause();
        }
        return (IOException) invokeV.objValue;
    }

    public RuntimeException getUnexpectedException() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.type == 2) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            return (RuntimeException) getCause();
        }
        return (RuntimeException) invokeV.objValue;
    }
}
