package d.a.o0.a.s.a.j;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.u.c.d;
import d.a.o0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.s.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0891a implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47724e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47725f;

        public C0891a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47725f = aVar;
            this.f47724e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.f47725f.t(this.f47724e);
                    return;
                }
                int b2 = iVar.b();
                String f2 = d.a.o0.a.e2.c.d.f(b2);
                if (d.f47942c) {
                    Log.e("AllianceAccountApi", "getUnionBDUSS failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f47725f.d(this.f47724e, new d.a.o0.a.u.h.b(b2, d.a.o0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.o0.a.u.c.b bVar) {
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

    public d.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.f47942c) {
                Log.d("AllianceAccountApi", "getUnionBduss start: " + str);
            }
            e Q = e.Q();
            if (Q == null) {
                if (d.f47942c) {
                    Log.e("AllianceAccountApi", "getUnionBduss failed: null swan runtime");
                }
                return new d.a.o0.a.u.h.b(1001, "null swan runtime");
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("AllianceAccountApi", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f47942c) {
                    d.a.o0.a.e0.d.b("AllianceAccountApi", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.o0.a.u.h.b(201, "empty cb");
            }
            Q.T().g(d.a.o0.a.a2.d.g(), "account_get_union_bduss", new C0891a(this, optString));
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "bduss", d.a.o0.a.s.a.d.f47707a.a());
            d(str, new d.a.o0.a.u.h.b(0, jSONObject));
        }
    }
}
