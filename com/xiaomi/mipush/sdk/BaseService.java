package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public abstract class BaseService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private a f13786a;

    /* loaded from: classes6.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<BaseService> f13787a;

        public a(WeakReference<BaseService> weakReference) {
            this.f13787a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaseService baseService;
            switch (message.what) {
                case 1001:
                    if (this.f13787a == null || (baseService = this.f13787a.get()) == null) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler" + baseService.toString() + "  kill self");
                    if (!baseService.mo97a()) {
                        baseService.stopSelf();
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler has job");
                    sendEmptyMessageDelayed(1001, 1000L);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    protected abstract boolean mo97a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f13786a == null) {
            this.f13786a = new a(new WeakReference(this));
        }
        this.f13786a.a();
    }
}
