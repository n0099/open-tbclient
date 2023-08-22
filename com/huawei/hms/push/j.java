package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes10.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public k c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1428231575, "Lcom/huawei/hms/push/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1428231575, "Lcom/huawei/hms/push/j;");
                return;
            }
        }
        a = new String[]{"url", "app", "cosa", "rp"};
    }

    public j(Context context, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = context;
        this.c = kVar;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (String str2 : a) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("enter launchApp, appPackageName =");
                sb.append(this.c.d());
                HMSLog.i("PushSelfShowLog", sb.toString());
                if (q.c(this.b, this.c.d())) {
                    b();
                }
            } catch (Exception e) {
                HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x007e, code lost:
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00be, code lost:
        if (com.huawei.hms.push.q.a(r6.b, r6.c.d(), r2).booleanValue() != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9 A[Catch: Exception -> 0x00e5, TryCatch #0 {Exception -> 0x00e5, blocks: (B:5:0x000b, B:7:0x0012, B:9:0x0020, B:28:0x00c5, B:30:0x00c9, B:32:0x00d4, B:34:0x00df, B:33:0x00da, B:21:0x009b, B:23:0x00a3, B:18:0x0082, B:20:0x0089, B:12:0x0048, B:14:0x005d), top: B:42:0x000b, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        Intent parseUri;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("enter launchExistApp cosa, appPackageName =");
                sb.append(this.c.d());
                sb.append(",and msg.intentUri is ");
                sb.append(this.c.n());
                HMSLog.i("PushSelfShowLog", sb.toString());
                Intent b = q.b(this.b, this.c.d());
                boolean z = false;
                if (this.c.n() != null) {
                    try {
                        parseUri = Intent.parseUri(this.c.n(), 0);
                        parseUri.setSelector(null);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Intent.parseUri(msg.intentUri, 0), action:");
                        sb2.append(parseUri.getAction());
                        HMSLog.i("PushSelfShowLog", sb2.toString());
                        z = q.a(this.b, this.c.d(), parseUri).booleanValue();
                    } catch (Exception e) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("intentUri error.");
                        sb3.append(e.toString());
                        HMSLog.w("PushSelfShowLog", sb3.toString());
                    }
                } else {
                    if (this.c.a() != null) {
                        parseUri = new Intent(this.c.a());
                    }
                    if (b != null) {
                        HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                        return;
                    }
                    b.setPackage(this.c.d());
                    if (z) {
                        b.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    } else {
                        b.setFlags(805437440);
                    }
                    this.b.startActivity(b);
                    return;
                }
                b = parseUri;
                if (b != null) {
                }
            } catch (Exception e2) {
                HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
            }
        }
    }

    public void c() {
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HMSLog.d("PushSelfShowLog", "enter launchNotify()");
            if (this.b != null && (kVar = this.c) != null) {
                if ("app".equals(kVar.i())) {
                    a();
                    return;
                } else if ("cosa".equals(this.c.i())) {
                    b();
                    return;
                } else if ("rp".equals(this.c.i())) {
                    HMSLog.w("PushSelfShowLog", this.c.i() + " not support rich message.");
                    return;
                } else if ("url".equals(this.c.i())) {
                    HMSLog.w("PushSelfShowLog", this.c.i() + " not support URL.");
                    return;
                } else {
                    HMSLog.d("PushSelfShowLog", this.c.i() + " is not exist in hShowType");
                    return;
                }
            }
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
        }
    }
}
