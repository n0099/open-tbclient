package com.google.ar.core;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.baidu.platform.comapi.map.NodeType;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.FatalException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes24.dex */
public class w {
    private final Queue<Runnable> a;
    private Context b;
    private volatile int c;
    private Context f;
    private com.google.a.b.a.a.a.a nMG;
    private BroadcastReceiver nMH;
    private final ServiceConnection nMI;
    private final AtomicReference<l> nMJ;

    w() {
    }

    public synchronized void a(Context context) {
        this.b = context;
        if (context.bindService(new Intent("com.google.android.play.core.install.BIND_INSTALL_SERVICE").setPackage("com.android.vending"), this.nMI, 1)) {
            this.c = al.b;
        } else {
            this.c = al.a;
            this.b = null;
            Log.w("ARCore-InstallService", "bindService returned false.");
            context.unbindService(this.nMI);
        }
    }

    public synchronized void a() {
        c();
        switch (this.c - 1) {
            case 1:
            case 2:
                this.b.unbindService(this.nMI);
                this.b = null;
                this.c = al.a;
                break;
        }
        if (this.nMH != null) {
            this.f.unregisterReceiver(this.nMH);
        }
    }

    public synchronized void a(Context context, ArCoreApk.a aVar) {
        try {
            a(new aa(this, context, aVar));
        } catch (ab e) {
            Log.e("ARCore-InstallService", "Play Store install service could not be bound.");
            aVar.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }

    public void a(Activity activity, y yVar) {
        l lVar = new l(activity, yVar);
        l andSet = this.nMJ.getAndSet(lVar);
        if (andSet != null) {
            andSet.a();
        }
        lVar.start();
        if (this.nMH == null) {
            this.nMH = new ac(this, yVar);
            this.f = activity;
            this.f.registerReceiver(this.nMH, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"));
        }
        try {
            a(new aj(this, activity, yVar));
        } catch (ab e) {
            Log.w("ARCore-InstallService", "requestInstall bind failed, launching fullscreen.");
            b(activity, yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(byte b) {
        this();
        this.a = new ArrayDeque();
        this.c = al.a;
        this.nMI = new z(this);
        this.nMJ = new AtomicReference<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, y yVar) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ar.core")));
        } catch (ActivityNotFoundException e) {
            yVar.a(new FatalException("Failed to launch installer.", e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Activity activity, Bundle bundle, y yVar) {
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("resolution.intent");
        if (pendingIntent != null) {
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), NodeType.E_STREET_POI, new Intent(activity, activity.getClass()), 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException e) {
                yVar.a(new FatalException("Installation Intent failed", e));
                return;
            }
        }
        Log.e("ARCore-InstallService", "Did not get pending intent.");
        yVar.a(new FatalException("Installation intent failed to unparcel."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("package.name", "com.google.ar.core");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        l andSet = this.nMJ.getAndSet(null);
        if (andSet != null) {
            andSet.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(IBinder iBinder) {
        com.google.a.b.a.a.a.a a = com.google.a.b.a.a.a.b.a(iBinder);
        Log.i("ARCore-InstallService", "Install service connected");
        this.nMG = a;
        this.c = al.c;
        for (Runnable runnable : this.a) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        Log.i("ARCore-InstallService", "Install service disconnected");
        this.c = al.a;
        this.nMG = null;
        c();
    }

    private synchronized void a(Runnable runnable) throws ab {
        switch (this.c - 1) {
            case 0:
                throw new ab();
            case 1:
                this.a.offer(runnable);
                break;
            case 2:
                runnable.run();
                break;
        }
    }
}
