package d.a.q0.a.u0;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.u.c.d;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0991a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.u0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f51173a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f51174b;

        public /* synthetic */ b(a aVar, String str, C0991a c0991a) {
            this(aVar, str);
        }

        @Override // d.a.q0.a.u0.b
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f51174b.d(this.f51173a, jSONObject == null ? new d.a.q0.a.u.h.b(0) : new d.a.q0.a.u.h.b(0, jSONObject));
            }
        }

        @Override // d.a.q0.a.u0.b
        public void onFail(int i2, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (d.f50740c && i2 == 0) {
                    Log.e("Api-GameCenterApi", "GameCenterCallback:onFail errCode cannot be ERR_OK.");
                }
                this.f51174b.d(this.f51173a, str == null ? new d.a.q0.a.u.h.b(i2) : new d.a.q0.a.u.h.b(i2, str));
            }
        }

        public b(a aVar, String str) {
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
            this.f51174b = aVar;
            this.f51173a = str;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.u0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
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

        @Override // d.a.q0.a.u0.b
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && d.f50740c) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onSuccess could not be invoked.");
            }
        }

        @Override // d.a.q0.a.u0.b
        public void onFail(int i2, @Nullable String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && d.f50740c) {
                Log.e("Api-GameCenterApi", "GameCenterEmptyCallback:onFail could not be invoked.");
            }
        }

        public /* synthetic */ c(a aVar, C0991a c0991a) {
            this(aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.q0.a.u.c.b bVar) {
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

    public d.a.q0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.f50740c) {
                Log.d("Api-GameCenterApi", "postGameCenterMessage: " + str);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-GameCenterApi", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.q0.a.e0.d.b("Api-GameCenterApi", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("Api-GameCenterApi", "empty cb");
                return new d.a.q0.a.u.h.b(202, "empty cb");
            }
            return t(jSONObject, new b(this, optString, null));
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.f50740c) {
                Log.d("Api-GameCenterApi", "postGameCenterMessageSync: " + str);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-GameCenterApi", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.q0.a.e0.d.b("Api-GameCenterApi", "parse fail");
                return bVar;
            }
            return t((JSONObject) b2.second, new c(this, null));
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final d.a.q0.a.u.h.b t(@NonNull JSONObject jSONObject, @NonNull d.a.q0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, bVar)) == null) {
            String optString = jSONObject.optString(RetrieveTaskManager.KEY);
            if (TextUtils.isEmpty(optString)) {
                return new d.a.q0.a.u.h.b(202, "empty api name");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            d.a.q0.a.u.h.b a2 = d.a.q0.a.c1.a.m0().a(optString, optJSONObject, bVar);
            return a2 == null ? new d.a.q0.a.u.h.b(0) : a2;
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }
}
