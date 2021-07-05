package com.kwad.sdk.glide.c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.c.c;
/* loaded from: classes7.dex */
public final class e implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a f37638a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37639b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f37640c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37641d;

    /* renamed from: e  reason: collision with root package name */
    public final BroadcastReceiver f37642e;

    public e(@NonNull Context context, @NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37642e = new BroadcastReceiver(this) { // from class: com.kwad.sdk.glide.c.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f37643a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37643a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NonNull Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) {
                    e eVar = this.f37643a;
                    boolean z = eVar.f37639b;
                    eVar.f37639b = eVar.a(context2);
                    if (z != this.f37643a.f37639b) {
                        if (Log.isLoggable("ConnectivityMonitor", 3)) {
                            Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.f37643a.f37639b);
                        }
                        e eVar2 = this.f37643a;
                        eVar2.f37638a.a(eVar2.f37639b);
                    }
                }
            }
        };
        this.f37640c = context.getApplicationContext();
        this.f37638a = aVar;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.f37641d) {
            return;
        }
        this.f37639b = a(this.f37640c);
        try {
            this.f37640c.registerReceiver(this.f37642e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f37641d = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f37641d) {
            this.f37640c.unregisterReceiver(this.f37642e);
            this.f37641d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.kwad.sdk.glide.g.j.a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e2) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.c.i
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b();
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
