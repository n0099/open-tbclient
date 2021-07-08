package d.a.d0.p.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42181a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0585a> f42182b;

    /* renamed from: d.a.d0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0585a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42183a;

        /* renamed from: b  reason: collision with root package name */
        public String f42184b;

        /* renamed from: c  reason: collision with root package name */
        public String f42185c;

        /* renamed from: d  reason: collision with root package name */
        public String f42186d;

        /* renamed from: e  reason: collision with root package name */
        public String f42187e;

        /* renamed from: f  reason: collision with root package name */
        public Long f42188f;

        /* renamed from: g  reason: collision with root package name */
        public int f42189g;

        /* renamed from: h  reason: collision with root package name */
        public String f42190h;

        public C0585a() {
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

        public C0585a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (jSONObject == null) {
                return;
            }
            this.f42184b = jSONObject.optString("display_name");
            this.f42185c = jSONObject.optString("pay_text");
            this.f42187e = jSONObject.optString("icon");
            this.f42186d = jSONObject.optString("valid_info");
            this.f42190h = jSONObject.optString("host_marketing_detail");
            this.f42188f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f42189g = jSONObject.optInt("is_selected");
            this.f42183a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (jSONArray == null) {
            return;
        }
        this.f42182b = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                this.f42182b.add(new C0585a(jSONObject));
            }
        }
        this.f42181a = this.f42182b.size() > 1;
    }
}
