package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.q;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public final class a extends q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f60942c;

    /* renamed from: e  reason: collision with root package name */
    public static final List<Integer> f60943e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f60944d;

    /* renamed from: f  reason: collision with root package name */
    public String f60945f;

    /* renamed from: g  reason: collision with root package name */
    public long f60946g;

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
        f60943e = Arrays.asList(3);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60945f = "";
    }

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (f60942c == null) {
                    f60942c = new a();
                }
                aVar = f60942c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f60944d = null;
        }
    }

    @Override // com.vivo.push.q
    public final void b(Message message) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            Intent intent = (Intent) message.obj;
            if (intent != null && this.a != null) {
                if (!TextUtils.isEmpty(this.f60945f) && this.f60945f.contains("CommandService") && !b(intent)) {
                    p.a("CommandWorker", " !checkIntentIsSecurity(intent)");
                    return;
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
                    if (f60943e.contains(Integer.valueOf(intExtra)) && t.c(this.a, packageName) && !t.c(this.a)) {
                        p.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
                        return;
                    }
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(this.f60944d)) {
                        String a = a(this.a, packageName, action);
                        this.f60944d = a;
                        if (TextUtils.isEmpty(a)) {
                            p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                            intent.setPackage(packageName);
                            this.a.sendBroadcast(intent);
                            return;
                        }
                    }
                    try {
                        Class<?> cls = Class.forName(this.f60944d);
                        Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                        Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                        intent.setClassName(packageName, this.f60944d);
                        method.invoke(newInstance, ContextDelegate.getContext(this.a).getApplicationContext(), intent);
                        return;
                    } catch (Exception e3) {
                        p.b("CommandWorker", "reflect e: ", e3);
                        return;
                    }
                }
                p.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
                return;
            }
            p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.a);
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f60945f = str;
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
            if (intent == null) {
                return false;
            }
            PackageManager packageManager = this.a.getPackageManager();
            if (this.f60946g <= 0) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.vivo.pushservice", 0);
                    if (packageInfo != null) {
                        this.f60946g = packageInfo.versionCode;
                        p.a("CommandWorker", "push service version:" + this.f60946g);
                    }
                } catch (Exception e2) {
                    p.a("CommandWorker", "getPackageInfo exception:" + e2.getMessage());
                }
            }
            if (this.f60946g >= 4040000) {
                String stringExtra = intent.getStringExtra("security_avoid_pull");
                if (TextUtils.isEmpty(stringExtra)) {
                    p.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
                    return false;
                }
                try {
                    String b2 = com.vivo.push.util.a.a(this.a).b(stringExtra);
                    if ("com.vivo.pushservice".equals(b2)) {
                        return true;
                    }
                    p.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b2)));
                    return false;
                } catch (Exception e3) {
                    p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e3.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
