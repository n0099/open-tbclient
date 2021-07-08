package e.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f72279a;

    /* loaded from: classes8.dex */
    public static class a implements Callable<SharedPreferences> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Context f72280e;

        /* renamed from: f  reason: collision with root package name */
        public final String f72281f;

        /* renamed from: g  reason: collision with root package name */
        public final b f72282g;

        public a(Context context, String str, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72280e = context;
            this.f72281f = str;
            this.f72282g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public SharedPreferences call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                SharedPreferences sharedPreferences = this.f72280e.getSharedPreferences(this.f72281f, 0);
                b bVar = this.f72282g;
                if (bVar != null) {
                    bVar.a(sharedPreferences);
                }
                return sharedPreferences;
            }
            return (SharedPreferences) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(SharedPreferences sharedPreferences);
    }

    public p() {
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
        this.f72279a = Executors.newSingleThreadExecutor();
    }

    public Future<SharedPreferences> a(Context context, String str, b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, bVar)) == null) {
            FutureTask futureTask = new FutureTask(new a(context, str, bVar));
            this.f72279a.execute(futureTask);
            return futureTask;
        }
        return (Future) invokeLLL.objValue;
    }
}
