package com.fun;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.eg9;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile NetworkInfo a;
    public static final HashSet<b> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                i0.a(context, intent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onActiveNetworkInfo(@Nullable NetworkInfo networkInfo);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-569874102, "Lcom/fun/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-569874102, "Lcom/fun/i0;");
                return;
            }
        }
        a aVar = new a();
        b = new HashSet<>();
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
            HashSet<b> hashSet = b;
            synchronized (hashSet) {
                Iterator<b> it = hashSet.iterator();
                while (it.hasNext()) {
                    it.next().onActiveNetworkInfo(activeNetworkInfo);
                }
            }
        }
    }

    public static void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            HashSet<b> hashSet = b;
            synchronized (hashSet) {
                hashSet.add(bVar);
            }
            ((eg9.b) bVar).onActiveNetworkInfo(a);
        }
    }
}
