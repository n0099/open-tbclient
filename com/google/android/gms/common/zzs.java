package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.repackage.cn9;
import com.repackage.eo9;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public final class zzs extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<zzs> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final String zza;
    @Nullable
    public final zzi zzb;
    public final boolean zzc;
    public final boolean zzd;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1936194962, "Lcom/google/android/gms/common/zzs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1936194962, "Lcom/google/android/gms/common/zzs;");
                return;
            }
        }
        CREATOR = new eo9();
    }

    public zzs(String str, @Nullable IBinder iBinder, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iBinder, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
        zzj zzjVar = null;
        if (iBinder != null) {
            try {
                IObjectWrapper zzd = zzy.zzg(iBinder).zzd();
                byte[] bArr = zzd == null ? null : (byte[]) ObjectWrapper.unwrap(zzd);
                if (bArr != null) {
                    zzjVar = new zzj(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.zzb = zzjVar;
        this.zzc = z;
        this.zzd = z2;
    }

    public zzs(String str, @Nullable zzi zziVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, zziVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.zza = str;
        this.zzb = zziVar;
        this.zzc = z;
        this.zzd = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
            int a = cn9.a(parcel);
            cn9.k(parcel, 1, this.zza, false);
            zzi zziVar = this.zzb;
            if (zziVar == null) {
                Log.w("GoogleCertificatesQuery", "certificate binder is null");
                zziVar = null;
            }
            cn9.f(parcel, 2, zziVar, false);
            cn9.c(parcel, 3, this.zzc);
            cn9.c(parcel, 4, this.zzd);
            cn9.b(parcel, a);
        }
    }
}
