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
public class gm extends gn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f435b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    public gm() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f435b = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm(Bundle bundle) {
        super(bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Bundle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f435b = false;
        this.b = bundle.getString("ext_msg_type");
        this.d = bundle.getString("ext_msg_lang");
        this.c = bundle.getString("ext_msg_thread");
        this.e = bundle.getString("ext_msg_sub");
        this.f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.a = bundle.getBoolean("ext_msg_trans", false);
        this.f435b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gn
    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle a = super.a();
            if (!TextUtils.isEmpty(this.b)) {
                a.putString("ext_msg_type", this.b);
            }
            String str = this.d;
            if (str != null) {
                a.putString("ext_msg_lang", str);
            }
            String str2 = this.e;
            if (str2 != null) {
                a.putString("ext_msg_sub", str2);
            }
            String str3 = this.f;
            if (str3 != null) {
                a.putString("ext_msg_body", str3);
            }
            if (!TextUtils.isEmpty(this.g)) {
                a.putString("ext_body_encode", this.g);
            }
            String str4 = this.c;
            if (str4 != null) {
                a.putString("ext_msg_thread", str4);
            }
            String str5 = this.h;
            if (str5 != null) {
                a.putString("ext_msg_appid", str5);
            }
            if (this.a) {
                a.putBoolean("ext_msg_trans", true);
            }
            if (!TextUtils.isEmpty(this.i)) {
                a.putString("ext_msg_seq", this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                a.putString("ext_msg_mseq", this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                a.putString("ext_msg_fseq", this.k);
            }
            if (this.f435b) {
                a.putBoolean("ext_msg_encrypt", true);
            }
            if (!TextUtils.isEmpty(this.l)) {
                a.putString("ext_msg_status", this.l);
            }
            return a;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.xiaomi.push.gn
    public String a() {
        InterceptResult invokeV;
        gr m369a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<message");
            if (p() != null) {
                sb.append(" xmlns=\"");
                sb.append(p());
                sb.append("\"");
            }
            if (this.d != null) {
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
                sb.append(gy.a(l()));
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
                sb.append(gy.a(m()));
                sb.append("\"");
            }
            if (k() != null) {
                sb.append(" chid=\"");
                sb.append(gy.a(k()));
                sb.append("\"");
            }
            if (this.a) {
                sb.append(" transient=\"true\"");
            }
            if (!TextUtils.isEmpty(this.h)) {
                sb.append(" appid=\"");
                sb.append(c());
                sb.append("\"");
            }
            if (!TextUtils.isEmpty(this.b)) {
                sb.append(" type=\"");
                sb.append(this.b);
                sb.append("\"");
            }
            if (this.f435b) {
                sb.append(" s=\"1\"");
            }
            sb.append(">");
            if (this.e != null) {
                sb.append("<subject>");
                sb.append(gy.a(this.e));
                sb.append("</subject>");
            }
            if (this.f != null) {
                sb.append("<body");
                if (!TextUtils.isEmpty(this.g)) {
                    sb.append(" encode=\"");
                    sb.append(this.g);
                    sb.append("\"");
                }
                sb.append(">");
                sb.append(gy.a(this.f));
                sb.append("</body>");
            }
            if (this.c != null) {
                sb.append("<thread>");
                sb.append(this.c);
                sb.append("</thread>");
            }
            if ("error".equalsIgnoreCase(this.b) && (m369a = m369a()) != null) {
                sb.append(m369a.m373a());
            }
            sb.append(o());
            sb.append("</message>");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.gn
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.h = str;
        }
    }

    @Override // com.xiaomi.push.gn
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f = str;
            this.g = str2;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
        }
    }

    @Override // com.xiaomi.push.gn
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.i = str;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f435b = z;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.i : (String) invokeV.objValue;
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

    @Override // com.xiaomi.push.gn
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || gm.class != obj.getClass()) {
                return false;
            }
            gm gmVar = (gm) obj;
            if (super.equals(gmVar)) {
                String str = this.f;
                if (str == null ? gmVar.f == null : str.equals(gmVar.f)) {
                    String str2 = this.d;
                    if (str2 == null ? gmVar.d == null : str2.equals(gmVar.d)) {
                        String str3 = this.e;
                        if (str3 == null ? gmVar.e == null : str3.equals(gmVar.e)) {
                            String str4 = this.c;
                            if (str4 == null ? gmVar.c == null : str4.equals(gmVar.c)) {
                                return this.b == gmVar.b;
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
            this.b = str;
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
            this.e = str;
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f = str;
        }
    }

    @Override // com.xiaomi.push.gn
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String str = this.b;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.e;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.c = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.d = str;
        }
    }
}
