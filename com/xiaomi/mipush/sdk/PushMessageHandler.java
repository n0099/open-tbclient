package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class PushMessageHandler extends Service {
    private static List<MiPushClient.MiPushClientCallback> a = new ArrayList();
    private static ExecutorService b = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a extends Serializable {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        synchronized (a) {
            a.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : a) {
                miPushClientCallback.onInitializeResult(j, str, str2);
            }
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.c("addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo) {
        try {
            MessageHandleService.addJob(context.getApplicationContext(), new MessageHandleService.a(intent, (PushMessageReceiver) Class.forName(resolveInfo.activityInfo.name).newInstance()));
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), MessageHandleService.class));
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : a) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        String str = null;
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            if (com.xiaomi.push.service.xmpush.a.COMMAND_REGISTER.k.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (com.xiaomi.push.service.xmpush.a.COMMAND_SET_ALIAS.k.equals(command) || com.xiaomi.push.service.xmpush.a.COMMAND_UNSET_ALIAS.k.equals(command) || com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCEPT_TIME.k.equals(command)) {
                a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (com.xiaomi.push.service.xmpush.a.COMMAND_SUBSCRIBE_TOPIC.k.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), (commandArguments2 == null || commandArguments2.isEmpty()) ? null : commandArguments2.get(0));
            } else if (com.xiaomi.push.service.xmpush.a.COMMAND_UNSUBSCRIBE_TOPIC.k.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), (commandArguments3 == null || commandArguments3.isEmpty()) ? null : commandArguments3.get(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : a) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : a) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (a) {
            if (!a.contains(miPushClientCallback)) {
                a.add(miPushClientCallback);
            }
        }
    }

    protected static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Context context, Intent intent) {
        ResolveInfo resolveInfo;
        try {
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                o.a(context, intent, null);
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                com.xiaomi.xmpush.thrift.f fVar = new com.xiaomi.xmpush.thrift.f();
                com.xiaomi.xmpush.thrift.at.a(fVar, intent.getByteArrayExtra("mipush_payload"));
                com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler.onHandleIntent " + fVar.m());
                MiTinyDataClient.upload(context, fVar);
            } else if ("com.xiaomi.mipush.sdk.HYBRID_NOTIFICATION_CLICK".equals(intent.getAction())) {
                MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra("mipush_payload");
                String stringExtra = intent.getStringExtra("mipush_hybrid_app_pkg");
                MiPushClient.reportMessageClicked(context, miPushMessage);
                MiPushClient4Hybrid.onNotificationMessageClicked(context, stringExtra, miPushMessage);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (b()) {
                    com.xiaomi.channel.commonutils.logger.b.d("receive a message before application calling initialize");
                    return;
                }
                a a2 = aw.a(context).a(intent);
                if (a2 != null) {
                    a(context, a2);
                }
            } else if ("com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Logger.uploadLogFile(context, false);
            } else {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    if (queryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                        while (it.hasNext()) {
                            resolveInfo = it.next();
                            if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                                break;
                            }
                        }
                    }
                    resolveInfo = null;
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.d("cannot find the receiver to handler this message, check your manifest");
                    com.xiaomi.push.service.clientReport.d.a(context).a(intent, "cannot find the receiver to handler this message, check your manifest");
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.service.clientReport.d.a(context).a(intent, e);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            com.xiaomi.push.service.clientReport.d.a(context).a(intent, th);
        }
    }

    protected static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : a) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    public static boolean b() {
        return a.isEmpty();
    }

    private static void c(Context context, Intent intent) {
        if (b.isShutdown()) {
            return;
        }
        b.execute(new av(context, intent));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        c(getApplicationContext(), intent);
    }
}
