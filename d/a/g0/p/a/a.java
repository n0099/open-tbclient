package d.a.g0.p.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f45500a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0636a> f45501b;

    /* renamed from: d.a.g0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0636a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f45502a;

        /* renamed from: b  reason: collision with root package name */
        public String f45503b;

        /* renamed from: c  reason: collision with root package name */
        public String f45504c;

        /* renamed from: d  reason: collision with root package name */
        public String f45505d;

        /* renamed from: e  reason: collision with root package name */
        public String f45506e;

        /* renamed from: f  reason: collision with root package name */
        public Long f45507f;

        /* renamed from: g  reason: collision with root package name */
        public int f45508g;

        /* renamed from: h  reason: collision with root package name */
        public String f45509h;

        public C0636a() {
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

        public C0636a(JSONObject jSONObject) {
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
            this.f45503b = jSONObject.optString("display_name");
            this.f45504c = jSONObject.optString("pay_text");
            this.f45506e = jSONObject.optString("icon");
            this.f45505d = jSONObject.optString("valid_info");
            this.f45509h = jSONObject.optString("host_marketing_detail");
            this.f45507f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f45508g = jSONObject.optInt("is_selected");
            this.f45502a = jSONObject.optInt("type");
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
        this.f45501b = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                this.f45501b.add(new C0636a(jSONObject));
            }
        }
        this.f45500a = this.f45501b.size() > 1;
    }
}
