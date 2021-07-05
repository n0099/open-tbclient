package d.a.q0.a.u.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50735c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50736a;

    /* renamed from: b  reason: collision with root package name */
    public d f50737b;

    /* loaded from: classes8.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50738a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f50739b;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50739b = cVar;
            this.f50738a = str;
        }

        @Override // d.a.q0.a.u.c.c.b
        public void a(d.a.q0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f50735c) {
                    Log.d("SwanAutoSyncApiHandler", this.f50739b.f50736a + " async callback: " + bVar.toString());
                }
                this.f50739b.f50737b.d(this.f50738a, bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(d.a.q0.a.u.h.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-297228937, "Ld/a/q0/a/u/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-297228937, "Ld/a/q0/a/u/c/c;");
                return;
            }
        }
        f50735c = k.f49133a;
    }

    public c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50736a = str;
    }

    @NonNull
    public abstract d.a.q0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract d.a.q0.a.u.h.b e(@NonNull JSONObject jSONObject);

    public d.a.q0.a.u.h.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, dVar)) == null) {
            this.f50737b = dVar;
            if (f50735c) {
                Log.d("SwanAutoSyncApiHandler", this.f50736a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
            }
            return i() ? h(jSONObject) : g(jSONObject, str);
        }
        return (d.a.q0.a.u.h.b) invokeLLL.objValue;
    }

    public final d.a.q0.a.u.h.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            if (f50735c) {
                Log.d("SwanAutoSyncApiHandler", this.f50736a + " start handle async");
            }
            d.a.q0.a.u.h.b d2 = d(jSONObject, new a(this, str));
            if (!d2.d("isSync", Boolean.FALSE)) {
                if (f50735c) {
                    Log.e("SwanAutoSyncApiHandler", this.f50736a + " handleAsync encounter error, json exception");
                }
                return new d.a.q0.a.u.h.b(1001, "make result json error");
            }
            if (f50735c) {
                Log.d("SwanAutoSyncApiHandler", this.f50736a + " end handle async, processing in other thread, sync result: " + d2.toString());
            }
            return d2;
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }

    public final d.a.q0.a.u.h.b h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (f50735c) {
                Log.d("SwanAutoSyncApiHandler", this.f50736a + " start handle sync");
            }
            d.a.q0.a.u.h.b e2 = e(jSONObject);
            if (!e2.d("isSync", Boolean.TRUE)) {
                if (f50735c) {
                    Log.e("SwanAutoSyncApiHandler", this.f50736a + " handleSync encounter error, json exception");
                }
                return new d.a.q0.a.u.h.b(1001, "make result json error");
            }
            if (f50735c) {
                Log.d("SwanAutoSyncApiHandler", this.f50736a + " end handle sync, result: " + e2.toString());
            }
            return e2;
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public abstract boolean i();
}
