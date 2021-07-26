package d.a.o0.n.i.i.g;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f51187e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f51188f;

    /* renamed from: g  reason: collision with root package name */
    public a f51189g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atomicBoolean, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51188f = atomicBoolean;
        this.f51187e = bVar;
        this.f51189g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f51187e.a(fVar);
            try {
                try {
                    fVar.run();
                } catch (Exception e2) {
                    if (d.a.o0.n.c.f51112a) {
                        Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                    }
                }
            } finally {
                this.f51187e.b(fVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.f51188f.get() && (a2 = this.f51189g.a(true)) != null && (a2 instanceof f)) {
                try {
                    a((f) a2);
                } catch (Throwable th) {
                    if (d.a.o0.n.c.f51112a) {
                        Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                    }
                }
            }
        }
    }
}
