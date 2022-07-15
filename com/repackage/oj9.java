package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@ParametersAreNonnullByDefault
/* loaded from: classes6.dex */
public class oj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @GuardedBy("this")
    public sj9 a;
    @Nullable
    @GuardedBy("this")
    public zzf b;
    @GuardedBy("this")
    public boolean c;
    public final Object d;
    @Nullable
    @GuardedBy("mAutoDisconnectTaskLock")
    public qj9 e;
    @GuardedBy("this")
    public final Context f;
    public final long g;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final String a;
        public final boolean b;

        @Deprecated
        public a(@Nullable String str, boolean z) {
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
            this.a = str;
            this.b = z;
        }

        @Nullable
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.booleanValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.a;
                boolean z = this.b;
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

    public oj9(@NonNull Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new Object();
        dk9.d(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f = context;
        this.c = false;
        this.g = j;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public static a a(@NonNull Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, context)) != null) {
            return (a) invokeL.objValue;
        }
        oj9 oj9Var = new oj9(context, -1L, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            oj9Var.c(false);
            a e = oj9Var.e(-1);
            oj9Var.d(e, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", null);
            return e;
        } finally {
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dk9.c("Calling this from your main thread can lead to deadlock");
            synchronized (this) {
                if (this.f == null || this.a == null) {
                    return;
                }
                if (this.c) {
                    sk9.a().unbindService(this.f, this.a);
                }
                this.c = false;
                this.b = null;
                this.a = null;
            }
        }
    }

    public final void c(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            dk9.c("Calling this from your main thread can lead to deadlock");
            synchronized (this) {
                if (this.c) {
                    b();
                }
                Context context = this.f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int b = tj9.a().b(context, uj9.a);
                    if (b != 0 && b != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    sj9 sj9Var = new sj9();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    if (sk9.a().bindService(context, intent, sj9Var, 1)) {
                        this.a = sj9Var;
                        try {
                            this.b = zze.zza(sj9Var.a(10000L, TimeUnit.MILLISECONDS));
                            this.c = true;
                            if (z) {
                                f();
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

    public final boolean d(@Nullable a aVar, boolean z, float f, long j, String str, @Nullable Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, Boolean.valueOf(z), Float.valueOf(f), Long.valueOf(j), str, th})) == null) {
            if (Math.random() <= 0.0d) {
                HashMap hashMap = new HashMap();
                hashMap.put("app_context", "1");
                if (aVar != null) {
                    hashMap.put("limit_ad_tracking", true != aVar.b() ? "0" : "1");
                    String a2 = aVar.a();
                    if (a2 != null) {
                        hashMap.put("ad_id_size", Integer.toString(a2.length()));
                    }
                }
                if (th != null) {
                    hashMap.put("error", th.getClass().getName());
                }
                hashMap.put("tag", "AdvertisingIdClient");
                hashMap.put("time_spent", Long.toString(j));
                new pj9(this, hashMap).start();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final a e(int i) throws IOException {
        InterceptResult invokeI;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            dk9.c("Calling this from your main thread can lead to deadlock");
            synchronized (this) {
                if (!this.c) {
                    synchronized (this.d) {
                        qj9 qj9Var = this.e;
                        if (qj9Var == null || !qj9Var.d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        c(false);
                        if (!this.c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                dk9.d(this.a);
                dk9.d(this.b);
                try {
                    aVar = new a(this.b.zzc(), this.b.zze(true));
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                }
            }
            f();
            return aVar;
        }
        return (a) invokeI.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.d) {
                qj9 qj9Var = this.e;
                if (qj9Var != null) {
                    qj9Var.c.countDown();
                    try {
                        this.e.join();
                    } catch (InterruptedException unused) {
                    }
                }
                long j = this.g;
                if (j > 0) {
                    this.e = new qj9(this, j);
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b();
            super.finalize();
        }
    }
}
