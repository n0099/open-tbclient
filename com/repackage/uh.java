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
public class uh {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uh i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, bh> a;
    public String b;
    public tg c;
    public wh d;
    public f e;
    public vg f;
    public Handler g;
    public xh h;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(uh uhVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhVar, looper};
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
            this.a = uhVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    bh bhVar = (bh) entry.getValue();
                    if (bhVar.u() > 0) {
                        this.a.y(bhVar, true, true);
                    }
                    if (bhVar.t() > 0) {
                        rh.c(bhVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(uh uhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, bh bhVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {uhVar, str, str2, str3, str4, action, bhVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = bhVar;
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
                    lh.m().t(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(uh uhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, bh bhVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {uhVar, str, str2, str3, str4, action, bhVar};
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
            this.a = bhVar;
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
        public final /* synthetic */ bh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(uh uhVar, String str, String str2, DiskFileOperate.Action action, bh bhVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhVar, str, str2, action, bhVar};
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
            this.c = bhVar;
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
    public class e implements xh {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh a;

        public e(uh uhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uhVar;
        }

        @Override // com.repackage.xh
        public void a(bh bhVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bhVar) == null) {
                if (this.a.o(bhVar)) {
                    this.a.z(bhVar);
                }
                if (this.a.m(bhVar)) {
                    this.a.u(bhVar);
                }
                if (this.a.n(bhVar)) {
                    this.a.x(bhVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh this$0;

        public f(uh uhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = uhVar;
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

        public /* synthetic */ f(uh uhVar, a aVar) {
            this(uhVar);
        }
    }

    public uh() {
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

    public static uh i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (uh.class) {
                    if (i == null) {
                        i = new uh();
                    }
                }
            }
            return i;
        }
        return (uh) invokeV.objValue;
    }

    public final void A(bh bhVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bhVar, z) == null) || bhVar == null) {
            return;
        }
        if (vh.a(bhVar) > 20480) {
            vh.b(bhVar);
        }
        vh.c(bhVar, z);
    }

    public void B(bh bhVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bhVar) == null) || bhVar == null) {
            return;
        }
        if (bhVar.l() > 0) {
            A(bhVar, true);
        } else if (bhVar.v() > 0) {
            vh.b(bhVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.b = str;
        }
    }

    public void D(String str, String str2, String str3, String str4, sg sgVar, Object... objArr) {
        bh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, sgVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((sgVar == null && (objArr == null || objArr.length == 0)) || (j = j(str)) == null || !ih.o().v(str, str2)) {
                return;
            }
            if (sgVar == null) {
                sgVar = new sg(str);
            }
            if (!str.equals("stat") && !str.equals("crash")) {
                sgVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
            }
            if (objArr != null && objArr.length > 0) {
                sgVar.c(objArr);
            }
            if (this.b != null && !str.equals("stat")) {
                sgVar.b("uid", this.b);
            }
            if (str3 != null && !str.equals("stat")) {
                sgVar.b("c_logid", str3);
            }
            if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                sgVar.b("seq_id", str4);
            }
            if (!str.equals("stat")) {
                sgVar.b("net", wg.a(BdBaseApplication.getInst()));
            }
            if (!str.equals("stat") && !str.equals("pfmonitor")) {
                sgVar.c("pid", Integer.valueOf(Process.myPid()));
                if (BdStatisticsManager.getInstance().isMainProcess()) {
                    sgVar.b("ismainproc", "1");
                } else {
                    sgVar.b("ismainproc", "0");
                }
            }
            if (yg.e() && yg.d(j)) {
                sgVar.d(this.f);
                j.c(sgVar);
            }
            if (ih.o().u(str, str2)) {
                j.a(sgVar);
            } else {
                j.b(sgVar);
            }
            ah.e(j, sgVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, bh> entry : this.a.entrySet()) {
                bh value = entry.getValue();
                tg tgVar = this.c;
                if (tgVar != null) {
                    long logUploadTime = tgVar.getLogUploadTime(value.o());
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
                        vh.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        vh.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        rh.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        rh.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new wh();
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

    public synchronized bh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = bh.g(str);
                bh bhVar = this.a.get(g);
                if (bhVar == null) {
                    if ("alert".equals(g)) {
                        bhVar = new oh(null);
                    } else if ("error".equals(g)) {
                        bhVar = new qh(this.h);
                    } else if ("dbg".equals(g)) {
                        bhVar = new ph(this.h);
                    } else if ("stat".equals(g)) {
                        bhVar = new th(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        bhVar = new sh(this.h);
                    } else {
                        bhVar = new qh(this.h);
                    }
                    bhVar.I(g);
                    this.a.put(g, bhVar);
                }
                return bhVar;
            }
        }
        return (bh) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void l(vg vgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vgVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = vgVar;
        }
    }

    public final boolean m(bh bhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bhVar)) == null) {
            if (bhVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - bhVar.i() >= 60000;
            if (ih.o().s(bhVar.o())) {
                z = true;
            }
            if (bhVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(bh bhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bhVar)) == null) {
            if (bhVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - bhVar.j() >= 60000;
            if (ih.o().s(bhVar.o())) {
                z = true;
            }
            if (bhVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean o(bh bhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bhVar)) == null) {
            if (bhVar != null && yg.e() && yg.d(bhVar)) {
                boolean z = System.currentTimeMillis() - bhVar.k() >= 60000;
                if (ih.o().s(bhVar.o())) {
                    z = true;
                }
                if (bhVar.l() >= 10) {
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
            for (Map.Entry<String, bh> entry : this.a.entrySet()) {
                bh value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, bh> entry : this.a.entrySet()) {
                bh value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            bh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, bh> entry : this.a.entrySet()) {
                bh value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, bh> entry : this.a.entrySet()) {
                bh value = entry.getValue();
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

    public void u(bh bhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bhVar) == null) {
            v(bhVar, false);
        }
    }

    public final void v(bh bhVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, bhVar, z) == null) || bhVar == null) {
            return;
        }
        if (rh.b(bhVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            rh.c(bhVar, false, false, false);
        }
        rh.d(bhVar, z);
    }

    public void w(bh bhVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bhVar) == null) || bhVar == null) {
            return;
        }
        if (bhVar.m() > 0) {
            v(bhVar, true);
        } else if (bhVar.t() > 0) {
            rh.c(bhVar, false, false, false);
        }
    }

    public void x(bh bhVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, bhVar) == null) || bhVar == null || bhVar.n() == 0) {
            return;
        }
        if (bhVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), bhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), bhVar.r(), DiskFileOperate.Action.RENAME, bhVar);
            cVar.setSdCard(bhVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            rb.f().a(cVar);
        }
        d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), bhVar.s(), DiskFileOperate.Action.APPEND, bhVar);
        dVar.setSdCard(bhVar.E());
        dVar.b(bhVar.y().toString());
        bhVar.e();
        if (!bhVar.A()) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        rb.f().a(dVar);
    }

    public void y(bh bhVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{bhVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || bhVar == null || bhVar.u() <= 0) {
            return;
        }
        b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), bhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), bhVar.r(), DiskFileOperate.Action.RENAME, bhVar, z, z2);
        bVar.setSdCard(bhVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        rb.f().a(bVar);
    }

    public void z(bh bhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bhVar) == null) {
            A(bhVar, false);
        }
    }
}
