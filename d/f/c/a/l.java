package d.f.c.a;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.session.XRSessionAnchor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.ab;
import com.google.ar.core.exceptions.FatalException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Runnable> f70793a;

    /* renamed from: b  reason: collision with root package name */
    public Context f70794b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f70795c;

    /* renamed from: d  reason: collision with root package name */
    public com.google.a.b.a.a.a.a f70796d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f70797e;

    /* renamed from: f  reason: collision with root package name */
    public Context f70798f;

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f70799g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<c> f70800h;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(Activity activity, Bundle bundle, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, activity, bundle, mVar) == null) {
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
    }

    public static Bundle l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("package.name", XRSessionAnchor.apkinfo);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public static void n(Activity activity, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, activity, mVar) == null) {
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ar.core")));
            } catch (ActivityNotFoundException e2) {
                mVar.b(new FatalException("Failed to launch installer.", e2));
            }
        }
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                p();
                int i2 = this.f70795c - 1;
                if (i2 == 1 || i2 == 2) {
                    this.f70794b.unbindService(this.f70799g);
                    this.f70794b = null;
                    this.f70795c = s.f70814a;
                }
                if (this.f70797e != null) {
                    this.f70798f.unregisterReceiver(this.f70797e);
                }
            }
        }
    }

    public void c(Activity activity, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, mVar) == null) {
            c cVar = new c(activity, mVar);
            c andSet = this.f70800h.getAndSet(cVar);
            if (andSet != null) {
                andSet.a();
            }
            cVar.start();
            if (this.f70797e == null) {
                p pVar = new p(this, mVar);
                this.f70797e = pVar;
                this.f70798f = activity;
                activity.registerReceiver(pVar, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"));
            }
            try {
                k(new q(this, activity, mVar));
            } catch (ab unused) {
                Log.w("ARCore-InstallService", "requestInstall bind failed, launching fullscreen.");
                n(activity, mVar);
            }
        }
    }

    public synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            synchronized (this) {
                this.f70794b = context;
                if (context.bindService(new Intent("com.google.android.play.core.install.BIND_INSTALL_SERVICE").setPackage("com.android.vending"), this.f70799g, 1)) {
                    this.f70795c = s.f70815b;
                    return;
                }
                this.f70795c = s.f70814a;
                this.f70794b = null;
                Log.w("ARCore-InstallService", "bindService returned false.");
                context.unbindService(this.f70799g);
            }
        }
    }

    public synchronized void e(Context context, ArCoreApk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            synchronized (this) {
                try {
                    k(new o(this, context, aVar));
                } catch (ab unused) {
                    Log.e("ARCore-InstallService", "Play Store install service could not be bound.");
                    aVar.a(ArCoreApk.Availability.UNKNOWN_ERROR);
                }
            }
        }
    }

    public final synchronized void f(IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iBinder) == null) {
            synchronized (this) {
                com.google.a.b.a.a.a.a a2 = com.google.a.b.a.a.a.b.a(iBinder);
                Log.i("ARCore-InstallService", "Install service connected");
                this.f70796d = a2;
                this.f70795c = s.f70816c;
                for (Runnable runnable : this.f70793a) {
                    runnable.run();
                }
            }
        }
    }

    public final synchronized void k(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            synchronized (this) {
                int i2 = this.f70795c - 1;
                if (i2 == 0) {
                    throw new ab();
                }
                if (i2 == 1) {
                    this.f70793a.offer(runnable);
                    return;
                }
                if (i2 == 2) {
                    runnable.run();
                }
            }
        }
    }

    public final void p() {
        c andSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (andSet = this.f70800h.getAndSet(null)) == null) {
            return;
        }
        andSet.a();
    }

    public final synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                Log.i("ARCore-InstallService", "Install service disconnected");
                this.f70795c = s.f70814a;
                this.f70796d = null;
                p();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(byte b2) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Byte.valueOf(b2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70793a = new ArrayDeque();
        this.f70795c = s.f70814a;
        this.f70799g = new n(this);
        this.f70800h = new AtomicReference<>();
    }
}
