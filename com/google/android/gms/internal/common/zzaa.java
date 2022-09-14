package com.google.android.gms.internal.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class zzaa<E> extends zzab<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] zza;
    public int zzb;
    public boolean zzc;

    public zzaa(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = new Object[4];
        this.zzb = 0;
    }

    private final void zzb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            Object[] objArr = this.zza;
            int length = objArr.length;
            if (length >= i) {
                if (this.zzc) {
                    this.zza = (Object[]) objArr.clone();
                    this.zzc = false;
                    return;
                }
                return;
            }
            int i2 = length + (length >> 1) + 1;
            if (i2 < i) {
                int highestOneBit = Integer.highestOneBit(i - 1);
                i2 = highestOneBit + highestOneBit;
            }
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i2);
            this.zzc = false;
        }
    }

    public final zzaa<E> zza(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e)) == null) {
            if (e != null) {
                zzb(this.zzb + 1);
                Object[] objArr = this.zza;
                int i = this.zzb;
                this.zzb = i + 1;
                objArr[i] = e;
                return this;
            }
            throw null;
        }
        return (zzaa) invokeL.objValue;
    }
}
