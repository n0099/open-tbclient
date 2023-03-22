package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.g.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String i = "c";
    public static final ExecutorService j;
    public static AtomicInteger k;
    public transient /* synthetic */ FieldHolder $fh;
    public GrsBaseInfo a;
    public Context b;
    public h c;
    public com.huawei.hms.framework.network.grs.e.a d;
    public com.huawei.hms.framework.network.grs.e.c e;
    public com.huawei.hms.framework.network.grs.e.c f;
    public com.huawei.hms.framework.network.grs.a g;
    public FutureTask<Boolean> h;

    /* loaded from: classes8.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ GrsBaseInfo b;
        public final /* synthetic */ c c;

        public a(c cVar, Context context, GrsBaseInfo grsBaseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, grsBaseInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cVar;
            this.a = context;
            this.b = grsBaseInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.c.c = new h();
                c cVar = this.c;
                Context context = this.a;
                cVar.e = new com.huawei.hms.framework.network.grs.e.c(context, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
                c cVar2 = this.c;
                Context context2 = this.a;
                cVar2.f = new com.huawei.hms.framework.network.grs.e.c(context2, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
                c cVar3 = this.c;
                cVar3.d = new com.huawei.hms.framework.network.grs.e.a(cVar3.e, this.c.f, this.c.c);
                c cVar4 = this.c;
                cVar4.g = new com.huawei.hms.framework.network.grs.a(cVar4.a, this.c.d, this.c.c, this.c.f);
                if (c.k.incrementAndGet() <= 2 || com.huawei.hms.framework.network.grs.f.b.a(this.a.getPackageName(), this.c.a) == null) {
                    new com.huawei.hms.framework.network.grs.f.b(this.a, this.b, true).a(this.b);
                }
                String c = new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a).c();
                String str = c.i;
                Logger.v(str, "scan serviceSet is:" + c);
                String a = this.c.f.a("services", "");
                String a2 = i.a(a, c);
                if (!TextUtils.isEmpty(a2)) {
                    this.c.f.b("services", a2);
                    String str2 = c.i;
                    Logger.i(str2, "postList is:" + StringUtils.anonymizeMessage(a2));
                    String str3 = c.i;
                    Logger.i(str3, "currentServices:" + StringUtils.anonymizeMessage(a));
                    if (!a2.equals(a)) {
                        this.c.c.a(this.c.a.getGrsParasKey(true, true, this.a));
                        this.c.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a), (String) null, this.c.f);
                    }
                }
                c cVar5 = this.c;
                cVar5.a(cVar5.e.a());
                this.c.d.b(this.b, this.a);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-6723424, "Lcom/huawei/hms/framework/network/grs/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-6723424, "Lcom/huawei/hms/framework/network/grs/c;");
                return;
            }
        }
        j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
        k = new AtomicInteger(0);
    }

    public c(Context context, GrsBaseInfo grsBaseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, grsBaseInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = null;
        this.b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this, this.b, grsBaseInfo2));
        this.h = futureTask;
        j.execute(futureTask);
        Logger.i(i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    public c(GrsBaseInfo grsBaseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {grsBaseInfo};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = null;
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, grsBaseInfo) == null) {
            try {
                this.a = grsBaseInfo.m90clone();
            } catch (CloneNotSupportedException e) {
                Logger.w(i, "GrsClient catch CloneNotSupportedException", e);
                this.a = grsBaseInfo.copy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, map) == null) {
            if (map == null || map.isEmpty()) {
                Logger.v(i, "sp's content is empty.");
                return;
            }
            for (String str : map.keySet()) {
                if (str.endsWith("time")) {
                    String a2 = this.e.a(str, "");
                    long j2 = 0;
                    if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
                        try {
                            j2 = Long.parseLong(a2);
                        } catch (NumberFormatException e) {
                            Logger.w(i, "convert expire time from String to Long catch NumberFormatException.", e);
                        }
                    }
                    if (!a(j2)) {
                        Logger.i(i, "init interface auto clear some invalid sp's data.");
                        String substring = str.substring(0, str.length() - 4);
                        this.e.a(substring);
                        this.e.a(str);
                        this.e.a(substring + Headers.ETAG);
                    }
                }
            }
        }
    }

    private boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65547, this, j2)) == null) ? System.currentTimeMillis() - j2 <= 604800000 : invokeJ.booleanValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            FutureTask<Boolean> futureTask = this.h;
            if (futureTask == null) {
                return false;
            }
            try {
                return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
            } catch (InterruptedException e) {
                e = e;
                str = i;
                str2 = "init compute task interrupted.";
                Logger.w(str, str2, e);
                return false;
            } catch (CancellationException unused) {
                Logger.i(i, "init compute task canceled.");
                return false;
            } catch (ExecutionException e2) {
                e = e2;
                str = i;
                str2 = "init compute task failed.";
                Logger.w(str, str2, e);
                return false;
            } catch (TimeoutException unused2) {
                Logger.w(i, "init compute task timed out");
                return false;
            } catch (Exception e3) {
                e = e3;
                str = i;
                str2 = "init compute task occur unknown Exception";
                Logger.w(str, str2, e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.a == null || str == null || str2 == null) {
                Logger.w(i, "invalid para!");
                return null;
            } else if (e()) {
                return this.g.a(str, str2, this.b);
            } else {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public Map<String, String> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a != null && str != null) {
                return e() ? this.g.a(str, this.b) : new HashMap();
            }
            Logger.w(i, "invalid para!");
            return new HashMap();
        }
        return (Map) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && e()) {
            String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
            this.e.a(grsParasKey);
            com.huawei.hms.framework.network.grs.e.c cVar = this.e;
            cVar.a(grsParasKey + "time");
            com.huawei.hms.framework.network.grs.e.c cVar2 = this.e;
            cVar2.a(grsParasKey + Headers.ETAG);
            this.c.a(grsParasKey);
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, iQueryUrlsCallBack) == null) {
            if (iQueryUrlsCallBack == null) {
                Logger.w(i, "IQueryUrlsCallBack is must not null for process continue.");
            } else if (this.a == null || str == null) {
                iQueryUrlsCallBack.onCallBackFail(-6);
            } else if (e()) {
                this.g.a(str, iQueryUrlsCallBack, this.b);
            } else {
                Logger.i(i, "grs init task has not completed.");
                iQueryUrlsCallBack.onCallBackFail(-7);
            }
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, iQueryUrlCallBack) == null) {
            if (iQueryUrlCallBack == null) {
                Logger.w(i, "IQueryUrlCallBack is must not null for process continue.");
            } else if (this.a == null || str == null || str2 == null) {
                iQueryUrlCallBack.onCallBackFail(-6);
            } else if (e()) {
                this.g.a(str, str2, iQueryUrlCallBack, this.b);
            } else {
                Logger.i(i, "grs init task has not completed.");
                iQueryUrlCallBack.onCallBackFail(-7);
            }
        }
    }

    public boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
                return this.a.compare(((c) obj).a);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        GrsBaseInfo grsBaseInfo;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!e() || (grsBaseInfo = this.a) == null || (context = this.b) == null) {
                return false;
            }
            this.d.a(grsBaseInfo, context);
            return true;
        }
        return invokeV.booleanValue;
    }
}
