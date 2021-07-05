package d.a.s0.h0.i;

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
import d.a.c.e.m.f;
import d.a.r0.z0.n;
import d.a.s0.h0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static d f59978f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f59979a;

    /* renamed from: b  reason: collision with root package name */
    public Object f59980b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.s0.h0.i.a> f59981c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.h0.i.a f59982d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59983e;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class b implements n<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f59984a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f59985e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f59986f;

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
                this.f59986f = bVar;
                this.f59985e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f59985e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            d.a.s0.h0.i.a a2 = d.a.s0.h0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f59963e, a2);
                            }
                        }
                    }
                    synchronized (this.f59986f.f59984a.f59980b) {
                        if (this.f59986f.f59984a.f59981c == null) {
                            this.f59986f.f59984a.f59981c = new ConcurrentHashMap();
                        }
                        this.f59986f.f59984a.f59981c.clear();
                        this.f59986f.f59984a.f59981c.putAll(hashMap);
                    }
                    this.f59986f.f59984a.f59983e = true;
                    this.f59986f.f59984a.s();
                    ArrayList<d.a.s0.h0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f59986f.f59984a.f59981c.entrySet()) {
                        if (this.f59986f.f59984a.f59982d != entry.getValue() && System.currentTimeMillis() - ((d.a.s0.h0.i.a) entry.getValue()).f59961c > 604800000) {
                            arrayList.add(entry.getValue());
                            d.a.s0.h0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (d.a.s0.h0.i.a aVar : arrayList) {
                        this.f59986f.f59984a.f59981c.remove(aVar.f59963e);
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
            this.f59984a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeHistroyDataReqIdl) == null) {
                e.i().o(new a(this, writeHistroyDataReqIdl));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59987e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f59988f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f59989g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f59990h;

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
            this.f59990h = dVar;
            this.f59987e = str;
            this.f59988f = z;
            this.f59989g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f59990h.f59982d != null) {
                    d.a.s0.h0.i.b bVar = this.f59990h.f59982d.f59959a.get(this.f59987e);
                    if (bVar == null) {
                        bVar = new d.a.s0.h0.i.b();
                        bVar.f59964a = this.f59987e;
                        this.f59990h.f59982d.f59959a.put(this.f59987e, bVar);
                    }
                    bVar.a(this.f59988f ? 1 : 0);
                    synchronized (this.f59990h.f59980b) {
                        hashMap = new HashMap(this.f59990h.f59981c);
                    }
                    d.a.s0.h0.i.c.h().j(hashMap);
                }
                if (this.f59989g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f59987e);
                    intent.putExtra("result", this.f59988f);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: d.a.s0.h0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1445d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f59992f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f59993g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f59994h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f59995i;

        public RunnableC1445d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f59995i = dVar;
            this.f59991e = str;
            this.f59992f = z;
            this.f59993g = i2;
            this.f59994h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f59995i.f59982d == null) {
                    String b2 = d.a.s0.h0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        d.a.s0.h0.i.a aVar = new d.a.s0.h0.i.a();
                        aVar.f59963e = b2;
                        this.f59995i.f59982d = aVar;
                        this.f59995i.f59981c.put(b2, aVar);
                    }
                }
                if (this.f59995i.f59982d != null) {
                    d.a.s0.h0.i.b bVar = this.f59995i.f59982d.f59959a.get(this.f59991e);
                    if (bVar == null) {
                        bVar = new d.a.s0.h0.i.b();
                        bVar.f59964a = this.f59991e;
                        this.f59995i.f59982d.f59959a.put(this.f59991e, bVar);
                    }
                    bVar.a(this.f59992f ? 1 : 0);
                    if (this.f59992f) {
                        d.a.s0.h0.i.b bVar2 = this.f59995i.f59982d.f59960b.get(this.f59991e);
                        if (bVar2 == null) {
                            bVar2 = new d.a.s0.h0.i.b();
                            bVar2.f59964a = this.f59991e;
                            this.f59995i.f59982d.f59960b.put(this.f59991e, bVar2);
                        }
                        bVar2.a(this.f59993g);
                    }
                    synchronized (this.f59995i.f59980b) {
                        hashMap = new HashMap(this.f59995i.f59981c);
                    }
                    d.a.s0.h0.i.c.h().j(hashMap);
                }
                if (this.f59994h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f59991e);
                    intent.putExtra("result", this.f59992f);
                    intent.putExtra("speed", this.f59993g);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1619152951, "Ld/a/s0/h0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1619152951, "Ld/a/s0/h0/i/d;");
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
        this.f59979a = new a(this);
        this.f59980b = new Object();
        this.f59981c = null;
        this.f59982d = null;
        this.f59983e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f59978f == null) {
                synchronized (d.class) {
                    if (f59978f == null) {
                        f59978f = new d();
                    }
                }
            }
            return f59978f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f59979a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        d.a.s0.h0.i.a aVar;
        d.a.s0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f59983e || (aVar = this.f59982d) == null || (bVar = aVar.f59959a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f59966c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        d.a.s0.h0.i.a aVar;
        d.a.s0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f59983e || (aVar = this.f59982d) == null || (bVar = aVar.f59960b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f59966c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f59983e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1445d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f59983e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f59983e) {
            String b2 = d.a.s0.h0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f59981c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.a.s0.h0.i.a aVar = this.f59981c.get(b2);
            this.f59982d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.a.s0.h0.i.a aVar2 = this.f59982d;
            if (currentTimeMillis - aVar2.f59962d <= 3600000 || currentTimeMillis - aVar2.f59961c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f59979a);
                TbadkCoreApplication.getInst().registerReceiver(this.f59979a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f59979a);
                TbadkCoreApplication.getInst().registerReceiver(this.f59979a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f59983e) {
                return;
            }
            d.a.s0.h0.i.c.h().i(new b(this));
        }
    }
}
