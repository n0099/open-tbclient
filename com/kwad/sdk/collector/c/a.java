package com.kwad.sdk.collector.c;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.b.c;
import com.kwad.sdk.collector.AppRunningInfo;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.utils.AppStatusHelper;
import com.kwad.sdk.utils.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public HandlerC0369a f32711a = new HandlerC0369a();

    /* renamed from: b  reason: collision with root package name */
    public Messenger f32712b = new Messenger(this.f32711a);

    /* renamed from: com.kwad.sdk.collector.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0369a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Service> f32713a;

        public HandlerC0369a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(Context context) {
            String a2 = aa.a(context);
            if (a2 == null) {
                return false;
            }
            return !context.getPackageName().equals(a2);
        }

        public void a(@Nullable Service service) {
            if (service != null) {
                this.f32713a = new WeakReference<>(service);
            } else {
                this.f32713a = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            WeakReference<Service> weakReference = this.f32713a;
            final Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            final Messenger messenger = message.replyTo;
            if (message.what != 100) {
                return;
            }
            AppStatusHelper.a(service, new AppStatusHelper.b() { // from class: com.kwad.sdk.collector.c.a.a.1
                @Override // com.kwad.sdk.utils.AppStatusHelper.b
                public void a(List<AppRunningInfo> list) {
                    com.kwad.sdk.core.d.a.a("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                    ArrayList arrayList = new ArrayList(list);
                    Message obtain = Message.obtain();
                    obtain.what = 101;
                    ArrayList<AppStatusRules.Strategy> allStrategy = AppStatusHelper.a().getAllStrategy();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data", arrayList);
                    bundle.putSerializable("allStrategy", allStrategy);
                    obtain.setData(bundle);
                    try {
                        messenger.send(obtain);
                    } catch (RemoteException unused) {
                    }
                    service.stopSelf();
                    if (HandlerC0369a.this.a((Context) service)) {
                        com.kwad.sdk.core.d.a.a("RemoteService", "gotta kill myself");
                        Process.killProcess(Process.myPid());
                    }
                }
            });
        }
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.b.c, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.f32712b.getBinder();
    }

    @Override // com.kwad.sdk.b.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        com.kwad.sdk.core.d.a.a("RemoteService", "onCreate processName:" + aa.a(service));
        this.f32711a.a(service);
    }

    @Override // com.kwad.sdk.b.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        this.f32711a.a((Service) null);
    }
}
