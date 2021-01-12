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
/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private d f7911a;
    private Service c;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Integer> f7912b = new ConcurrentHashMap();
    private final HandlerC1059a d = new HandlerC1059a(this);

    /* renamed from: com.ksad.download.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class HandlerC1059a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a> f7913a;

        public HandlerC1059a(a aVar) {
            this.f7913a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f7913a.get();
            if (aVar == null) {
                return;
            }
            switch (message.what) {
                case 1:
                    if (aVar.f7911a == null || !aVar.f7911a.d()) {
                        sendEmptyMessageDelayed(1, 30000L);
                        return;
                    } else {
                        aVar.c.stopSelf();
                        return;
                    }
                default:
                    return;
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
            Integer num = this.f7912b.get(stringExtra);
            switch (intExtra) {
                case 1:
                    this.f7912b.put(stringExtra, Integer.valueOf(this.f7911a.a(downloadRequest, (c) null)));
                    break;
                case 2:
                    this.f7911a.d(num.intValue());
                    break;
                case 3:
                    this.f7911a.e(num.intValue());
                    break;
                case 4:
                    this.f7911a.c(num.intValue());
                    break;
            }
        } catch (Exception e) {
        }
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.c = service;
        this.f7911a = d.a();
        this.d.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        a(intent);
        return super.onStartCommand(service, intent, i, i2);
    }
}
