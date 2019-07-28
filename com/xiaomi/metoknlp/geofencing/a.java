package com.xiaomi.metoknlp.geofencing;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private Context a;
    private c b;
    private boolean c;
    private Handler g;
    private int d = 0;
    private List<b> e = new ArrayList();
    private List<b> f = new ArrayList();
    private final ServiceConnection h = new com.xiaomi.metoknlp.geofencing.b(this);

    /* renamed from: com.xiaomi.metoknlp.geofencing.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class HandlerC0487a extends Handler {
        public HandlerC0487a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a.a(a.this);
                    a.this.a(a.this.a);
                    Log.w("GeoFencingServiceWrapper", "Try bindService count=" + a.this.d + ",mBinded=" + a.this.c);
                    if (a.this.c || a.this.g == null || a.this.d >= 10) {
                        return;
                    }
                    a.this.g.sendEmptyMessageDelayed(1, 10000L);
                    return;
                case 2:
                    a.this.a();
                    return;
                case 3:
                    a.this.b();
                    return;
                default:
                    Log.w("GeoFencingServiceWrapper", "unknown message type ");
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        public double a;
        public double b;
        public float c;
        public long d;
        public String e;
        public String f;
        public String g;

        public b(double d, double d2, float f, long j, String str, String str2, String str3) {
            this.a = d;
            this.b = d2;
            this.c = f;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
        }
    }

    public a(Context context) {
        this.c = false;
        this.a = context;
        this.c = false;
        a(context);
        HandlerThread handlerThread = new HandlerThread("GeoFencingServiceWrapper");
        handlerThread.start();
        this.g = new HandlerC0487a(handlerThread.getLooper());
        if (this.c) {
            return;
        }
        this.g.sendEmptyMessageDelayed(1, 10000L);
    }

    static /* synthetic */ int a(a aVar) {
        int i = aVar.d;
        aVar.d = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Log.d("GeoFencingServiceWrapper", "try registerPendingFence size=" + (this.e == null ? 0 : this.e.size()));
        for (b bVar : this.e) {
            if (bVar != null && this.b != null) {
                try {
                    this.b.a(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
                } catch (RemoteException e) {
                    Log.w("GeoFencingServiceWrapper", "registerPendingFence:" + e);
                }
            }
        }
        if (this.e != null) {
            this.e.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Log.d("GeoFencingServiceWrapper", "try unregisterPendingFence size=" + (this.f == null ? 0 : this.f.size()));
        for (b bVar : this.f) {
            if (bVar != null && this.b != null) {
                try {
                    this.b.a(bVar.e, bVar.f);
                } catch (RemoteException e) {
                    Log.w("GeoFencingServiceWrapper", "unregisterPendingFence:" + e);
                }
            }
        }
        if (this.f != null) {
            this.f.clear();
        }
    }

    public void a(Context context) {
        if (this.c || context == null) {
            return;
        }
        if (this.b != null) {
            Log.d("GeoFencingServiceWrapper", "GeoFencingService already started");
            return;
        }
        Intent intent = new Intent("com.xiaomi.metoknlp.GeoFencingService");
        intent.setPackage("com.xiaomi.metoknlp");
        try {
            if (context.bindService(intent, this.h, 1)) {
                Log.d("GeoFencingServiceWrapper", "GeoFencingService started");
                this.c = true;
            } else {
                Log.d("GeoFencingServiceWrapper", "Can't bind GeoFencingService");
                this.c = false;
            }
        } catch (SecurityException e) {
            Log.e("GeoFencingServiceWrapper", "SecurityException:" + e);
        }
    }

    public void a(Context context, double d, double d2, float f, long j, String str, String str2, String str3) {
        a(context);
        if (this.b == null) {
            Log.d("GeoFencingServiceWrapper", "registerFenceListener service not ready, add to pending list.");
            this.e.add(new b(d, d2, f, j, str, str2, str3));
            return;
        }
        try {
            this.b.a(d, d2, f, j, str, str2, str3);
            Log.d("GeoFencingServiceWrapper", "calling registerFenceListener success");
        } catch (RemoteException e) {
            throw new RuntimeException("GeoFencingService has died", e);
        }
    }

    public void a(Context context, String str, String str2) {
        a(context);
        if (this.b == null) {
            Log.d("GeoFencingServiceWrapper", "unregisterFenceListener service not ready, add to pending list.");
            this.f.add(new b(0.0d, 0.0d, 0.0f, -1L, str, str2, ""));
            return;
        }
        try {
            this.b.a(str, str2);
            Log.d("GeoFencingServiceWrapper", "calling unregisterFenceListener success");
        } catch (RemoteException e) {
            throw new RuntimeException("GeoFencingService has died", e);
        }
    }
}
