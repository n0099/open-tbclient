package d.a.p0.h0.i;

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
import d.a.o0.z0.n;
import d.a.p0.h0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static d f56734f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f56735a;

    /* renamed from: b  reason: collision with root package name */
    public Object f56736b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.p0.h0.i.a> f56737c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.h0.i.a f56738d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56739e;

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
        public final /* synthetic */ d f56740a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f56741e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f56742f;

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
                this.f56742f = bVar;
                this.f56741e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f56741e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            d.a.p0.h0.i.a a2 = d.a.p0.h0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f56719e, a2);
                            }
                        }
                    }
                    synchronized (this.f56742f.f56740a.f56736b) {
                        if (this.f56742f.f56740a.f56737c == null) {
                            this.f56742f.f56740a.f56737c = new ConcurrentHashMap();
                        }
                        this.f56742f.f56740a.f56737c.clear();
                        this.f56742f.f56740a.f56737c.putAll(hashMap);
                    }
                    this.f56742f.f56740a.f56739e = true;
                    this.f56742f.f56740a.s();
                    ArrayList<d.a.p0.h0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f56742f.f56740a.f56737c.entrySet()) {
                        if (this.f56742f.f56740a.f56738d != entry.getValue() && System.currentTimeMillis() - ((d.a.p0.h0.i.a) entry.getValue()).f56717c > 604800000) {
                            arrayList.add(entry.getValue());
                            d.a.p0.h0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (d.a.p0.h0.i.a aVar : arrayList) {
                        this.f56742f.f56740a.f56737c.remove(aVar.f56719e);
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
            this.f56740a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
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
        public final /* synthetic */ String f56743e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f56744f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f56745g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f56746h;

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
            this.f56746h = dVar;
            this.f56743e = str;
            this.f56744f = z;
            this.f56745g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f56746h.f56738d != null) {
                    d.a.p0.h0.i.b bVar = this.f56746h.f56738d.f56715a.get(this.f56743e);
                    if (bVar == null) {
                        bVar = new d.a.p0.h0.i.b();
                        bVar.f56720a = this.f56743e;
                        this.f56746h.f56738d.f56715a.put(this.f56743e, bVar);
                    }
                    bVar.a(this.f56744f ? 1 : 0);
                    synchronized (this.f56746h.f56736b) {
                        hashMap = new HashMap(this.f56746h.f56737c);
                    }
                    d.a.p0.h0.i.c.h().j(hashMap);
                }
                if (this.f56745g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f56743e);
                    intent.putExtra("result", this.f56744f);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: d.a.p0.h0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1400d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f56747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f56748f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f56749g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f56750h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f56751i;

        public RunnableC1400d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f56751i = dVar;
            this.f56747e = str;
            this.f56748f = z;
            this.f56749g = i2;
            this.f56750h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f56751i.f56738d == null) {
                    String b2 = d.a.p0.h0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        d.a.p0.h0.i.a aVar = new d.a.p0.h0.i.a();
                        aVar.f56719e = b2;
                        this.f56751i.f56738d = aVar;
                        this.f56751i.f56737c.put(b2, aVar);
                    }
                }
                if (this.f56751i.f56738d != null) {
                    d.a.p0.h0.i.b bVar = this.f56751i.f56738d.f56715a.get(this.f56747e);
                    if (bVar == null) {
                        bVar = new d.a.p0.h0.i.b();
                        bVar.f56720a = this.f56747e;
                        this.f56751i.f56738d.f56715a.put(this.f56747e, bVar);
                    }
                    bVar.a(this.f56748f ? 1 : 0);
                    if (this.f56748f) {
                        d.a.p0.h0.i.b bVar2 = this.f56751i.f56738d.f56716b.get(this.f56747e);
                        if (bVar2 == null) {
                            bVar2 = new d.a.p0.h0.i.b();
                            bVar2.f56720a = this.f56747e;
                            this.f56751i.f56738d.f56716b.put(this.f56747e, bVar2);
                        }
                        bVar2.a(this.f56749g);
                    }
                    synchronized (this.f56751i.f56736b) {
                        hashMap = new HashMap(this.f56751i.f56737c);
                    }
                    d.a.p0.h0.i.c.h().j(hashMap);
                }
                if (this.f56750h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f56747e);
                    intent.putExtra("result", this.f56748f);
                    intent.putExtra("speed", this.f56749g);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2086273830, "Ld/a/p0/h0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2086273830, "Ld/a/p0/h0/i/d;");
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
        this.f56735a = new a(this);
        this.f56736b = new Object();
        this.f56737c = null;
        this.f56738d = null;
        this.f56739e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f56734f == null) {
                synchronized (d.class) {
                    if (f56734f == null) {
                        f56734f = new d();
                    }
                }
            }
            return f56734f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f56735a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        d.a.p0.h0.i.a aVar;
        d.a.p0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f56739e || (aVar = this.f56738d) == null || (bVar = aVar.f56715a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f56722c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        d.a.p0.h0.i.a aVar;
        d.a.p0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f56739e || (aVar = this.f56738d) == null || (bVar = aVar.f56716b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f56722c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f56739e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1400d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f56739e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f56739e) {
            String b2 = d.a.p0.h0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f56737c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.a.p0.h0.i.a aVar = this.f56737c.get(b2);
            this.f56738d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.a.p0.h0.i.a aVar2 = this.f56738d;
            if (currentTimeMillis - aVar2.f56718d <= 3600000 || currentTimeMillis - aVar2.f56717c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f56735a);
                TbadkCoreApplication.getInst().registerReceiver(this.f56735a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f56735a);
                TbadkCoreApplication.getInst().registerReceiver(this.f56735a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f56739e) {
                return;
            }
            d.a.p0.h0.i.c.h().i(new b(this));
        }
    }
}
