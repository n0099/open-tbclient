package com.repackage;

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
import com.google.ar.core.exceptions.FatalException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class hm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<Runnable> a;
    public Context b;
    public volatile int c;
    public com.google.a.b.a.a.a.a d;
    public BroadcastReceiver e;
    public Context f;
    public final ServiceConnection g;
    public final AtomicReference<yl9> h;

    public hm9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(Activity activity, Bundle bundle, im9 im9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, activity, bundle, im9Var) == null) {
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("resolution.intent");
            if (pendingIntent != null) {
                try {
                    activity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1234, new Intent(activity, activity.getClass()), 0, 0, 0);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    im9Var.b(new FatalException("Installation Intent failed", e));
                    return;
                }
            }
            Log.e("ARCore-InstallService", "Did not get pending intent.");
            im9Var.b(new FatalException("Installation intent failed to unparcel."));
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

    public static void n(Activity activity, im9 im9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, activity, im9Var) == null) {
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ar.core")));
            } catch (ActivityNotFoundException e) {
                im9Var.b(new FatalException("Failed to launch installer.", e));
            }
        }
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                p();
                int i = this.c - 1;
                if (i == 1 || i == 2) {
                    this.b.unbindService(this.g);
                    this.b = null;
                    this.c = om9.a;
                }
                if (this.e != null) {
                    this.f.unregisterReceiver(this.e);
                }
            }
        }
    }

    public void c(Activity activity, im9 im9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, im9Var) == null) {
            yl9 yl9Var = new yl9(activity, im9Var);
            yl9 andSet = this.h.getAndSet(yl9Var);
            if (andSet != null) {
                andSet.a();
            }
            yl9Var.start();
            if (this.e == null) {
                lm9 lm9Var = new lm9(this, im9Var);
                this.e = lm9Var;
                this.f = activity;
                activity.registerReceiver(lm9Var, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"));
            }
            try {
                k(new mm9(this, activity, im9Var));
            } catch (com.google.ar.core.ab unused) {
                Log.w("ARCore-InstallService", "requestInstall bind failed, launching fullscreen.");
                n(activity, im9Var);
            }
        }
    }

    public synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            synchronized (this) {
                this.b = context;
                if (context.bindService(new Intent("com.google.android.play.core.install.BIND_INSTALL_SERVICE").setPackage("com.android.vending"), this.g, 1)) {
                    this.c = om9.b;
                    return;
                }
                this.c = om9.a;
                this.b = null;
                Log.w("ARCore-InstallService", "bindService returned false.");
                context.unbindService(this.g);
            }
        }
    }

    public synchronized void e(Context context, ArCoreApk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            synchronized (this) {
                try {
                    k(new km9(this, context, aVar));
                } catch (com.google.ar.core.ab unused) {
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
                com.google.a.b.a.a.a.a a = com.google.a.b.a.a.a.b.a(iBinder);
                Log.i("ARCore-InstallService", "Install service connected");
                this.d = a;
                this.c = om9.c;
                for (Runnable runnable : this.a) {
                    runnable.run();
                }
            }
        }
    }

    public final synchronized void k(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            synchronized (this) {
                int i = this.c - 1;
                if (i == 0) {
                    throw new com.google.ar.core.ab();
                }
                if (i == 1) {
                    this.a.offer(runnable);
                    return;
                }
                if (i == 2) {
                    runnable.run();
                }
            }
        }
    }

    public final void p() {
        yl9 andSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (andSet = this.h.getAndSet(null)) == null) {
            return;
        }
        andSet.a();
    }

    public final synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                Log.i("ARCore-InstallService", "Install service disconnected");
                this.c = om9.a;
                this.d = null;
                p();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hm9(byte b) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Byte.valueOf(b)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayDeque();
        this.c = om9.a;
        this.g = new jm9(this);
        this.h = new AtomicReference<>();
    }
}
