package d.a.s.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.g.c.a.b;
import d.a.s.g.c.a.e;
import d.a.s.g.d.a;
import d.a.s.h.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.s.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1904a f67990d;

    /* renamed from: e  reason: collision with root package name */
    public C1913a f67991e;

    /* renamed from: d.a.s.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1913a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67992a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67993b;

        /* renamed from: c  reason: collision with root package name */
        public e f67994c;

        /* renamed from: d  reason: collision with root package name */
        public String f67995d;

        /* renamed from: e  reason: collision with root package name */
        public String f67996e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67997f;

        public C1913a(a aVar) {
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
            this.f67997f = aVar;
            this.f67993b = true;
            this.f67994c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67995d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f67995d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67995d = str;
                this.f67993b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67996e : (String) invokeV.objValue;
        }

        public void d(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.f67992a == j) {
                return;
            }
            this.f67992a = j;
            this.f67993b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f67996e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67996e = str;
                this.f67993b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String g2 = this.f67997f.f67990d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f67995d = jSONObject.optString("form_id");
                    this.f67992a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f67996e = jSONObject.getString("ssaid");
                    this.f67994c.b(jSONObject.getLong("flags"));
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
                if (this.f67993b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f67995d);
                        jSONObject.put("lst_fe_ts", this.f67992a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f67994c.d());
                        jSONObject.put("ssaid", this.f67996e);
                        this.f67997f.f67990d.i("cache.dat", jSONObject.toString(), true);
                        this.f67993b = false;
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
        this.f67991e = new C1913a(this);
    }

    @Override // d.a.s.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67991e.a() : (String) invokeV.objValue;
    }

    @Override // d.a.s.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f67990d = this.f67922a.f(e());
            String string = Settings.Secure.getString(this.f67923b.f67927a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (string == null) {
                string = "0";
            }
            this.f67991e.f();
            if (TextUtils.isEmpty(this.f67991e.a()) || !TextUtils.equals(string, this.f67991e.c())) {
                this.f67991e.e(string);
                try {
                    this.f67991e.b(d.a.s.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f67991e.d(System.currentTimeMillis());
            }
            this.f67991e.g();
        }
    }
}
