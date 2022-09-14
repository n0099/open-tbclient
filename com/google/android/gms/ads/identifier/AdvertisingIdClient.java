package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
@ParametersAreNonnullByDefault
/* loaded from: classes7.dex */
public class AdvertisingIdClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @GuardedBy("this")
    public BlockingServiceConnection zza;
    @Nullable
    @GuardedBy("this")
    public zzf zzb;
    @GuardedBy("this")
    public boolean zzc;
    public final Object zzd;
    @Nullable
    @GuardedBy("mAutoDisconnectTaskLock")
    public zzb zze;
    public final long zzf;
    @GuardedBy("this")
    public final Context zzg;

    @KeepForSdkWithMembers
    /* loaded from: classes7.dex */
    public static final class Info {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final String zza;
        public final boolean zzb;

        @Deprecated
        public Info(@Nullable String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.zza = str;
            this.zzb = z;
        }

        @Nullable
        public String getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.zza : (String) invokeV.objValue;
        }

        public boolean isLimitAdTrackingEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zzb : invokeV.booleanValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.zza;
                boolean z = this.zzb;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
                sb.append("{");
                sb.append(str);
                sb.append("}");
                sb.append(z);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @KeepForSdk
    public AdvertisingIdClient(@NonNull Context context) {
        this(context, 30000L, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    @KeepForSdk
    public static Info getAdvertisingIdInfo(@NonNull Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, context)) != null) {
            return (Info) invokeL.objValue;
        }
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zzb(false);
            Info zzd = advertisingIdClient.zzd(-1);
            advertisingIdClient.zzc(zzd, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", null);
            return zzd;
        } finally {
        }
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(@NonNull Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        InterceptResult invokeL;
        boolean zzd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, false, false);
            try {
                advertisingIdClient.zzb(false);
                Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
                synchronized (advertisingIdClient) {
                    if (!advertisingIdClient.zzc) {
                        synchronized (advertisingIdClient.zzd) {
                            zzb zzbVar = advertisingIdClient.zze;
                            if (zzbVar == null || !zzbVar.zzb) {
                                throw new IOException("AdvertisingIdClient is not connected.");
                            }
                        }
                        try {
                            advertisingIdClient.zzb(false);
                            if (!advertisingIdClient.zzc) {
                                throw new IOException("AdvertisingIdClient cannot reconnect.");
                            }
                        } catch (Exception e) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                        }
                    }
                    Preconditions.checkNotNull(advertisingIdClient.zza);
                    Preconditions.checkNotNull(advertisingIdClient.zzb);
                    try {
                        zzd = advertisingIdClient.zzb.zzd();
                    } catch (RemoteException e2) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                        throw new IOException("Remote exception");
                    }
                }
                advertisingIdClient.zze();
                return zzd;
            } finally {
                advertisingIdClient.zza();
            }
        }
        return invokeL.booleanValue;
    }

    @ShowFirstParty
    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
        }
    }

    private final Info zzd(int i) throws IOException {
        InterceptResult invokeI;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (this) {
                if (!this.zzc) {
                    synchronized (this.zzd) {
                        zzb zzbVar = this.zze;
                        if (zzbVar == null || !zzbVar.zzb) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        zzb(false);
                        if (!this.zzc) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                Preconditions.checkNotNull(this.zza);
                Preconditions.checkNotNull(this.zzb);
                try {
                    info = new Info(this.zzb.zzc(), this.zzb.zze(true));
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                }
            }
            zze();
            return info;
        }
        return (Info) invokeI.objValue;
    }

    private final void zze() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            synchronized (this.zzd) {
                zzb zzbVar = this.zze;
                if (zzbVar != null) {
                    zzbVar.zza.countDown();
                    try {
                        this.zze.join();
                    } catch (InterruptedException unused) {
                    }
                }
                long j = this.zzf;
                if (j > 0) {
                    this.zze = new zzb(this, j);
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zza();
            super.finalize();
        }
    }

    @NonNull
    @KeepForSdk
    public Info getInfo() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? zzd(-1) : (Info) invokeV.objValue;
    }

    @KeepForSdk
    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            zzb(true);
        }
    }

    public final void zza() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (this) {
                if (this.zzg == null || this.zza == null) {
                    return;
                }
                if (this.zzc) {
                    ConnectionTracker.getInstance().unbindService(this.zzg, this.zza);
                }
                this.zzc = false;
                this.zzb = null;
                this.zza = null;
            }
        }
    }

    @VisibleForTesting
    public final void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (this) {
                if (this.zzc) {
                    zza();
                }
                Context context = this.zzg;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (isGooglePlayServicesAvailable != 0 && isGooglePlayServicesAvailable != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    if (ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                        this.zza = blockingServiceConnection;
                        try {
                            this.zzb = zze.zza(blockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
                            this.zzc = true;
                            if (z) {
                                zze();
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        }
                    } else {
                        throw new IOException("Connection failure");
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new GooglePlayServicesNotAvailableException(9);
                }
            }
        }
    }

    @VisibleForTesting
    public final boolean zzc(@Nullable Info info, boolean z, float f, long j, String str, @Nullable Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{info, Boolean.valueOf(z), Float.valueOf(f), Long.valueOf(j), str, th})) == null) {
            if (Math.random() <= 0.0d) {
                HashMap hashMap = new HashMap();
                hashMap.put("app_context", "1");
                if (info != null) {
                    hashMap.put("limit_ad_tracking", true != info.isLimitAdTrackingEnabled() ? "0" : "1");
                    String id = info.getId();
                    if (id != null) {
                        hashMap.put("ad_id_size", Integer.toString(id.length()));
                    }
                }
                if (th != null) {
                    hashMap.put("error", th.getClass().getName());
                }
                hashMap.put("tag", "AdvertisingIdClient");
                hashMap.put("time_spent", Long.toString(j));
                new zza(this, hashMap).start();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @VisibleForTesting
    public AdvertisingIdClient(@NonNull Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zzd = new Object();
        Preconditions.checkNotNull(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.zzg = context;
        this.zzc = false;
        this.zzf = j;
    }
}
