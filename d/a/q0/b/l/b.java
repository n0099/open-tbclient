package d.a.q0.b.l;

import android.annotation.SuppressLint;
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
import d.a.q0.a.a2.e;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.u.c.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f52205f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f52206g;

        public a(b bVar, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52206g = bVar;
            this.f52204e = str;
            this.f52205f = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.q0.a.e2.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    String f2 = d.a.q0.a.e2.c.d.f(b2);
                    if (d.f50740c) {
                        Log.e("getOpenBduss", "getOpenBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.f52206g.d(this.f52204e, new d.a.q0.a.u.h.b(b2, d.a.q0.a.e2.c.d.f(b2)));
                    return;
                }
                JSONArray optJSONArray = this.f52205f.optJSONArray("tpls");
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(optJSONArray.optString(i2));
                }
                this.f52206g.t(this.f52205f.optString("clientId"), arrayList, this.f52204e);
            }
        }
    }

    /* renamed from: d.a.q0.b.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1064b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52207a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f52208b;

        public C1064b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52208b = bVar;
            this.f52207a = str;
        }

        @Override // d.a.q0.b.l.b.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    this.f52208b.d(this.f52207a, new d.a.q0.a.u.h.b(0, new JSONObject(str)));
                } catch (JSONException e2) {
                    this.f52208b.d(this.f52207a, new d.a.q0.a.u.h.b(10001, "internal error"));
                    if (d.f50740c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.q0.a.u.c.b bVar) {
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
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.a.q0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            e Q = e.Q();
            if (Q == null) {
                if (d.f50740c) {
                    Log.e("getOpenBduss", "getOpenBduss failed: null swan runtime");
                }
                return new d.a.q0.a.u.h.b(1001, "null swan runtime");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Base", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-Base", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.q0.a.u.h.b(201, "empty cb");
            }
            Q.T().g(d.a.q0.a.a2.d.g(), "scope_get_open_bduss", new a(this, optString, jSONObject));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final void t(String str, ArrayList<String> arrayList, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, arrayList, str2) == null) {
            if (!d.a.q0.b.j.a.G(d.a.q0.a.a2.d.g())) {
                d(str2, new d.a.q0.a.u.h.b(202, "user is not logged in or the params are invalid"));
            } else {
                d.a.q0.b.j.a.o(d.a.q0.a.a2.d.g(), str, arrayList, new C1064b(this, str2));
            }
        }
    }
}
