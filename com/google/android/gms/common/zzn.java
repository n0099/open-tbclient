package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.repackage.bo9;
import com.repackage.cn9;
/* loaded from: classes5.dex */
public final class zzn extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<zzn> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final Context zzd;
    public final boolean zze;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1936195117, "Lcom/google/android/gms/common/zzn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1936195117, "Lcom/google/android/gms/common/zzn;");
                return;
            }
        }
        CREATOR = new bo9();
    }

    public zzn(String str, boolean z, boolean z2, IBinder iBinder, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2), iBinder, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zze = z3;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
            int a = cn9.a(parcel);
            cn9.k(parcel, 1, this.zza, false);
            cn9.c(parcel, 2, this.zzb);
            cn9.c(parcel, 3, this.zzc);
            cn9.f(parcel, 4, ObjectWrapper.wrap(this.zzd), false);
            cn9.c(parcel, 5, this.zze);
            cn9.b(parcel, a);
        }
    }
}
