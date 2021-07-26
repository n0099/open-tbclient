package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.aa;
import com.vivo.push.util.p;
import com.vivo.push.util.s;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public final class a extends aa {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f39439c;

    /* renamed from: f  reason: collision with root package name */
    public static final List<Integer> f39440f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Handler f39441d;

    /* renamed from: e  reason: collision with root package name */
    public String f39442e;

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
        f39440f = Arrays.asList(3);
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
        this.f39441d = new Handler(Looper.getMainLooper());
    }

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (f39439c == null) {
                    f39439c = new a();
                }
                aVar = f39439c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f39442e = null;
        }
    }

    @Override // com.vivo.push.aa
    public final void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            Intent intent = (Intent) message.obj;
            if (intent != null && this.f39271a != null) {
                int intExtra = intent.getIntExtra("command", -1);
                if (intExtra < 0) {
                    intExtra = intent.getIntExtra("method", -1);
                }
                String packageName = this.f39271a.getPackageName();
                if (f39440f.contains(Integer.valueOf(intExtra)) && s.b(this.f39271a, packageName) && !s.d(this.f39271a)) {
                    return;
                }
                String action = intent.getAction();
                if (TextUtils.isEmpty(this.f39442e)) {
                    String a2 = a(this.f39271a, packageName, action);
                    this.f39442e = a2;
                    if (TextUtils.isEmpty(a2)) {
                        p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                        intent.setPackage(packageName);
                        this.f39271a.sendBroadcast(intent);
                        return;
                    }
                }
                try {
                    Class<?> cls = Class.forName(this.f39442e);
                    Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                    Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                    intent.setClassName(packageName, this.f39442e);
                    this.f39441d.post(new b(this, method, newInstance, new Object[]{this.f39271a.getApplicationContext(), intent}));
                    return;
                } catch (Exception e2) {
                    p.b("CommandWorker", "reflect e: ", e2);
                    return;
                }
            }
            p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f39271a);
        }
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            if (intent != null && this.f39271a != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                a(obtain);
                return;
            }
            p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f39271a);
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
}
