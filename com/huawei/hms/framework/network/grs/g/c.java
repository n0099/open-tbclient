package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String n = "c";
    public transient /* synthetic */ FieldHolder $fh;
    public final GrsBaseInfo a;
    public final Context b;
    public final com.huawei.hms.framework.network.grs.e.a c;
    public d d;
    public final Map<String, Future<d>> e;
    public final List<d> f;
    public final JSONArray g;
    public final List<String> h;
    public final List<String> i;
    public final com.huawei.hms.framework.network.grs.g.k.c j;
    public com.huawei.hms.framework.network.grs.g.k.d k;
    public String l;
    public long m;

    /* loaded from: classes10.dex */
    public class a implements Callable<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExecutorService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;
        public final /* synthetic */ c d;

        public a(c cVar, ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, executorService, str, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cVar;
            this.a = executorService;
            this.b = str;
            this.c = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d.b(this.a, this.b, this.c) : (d) invokeV.objValue;
        }
    }

    public c(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ConcurrentHashMap(16);
        this.f = new CopyOnWriteArrayList();
        this.g = new JSONArray();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.l = "";
        this.m = 1L;
        this.j = cVar;
        this.a = cVar.b();
        this.b = cVar.a();
        this.c = aVar;
        c();
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009d A[LOOP:0: B:5:0x000a->B:35:0x009d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private d a(ExecutorService executorService, List<String> list, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        InterceptResult invokeLLLL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, executorService, list, str, cVar)) == null) {
            d dVar2 = null;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                String str2 = list.get(i);
                boolean z = true;
                if (!TextUtils.isEmpty(str2)) {
                    Future<d> submit = executorService.submit(new com.huawei.hms.framework.network.grs.g.a(str2, i, this, this.b, str, this.a, cVar).g());
                    this.e.put(str2, submit);
                    try {
                        dVar = submit.get(this.m, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e = e;
                    } catch (CancellationException unused) {
                    } catch (ExecutionException e2) {
                        e = e2;
                    } catch (TimeoutException unused2) {
                    }
                    if (dVar != null) {
                        try {
                        } catch (InterruptedException e3) {
                            e = e3;
                            dVar2 = dVar;
                            Logger.w(n, "the current thread was interrupted while waiting", e);
                            if (!z) {
                            }
                        } catch (CancellationException unused3) {
                            dVar2 = dVar;
                            Logger.i(n, "{requestServer} the computation was cancelled");
                            if (!z) {
                            }
                        } catch (ExecutionException e4) {
                            e = e4;
                            dVar2 = dVar;
                            Logger.w(n, "the computation threw an ExecutionException", e);
                            z = false;
                            if (!z) {
                            }
                        } catch (TimeoutException unused4) {
                            dVar2 = dVar;
                            Logger.w(n, "the wait timed out");
                            z = false;
                            if (!z) {
                            }
                        }
                        if (dVar.o() || dVar.m()) {
                            Logger.i(n, "grs request return body is not null and is OK.");
                            dVar2 = dVar;
                            if (!z) {
                                Logger.v(n, "needBreak is true so need break current circulation");
                                break;
                            }
                            i++;
                        }
                    }
                    dVar2 = dVar;
                }
                z = false;
                if (!z) {
                }
            }
            return b(dVar2);
        }
        return (d) invokeLLLL.objValue;
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, str2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, e(), this.b);
            if (!TextUtils.isEmpty(grsReqParamJoint)) {
                sb.append("?");
                sb.append(grsReqParamJoint);
            }
            this.i.add(sb.toString());
        }
    }

    private d b(d dVar) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar)) == null) {
            for (Map.Entry<String, Future<d>> entry : this.e.entrySet()) {
                if (dVar != null && (dVar.o() || dVar.m())) {
                    break;
                }
                try {
                    dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e = e;
                    str = n;
                    str2 = "{checkResponse} when check result, find InterruptedException, check others";
                    Logger.w(str, str2, e);
                } catch (CancellationException unused) {
                    Logger.i(n, "{checkResponse} when check result, find CancellationException, check others");
                } catch (ExecutionException e2) {
                    e = e2;
                    str = n;
                    str2 = "{checkResponse} when check result, find ExecutionException, check others";
                    Logger.w(str, str2, e);
                } catch (TimeoutException unused2) {
                    Logger.w(n, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                    if (!entry.getValue().isCancelled()) {
                        entry.getValue().cancel(true);
                    }
                }
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d b(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, executorService, str, cVar)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            d a2 = a(executorService, this.i, str, cVar);
            int b = a2 == null ? 0 : a2.b();
            Logger.v(n, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(b));
            if (b == 404 || b == 401) {
                if (TextUtils.isEmpty(e()) && TextUtils.isEmpty(this.a.getAppName())) {
                    Logger.i(n, "request grs server use 1.0 API must set appName,please check.");
                    return null;
                }
                this.e.clear();
                Logger.i(n, "this env has not deploy new interface,so use old interface.");
                a2 = a(executorService, this.h, str, cVar);
            }
            e.a(new ArrayList(this.f), SystemClock.elapsedRealtime() - elapsedRealtime, this.g, this.b);
            this.f.clear();
            return a2;
        }
        return (d) invokeLLL.objValue;
    }

    private void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, str, str2) == null) {
            if (TextUtils.isEmpty(this.a.getAppName()) && TextUtils.isEmpty(e())) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            Locale locale = Locale.ROOT;
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(e()) ? this.a.getAppName() : e();
            sb.append(String.format(locale, str, objArr));
            String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, "1.0", this.b);
            if (!TextUtils.isEmpty(grsReqParamJoint)) {
                sb.append("?");
                sb.append(grsReqParamJoint);
            }
            this.h.add(sb.toString());
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.huawei.hms.framework.network.grs.g.k.d a2 = com.huawei.hms.framework.network.grs.g.j.a.a(this.b);
            if (a2 == null) {
                Logger.w(n, "g*s***_se****er_conf*** maybe has a big error");
                return;
            }
            a(a2);
            List<String> a3 = a2.a();
            if (a3 == null || a3.size() <= 0) {
                Logger.v(n, "maybe grs_base_url config with [],please check.");
            } else if (a3.size() > 10) {
                throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
            } else {
                String c = a2.c();
                String b = a2.b();
                if (a3.size() > 0) {
                    for (String str : a3) {
                        if (str.startsWith("https://")) {
                            b(c, str);
                            a(b, str);
                        } else {
                            Logger.w(n, "grs server just support https scheme url,please check.");
                        }
                    }
                }
                Logger.v(n, "request to GRS server url is{%s} and {%s}", this.h, this.i);
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
            com.huawei.hms.framework.network.grs.e.c a2 = this.c.a();
            this.l = a2.a(grsParasKey + Headers.ETAG, "");
        }
    }

    private String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            com.huawei.hms.framework.network.grs.f.b a2 = com.huawei.hms.framework.network.grs.f.b.a(this.b.getPackageName(), this.a);
            com.huawei.hms.framework.network.grs.local.model.a a3 = a2 != null ? a2.a() : null;
            if (a3 != null) {
                String b = a3.b();
                Logger.v(n, "get appName from local assets is{%s}", b);
                return b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        InterceptResult invokeLLL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, executorService, str, cVar)) == null) {
            if (this.h.isEmpty() && this.i.isEmpty()) {
                return null;
            }
            try {
                com.huawei.hms.framework.network.grs.g.k.d b = b();
                return (d) executorService.submit(new a(this, executorService, str, cVar)).get(b != null ? b.d() : 10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e = e;
                str2 = n;
                str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
                Logger.w(str2, str3, e);
                return null;
            } catch (CancellationException unused) {
                Logger.i(n, "{submitExcutorTaskWithTimeout} the computation was cancelled");
                return null;
            } catch (ExecutionException e2) {
                e = e2;
                str2 = n;
                str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
                Logger.w(str2, str3, e);
                return null;
            } catch (TimeoutException unused2) {
                Logger.w(n, "{submitExcutorTaskWithTimeout} the wait timed out");
                return null;
            } catch (Exception e3) {
                e = e3;
                str2 = n;
                str3 = "{submitExcutorTaskWithTimeout} catch Exception";
                Logger.w(str2, str3, e);
                return null;
            }
        }
        return (d) invokeLLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public synchronized void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            synchronized (this) {
                this.f.add(dVar);
                d dVar2 = this.d;
                if (dVar2 != null && (dVar2.o() || this.d.m())) {
                    Logger.v(n, "grsResponseResult is ok");
                } else if (dVar.n()) {
                    Logger.i(n, "GRS server open 503 limiting strategy.");
                    com.huawei.hms.framework.network.grs.h.d.a(this.a.getGrsParasKey(true, true, this.b), new d.a(dVar.k(), SystemClock.elapsedRealtime()));
                } else {
                    if (dVar.m()) {
                        Logger.i(n, "GRS server open 304 Not Modified.");
                    }
                    if (!dVar.o() && !dVar.m()) {
                        Logger.v(n, "grsResponseResult has exception so need return");
                        return;
                    }
                    this.d = dVar;
                    this.c.a(this.a, dVar, this.b, this.j);
                    for (Map.Entry<String, Future<d>> entry : this.e.entrySet()) {
                        if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                            Logger.i(n, "future cancel");
                            entry.getValue().cancel(true);
                        }
                    }
                }
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public com.huawei.hms.framework.network.grs.g.k.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (com.huawei.hms.framework.network.grs.g.k.d) invokeV.objValue;
    }
}
