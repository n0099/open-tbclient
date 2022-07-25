package com.sdk.d;

import android.os.Process;
import android.os.SystemClock;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.e;
import com.sdk.d.e;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class c extends e.c<Params, Result> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ e b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = eVar;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, Result] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public Result call() {
        InterceptResult invokeV;
        AtomicBoolean atomicBoolean;
        ?? a;
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            atomicBoolean = this.b.f;
            atomicBoolean.set(true);
            Process.setThreadPriority(10);
            e eVar = this.b;
            Object[] objArr2 = this.a;
            com.sdk.a.e eVar2 = (com.sdk.a.e) eVar;
            if (eVar2.p != e.a.e && objArr2 != null && objArr2.length != 0) {
                if (objArr2.length == 4) {
                    String valueOf = String.valueOf(objArr2[1]);
                    eVar2.t = valueOf;
                    eVar2.u = valueOf != null;
                    eVar2.v = (Boolean) objArr2[2];
                    eVar2.w = (Boolean) objArr2[3];
                }
                if (objArr2.length == 2) {
                    eVar2.x = (Boolean) objArr2[1];
                }
                try {
                    eVar2.s = SystemClock.uptimeMillis();
                    eVar2.a(1);
                    com.sdk.a.g gVar = (com.sdk.a.g) objArr2[0];
                    String a2 = gVar.a();
                    eVar2.o = a2;
                    HttpURLConnection a3 = gVar.a(a2, false);
                    if (a3 == null) {
                        objArr = new Object[]{4, new com.sdk.a.i(0, eVar2.b(), false)};
                    } else {
                        com.sdk.a.i b = eVar2.b(gVar, a3);
                        if (b.a() == 0) {
                            objArr = new Object[]{4, b};
                        } else {
                            eVar2.a(3, Integer.valueOf(b.a()), b.b());
                        }
                    }
                    eVar2.a(objArr);
                } catch (Exception e) {
                    com.sdk.n.b.c(e.toString());
                    com.sdk.n.a.a("PriorityAsyncTask", "网络访问异常：\n" + e.toString(), eVar2.h);
                    eVar2.a(3, 302002, "网络访问异常");
                }
            }
            a = eVar.a((e) null);
            return a;
        }
        return invokeV.objValue;
    }
}
