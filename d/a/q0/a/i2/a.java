package d.a.q0.a.i2;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.i2.d.c;
import d.a.q0.a.k;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48951e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f48952f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.i2.d.b f48953a;

    /* renamed from: b  reason: collision with root package name */
    public c f48954b;

    /* renamed from: c  reason: collision with root package name */
    public b f48955c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.i2.c.a f48956d;

    /* renamed from: d.a.q0.a.i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0837a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.i2.d.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f48957b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48957b = null;
            }
        }

        public JSONObject c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("extra", this.f48957b);
                } catch (JSONException e2) {
                    if (d.a.q0.a.i2.d.a.f48960a) {
                        Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0837a c0837a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(117917959, "Ld/a/q0/a/i2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(117917959, "Ld/a/q0/a/i2/a;");
                return;
            }
        }
        f48951e = k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48953a = new d.a.q0.a.i2.d.b();
        this.f48954b = new c();
        this.f48955c = new b(this, null);
        this.f48956d = new d.a.q0.a.i2.c.a();
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f48952f == null) {
                synchronized (a.class) {
                    if (f48952f == null) {
                        f48952f = new a();
                    }
                }
            }
            return f48952f;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48953a.c();
            this.f48954b.b();
            this.f48955c.b();
        }
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(e());
            jSONArray.put(g());
            jSONArray.put(c());
            return this.f48956d.d(jSONArray);
        }
        return (File) invokeV.objValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject c2 = this.f48955c.c();
            if (f48951e) {
                Log.d("SwanStabilityTracer", "extraTraces: " + c2);
            }
            return c2;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject d2 = this.f48953a.d();
            if (f48951e) {
                Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
            }
            return d2;
        }
        return (JSONObject) invokeV.objValue;
    }

    public d.a.q0.a.i2.c.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48956d : (d.a.q0.a.i2.c.a) invokeV.objValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject c2 = this.f48954b.c();
            if (f48951e) {
                Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
            }
            return c2;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            this.f48954b.a(jSONObject);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            j(str, null);
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.f48953a.a(str, str2);
        }
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            this.f48953a.b(jSONObject);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f48955c.f48957b == null || this.f48955c.f48957b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f48956d.d(jSONArray);
    }
}
