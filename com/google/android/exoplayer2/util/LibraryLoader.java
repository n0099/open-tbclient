package com.google.android.exoplayer2.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class LibraryLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAvailable;
    public boolean loadAttempted;
    public String[] nativeLibraries;

    public LibraryLoader(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nativeLibraries = strArr;
    }

    public synchronized void setLibraries(String... strArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr) == null) {
            synchronized (this) {
                if (!this.loadAttempted) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkState(z, "Cannot set libraries after loading");
                this.nativeLibraries = strArr;
            }
        }
    }

    public synchronized boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.loadAttempted) {
                    return this.isAvailable;
                }
                this.loadAttempted = true;
                try {
                    for (String str : this.nativeLibraries) {
                        System.loadLibrary(str);
                    }
                    this.isAvailable = true;
                } catch (UnsatisfiedLinkError unused) {
                }
                return this.isAvailable;
            }
        }
        return invokeV.booleanValue;
    }
}
