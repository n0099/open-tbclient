package com.google.android.gms.internal.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public abstract class zzz<E> extends zzak<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int zza;
    public int zzb;

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.zzb < this.zza : invokeV.booleanValue;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zzb > 0 : invokeV.booleanValue;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.zzb : invokeV.intValue;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.zzb - 1 : invokeV.intValue;
    }

    public abstract E zza(int i);

    public zzz(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        zzs.zzb(i2, i, "index");
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (hasNext()) {
                int i = this.zzb;
                this.zzb = i + 1;
                return zza(i);
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (hasPrevious()) {
                int i = this.zzb - 1;
                this.zzb = i;
                return zza(i);
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }
}
