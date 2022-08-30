package com.facebook.soloader;

import android.os.StrictMode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class SoSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_FLAG_ALLOW_IMPLICIT_PROVISION = 1;
    @Deprecated
    public static final int LOAD_FLAG_ALLOW_SOURCE_CHANGE = 2;
    public static final int LOAD_FLAG_MIN_CUSTOM_FLAG = 4;
    public static final int LOAD_RESULT_CORRUPTED_LIB_FILE = 3;
    public static final int LOAD_RESULT_IMPLICITLY_PROVIDED = 2;
    public static final int LOAD_RESULT_LOADED = 1;
    public static final int LOAD_RESULT_NOT_FOUND = 0;
    public static final int PREPARE_FLAG_ALLOW_ASYNC_INIT = 1;
    public static final int PREPARE_FLAG_FORCE_REFRESH = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public SoSource() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void addToLdLibraryPath(Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, collection) == null) {
        }
    }

    @Nullable
    public String[] getLibraryDependencies(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @Nullable
    public String getLibraryPath(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String[] getSoSourceAbis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? SysUtil.getSupportedAbis() : (String[]) invokeV.objValue;
    }

    public abstract int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException;

    public void prepare(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getClass().getName() : (String) invokeV.objValue;
    }

    @Nullable
    public abstract File unpackLibrary(String str) throws IOException;
}
