package com.repackage;

import android.os.Looper;
import android.os.MessageQueue;
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
import java.lang.ref.WeakReference;
import tbclient.Personalized.DataRes;
/* loaded from: classes5.dex */
public class b07 {
    public static /* synthetic */ Interceptable $ic;
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
    public volatile WeakReference<RecPersonalizePageModel.c> j;

    /* loaded from: classes5.dex */
    public class a implements RecPersonalizePageModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b07 a;

        public a(b07 b07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b07Var;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                synchronized (this.a) {
                    if (this.a.j == null || this.a.g) {
                        this.a.b = dataRes;
                        this.a.e = z;
                        this.a.f = z2;
                    } else {
                        this.a.i = false;
                        RecPersonalizePageModel.c cVar = (RecPersonalizePageModel.c) this.a.j.get();
                        if (cVar != null) {
                            cVar.a(dataRes, z, z2);
                        }
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
                    if (this.a.j == null || this.a.g) {
                        this.a.c = i;
                        this.a.d = str;
                    } else {
                        this.a.i = false;
                        RecPersonalizePageModel.c cVar = (RecPersonalizePageModel.c) this.a.j.get();
                        if (cVar != null) {
                            cVar.onLoadError(i, str);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ b07 b;

        public b(b07 b07Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b07Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b07Var;
            this.a = runnable;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                } catch (Exception e) {
                    BdLog.e(e);
                }
                if (this.b.i) {
                    this.a.run();
                    return false;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755880728, "Lcom/repackage/b07;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755880728, "Lcom/repackage/b07;");
        }
    }

    public b07() {
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

    public synchronized DataRes j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.h) {
                    n();
                }
                this.h = true;
                DataRes dataRes = this.a;
                if (!MainTabDataSwitch.isCacheOpen() || this.b == null) {
                    return this.a;
                }
                return null;
            }
        }
        return (DataRes) invokeV.objValue;
    }

    public synchronized boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                this.g = false;
                if (this.i) {
                    if (this.j != null && (this.c != 0 || this.b != null)) {
                        if (this.c == 0) {
                            this.i = false;
                            RecPersonalizePageModel.c cVar = this.j.get();
                            if (cVar != null) {
                                cVar.a(this.b, this.e, this.f);
                            }
                        } else {
                            this.i = false;
                            RecPersonalizePageModel.c cVar2 = this.j.get();
                            if (cVar2 != null) {
                                cVar2.onLoadError(this.c, this.d);
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public RecPersonalizePageModel.c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j == null) {
                return null;
            }
            return this.j.get();
        }
        return (RecPersonalizePageModel.c) invokeV.objValue;
    }

    public synchronized boolean m() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                long m = vt4.k().m("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
                vt4 k = vt4.k();
                long m2 = k.m("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (m2 != 0) {
                    z = Math.abs(System.currentTimeMillis() - m2) > m;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        qe<byte[]> e;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                dn4.t().A();
            }
            if (!m() || MainTabDataSwitch.isCacheOpen()) {
                if ((st4.q().u() && st4.q().o() >= st4.q().p()) || (e = br4.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())) == null || (bArr = e.get("0")) == null || bArr.length == 0) {
                    return;
                }
                try {
                    DataRes dataRes = (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    if (dataRes == null || dataRes.thread_list == null || dataRes.thread_list.size() <= 0) {
                        return;
                    }
                    this.a = dataRes;
                } catch (IOException e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    public synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                RecPersonalizePageModel.g().q(new a(this));
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    n();
                    if (this.a != null && (!MainTabDataSwitch.isCacheOpen() || !m())) {
                        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY);
                    }
                    vb5 vb5Var = new vb5();
                    vb5Var.b = "";
                    vb5Var.a = 0;
                    RecPersonalizePageModel.g().n(1, 0, vb5Var, 1, 0);
                    this.i = true;
                }
            }
        }
    }

    public synchronized void p(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            synchronized (this) {
                boolean m = m();
                if (MainTabDataSwitch.isCacheOpen() && m) {
                    this.g = true;
                    Looper.myQueue().addIdleHandler(new b(this, runnable));
                }
            }
        }
    }

    public synchronized void q(RecPersonalizePageModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            synchronized (this) {
                this.j = new WeakReference<>(cVar);
            }
        }
    }
}
