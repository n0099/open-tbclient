package com.kwad.sdk.collector.b;

import android.app.ActivityManager;
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
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.h.c;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class a extends c {
    public static volatile Message a;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f39195d = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public HandlerC1948a f39196b = new HandlerC1948a();

    /* renamed from: c  reason: collision with root package name */
    public Messenger f39197c = new Messenger(this.f39196b);

    /* renamed from: com.kwad.sdk.collector.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC1948a extends Handler {
        public WeakReference<Service> a;

        public HandlerC1948a() {
        }

        public void a(@Nullable Service service) {
            if (service != null) {
                this.a = new WeakReference<>(service);
            } else {
                this.a = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            com.kwad.sdk.core.d.a.a("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.a;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.a().get()) {
                com.kwad.sdk.core.d.a.a("RemoteService", "save buffered message");
                a.a = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            com.kwad.sdk.core.d.a.a("RemoteService", "handleMessage what: " + i);
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            h.a(service, new h.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                @Override // com.kwad.sdk.utils.h.b
                public void a(List<b> list) {
                    com.kwad.sdk.core.d.a.a("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        com.kwad.sdk.core.d.a.a("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray a = h.a.a(list);
                        String jSONArray = a != null ? a.toString() : null;
                        com.kwad.sdk.core.d.a.a("RemoteService", "resultJson :" + jSONArray);
                        if (jSONArray != null) {
                            AppStatusRules a2 = h.a();
                            ArrayList<AppStatusRules.Strategy> allStrategy = a2 != null ? a2.getAllStrategy() : null;
                            String jSONArray2 = allStrategy != null ? t.b(allStrategy).toString() : null;
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
                    for (b bVar : list) {
                        bVar.destroy();
                    }
                }
            });
        }
    }

    public static AtomicBoolean a() {
        return f39195d;
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        com.kwad.sdk.core.d.a.a("RemoteService", "bindASService");
        context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
    }

    public static boolean a(Context context) {
        String a2 = al.a(context);
        if (a2 == null) {
            return false;
        }
        return !context.getPackageName().equals(a2);
    }

    private String b(Context context) {
        if (context == null) {
            return "ksad_remote";
        }
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "ksad_remote";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "ksad_remote";
        }
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        com.kwad.sdk.core.d.a.a("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.h.c, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.f39197c.getBinder();
    }

    @Override // com.kwad.sdk.h.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(b(service.getApplicationContext()));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a("RemoteService", "WebView has already been initialized " + e2.getMessage());
            }
        }
        com.kwad.sdk.core.d.a.a("RemoteService", "onCreate processName:" + al.a(service));
        if (SystemUtil.b(service)) {
            f39195d.set(true);
        } else {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.d.a
                public void a() {
                    com.kwad.sdk.core.d.a.a("RemoteService", "onLoaded");
                    a.f39195d.set(true);
                    if (a.a != null) {
                        a.this.f39196b.handleMessage(a.a);
                        a.a = null;
                    }
                }

                @Override // com.kwad.sdk.collector.d.a
                public void a(String str) {
                    com.kwad.sdk.core.d.a.e("RemoteService", "onLoadError: " + str);
                    a.f39195d.set(false);
                }
            });
        }
        this.f39196b.a(service);
    }

    @Override // com.kwad.sdk.h.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        com.kwad.sdk.core.d.a.a("RemoteService", MissionEvent.MESSAGE_DESTROY);
        this.f39196b.a(null);
        if (a(service)) {
            com.kwad.sdk.core.d.a.a("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }
}
