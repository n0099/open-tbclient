package com.repackage;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class th {
    public static /* synthetic */ Interceptable $ic;
    public static volatile th i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, ah> a;
    public String b;
    public sg c;
    public vh d;
    public f e;
    public ug f;
    public Handler g;
    public wh h;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(th thVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = thVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    ah ahVar = (ah) entry.getValue();
                    if (ahVar.u() > 0) {
                        this.a.y(ahVar, true, true);
                    }
                    if (ahVar.t() > 0) {
                        qh.c(ahVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(th thVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, ah ahVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {thVar, str, str2, str3, str4, action, ahVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ahVar;
            this.b = z;
            this.c = z2;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.H(0L);
                    kh.m().t(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(th thVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, ah ahVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {thVar, str, str2, str3, str4, action, ahVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ahVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.H(0L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends wb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(th thVar, String str, String str2, DiskFileOperate.Action action, ah ahVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thVar, str, str2, action, ahVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ahVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.H(getFileInfo().length());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements wh {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th a;

        public e(th thVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = thVar;
        }

        @Override // com.repackage.wh
        public void a(ah ahVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ahVar) == null) {
                if (this.a.o(ahVar)) {
                    this.a.z(ahVar);
                }
                if (this.a.m(ahVar)) {
                    this.a.u(ahVar);
                }
                if (this.a.n(ahVar)) {
                    this.a.x(ahVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th this$0;

        public f(th thVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = thVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            this.this$0.C(intent.getStringExtra("intent_data_userid"));
            this.this$0.p();
        }

        public /* synthetic */ f(th thVar, a aVar) {
            this(thVar);
        }
    }

    public th() {
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
        this.a = new ConcurrentHashMap<>();
        this.g = new a(this, Looper.getMainLooper());
        this.h = new e(this);
    }

    public static th i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (th.class) {
                    if (i == null) {
                        i = new th();
                    }
                }
            }
            return i;
        }
        return (th) invokeV.objValue;
    }

    public final void A(ah ahVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, ahVar, z) == null) || ahVar == null) {
            return;
        }
        if (uh.a(ahVar) > 20480) {
            uh.b(ahVar);
        }
        uh.c(ahVar, z);
    }

    public void B(ah ahVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ahVar) == null) || ahVar == null) {
            return;
        }
        if (ahVar.l() > 0) {
            A(ahVar, true);
        } else if (ahVar.v() > 0) {
            uh.b(ahVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.b = str;
        }
    }

    public void D(String str, String str2, String str3, String str4, rg rgVar, Object... objArr) {
        ah j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, rgVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((rgVar == null && (objArr == null || objArr.length == 0)) || (j = j(str)) == null || !hh.o().v(str, str2)) {
                return;
            }
            if (rgVar == null) {
                rgVar = new rg(str);
            }
            if (!str.equals("stat") && !str.equals("crash")) {
                rgVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
            }
            if (objArr != null && objArr.length > 0) {
                rgVar.c(objArr);
            }
            if (this.b != null && !str.equals("stat")) {
                rgVar.b("uid", this.b);
            }
            if (str3 != null && !str.equals("stat")) {
                rgVar.b("c_logid", str3);
            }
            if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                rgVar.b("seq_id", str4);
            }
            if (!str.equals("stat")) {
                rgVar.b("net", vg.a(BdBaseApplication.getInst()));
            }
            if (!str.equals("stat") && !str.equals("pfmonitor")) {
                rgVar.c("pid", Integer.valueOf(Process.myPid()));
                if (BdStatisticsManager.getInstance().isMainProcess()) {
                    rgVar.b("ismainproc", "1");
                } else {
                    rgVar.b("ismainproc", "0");
                }
            }
            if (xg.e() && xg.d(j)) {
                rgVar.d(this.f);
                j.c(rgVar);
            }
            if (hh.o().u(str, str2)) {
                j.a(rgVar);
            } else {
                j.b(rgVar);
            }
            zg.e(j, rgVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, ah> entry : this.a.entrySet()) {
                ah value = entry.getValue();
                sg sgVar = this.c;
                if (sgVar != null) {
                    long logUploadTime = sgVar.getLogUploadTime(value.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.c.setLogUploadTime(value.o(), logUploadTime);
                    }
                    value.L(logUploadTime);
                }
                if (value != null) {
                    if (value.l() > 0) {
                        A(value, false);
                    }
                    if (value.v() > 20480) {
                        uh.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        uh.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        qh.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        qh.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new vh();
            }
            this.d.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Message obtainMessage = this.g.obtainMessage();
            obtainMessage.what = 6;
            this.g.removeMessages(6);
            this.g.sendMessageDelayed(obtainMessage, 3000L);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Message obtainMessage = this.g.obtainMessage();
            obtainMessage.what = 6;
            this.g.removeMessages(6);
            this.g.sendMessage(obtainMessage);
        }
    }

    public synchronized ah j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = ah.g(str);
                ah ahVar = this.a.get(g);
                if (ahVar == null) {
                    if ("alert".equals(g)) {
                        ahVar = new nh(null);
                    } else if ("error".equals(g)) {
                        ahVar = new ph(this.h);
                    } else if ("dbg".equals(g)) {
                        ahVar = new oh(this.h);
                    } else if ("stat".equals(g)) {
                        ahVar = new sh(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        ahVar = new rh(this.h);
                    } else {
                        ahVar = new ph(this.h);
                    }
                    ahVar.I(g);
                    this.a.put(g, ahVar);
                }
                return ahVar;
            }
        }
        return (ah) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void l(ug ugVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ugVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = ugVar;
        }
    }

    public final boolean m(ah ahVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ahVar)) == null) {
            if (ahVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - ahVar.i() >= 60000;
            if (hh.o().s(ahVar.o())) {
                z = true;
            }
            if (ahVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(ah ahVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ahVar)) == null) {
            if (ahVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - ahVar.j() >= 60000;
            if (hh.o().s(ahVar.o())) {
                z = true;
            }
            if (ahVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean o(ah ahVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ahVar)) == null) {
            if (ahVar != null && xg.e() && xg.d(ahVar)) {
                boolean z = System.currentTimeMillis() - ahVar.k() >= 60000;
                if (hh.o().s(ahVar.o())) {
                    z = true;
                }
                if (ahVar.l() >= 10) {
                    return true;
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, ah> entry : this.a.entrySet()) {
                ah value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, ah> entry : this.a.entrySet()) {
                ah value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            ah j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, ah> entry : this.a.entrySet()) {
                ah value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, ah> entry : this.a.entrySet()) {
                ah value = entry.getValue();
                z(value);
                u(value);
                x(value);
            }
            if (z) {
                h();
            } else {
                g();
            }
        }
    }

    public void u(ah ahVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ahVar) == null) {
            v(ahVar, false);
        }
    }

    public final void v(ah ahVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, ahVar, z) == null) || ahVar == null) {
            return;
        }
        if (qh.b(ahVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            qh.c(ahVar, false, false, false);
        }
        qh.d(ahVar, z);
    }

    public void w(ah ahVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, ahVar) == null) || ahVar == null) {
            return;
        }
        if (ahVar.m() > 0) {
            v(ahVar, true);
        } else if (ahVar.t() > 0) {
            qh.c(ahVar, false, false, false);
        }
    }

    public void x(ah ahVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, ahVar) == null) || ahVar == null || ahVar.n() == 0) {
            return;
        }
        if (ahVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ahVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), ahVar.r(), DiskFileOperate.Action.RENAME, ahVar);
            cVar.setSdCard(ahVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            rb.f().a(cVar);
        }
        d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ahVar.s(), DiskFileOperate.Action.APPEND, ahVar);
        dVar.setSdCard(ahVar.E());
        dVar.b(ahVar.y().toString());
        ahVar.e();
        if (!ahVar.A()) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        rb.f().a(dVar);
    }

    public void y(ah ahVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{ahVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || ahVar == null || ahVar.u() <= 0) {
            return;
        }
        b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ahVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), ahVar.r(), DiskFileOperate.Action.RENAME, ahVar, z, z2);
        bVar.setSdCard(ahVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        rb.f().a(bVar);
    }

    public void z(ah ahVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ahVar) == null) {
            A(ahVar, false);
        }
    }
}
