package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.l.a {
    public com.kwad.sdk.c aMo;
    public Service aMq;
    public final Map<String, Integer> aMp = new ConcurrentHashMap();
    public final HandlerC0726a aMr = new HandlerC0726a(this);

    /* renamed from: com.kwad.sdk.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0726a extends Handler {
        public final WeakReference<a> aMs;

        public HandlerC0726a(a aVar) {
            this.aMs = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.aMs.get();
            if (aVar != null && message.what == 1) {
                if (aVar.aMo != null && aVar.aMo.xG()) {
                    aVar.aMq.stopSelf();
                } else {
                    sendEmptyMessageDelayed(1, 30000L);
                }
            }
        }
    }

    @InvokeBy(invokerClass = b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        b.a(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.aMq = service;
        this.aMo = com.kwad.sdk.c.xA();
        this.aMr.sendEmptyMessageDelayed(1, 30000L);
    }

    private void g(Intent intent) {
        Integer num;
        if (intent == null) {
            return;
        }
        try {
            int i = 0;
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            if (TextUtils.isEmpty(stringExtra)) {
                num = null;
            } else {
                num = this.aMp.get(stringExtra);
            }
            if (num != null) {
                i = num.intValue();
            }
            if (intExtra != 1) {
                if (intExtra != 2) {
                    if (intExtra != 3) {
                        if (intExtra == 4) {
                            if (i != 0) {
                                this.aMo.cancel(i);
                                return;
                            }
                            String stringExtra2 = intent.getStringExtra("download_service_path");
                            if (stringExtra2 != null) {
                                com.kwad.sdk.c.bL(stringExtra2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.aMo.resume(i);
                    return;
                }
                this.aMo.pause(i);
                return;
            }
            this.aMp.put(stringExtra, Integer.valueOf(this.aMo.a(downloadRequest, (com.kwad.sdk.a) null)));
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        g(intent);
        return super.onStartCommand(service, intent, i, i2);
    }
}
