package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class ProviderInstaller {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    public static final GoogleApiAvailabilityLight zza;
    public static final Object zzb;
    public static Method zzc;
    public static Method zzd;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public ProviderInstaller() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1925897931, "Lcom/google/android/gms/security/ProviderInstaller;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1925897931, "Lcom/google/android/gms/security/ProviderInstaller;");
                return;
            }
        }
        zza = GoogleApiAvailabilityLight.getInstance();
        zzb = new Object();
        zzc = null;
        zzd = null;
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        String str;
        Context context2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
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
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, providerInstallListener) == null) {
            Preconditions.checkNotNull(context, "Context must not be null");
            Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
            Preconditions.checkMainThread("Must be called on the UI thread");
            new zza(context, providerInstallListener).execute(new Void[0]);
        }
    }

    public static Method zzb(Context context, String str, String str2, Class[] clsArr) throws ClassNotFoundException, NoSuchMethodException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, str, str2, clsArr)) == null) {
            return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
        }
        return (Method) invokeLLLL.objValue;
    }

    public static void zzc(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        String message;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, context, context2, str) == null) {
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
}
