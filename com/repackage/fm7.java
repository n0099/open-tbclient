package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fm7 implements s75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public long d;
    public String e;
    public boolean f;
    public boolean g;
    public int h;
    public boolean i;
    public long j;
    public int k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public boolean p;

    public fm7() {
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
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = System.currentTimeMillis();
        this.e = "";
        this.f = false;
        this.g = false;
        this.h = 0;
        this.i = false;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = true;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.o = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f = z;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.p = z;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.i = z;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.e = str;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.g = z;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.a = str;
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.b = str;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.h = i;
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.n = str;
        }
    }

    public JSONObject N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_name", this.c);
                jSONObject.put("thread_id", this.a);
                jSONObject.put("thread_time", this.d);
                jSONObject.put("thread_name", this.b);
                jSONObject.put("post_id", this.e);
                jSONObject.put("host_only", this.f);
                jSONObject.put("squence", this.g);
                jSONObject.put("thread_type", this.h);
                jSONObject.put("is_manga", this.i);
                jSONObject.put("cartoon_id", this.j);
                jSONObject.put(MangaBrowserActivityConfig.CHAPTER_ID, this.k);
                jSONObject.put(VideoPlayActivityConfig.IS_SHARE_THREAD, this.l);
                jSONObject.put("live_id", this.m);
                jSONObject.put("user_name", this.n);
                jSONObject.put("live_description", this.o);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof fm7)) {
                fm7 fm7Var = (fm7) obj;
                if (this.h == 49) {
                    String str3 = this.m;
                    if (str3 != null && (str2 = fm7Var.m) != null && str3.equals(str2)) {
                        return true;
                    }
                } else {
                    String str4 = this.a;
                    if (str4 != null && (str = fm7Var.a) != null && str4.equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.repackage.q75
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.h == 49) {
                return this.m + "_ala";
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int hashCode = TextUtils.isEmpty(this.a) ? 120 : 119 + this.a.hashCode();
            int hashCode2 = TextUtils.isEmpty(this.b) ? (hashCode * 7) + 1 : (hashCode * 7) + this.b.hashCode();
            int hashCode3 = ((TextUtils.isEmpty(this.c) ? (hashCode2 * 7) + 1 : (hashCode2 * 7) + this.c.hashCode()) * 7) + ((int) this.d);
            int hashCode4 = TextUtils.isEmpty(this.e) ? (hashCode3 * 7) + 1 : (hashCode3 * 7) + this.e.hashCode();
            int hashCode5 = TextUtils.isEmpty(this.m) ? (hashCode4 * 7) + 1 : (hashCode4 * 7) + this.m.hashCode();
            return ((((TextUtils.isEmpty(this.o) ? (hashCode5 * 7) + 1 : (hashCode5 * 7) + this.o.hashCode()) * 7) + (this.f ? 1 : 0)) * 7) + (this.g ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.h : invokeV.intValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.d : invokeV.longValue;
    }

    @Override // com.repackage.s75
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? N().toString() : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // com.repackage.s75
    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (str != null) {
                try {
                    return u(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jSONObject)) == null) {
            String optString = jSONObject.optString("forum_name");
            String optString2 = jSONObject.optString("thread_id");
            String optString3 = jSONObject.optString("thread_name");
            long optLong = jSONObject.optLong("thread_time");
            this.e = jSONObject.optString("post_id");
            this.f = jSONObject.optBoolean("host_only");
            this.g = jSONObject.optBoolean("squence");
            this.i = jSONObject.optBoolean("is_manga");
            this.j = jSONObject.optLong("cartoon_id");
            this.k = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
            this.l = jSONObject.optBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            if (!TextUtils.isEmpty(optString)) {
                this.c = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.a = optString2;
            }
            if (!TextUtils.isEmpty(optString3)) {
                this.b = optString3;
            }
            if (optLong > 2000) {
                this.d = optLong;
            }
            this.h = jSONObject.optInt("thread_type");
            this.m = jSONObject.optString("live_id", "");
            this.n = jSONObject.optString("user_name", "");
            this.o = jSONObject.optString("live_description", "");
            return true;
        }
        return invokeL.booleanValue;
    }

    public void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            this.j = j;
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.k = i;
        }
    }
}
