package com.google.android.gms.internal.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
/* loaded from: classes7.dex */
public abstract class zzj implements Iterator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @CheckForNull
    public Object zza;
    public int zzb;

    public zzj() {
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
        this.zzb = 2;
    }

    @CheckForNull
    public abstract Object zza();

    @CheckForNull
    public final Object zzb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.zzb = 3;
            return null;
        }
        return invokeV.objValue;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.zzb;
            if (i != 4) {
                int i2 = i - 1;
                if (i != 0) {
                    if (i2 == 0) {
                        return true;
                    }
                    if (i2 != 2) {
                        this.zzb = 4;
                        this.zza = zza();
                        if (this.zzb != 3) {
                            this.zzb = 1;
                            return true;
                        }
                    }
                    return false;
                }
                throw null;
            }
            throw new IllegalStateException();
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.Iterator
    public final Object next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (hasNext()) {
                this.zzb = 2;
                Object obj = this.zza;
                this.zza = null;
                return obj;
            }
            throw new NoSuchElementException();
        }
        return invokeV.objValue;
    }

    @Override // java.util.Iterator
    public final void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            throw new UnsupportedOperationException();
        }
    }
}
