package com.facebook.common.references;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class OOMSoftReference<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SoftReference<T> softRef1;
    public SoftReference<T> softRef2;
    public SoftReference<T> softRef3;

    public OOMSoftReference() {
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
        this.softRef1 = null;
        this.softRef2 = null;
        this.softRef3 = null;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SoftReference<T> softReference = this.softRef1;
            if (softReference != null) {
                softReference.clear();
                this.softRef1 = null;
            }
            SoftReference<T> softReference2 = this.softRef2;
            if (softReference2 != null) {
                softReference2.clear();
                this.softRef2 = null;
            }
            SoftReference<T> softReference3 = this.softRef3;
            if (softReference3 != null) {
                softReference3.clear();
                this.softRef3 = null;
            }
        }
    }

    @Nullable
    public T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SoftReference<T> softReference = this.softRef1;
            if (softReference == null) {
                return null;
            }
            return softReference.get();
        }
        return (T) invokeV.objValue;
    }

    public void set(@Nonnull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            this.softRef1 = new SoftReference<>(t);
            this.softRef2 = new SoftReference<>(t);
            this.softRef3 = new SoftReference<>(t);
        }
    }
}
