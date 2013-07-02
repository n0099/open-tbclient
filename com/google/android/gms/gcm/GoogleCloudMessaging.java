package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes.dex */
public class GoogleCloudMessaging {
    final BlockingQueue a = new LinkedBlockingQueue();
    private Handler b = new Handler(Looper.getMainLooper()) { // from class: com.google.android.gms.gcm.GoogleCloudMessaging.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GoogleCloudMessaging.this.a.add((Intent) message.obj);
        }
    };
    private Messenger c = new Messenger(this.b);
}
