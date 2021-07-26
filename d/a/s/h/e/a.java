package d.a.s.h.e;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.g.c.a.b;
import d.a.s.g.c.a.e;
import d.a.s.g.d.a;
import d.a.s.h.a;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.s.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1904a f67947d;

    /* renamed from: e  reason: collision with root package name */
    public C1907a f67948e;

    /* renamed from: d.a.s.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1907a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67949a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67950b;

        /* renamed from: c  reason: collision with root package name */
        public e f67951c;

        /* renamed from: d  reason: collision with root package name */
        public String f67952d;

        /* renamed from: e  reason: collision with root package name */
        public String f67953e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67954f;

        public C1907a(a aVar) {
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
            this.f67954f = aVar;
            this.f67950b = true;
            this.f67951c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67952d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f67952d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67952d = str;
                this.f67950b = true;
            }
        }

        public void c(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || this.f67949a == j) {
                return;
            }
            this.f67949a = j;
            this.f67950b = true;
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f67953e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67953e = str;
                this.f67950b = true;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                String g2 = this.f67954f.f67947d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f67952d = jSONObject.optString("form_id");
                    this.f67949a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f67953e = jSONObject.getString("uuid");
                    this.f67951c.b(jSONObject.getLong("flags"));
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
                if (this.f67950b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f67952d);
                        jSONObject.put("lst_fe_ts", this.f67949a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f67951c.d());
                        jSONObject.put("uuid", this.f67953e);
                        this.f67954f.f67947d.i("cache.dat", jSONObject.toString(), true);
                        this.f67950b = false;
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
        this.f67948e = new C1907a(this);
    }

    @Override // d.a.s.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67948e.a() : (String) invokeV.objValue;
    }

    @Override // d.a.s.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f67947d = this.f67922a.f(e());
            this.f67948e.e();
            if (TextUtils.isEmpty(this.f67948e.a())) {
                String uuid = UUID.randomUUID().toString();
                this.f67948e.d(uuid);
                try {
                    this.f67948e.b(d.a.s.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f67948e.c(System.currentTimeMillis());
            }
            this.f67948e.f();
        }
    }
}
