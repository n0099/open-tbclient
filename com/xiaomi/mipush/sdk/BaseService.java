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
    private a f13784a;

    /* loaded from: classes6.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<BaseService> f13785a;

        public a(WeakReference<BaseService> weakReference) {
            this.f13785a = weakReference;
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
                    if (this.f13785a == null || (baseService = this.f13785a.get()) == null) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler" + baseService.toString() + "  kill self");
                    if (!baseService.mo98a()) {
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
    protected abstract boolean mo98a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f13784a == null) {
            this.f13784a = new a(new WeakReference(this));
        }
        this.f13784a.a();
    }
}
