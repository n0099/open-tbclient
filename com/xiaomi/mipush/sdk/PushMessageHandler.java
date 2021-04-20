package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.el;
import com.xiaomi.push.ev;
import com.xiaomi.push.hj;
import com.xiaomi.push.ip;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class PushMessageHandler extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    public static List<MiPushClient.ICallbackResult> f40435a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static List<MiPushClient.MiPushClientCallback> f40436b = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f55a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes7.dex */
    public interface a extends Serializable {
    }

    public static void a() {
        synchronized (f40436b) {
            f40436b.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (f40436b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f40436b) {
                miPushClientCallback.onInitializeResult(j, str, str2);
            }
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m55a(e2.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.c("addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    public static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) com.xiaomi.push.t.a(context, resolveInfo.activityInfo.name).newInstance());
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

    public static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f40435a) {
            for (MiPushClient.ICallbackResult iCallbackResult : f40435a) {
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

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (f40436b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f40436b) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (ev.COMMAND_REGISTER.f337a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (ev.COMMAND_SET_ALIAS.f337a.equals(command) || ev.COMMAND_UNSET_ALIAS.f337a.equals(command) || ev.COMMAND_SET_ACCEPT_TIME.f337a.equals(command)) {
                a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (ev.COMMAND_SUBSCRIBE_TOPIC.f337a.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (ev.COMMAND_UNSUBSCRIBE_TOPIC.f337a.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    public static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (f40436b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f40436b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (f40436b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f40436b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    public static void a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (f40435a) {
            if (!f40435a.contains(iCallbackResult)) {
                f40435a.add(iCallbackResult);
            }
        }
    }

    public static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (f40436b) {
            if (!f40436b.contains(miPushClientCallback)) {
                f40436b.add(miPushClientCallback);
            }
        }
    }

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    public static void b() {
        synchronized (f40435a) {
            f40435a.clear();
        }
    }

    public static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, d.a(context));
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m55a("callback sync error" + e2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static void b(Context context, Intent intent) {
        boolean z = false;
        if (intent != null && intent.getBooleanExtra("is_clicked_activity_call", false)) {
            z = true;
        }
        try {
            ResolveInfo resolveInfo = null;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                o.a(context, intent, null);
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                hj hjVar = new hj();
                ip.a(hjVar, intent.getByteArrayExtra("mipush_payload"));
                com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler.onHandleIntent " + hjVar.d());
                MiTinyDataClient.upload(context, hjVar);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m73b()) {
                    com.xiaomi.channel.commonutils.logger.b.d("receive a message before application calling initialize");
                    if (z) {
                        b(context);
                        return;
                    }
                    return;
                }
                a a2 = al.a(context).a(intent);
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
                            if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.t.a(context, next.activityInfo.name))) {
                                resolveInfo = next;
                                break;
                            }
                        }
                    }
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo, z);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("cannot find the receiver to handler this message, check your manifest");
                        el.a(context).a(context.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    el.a(context).a(context.getPackageName(), intent, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
                }
            }
        } catch (Throwable th) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                el.a(context).a(context.getPackageName(), intent, "10");
                if (!z) {
                }
            } finally {
                if (z) {
                    b(context);
                }
            }
        }
    }

    public static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (f40436b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f40436b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m73b() {
        return f40436b.isEmpty();
    }

    public static void c(Context context, Intent intent) {
        if (intent == null || f55a.isShutdown()) {
            return;
        }
        f55a.execute(new ak(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo74a() {
        ThreadPoolExecutor threadPoolExecutor = f55a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f55a.getQueue().size() <= 0) ? false : true;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        c(getApplicationContext(), intent);
    }
}
