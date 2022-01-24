package com.duxiaoman.dxmpay.statistics.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import c.d.a.a.a.d;
import c.d.a.a.a.e;
import c.d.a.a.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.duxiaoman.dxmpay.statistics.StrategyProcess;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class LogSender {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f53526b;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static LogSender a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1236389876, "Lcom/duxiaoman/dxmpay/statistics/internal/LogSender$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1236389876, "Lcom/duxiaoman/dxmpay/statistics/internal/LogSender$a;");
                    return;
                }
            }
            a = new LogSender(null);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogSender a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LogSender logSender, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logSender, looper};
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
            this.a = logSender;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || StatApi.getAppContext() == null) {
                return;
            }
            int i2 = message.what;
            if (10000 == i2) {
                this.a.d((String) message.obj);
                this.a.f();
            } else if (10001 == i2) {
                this.a.d("normal_log");
                this.a.f();
            } else if (10002 == i2) {
                StrategyProcess.getInstance().loadCachedStrategy(StatApi.getAppContext());
            }
        }
    }

    public /* synthetic */ LogSender(b bVar) {
        this();
    }

    public static LogSender getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (LogSender) invokeV.objValue;
    }

    public void a() {
        Context appContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (appContext = StatApi.getAppContext()) == null) {
            return;
        }
        g.b(c.d.a.a.a.b.a().e(appContext));
        this.f53526b.sendEmptyMessage(10002);
    }

    public final synchronized boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String b2 = c.d.a.a.a.b.a().b(context);
                if (TextUtils.isEmpty(b2)) {
                    return false;
                }
                return b2.equals(c.d.a.a.a.a.e(str.getBytes(), false));
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Context appContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (d.a().g() || (appContext = StatApi.getAppContext()) == null || !c.d.a.a.a.a.h(appContext)) {
                return false;
            }
            d.b f2 = d.a().f(str);
            if (f2.a == 0 || TextUtils.isEmpty(f2.f27622b) || !e(f2.f27622b, null)) {
                return false;
            }
            if (str.equals("normal_log")) {
                c.d.a.a.a.b.a().d(appContext, c.d.a.a.a.a.e(f2.f27622b.getBytes(), false));
            }
            e.a().b(str, f2.a);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(String str, String str2) {
        InterceptResult invokeLL;
        ISyncHttpImpl httpImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String str3 = str.toString();
            Context appContext = StatApi.getAppContext();
            if (appContext != null && g(appContext, str)) {
                try {
                    IStatConfig settings = StatApi.getInstance().getSettings();
                    if (settings == null || (httpImpl = StatApi.getInstance().getHttpImpl()) == null) {
                        return false;
                    }
                    String uploadUrl = settings.getUploadUrl();
                    String encodeToString = Base64.encodeToString(f.b(str3, settings.getCommonEvent(), settings.getDistinctId(), settings.getDistinctIdKey(), settings.isLogin(), settings.getProductName(), settings.getSDKVersion(), settings.getChannelId(), settings.getAppVersionName(), settings.getAppVersionCode()).getBytes(), 2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("sign", c.d.a.a.a.a.e((encodeToString + "(null)").getBytes("GBK"), false));
                    hashMap.put("data", encodeToString);
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put("mk", str2);
                    }
                    return httpImpl.send(appContext, 1, uploadUrl, hashMap);
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void f() {
        Context appContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (appContext = StatApi.getAppContext()) == null) {
            return;
        }
        this.f53526b.removeMessages(10001);
        int i2 = StrategyProcess.getInstance().get3GSendingInterval();
        if (c.d.a.a.a.a.k(appContext)) {
            i2 = StrategyProcess.getInstance().getWifiSendingInterval();
        }
        this.f53526b.sendEmptyMessageDelayed(10001, i2 * 60000);
    }

    public final boolean g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, str)) == null) {
            if (d.a().g() || !c(context, str)) {
                return true;
            }
            d.a().d("normal_log");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void triggerSending(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f53526b.obtainMessage(10000, str).sendToTarget();
        }
    }

    public LogSender() {
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
        HandlerThread handlerThread = new HandlerThread("SensorLogSenderThread");
        this.a = handlerThread;
        handlerThread.start();
        this.f53526b = new b(this, this.a.getLooper());
    }
}
