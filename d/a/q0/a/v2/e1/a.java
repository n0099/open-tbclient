package d.a.q0.a.v2.e1;

import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.v2.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class RunnableC1004a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51331e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f51332f;

        public RunnableC1004a(b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51331e = bVar;
            this.f51332f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51331e.onCallback(this.f51332f);
            }
        }
    }

    public static <T> void a(Handler handler, b<T> bVar, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, handler, bVar, collection) == null) || bVar == null || collection == null || collection.isEmpty()) {
            return;
        }
        for (T t : collection) {
            e(handler, bVar, t);
        }
    }

    public static <T> void b(Handler handler, b<T> bVar, T... tArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, handler, bVar, tArr) == null) || bVar == null || tArr == null || tArr.length < 1) {
            return;
        }
        for (T t : tArr) {
            e(handler, bVar, t);
        }
    }

    public static <T> void c(b<T> bVar, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bVar, collection) == null) {
            a(null, bVar, collection);
        }
    }

    public static <T> void d(b<T> bVar, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bVar, tArr) == null) {
            b(null, bVar, tArr);
        }
    }

    public static <T> void e(Handler handler, b<T> bVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, handler, bVar, t) == null) {
            if (handler == null) {
                bVar.onCallback(t);
            } else {
                handler.post(new RunnableC1004a(bVar, t));
            }
        }
    }
}
