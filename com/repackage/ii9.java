package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class ii9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Activity a;
    public final /* synthetic */ ei9 b;
    public final /* synthetic */ di9 c;

    public ii9(di9 di9Var, Activity activity, ei9 ei9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {di9Var, activity, ei9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = di9Var;
        this.a = activity;
        this.b = ei9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                aVar = this.c.d;
                String str = this.a.getApplicationInfo().packageName;
                di9 di9Var = this.c;
                l = di9.l();
                aVar.a(str, Collections.singletonList(l), new Bundle(), new com.google.ar.core.x(this, atomicBoolean));
                new Handler().postDelayed(new ji9(this, atomicBoolean), 3000L);
            } catch (RemoteException e) {
                Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
                di9 di9Var2 = this.c;
                di9.n(this.a, this.b);
            }
        }
    }
}
