package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
/* loaded from: classes7.dex */
public abstract class BaseGmsClient<T extends IInterface> {
    public static /* synthetic */ Interceptable $ic = null;
    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @NonNull
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @NonNull
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES;
    @NonNull
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    public static final Feature[] zze;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public volatile String zzA;
    @Nullable
    public ConnectionResult zzB;
    public boolean zzC;
    @Nullable
    public volatile zzj zzD;
    @VisibleForTesting
    public zzu zza;
    public final Handler zzb;
    @NonNull
    @VisibleForTesting
    public ConnectionProgressReportCallbacks zzc;
    @NonNull
    @VisibleForTesting
    public AtomicInteger zzd;
    public int zzf;
    public long zzg;
    public long zzh;
    public int zzi;
    public long zzj;
    @Nullable
    public volatile String zzk;
    public final Context zzl;
    public final Looper zzm;
    public final GmsClientSupervisor zzn;
    public final GoogleApiAvailabilityLight zzo;
    public final Object zzp;
    public final Object zzq;
    @Nullable
    @GuardedBy("mServiceBrokerLock")
    public IGmsServiceBroker zzr;
    @Nullable
    @GuardedBy("mLock")
    public T zzs;
    public final ArrayList<zzc<?>> zzt;
    @Nullable
    @GuardedBy("mLock")
    public zze zzu;
    @GuardedBy("mLock")
    public int zzv;
    @Nullable
    public final BaseConnectionCallbacks zzw;
    @Nullable
    public final BaseOnConnectionFailedListener zzx;
    public final int zzy;
    @Nullable
    public final String zzz;

    @KeepForSdk
    /* loaded from: classes7.dex */
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
        @KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @KeepForSdk
        void onConnected(@Nullable Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    @KeepForSdk
    /* loaded from: classes7.dex */
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    /* loaded from: classes7.dex */
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(@NonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    /* loaded from: classes7.dex */
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(251340128, "Lcom/google/android/gms/common/internal/BaseGmsClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(251340128, "Lcom/google/android/gms/common/internal/BaseGmsClient;");
                return;
            }
        }
        zze = new Feature[0];
        GOOGLE_PLUS_REQUIRED_FEATURES = new String[]{"service_esmobile", "service_googleme"};
    }

    @Nullable
    @KeepForSdk
    public abstract T createServiceInterface(@NonNull IBinder iBinder);

