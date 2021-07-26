package d.a.q0.h0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.f;
import d.a.p0.b1.n;
import d.a.q0.h0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static d f57278f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f57279a;

    /* renamed from: b  reason: collision with root package name */
    public Object f57280b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.q0.h0.i.a> f57281c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.h0.i.a f57282d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57283e;

    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d this$0;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("ip");
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            int intExtra = intent.getIntExtra("speed", -1);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (intExtra == -1) {
                this.this$0.q(stringExtra, booleanExtra, false);
            } else {
                this.this$0.o(stringExtra, intExtra, booleanExtra, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements n<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f57284a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f57285e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f57286f;

            public a(b bVar, WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, writeHistroyDataReqIdl};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57286f = bVar;
                this.f57285e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f57285e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            d.a.q0.h0.i.a a2 = d.a.q0.h0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f57263e, a2);
                            }
                        }
                    }
                    synchronized (this.f57286f.f57284a.f57280b) {
                        if (this.f57286f.f57284a.f57281c == null) {
                            this.f57286f.f57284a.f57281c = new ConcurrentHashMap();
                        }
                        this.f57286f.f57284a.f57281c.clear();
                        this.f57286f.f57284a.f57281c.putAll(hashMap);
                    }
                    this.f57286f.f57284a.f57283e = true;
                    this.f57286f.f57284a.s();
                    ArrayList<d.a.q0.h0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f57286f.f57284a.f57281c.entrySet()) {
                        if (this.f57286f.f57284a.f57282d != entry.getValue() && System.currentTimeMillis() - ((d.a.q0.h0.i.a) entry.getValue()).f57261c > 604800000) {
                            arrayList.add(entry.getValue());
                            d.a.q0.h0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (d.a.q0.h0.i.a aVar : arrayList) {
                        this.f57286f.f57284a.f57281c.remove(aVar.f57263e);
                    }
                }
            }
        }

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57284a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeHistroyDataReqIdl) == null) {
                e.i().o(new a(this, writeHistroyDataReqIdl));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57287e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f57288f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f57289g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f57290h;

        public c(d dVar, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57290h = dVar;
            this.f57287e = str;
            this.f57288f = z;
            this.f57289g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f57290h.f57282d != null) {
                    d.a.q0.h0.i.b bVar = this.f57290h.f57282d.f57259a.get(this.f57287e);
                    if (bVar == null) {
                        bVar = new d.a.q0.h0.i.b();
                        bVar.f57264a = this.f57287e;
                        this.f57290h.f57282d.f57259a.put(this.f57287e, bVar);
                    }
                    bVar.a(this.f57288f ? 1 : 0);
                    synchronized (this.f57290h.f57280b) {
                        hashMap = new HashMap(this.f57290h.f57281c);
                    }
                    d.a.q0.h0.i.c.h().j(hashMap);
                }
                if (this.f57289g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f57287e);
                    intent.putExtra("result", this.f57288f);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: d.a.q0.h0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1409d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f57292f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f57293g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f57294h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f57295i;

        public RunnableC1409d(d dVar, String str, boolean z, int i2, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57295i = dVar;
            this.f57291e = str;
            this.f57292f = z;
            this.f57293g = i2;
            this.f57294h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f57295i.f57282d == null) {
                    String b2 = d.a.q0.h0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        d.a.q0.h0.i.a aVar = new d.a.q0.h0.i.a();
                        aVar.f57263e = b2;
                        this.f57295i.f57282d = aVar;
                        this.f57295i.f57281c.put(b2, aVar);
                    }
                }
                if (this.f57295i.f57282d != null) {
                    d.a.q0.h0.i.b bVar = this.f57295i.f57282d.f57259a.get(this.f57291e);
                    if (bVar == null) {
                        bVar = new d.a.q0.h0.i.b();
                        bVar.f57264a = this.f57291e;
                        this.f57295i.f57282d.f57259a.put(this.f57291e, bVar);
                    }
                    bVar.a(this.f57292f ? 1 : 0);
                    if (this.f57292f) {
                        d.a.q0.h0.i.b bVar2 = this.f57295i.f57282d.f57260b.get(this.f57291e);
                        if (bVar2 == null) {
                            bVar2 = new d.a.q0.h0.i.b();
                            bVar2.f57264a = this.f57291e;
                            this.f57295i.f57282d.f57260b.put(this.f57291e, bVar2);
                        }
                        bVar2.a(this.f57293g);
                    }
                    synchronized (this.f57295i.f57280b) {
                        hashMap = new HashMap(this.f57295i.f57281c);
                    }
                    d.a.q0.h0.i.c.h().j(hashMap);
                }
                if (this.f57294h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f57291e);
                    intent.putExtra("result", this.f57292f);
                    intent.putExtra("speed", this.f57293g);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2012179961, "Ld/a/q0/h0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2012179961, "Ld/a/q0/h0/i/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57279a = new a(this);
        this.f57280b = new Object();
        this.f57281c = null;
        this.f57282d = null;
        this.f57283e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f57278f == null) {
                synchronized (d.class) {
                    if (f57278f == null) {
                        f57278f = new d();
                    }
                }
            }
            return f57278f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f57279a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        d.a.q0.h0.i.a aVar;
        d.a.q0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f57283e || (aVar = this.f57282d) == null || (bVar = aVar.f57259a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f57266c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        d.a.q0.h0.i.a aVar;
        d.a.q0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f57283e || (aVar = this.f57282d) == null || (bVar = aVar.f57260b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f57266c;
        }
        return invokeLL.floatValue;
    }

    public void n(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            o(str, i2, z, true);
        }
    }

    public final void o(String str, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f57283e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1409d(this, str, z, i2, z2));
        }
    }

    public void p(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            q(str, z, true);
        }
    }

    public final void q(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f57283e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(this, str, z, z2));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            s();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f57283e) {
            String b2 = d.a.q0.h0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f57281c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.a.q0.h0.i.a aVar = this.f57281c.get(b2);
            this.f57282d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.a.q0.h0.i.a aVar2 = this.f57282d;
            if (currentTimeMillis - aVar2.f57262d <= 3600000 || currentTimeMillis - aVar2.f57261c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f57279a);
                TbadkCoreApplication.getInst().registerReceiver(this.f57279a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f57279a);
                TbadkCoreApplication.getInst().registerReceiver(this.f57279a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f57283e) {
                return;
            }
            d.a.q0.h0.i.c.h().i(new b(this));
        }
    }
}
