package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.repackage.fk9;
import com.repackage.fl9;
import com.repackage.gl9;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public final class zzq extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<zzq> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean zza;
    @Nullable
    public final String zzb;
    public final int zzc;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1936195024, "Lcom/google/android/gms/common/zzq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1936195024, "Lcom/google/android/gms/common/zzq;");
                return;
            }
        }
        CREATOR = new gl9();
    }

    public zzq(boolean z, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zza = z;
        this.zzb = str;
        this.zzc = fl9.a(i) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
            int a = fk9.a(parcel);
            fk9.c(parcel, 1, this.zza);
            fk9.k(parcel, 2, this.zzb, false);
            fk9.g(parcel, 3, this.zzc);
            fk9.b(parcel, a);
        }
    }

    @Nullable
    public final String zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zzb : (String) invokeV.objValue;
    }

    public final boolean zzb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.zza : invokeV.booleanValue;
    }

    public final int zzc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? fl9.a(this.zzc) : invokeV.intValue;
    }
}
