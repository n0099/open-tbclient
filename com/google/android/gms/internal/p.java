package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.t;
import com.google.android.gms.internal.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class p implements GooglePlayServicesClient {
    public static final String[] e = {"service_esmobile", "service_googleme"};
    final Handler a;
    final ArrayList b;
    boolean c;
    boolean d;
    private final Context f;
    private IInterface g;
    private ArrayList h;
    private boolean i;
    private ArrayList j;
    private boolean k;
    private final ArrayList l;
    private e m;
    private final String[] n;
    private final Object o;

    /* loaded from: classes.dex */
    final class a extends Handler {
        final /* synthetic */ p a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (this.a.o) {
                this.a.d = false;
            }
            if (message.what == 3) {
                this.a.a(new ConnectionResult(((Integer) message.obj).intValue(), null));
            } else if (message.what == 4) {
                synchronized (this.a.h) {
                    if (this.a.c && this.a.f() && this.a.h.contains(message.obj)) {
                        ((GooglePlayServicesClient.ConnectionCallbacks) message.obj).a(this.a.d());
                    }
                }
            } else if (message.what != 2 || this.a.f()) {
                if (message.what == 2 || message.what == 1) {
                    ((b) message.obj).b();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class b {
        private Object a;

        public b(Object obj) {
            this.a = obj;
            synchronized (p.this.l) {
                p.this.l.add(this);
            }
        }

        public void a() {
            synchronized (this) {
                this.a = null;
            }
        }

        protected abstract void a(Object obj);

        public void b() {
            Object obj;
            synchronized (this) {
                obj = this.a;
            }
            a(obj);
        }
    }

    /* loaded from: classes.dex */
    public abstract class c extends b {
        protected final k d;

        public c(Object obj, k kVar) {
            super(obj);
            this.d = kVar;
        }

        @Override // com.google.android.gms.internal.p.b
        public /* bridge */ /* synthetic */ void a() {
            super.a();
        }

        @Override // com.google.android.gms.internal.p.b
        public /* bridge */ /* synthetic */ void b() {
            super.b();
        }
    }

    /* loaded from: classes.dex */
    public final class d extends t.a {
        protected d() {
        }

        @Override // com.google.android.gms.internal.t
        public void a(int i, IBinder iBinder, Bundle bundle) {
            p.this.a.sendMessage(p.this.a.obtainMessage(1, new f(i, iBinder, bundle)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class e implements ServiceConnection {
        final /* synthetic */ p a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.a.c(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.a.g = null;
            this.a.i();
        }
    }

    /* loaded from: classes.dex */
    public final class f extends b {
        public final int a;
        public final Bundle b;
        public final IBinder c;

        public f(int i, IBinder iBinder, Bundle bundle) {
            super(true);
            this.a = i;
            this.c = iBinder;
            this.b = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(Boolean bool) {
            if (bool == null) {
                return;
            }
            switch (this.a) {
                case 0:
                    try {
                        if (p.this.c().equals(this.c.getInterfaceDescriptor())) {
                            p.this.g = p.this.b(this.c);
                            if (p.this.g != null) {
                                p.this.e();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    q.a(p.this.f).a(p.this.b(), p.this.m);
                    p.this.m = null;
                    p.this.g = null;
                    p.this.a(new ConnectionResult(8, null));
                    return;
                case 10:
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    p.this.a(new ConnectionResult(this.a, this.b != null ? (PendingIntent) this.b.getParcelable("pendingIntent") : null));
                    return;
            }
        }
    }

    public void a() {
        this.c = false;
        synchronized (this.o) {
            this.d = false;
        }
        synchronized (this.l) {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                ((b) this.l.get(i)).a();
            }
            this.l.clear();
        }
        this.g = null;
        if (this.m != null) {
            q.a(this.f).a(b(), this.m);
            this.m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ConnectionResult connectionResult) {
        this.a.removeMessages(4);
        synchronized (this.j) {
            this.k = true;
            ArrayList arrayList = this.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (!this.c) {
                    return;
                }
                if (this.j.contains(arrayList.get(i))) {
                    ((GooglePlayServicesClient.OnConnectionFailedListener) arrayList.get(i)).a(connectionResult);
                }
            }
            this.k = false;
        }
    }

    public void a(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        x.a(connectionCallbacks);
        synchronized (this.h) {
            if (this.h.contains(connectionCallbacks)) {
                Log.w("GmsClient", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                if (this.i) {
                    this.h = new ArrayList(this.h);
                }
                this.h.add(connectionCallbacks);
            }
        }
        if (f()) {
            this.a.sendMessage(this.a.obtainMessage(4, connectionCallbacks));
        }
    }

    public void a(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        x.a(onConnectionFailedListener);
        synchronized (this.j) {
            if (this.j.contains(onConnectionFailedListener)) {
                Log.w("GmsClient", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                if (this.k) {
                    this.j = new ArrayList(this.j);
                }
                this.j.add(onConnectionFailedListener);
            }
        }
    }

    public final void a(b bVar) {
        this.a.sendMessage(this.a.obtainMessage(2, bVar));
    }

    protected abstract void a(u uVar, d dVar);

    protected abstract IInterface b(IBinder iBinder);

    protected abstract String b();

    public boolean b(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        x.a(connectionCallbacks);
        synchronized (this.h) {
            contains = this.h.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean b(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        x.a(onConnectionFailedListener);
        synchronized (this.j) {
            contains = this.j.contains(onConnectionFailedListener);
        }
        return contains;
    }

    protected abstract String c();

    protected final void c(IBinder iBinder) {
        try {
            a(u.a.a(iBinder), new d());
        } catch (RemoteException e2) {
            Log.w("GmsClient", "service died");
        }
    }

    public void c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        x.a(connectionCallbacks);
        synchronized (this.h) {
            if (this.h != null) {
                if (this.i) {
                    this.h = new ArrayList(this.h);
                }
                if (!this.h.remove(connectionCallbacks)) {
                    Log.w("GmsClient", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
                } else if (this.i && !this.b.contains(connectionCallbacks)) {
                    this.b.add(connectionCallbacks);
                }
            }
        }
    }

    public void c(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        x.a(onConnectionFailedListener);
        synchronized (this.j) {
            if (this.j != null) {
                if (this.k) {
                    this.j = new ArrayList(this.j);
                }
                if (!this.j.remove(onConnectionFailedListener)) {
                    Log.w("GmsClient", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
                }
            }
        }
    }

    protected Bundle d() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        synchronized (this.h) {
            x.a(!this.i);
            this.a.removeMessages(4);
            this.i = true;
            x.a(this.b.size() == 0);
            Bundle d2 = d();
            ArrayList arrayList = this.h;
            int size = arrayList.size();
            for (int i = 0; i < size && this.c && f(); i++) {
                this.b.size();
                if (!this.b.contains(arrayList.get(i))) {
                    ((GooglePlayServicesClient.ConnectionCallbacks) arrayList.get(i)).a(d2);
                }
            }
            this.b.clear();
            this.i = false;
        }
    }

    public boolean f() {
        return this.g != null;
    }

    public final Context g() {
        return this.f;
    }

    public final String[] h() {
        return this.n;
    }

    protected final void i() {
        this.a.removeMessages(4);
        synchronized (this.h) {
            this.i = true;
            ArrayList arrayList = this.h;
            int size = arrayList.size();
            for (int i = 0; i < size && this.c; i++) {
                if (this.h.contains(arrayList.get(i))) {
                    ((GooglePlayServicesClient.ConnectionCallbacks) arrayList.get(i)).a();
                }
            }
            this.i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        if (!f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IInterface k() {
        j();
        return this.g;
    }
}
