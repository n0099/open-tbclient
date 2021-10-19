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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class b implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f76841a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, b> f76842b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f76843c;

    /* renamed from: d  reason: collision with root package name */
    public String f76844d;

    /* renamed from: e  reason: collision with root package name */
    public Context f76845e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f76846f;

    /* renamed from: g  reason: collision with root package name */
    public volatile IPCInvoke f76847g;

    /* renamed from: h  reason: collision with root package name */
    public Object f76848h;

    /* renamed from: i  reason: collision with root package name */
    public String f76849i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f76850j;

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
        f76841a = new Object();
        f76842b = new HashMap();
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
        this.f76844d = null;
        this.f76848h = new Object();
        this.f76850j = null;
        this.f76845e = context;
        this.f76849i = str;
        this.f76846f = new AtomicInteger(1);
        this.f76850j = new Handler(Looper.getMainLooper(), new c(this));
        String b2 = com.vivo.push.util.s.b(context);
        this.f76844d = b2;
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(this.f76849i)) {
            this.f76843c = com.vivo.push.util.z.a(context, this.f76844d) >= 1260;
            b();
            return;
        }
        Context context2 = this.f76845e;
        com.vivo.push.util.p.c(context2, "init error : push pkgname is " + this.f76844d + " ; action is " + this.f76849i);
        this.f76843c = false;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f76850j.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                this.f76845e.unbindService(this);
            } catch (Exception e2) {
                com.vivo.push.util.p.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
            com.vivo.push.util.p.b("AidlManager", "onBindingDied : " + componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, componentName, iBinder) == null) {
            d();
            this.f76847g = IPCInvoke.Stub.asInterface(iBinder);
            if (this.f76847g == null) {
                com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
                e();
                this.f76846f.set(1);
                return;
            }
            if (this.f76846f.get() == 2) {
                a(4);
            } else if (this.f76846f.get() != 4) {
                e();
            }
            synchronized (this.f76848h) {
                this.f76848h.notifyAll();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, componentName) == null) {
            this.f76847g = null;
            a(1);
        }
    }

    public static b a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            b bVar = f76842b.get(str);
            if (bVar == null) {
                synchronized (f76841a) {
                    bVar = f76842b.get(str);
                    if (bVar == null) {
                        bVar = new b(context, str);
                        f76842b.put(str, bVar);
                    }
                }
            }
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            int i2 = this.f76846f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: " + i2);
            if (i2 == 4 || i2 == 2 || i2 == 3 || i2 == 5 || !this.f76843c) {
                return;
            }
            a(2);
            if (!c()) {
                a(1);
                com.vivo.push.util.p.a("AidlManager", "bind core service fail");
                return;
            }
            this.f76850j.removeMessages(1);
            this.f76850j.sendEmptyMessageDelayed(1, 3000L);
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Intent intent = new Intent(this.f76849i);
            intent.setPackage(this.f76844d);
            try {
                return this.f76845e.bindService(intent, this, 1);
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
            String b2 = com.vivo.push.util.s.b(this.f76845e);
            this.f76844d = b2;
            if (TextUtils.isEmpty(b2)) {
                com.vivo.push.util.p.c(this.f76845e, "push pkgname is null");
                return false;
            }
            boolean z = com.vivo.push.util.z.a(this.f76845e, this.f76844d) >= 1260;
            this.f76843c = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            this.f76846f.set(i2);
        }
    }

    public final boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            b();
            if (this.f76846f.get() == 2) {
                synchronized (this.f76848h) {
                    try {
                        this.f76848h.wait(2000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            try {
                int i2 = this.f76846f.get();
                if (i2 == 4) {
                    this.f76850j.removeMessages(2);
                    this.f76850j.sendEmptyMessageDelayed(2, 30000L);
                    this.f76847g.asyncCall(bundle, null);
                    return true;
                }
                com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = " + i2);
                return false;
            } catch (Exception e3) {
                com.vivo.push.util.p.a("AidlManager", "invoke error ", e3);
                int i3 = this.f76846f.get();
                com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: " + i3);
                if (i3 == 2) {
                    d();
                    a(1);
                    return false;
                } else if (i3 == 3) {
                    a(1);
                    return false;
                } else if (i3 != 4) {
                    return false;
                } else {
                    a(1);
                    e();
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }
}
