package d.a.d.e.n.o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile g f41908i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, d.a.d.e.n.j.a> f41909a;

    /* renamed from: b  reason: collision with root package name */
    public String f41910b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.d.e.n.b f41911c;

    /* renamed from: d  reason: collision with root package name */
    public i f41912d;

    /* renamed from: e  reason: collision with root package name */
    public f f41913e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.e.n.d f41914f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f41915g;

    /* renamed from: h  reason: collision with root package name */
    public j f41916h;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f41917a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41917a = gVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.f41917a.f41909a.entrySet()) {
                    d.a.d.e.n.j.a aVar = (d.a.d.e.n.j.a) entry.getValue();
                    if (aVar.u() > 0) {
                        this.f41917a.x(aVar, true, true);
                    }
                    if (aVar.t() > 0) {
                        d.a.d.e.n.o.d.c(aVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d.e.n.j.a f41918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f41919b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f41920c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.a.d.e.n.j.a aVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {gVar, str, str2, str3, str4, action, aVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41918a = aVar;
            this.f41919b = z;
            this.f41920c = z2;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f41918a.H(0L);
                    d.a.d.e.n.n.b.m().r(this.f41918a, this.f41919b, true, this.f41920c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d.e.n.j.a f41921a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.a.d.e.n.j.a aVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {gVar, str, str2, str3, str4, action, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41921a = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f41921a.H(0L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.d.e.a.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.d.e.n.j.a f41922c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g gVar, String str, String str2, DiskFileOperate.Action action, d.a.d.e.n.j.a aVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, str2, action, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41922c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f41922c.H(getFileInfo().length());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f41923a;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41923a = gVar;
        }

        @Override // d.a.d.e.n.o.j
        public void a(d.a.d.e.n.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f41923a.n(aVar)) {
                    this.f41923a.y(aVar);
                }
                if (this.f41923a.l(aVar)) {
                    this.f41923a.t(aVar);
                }
                if (this.f41923a.m(aVar)) {
                    this.f41923a.w(aVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g this$0;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            this.this$0.B(intent.getStringExtra("intent_data_userid"));
            this.this$0.o();
        }

        public /* synthetic */ f(g gVar, a aVar) {
            this(gVar);
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41909a = new ConcurrentHashMap<>();
        this.f41915g = new a(this, Looper.getMainLooper());
        this.f41916h = new e(this);
    }

    public static g h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f41908i == null) {
                synchronized (g.class) {
                    if (f41908i == null) {
                        f41908i = new g();
                    }
                }
            }
            return f41908i;
        }
        return (g) invokeV.objValue;
    }

    public void A(d.a.d.e.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.l() > 0) {
            z(aVar, true);
        } else if (aVar.v() > 0) {
            h.b(aVar);
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f41910b = str;
        }
    }

    public void C(String str, String str2, String str3, String str4, d.a.d.e.n.a aVar, Object... objArr) {
        d.a.d.e.n.j.a i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, aVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((aVar == null && (objArr == null || objArr.length == 0)) || (i2 = i(str)) == null || !d.a.d.e.n.m.a.o().v(str, str2)) {
                return;
            }
            if (aVar == null) {
                aVar = new d.a.d.e.n.a(str);
            }
            if (!str.equals("stat") && !str.equals("crash")) {
                aVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
            }
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
            }
            if (this.f41910b != null && !str.equals("stat")) {
                aVar.b("uid", this.f41910b);
            }
            if (str3 != null && !str.equals("stat")) {
                aVar.b("c_logid", str3);
            }
            if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                aVar.b("seq_id", str4);
            }
            if (!str.equals("stat")) {
                aVar.b("net", d.a.d.e.n.e.a(BdBaseApplication.getInst()));
            }
            if (!str.equals("stat") && !str.equals("pfmonitor")) {
                aVar.c("pid", Integer.valueOf(Process.myPid()));
                if (BdStatisticsManager.getInstance().isMainProcess()) {
                    aVar.b("ismainproc", "1");
                } else {
                    aVar.b("ismainproc", "0");
                }
            }
            if (d.a.d.e.n.g.e() && d.a.d.e.n.g.d(i2)) {
                aVar.d(this.f41914f);
                i2.c(aVar);
            }
            if (d.a.d.e.n.m.a.o().u(str, str2)) {
                i2.a(aVar);
            } else {
                i2.b(aVar);
            }
            d.a.d.e.n.i.e(i2, aVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (Map.Entry<String, d.a.d.e.n.j.a> entry : this.f41909a.entrySet()) {
                d.a.d.e.n.j.a value = entry.getValue();
                d.a.d.e.n.b bVar = this.f41911c;
                if (bVar != null) {
                    long logUploadTime = bVar.getLogUploadTime(value.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.f41911c.setLogUploadTime(value.o(), logUploadTime);
                    }
                    value.L(logUploadTime);
                }
                if (value != null) {
                    if (value.l() > 0) {
                        z(value, false);
                    }
                    if (value.v() > 20480) {
                        h.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        h.b(value);
                    }
                    if (value.m() > 0) {
                        u(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        d.a.d.e.n.o.d.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        d.a.d.e.n.o.d.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f41912d == null) {
                this.f41912d = new i();
            }
            this.f41912d.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Message obtainMessage = this.f41915g.obtainMessage();
            obtainMessage.what = 6;
            this.f41915g.removeMessages(6);
            this.f41915g.sendMessageDelayed(obtainMessage, 3000L);
        }
    }

    public synchronized d.a.d.e.n.j.a i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g2 = d.a.d.e.n.j.a.g(str);
                d.a.d.e.n.j.a aVar = this.f41909a.get(g2);
                if (aVar == null) {
                    if ("alert".equals(g2)) {
                        aVar = new d.a.d.e.n.o.a(null);
                    } else if ("error".equals(g2)) {
                        aVar = new d.a.d.e.n.o.c(this.f41916h);
                    } else if ("dbg".equals(g2)) {
                        aVar = new d.a.d.e.n.o.b(this.f41916h);
                    } else if ("stat".equals(g2)) {
                        aVar = new d.a.d.e.n.o.f(this.f41916h);
                    } else if ("pfmonitor".equals(g2)) {
                        aVar = new d.a.d.e.n.o.e(this.f41916h);
                    } else {
                        aVar = new d.a.d.e.n.o.c(this.f41916h);
                    }
                    aVar.I(g2);
                    this.f41909a.put(g2, aVar);
                }
                return aVar;
            }
        }
        return (d.a.d.e.n.j.a) invokeL.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41910b : (String) invokeV.objValue;
    }

    public void k(d.a.d.e.n.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            if (this.f41913e == null) {
                this.f41913e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f41913e, intentFilter);
            }
            this.f41911c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f41914f = dVar;
        }
    }

    public final boolean l(d.a.d.e.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - aVar.i() >= 60000;
            if (d.a.d.e.n.m.a.o().s(aVar.o())) {
                z = true;
            }
            if (aVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean m(d.a.d.e.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - aVar.j() >= 60000;
            if (d.a.d.e.n.m.a.o().s(aVar.o())) {
                z = true;
            }
            if (aVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(d.a.d.e.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aVar)) == null) {
            if (aVar != null && d.a.d.e.n.g.e() && d.a.d.e.n.g.d(aVar)) {
                boolean z = System.currentTimeMillis() - aVar.k() >= 60000;
                if (d.a.d.e.n.m.a.o().s(aVar.o())) {
                    z = true;
                }
                if (aVar.l() >= 10) {
                    return true;
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (Map.Entry<String, d.a.d.e.n.j.a> entry : this.f41909a.entrySet()) {
                d.a.d.e.n.j.a value = entry.getValue();
                y(value);
                t(value);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (Map.Entry<String, d.a.d.e.n.j.a> entry : this.f41909a.entrySet()) {
                d.a.d.e.n.j.a value = entry.getValue();
                A(value);
                v(value);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            d.a.d.e.n.j.a i2 = h().i(str);
            A(i2);
            x(i2, false, true);
            v(i2);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, d.a.d.e.n.j.a> entry : this.f41909a.entrySet()) {
                d.a.d.e.n.j.a value = entry.getValue();
                A(value);
                x(value, false, false);
                v(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (Map.Entry<String, d.a.d.e.n.j.a> entry : this.f41909a.entrySet()) {
                d.a.d.e.n.j.a value = entry.getValue();
                y(value);
                t(value);
                w(value);
            }
            g();
        }
    }

    public void t(d.a.d.e.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            u(aVar, false);
        }
    }

    public final void u(d.a.d.e.n.j.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048594, this, aVar, z) == null) || aVar == null) {
            return;
        }
        if (d.a.d.e.n.o.d.b(aVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            d.a.d.e.n.o.d.c(aVar, false, false, false);
        }
        d.a.d.e.n.o.d.d(aVar, z);
    }

    public void v(d.a.d.e.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.m() > 0) {
            u(aVar, true);
        } else if (aVar.t() > 0) {
            d.a.d.e.n.o.d.c(aVar, false, false, false);
        }
    }

    public void w(d.a.d.e.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || aVar == null || aVar.n() == 0) {
            return;
        }
        if (aVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar);
            cVar.setSdCard(aVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            d.a.d.e.a.d.g().a(cVar);
        }
        d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), DiskFileOperate.Action.APPEND, aVar);
        dVar.setSdCard(aVar.E());
        dVar.b(aVar.y().toString());
        aVar.e();
        if (!aVar.A()) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        d.a.d.e.a.d.g().a(dVar);
    }

    public void x(d.a.d.e.n.j.a aVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || aVar == null || aVar.u() <= 0) {
            return;
        }
        b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar, z, z2);
        bVar.setSdCard(aVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.a.d.e.a.d.g().a(bVar);
    }

    public void y(d.a.d.e.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            z(aVar, false);
        }
    }

    public final void z(d.a.d.e.n.j.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, aVar, z) == null) || aVar == null) {
            return;
        }
        if (h.a(aVar) > 20480) {
            h.b(aVar);
        }
        h.c(aVar, z);
    }
}
