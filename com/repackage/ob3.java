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
/* loaded from: classes6.dex */
public abstract class ob3 implements pb3, qb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WifiManager b;
    public SwanWifiBroadcastReceiver c;
    public final qb3 d;
    public boolean e;
    public volatile List<nf3<ub3<tb3>>> f;
    public final mb3 g;

    /* loaded from: classes6.dex */
    public class a implements mb3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob3 a;

        public a(ob3 ob3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob3Var;
        }

        @Override // com.repackage.mb3
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

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;
        public final /* synthetic */ ob3 b;

        public b(ob3 ob3Var, nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob3Var, nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ob3Var;
            this.a = nf3Var;
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
                } else if (!oe3.K(this.b.a)) {
                    this.b.g(12006, "LBS is not on", null, this.a);
                } else if (ContextCompat.checkSelfPermission(this.b.a, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    this.b.g(12012, "no location permission", null, this.a);
                } else {
                    WifiInfo connectionInfo = this.b.b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    ob3 ob3Var = this.b;
                    ob3Var.g(0, "success", new tb3(wifiInfo, wb3.a(vb3.b(ob3Var.a, ob3Var.b, wifiInfo))), this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements qb3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<nf3<ub3<List<tb3>>>> a;
        public boolean b;
        public List<nf3<ub3<Void>>> c;
        public Lock d;
        public Handler e;
        public List<ScanResult> f;
        public Runnable g;
        public nb3 h;
        public final /* synthetic */ ob3 i;

        /* loaded from: classes6.dex */
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

        /* loaded from: classes6.dex */
        public class b implements nb3 {
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

            @Override // com.repackage.nb3
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

        /* renamed from: com.repackage.ob3$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0479c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nf3 a;
            public final /* synthetic */ c b;

            public RunnableC0479c(c cVar, nf3 nf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, nf3Var};
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
                this.a = nf3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.b.i.e) {
                        this.b.i.g(com.kuaishou.weapon.un.w0.X3, "not init", null, this.a);
                    } else if (!this.b.i.b.isWifiEnabled()) {
                        this.b.i.g(12005, "wifi is not on", null, this.a);
                    } else if (!oe3.K(this.b.i.a)) {
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

        public c(ob3 ob3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = ob3Var;
            this.a = new CopyOnWriteArrayList();
            this.b = false;
            this.c = new CopyOnWriteArrayList();
            this.d = new ReentrantLock();
            this.e = new Handler(Looper.getMainLooper());
            this.g = new a(this);
            b bVar = new b(this);
            this.h = bVar;
            ob3Var.c.setScanListener(bVar);
        }

        @Override // com.repackage.qb3
        public boolean b(nf3<ub3<List<tb3>>> nf3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nf3Var)) == null) {
                if (nf3Var == null) {
                    return false;
                }
                List<nf3<ub3<List<tb3>>>> list = this.a;
                if (list.contains(nf3Var)) {
                    return list.remove(nf3Var);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.qb3
        public void c(nf3<ub3<Void>> nf3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nf3Var) == null) || nf3Var == null) {
                return;
            }
            od3.k(new RunnableC0479c(this, nf3Var), "wifiScan");
        }

        @Override // com.repackage.qb3
        public boolean d(nf3<ub3<List<tb3>>> nf3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nf3Var)) == null) {
                if (nf3Var == null) {
                    return false;
                }
                List<nf3<ub3<List<tb3>>>> list = this.a;
                if (list.contains(nf3Var)) {
                    return true;
                }
                return list.add(nf3Var);
            }
            return invokeL.booleanValue;
        }

        public final void m(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        arrayList.add(new tb3(scanResult));
                    }
                }
                List<nf3<ub3<List<tb3>>>> list2 = this.a;
                for (nf3<ub3<List<tb3>>> nf3Var : list2) {
                    this.i.g(0, "success", arrayList, nf3Var);
                }
                List<nf3<ub3<Void>>> list3 = this.c;
                this.c = new CopyOnWriteArrayList();
                for (nf3<ub3<Void>> nf3Var2 : list3) {
                    this.i.g(0, "success", null, nf3Var2);
                    for (nf3<ub3<List<tb3>>> nf3Var3 : list2) {
                        this.i.g(0, "success", arrayList, nf3Var3);
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

    public ob3(Context context) {
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

    @Override // com.repackage.qb3
    public boolean b(nf3<ub3<List<tb3>>> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nf3Var)) == null) ? this.d.b(nf3Var) : invokeL.booleanValue;
    }

    @Override // com.repackage.qb3
    public void c(nf3<ub3<Void>> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nf3Var) == null) {
            this.d.c(nf3Var);
        }
    }

    @Override // com.repackage.qb3
    public boolean d(nf3<ub3<List<tb3>>> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nf3Var)) == null) ? this.d.d(nf3Var) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i, String str, ResultType resulttype, nf3<ub3<ResultType>> nf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, resulttype, nf3Var}) == null) || nf3Var == null) {
            return;
        }
        ub3<ResultType> ub3Var = new ub3<>();
        ub3Var.a = i;
        ub3Var.b = str;
        ub3Var.c = resulttype;
        nf3Var.onCallback(ub3Var);
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

    public void j(nf3<ub3<tb3>> nf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, nf3Var) == null) || nf3Var == null) {
            return;
        }
        od3.k(new b(this, nf3Var), "getConnectedWifi");
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
            for (nf3<ub3<tb3>> nf3Var : this.f) {
                g(0, "success", new tb3(wifiInfo, wb3.a(vb3.b(this.a, this.b, wifiInfo))), nf3Var);
            }
        }
    }

    public boolean n(nf3<ub3<tb3>> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, nf3Var)) == null) {
            if (nf3Var == null) {
                return false;
            }
            List<nf3<ub3<tb3>>> list = this.f;
            if (list.contains(nf3Var)) {
                return true;
            }
            return list.add(nf3Var);
        }
        return invokeL.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void p(nf3<ub3<Void>> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, nf3Var) == null) {
            if (this.e) {
                g(0, "success", null, nf3Var);
                return;
            }
            k();
            g(0, "success", null, nf3Var);
        }
    }

    public void q(nf3<ub3<Void>> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, nf3Var) == null) {
            if (!this.e) {
                g(0, "success", null, nf3Var);
                return;
            }
            i();
            g(0, "success", null, nf3Var);
        }
    }

    public boolean r(nf3<ub3<tb3>> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, nf3Var)) == null) {
            if (nf3Var == null) {
                return false;
            }
            List<nf3<ub3<tb3>>> list = this.f;
            if (list.contains(nf3Var)) {
                return list.remove(nf3Var);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
