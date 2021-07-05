package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class gb extends gc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f43153a;

    /* renamed from: b  reason: collision with root package name */
    public String f43154b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f425b;

    /* renamed from: c  reason: collision with root package name */
    public String f43155c;

    /* renamed from: d  reason: collision with root package name */
    public String f43156d;

    /* renamed from: e  reason: collision with root package name */
    public String f43157e;

    /* renamed from: f  reason: collision with root package name */
    public String f43158f;

    /* renamed from: g  reason: collision with root package name */
    public String f43159g;

    /* renamed from: h  reason: collision with root package name */
    public String f43160h;

    /* renamed from: i  reason: collision with root package name */
    public String f43161i;
    public String j;
    public String k;
    public String l;

    public gb() {
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
        this.f43154b = null;
        this.f43155c = null;
        this.f43153a = false;
        this.f43161i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f425b = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb(Bundle bundle) {
        super(bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Bundle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43154b = null;
        this.f43155c = null;
        this.f43153a = false;
        this.f43161i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f425b = false;
        this.f43154b = bundle.getString("ext_msg_type");
        this.f43156d = bundle.getString("ext_msg_lang");
        this.f43155c = bundle.getString("ext_msg_thread");
        this.f43157e = bundle.getString("ext_msg_sub");
        this.f43158f = bundle.getString("ext_msg_body");
        this.f43159g = bundle.getString("ext_body_encode");
        this.f43160h = bundle.getString("ext_msg_appid");
        this.f43153a = bundle.getBoolean("ext_msg_trans", false);
        this.f425b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f43161i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gc
    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle a2 = super.a();
            if (!TextUtils.isEmpty(this.f43154b)) {
                a2.putString("ext_msg_type", this.f43154b);
            }
            String str = this.f43156d;
            if (str != null) {
                a2.putString("ext_msg_lang", str);
            }
            String str2 = this.f43157e;
            if (str2 != null) {
                a2.putString("ext_msg_sub", str2);
            }
            String str3 = this.f43158f;
            if (str3 != null) {
                a2.putString("ext_msg_body", str3);
            }
            if (!TextUtils.isEmpty(this.f43159g)) {
                a2.putString("ext_body_encode", this.f43159g);
            }
            String str4 = this.f43155c;
            if (str4 != null) {
                a2.putString("ext_msg_thread", str4);
            }
            String str5 = this.f43160h;
            if (str5 != null) {
                a2.putString("ext_msg_appid", str5);
            }
            if (this.f43153a) {
                a2.putBoolean("ext_msg_trans", true);
            }
            if (!TextUtils.isEmpty(this.f43161i)) {
                a2.putString("ext_msg_seq", this.f43161i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                a2.putString("ext_msg_mseq", this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                a2.putString("ext_msg_fseq", this.k);
            }
            if (this.f425b) {
                a2.putBoolean("ext_msg_encrypt", true);
            }
            if (!TextUtils.isEmpty(this.l)) {
                a2.putString("ext_msg_status", this.l);
            }
            return a2;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.xiaomi.push.gc
    public String a() {
        InterceptResult invokeV;
        gg m343a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<message");
            if (p() != null) {
                sb.append(" xmlns=\"");
                sb.append(p());
                sb.append("\"");
            }
            if (this.f43156d != null) {
                sb.append(" xml:lang=\"");
                sb.append(h());
                sb.append("\"");
            }
            if (j() != null) {
                sb.append(" id=\"");
                sb.append(j());
                sb.append("\"");
            }
            if (l() != null) {
                sb.append(" to=\"");
                sb.append(gn.a(l()));
                sb.append("\"");
            }
            if (!TextUtils.isEmpty(d())) {
                sb.append(" seq=\"");
                sb.append(d());
                sb.append("\"");
            }
            if (!TextUtils.isEmpty(e())) {
                sb.append(" mseq=\"");
                sb.append(e());
                sb.append("\"");
            }
            if (!TextUtils.isEmpty(f())) {
                sb.append(" fseq=\"");
                sb.append(f());
                sb.append("\"");
            }
            if (!TextUtils.isEmpty(g())) {
                sb.append(" status=\"");
                sb.append(g());
                sb.append("\"");
            }
            if (m() != null) {
                sb.append(" from=\"");
                sb.append(gn.a(m()));
                sb.append("\"");
            }
            if (k() != null) {
                sb.append(" chid=\"");
                sb.append(gn.a(k()));
                sb.append("\"");
            }
            if (this.f43153a) {
                sb.append(" transient=\"true\"");
            }
            if (!TextUtils.isEmpty(this.f43160h)) {
                sb.append(" appid=\"");
                sb.append(c());
                sb.append("\"");
            }
            if (!TextUtils.isEmpty(this.f43154b)) {
                sb.append(" type=\"");
                sb.append(this.f43154b);
                sb.append("\"");
            }
            if (this.f425b) {
                sb.append(" s=\"1\"");
            }
            sb.append(">");
            if (this.f43157e != null) {
                sb.append("<subject>");
                sb.append(gn.a(this.f43157e));
                sb.append("</subject>");
            }
            if (this.f43158f != null) {
                sb.append("<body");
                if (!TextUtils.isEmpty(this.f43159g)) {
                    sb.append(" encode=\"");
                    sb.append(this.f43159g);
                    sb.append("\"");
                }
                sb.append(">");
                sb.append(gn.a(this.f43158f));
                sb.append("</body>");
            }
            if (this.f43155c != null) {
                sb.append("<thread>");
                sb.append(this.f43155c);
                sb.append("</thread>");
            }
            if ("error".equalsIgnoreCase(this.f43154b) && (m343a = m343a()) != null) {
                sb.append(m343a.m347a());
            }
            sb.append(o());
            sb.append("</message>");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.gc
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f43160h = str;
        }
    }

    @Override // com.xiaomi.push.gc
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f43158f = str;
            this.f43159g = str2;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f43153a = z;
        }
    }

    @Override // com.xiaomi.push.gc
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43154b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f43161i = str;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f425b = z;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f43160h : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.j = str;
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f43161i : (String) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.k = str;
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.l = str;
        }
    }

    @Override // com.xiaomi.push.gc
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || gb.class != obj.getClass()) {
                return false;
            }
            gb gbVar = (gb) obj;
            if (super.equals(gbVar)) {
                String str = this.f43158f;
                if (str == null ? gbVar.f43158f == null : str.equals(gbVar.f43158f)) {
                    String str2 = this.f43156d;
                    if (str2 == null ? gbVar.f43156d == null : str2.equals(gbVar.f43156d)) {
                        String str3 = this.f43157e;
                        if (str3 == null ? gbVar.f43157e == null : str3.equals(gbVar.f43157e)) {
                            String str4 = this.f43155c;
                            if (str4 == null ? gbVar.f43155c == null : str4.equals(gbVar.f43155c)) {
                                return this.f43154b == gbVar.f43154b;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f43154b = str;
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f43157e = str;
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f43156d : (String) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f43158f = str;
        }
    }

    @Override // com.xiaomi.push.gc
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String str = this.f43154b;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f43158f;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f43155c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f43156d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f43157e;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f43155c = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f43156d = str;
        }
    }
}
