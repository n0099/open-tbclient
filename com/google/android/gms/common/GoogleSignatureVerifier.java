package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import javax.annotation.Nullable;
@ShowFirstParty
@KeepForSdk
/* loaded from: classes8.dex */
public class GoogleSignatureVerifier {
    @Nullable
    public static GoogleSignatureVerifier zza;
    public final Context zzb;
    public volatile String zzc;

    public GoogleSignatureVerifier(@NonNull Context context) {
        this.zzb = context.getApplicationContext();
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzm.zzd(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@NonNull PackageInfo packageInfo) {
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

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(@NonNull String str) {
        zzw zzc = zzc(str, false, false);
        zzc.zze();
        return zzc.zza;
    }

    @Nullable
    public static final zzi zza(PackageInfo packageInfo, zzi... zziVarArr) {
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

    public static final boolean zzb(@NonNull PackageInfo packageInfo, boolean z) {
        zzi zza2;
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

    @SuppressLint({"PackageManagerGetSignatures"})
    private final zzw zzc(String str, boolean z, boolean z2) {
        String str2;
        zzw zzc;
        ApplicationInfo applicationInfo;
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

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        zzw zzc;
        int length;
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
}
