package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class zzn {
    public static /* synthetic */ Interceptable $ic;
    public static final Uri zza;
    public transient /* synthetic */ FieldHolder $fh;
    public final String zzb;
    public final String zzc;
    public final ComponentName zzd;
    public final int zze;
    public final boolean zzf;

    public final int zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.zze : invokeV.intValue;
    }

    public final ComponentName zzb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.zzd : (ComponentName) invokeV.objValue;
    }

    public final String zzd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.zzc : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1907026279, "Lcom/google/android/gms/common/internal/zzn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1907026279, "Lcom/google/android/gms/common/internal/zzn;");
                return;
            }
        }
        zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Objects.hashCode(this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Boolean.valueOf(this.zzf));
        }
        return invokeV.intValue;
    }

    public zzn(ComponentName componentName, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {componentName, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zzb = null;
        this.zzc = null;
        Preconditions.checkNotNull(componentName);
        this.zzd = componentName;
        this.zze = i;
        this.zzf = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zzn(String str, int i, boolean z) {
        this(str, "com.google.android.gms", i, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public zzn(String str, String str2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        Preconditions.checkNotEmpty(str2);
        this.zzc = str2;
        this.zzd = null;
        this.zze = i;
        this.zzf = z;
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zzn)) {
                return false;
            }
            zzn zznVar = (zzn) obj;
            if (Objects.equal(this.zzb, zznVar.zzb) && Objects.equal(this.zzc, zznVar.zzc) && Objects.equal(this.zzd, zznVar.zzd) && this.zze == zznVar.zze && this.zzf == zznVar.zzf) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.zzb;
            if (str == null) {
                Preconditions.checkNotNull(this.zzd);
                return this.zzd.flattenToString();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final Intent zzc(Context context) {
        InterceptResult invokeL;
        Bundle bundle;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (this.zzb != null) {
                Intent intent = null;
                if (this.zzf) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("serviceActionBundleKey", this.zzb);
                    try {
                        bundle = context.getContentResolver().call(zza, "serviceIntentCall", (String) null, bundle2);
                    } catch (IllegalArgumentException e) {
                        Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                        bundle = null;
                    }
                    if (bundle != null) {
                        intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                    }
                    if (intent == null) {
                        String valueOf = String.valueOf(this.zzb);
                        if (valueOf.length() != 0) {
                            str = "Dynamic lookup for intent failed for action: ".concat(valueOf);
                        } else {
                            str = new String("Dynamic lookup for intent failed for action: ");
                        }
                        Log.w("ConnectionStatusConfig", str);
                    }
                }
                if (intent == null) {
                    return new Intent(this.zzb).setPackage(this.zzc);
                }
                return intent;
            }
            return new Intent().setComponent(this.zzd);
        }
        return (Intent) invokeL.objValue;
    }
}
