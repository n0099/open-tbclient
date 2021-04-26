package com.ksad.download.c;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.ksad.download.DownloadTask;
import com.ksad.download.d;
import com.kwad.sdk.b.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public d f32411a;

    /* renamed from: c  reason: collision with root package name */
    public Service f32413c;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f32412b = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HandlerC0361a f32414d = new HandlerC0361a(this);

    /* renamed from: com.ksad.download.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0361a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<a> f32415a;

        public HandlerC0361a(a aVar) {
            this.f32415a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f32415a.get();
            if (aVar != null && message.what == 1) {
                if (aVar.f32411a == null || !aVar.f32411a.d()) {
                    sendEmptyMessageDelayed(1, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
                } else {
                    aVar.f32413c.stopSelf();
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
            Integer num = this.f32412b.get(stringExtra);
            if (intExtra == 1) {
                this.f32412b.put(stringExtra, Integer.valueOf(this.f32411a.a(downloadRequest, (com.ksad.download.c) null)));
            } else if (intExtra == 2) {
                this.f32411a.d(num.intValue());
            } else if (intExtra == 3) {
                this.f32411a.e(num.intValue());
            } else if (intExtra == 4) {
                this.f32411a.c(num.intValue());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.b.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.f32413c = service;
        this.f32411a = d.a();
        this.f32414d.sendEmptyMessageDelayed(1, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    @Override // com.kwad.sdk.b.c, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i2, int i3) {
        a(intent);
        return super.onStartCommand(service, intent, i2, i3);
    }
}
