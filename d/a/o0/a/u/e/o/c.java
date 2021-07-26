package d.a.o0.a.u.e.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.r0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f48285e;

        public a(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48285e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.a.o0.a.z1.b.f.e.d()) {
                return;
            }
            d.a.o0.a.z1.b.f.e.f(this.f48285e, d.a.o0.a.h.clipboardapi_tip_content).F();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public d.a.o0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-ClipboardApi", "start get clipboard data");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                CharSequence a2 = r0.b(i()).a();
                jSONObject.put("data", TextUtils.isEmpty(a2) ? "" : a2.toString());
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.i("Api-ClipboardApi", "getClipboardData:  " + jSONObject);
                }
                return new d.a.o0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    e2.printStackTrace();
                }
                return new d.a.o0.a.u.h.b(1001, "JSONException");
            }
        }
        return (d.a.o0.a.u.h.b) invokeV.objValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public d.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-ClipboardApi", "start set clipboard data");
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-ClipboardApi", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-ClipboardApi", "parse fail");
                }
                return bVar;
            }
            r0.b(i()).c(((JSONObject) b2.second).optString("data"));
            d.a.o0.a.a2.e r = d.a.o0.a.a2.d.g().r();
            if (r != null && (x = r.x()) != null) {
                q0.c0(new a(this, x), 200L);
            }
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
