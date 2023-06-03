package com.sdk.d;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.e;
import com.sdk.d.e;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* loaded from: classes10.dex */
public class c<Params, Result> extends e.c<Params, Result> {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0054 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d6 -> B:38:0x010f). Please submit an issue!!! */
    @Override // java.util.concurrent.Callable
    public Result call() {
        InterceptResult invokeV;
        AtomicBoolean atomicBoolean;
        boolean z;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "PriorityAsyncTask";
            atomicBoolean = this.b.f;
            ?? r2 = 1;
            r2 = 1;
            r2 = 1;
            r2 = 1;
            atomicBoolean.set(true);
            Process.setThreadPriority(10);
            e eVar = this.b;
            Params[] paramsArr = this.a;
            com.sdk.a.e eVar2 = (com.sdk.a.e) eVar;
            if (eVar2.p != e.a.e && paramsArr != null && paramsArr.length != 0) {
                if (paramsArr.length == 4) {
                    String valueOf = String.valueOf(paramsArr[1]);
                    eVar2.t = valueOf;
                    if (valueOf != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    eVar2.u = z;
                    eVar2.v = (Boolean) paramsArr[2];
                    eVar2.w = (Boolean) paramsArr[3];
                }
                if (paramsArr.length == 2) {
                    eVar2.x = (Boolean) paramsArr[1];
                }
                try {
                    eVar2.s = SystemClock.uptimeMillis();
                    eVar2.a(1);
                    com.sdk.a.f fVar = (com.sdk.a.f) paramsArr[0];
                    String a2 = fVar.a();
                    eVar2.o = a2;
                    HttpURLConnection a3 = fVar.a(a2, false);
                    if (a3 == null) {
                        eVar2.a(4, new com.sdk.a.h(0, eVar2.b(), false));
                        str = "PriorityAsyncTask";
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("client: ");
                        sb.append(a3);
                        Log.e("PriorityAsyncTask", sb.toString());
                        com.sdk.a.h b = eVar2.b(fVar, a3);
                        if (b.a() == 0) {
                            eVar2.a(4, b);
                            str = "PriorityAsyncTask";
                        } else {
                            eVar2.a(3, Integer.valueOf(b.a()), b.b());
                            str = "PriorityAsyncTask";
                        }
                    }
                } catch (Exception e) {
                    com.sdk.o.b.c(e.toString());
                    com.sdk.o.a.a(str, "HttpHandler：doInBackground\n" + e.toString(), eVar2.h);
                    ?? r0 = new Object[3];
                    r0[0] = 3;
                    r0[r2] = 302002;
                    r0[2] = "网络访问异常";
                    eVar2.a((Object[]) r0);
                    str = r0;
                    r2 = "网络访问异常";
                }
            }
            a = eVar.a((e) null);
            return (Result) a;
        }
        return (Result) invokeV.objValue;
    }
}
