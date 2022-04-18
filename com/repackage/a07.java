package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.MainTabDataSwitch;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* loaded from: classes5.dex */
public class a07 {
    public static /* synthetic */ Interceptable $ic;
    public static final a07 k;
    public static final b07 l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile DataRes a;
    public volatile DataRes b;
    public volatile int c;
    public volatile String d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public volatile boolean i;
    public volatile RecPersonalizePageModel.c j;

    /* loaded from: classes5.dex */
    public class a implements RecPersonalizePageModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public a(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                synchronized (this.a) {
                    this.a.b = dataRes;
                    this.a.e = z;
                    this.a.f = z2;
                    if (this.a.g && this.a.j != null) {
                        g07.a("postCallbackSuccess");
                        this.a.j.a(this.a.b, this.a.e, this.a.f);
                    }
                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                synchronized (this.a) {
                    this.a.c = i;
                    this.a.d = str;
                    if (this.a.g && this.a.j != null) {
                        g07.a("postCallbackError");
                        this.a.j.onLoadError(i, str);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755910519, "Lcom/repackage/a07;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755910519, "Lcom/repackage/a07;");
                return;
            }
        }
        k = new a07();
        l = new b07();
    }

    public a07() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.g = false;
        this.h = false;
        this.i = false;
    }

    public static synchronized a07 n() {
        InterceptResult invokeV;
        a07 a07Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (a07.class) {
                a07Var = k;
            }
            return a07Var;
        }
        return (a07) invokeV.objValue;
    }

    public synchronized DataRes k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    return l.j();
                }
                if (this.h) {
                    p();
                }
                this.h = true;
                if (this.a != null) {
                    this.g = true;
                }
                return this.a;
            }
        }
        return (DataRes) invokeV.objValue;
    }

    public synchronized boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    return l.k();
                }
                this.g = true;
                if (this.i) {
                    this.i = false;
                    RecPersonalizePageModel.c f = RecPersonalizePageModel.g().f();
                    if (f != null && (this.c != 0 || this.b != null)) {
                        if (this.c == 0) {
                            g07.a("netSuccess");
                            f.a(this.b, this.e, this.f);
                        } else {
                            g07.a("netError");
                            f.onLoadError(this.c, this.d);
                        }
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized RecPersonalizePageModel.c m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    return l.l();
                }
                return this.j;
            }
        }
        return (RecPersonalizePageModel.c) invokeV.objValue;
    }

    public synchronized boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    return l.m();
                }
                long m = vt4.k().m("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
                vt4 k2 = vt4.k();
                long m2 = k2.m("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
                return m2 == 0 || Math.abs(System.currentTimeMillis() - m2) > m;
            }
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        qe<byte[]> e;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                dn4.t().A();
            }
            if (!o() || MainTabDataSwitch.isCacheOpen()) {
                if ((st4.q().u() && st4.q().o() >= st4.q().p()) || (e = br4.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())) == null || (bArr = e.get("0")) == null || bArr.length == 0) {
                    return;
                }
                try {
                    DataRes dataRes = (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    if (dataRes != null && dataRes.thread_list != null && dataRes.thread_list.size() > 0) {
                        this.a = dataRes;
                    }
                } catch (IOException e2) {
                    BdLog.e(e2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921687, null));
            }
        }
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    l.o();
                    return;
                }
                RecPersonalizePageModel.g().q(new a(this));
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    p();
                    if (this.a == null) {
                        if (MainTabDataSwitch.isPrefetchOpen()) {
                            vb5 vb5Var = new vb5();
                            vb5Var.b = "";
                            vb5Var.a = 0;
                            RecPersonalizePageModel.g().n(1, 0, vb5Var, 1, 0);
                            this.i = true;
                        }
                    } else {
                        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY);
                    }
                }
            }
        }
    }

    public synchronized void r(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            synchronized (this) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    l.p(runnable);
                }
            }
        }
    }

    public synchronized void s(RecPersonalizePageModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            synchronized (this) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    l.q(cVar);
                } else {
                    this.j = cVar;
                }
            }
        }
    }
}
