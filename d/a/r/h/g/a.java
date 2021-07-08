package d.a.r.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r.g.c.a.b;
import d.a.r.g.c.a.e;
import d.a.r.g.d.a;
import d.a.r.h.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1899a f67312d;

    /* renamed from: e  reason: collision with root package name */
    public C1908a f67313e;

    /* renamed from: d.a.r.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1908a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67314a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67315b;

        /* renamed from: c  reason: collision with root package name */
        public e f67316c;

        /* renamed from: d  reason: collision with root package name */
        public String f67317d;

        /* renamed from: e  reason: collision with root package name */
        public String f67318e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67319f;

        public C1908a(a aVar) {
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
            this.f67319f = aVar;
            this.f67315b = true;
            this.f67316c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67317d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f67317d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67317d = str;
                this.f67315b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67318e : (String) invokeV.objValue;
        }

        public void d(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.f67314a == j) {
                return;
            }
            this.f67314a = j;
            this.f67315b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f67318e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67318e = str;
                this.f67315b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String g2 = this.f67319f.f67312d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f67317d = jSONObject.optString("form_id");
                    this.f67314a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f67318e = jSONObject.getString("ssaid");
                    this.f67316c.b(jSONObject.getLong("flags"));
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.f67315b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f67317d);
                        jSONObject.put("lst_fe_ts", this.f67314a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f67316c.d());
                        jSONObject.put("ssaid", this.f67318e);
                        this.f67319f.f67312d.i("cache.dat", jSONObject.toString(), true);
                        this.f67315b = false;
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
        super("ssaid");
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
        this.f67313e = new C1908a(this);
    }

    @Override // d.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67313e.a() : (String) invokeV.objValue;
    }

    @Override // d.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f67312d = this.f67244a.f(e());
            String string = Settings.Secure.getString(this.f67245b.f67249a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (string == null) {
                string = "0";
            }
            this.f67313e.f();
            if (TextUtils.isEmpty(this.f67313e.a()) || !TextUtils.equals(string, this.f67313e.c())) {
                this.f67313e.e(string);
                try {
                    this.f67313e.b(d.a.r.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f67313e.d(System.currentTimeMillis());
            }
            this.f67313e.g();
        }
    }
}