    @KeepForSdk
    public boolean enableLocalFallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    @KeepForSdk
    public Account getAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (Account) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    public Feature[] getApiFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? zze : (Feature[]) invokeV.objValue;
    }

    @Nullable
    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            zzj zzjVar = this.zzD;
            if (zzjVar == null) {
                return null;
            }
            return zzjVar.zzb;
        }
        return (Feature[]) invokeV.objValue;
    }

    @Nullable
    @KeepForSdk
    public Executor getBindServiceExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (Executor) invokeV.objValue;
    }

    @Nullable
    @KeepForSdk
    public Bundle getConnectionHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (Bundle) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.zzl : (Context) invokeV.objValue;
    }

    @KeepForSdk
    public int getGCoreServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.zzy : invokeV.intValue;
    }

    @Nullable
    @KeepForSdk
    public String getLastDisconnectMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.zzk : (String) invokeV.objValue;
    }

    @Nullable
    @KeepForSdk
    public String getLocalStartServiceAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    public final Looper getLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.zzm : (Looper) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    public abstract String getServiceDescriptor();

    @NonNull
    @KeepForSdk
    public abstract String getStartServiceAction();

    @NonNull
    @KeepForSdk
    public String getStartServicePackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? "com.google.android.gms" : (String) invokeV.objValue;
    }

    @Nullable
    @KeepForSdk
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            zzj zzjVar = this.zzD;
            if (zzjVar == null) {
                return null;
            }
            return zzjVar.zzd;
        }
        return (ConnectionTelemetryConfiguration) invokeV.objValue;
    }

    @KeepForSdk
    public boolean hasConnectionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.zzD != null : invokeV.booleanValue;
    }

    @KeepForSdk
    public boolean providesSignIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public void setAttributionTag(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.zzA = str;
        }
    }

    @KeepForSdk
    public boolean usesClientTelemetry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseGmsClient zza;

        @KeepForSdk
        public LegacyClientCallbackAdapter(BaseGmsClient baseGmsClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseGmsClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.zza = baseGmsClient;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, connectionResult) == null) {
                if (connectionResult.isSuccess()) {
                    BaseGmsClient baseGmsClient = this.zza;
                    baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
                } else if (this.zza.zzx != null) {
                    this.zza.zzx.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public BaseGmsClient(@NonNull Context context, @NonNull Handler handler, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler, gmsClientSupervisor, googleApiAvailabilityLight, Integer.valueOf(i), baseConnectionCallbacks, baseOnConnectionFailedListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseGmsClient(@NonNull Context context, @NonNull Looper looper, int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        this(context, looper, r3, r4, i, baseConnectionCallbacks, baseOnConnectionFailedListener, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, looper, Integer.valueOf(i), baseConnectionCallbacks, baseOnConnectionFailedListener, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Looper) objArr2[1], (GmsClientSupervisor) objArr2[2], (GoogleApiAvailabilityLight) objArr2[3], ((Integer) objArr2[4]).intValue(), (BaseConnectionCallbacks) objArr2[5], (BaseOnConnectionFailedListener) objArr2[6], (String) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        Preconditions.checkNotNull(baseConnectionCallbacks);
        Preconditions.checkNotNull(baseOnConnectionFailedListener);
    }

    @VisibleForTesting
    @KeepForSdk
    public BaseGmsClient(@NonNull Context context, @NonNull Looper looper, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, looper, gmsClientSupervisor, googleApiAvailabilityLight, Integer.valueOf(i), baseConnectionCallbacks, baseOnConnectionFailedListener, str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzm = looper;
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new zzb(this, looper);
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }

    public static /* bridge */ /* synthetic */ void zzj(BaseGmsClient baseGmsClient, zzj zzjVar) {
        RootTelemetryConfiguration zza;
        baseGmsClient.zzD = zzjVar;
        if (baseGmsClient.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.zzd;
            RootTelemetryConfigManager rootTelemetryConfigManager = RootTelemetryConfigManager.getInstance();
            if (connectionTelemetryConfiguration == null) {
                zza = null;
            } else {
                zza = connectionTelemetryConfiguration.zza();
            }
            rootTelemetryConfigManager.zza(zza);
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(BaseGmsClient baseGmsClient, int i) {
        int i2;
        int i3;
        synchronized (baseGmsClient.zzp) {
            i2 = baseGmsClient.zzv;
        }
        if (i2 == 3) {
            baseGmsClient.zzC = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = baseGmsClient.zzb;
        handler.sendMessage(handler.obtainMessage(i3, baseGmsClient.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzn(BaseGmsClient baseGmsClient, int i, int i2, IInterface iInterface) {
        synchronized (baseGmsClient.zzp) {
            if (baseGmsClient.zzv != i) {
                return false;
            }
            baseGmsClient.zzp(i2, iInterface);
            return true;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static /* bridge */ /* synthetic */ boolean zzo(com.google.android.gms.common.internal.BaseGmsClient r2) {
        /*
            boolean r0 = r2.zzC
            r1 = 0
            if (r0 == 0) goto L6
            goto L24
        L6:
            java.lang.String r0 = r2.getServiceDescriptor()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L11
            goto L24
        L11:
            java.lang.String r0 = r2.getLocalStartServiceAction()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1c
            goto L24
        L1c:
            java.lang.String r2 = r2.getServiceDescriptor()     // Catch: java.lang.ClassNotFoundException -> L24
            java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L24
            r1 = 1
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.zzo(com.google.android.gms.common.internal.BaseGmsClient):boolean");
    }

    @KeepForSdk
    public void connect(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, connectionProgressReportCallbacks) == null) {
            Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
            this.zzc = connectionProgressReportCallbacks;
            zzp(2, null);
        }
    }

    @KeepForSdk
    public void disconnect(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.zzk = str;
            disconnect();
        }
    }

    @KeepForSdk
    @CallSuper
    public void onConnectedLocked(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, t) == null) {
            this.zzh = System.currentTimeMillis();
        }
    }

    @KeepForSdk
    @CallSuper
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, connectionResult) == null) {
            this.zzi = connectionResult.getErrorCode();
            this.zzj = System.currentTimeMillis();
        }
    }

    @KeepForSdk
    @CallSuper
    public void onConnectionSuspended(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.zzf = i;
            this.zzg = System.currentTimeMillis();
        }
    }

    @KeepForSdk
    public void onUserSignOut(@NonNull SignOutCallbacks signOutCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, signOutCallbacks) == null) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            Handler handler = this.zzb;
            handler.sendMessage(handler.obtainMessage(6, this.zzd.get(), i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzp(int i, @Nullable T t) {
        boolean z;
        boolean z2;
        zzu zzuVar;
        String str;
        zzu zzuVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65553, this, i, t) == null) {
            boolean z3 = false;
            if (i != 4) {
                z = false;
            } else {
                z = true;
            }
            if (t == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z == z2) {
                z3 = true;
            }
            Preconditions.checkArgument(z3);
            synchronized (this.zzp) {
                this.zzv = i;
                this.zzs = t;
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        if (i == 4) {
                            Preconditions.checkNotNull(t);
                            onConnectedLocked(t);
                        }
                    } else {
                        zze zzeVar = this.zzu;
                        if (zzeVar != null && (zzuVar2 = this.zza) != null) {
                            String zzc = zzuVar2.zzc();
                            String zzb = zzuVar2.zzb();
                            StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 70 + String.valueOf(zzb).length());
                            sb.append("Calling connect() while still connected, missing disconnect() for ");
                            sb.append(zzc);
                            sb.append(" on ");
                            sb.append(zzb);
                            Log.e("GmsClient", sb.toString());
                            GmsClientSupervisor gmsClientSupervisor = this.zzn;
                            String zzc2 = this.zza.zzc();
                            Preconditions.checkNotNull(zzc2);
                            gmsClientSupervisor.zzb(zzc2, this.zza.zzb(), this.zza.zza(), zzeVar, zze(), this.zza.zzd());
                            this.zzd.incrementAndGet();
                        }
                        zze zzeVar2 = new zze(this, this.zzd.get());
                        this.zzu = zzeVar2;
                        if (this.zzv == 3 && getLocalStartServiceAction() != null) {
                            zzuVar = new zzu(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
                        } else {
                            zzuVar = new zzu(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
                        }
                        this.zza = zzuVar;
                        if (zzuVar.zzd() && getMinApkVersion() < 17895000) {
                            String valueOf = String.valueOf(this.zza.zzc());
                            if (valueOf.length() != 0) {
                                str = "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf);
                            } else {
                                str = new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ");
                            }
                            throw new IllegalStateException(str);
                        }
                        GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                        String zzc3 = this.zza.zzc();
                        Preconditions.checkNotNull(zzc3);
                        String zzb2 = this.zza.zzb();
                        int zza = this.zza.zza();
                        if (!gmsClientSupervisor2.zzc(new zzn(zzc3, zzb2, zza, this.zza.zzd()), zzeVar2, zze(), getBindServiceExecutor())) {
                            String zzc4 = this.zza.zzc();
                            String zzb3 = this.zza.zzb();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(zzc4).length() + 34 + String.valueOf(zzb3).length());
                            sb2.append("unable to connect to service: ");
                            sb2.append(zzc4);
                            sb2.append(" on ");
                            sb2.append(zzb3);
                            Log.w("GmsClient", sb2.toString());
                            zzl(16, null, this.zzd.get());
                        }
                    }
                } else {
                    zze zzeVar3 = this.zzu;
                    if (zzeVar3 != null) {
                        GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                        String zzc5 = this.zza.zzc();
                        Preconditions.checkNotNull(zzc5);
                        gmsClientSupervisor3.zzb(zzc5, this.zza.zzb(), this.zza.zza(), zzeVar3, zze(), this.zza.zzd());
                        this.zzu = null;
                    }
                }
            }
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int isGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
            if (isGooglePlayServicesAvailable != 0) {
                zzp(1, null);
                triggerNotAvailable(new LegacyClientCallbackAdapter(this), isGooglePlayServicesAvailable, null);
                return;
            }
            connect(new LegacyClientCallbackAdapter(this));
        }
    }

    @KeepForSdk
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.zzd.incrementAndGet();
            synchronized (this.zzt) {
                int size = this.zzt.size();
                for (int i = 0; i < size; i++) {
                    this.zzt.get(i).zzf();
                }
                this.zzt.clear();
            }
            synchronized (this.zzq) {
                this.zzr = null;
            }
            zzp(1, null);
        }
    }

    @KeepForSdk
    public final void checkConnected() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || isConnected()) {
            return;
        }
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    @NonNull
    @KeepForSdk
    public String getEndpointPackageName() {
        InterceptResult invokeV;
        zzu zzuVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (isConnected() && (zzuVar = this.zza) != null) {
                return zzuVar.zzb();
            }
            throw new RuntimeException("Failed to connect when checking package");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    public Bundle getGetServiceRequestExtraArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return new Bundle();
        }
        return (Bundle) invokeV.objValue;
    }

    @KeepForSdk
    public int getMinApkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        }
        return invokeV.intValue;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getScopes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return Collections.emptySet();
        }
        return (Set) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    public final T getService() throws DeadObjectException {
        InterceptResult invokeV;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this.zzp) {
                if (this.zzv != 5) {
                    checkConnected();
                    t = this.zzs;
                    Preconditions.checkNotNull(t, "Client is connected but service is null");
                } else {
                    throw new DeadObjectException();
                }
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    @Nullable
    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            synchronized (this.zzq) {
                IGmsServiceBroker iGmsServiceBroker = this.zzr;
                if (iGmsServiceBroker == null) {
                    return null;
                }
                return iGmsServiceBroker.asBinder();
            }
        }
        return (IBinder) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    public Intent getSignInIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            throw new UnsupportedOperationException("Not a sign in API");
        }
        return (Intent) invokeV.objValue;
    }

    @KeepForSdk
    public boolean getUseDynamicLookup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (getMinApkVersion() >= 211700000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public boolean isConnected() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            synchronized (this.zzp) {
                if (this.zzv == 4) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public boolean isConnecting() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this.zzp) {
                int i = this.zzv;
                z = true;
                if (i != 2 && i != 3) {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final String zze() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            String str = this.zzz;
            if (str == null) {
                return this.zzl.getClass().getName();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @KeepForSdk
    public void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            synchronized (this.zzp) {
                i = this.zzv;
                t = this.zzs;
            }
            synchronized (this.zzq) {
                iGmsServiceBroker = this.zzr;
            }
            printWriter.append((CharSequence) str).append("mConnectState=");
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                printWriter.print(RomUtils.UNKNOWN);
                            } else {
                                printWriter.print("DISCONNECTING");
                            }
                        } else {
                            printWriter.print("CONNECTED");
                        }
                    } else {
                        printWriter.print("LOCAL_CONNECTING");
                    }
                } else {
                    printWriter.print("REMOTE_CONNECTING");
                }
            } else {
                printWriter.print("DISCONNECTED");
            }
            printWriter.append(" mService=");
            if (t == null) {
                printWriter.append(StringUtil.NULL_STRING);
            } else {
                printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
            }
            printWriter.append(" mServiceBroker=");
            if (iGmsServiceBroker == null) {
                printWriter.println(StringUtil.NULL_STRING);
            } else {
                printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
            if (this.zzh > 0) {
                PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
                long j = this.zzh;
                String format = simpleDateFormat.format(new Date(j));
                StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
                sb.append(j);
                sb.append(" ");
                sb.append(format);
                append.println(sb.toString());
            }
            if (this.zzg > 0) {
                printWriter.append((CharSequence) str).append("lastSuspendedCause=");
                int i2 = this.zzf;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            printWriter.append((CharSequence) String.valueOf(i2));
                        } else {
                            printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
                        }
                    } else {
                        printWriter.append("CAUSE_NETWORK_LOST");
                    }
                } else {
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                }
                PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
                long j2 = this.zzg;
                String format2 = simpleDateFormat.format(new Date(j2));
                StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
                sb2.append(j2);
                sb2.append(" ");
                sb2.append(format2);
                append2.println(sb2.toString());
            }
            if (this.zzj > 0) {
                printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzi));
                PrintWriter append3 = printWriter.append(" lastFailedTime=");
                long j3 = this.zzj;
                String format3 = simpleDateFormat.format(new Date(j3));
                StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
                sb3.append(j3);
                sb3.append(" ");
                sb3.append(format3);
                append3.println(sb3.toString());
            }
        }
    }

    @KeepForSdk
    @WorkerThread
    public void getRemoteService(@Nullable IAccountAccessor iAccountAccessor, @NonNull Set<Scope> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, iAccountAccessor, set) == null) {
            Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
            GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy, this.zzA);
            getServiceRequest.zzd = this.zzl.getPackageName();
            getServiceRequest.zzg = getServiceRequestExtraArgs;
            if (set != null) {
                getServiceRequest.zzf = (Scope[]) set.toArray(new Scope[set.size()]);
            }
            if (requiresSignIn()) {
                Account account = getAccount();
                if (account == null) {
                    account = new Account(DEFAULT_ACCOUNT, AccountType.GOOGLE);
                }
                getServiceRequest.zzh = account;
                if (iAccountAccessor != null) {
                    getServiceRequest.zze = iAccountAccessor.asBinder();
                }
            } else if (requiresAccount()) {
                getServiceRequest.zzh = getAccount();
            }
            getServiceRequest.zzi = zze;
            getServiceRequest.zzj = getApiFeatures();
            if (usesClientTelemetry()) {
                getServiceRequest.zzm = true;
            }
            try {
                synchronized (this.zzq) {
                    IGmsServiceBroker iGmsServiceBroker = this.zzr;
                    if (iGmsServiceBroker != null) {
                        iGmsServiceBroker.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                }
            } catch (DeadObjectException e) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
                triggerConnectionSuspended(3);
            } catch (RemoteException e2) {
                e = e2;
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
                onPostInitHandler(8, null, null, this.zzd.get());
            } catch (SecurityException e3) {
                throw e3;
            } catch (RuntimeException e4) {
                e = e4;
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
                onPostInitHandler(8, null, null, this.zzd.get());
            }
        }
    }

    @KeepForSdk
    public void onPostInitHandler(int i, @Nullable IBinder iBinder, @Nullable Bundle bundle, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i), iBinder, bundle, Integer.valueOf(i2)}) == null) {
            Handler handler = this.zzb;
            handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(this, i, iBinder, bundle)));
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, @Nullable PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048621, this, connectionProgressReportCallbacks, i, pendingIntent) == null) {
            Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
            this.zzc = connectionProgressReportCallbacks;
            Handler handler = this.zzb;
            handler.sendMessage(handler.obtainMessage(3, this.zzd.get(), i, pendingIntent));
        }
    }

    public final void zzl(int i, @Nullable Bundle bundle, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i), bundle, Integer.valueOf(i2)}) == null) {
            Handler handler = this.zzb;
            handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(this, i, null)));
        }
    }
}
