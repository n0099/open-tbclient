package d.a.t.h.e;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.t.g.c.a.b;
import d.a.t.g.c.a.e;
import d.a.t.g.d.a;
import d.a.t.h.a;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d.a.t.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1937a f70411d;

    /* renamed from: e  reason: collision with root package name */
    public C1940a f70412e;

    /* renamed from: d.a.t.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1940a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f70413a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f70414b;

        /* renamed from: c  reason: collision with root package name */
        public e f70415c;

        /* renamed from: d  reason: collision with root package name */
        public String f70416d;

        /* renamed from: e  reason: collision with root package name */
        public String f70417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f70418f;

        public C1940a(a aVar) {
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
            this.f70418f = aVar;
            this.f70414b = true;
            this.f70415c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70416d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f70416d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f70416d = str;
                this.f70414b = true;
            }
        }

        public void c(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || this.f70413a == j) {
                return;
            }
            this.f70413a = j;
            this.f70414b = true;
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f70417e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f70417e = str;
                this.f70414b = true;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                String g2 = this.f70418f.f70411d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f70416d = jSONObject.optString("form_id");
                    this.f70413a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f70417e = jSONObject.getString("uuid");
                    this.f70415c.b(jSONObject.getLong("flags"));
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
                if (this.f70414b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f70416d);
                        jSONObject.put("lst_fe_ts", this.f70413a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f70415c.d());
                        jSONObject.put("uuid", this.f70417e);
                        this.f70418f.f70411d.i("cache.dat", jSONObject.toString(), true);
                        this.f70414b = false;
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
        this.f70412e = new C1940a(this);
    }

    @Override // d.a.t.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70412e.a() : (String) invokeV.objValue;
    }

    @Override // d.a.t.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f70411d = this.f70386a.f(e());
            this.f70412e.e();
            if (TextUtils.isEmpty(this.f70412e.a())) {
                String uuid = UUID.randomUUID().toString();
                this.f70412e.d(uuid);
                try {
                    this.f70412e.b(d.a.t.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f70412e.c(System.currentTimeMillis());
            }
            this.f70412e.f();
        }
    }
}
