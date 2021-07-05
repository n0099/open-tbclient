package d.f.c.a;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.u;
/* loaded from: classes10.dex */
public final class o implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f73701e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArCoreApk.a f73702f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f73703g;

    public o(l lVar, Context context, ArCoreApk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73703g = lVar;
        this.f73701e = context;
        this.f73702f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                aVar = this.f73703g.f73693d;
                String str = this.f73701e.getApplicationInfo().packageName;
                l lVar = this.f73703g;
                l = l.l();
                aVar.a(str, l, new u(this));
            } catch (RemoteException e2) {
                Log.e("ARCore-InstallService", "requestInfo threw", e2);
                this.f73702f.a(ArCoreApk.Availability.UNKNOWN_ERROR);
            }
        }
    }
}
