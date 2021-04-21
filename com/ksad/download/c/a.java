package com.ksad.download.c;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
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
    public d f31540a;

    /* renamed from: c  reason: collision with root package name */
    public Service f31542c;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f31541b = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HandlerC0367a f31543d = new HandlerC0367a(this);

    /* renamed from: com.ksad.download.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0367a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<a> f31544a;

        public HandlerC0367a(a aVar) {
            this.f31544a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f31544a.get();
            if (aVar != null && message.what == 1) {
                if (aVar.f31540a == null || !aVar.f31540a.d()) {
                    sendEmptyMessageDelayed(1, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
                } else {
                    aVar.f31542c.stopSelf();
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
            Integer num = this.f31541b.get(stringExtra);
            if (intExtra == 1) {
                this.f31541b.put(stringExtra, Integer.valueOf(this.f31540a.a(downloadRequest, (c) null)));
            } else if (intExtra == 2) {
                this.f31540a.d(num.intValue());
            } else if (intExtra == 3) {
                this.f31540a.e(num.intValue());
            } else if (intExtra == 4) {
                this.f31540a.c(num.intValue());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.f31542c = service;
        this.f31540a = d.a();
        this.f31543d.sendEmptyMessageDelayed(1, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        a(intent);
        return super.onStartCommand(service, intent, i, i2);
    }
}
