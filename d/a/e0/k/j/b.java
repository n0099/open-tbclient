package d.a.e0.k.j;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e0.h;
import d.a.e0.k.a.c;
import d.a.e0.k.a.f;
import d.a.e0.k.b.d;
import d.a.e0.k.j.a;
import d.a.e0.n.g;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends d.a.e0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.e0.k.j.a f42671a;

        public a(d.a.e0.k.j.a aVar) {
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
                    return;
                }
            }
            this.f42671a = aVar;
        }

        @Override // d.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                a.C0591a c0591a = new a.C0591a();
                c0591a.f42667a = 2;
                c0591a.f42668b = g.a().getResources().getString(h.calculate_price_default_error);
                this.f42671a.a(c0591a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.e0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.C0591a c0591a = new a.C0591a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        c0591a.f42667a = 0;
                        c0591a.f42668b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        optJSONObject.optLong("totalAmount");
                        c0591a.f42669c = optJSONObject.optLong("userPayAmount");
                        c0591a.f42670d = optJSONObject.optString("usedhostMarketingDetail");
                    } else {
                        c0591a.f42667a = jSONObject.optInt("errorLevel", 2);
                        c0591a.f42668b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    c0591a.f42667a = 2;
                    c0591a.f42668b = g.a().getResources().getString(h.calculate_price_default_error);
                }
                this.f42671a.a(c0591a);
            }
        }
    }

    public static void a(String str, String str2, String str3, List<String> list, d.a.e0.k.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, str, str2, str3, list, aVar) == null) {
            c cVar = new c();
            if (!TextUtils.isEmpty(str)) {
                cVar.e("Cookie", "BDUSS=" + str);
            }
            d.a.e0.k.a.b bVar = new d.a.e0.k.a.b();
            bVar.e("appKey", str2);
            bVar.e("totalAmount", str3);
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            jSONArray.put(new JSONObject(str4));
                        } catch (Exception unused) {
                        }
                    }
                }
                bVar.e("hostMarketingDetail", jSONArray.toString());
            }
            new f().a(d.c(), cVar, bVar, new a(aVar));
        }
    }
}
