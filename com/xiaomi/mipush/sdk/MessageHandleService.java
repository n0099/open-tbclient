package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.el;
import com.xiaomi.push.ev;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class MessageHandleService extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue<a> f40525a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    public static ExecutorService f43a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Intent f40526a;

        /* renamed from: a  reason: collision with other field name */
        public PushMessageReceiver f44a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f44a = pushMessageReceiver;
            this.f40526a = intent;
        }

        public Intent a() {
            return this.f40526a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m68a() {
            return this.f44a;
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver m68a = aVar.m68a();
            Intent a2 = aVar.a();
            int intExtra = a2.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1);
            if (intExtra == 1) {
                PushMessageHandler.a a3 = al.a(context).a(a2);
                int intExtra2 = a2.getIntExtra("eventMessageType", -1);
                if (a3 == null) {
                    return;
                }
                if (a3 instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) a3;
                    if (!miPushMessage.isArrivedMessage()) {
                        m68a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        el.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004, (String) null);
                        com.xiaomi.channel.commonutils.logger.b.e("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        m68a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    } else if (!miPushMessage.isNotified()) {
                        com.xiaomi.channel.commonutils.logger.b.e("begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                        m68a.onNotificationMessageArrived(context, miPushMessage);
                        return;
                    } else {
                        if (intExtra2 == 1000) {
                            el.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, (String) null);
                        } else {
                            el.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007, (String) null);
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        m68a.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                } else if (!(a3 instanceof MiPushCommandMessage)) {
                    return;
                } else {
                    MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                    com.xiaomi.channel.commonutils.logger.b.e("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                    m68a.onCommandResult(context, miPushCommandMessage);
                    if (!TextUtils.equals(miPushCommandMessage.getCommand(), ev.COMMAND_REGISTER.f337a)) {
                        return;
                    }
                    m68a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() != 0) {
                        return;
                    }
                }
            } else if (intExtra != 3) {
                if (intExtra == 5 && PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a2.getStringExtra(PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = a2.getStringArrayExtra("error_message")) != null) {
                    com.xiaomi.channel.commonutils.logger.b.e("begin execute onRequirePermissions, lack of necessary permissions");
                    m68a.onRequirePermissions(context, stringArrayExtra);
                    return;
                }
                return;
            } else {
                MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                com.xiaomi.channel.commonutils.logger.b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                m68a.onCommandResult(context, miPushCommandMessage2);
                if (!TextUtils.equals(miPushCommandMessage2.getCommand(), ev.COMMAND_REGISTER.f337a)) {
                    return;
                }
                m68a.onReceiveRegisterResult(context, miPushCommandMessage2);
                PushMessageHandler.a(context, miPushCommandMessage2);
                if (miPushCommandMessage2.getResultCode() != 0) {
                    return;
                }
            }
            i.b(context);
        } catch (RuntimeException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            f40525a.add(aVar);
            b(context);
            startService(context);
        }
    }

    public static void b(Context context) {
        if (f43a.isShutdown()) {
            return;
        }
        f43a.execute(new y(context));
    }

    public static void c(Context context) {
        try {
            a(context, f40525a.poll());
        } catch (RuntimeException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        com.xiaomi.push.ai.a(context).a(new x(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    public boolean mo74a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f40525a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
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
