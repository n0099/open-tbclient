package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class MessageHandleService extends IntentService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

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

    public MessageHandleService() {
        super("MessageHandleThread");
    }

    public static void addJob(a aVar) {
        if (aVar != null) {
            a.add(aVar);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        a poll;
        if (intent == null || (poll = a.poll()) == null) {
            return;
        }
        try {
            PushMessageReceiver a2 = poll.a();
            Intent b = poll.b();
            switch (b.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1)) {
                case 1:
                    PushMessageHandler.a a3 = s.a(this).a(b);
                    if (a3 != null) {
                        if (!(a3 instanceof MiPushMessage)) {
                            if (a3 instanceof MiPushCommandMessage) {
                                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                                a2.onCommandResult(this, miPushCommandMessage);
                                if (TextUtils.equals(miPushCommandMessage.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                                    a2.onReceiveRegisterResult(this, miPushCommandMessage);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        MiPushMessage miPushMessage = (MiPushMessage) a3;
                        if (!miPushMessage.isArrivedMessage()) {
                            a2.onReceiveMessage(this, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            a2.onReceivePassThroughMessage(this, miPushMessage);
                            return;
                        } else if (miPushMessage.isNotified()) {
                            a2.onNotificationMessageClicked(this, miPushMessage);
                            return;
                        } else {
                            a2.onNotificationMessageArrived(this, miPushMessage);
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) b.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    a2.onCommandResult(this, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                        a2.onReceiveRegisterResult(this, miPushCommandMessage2);
                        return;
                    }
                    return;
                case 4:
                    return;
            }
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
