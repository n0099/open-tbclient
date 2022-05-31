package com.repackage;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.system.wifi.listener.SwanWifiBroadcastReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public abstract class ba3 implements ca3, da3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WifiManager b;
    public SwanWifiBroadcastReceiver c;
    public final da3 d;
    public boolean e;
    public volatile List<ae3<ha3<ga3>>> f;
    public final z93 g;

    /* loaded from: classes5.dex */
    public class a implements z93 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba3 a;

        public a(ba3 ba3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba3Var;
        }

        @Override // com.repackage.z93
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.a.b.getConnectionInfo();
                }
                this.a.m(wifiInfo);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae3 a;
        public final /* synthetic */ ba3 b;

        public b(ba3 ba3Var, ae3 ae3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba3Var, ae3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ba3Var;
            this.a = ae3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.b.e) {
                    this.b.g(com.kuaishou.weapon.un.w0.X3, "not init", null, this.a);
                } else if (!this.b.b.isWifiEnabled()) {
                    this.b.g(12005, "wifi is not on", null, this.a);
                } else if (!bd3.K(this.b.a)) {
                    this.b.g(12006, "LBS is not on", null, this.a);
                } else if (ContextCompat.checkSelfPermission(this.b.a, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    this.b.g(12012, "no location permission", null, this.a);
                } else {
                    WifiInfo connectionInfo = this.b.b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    ba3 ba3Var = this.b;
                    ba3Var.g(0, "success", new ga3(wifiInfo, ja3.a(ia3.b(ba3Var.a, ba3Var.b, wifiInfo))), this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements da3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<ae3<ha3<List<ga3>>>> a;
        public boolean b;
        public List<ae3<ha3<Void>>> c;
        public Lock d;
        public Handler e;
        public List<ScanResult> f;
        public Runnable g;
        public aa3 h;
        public final /* synthetic */ ba3 i;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.d.lock();
                    try {
                        if (this.a.b) {
                            this.a.m(this.a.f);
                            this.a.b = false;
                        }
                    } finally {
                        this.a.d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements aa3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.repackage.aa3
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.f = list;
                    this.a.d.lock();
                    try {
                        if (this.a.b) {
                            this.a.e.removeCallbacks(this.a.g);
                            this.a.m(list);
                            this.a.b = false;
                        }
                    } finally {
                        this.a.d.unlock();
                    }
                }
            }
        }

        /* renamed from: com.repackage.ba3$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0386c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ae3 a;
            public final /* synthetic */ c b;

            public RunnableC0386c(c cVar, ae3 ae3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, ae3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = ae3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.b.i.e) {
                        this.b.i.g(com.kuaishou.weapon.un.w0.X3, "not init", null, this.a);
                    } else if (!this.b.i.b.isWifiEnabled()) {
                        this.b.i.g(12005, "wifi is not on", null, this.a);
                    } else if (!bd3.K(this.b.i.a)) {
                        this.b.i.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.b.i.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        this.b.d.lock();
                        try {
                            if (this.b.b) {
                                this.b.c.add(this.a);
                                return;
                            }
                            this.b.b = true;
                            this.b.d.unlock();
                            this.b.e.postDelayed(this.b.g, 6000L);
                            this.b.i.b.startScan();
                            this.b.i.g(0, "success", null, this.a);
                        } finally {
                            this.b.d.unlock();
                        }
                    } else {
                        this.b.i.g(12012, "no location permission", null, this.a);
                    }
                }
            }
        }

        public c(ba3 ba3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = ba3Var;
            this.a = new CopyOnWriteArrayList();
            this.b = false;
            this.c = new CopyOnWriteArrayList();
            this.d = new ReentrantLock();
            this.e = new Handler(Looper.getMainLooper());
            this.g = new a(this);
            b bVar = new b(this);
            this.h = bVar;
            ba3Var.c.setScanListener(bVar);
        }

        @Override // com.repackage.da3
        public boolean b(ae3<ha3<List<ga3>>> ae3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ae3Var)) == null) {
                if (ae3Var == null) {
                    return false;
                }
                List<ae3<ha3<List<ga3>>>> list = this.a;
                if (list.contains(ae3Var)) {
                    return list.remove(ae3Var);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.da3
        public void c(ae3<ha3<Void>> ae3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ae3Var) == null) || ae3Var == null) {
                return;
            }
            bc3.k(new RunnableC0386c(this, ae3Var), "wifiScan");
        }

        @Override // com.repackage.da3
        public boolean d(ae3<ha3<List<ga3>>> ae3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ae3Var)) == null) {
                if (ae3Var == null) {
                    return false;
                }
                List<ae3<ha3<List<ga3>>>> list = this.a;
                if (list.contains(ae3Var)) {
                    return true;
                }
                return list.add(ae3Var);
            }
            return invokeL.booleanValue;
        }

        public final void m(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        arrayList.add(new ga3(scanResult));
                    }
                }
                List<ae3<ha3<List<ga3>>>> list2 = this.a;
                for (ae3<ha3<List<ga3>>> ae3Var : list2) {
                    this.i.g(0, "success", arrayList, ae3Var);
                }
                List<ae3<ha3<Void>>> list3 = this.c;
                this.c = new CopyOnWriteArrayList();
                for (ae3<ha3<Void>> ae3Var2 : list3) {
                    this.i.g(0, "success", null, ae3Var2);
                    for (ae3<ha3<List<ga3>>> ae3Var3 : list2) {
                        this.i.g(0, "success", arrayList, ae3Var3);
                    }
                }
            }
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a = new CopyOnWriteArrayList();
            }
        }
    }

    public ba3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = new CopyOnWriteArrayList();
        this.g = new a(this);
        this.a = context;
        this.b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.b);
        this.c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.g);
        this.d = new c(this);
    }

    @Override // com.repackage.da3
    public boolean b(ae3<ha3<List<ga3>>> ae3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ae3Var)) == null) ? this.d.b(ae3Var) : invokeL.booleanValue;
    }

    @Override // com.repackage.da3
    public void c(ae3<ha3<Void>> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ae3Var) == null) {
            this.d.c(ae3Var);
        }
    }

    @Override // com.repackage.da3
    public boolean d(ae3<ha3<List<ga3>>> ae3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ae3Var)) == null) ? this.d.d(ae3Var) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i, String str, ResultType resulttype, ae3<ha3<ResultType>> ae3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, resulttype, ae3Var}) == null) || ae3Var == null) {
            return;
        }
        ha3<ResultType> ha3Var = new ha3<>();
        ha3Var.a = i;
        ha3Var.b = str;
        ha3Var.c = resulttype;
        ae3Var.onCallback(ha3Var);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.unregisterSelf(this.a);
            this.f = new CopyOnWriteArrayList();
            ((c) this.d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.unregisterSelf(this.a);
            o(false);
        }
    }

    public void j(ae3<ha3<ga3>> ae3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ae3Var) == null) || ae3Var == null) {
            return;
        }
        bc3.k(new b(this, ae3Var), "getConnectedWifi");
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.registerSelf(this.a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (ae3<ha3<ga3>> ae3Var : this.f) {
                g(0, "success", new ga3(wifiInfo, ja3.a(ia3.b(this.a, this.b, wifiInfo))), ae3Var);
            }
        }
    }

    public boolean n(ae3<ha3<ga3>> ae3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, ae3Var)) == null) {
            if (ae3Var == null) {
                return false;
            }
            List<ae3<ha3<ga3>>> list = this.f;
            if (list.contains(ae3Var)) {
                return true;
            }
            return list.add(ae3Var);
        }
        return invokeL.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void p(ae3<ha3<Void>> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ae3Var) == null) {
            if (this.e) {
                g(0, "success", null, ae3Var);
                return;
            }
            k();
            g(0, "success", null, ae3Var);
        }
    }

    public void q(ae3<ha3<Void>> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ae3Var) == null) {
            if (!this.e) {
                g(0, "success", null, ae3Var);
                return;
            }
            i();
            g(0, "success", null, ae3Var);
        }
    }

    public boolean r(ae3<ha3<ga3>> ae3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ae3Var)) == null) {
            if (ae3Var == null) {
                return false;
            }
            List<ae3<ha3<ga3>>> list = this.f;
            if (list.contains(ae3Var)) {
                return list.remove(ae3Var);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
