package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.ev;
import com.xiaomi.push.fa;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class MessageHandleService extends BaseService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f20a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes8.dex */
    public static class a {
        private Intent a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f21a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f21a = pushMessageReceiver;
            this.a = intent;
        }

        public Intent a() {
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m54a() {
            return this.f21a;
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
        if (f20a.isShutdown()) {
            return;
        }
        f20a.execute(new ad(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        String[] stringArrayExtra;
        try {
            a poll = a.poll();
            if (poll == null) {
                return;
            }
            PushMessageReceiver m54a = poll.m54a();
            Intent a2 = poll.a();
            switch (a2.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1)) {
                case 1:
                    PushMessageHandler.a a3 = av.a(context).a(a2);
                    int intExtra = a2.getIntExtra("eventMessageType", -1);
                    if (a3 != null) {
                        if (!(a3 instanceof MiPushMessage)) {
                            if (a3 instanceof MiPushCommandMessage) {
                                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                                m54a.onCommandResult(context, miPushCommandMessage);
                                if (TextUtils.equals(miPushCommandMessage.getCommand(), fa.COMMAND_REGISTER.f332a)) {
                                    m54a.onReceiveRegisterResult(context, miPushCommandMessage);
                                    if (miPushCommandMessage.getResultCode() == 0) {
                                        j.b(context);
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
                            m54a.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            ev.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004, "call passThrough callBack");
                            m54a.onReceivePassThroughMessage(context, miPushMessage);
                            return;
                        } else if (!miPushMessage.isNotified()) {
                            m54a.onNotificationMessageArrived(context, miPushMessage);
                            return;
                        } else {
                            if (intExtra == 1000) {
                                ev.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, "call notification callBack");
                            } else {
                                ev.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007, "call business callBack");
                            }
                            com.xiaomi.channel.commonutils.logger.b.m45a("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                            m54a.onNotificationMessageClicked(context, miPushMessage);
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    m54a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), fa.COMMAND_REGISTER.f332a)) {
                        m54a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            j.b(context);
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    return;
                case 5:
                    if (!PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a2.getStringExtra(PushMessageHelper.ERROR_TYPE)) || (stringArrayExtra = a2.getStringArrayExtra("error_message")) == null) {
                        return;
                    }
                    m54a.onRequirePermissions(context, stringArrayExtra);
                    return;
            }
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        com.xiaomi.push.ai.a(context).a(new ac(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo59a() {
        return a != null && a.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
