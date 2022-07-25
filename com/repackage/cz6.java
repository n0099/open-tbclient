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
public class cz6 {
    public static /* synthetic */ Interceptable $ic;
    public static final cz6 k;
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
        public final /* synthetic */ cz6 a;

        public a(cz6 cz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz6Var;
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
                        jz6.a("postCallbackSuccess");
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
                        jz6.a("postCallbackError");
                        this.a.j.onLoadError(i, str);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755779854, "Lcom/repackage/cz6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755779854, "Lcom/repackage/cz6;");
                return;
            }
        }
        k = new cz6();
    }

    public cz6() {
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

    public static synchronized cz6 m() {
        InterceptResult invokeV;
        cz6 cz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (cz6.class) {
                cz6Var = k;
            }
            return cz6Var;
        }
        return (cz6) invokeV.objValue;
    }

    public synchronized DataRes k() {
        InterceptResult invokeV;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.h) {
                    o();
                }
                this.h = true;
                if (this.a != null) {
                    this.g = true;
                }
                dataRes = this.a;
            }
            return dataRes;
        }
        return (DataRes) invokeV.objValue;
    }

    public synchronized boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                this.g = true;
                if (this.i) {
                    this.i = false;
                    RecPersonalizePageModel.c f = RecPersonalizePageModel.g().f();
                    if (f != null && (this.c != 0 || this.b != null)) {
                        if (this.c == 0) {
                            jz6.a("netSuccess");
                            f.a(this.b, this.e, this.f);
                        } else {
                            jz6.a("netError");
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

    public synchronized boolean n() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                long m = yt4.k().m("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
                yt4 k2 = yt4.k();
                long m2 = k2.m("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (m2 != 0) {
                    z = Math.abs(System.currentTimeMillis() - m2) > m;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        te<byte[]> e;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                cn4.t().A();
            }
            if (n()) {
                return;
            }
            if ((vt4.q().u() && vt4.q().o() >= vt4.q().p()) || (e = cr4.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())) == null || (bArr = e.get("0")) == null || bArr.length == 0) {
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

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                RecPersonalizePageModel.g().r(new a(this));
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    o();
                    if (this.a == null) {
                        xc5 xc5Var = new xc5();
                        xc5Var.b = "";
                        xc5Var.a = 0;
                        RecPersonalizePageModel.g().o(1, 0, xc5Var, 1, 0);
                        this.i = true;
                    } else {
                        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY);
                    }
                }
            }
        }
    }

    public synchronized void q(RecPersonalizePageModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            synchronized (this) {
                this.j = cVar;
            }
        }
    }
}
