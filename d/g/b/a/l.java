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
    public final Queue<Runnable> f66159a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66160b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f66161c;

    /* renamed from: d  reason: collision with root package name */
    public com.google.a.b.a.a.a.a f66162d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f66163e;

    /* renamed from: f  reason: collision with root package name */
    public Context f66164f;

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f66165g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<c> f66166h;

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
        int i2 = this.f66161c - 1;
        if (i2 == 1 || i2 == 2) {
            this.f66160b.unbindService(this.f66165g);
            this.f66160b = null;
            this.f66161c = s.f66180a;
        }
        if (this.f66163e != null) {
            this.f66164f.unregisterReceiver(this.f66163e);
        }
    }

    public void c(Activity activity, m mVar) {
        c cVar = new c(activity, mVar);
        c andSet = this.f66166h.getAndSet(cVar);
        if (andSet != null) {
            andSet.a();
        }
        cVar.start();
        if (this.f66163e == null) {
            p pVar = new p(this, mVar);
            this.f66163e = pVar;
            this.f66164f = activity;
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
        this.f66160b = context;
        if (context.bindService(new Intent("com.google.android.play.core.install.BIND_INSTALL_SERVICE").setPackage("com.android.vending"), this.f66165g, 1)) {
            this.f66161c = s.f66181b;
            return;
        }
        this.f66161c = s.f66180a;
        this.f66160b = null;
        Log.w("ARCore-InstallService", "bindService returned false.");
        context.unbindService(this.f66165g);
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
        this.f66162d = a2;
        this.f66161c = s.f66182c;
        for (Runnable runnable : this.f66159a) {
            runnable.run();
        }
    }

    public final synchronized void k(Runnable runnable) {
        int i2 = this.f66161c - 1;
        if (i2 == 0) {
            throw new ab();
        }
        if (i2 == 1) {
            this.f66159a.offer(runnable);
            return;
        }
        if (i2 == 2) {
            runnable.run();
        }
    }

    public final void p() {
        c andSet = this.f66166h.getAndSet(null);
        if (andSet != null) {
            andSet.a();
        }
    }

    public final synchronized void q() {
        Log.i("ARCore-InstallService", "Install service disconnected");
        this.f66161c = s.f66180a;
        this.f66162d = null;
        p();
    }

    public l(byte b2) {
        this();
        this.f66159a = new ArrayDeque();
        this.f66161c = s.f66180a;
        this.f66165g = new n(this);
        this.f66166h = new AtomicReference<>();
    }
}
