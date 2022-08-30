package com.facebook.soloader;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class NativeLibrary {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.facebook.soloader.NativeLibrary";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mLibrariesLoaded;
    @Nullable
    public List<String> mLibraryNames;
    @Nullable
    public volatile UnsatisfiedLinkError mLinkError;
    public Boolean mLoadLibraries;
    public final Object mLock;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1860854360, "Lcom/facebook/soloader/NativeLibrary;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1860854360, "Lcom/facebook/soloader/NativeLibrary;");
        }
    }

    public NativeLibrary(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mLoadLibraries = Boolean.TRUE;
        this.mLibrariesLoaded = false;
        this.mLinkError = null;
        this.mLibraryNames = list;
    }

    public void ensureLoaded() throws UnsatisfiedLinkError {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !loadLibraries()) {
            throw this.mLinkError;
        }
    }

    @Nullable
    public UnsatisfiedLinkError getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLinkError : (UnsatisfiedLinkError) invokeV.objValue;
    }

    public void initialNativeCheck() throws UnsatisfiedLinkError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Nullable
    public boolean loadLibraries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mLoadLibraries.booleanValue()) {
                    return this.mLibrariesLoaded;
                }
                try {
                    if (this.mLibraryNames != null) {
                        for (String str : this.mLibraryNames) {
                            SoLoader.loadLibrary(str);
                        }
                    }
                    initialNativeCheck();
                    this.mLibrariesLoaded = true;
                    this.mLibraryNames = null;
                } catch (UnsatisfiedLinkError e) {
                    Log.e(TAG, "Failed to load native lib (initial check): ", e);
                    this.mLinkError = e;
                    this.mLibrariesLoaded = false;
                } catch (Throwable th) {
                    Log.e(TAG, "Failed to load native lib (other error): ", th);
                    this.mLinkError = new UnsatisfiedLinkError("Failed loading libraries");
                    this.mLinkError.initCause(th);
                    this.mLibrariesLoaded = false;
                }
                this.mLoadLibraries = Boolean.FALSE;
                return this.mLibrariesLoaded;
            }
        }
        return invokeV.booleanValue;
    }
}
