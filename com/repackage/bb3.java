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
import com.baidu.sofire.utility.PermissionChecker;
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
public abstract class bb3 implements cb3, db3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WifiManager b;
    public SwanWifiBroadcastReceiver c;
    public final db3 d;
    public boolean e;
    public volatile List<af3<hb3<gb3>>> f;
    public final za3 g;

    /* loaded from: classes5.dex */
    public class a implements za3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb3 a;

        public a(bb3 bb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb3Var;
        }

        @Override // com.repackage.za3
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
        public final /* synthetic */ af3 a;
        public final /* synthetic */ bb3 b;

        public b(bb3 bb3Var, af3 af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb3Var, af3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bb3Var;
            this.a = af3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.b.e) {
                    this.b.g(12000, "not init", null, this.a);
                } else if (!this.b.b.isWifiEnabled()) {
                    this.b.g(12005, "wifi is not on", null, this.a);
                } else if (!be3.K(this.b.a)) {
                    this.b.g(12006, "LBS is not on", null, this.a);
                } else if (ContextCompat.checkSelfPermission(this.b.a, PermissionChecker.ACCESS_FINE_LOCATION) != 0) {
                    this.b.g(12012, "no location permission", null, this.a);
                } else {
                    WifiInfo connectionInfo = this.b.b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    bb3 bb3Var = this.b;
                    bb3Var.g(0, "success", new gb3(wifiInfo, jb3.a(ib3.b(bb3Var.a, bb3Var.b, wifiInfo))), this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements db3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<af3<hb3<List<gb3>>>> a;
        public boolean b;
        public List<af3<hb3<Void>>> c;
        public Lock d;
        public Handler e;
        public List<ScanResult> f;
        public Runnable g;
        public ab3 h;
        public final /* synthetic */ bb3 i;

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
        public class b implements ab3 {
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

            @Override // com.repackage.ab3
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

        /* renamed from: com.repackage.bb3$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0600c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ af3 a;
            public final /* synthetic */ c b;

            public RunnableC0600c(c cVar, af3 af3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, af3Var};
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
                this.a = af3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.b.i.e) {
                        this.b.i.g(12000, "not init", null, this.a);
                    } else if (!this.b.i.b.isWifiEnabled()) {
                        this.b.i.g(12005, "wifi is not on", null, this.a);
                    } else if (!be3.K(this.b.i.a)) {
                        this.b.i.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.b.i.a, PermissionChecker.ACCESS_FINE_LOCATION) == 0) {
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

        public c(bb3 bb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = bb3Var;
            this.a = new CopyOnWriteArrayList();
            this.b = false;
            this.c = new CopyOnWriteArrayList();
            this.d = new ReentrantLock();
            this.e = new Handler(Looper.getMainLooper());
            this.g = new a(this);
            b bVar = new b(this);
            this.h = bVar;
            bb3Var.c.setScanListener(bVar);
        }

        @Override // com.repackage.db3
        public boolean b(af3<hb3<List<gb3>>> af3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, af3Var)) == null) {
                if (af3Var == null) {
                    return false;
                }
                List<af3<hb3<List<gb3>>>> list = this.a;
                if (list.contains(af3Var)) {
                    return list.remove(af3Var);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.db3
        public void c(af3<hb3<Void>> af3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af3Var) == null) || af3Var == null) {
                return;
            }
            bd3.k(new RunnableC0600c(this, af3Var), "wifiScan");
        }

        @Override // com.repackage.db3
        public boolean d(af3<hb3<List<gb3>>> af3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, af3Var)) == null) {
                if (af3Var == null) {
                    return false;
                }
                List<af3<hb3<List<gb3>>>> list = this.a;
                if (list.contains(af3Var)) {
                    return true;
                }
                return list.add(af3Var);
            }
            return invokeL.booleanValue;
        }

        public final void m(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        arrayList.add(new gb3(scanResult));
                    }
                }
                List<af3<hb3<List<gb3>>>> list2 = this.a;
                for (af3<hb3<List<gb3>>> af3Var : list2) {
                    this.i.g(0, "success", arrayList, af3Var);
                }
                List<af3<hb3<Void>>> list3 = this.c;
                this.c = new CopyOnWriteArrayList();
                for (af3<hb3<Void>> af3Var2 : list3) {
                    this.i.g(0, "success", null, af3Var2);
                    for (af3<hb3<List<gb3>>> af3Var3 : list2) {
                        this.i.g(0, "success", arrayList, af3Var3);
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

    public bb3(Context context) {
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

    @Override // com.repackage.db3
    public boolean b(af3<hb3<List<gb3>>> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, af3Var)) == null) ? this.d.b(af3Var) : invokeL.booleanValue;
    }

    @Override // com.repackage.db3
    public void c(af3<hb3<Void>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af3Var) == null) {
            this.d.c(af3Var);
        }
    }

    @Override // com.repackage.db3
    public boolean d(af3<hb3<List<gb3>>> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, af3Var)) == null) ? this.d.d(af3Var) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i, String str, ResultType resulttype, af3<hb3<ResultType>> af3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, resulttype, af3Var}) == null) || af3Var == null) {
            return;
        }
        hb3<ResultType> hb3Var = new hb3<>();
        hb3Var.a = i;
        hb3Var.b = str;
        hb3Var.c = resulttype;
        af3Var.a(hb3Var);
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

    public void j(af3<hb3<gb3>> af3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, af3Var) == null) || af3Var == null) {
            return;
        }
        bd3.k(new b(this, af3Var), "getConnectedWifi");
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
            for (af3<hb3<gb3>> af3Var : this.f) {
                g(0, "success", new gb3(wifiInfo, jb3.a(ib3.b(this.a, this.b, wifiInfo))), af3Var);
            }
        }
    }

    public boolean n(af3<hb3<gb3>> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, af3Var)) == null) {
            if (af3Var == null) {
                return false;
            }
            List<af3<hb3<gb3>>> list = this.f;
            if (list.contains(af3Var)) {
                return true;
            }
            return list.add(af3Var);
        }
        return invokeL.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void p(af3<hb3<Void>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, af3Var) == null) {
            if (this.e) {
                g(0, "success", null, af3Var);
                return;
            }
            k();
            g(0, "success", null, af3Var);
        }
    }

    public void q(af3<hb3<Void>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, af3Var) == null) {
            if (!this.e) {
                g(0, "success", null, af3Var);
                return;
            }
            i();
            g(0, "success", null, af3Var);
        }
    }

    public boolean r(af3<hb3<gb3>> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, af3Var)) == null) {
            if (af3Var == null) {
                return false;
            }
            List<af3<hb3<gb3>>> list = this.f;
            if (list.contains(af3Var)) {
                return list.remove(af3Var);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
