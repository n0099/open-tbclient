package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.fb;
import com.xiaomi.push.fg;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class MessageHandleService extends BaseService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f25a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes8.dex */
    public static class a {
        private Intent a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f26a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f26a = pushMessageReceiver;
            this.a = intent;
        }

        public Intent a() {
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m64a() {
            return this.f26a;
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
        if (f25a.isShutdown()) {
            return;
        }
        f25a.execute(new ab(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        String[] stringArrayExtra;
        try {
            a poll = a.poll();
            if (poll == null) {
                return;
            }
            PushMessageReceiver m64a = poll.m64a();
            Intent a2 = poll.a();
            switch (a2.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1)) {
                case 1:
                    PushMessageHandler.a a3 = an.a(context).a(a2);
                    int intExtra = a2.getIntExtra("eventMessageType", -1);
                    if (a3 != null) {
                        if (!(a3 instanceof MiPushMessage)) {
                            if (a3 instanceof MiPushCommandMessage) {
                                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                                com.xiaomi.channel.commonutils.logger.b.m52a("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                                m64a.onCommandResult(context, miPushCommandMessage);
                                if (TextUtils.equals(miPushCommandMessage.getCommand(), fg.COMMAND_REGISTER.f318a)) {
                                    m64a.onReceiveRegisterResult(context, miPushCommandMessage);
                                    PushMessageHandler.a(context, miPushCommandMessage);
                                    if (miPushCommandMessage.getResultCode() == 0) {
                                        h.b(context);
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
                            m64a.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            fb.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004, (String) null);
                            com.xiaomi.channel.commonutils.logger.b.m52a("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                            m64a.onReceivePassThroughMessage(context, miPushMessage);
                            return;
                        } else if (!miPushMessage.isNotified()) {
                            m64a.onNotificationMessageArrived(context, miPushMessage);
                            return;
                        } else {
                            if (intExtra == 1000) {
                                fb.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, (String) null);
                            } else {
                                fb.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007, (String) null);
                            }
                            com.xiaomi.channel.commonutils.logger.b.m52a("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                            m64a.onNotificationMessageClicked(context, miPushMessage);
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    com.xiaomi.channel.commonutils.logger.b.m52a("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    m64a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), fg.COMMAND_REGISTER.f318a)) {
                        m64a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            h.b(context);
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
                    com.xiaomi.channel.commonutils.logger.b.m52a("begin execute onRequirePermissions, lack of necessary permissions");
                    m64a.onRequirePermissions(context, stringArrayExtra);
                    return;
            }
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        com.xiaomi.push.ai.a(context).a(new aa(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo70a() {
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
