package d.l.a.e.b.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes10.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public static d.l.a.e.b.k.d l;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        l = new d.l.a.e.b.k.d();
    }

    public static void V(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService F0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || (F0 = d.l.a.e.b.g.e.F0()) == null) {
            return;
        }
        F0.invokeAll(list);
    }

    public static List<Future> W(List<Runnable> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ExecutorService F0 = d.l.a.e.b.g.e.F0();
            ArrayList arrayList = new ArrayList(list.size());
            for (Runnable runnable : list) {
                arrayList.add(F0.submit(runnable));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Runnable X(List<Future> list) {
        InterceptResult invokeL;
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                try {
                    ExecutorService F0 = d.l.a.e.b.g.e.F0();
                    if ((F0 instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) F0).getQueue()) != null && !queue.isEmpty()) {
                        Iterator<Future> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                runnable = null;
                                break;
                            }
                            Future next = it.next();
                            if ((next instanceof Runnable) && queue.remove(next)) {
                                runnable = (Runnable) next;
                                break;
                            }
                        }
                        if (runnable != null) {
                            list.remove(runnable);
                            return runnable;
                        }
                    }
                } catch (Throwable th) {
                    d.l.a.e.b.c.a.j("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
                }
            }
            return null;
        }
        return (Runnable) invokeL.objValue;
    }

    @Override // d.l.a.e.b.m.a
    public d.l.a.e.b.k.c D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            d.l.a.e.b.k.d dVar = l;
            if (dVar == null) {
                return null;
            }
            return dVar.e(i2);
        }
        return (d.l.a.e.b.k.c) invokeI.objValue;
    }

    @Override // d.l.a.e.b.m.a
    public List<Integer> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l.a() : (List) invokeV.objValue;
    }

    @Override // d.l.a.e.b.m.a
    public void h(int i2, long j) {
        d.l.a.e.b.k.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || (dVar = l) == null) {
            return;
        }
        dVar.b(i2, j);
    }

    @Override // d.l.a.e.b.m.a
    public void k(int i2, d.l.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        d.l.a.e.b.c.a.g("DownloadTask", "start doDownload for task : " + i2);
        l.c(new d.l.a.e.b.k.c(aVar, this.k));
    }

    @Override // d.l.a.e.b.m.a
    public void l(d.l.a.e.b.k.c cVar) {
        d.l.a.e.b.k.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || (dVar = l) == null) {
            return;
        }
        dVar.g(cVar);
    }

    @Override // d.l.a.e.b.m.a
    public boolean r(int i2) {
        InterceptResult invokeI;
        DownloadInfo G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            d.l.a.e.b.k.d dVar = l;
            if (dVar == null || !dVar.d(i2) || (G = G(i2)) == null) {
                return false;
            }
            if (d.l.a.e.b.d.a.b(G.getStatus())) {
                return true;
            }
            v(i2);
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.m.a
    public void v(int i2) {
        d.l.a.e.b.k.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (dVar = l) == null) {
            return;
        }
        dVar.h(i2);
    }
}
