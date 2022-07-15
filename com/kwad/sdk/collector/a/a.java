package com.kwad.sdk.collector.a;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.h.a {
    public static volatile Message a;
    public static AtomicBoolean d = new AtomicBoolean(false);
    public HandlerC0534a b = new HandlerC0534a((byte) 0);
    public Messenger c = new Messenger(this.b);

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class HandlerC0534a extends Handler {
        public WeakReference<Service> a;

        public HandlerC0534a() {
        }

        public /* synthetic */ HandlerC0534a(byte b) {
            this();
        }

        public final void a(@Nullable Service service) {
            if (service != null) {
                this.a = new WeakReference<>(service);
            } else {
                this.a = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            b.a("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.a;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.a().get()) {
                b.a("RemoteService", "save buffered message");
                a.a = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            b.a("RemoteService", "handleMessage what: " + i);
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            f.a(service, new f.b() { // from class: com.kwad.sdk.collector.a.a.a.1
                @Override // com.kwad.sdk.utils.f.b
                public final void a(List<com.kwad.sdk.collector.model.b> list) {
                    b.a("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        b.a("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray a = f.a.a(list);
                        String jSONArray = a != null ? a.toString() : null;
                        b.a("RemoteService", "resultJson :" + jSONArray);
                        if (jSONArray != null) {
                            AppStatusRules a2 = f.a();
                            ArrayList<AppStatusRules.Strategy> allStrategy = a2 != null ? a2.getAllStrategy() : null;
                            String jSONArray2 = allStrategy != null ? r.b(allStrategy).toString() : null;
                            bundle.putString("resultJson", jSONArray);
                            bundle.putString("allStrategyJson", jSONArray2);
                        }
                    }
                    try {
                        Message obtain = Message.obtain();
                        obtain.what = 101;
                        obtain.setData(bundle);
                        messenger.send(obtain);
                    } catch (RemoteException unused) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        bVar.destroy();
                    }
                }
            });
        }
    }

    public static AtomicBoolean a() {
        return d;
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        b.a("RemoteService", "bindASService");
        context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
    }

    public static boolean a(Context context) {
        String a2 = ak.a(context);
        return (a2 == null || context.getPackageName().equals(a2)) ? false : true;
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        b.a("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            b.a(e);
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.c.getBinder();
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(ak.a(service.getApplicationContext()));
            } catch (Exception e) {
                b.a("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        b.a("RemoteService", "onCreate processName:" + ak.a(service));
        if (SystemUtil.c(service)) {
            d.set(true);
        } else {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.a.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void a() {
                    b.a("RemoteService", "onLoaded");
                    a.d.set(true);
                    if (a.a != null) {
                        a.this.b.handleMessage(a.a);
                        a.a = null;
                    }
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void a(String str) {
                    b.e("RemoteService", "onLoadError: " + str);
                    a.d.set(false);
                }
            });
        }
        this.b.a(service);
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        b.a("RemoteService", MissionEvent.MESSAGE_DESTROY);
        this.b.a(null);
        if (a(service)) {
            b.a("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }
}
