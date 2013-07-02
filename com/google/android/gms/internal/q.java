package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.internal.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class q implements Handler.Callback {
    private static q a;
    private final Context b;
    private final HashMap c = new HashMap();
    private final Handler d;

    /* loaded from: classes.dex */
    final class a {
        final /* synthetic */ q a;
        private final String b;
        private final ServiceConnectionC0037a c;
        private final HashSet d;
        private int e;
        private IBinder f;
        private ComponentName g;

        /* renamed from: com.google.android.gms.internal.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class ServiceConnectionC0037a implements ServiceConnection {
            final /* synthetic */ a a;

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.a.a.c) {
                    this.a.f = iBinder;
                    this.a.g = componentName;
                    Iterator it = this.a.d.iterator();
                    while (it.hasNext()) {
                        ((p.e) it.next()).onServiceConnected(componentName, iBinder);
                    }
                    this.a.e = 1;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.a.a.c) {
                    this.a.f = null;
                    this.a.g = componentName;
                    Iterator it = this.a.d.iterator();
                    while (it.hasNext()) {
                        ((p.e) it.next()).onServiceDisconnected(componentName);
                    }
                    this.a.e = 2;
                }
            }
        }

        public ServiceConnectionC0037a a() {
            return this.c;
        }

        public void a(p.e eVar) {
            this.d.remove(eVar);
        }

        public String b() {
            return this.b;
        }

        public boolean b(p.e eVar) {
            return this.d.contains(eVar);
        }

        public boolean c() {
            return this.d.isEmpty();
        }
    }

    private q(Context context) {
        this.d = new Handler(context.getMainLooper(), this);
        this.b = context.getApplicationContext();
    }

    public static q a(Context context) {
        if (a == null) {
            a = new q(context.getApplicationContext());
        }
        return a;
    }

    public void a(String str, p.e eVar) {
        synchronized (this.c) {
            a aVar = (a) this.c.get(str);
            if (aVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            }
            if (!aVar.b(eVar)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
            aVar.a(eVar);
            if (aVar.c()) {
                this.d.sendMessageDelayed(this.d.obtainMessage(0, aVar), 5000L);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                a aVar = (a) message.obj;
                synchronized (this.c) {
                    if (aVar.c()) {
                        this.b.unbindService(aVar.a());
                        this.c.remove(aVar.b());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
