package d.a.n0.b.l;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.e2.c.i;
import d.a.n0.a.e2.c.j.b;
import d.a.n0.a.u.c.c;
import d.a.n0.a.u.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.b.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1011a extends d.a.n0.a.u.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f48899d;

        /* renamed from: d.a.n0.b.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1012a implements d.a.n0.a.v2.e1.b<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f48900e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1011a f48901f;

            public C1012a(C1011a c1011a, c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1011a, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48901f = c1011a;
                this.f48900e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.n0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (d.a.n0.a.e2.c.d.h(iVar)) {
                        this.f48900e.a(this.f48901f.f48899d.t());
                        return;
                    }
                    int b2 = iVar.b();
                    String f2 = d.a.n0.a.e2.c.d.f(b2);
                    if (d.f47438c) {
                        Log.e("Api-Base-getBduss", "getBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.f48900e.a(new d.a.n0.a.u.h.b(b2, f2));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1011a(a aVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48899d = aVar;
        }

        @Override // d.a.n0.a.u.c.c
        @NonNull
        public d.a.n0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                e Q = e.Q();
                if (Q == null) {
                    if (d.f47438c) {
                        Log.e("Api-Base-getBduss", "getBduss failed: null swan runtime");
                    }
                    return new d.a.n0.a.u.h.b(1001, "null swan runtime");
                }
                Q.T().g(d.a.n0.a.a2.d.g(), "mapp_i_get_bduss", new C1012a(this, bVar));
                return new d.a.n0.a.u.h.b(0);
            }
            return (d.a.n0.a.u.h.b) invokeLL.objValue;
        }

        @Override // d.a.n0.a.u.c.c
        @NonNull
        public d.a.n0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.f48899d.t() : (d.a.n0.a.u.h.b) invokeL.objValue;
        }

        @Override // d.a.n0.a.u.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.n0.a.a2.d.g().C() && d.a.n0.a.a2.d.g().r().T().f("mapp_i_get_bduss") : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.n0.a.u.c.b bVar) {
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
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.a.n0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? k(str, new C1011a(this, "getBDUSS")) : (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    @NonNull
    public final d.a.n0.a.u.h.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String i2 = d.a.n0.b.j.a.i(d.a.n0.a.a2.d.g());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i2);
                if (d.f47438c) {
                    Log.d("Api-Base-getBduss", "getBduss success: " + jSONObject.toString());
                }
                return new d.a.n0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (d.f47438c) {
                    Log.e("Api-Base-getBduss", "getBduss failed: JsonException");
                    e2.printStackTrace();
                }
                return new d.a.n0.a.u.h.b(1001, "result JSONException");
            }
        }
        return (d.a.n0.a.u.h.b) invokeV.objValue;
    }
}
