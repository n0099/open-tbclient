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
/* loaded from: classes2.dex */
public class gb extends gc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f70988a;

    /* renamed from: b  reason: collision with root package name */
    public String f70989b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f430b;

    /* renamed from: c  reason: collision with root package name */
    public String f70990c;

    /* renamed from: d  reason: collision with root package name */
    public String f70991d;

    /* renamed from: e  reason: collision with root package name */
    public String f70992e;

    /* renamed from: f  reason: collision with root package name */
    public String f70993f;

    /* renamed from: g  reason: collision with root package name */
    public String f70994g;

    /* renamed from: h  reason: collision with root package name */
    public String f70995h;

    /* renamed from: i  reason: collision with root package name */
    public String f70996i;
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
        this.f70989b = null;
        this.f70990c = null;
        this.f70988a = false;
        this.f70996i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f430b = false;
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
        this.f70989b = null;
        this.f70990c = null;
        this.f70988a = false;
        this.f70996i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f430b = false;
        this.f70989b = bundle.getString("ext_msg_type");
        this.f70991d = bundle.getString("ext_msg_lang");
        this.f70990c = bundle.getString("ext_msg_thread");
        this.f70992e = bundle.getString("ext_msg_sub");
        this.f70993f = bundle.getString("ext_msg_body");
        this.f70994g = bundle.getString("ext_body_encode");
        this.f70995h = bundle.getString("ext_msg_appid");
        this.f70988a = bundle.getBoolean("ext_msg_trans", false);
        this.f430b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f70996i = bundle.getString("ext_msg_seq");
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
            if (!TextUtils.isEmpty(this.f70989b)) {
                a2.putString("ext_msg_type", this.f70989b);
            }
            String str = this.f70991d;
            if (str != null) {
                a2.putString("ext_msg_lang", str);
            }
            String str2 = this.f70992e;
            if (str2 != null) {
                a2.putString("ext_msg_sub", str2);
            }
            String str3 = this.f70993f;
            if (str3 != null) {
                a2.putString("ext_msg_body", str3);
            }
            if (!TextUtils.isEmpty(this.f70994g)) {
                a2.putString("ext_body_encode", this.f70994g);
            }
            String str4 = this.f70990c;
            if (str4 != null) {
                a2.putString("ext_msg_thread", str4);
            }
            String str5 = this.f70995h;
            if (str5 != null) {
                a2.putString("ext_msg_appid", str5);
            }
            if (this.f70988a) {
                a2.putBoolean("ext_msg_trans", true);
            }
            if (!TextUtils.isEmpty(this.f70996i)) {
                a2.putString("ext_msg_seq", this.f70996i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                a2.putString("ext_msg_mseq", this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                a2.putString("ext_msg_fseq", this.k);
            }
            if (this.f430b) {
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
        gg m346a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<message");
            if (p() != null) {
                sb.append(" xmlns=\"");
                sb.append(p());
                sb.append("\"");
            }
            if (this.f70991d != null) {
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
            if (this.f70988a) {
                sb.append(" transient=\"true\"");
            }
            if (!TextUtils.isEmpty(this.f70995h)) {
                sb.append(" appid=\"");
                sb.append(c());
                sb.append("\"");
            }
            if (!TextUtils.isEmpty(this.f70989b)) {
                sb.append(" type=\"");
                sb.append(this.f70989b);
                sb.append("\"");
            }
            if (this.f430b) {
                sb.append(" s=\"1\"");
            }
            sb.append(">");
            if (this.f70992e != null) {
                sb.append("<subject>");
                sb.append(gn.a(this.f70992e));
                sb.append("</subject>");
            }
            if (this.f70993f != null) {
                sb.append("<body");
                if (!TextUtils.isEmpty(this.f70994g)) {
                    sb.append(" encode=\"");
                    sb.append(this.f70994g);
                    sb.append("\"");
                }
                sb.append(">");
                sb.append(gn.a(this.f70993f));
                sb.append("</body>");
            }
            if (this.f70990c != null) {
                sb.append("<thread>");
                sb.append(this.f70990c);
                sb.append("</thread>");
            }
            if ("error".equalsIgnoreCase(this.f70989b) && (m346a = m346a()) != null) {
                sb.append(m346a.m350a());
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
            this.f70995h = str;
        }
    }

    @Override // com.xiaomi.push.gc
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f70993f = str;
            this.f70994g = str2;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f70988a = z;
        }
    }

    @Override // com.xiaomi.push.gc
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70989b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f70996i = str;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f430b = z;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f70995h : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f70996i : (String) invokeV.objValue;
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
                String str = this.f70993f;
                if (str == null ? gbVar.f70993f == null : str.equals(gbVar.f70993f)) {
                    String str2 = this.f70991d;
                    if (str2 == null ? gbVar.f70991d == null : str2.equals(gbVar.f70991d)) {
                        String str3 = this.f70992e;
                        if (str3 == null ? gbVar.f70992e == null : str3.equals(gbVar.f70992e)) {
                            String str4 = this.f70990c;
                            if (str4 == null ? gbVar.f70990c == null : str4.equals(gbVar.f70990c)) {
                                return this.f70989b == gbVar.f70989b;
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
            this.f70989b = str;
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
            this.f70992e = str;
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f70991d : (String) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f70993f = str;
        }
    }

    @Override // com.xiaomi.push.gc
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String str = this.f70989b;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f70993f;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f70990c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f70991d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f70992e;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f70990c = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f70991d = str;
        }
    }
}
