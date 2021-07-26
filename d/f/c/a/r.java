package d.f.c.a;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class r implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f71266e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f71267f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar, atomicBoolean};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71267f = qVar;
        this.f71266e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f71266e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f71267f;
        l lVar = qVar.f71265g;
        l.n(qVar.f71263e, qVar.f71264f);
    }
}
