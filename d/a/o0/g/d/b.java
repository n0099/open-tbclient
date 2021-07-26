package d.a.o0.g.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.p.d.f1;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements f1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f50202a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.g.d.a f50203b;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.u0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.u0.b f50204a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f50205b;

        public a(b bVar, d.a.o0.a.u0.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50205b = bVar;
            this.f50204a = bVar2;
        }

        @Override // d.a.o0.a.u0.b
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f50205b.g(true);
                this.f50204a.a(jSONObject);
            }
        }

        @Override // d.a.o0.a.u0.b
        public void onFail(int i2, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f50205b.g(false);
                this.f50204a.onFail(i2, str);
            }
        }
    }

    public b() {
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
        this.f50202a = new HashMap<>();
        this.f50203b = new d.a.o0.g.d.a();
    }

    @Override // d.a.o0.a.p.d.f1
    @Nullable
    public d.a.o0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.o0.a.u0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bVar)) == null) {
            if (f()) {
                bVar.a(null);
                return null;
            }
            return this.f50203b.a(jSONObject, c(bVar));
        }
        return (d.a.o0.a.u.h.b) invokeLLL.objValue;
    }

    public final d.a.o0.a.u0.b c(@NonNull d.a.o0.a.u0.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? new a(this, bVar) : (d.a.o0.a.u0.b) invokeL.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e Q = e.Q();
            if (Q != null) {
                return Q.D();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.f50203b.f50207a, str) : invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String d2 = d();
            if (TextUtils.isEmpty(d2) || (bool = this.f50202a.get(d2)) == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            this.f50202a.put(d2, Boolean.valueOf(z));
        }
    }
}
