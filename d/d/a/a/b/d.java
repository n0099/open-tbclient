package d.d.a.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.d.a.a.b.h;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f69562a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f69563b;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d f69564a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1909436731, "Ld/d/a/a/b/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1909436731, "Ld/d/a/a/b/d$a;");
                    return;
                }
            }
            f69564a = new d(null);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f69565a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
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
            this.f69565a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || d.d.a.a.a.c() == null) {
                return;
            }
            int i2 = message.what;
            if (10000 == i2) {
                this.f69565a.d((String) message.obj);
                this.f69565a.f();
            } else if (10001 == i2) {
                this.f69565a.d("normal_log");
                this.f69565a.f();
            }
        }
    }

    public /* synthetic */ d(b bVar) {
        this();
    }

    public static d h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f69564a : (d) invokeV.objValue;
    }

    public void a() {
        Context c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = d.d.a.a.a.c()) == null) {
            return;
        }
        k.b(f.a().e(c2));
    }

    public final synchronized boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String b2 = f.a().b(context);
                if (TextUtils.isEmpty(b2)) {
                    return false;
                }
                return b2.equals(e.e(str.getBytes(), false));
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Context c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (h.a().g() || (c2 = d.d.a.a.a.c()) == null || !e.h(c2)) {
                return false;
            }
            h.b f2 = h.a().f(str);
            if (f2.f69573a == 0 || TextUtils.isEmpty(f2.f69574b) || !e(f2.f69574b, null)) {
                return false;
            }
            if (str.equals("normal_log")) {
                f.a().d(c2, e.e(f2.f69574b.getBytes(), false));
            }
            i.a().b(str, f2.f69573a);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(String str, String str2) {
        InterceptResult invokeLL;
        c d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String str3 = str.toString();
            Context c2 = d.d.a.a.a.c();
            if (c2 != null && g(c2, str)) {
                try {
                    d.d.a.a.b.a f2 = d.d.a.a.a.e().f();
                    if (f2 == null || (d2 = d.d.a.a.a.e().d()) == null) {
                        return false;
                    }
                    String uploadUrl = f2.getUploadUrl();
                    String encodeToString = Base64.encodeToString(com.duxiaoman.dxmpay.statistics.internal.f.b(str3, f2.getCommonEvent(), f2.getDistinctId(), f2.getDistinctIdKey(), f2.isLogin(), f2.getProductName(), f2.getSDKVersion(), f2.getChannelId(), f2.getAppVersionName(), f2.getAppVersionCode()).getBytes(), 2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("sign", e.e((encodeToString + "(null)").getBytes("GBK"), false));
                    hashMap.put("data", encodeToString);
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put("mk", str2);
                    }
                    return d2.send(c2, 1, uploadUrl, hashMap);
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void f() {
        Context c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (c2 = d.d.a.a.a.c()) == null) {
            return;
        }
        this.f69563b.removeMessages(10001);
        int i2 = d.d.a.a.a.e().f().get3GSendingInterval();
        if (e.k(c2)) {
            i2 = d.d.a.a.a.e().f().getWifiSendingInterval();
        }
        this.f69563b.sendEmptyMessageDelayed(10001, i2 * 60000);
    }

    public final boolean g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, str)) == null) {
            if (h.a().g() || !c(context, str)) {
                return true;
            }
            h.a().d("normal_log");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f69563b.obtainMessage(10000, str).sendToTarget();
        }
    }

    public d() {
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
        this.f69562a = handlerThread;
        handlerThread.start();
        this.f69563b = new b(this, this.f69562a.getLooper());
    }
}
