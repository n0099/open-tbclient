package d.a.e0.p.a;

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
    public boolean f42685a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0594a> f42686b;

    /* renamed from: d.a.e0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0594a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42687a;

        /* renamed from: b  reason: collision with root package name */
        public String f42688b;

        /* renamed from: c  reason: collision with root package name */
        public String f42689c;

        /* renamed from: d  reason: collision with root package name */
        public String f42690d;

        /* renamed from: e  reason: collision with root package name */
        public String f42691e;

        /* renamed from: f  reason: collision with root package name */
        public Long f42692f;

        /* renamed from: g  reason: collision with root package name */
        public int f42693g;

        /* renamed from: h  reason: collision with root package name */
        public String f42694h;

        public C0594a() {
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

        public C0594a(JSONObject jSONObject) {
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
            this.f42688b = jSONObject.optString("display_name");
            this.f42689c = jSONObject.optString("pay_text");
            this.f42691e = jSONObject.optString("icon");
            this.f42690d = jSONObject.optString("valid_info");
            this.f42694h = jSONObject.optString("host_marketing_detail");
            this.f42692f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f42693g = jSONObject.optInt("is_selected");
            this.f42687a = jSONObject.optInt("type");
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
        this.f42686b = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                this.f42686b.add(new C0594a(jSONObject));
            }
        }
        this.f42685a = this.f42686b.size() > 1;
    }
}
