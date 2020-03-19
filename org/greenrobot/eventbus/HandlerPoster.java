package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class HandlerPoster extends Handler {
    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerPoster(EventBus eventBus, Looper looper, int i) {
        super(looper);
        this.eventBus = eventBus;
        this.maxMillisInsideHandleMessage = i;
        this.queue = new PendingPostQueue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueue(Subscription subscription, Object obj) {
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(subscription, obj);
        synchronized (this) {
            this.queue.enqueue(obtainPendingPost);
            if (!this.handlerActive) {
                this.handlerActive = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost poll = this.queue.poll();
                if (poll == null) {
                    synchronized (this) {
                        poll = this.queue.poll();
                        if (poll == null) {
                            this.handlerActive = false;
                            return;
                        }
                    }
                }
                this.eventBus.invokeSubscriber(poll);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.maxMillisInsideHandleMessage);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.handlerActive = true;
        } finally {
            this.handlerActive = false;
        }
    }
}
