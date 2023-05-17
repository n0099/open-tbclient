package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class ProviderInstaller {
    @NonNull
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    public static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    public static final Object zzb = new Object();
    @GuardedBy("ProviderInstaller.lock")
    public static Method zzc = null;
    @GuardedBy("ProviderInstaller.lock")
    public static Method zzd = null;

    /* loaded from: classes9.dex */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, @Nullable Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(@NonNull Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        String str;
        Context context2;
        String str2;
        Preconditions.checkNotNull(context, "Context must not be null");
        zza.verifyGooglePlayServicesIsAvailable(context, 11925000);
        synchronized (zzb) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                context2 = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
            } catch (DynamiteModule.LoadingException e) {
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    str = "Failed to load providerinstaller module: ".concat(valueOf);
                } else {
                    str = new String("Failed to load providerinstaller module: ");
                }
                Log.w("ProviderInstaller", str);
                context2 = null;
            }
            if (context2 == null) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext != null) {
                    try {
                        if (zzd == null) {
                            zzd = zzb(remoteContext, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, Long.TYPE, Long.TYPE});
                        }
                        zzd.invoke(null, context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2));
                    } catch (Exception e2) {
                        String valueOf2 = String.valueOf(e2.getMessage());
                        if (valueOf2.length() != 0) {
                            str2 = "Failed to report request stats: ".concat(valueOf2);
                        } else {
                            str2 = new String("Failed to report request stats: ");
                        }
                        Log.w("ProviderInstaller", str2);
                    }
                }
                if (remoteContext != null) {
                    zzc(remoteContext, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                    return;
                } else {
                    Log.e("ProviderInstaller", "Failed to get remote context");
                    throw new GooglePlayServicesNotAvailableException(8);
                }
            }
            zzc(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
        }
    }

    public static void installIfNeededAsync(@NonNull Context context, @NonNull ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    public static Method zzb(Context context, String str, String str2, Class[] clsArr) throws ClassNotFoundException, NoSuchMethodException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    @GuardedBy("ProviderInstaller.lock")
    public static void zzc(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        String message;
        String str2;
        try {
            if (zzc == null) {
                zzc = zzb(context, str, "insertProvider", new Class[]{Context.class});
            }
            zzc.invoke(null, context);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                if (cause == null) {
                    message = e.getMessage();
                } else {
                    message = cause.getMessage();
                }
                String valueOf = String.valueOf(message);
                if (valueOf.length() != 0) {
                    str2 = "Failed to install provider: ".concat(valueOf);
                } else {
                    str2 = new String("Failed to install provider: ");
                }
                Log.e("ProviderInstaller", str2);
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
