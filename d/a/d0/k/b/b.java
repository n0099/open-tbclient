package d.a.d0.k.b;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.RouterCallback;
import d.a.d0.h;
import d.a.d0.k.a.e;
import d.a.d0.k.a.f;
import d.a.d0.n.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f42056b = "payChannel";

    /* renamed from: c  reason: collision with root package name */
    public static String f42057c = "payType";

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f42058d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f42059a;

    /* loaded from: classes7.dex */
    public class a extends d.a.d0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.k.a.a f42060a;

        public a(b bVar, d.a.d0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42060a = aVar;
        }

        @Override // d.a.d0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                d.a.d0.k.h.a.f("7");
                this.f42060a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(RouterCallback.KEY_ERROR_CODE, -1);
                    int optInt2 = jSONObject.optInt("errno", -1);
                    if (optInt == 0 && optInt2 == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null) {
                            d.a.d0.k.h.a.d("7", optInt2 + "", jSONObject.optString("msg"));
                            d.a.d0.k.a.a aVar = this.f42060a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("msg = ");
                            sb.append(jSONObject.optString("msg"));
                            aVar.b(new com.baidu.poly.a.i.b(sb.toString()), "data is empty");
                        } else {
                            this.f42060a.a(optJSONObject);
                        }
                    } else {
                        d.a.d0.k.h.a.d("7", optInt2 + "", jSONObject.optString("errmsg"));
                        d.a.d0.k.a.a aVar2 = this.f42060a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("errmsg = ");
                        sb2.append(jSONObject.optString("errmsg"));
                        com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("errno is ");
                        sb3.append(optInt2);
                        aVar2.b(bVar, sb3.toString());
                    }
                } catch (JSONException e2) {
                    d.a.d0.k.h.a.d("7", null, null);
                    this.f42060a.b(e2, "error");
                }
            }
        }
    }

    /* renamed from: d.a.d0.k.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0574b extends d.a.d0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.k.a.a f42061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f42062b;

        public C0574b(b bVar, d.a.d0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42062b = bVar;
            this.f42061a = aVar;
        }

        @Override // d.a.d0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                d.a.d0.k.h.a.f("8");
                this.f42061a.b(th, g.a().getResources().getString(h.common_error_tips));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f42061a.a(this.f42062b.i(jSONObject.optJSONObject("data")));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(optInt);
                        sb.append("");
                        d.a.d0.k.h.a.d("8", sb.toString(), jSONObject.optString("msg"));
                        d.a.d0.k.a.a aVar = this.f42061a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("msg = ");
                        sb2.append(jSONObject.optString("msg"));
                        aVar.b(new com.baidu.poly.a.i.b(sb2.toString()), jSONObject.optString("msg"));
                    }
                } catch (Throwable th) {
                    d.a.d0.k.h.a.d("8", null, null);
                    this.f42061a.b(th, g.a().getResources().getString(h.common_error_tips));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.d0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.k.a.a f42063a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f42064b;

        public c(b bVar, d.a.d0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42064b = bVar;
            this.f42063a = aVar;
        }

        @Override // d.a.d0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                d.a.d0.k.h.a.f("8");
                this.f42063a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f42063a.a(this.f42064b.i(jSONObject.optJSONObject("data")));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(optInt);
                        sb.append("");
                        d.a.d0.k.h.a.d("8", sb.toString(), jSONObject.optString("msg"));
                        d.a.d0.k.a.a aVar = this.f42063a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("msg = ");
                        sb2.append(jSONObject.optString("msg"));
                        com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("errno is ");
                        sb3.append(optInt);
                        aVar.b(bVar, sb3.toString());
                    }
                } catch (Throwable th) {
                    d.a.d0.k.h.a.d("8", null, null);
                    this.f42063a.b(th, "error");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.d0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.k.a.a f42065a;

        public d(b bVar, d.a.d0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42065a = aVar;
        }

        @Override // d.a.d0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f42065a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f42065a.a(jSONObject.optJSONObject("data"));
                        return;
                    }
                    d.a.d0.k.a.a aVar = this.f42065a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("msg = ");
                    sb.append(jSONObject.optString("msg"));
                    com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("errno is ");
                    sb2.append(optInt);
                    aVar.b(bVar, sb2.toString());
                } catch (Throwable th) {
                    this.f42065a.b(th, "error");
                }
            }
        }
    }

    public b(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42059a = eVar;
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f42058d == null) {
                synchronized (b.class) {
                    if (f42058d == null) {
                        f42058d = new b(new f());
                    }
                }
            }
            return f42058d;
        }
        return (b) invokeV.objValue;
    }

    public d.a.d0.k.a.b a(Bundle bundle, d.a.d0.k.a.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, cVar)) == null) {
            d.a.d0.k.a.b bVar = new d.a.d0.k.a.b();
            f(bVar, bundle);
            bVar.e(f42057c, "android");
            e(bundle, bVar, cVar);
            return bVar;
        }
        return (d.a.d0.k.a.b) invokeLL.objValue;
    }

    public void c(Bundle bundle, d.a.d0.k.a.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, aVar) == null) {
            d.a.d0.k.a.c k = k();
            Set<String> keySet = bundle.keySet();
            d.a.d0.k.a.b bVar = new d.a.d0.k.a.b();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    bVar.e(str, bundle.get(str).toString());
                }
            }
            e(bundle, bVar, k);
            this.f42059a.a(d.a.d0.k.b.d.d(), k, bVar, new a(this, aVar));
        }
    }

    public void d(Bundle bundle, d.a.d0.k.a.a<Map<String, String>> aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, aVar, str) == null) {
            d.a.d0.k.a.c k = k();
            Set<String> keySet = bundle.keySet();
            d.a.d0.k.a.b bVar = new d.a.d0.k.a.b();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    bVar.e(str2, bundle.get(str2).toString());
                }
            }
            bVar.e(f42056b, str);
            e(bundle, bVar, k);
            this.f42059a.a(d.a.d0.k.b.d.f(), k, bVar, new C0574b(this, aVar));
        }
    }

    public final void e(Bundle bundle, d.a.d0.k.a.b bVar, d.a.d0.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, bVar, cVar) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String b2 = cVar.b("Cookie");
            String str = "BDUSS=" + string;
            if (b2 == null) {
                cVar.e("Cookie", str);
                return;
            }
            cVar.e("Cookie", b2 + "; " + str);
        }
    }

    public final void f(d.a.d0.k.a.b bVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, bVar, bundle) == null) || bundle == null || bVar == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            bVar.e(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = bVar.c().entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    public void g(Bundle bundle, d.a.d0.k.a.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, aVar) == null) {
            d.a.d0.k.a.c k = k();
            Set<String> keySet = bundle.keySet();
            d.a.d0.k.a.b bVar = new d.a.d0.k.a.b();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    bVar.e(str, bundle.get(str).toString());
                }
            }
            this.f42059a.a(d.a.d0.k.b.d.h(), k, bVar, new d(this, aVar));
        }
    }

    public void h(Bundle bundle, d.a.d0.k.a.a<Map<String, String>> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, aVar) == null) {
            d.a.d0.k.a.c k = k();
            d.a.d0.k.a.b a2 = a(bundle, k);
            this.f42059a.a(d.a.d0.k.b.d.g(), k, a2, new c(this, aVar));
        }
    }

    public final Map<String, String> i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            Map<String, String> a2 = d.a.d0.n.e.a();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        a2.put(next, jSONObject.optString(next));
                    }
                }
            }
            return a2;
        }
        return (Map) invokeL.objValue;
    }

    public final d.a.d0.k.a.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new d.a.d0.k.a.c() : (d.a.d0.k.a.c) invokeV.objValue;
    }
}
