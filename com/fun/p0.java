package com.fun;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import androidx.annotation.Nullable;
import c.g.r0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile NetworkInfo a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<b> f54438b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                LogPrinter.d("onReceive:" + intent, new Object[0]);
                p0.a(context, intent);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(@Nullable NetworkInfo networkInfo);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-569867375, "Lcom/fun/p0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-569867375, "Lcom/fun/p0;");
                return;
            }
        }
        a aVar = new a();
        f54438b = new HashSet<>();
        Context appContext = FunAdSdk.getAppContext();
        a(appContext, appContext.registerReceiver(aVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, intent) == null) {
            if (intent == null || context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                a = null;
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a = null;
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            LogPrinter.d("activeNetworkInfo:" + activeNetworkInfo, new Object[0]);
            a = activeNetworkInfo;
            HashSet<b> hashSet = f54438b;
            synchronized (hashSet) {
                Iterator<b> it = hashSet.iterator();
                while (it.hasNext()) {
                    it.next().a(activeNetworkInfo);
                }
            }
        }
    }

    public static void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            HashSet<b> hashSet = f54438b;
            synchronized (hashSet) {
                hashSet.add(bVar);
            }
            ((r0.b) bVar).a(a);
        }
    }
}
