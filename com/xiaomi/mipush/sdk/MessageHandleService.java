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
/* loaded from: classes12.dex */
public class MessageHandleService extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f4736a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f27a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Intent f4737a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f28a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f28a = pushMessageReceiver;
            this.f4737a = intent;
        }

        public Intent a() {
            return this.f4737a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m67a() {
            return this.f28a;
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
            f4736a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (f27a.isShutdown()) {
            return;
        }
        f27a.execute(new ab(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        String[] stringArrayExtra;
        try {
            a poll = f4736a.poll();
            if (poll == null) {
                return;
            }
            PushMessageReceiver m67a = poll.m67a();
            Intent a2 = poll.a();
            switch (a2.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1)) {
                case 1:
                    PushMessageHandler.a a3 = an.a(context).a(a2);
                    int intExtra = a2.getIntExtra("eventMessageType", -1);
                    if (a3 != null) {
                        if (!(a3 instanceof MiPushMessage)) {
                            if (a3 instanceof MiPushCommandMessage) {
                                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                                com.xiaomi.channel.commonutils.logger.b.m55a("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                                m67a.onCommandResult(context, miPushCommandMessage);
                                if (TextUtils.equals(miPushCommandMessage.getCommand(), fg.COMMAND_REGISTER.f320a)) {
                                    m67a.onReceiveRegisterResult(context, miPushCommandMessage);
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
                            m67a.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            fb.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004, (String) null);
                            com.xiaomi.channel.commonutils.logger.b.m55a("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                            m67a.onReceivePassThroughMessage(context, miPushMessage);
                            return;
                        } else if (!miPushMessage.isNotified()) {
                            m67a.onNotificationMessageArrived(context, miPushMessage);
                            return;
                        } else {
                            if (intExtra == 1000) {
                                fb.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, (String) null);
                            } else {
                                fb.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007, (String) null);
                            }
                            com.xiaomi.channel.commonutils.logger.b.m55a("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                            m67a.onNotificationMessageClicked(context, miPushMessage);
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    com.xiaomi.channel.commonutils.logger.b.m55a("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    m67a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), fg.COMMAND_REGISTER.f320a)) {
                        m67a.onReceiveRegisterResult(context, miPushCommandMessage2);
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
                    com.xiaomi.channel.commonutils.logger.b.m55a("begin execute onRequirePermissions, lack of necessary permissions");
                    m67a.onRequirePermissions(context, stringArrayExtra);
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
    protected boolean mo73a() {
        return f4736a != null && f4736a.size() > 0;
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
