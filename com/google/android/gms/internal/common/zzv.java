package com.google.android.gms.internal.common;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class zzv implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ CharSequence zza;
    public final /* synthetic */ zzx zzb;

    public zzv(zzx zzxVar, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zzxVar, charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzb = zzxVar;
        this.zza = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        InterceptResult invokeV;
        Iterator zzh;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zzh = this.zzb.zzh(this.zza);
            return zzh;
        }
        return (Iterator) invokeV.objValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator it = iterator();
            try {
                if (it.hasNext()) {
                    sb.append(zzq.zza(it.next(), StringUtil.ARRAY_ELEMENT_SEPARATOR));
                    while (it.hasNext()) {
                        sb.append((CharSequence) StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        sb.append(zzq.zza(it.next(), StringUtil.ARRAY_ELEMENT_SEPARATOR));
                    }
                }
                sb.append(']');
                return sb.toString();
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeV.objValue;
    }
}
