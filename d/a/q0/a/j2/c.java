package d.a.q0.a.j2;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f49026e;

        public a(c cVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49026e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.j2.b.k("777", this.f49026e);
                d.a.q0.a.e0.d.h("SwanAppBusinessUbc", this.f49026e.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f49027a;

        /* renamed from: b  reason: collision with root package name */
        public String f49028b;

        /* renamed from: c  reason: collision with root package name */
        public String f49029c;

        /* renamed from: d  reason: collision with root package name */
        public String f49030d;

        /* renamed from: e  reason: collision with root package name */
        public String f49031e;

        /* renamed from: f  reason: collision with root package name */
        public String f49032f;

        /* renamed from: g  reason: collision with root package name */
        public String f49033g;

        /* renamed from: h  reason: collision with root package name */
        public String f49034h;

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49027a = new c(null);
            this.f49029c = String.valueOf(i2);
            this.f49028b = "swan";
        }

        public b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f49033g = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f49034h = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f49032f = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f49030d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f49031e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f49027a.b(this);
            }
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bVar.f49028b)) {
                jSONObject.put("from", bVar.f49028b);
            }
            if (!TextUtils.isEmpty(bVar.f49029c)) {
                jSONObject.put("type", bVar.f49029c);
            }
            if (!TextUtils.isEmpty(bVar.f49031e)) {
                jSONObject.put("value", bVar.f49031e);
            }
            if (!TextUtils.isEmpty(bVar.f49030d)) {
                jSONObject.put("source", bVar.f49030d);
            }
            if (!TextUtils.isEmpty(bVar.f49032f)) {
                jSONObject.put("page", bVar.f49032f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f49033g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f49034h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f49033g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f49034h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            q.j(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (d.a.q0.a.k.f49133a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
