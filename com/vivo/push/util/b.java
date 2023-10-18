package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.security.PublicKey;
import java.util.HashMap;
/* loaded from: classes10.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;
    public Context c;
    public NotifyArriveCallbackByUser d;

    public abstract int a();

    public abstract PendingIntent a(Context context, Intent intent);

    public abstract Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser);

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public static Intent a(Context context, String str, long j, Intent intent, InsideNotificationItem insideNotificationItem) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Long.valueOf(j), intent, insideNotificationItem})) == null) {
            Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
            intent2.setPackage(context.getPackageName());
            intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
            intent2.putExtra("command_type", "reflect_receiver");
            intent2.putExtras(intent.getExtras());
            a(intent2, context);
            com.vivo.push.b.p pVar = new com.vivo.push.b.p(str, j, insideNotificationItem);
            pVar.b(intent.getAction());
            if (intent.getComponent() != null) {
                pVar.c(intent.getComponent().getPackageName());
                pVar.d(intent.getComponent().getClassName());
            }
            if (intent.getData() != null) {
                pVar.a(intent.getData());
            }
            pVar.b(intent2);
            return intent2;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static void a(Intent intent, Context context) {
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, intent, context) == null) {
            try {
                intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
                if (Build.VERSION.SDK_INT >= 18) {
                    String a2 = com.vivo.push.e.b.a().a(context).a("com.vivo.pushservice");
                    PublicKey a3 = com.vivo.push.e.b.a().a(context).a();
                    if (TextUtils.isEmpty(a2)) {
                        a2 = "com.vivo.pushservice";
                    }
                    intent.putExtra("security_avoid_pull_rsa", a2);
                    if (a3 == null) {
                        a = "com.vivo.pushservice";
                    } else {
                        a = ab.a(a3);
                    }
                    intent.putExtra("security_avoid_rsa_public_key", a);
                }
            } catch (Exception e) {
                u.a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt ：" + e.getMessage());
                intent.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
                intent.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
            }
        }
    }

    public final Intent a(Context context, String str, long j, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, Long.valueOf(j), insideNotificationItem, notifyArriveCallbackByUser})) == null) {
            this.b = j;
            this.a = str;
            this.c = context;
            this.d = notifyArriveCallbackByUser;
            Intent a = a(context, insideNotificationItem, notifyArriveCallbackByUser);
            int a2 = a();
            if (a2 > 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("messageID", String.valueOf(this.b));
                String a3 = com.vivo.push.d.a.a().e().a();
                if (!TextUtils.isEmpty(a3)) {
                    hashMap.put("remoteAppId", a3);
                }
                hashMap.put("ap", this.a);
                hashMap.put("clientsdkver", String.valueOf(ag.c(this.c, this.a)));
                f.a(a2, hashMap);
                return null;
            }
            return a;
        }
        return (Intent) invokeCommon.objValue;
    }
}
