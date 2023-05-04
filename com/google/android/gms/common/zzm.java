package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
/* loaded from: classes8.dex */
public final class zzm {
    public static volatile zzaf zze;
    public static Context zzg;
    public static final zzk zza = new zze(zzi.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    public static final zzk zzb = new zzf(zzi.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    public static final zzk zzc = new zzg(zzi.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    public static final zzk zzd = new zzh(zzi.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    public static final Object zzf = new Object();

    public static zzw zza(String str, zzi zziVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzf(str, zziVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    public static zzw zzb(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        zzw zzd2;
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
                        if (zze2.zzc() == 4) {
                            zzd2 = zzw.zzd(zza2, new PackageManager.NameNotFoundException());
                        } else {
                            zzd2 = zzw.zzc(zza2);
                        }
                    }
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    zzd2 = zzw.zzd("module call", e);
                }
            } catch (DynamiteModule.LoadingException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    str2 = "module init: ".concat(valueOf);
                } else {
                    str2 = new String("module init: ");
                }
                zzd2 = zzw.zzd(str2, e2);
            }
            return zzd2;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static /* synthetic */ String zzc(boolean z, String str, zzi zziVar) throws Exception {
        boolean z2;
        String str2;
        if (!z && zzf(str, zziVar, true, false).zza) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (true != z2) {
            str2 = "not allowed";
        } else {
            str2 = "debug cert rejected";
        }
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-1");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza2.digest(zziVar.zzf())), Boolean.valueOf(z), "12451000.false");
    }

    public static synchronized void zzd(Context context) {
        synchronized (zzm.class) {
            if (zzg == null) {
                if (context != null) {
                    zzg = context.getApplicationContext();
                    return;
                }
                return;
            }
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        }
    }

    public static boolean zze() {
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

    public static void zzg() throws DynamiteModule.LoadingException {
        if (zze != null) {
            return;
        }
        Preconditions.checkNotNull(zzg);
        synchronized (zzf) {
            if (zze == null) {
                zze = zzae.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }

    public static zzw zzf(final String str, final zzi zziVar, final boolean z, boolean z2) {
        String str2;
        try {
            zzg();
            Preconditions.checkNotNull(zzg);
            try {
                if (zze.zzf(new zzs(str, zziVar, z, z2), ObjectWrapper.wrap(zzg.getPackageManager()))) {
                    return zzw.zzb();
                }
                return new zzv(new Callable() { // from class: com.google.android.gms.common.zzd
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzm.zzc(z, str, zziVar);
                    }
                }, null);
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzw.zzd("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                str2 = "module init: ".concat(valueOf);
            } else {
                str2 = new String("module init: ");
            }
            return zzw.zzd(str2, e2);
        }
    }
}
