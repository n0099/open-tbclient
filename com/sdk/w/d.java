package com.sdk.w;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.g;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.f.g;
import com.sdk.o.f;
/* loaded from: classes8.dex */
public class d<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.w.d";
    public static Boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public CallBack<T> c;
    public Context d;
    public d<T>.a e;
    public com.sdk.a.e f;
    public int g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592660802, "Lcom/sdk/w/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592660802, "Lcom/sdk/w/d;");
                return;
            }
        }
        b = Boolean.valueOf(g.b);
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Handler a;
        public long b;
        public final /* synthetic */ d c;

        public a(d dVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dVar;
            this.a = new Handler(Looper.getMainLooper());
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.f != null) {
                    com.sdk.n.a.c(d.a, "超时，已取消请求", d.b);
                    this.c.f.a();
                }
                this.c.a(1, "超时", 101005, null, com.sdk.n.b.a().c);
            }
        }
    }

    public d(Context context, int i, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), callBack};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = callBack;
        this.d = context;
        i = i <= 0 ? 30 : i;
        this.g = i;
        d<T>.a aVar = new a(this, i * 1000);
        this.e = aVar;
        aVar.a.postDelayed(aVar, aVar.b);
        com.sdk.n.b.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            String a2 = com.sdk.b.a.a(this.d, i, f.b.b.a());
            if (com.sdk.n.a.b(a2).booleanValue()) {
                a(0, "成功", 100, com.sdk.b.a.a(a2), com.sdk.b.a.b(a2));
                return;
            }
            Context context = this.d;
            if (!com.sdk.q.b.a) {
                Long b2 = com.sdk.j.a.b(context, "access_limit_time");
                long currentTimeMillis = System.currentTimeMillis();
                if (b2 == null) {
                    com.sdk.j.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
                } else {
                    if (currentTimeMillis - b2.longValue() > 600000) {
                        com.sdk.j.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
                    } else {
                        Long b3 = com.sdk.j.a.b(context, "access_limit_count");
                        if (b3 != null) {
                            if (b3.longValue() > 30) {
                                z = false;
                                if (z) {
                                    a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
                                    return;
                                }
                                com.sdk.x.a aVar = new com.sdk.x.a(this.d, new com.sdk.w.a(this, i));
                                DataInfo dataInfo = new DataInfo();
                                dataInfo.putData("serviceType", Integer.valueOf(i));
                                dataInfo.putData("privateIp", AppUtils.getLocalIPAddress());
                                dataInfo.putData("newVersion", "10");
                                this.f = aVar.a(aVar.i, "/dro/netm/v1.0/qc", dataInfo, new com.sdk.g.a(aVar), 0, g.a.b);
                                return;
                            }
                        }
                    }
                    com.sdk.j.a.a(context, "access_limit_count", (Long) 0L);
                }
            }
            z = true;
            if (z) {
            }
        }
    }

    public final void a(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
            String str2 = com.sdk.n.b.a().c;
            if (com.sdk.n.a.a(str2).booleanValue()) {
                str2 = com.sdk.q.a.a(20);
            }
            d<T>.a aVar = this.e;
            if (aVar != null) {
                aVar.a.removeCallbacks(aVar);
            }
            CallBack<T> callBack = this.c;
            if (callBack != null) {
                callBack.onFailed(i, i2, str, str2);
                this.c = null;
            }
            com.sdk.t.a.a();
        }
    }

    public final void a(int i, String str, int i2, T t, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), t, str2}) == null) {
            if (com.sdk.n.a.a(str2).booleanValue()) {
                str2 = com.sdk.q.a.a(20);
            }
            String str3 = str2;
            d<T>.a aVar = this.e;
            if (aVar != null) {
                aVar.a.removeCallbacks(aVar);
            }
            CallBack<T> callBack = this.c;
            if (callBack != null) {
                callBack.onSuccess(i, str, i2, t, str3);
                this.c = null;
            }
            com.sdk.t.a.a();
        }
    }
}
