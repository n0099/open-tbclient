package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public abstract class BaseService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public a f38035a;

    /* loaded from: classes7.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<BaseService> f38036a;

        public a(WeakReference<BaseService> weakReference) {
            this.f38036a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what != 1001 || (weakReference = this.f38036a) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler" + baseService.toString() + "  kill self");
            if (!baseService.mo77a()) {
                baseService.stopSelf();
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler has job");
            sendEmptyMessageDelayed(1001, 1000L);
        }
    }

    /* renamed from: a */
    public abstract boolean mo77a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (this.f38035a == null) {
            this.f38035a = new a(new WeakReference(this));
        }
        this.f38035a.a();
    }
}
