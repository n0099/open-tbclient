package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.eo;
import com.xiaomi.push.ey;
import com.xiaomi.push.hn;
import com.xiaomi.push.it;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class PushMessageHandler extends BaseService {
    public static /* synthetic */ Interceptable $ic;
    public static List<MiPushClient.ICallbackResult> a;

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f70a;
    public static List<MiPushClient.MiPushClientCallback> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a extends Serializable {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1564701174, "Lcom/xiaomi/mipush/sdk/PushMessageHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1564701174, "Lcom/xiaomi/mipush/sdk/PushMessageHandler;");
                return;
            }
        }
        a = new ArrayList();
        b = new ArrayList();
        f70a = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public PushMessageHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (b) {
                b.clear();
            }
        }
    }

    public static void a(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), str, str2}) == null) {
            synchronized (b) {
                for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                    miPushClientCallback.onInitializeResult(j, str, str2);
                }
            }
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context, PushMessageHandler.class));
            try {
                context.startService(intent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m105a(e.getMessage());
            }
        }
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, intent) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("addjob PushMessageHandler " + intent);
            if (intent != null) {
                c(context, intent);
                a(context);
            }
        }
    }

    public static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, intent, resolveInfo, Boolean.valueOf(z)}) == null) {
            try {
                MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) com.xiaomi.push.v.a(context, resolveInfo.activityInfo.name).newInstance());
                if (z) {
                    MessageHandleService.a(context.getApplicationContext(), aVar);
                } else {
                    MessageHandleService.addJob(context.getApplicationContext(), aVar);
                }
                MessageHandleService.a(context, new Intent(context.getApplicationContext(), MessageHandleService.class));
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            }
        }
    }

    public static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, miPushCommandMessage) == null) {
            synchronized (a) {
                for (MiPushClient.ICallbackResult iCallbackResult : a) {
                    if (iCallbackResult instanceof MiPushClient.UPSRegisterCallBack) {
                        MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                        if (miPushCommandMessage != null && miPushCommandMessage.getCommandArguments() != null && miPushCommandMessage.getCommandArguments().size() > 0) {
                            tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                            tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                        }
                        iCallbackResult.onResult(tokenResult);
                    }
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, miPushMessage) == null) {
            synchronized (b) {
                for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                    if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                        miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                        miPushClientCallback.onReceiveMessage(miPushMessage);
                    }
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, aVar) == null) {
            if (aVar instanceof MiPushMessage) {
                a(context, (MiPushMessage) aVar);
            } else if (aVar instanceof MiPushCommandMessage) {
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
                String command = miPushCommandMessage.getCommand();
                String str = null;
                if (ey.a.f357a.equals(command)) {
                    List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                    if (commandArguments != null && !commandArguments.isEmpty()) {
                        str = commandArguments.get(0);
                    }
                    a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                } else if (ey.c.f357a.equals(command) || ey.d.f357a.equals(command) || ey.i.f357a.equals(command)) {
                    a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
                } else if (ey.g.f357a.equals(command)) {
                    List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                        str = commandArguments2.get(0);
                    }
                    a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                } else if (ey.h.f357a.equals(command)) {
                    List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                        str = commandArguments3.get(0);
                    }
                    b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                }
            }
        }
    }

    public static void a(Context context, String str, long j, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, Long.valueOf(j), str2, str3}) == null) {
            synchronized (b) {
                for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                    if (a(str, miPushClientCallback.getCategory())) {
                        miPushClientCallback.onSubscribeResult(j, str2, str3);
                    }
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, str, str2, Long.valueOf(j), str3, list}) == null) {
            synchronized (b) {
                for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                    if (a(str, miPushClientCallback.getCategory())) {
                        miPushClientCallback.onCommandResult(str2, j, str3, list);
                    }
                }
            }
        }
    }

    public static void a(MiPushClient.ICallbackResult iCallbackResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, iCallbackResult) == null) {
            synchronized (a) {
                if (!a.contains(iCallbackResult)) {
                    a.add(iCallbackResult);
                }
            }
        }
    }

    public static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, miPushClientCallback) == null) {
            synchronized (b) {
                if (!b.contains(miPushClientCallback)) {
                    b.add(miPushClientCallback);
                }
            }
        }
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) ? (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2) : invokeLL.booleanValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            synchronized (a) {
                a.clear();
            }
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, context) == null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("action_clicked_activity_finish");
                context.sendBroadcast(intent, d.a(context));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m105a("callback sync error" + e);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static void b(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, intent) == null) {
            boolean z = false;
            try {
                z = intent.getBooleanExtra("is_clicked_activity_call", false);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m105a("intent unparcel error:" + th);
            }
            try {
                ResolveInfo resolveInfo = null;
                if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                    o.a(context, intent, null);
                } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                    hn hnVar = new hn();
                    it.a(hnVar, intent.getByteArrayExtra("mipush_payload"));
                    com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler.onHandleIntent " + hnVar.d());
                    MiTinyDataClient.upload(context, hnVar);
                } else if (1 == PushMessageHelper.getPushMode(context)) {
                    if (m124b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive a message before application calling initialize");
                        if (z) {
                            b(context);
                            return;
                        }
                        return;
                    }
                    a a2 = am.a(context).a(intent);
                    if (a2 != null) {
                        a(context, a2);
                    }
                } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                    Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                    intent2.setPackage(context.getPackageName());
                    intent2.putExtras(intent);
                    try {
                        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                        if (queryBroadcastReceivers != null) {
                            Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ResolveInfo next = it.next();
                                if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.v.a(context, next.activityInfo.name))) {
                                    resolveInfo = next;
                                    break;
                                }
                            }
                        }
                        if (resolveInfo != null) {
                            a(context, intent2, resolveInfo, z);
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("cannot find the receiver to handler this message, check your manifest");
                            eo.a(context).a(context.getPackageName(), intent, "11");
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        eo.a(context).a(context.getPackageName(), intent, "9");
                    }
                }
            } catch (Throwable th2) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.a(th2);
                    eo.a(context).a(context.getPackageName(), intent, "10");
                    if (!z) {
                    }
                } finally {
                    if (z) {
                        b(context);
                    }
                }
            }
        }
    }

    public static void b(Context context, String str, long j, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, str, Long.valueOf(j), str2, str3}) == null) {
            synchronized (b) {
                for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                    if (a(str, miPushClientCallback.getCategory())) {
                        miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                    }
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m124b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? b.isEmpty() : invokeV.booleanValue;
    }

    public static void c(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, context, intent) == null) || intent == null || f70a.isShutdown()) {
            return;
        }
        f70a.execute(new al(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo125a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ThreadPoolExecutor threadPoolExecutor = f70a;
            return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f70a.getQueue().size() <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, intent, i) == null) {
            super.onStart(intent, i);
            c(getApplicationContext(), intent);
        }
    }
}
