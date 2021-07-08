package d.a.r.h.e;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r.g.c.a.b;
import d.a.r.g.c.a.e;
import d.a.r.g.d.a;
import d.a.r.h.a;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1899a f67269d;

    /* renamed from: e  reason: collision with root package name */
    public C1902a f67270e;

    /* renamed from: d.a.r.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1902a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67271a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67272b;

        /* renamed from: c  reason: collision with root package name */
        public e f67273c;

        /* renamed from: d  reason: collision with root package name */
        public String f67274d;

        /* renamed from: e  reason: collision with root package name */
        public String f67275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67276f;

        public C1902a(a aVar) {
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
            this.f67276f = aVar;
            this.f67272b = true;
            this.f67273c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67274d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f67274d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67274d = str;
                this.f67272b = true;
            }
        }

        public void c(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || this.f67271a == j) {
                return;
            }
            this.f67271a = j;
            this.f67272b = true;
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f67275e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67275e = str;
                this.f67272b = true;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                String g2 = this.f67276f.f67269d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f67274d = jSONObject.optString("form_id");
                    this.f67271a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f67275e = jSONObject.getString("uuid");
                    this.f67273c.b(jSONObject.getLong("flags"));
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f67272b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f67274d);
                        jSONObject.put("lst_fe_ts", this.f67271a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f67273c.d());
                        jSONObject.put("uuid", this.f67275e);
                        this.f67276f.f67269d.i("cache.dat", jSONObject.toString(), true);
                        this.f67272b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(CommonUrlParamManager.PARAM_IID);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.f67270e = new C1902a(this);
    }

    @Override // d.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67270e.a() : (String) invokeV.objValue;
    }

    @Override // d.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f67269d = this.f67244a.f(e());
            this.f67270e.e();
            if (TextUtils.isEmpty(this.f67270e.a())) {
                String uuid = UUID.randomUUID().toString();
                this.f67270e.d(uuid);
                try {
                    this.f67270e.b(d.a.r.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f67270e.c(System.currentTimeMillis());
            }
            this.f67270e.f();
        }
    }
}
