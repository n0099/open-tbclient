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
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.g.a {
    public static AtomicBoolean SW = new AtomicBoolean(false);
    public static volatile Message SX;
    public HandlerC0380a SU = new HandlerC0380a((byte) 0);
    public Messenger SV = new Messenger(this.SU);

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class HandlerC0380a extends Handler {
        public WeakReference<Service> SZ;

        public HandlerC0380a() {
        }

        public /* synthetic */ HandlerC0380a(byte b) {
            this();
        }

        public final void a(@Nullable Service service) {
            if (service != null) {
                this.SZ = new WeakReference<>(service);
            } else {
                this.SZ = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            b.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.SZ;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.ry().get()) {
                b.d("RemoteService", "save buffered message");
                a.SX = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            b.d("RemoteService", "handleMessage what: " + i);
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            f.a(service, new f.b() { // from class: com.kwad.sdk.collector.a.a.a.1
                @Override // com.kwad.sdk.utils.f.b
                public final void m(List<com.kwad.sdk.collector.model.b> list) {
                    b.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        b.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray y = f.a.y(list);
                        String jSONArray = y != null ? y.toString() : null;
                        b.d("RemoteService", "resultJson :" + jSONArray);
                        if (jSONArray != null) {
                            AppStatusRules yV = f.yV();
                            ArrayList<AppStatusRules.Strategy> allStrategy = yV != null ? yV.getAllStrategy() : null;
                            String jSONArray2 = allStrategy != null ? r.B(allStrategy).toString() : null;
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

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        b.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
    }

    public static boolean aQ(Context context) {
        String processName = an.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        b.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            b.printStackTrace(e);
        }
    }

    public static AtomicBoolean ry() {
        return SW;
    }

    @Override // com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.SV.getBinder();
    }

    @Override // com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(an.getProcessName(service.getApplicationContext()));
            } catch (Exception e) {
                b.d("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        b.d("RemoteService", "onCreate processName:" + an.getProcessName(service));
        if (SystemUtil.isInMainProcess(service)) {
            SW.set(true);
        } else {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.a.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void bg(String str) {
                    b.e("RemoteService", "onLoadError: " + str);
                    a.SW.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    b.d("RemoteService", "onLoaded");
                    a.SW.set(true);
                    if (a.SX != null) {
                        a.this.SU.handleMessage(a.SX);
                        a.SX = null;
                    }
                }
            });
        }
        this.SU.a(service);
    }

    @Override // com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        b.d("RemoteService", MissionEvent.MESSAGE_DESTROY);
        this.SU.a(null);
        if (aQ(service)) {
            b.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }
}
