package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import javax.annotation.Nullable;
@ShowFirstParty
@KeepForSdk
/* loaded from: classes7.dex */
public class GoogleSignatureVerifier {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static GoogleSignatureVerifier zza;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context zzb;
    public volatile String zzc;

    public GoogleSignatureVerifier(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzb = context.getApplicationContext();
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@NonNull PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, packageInfo)) == null) {
            if (packageInfo == null) {
                return false;
            }
            if (zzb(packageInfo, false)) {
                return true;
            }
            if (zzb(packageInfo, true)) {
                if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                    return true;
                }
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        InterceptResult invokeI;
        zzw zzc;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            String[] packagesForUid = this.zzb.getPackageManager().getPackagesForUid(i);
            if (packagesForUid != null && (length = packagesForUid.length) != 0) {
                zzc = null;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        zzc = zzc(packagesForUid[i2], false, false);
                        if (zzc.zza) {
                            break;
                        }
                        i2++;
                    } else {
                        Preconditions.checkNotNull(zzc);
                        break;
                    }
                }
            } else {
                zzc = zzw.zzc("no pkgs");
            }
            zzc.zze();
            return zzc.zza;
        }
        return invokeI.booleanValue;
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Preconditions.checkNotNull(context);
            synchronized (GoogleSignatureVerifier.class) {
                if (zza == null) {
                    zzm.zzd(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            }
            return zza;
        }
        return (GoogleSignatureVerifier) invokeL.objValue;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            zzw zzc = zzc(str, false, false);
            zzc.zze();
            return zzc.zza;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static final zzi zza(PackageInfo packageInfo, zzi... zziVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, packageInfo, zziVarArr)) == null) {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return null;
            }
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzj zzjVar = new zzj(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zziVarArr.length; i++) {
                if (zziVarArr[i].equals(zzjVar)) {
                    return zziVarArr[i];
                }
            }
            return null;
        }
        return (zzi) invokeLL.objValue;
    }

    public static final boolean zzb(@NonNull PackageInfo packageInfo, boolean z) {
        InterceptResult invokeLZ;
        zzi zza2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, packageInfo, z)) == null) {
            if (packageInfo != null && packageInfo.signatures != null) {
                if (z) {
                    zza2 = zza(packageInfo, zzl.zza);
                } else {
                    zza2 = zza(packageInfo, zzl.zza[0]);
                }
                if (zza2 != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final zzw zzc(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str2;
        zzw zzc;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (str == null) {
                return zzw.zzc("null pkg");
            }
            if (!str.equals(this.zzc)) {
                if (zzm.zze()) {
                    zzc = zzm.zzb(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb), false, false);
                } else {
                    try {
                        PackageInfo packageInfo = this.zzb.getPackageManager().getPackageInfo(str, 64);
                        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
                        if (packageInfo == null) {
                            zzc = zzw.zzc("null pkg");
                        } else {
                            Signature[] signatureArr = packageInfo.signatures;
                            if (signatureArr != null && signatureArr.length == 1) {
                                zzj zzjVar = new zzj(packageInfo.signatures[0].toByteArray());
                                String str3 = packageInfo.packageName;
                                zzw zza2 = zzm.zza(str3, zzjVar, honorsDebugCertificates, false);
                                if (zza2.zza && (applicationInfo = packageInfo.applicationInfo) != null && (applicationInfo.flags & 2) != 0 && zzm.zza(str3, zzjVar, false, true).zza) {
                                    zzc = zzw.zzc("debuggable release cert app rejected");
                                } else {
                                    zzc = zza2;
                                }
                            } else {
                                zzc = zzw.zzc("single cert required");
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        if (str.length() != 0) {
                            str2 = "no pkg ".concat(str);
                        } else {
                            str2 = new String("no pkg ");
                        }
                        return zzw.zzd(str2, e);
                    }
                }
                if (zzc.zza) {
                    this.zzc = str;
                }
                return zzc;
            }
            return zzw.zzb();
        }
        return (zzw) invokeCommon.objValue;
    }
}
