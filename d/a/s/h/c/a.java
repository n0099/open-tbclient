package d.a.s.h.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.g.c.a.e;
import d.a.s.g.c.a.f;
import d.a.s.g.d.a;
import d.a.s.h.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.s.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1904a f67934d;

    /* renamed from: e  reason: collision with root package name */
    public b f67935e;

    /* renamed from: d.a.s.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1906a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f67936a;

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f67937b;

        public C1906a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67936a = new HashSet<>();
            this.f67937b = new HashSet<>();
        }

        public static C1906a a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
                try {
                    String m = trustSubject.m("config-aid");
                    if (TextUtils.isEmpty(m)) {
                        return null;
                    }
                    try {
                        C1906a c1906a = new C1906a();
                        JSONObject jSONObject = new JSONObject(m);
                        JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                c1906a.f67936a.add(optJSONArray.getString(i2));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                c1906a.f67937b.add(optJSONArray2.getString(i3));
                            }
                        }
                        return c1906a;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (TrustSubject.ConfigNotFoundException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return (C1906a) invokeL.objValue;
        }

        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f67936a.contains(str) : invokeL.booleanValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f67937b.contains(str) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f67938a;

        /* renamed from: b  reason: collision with root package name */
        public String f67939b;

        /* renamed from: c  reason: collision with root package name */
        public String f67940c;

        /* renamed from: d  reason: collision with root package name */
        public long f67941d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f67942e;

        /* renamed from: f  reason: collision with root package name */
        public String f67943f;

        /* renamed from: g  reason: collision with root package name */
        public e f67944g;

        /* renamed from: h  reason: collision with root package name */
        public long f67945h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f67946i;

        public b(a aVar) {
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
            this.f67946i = aVar;
            this.f67942e = true;
            this.f67944g = new e();
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j == this.f67941d) {
                return;
            }
            this.f67941d = j;
            this.f67942e = true;
        }

        public void b(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f67944g.c(j, j2)) {
                this.f67942e = true;
            }
        }

        public void c(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == (str2 = this.f67939b)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67939b = str;
                this.f67942e = true;
            }
        }

        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) || Arrays.equals(bArr, this.f67938a)) {
                return;
            }
            this.f67938a = bArr;
            this.f67942e = true;
        }

        public byte[] e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67938a : (byte[]) invokeV.objValue;
        }

        public long f(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? this.f67944g.a(j) : invokeJ.longValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67939b : (String) invokeV.objValue;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (str2 = this.f67940c) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67940c = str;
                this.f67942e = true;
            }
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67940c : (String) invokeV.objValue;
        }

        public void j(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048585, this, j) == null) || this.f67945h == j) {
                return;
            }
            this.f67945h = j;
            this.f67942e = true;
        }

        public void k(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == (str2 = this.f67943f)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67943f = str;
                this.f67942e = true;
            }
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f67945h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                String g2 = this.f67946i.f67934d.g("aid.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f67938a = Base64.decode(jSONObject.getString("raw_id"), 2);
                        this.f67941d = jSONObject.getLong("gen_ts");
                        this.f67940c = jSONObject.getString("form_id");
                        this.f67939b = jSONObject.getString("and_id");
                        this.f67943f = jSONObject.optString("ran_id", null);
                        this.f67944g.b(jSONObject.getLong("flags"));
                        this.f67945h = jSONObject.getLong("lst_conf_ver");
                        jSONObject.getInt("c_form_ver");
                        this.f67942e = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (this.f67942e) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("and_id", this.f67939b);
                        jSONObject.put("form_id", this.f67940c);
                        jSONObject.put("gen_ts", this.f67941d);
                        jSONObject.put("flags", this.f67944g.d());
                        jSONObject.put("c_form_ver", 1);
                        if (!TextUtils.isEmpty(this.f67943f)) {
                            jSONObject.put("ran_id", this.f67943f);
                        }
                        if (this.f67938a != null) {
                            jSONObject.put("raw_id", Base64.encodeToString(this.f67938a, 2));
                        }
                        jSONObject.put("lst_conf_ver", this.f67945h);
                        this.f67946i.f67934d.i("aid.dat", jSONObject.toString(), true);
                        this.f67942e = false;
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
        super("aid");
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
        this.f67935e = new b(this);
    }

    public static String i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? d.a.s.h.a.b("A00", new d.a.s.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr)) : (String) invokeL.objValue;
    }

    @Override // d.a.s.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67935e.i() : (String) invokeV.objValue;
    }

    @Override // d.a.s.h.a
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67935e.e() : (byte[]) invokeV.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:3|(2:5|(4:7|8|(1:51)(1:14)|(12:19|(1:21)(1:50)|22|23|24|25|(1:27)|28|(2:(2:41|42)|33)(2:(2:44|(1:46))|42)|(3:35|(1:37)|38)|39|40)(1:17)))(1:53)|52|8|(1:10)|51|(0)|19|(0)(0)|22|23|24|25|(0)|28|(0)(0)|(0)|39|40) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        if (r13.c(r6) != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    @Override // d.a.s.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(a.c cVar) {
        long j;
        boolean z;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f67934d = this.f67922a.f("aid");
            this.f67935e.m();
            TrustSubject trustSubject = this.f67923b.f67929c.f6385b;
            boolean z3 = false;
            boolean z4 = true;
            if (trustSubject != null) {
                j = trustSubject.n();
                if (j != this.f67935e.l()) {
                    z = true;
                    z2 = !TextUtils.isEmpty(this.f67935e.i()) || this.f67935e.e() == null || TextUtils.isEmpty(this.f67935e.g());
                    if (!z2 || z) {
                        str = null;
                        C1906a a2 = trustSubject == null ? C1906a.a(trustSubject) : null;
                        str = Settings.Secure.getString(this.f67923b.f67927a.getContentResolver(), IAdRequestParam.ANDROID_ID);
                        if (TextUtils.isEmpty(str)) {
                            str = "000000000";
                        }
                        if (z2) {
                            if (a2 != null) {
                                if (this.f67935e.f(1L) == 0) {
                                }
                            }
                            z4 = false;
                        } else {
                            if (a2 == null || !a2.b(str)) {
                                z3 = true;
                                z4 = false;
                            }
                            z3 = true;
                        }
                        if (z3) {
                            String str2 = "com.helios" + str;
                            if (z4) {
                                String uuid = UUID.randomUUID().toString();
                                this.f67935e.k(uuid);
                                str2 = str2 + uuid;
                                this.f67935e.b(1L, 1L);
                            }
                            byte[] a3 = f.a(str2, "utf-8");
                            String i2 = i(a3);
                            this.f67935e.d(a3);
                            this.f67935e.a(System.currentTimeMillis());
                            this.f67935e.c(str);
                            this.f67935e.h(i2);
                        }
                        this.f67935e.j(j);
                        this.f67935e.n();
                    }
                    return;
                }
            } else {
                j = 0;
            }
            z = false;
            if (TextUtils.isEmpty(this.f67935e.i())) {
            }
            if (z2) {
            }
            str = null;
            if (trustSubject == null) {
            }
            str = Settings.Secure.getString(this.f67923b.f67927a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (TextUtils.isEmpty(str)) {
            }
            if (z2) {
            }
            if (z3) {
            }
            this.f67935e.j(j);
            this.f67935e.n();
        }
    }
}
