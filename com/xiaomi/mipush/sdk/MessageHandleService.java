package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class MessageHandleService extends Service {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();
    private static ExecutorService b = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes3.dex */
    public static class a {
        private PushMessageReceiver a;
        private Intent b;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.a = pushMessageReceiver;
            this.b = intent;
        }

        public PushMessageReceiver a() {
            return this.a;
        }

        public Intent b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (b.isShutdown()) {
            return;
        }
        b.execute(new af(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        String[] stringArrayExtra;
        try {
            a poll = a.poll();
            if (poll == null) {
                return;
            }
            PushMessageReceiver a2 = poll.a();
            Intent b2 = poll.b();
            switch (b2.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1)) {
                case 1:
                    PushMessageHandler.a a3 = aw.a(context).a(b2);
                    int intExtra = b2.getIntExtra("eventMessageType", -1);
                    if (a3 != null) {
                        if (!(a3 instanceof MiPushMessage)) {
                            if (a3 instanceof MiPushCommandMessage) {
                                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                                a2.onCommandResult(context, miPushCommandMessage);
                                if (TextUtils.equals(miPushCommandMessage.getCommand(), com.xiaomi.push.service.xmpush.a.COMMAND_REGISTER.k)) {
                                    a2.onReceiveRegisterResult(context, miPushCommandMessage);
                                    if (miPushCommandMessage.getResultCode() == 0) {
                                        i.c(context);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        MiPushMessage miPushMessage = (MiPushMessage) a3;
                        if (!miPushMessage.isArrivedMessage()) {
                            a2.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(b2, 2004, "call passThrough callBack");
                            a2.onReceivePassThroughMessage(context, miPushMessage);
                            return;
                        } else if (!miPushMessage.isNotified()) {
                            a2.onNotificationMessageArrived(context, miPushMessage);
                            return;
                        } else {
                            if (intExtra == 1000) {
                                com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(b2, PointerIconCompat.TYPE_CROSSHAIR, "call notification callBack");
                            } else {
                                com.xiaomi.push.service.clientReport.d.a(context.getApplicationContext()).a(b2, 3007, "call business callBack");
                            }
                            com.xiaomi.channel.commonutils.logger.b.a("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                            a2.onNotificationMessageClicked(context, miPushMessage);
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) b2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    a2.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), com.xiaomi.push.service.xmpush.a.COMMAND_REGISTER.k)) {
                        a2.onReceiveRegisterResult(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            i.c(context);
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    return;
                case 5:
                    if (!PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(b2.getStringExtra(PushMessageHelper.ERROR_TYPE)) || (stringArrayExtra = b2.getStringArrayExtra("error_message")) == null) {
                        return;
                    }
                    a2.onRequirePermissions(context, stringArrayExtra);
                    return;
            }
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        com.xiaomi.channel.commonutils.misc.h.a(context).a(new ae(context, intent));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
