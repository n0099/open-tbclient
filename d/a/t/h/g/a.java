package d.a.t.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.t.g.c.a.b;
import d.a.t.g.c.a.e;
import d.a.t.g.d.a;
import d.a.t.h.a;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d.a.t.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1937a f70454d;

    /* renamed from: e  reason: collision with root package name */
    public C1946a f70455e;

    /* renamed from: d.a.t.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1946a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f70456a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f70457b;

        /* renamed from: c  reason: collision with root package name */
        public e f70458c;

        /* renamed from: d  reason: collision with root package name */
        public String f70459d;

        /* renamed from: e  reason: collision with root package name */
        public String f70460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f70461f;

        public C1946a(a aVar) {
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
            this.f70461f = aVar;
            this.f70457b = true;
            this.f70458c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70459d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f70459d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f70459d = str;
                this.f70457b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70460e : (String) invokeV.objValue;
        }

        public void d(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.f70456a == j) {
                return;
            }
            this.f70456a = j;
            this.f70457b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f70460e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f70460e = str;
                this.f70457b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String g2 = this.f70461f.f70454d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f70459d = jSONObject.optString("form_id");
                    this.f70456a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f70460e = jSONObject.getString("ssaid");
                    this.f70458c.b(jSONObject.getLong("flags"));
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
                if (this.f70457b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f70459d);
                        jSONObject.put("lst_fe_ts", this.f70456a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f70458c.d());
                        jSONObject.put("ssaid", this.f70460e);
                        this.f70461f.f70454d.i("cache.dat", jSONObject.toString(), true);
                        this.f70457b = false;
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
        this.f70455e = new C1946a(this);
    }

    @Override // d.a.t.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70455e.a() : (String) invokeV.objValue;
    }

    @Override // d.a.t.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f70454d = this.f70386a.f(e());
            String string = Settings.Secure.getString(this.f70387b.f70391a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (string == null) {
                string = "0";
            }
            this.f70455e.f();
            if (TextUtils.isEmpty(this.f70455e.a()) || !TextUtils.equals(string, this.f70455e.c())) {
                this.f70455e.e(string);
                try {
                    this.f70455e.b(d.a.t.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f70455e.d(System.currentTimeMillis());
            }
            this.f70455e.g();
        }
    }
}
