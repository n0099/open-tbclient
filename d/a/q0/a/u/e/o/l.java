package d.a.q0.a.u.e.o;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f51113a;

    /* renamed from: b  reason: collision with root package name */
    public final String f51114b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f51115c;

    public l(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51113a = str;
        this.f51114b = str2;
        this.f51115c = jSONObject.optBoolean("useEvent");
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, unitedSchemeEntity, callbackHandler) == null) && this.f51115c) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f51114b);
        }
    }

    public void b(d.a.q0.a.u.c.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) && this.f51115c) {
            dVar.d(this.f51114b, new d.a.q0.a.u.h.b(0));
        }
    }

    public void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, jSONObject) == null) {
            if (this.f51115c) {
                d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.f(this.f51113a, new d.a.q0.a.u.h.b(0, jSONObject)));
                return;
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f51114b);
        }
    }

    public void d(d.a.q0.a.u.c.d dVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, dVar, jSONObject) == null) {
            d.a.q0.a.u.h.b bVar = new d.a.q0.a.u.h.b(0, jSONObject);
            if (this.f51115c) {
                d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.f(this.f51113a, bVar));
            } else {
                dVar.d(this.f51114b, bVar);
            }
        }
    }

    public void e(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, str) == null) {
            if (this.f51115c) {
                d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.f(this.f51113a, new d.a.q0.a.u.h.b(1001, str)));
                return;
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f51114b);
        }
    }

    public void f(d.a.q0.a.u.c.d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, dVar, str) == null) {
            d.a.q0.a.u.h.b bVar = new d.a.q0.a.u.h.b(1001, str);
            if (this.f51115c) {
                d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.f(this.f51113a, bVar));
            } else {
                dVar.d(this.f51114b, bVar);
            }
        }
    }
}
