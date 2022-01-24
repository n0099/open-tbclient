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
import com.vivo.push.util.t;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class b implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, b> f60667b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60668c;

    /* renamed from: d  reason: collision with root package name */
    public String f60669d;

    /* renamed from: e  reason: collision with root package name */
    public Context f60670e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f60671f;

    /* renamed from: g  reason: collision with root package name */
    public volatile IPCInvoke f60672g;

    /* renamed from: h  reason: collision with root package name */
    public Object f60673h;

    /* renamed from: i  reason: collision with root package name */
    public String f60674i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f60675j;

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
        f60667b = new HashMap();
    }

    public b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60669d = null;
        this.f60673h = new Object();
        this.f60675j = null;
        this.f60670e = context;
        this.f60674i = str;
        this.f60671f = new AtomicInteger(1);
        this.f60675j = new Handler(Looper.getMainLooper(), new c(this));
        String b2 = t.b(context);
        this.f60669d = b2;
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(this.f60674i)) {
            this.f60668c = aa.a(context, this.f60669d) >= 1260;
            b();
            return;
        }
        Context context2 = this.f60670e;
        com.vivo.push.util.p.c(context2, "init error : push pkgname is " + this.f60669d + " ; action is " + this.f60674i);
        this.f60668c = false;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f60675j.removeMessages(1);
            this.f60675j.sendEmptyMessageDelayed(1, 3000L);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f60675j.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                this.f60670e.unbindService(this);
            } catch (Exception e2) {
                com.vivo.push.util.p.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
            com.vivo.push.util.p.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, componentName, iBinder) == null) {
            e();
            this.f60672g = IPCInvoke.Stub.asInterface(iBinder);
            if (this.f60672g == null) {
                com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
                f();
                this.f60671f.set(1);
                return;
            }
            if (this.f60671f.get() == 2) {
                a(4);
            } else if (this.f60671f.get() != 4) {
                f();
            }
            synchronized (this.f60673h) {
                this.f60673h.notifyAll();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, componentName) == null) {
            this.f60672g = null;
            a(1);
        }
    }

    public static b a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            b bVar = f60667b.get(str);
            if (bVar == null) {
                synchronized (a) {
                    bVar = f60667b.get(str);
                    if (bVar == null) {
                        bVar = new b(context, str);
                        f60667b.put(str, bVar);
                    }
                }
            }
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            int i2 = this.f60671f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i2)));
            if (i2 == 4 || i2 == 2 || i2 == 3 || i2 == 5 || !this.f60668c) {
                return;
            }
            a(2);
            if (!c()) {
                a(1);
                com.vivo.push.util.p.a("AidlManager", "bind core service fail");
                return;
            }
            d();
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Intent intent = new Intent(this.f60674i);
            intent.setPackage(this.f60669d);
            try {
                return this.f60670e.bindService(intent, this, 1);
            } catch (Exception e2) {
                com.vivo.push.util.p.a("AidlManager", "bind core error", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String b2 = t.b(this.f60670e);
            this.f60669d = b2;
            if (TextUtils.isEmpty(b2)) {
                com.vivo.push.util.p.c(this.f60670e, "push pkgname is null");
                return false;
            }
            boolean z = aa.a(this.f60670e, this.f60669d) >= 1260;
            this.f60668c = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            this.f60671f.set(i2);
        }
    }

    public final boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            b();
            if (this.f60671f.get() == 2) {
                synchronized (this.f60673h) {
                    try {
                        this.f60673h.wait(2000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            try {
                int i2 = this.f60671f.get();
                if (i2 == 4) {
                    this.f60675j.removeMessages(2);
                    this.f60675j.sendEmptyMessageDelayed(2, 30000L);
                    this.f60672g.asyncCall(bundle, null);
                    return true;
                }
                com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i2)));
                return false;
            } catch (Exception e3) {
                com.vivo.push.util.p.a("AidlManager", "invoke error ", e3);
                int i3 = this.f60671f.get();
                com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i3)));
                if (i3 == 2) {
                    e();
                    a(1);
                    return false;
                } else if (i3 == 3) {
                    a(1);
                    return false;
                } else if (i3 != 4) {
                    return false;
                } else {
                    a(1);
                    f();
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }
}
