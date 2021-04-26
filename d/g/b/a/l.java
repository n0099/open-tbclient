package d.g.b.a;

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
import com.baidu.ar.session.XRSessionAnchor;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.ab;
import com.google.ar.core.exceptions.FatalException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Runnable> f65473a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65474b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f65475c;

    /* renamed from: d  reason: collision with root package name */
    public com.google.a.b.a.a.a.a f65476d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f65477e;

    /* renamed from: f  reason: collision with root package name */
    public Context f65478f;

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f65479g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<c> f65480h;

    public l() {
    }

    public static void b(Activity activity, Bundle bundle, m mVar) {
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("resolution.intent");
        if (pendingIntent != null) {
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1234, new Intent(activity, activity.getClass()), 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException e2) {
                mVar.b(new FatalException("Installation Intent failed", e2));
                return;
            }
        }
        Log.e("ARCore-InstallService", "Did not get pending intent.");
        mVar.b(new FatalException("Installation intent failed to unparcel."));
    }

    public static Bundle l() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("package.name", XRSessionAnchor.apkinfo);
        return bundle;
    }

    public static void n(Activity activity, m mVar) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ar.core")));
        } catch (ActivityNotFoundException e2) {
            mVar.b(new FatalException("Failed to launch installer.", e2));
        }
    }

    public synchronized void a() {
        p();
        int i2 = this.f65475c - 1;
        if (i2 == 1 || i2 == 2) {
            this.f65474b.unbindService(this.f65479g);
            this.f65474b = null;
            this.f65475c = s.f65494a;
        }
        if (this.f65477e != null) {
            this.f65478f.unregisterReceiver(this.f65477e);
        }
    }

    public void c(Activity activity, m mVar) {
        c cVar = new c(activity, mVar);
        c andSet = this.f65480h.getAndSet(cVar);
        if (andSet != null) {
            andSet.a();
        }
        cVar.start();
        if (this.f65477e == null) {
            p pVar = new p(this, mVar);
            this.f65477e = pVar;
            this.f65478f = activity;
            activity.registerReceiver(pVar, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"));
        }
        try {
            k(new q(this, activity, mVar));
        } catch (ab unused) {
            Log.w("ARCore-InstallService", "requestInstall bind failed, launching fullscreen.");
            n(activity, mVar);
        }
    }

    public synchronized void d(Context context) {
        this.f65474b = context;
        if (context.bindService(new Intent("com.google.android.play.core.install.BIND_INSTALL_SERVICE").setPackage("com.android.vending"), this.f65479g, 1)) {
            this.f65475c = s.f65495b;
            return;
        }
        this.f65475c = s.f65494a;
        this.f65474b = null;
        Log.w("ARCore-InstallService", "bindService returned false.");
        context.unbindService(this.f65479g);
    }

    public synchronized void e(Context context, ArCoreApk.a aVar) {
        try {
            k(new o(this, context, aVar));
        } catch (ab unused) {
            Log.e("ARCore-InstallService", "Play Store install service could not be bound.");
            aVar.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }

    public final synchronized void f(IBinder iBinder) {
        com.google.a.b.a.a.a.a a2 = com.google.a.b.a.a.a.b.a(iBinder);
        Log.i("ARCore-InstallService", "Install service connected");
        this.f65476d = a2;
        this.f65475c = s.f65496c;
        for (Runnable runnable : this.f65473a) {
            runnable.run();
        }
    }

    public final synchronized void k(Runnable runnable) throws ab {
        int i2 = this.f65475c - 1;
        if (i2 == 0) {
            throw new ab();
        }
        if (i2 == 1) {
            this.f65473a.offer(runnable);
            return;
        }
        if (i2 == 2) {
            runnable.run();
        }
    }

    public final void p() {
        c andSet = this.f65480h.getAndSet(null);
        if (andSet != null) {
            andSet.a();
        }
    }

    public final synchronized void q() {
        Log.i("ARCore-InstallService", "Install service disconnected");
        this.f65475c = s.f65494a;
        this.f65476d = null;
        p();
    }

    public l(byte b2) {
        this();
        this.f65473a = new ArrayDeque();
        this.f65475c = s.f65494a;
        this.f65479g = new n(this);
        this.f65480h = new AtomicReference<>();
    }
}
