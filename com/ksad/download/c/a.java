package com.ksad.download.c;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.ksad.download.DownloadTask;
import com.ksad.download.c;
import com.ksad.download.d;
import com.kwad.sdk.b.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public d f31676a;

    /* renamed from: c  reason: collision with root package name */
    public Service f31678c;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f31677b = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HandlerC0350a f31679d = new HandlerC0350a(this);

    /* renamed from: com.ksad.download.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0350a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<a> f31680a;

        public HandlerC0350a(a aVar) {
            this.f31680a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f31680a.get();
            if (aVar != null && message.what == 1) {
                if (aVar.f31676a == null || !aVar.f31676a.d()) {
                    sendEmptyMessageDelayed(1, 30000L);
                } else {
                    aVar.f31678c.stopSelf();
                }
            }
        }
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            Integer num = this.f31677b.get(stringExtra);
            if (intExtra == 1) {
                this.f31677b.put(stringExtra, Integer.valueOf(this.f31676a.a(downloadRequest, (c) null)));
            } else if (intExtra == 2) {
                this.f31676a.d(num.intValue());
            } else if (intExtra == 3) {
                this.f31676a.e(num.intValue());
            } else if (intExtra == 4) {
                this.f31676a.c(num.intValue());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.f31678c = service;
        this.f31676a = d.a();
        this.f31679d.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i2, int i3) {
        a(intent);
        return super.onStartCommand(service, intent, i2, i3);
    }
}
