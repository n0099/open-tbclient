package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class zzm {
    public static /* synthetic */ Interceptable $ic;
    public static final zzk zza;
    public static final zzk zzb;
    public static final zzk zzc;
    public static final zzk zzd;
    public static volatile zzaf zze;
    public static final Object zzf;
    public static Context zzg;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1936195148, "Lcom/google/android/gms/common/zzm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1936195148, "Lcom/google/android/gms/common/zzm;");
                return;
            }
        }
        zza = new zze(zzi.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        zzb = new zzf(zzi.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        zzc = new zzg(zzi.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        zzd = new zzh(zzi.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        zzf = new Object();
    }

    public static zzw zza(String str, zzi zziVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, zziVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                return zzf(str, zziVar, z, z2);
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return (zzw) invokeCommon.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    public static zzw zzb(String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        zzw zzd2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                Preconditions.checkNotNull(zzg);
                try {
                    zzg();
                    try {
                        zzq zze2 = zze.zze(new zzn(str, z, false, ObjectWrapper.wrap(zzg), false));
                        if (zze2.zzb()) {
                            zzd2 = zzw.zzb();
                        } else {
                            String zza2 = zze2.zza();
                            if (zza2 == null) {
                                zza2 = "error checking package certificate";
                            }
                            zzd2 = zze2.zzc() == 4 ? zzw.zzd(zza2, new PackageManager.NameNotFoundException()) : zzw.zzc(zza2);
                        }
                    } catch (RemoteException e) {
                        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                        zzd2 = zzw.zzd("module call", e);
                    }
                } catch (DynamiteModule.LoadingException e2) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                    String valueOf = String.valueOf(e2.getMessage());
                    zzd2 = zzw.zzd(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
                }
                return zzd2;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return (zzw) invokeCommon.objValue;
    }

    public static /* synthetic */ String zzc(boolean z, String str, zzi zziVar) throws Exception {
        String str2 = true != (!z && zzf(str, zziVar, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-1");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza2.digest(zziVar.zzf())), Boolean.valueOf(z), "12451000.false");
    }

    public static synchronized void zzd(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            synchronized (zzm.class) {
                if (zzg != null) {
                    Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                } else if (context != null) {
                    zzg = context.getApplicationContext();
                }
            }
        }
    }

    public static boolean zze() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                try {
                    zzg();
                    return zze.zzg();
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            } catch (RemoteException | DynamiteModule.LoadingException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static zzw zzf(final String str, final zzi zziVar, final boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, zziVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            try {
                zzg();
                Preconditions.checkNotNull(zzg);
                try {
                    return zze.zzf(new zzs(str, zziVar, z, z2), ObjectWrapper.wrap(zzg.getPackageManager())) ? zzw.zzb() : new zzv(new Callable() { // from class: com.google.android.gms.common.zzd
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? zzm.zzc(z, str, zziVar) : invokeV.objValue;
                        }
                    }, null);
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    return zzw.zzd("module call", e);
                }
            } catch (DynamiteModule.LoadingException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                String valueOf = String.valueOf(e2.getMessage());
                return zzw.zzd(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
            }
        }
        return (zzw) invokeCommon.objValue;
    }

    public static void zzg() throws DynamiteModule.LoadingException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && zze == null) {
            Preconditions.checkNotNull(zzg);
            synchronized (zzf) {
                if (zze == null) {
                    zze = zzae.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }
}
