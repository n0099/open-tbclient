package d.n.a.a;

import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.n.a.a.c.a.a;
/* loaded from: classes10.dex */
public final class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f75158e;

    public e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75158e = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        int i2;
        int i3;
        Context context2;
        String str;
        d dVar;
        d dVar2;
        Context context3;
        d dVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                context = this.f75158e.f75128a;
                if (context == null) {
                    dVar3 = this.f75158e.f75133f;
                    dVar3.a(-3, "parameter error");
                    return;
                }
                i2 = b.f75126g;
                if (i2 == -1) {
                    context3 = this.f75158e.f75128a;
                    if (context3.getPackageName().equals(d.n.a.a.c.b.e.a(Process.myPid()))) {
                        int unused = b.f75126g = 1;
                    } else {
                        int unused2 = b.f75126g = 0;
                    }
                }
                i3 = b.f75126g;
                if (i3 == 0) {
                    dVar2 = this.f75158e.f75133f;
                    dVar2.a(-4, "need main process");
                    return;
                }
                b bVar = this.f75158e;
                context2 = this.f75158e.f75128a;
                bVar.f75129b = context2.getPackageName();
                a a2 = a.a();
                str = this.f75158e.f75129b;
                a2.d(str);
                b bVar2 = this.f75158e;
                dVar = this.f75158e.f75133f;
                bVar2.i(dVar);
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }
}
