package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.aa;
import com.vivo.push.util.ag;
import com.vivo.push.util.u;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class b implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static Map<String, b> b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public String d;
    public Context e;
    public AtomicInteger f;
    public volatile IPCInvoke g;
    public Object h;
    public String i;
    public Handler j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1612095771, "Lcom/vivo/push/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1612095771, "Lcom/vivo/push/b;");
                return;
            }
        }
        a = new Object();
        b = new HashMap();
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Intent intent = new Intent(this.i);
            intent.setPackage(this.d);
            try {
                return this.e.bindService(intent, this, 1);
            } catch (Exception e) {
                u.a("AidlManager", "bind core error", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.j.removeMessages(1);
            this.j.sendEmptyMessageDelayed(1, 3000L);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.j.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                this.e.unbindService(this);
            } catch (Exception e) {
                u.a("AidlManager", "On unBindServiceException:" + e.getMessage());
            }
        }
    }

    public b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.h = new Object();
        this.j = null;
        this.e = context;
        this.i = str;
        this.f = new AtomicInteger(1);
        this.j = new Handler(Looper.getMainLooper(), new c(this));
        String a2 = aa.a(context);
        this.d = a2;
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(this.i)) {
            this.c = ag.a(context, this.d) >= 1260;
            b();
            return;
        }
        Context context2 = this.e;
        u.c(context2, "init error : push pkgname is " + this.d + " ; action is " + this.i);
        this.c = false;
    }

    public static b a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            b bVar = b.get(str);
            if (bVar == null) {
                synchronized (a) {
                    bVar = b.get(str);
                    if (bVar == null) {
                        bVar = new b(context, str);
                        b.put(str, bVar);
                    }
                }
            }
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
            u.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, componentName) == null) {
            this.g = null;
            a(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            this.f.set(i);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            int i = this.f.get();
            u.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i)));
            if (i != 4 && i != 2 && i != 3 && i != 5 && this.c) {
                a(2);
                if (!c()) {
                    a(1);
                    u.a("AidlManager", "bind core service fail");
                    return;
                }
                d();
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a2 = aa.a(this.e);
            this.d = a2;
            boolean z = false;
            if (TextUtils.isEmpty(a2)) {
                u.c(this.e, "push pkgname is null");
                return false;
            }
            if (ag.a(this.e, this.d) >= 1260) {
                z = true;
            }
            this.c = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            b();
            if (this.f.get() == 2) {
                synchronized (this.h) {
                    try {
                        this.h.wait(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                int i = this.f.get();
                if (i == 4) {
                    this.j.removeMessages(2);
                    this.j.sendEmptyMessageDelayed(2, 30000L);
                    this.g.asyncCall(bundle, null);
                    return true;
                }
                u.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i)));
                return false;
            } catch (Exception e2) {
                u.a("AidlManager", "invoke error ", e2);
                int i2 = this.f.get();
                u.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i2)));
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            a(1);
                            f();
                            return false;
                        }
                        return false;
                    }
                    a(1);
                    return false;
                }
                e();
                a(1);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, componentName, iBinder) == null) {
            e();
            this.g = IPCInvoke.Stub.asInterface(iBinder);
            if (this.g == null) {
                u.d("AidlManager", "onServiceConnected error : aidl must not be null.");
                f();
                this.f.set(1);
                return;
            }
            if (this.f.get() == 2) {
                a(4);
            } else if (this.f.get() != 4) {
                f();
            }
            synchronized (this.h) {
                this.h.notifyAll();
            }
        }
    }
}
