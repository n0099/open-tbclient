package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.b.x;
import com.vivo.push.c.d;
import com.vivo.push.e;
import com.vivo.push.q;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public final class a extends q {
    public static /* synthetic */ Interceptable $ic;
    public static a c;
    public static final List e;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public String f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-602215749, "Lcom/vivo/push/sdk/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-602215749, "Lcom/vivo/push/sdk/a;");
                return;
            }
        }
        e = Arrays.asList(3);
    }

    public a() {
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
        this.f = "";
    }

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
                aVar = c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = null;
        }
    }

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        List<ResolveInfo> queryBroadcastReceivers;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                    return null;
                }
                return queryBroadcastReceivers.get(0).activityInfo.name;
            } catch (Exception e2) {
                p.a("CommandWorker", "error  " + e2.getMessage());
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    private boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent)) == null) {
            String stringExtra = intent.getStringExtra("security_avoid_pull");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    String b = com.vivo.push.util.a.a(this.a).b(stringExtra);
                    if (!"com.vivo.pushservice".equals(b)) {
                        p.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b)));
                        return false;
                    }
                    return true;
                } catch (Exception e2) {
                    p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
                    return false;
                }
            }
            p.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean c(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, intent)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return true;
            }
            String c2 = z.c(this.a, "com.vivo.pushservice");
            p.d("CommandWorker", " 配置的验签参数 = ".concat(String.valueOf(c2)));
            if (!TextUtils.equals(c2, "1")) {
                return true;
            }
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                try {
                    if (d.a(this.a).a().a("com.vivo.pushservice".getBytes("UTF-8"), u.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                        p.d("CommandWorker", " RSA验签通过  ");
                        return true;
                    }
                } catch (Exception e2) {
                    p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
                }
                p.d("CommandWorker", " RSA验签 不通过  ");
                return false;
            }
            p.a("CommandWorker", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        }
        return invokeL.booleanValue;
    }

    private int d(Intent intent) {
        InterceptResult invokeL;
        String stringExtra;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, intent)) == null) {
            if (!TextUtils.isEmpty(this.f) && this.f.contains("CommandService")) {
                if (intent != null && b(intent) && c(intent)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    p.a("CommandWorker", " !checkIntentIsSecurity(intent)");
                    return 2151;
                }
            }
            String packageName = this.a.getPackageName();
            try {
                stringExtra = intent.getStringExtra("command_type");
            } catch (Exception e2) {
                p.a("CommandWorker", e2);
            }
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
                int intExtra = intent.getIntExtra("command", -1);
                if (intExtra < 0) {
                    intExtra = intent.getIntExtra("method", -1);
                }
                if (e.contains(Integer.valueOf(intExtra)) && t.c(this.a, packageName) && !t.c(this.a)) {
                    p.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
                    return 2153;
                }
                String action = intent.getAction();
                if (TextUtils.isEmpty(this.d)) {
                    String a = a(this.a, packageName, action);
                    this.d = a;
                    if (TextUtils.isEmpty(a)) {
                        p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                        intent.setPackage(packageName);
                        this.a.sendBroadcast(intent);
                        return 2152;
                    }
                }
                return 0;
            }
            p.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
            return 2151;
        }
        return invokeL.intValue;
    }

    @Override // com.vivo.push.q
    public final void b(Message message) {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            Intent intent = (Intent) message.obj;
            if (intent != null && (context = this.a) != null) {
                String packageName = context.getPackageName();
                int d = d(intent);
                if (d > 0) {
                    x xVar = new x(d);
                    HashMap hashMap = new HashMap();
                    if (intent != null) {
                        Bundle extras = intent.getExtras();
                        long j = 404000044642424832L;
                        if (extras != null) {
                            j = extras.getLong("notify_id", 404000044642424832L);
                        }
                        hashMap.put("messageID", String.valueOf(j));
                    }
                    String b = z.b(this.a, packageName);
                    if (!TextUtils.isEmpty(b)) {
                        hashMap.put("remoteAppId", b);
                    }
                    xVar.a(hashMap);
                    e.a().a(xVar);
                    return;
                }
                try {
                    Class<?> cls = Class.forName(this.d);
                    Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                    Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                    intent.setClassName(packageName, this.d);
                    method.invoke(newInstance, ContextDelegate.getContext(this.a).getApplicationContext(), intent);
                    return;
                } catch (Exception e2) {
                    p.b("CommandWorker", "reflect e: ", e2);
                    return;
                }
            }
            p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.a);
        }
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            if (intent != null && this.a != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                a(obtain);
                return;
            }
            p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.a);
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f = str;
        }
    }
}
