package com.kwad.sdk.collector.b;

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
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.l.a {
    public static AtomicBoolean ang = new AtomicBoolean(false);
    public static volatile Message anh;
    public HandlerC0695a ane = new HandlerC0695a((byte) 0);
    public Messenger anf = new Messenger(this.ane);

    /* renamed from: com.kwad.sdk.collector.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0695a extends Handler {
        public WeakReference<Service> anj;

        public HandlerC0695a() {
        }

        public /* synthetic */ HandlerC0695a(byte b) {
            this();
        }

        public final void a(@Nullable Service service) {
            if (service != null) {
                this.anj = new WeakReference<>(service);
            } else {
                this.anj = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            Service service;
            super.handleMessage(message);
            c.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.anj;
            if (weakReference != null) {
                service = weakReference.get();
            } else {
                service = null;
            }
            if (service == null) {
                return;
            }
            if (!a.zK().get()) {
                c.d("RemoteService", "save buffered message");
                a.anh = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            c.d("RemoteService", "handleMessage what: " + i);
            if (i == 100) {
                final Bundle bundle = new Bundle();
                f.a(service, new f.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                    @Override // com.kwad.sdk.utils.f.b
                    public final void s(List<b> list) {
                        String str;
                        ArrayList<AppStatusRules.Strategy> arrayList;
                        c.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                        if (list != null && !list.isEmpty()) {
                            c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                            JSONArray H = f.a.H(list);
                            String str2 = null;
                            if (H != null) {
                                str = H.toString();
                            } else {
                                str = null;
                            }
                            c.d("RemoteService", "resultJson :" + str);
                            if (str != null) {
                                AppStatusRules Jq = f.Jq();
                                if (Jq != null) {
                                    arrayList = Jq.getAllStrategy();
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    str2 = t.K(arrayList).toString();
                                }
                                bundle.putString("resultJson", str);
                                bundle.putString("allStrategyJson", str2);
                            }
                        }
                        try {
                            Message obtain = Message.obtain();
                            obtain.what = 101;
                            obtain.setData(bundle);
                            messenger.send(obtain);
                        } catch (RemoteException unused) {
                        }
                        if (list != null && !list.isEmpty()) {
                            for (b bVar : list) {
                                bVar.destroy();
                            }
                        }
                    }
                });
            }
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.a(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable unused) {
        }
    }

    public static AtomicBoolean zK() {
        return ang;
    }

    public static boolean aN(Context context) {
        String processName = aq.getProcessName(context);
        if (processName == null || context.getPackageName().equals(processName)) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        c.d("RemoteService", MissionEvent.MESSAGE_DESTROY);
        this.ane.a(null);
        if (aN(service)) {
            c.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, ServiceProxyRemote.class), serviceConnection, 1);
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.anf.getBinder();
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(aq.getProcessName(service.getApplicationContext()));
            } catch (Exception e) {
                c.d("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        c.d("RemoteService", "onCreate processName:" + aq.getProcessName(service));
        if (!SystemUtil.isInMainProcess(service)) {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void ch(String str) {
                    c.e("RemoteService", "onLoadError: " + str);
                    a.ang.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    c.d("RemoteService", "onLoaded");
                    a.ang.set(true);
                    if (a.anh != null) {
                        a.this.ane.handleMessage(a.anh);
                        a.anh = null;
                    }
                }
            });
        } else {
            ang.set(true);
        }
        this.ane.a(service);
    }
}
