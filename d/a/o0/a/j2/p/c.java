package d.a.o0.a.j2.p;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.j2.j;
import d.a.o0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public long C;
    public long D;
    public int v;
    public String w;
    public String x;
    public int y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2015181689, "Ld/a/o0/a/j2/p/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2015181689, "Ld/a/o0/a/j2/p/c;");
                return;
            }
        }
        E = k.f46335a;
    }

    public c(String str, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.w = str;
        this.y = i2;
        this.C = j;
        this.D = j2;
        this.B = "0";
    }

    @Override // d.a.o0.a.j2.p.f, d.a.o0.a.j2.p.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f46328h == null) {
                this.f46328h = new JSONObject();
            }
            try {
                if (TextUtils.equals(this.B, "1") || TextUtils.equals(this.B, "2")) {
                    this.f46328h.put("errorno", this.v);
                }
                String a2 = j.a(this.w);
                this.w = a2;
                this.f46328h.put("url", a2);
                this.f46328h.put("netStatus", this.y);
                if (!TextUtils.isEmpty(this.x)) {
                    this.f46328h.put("msg", this.x);
                }
                if (!TextUtils.isEmpty(this.z)) {
                    this.f46328h.put("pagetype", this.z);
                }
                if (!TextUtils.isEmpty(this.A)) {
                    this.f46328h.put("curpage", this.A);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    this.f46328h.put("requesttype", this.B);
                }
                if (this.D - this.C > 0) {
                    this.f46328h.put("startTime", this.C);
                    this.f46328h.put("endTime", this.D);
                }
                ExtensionCore M = d.a.o0.a.h0.u.g.N().M();
                if (M != null) {
                    this.f46328h.put("extension_ver", M.extensionCoreVersionName);
                }
            } catch (JSONException e2) {
                if (E) {
                    Log.d("SwanAppRequestEvent", Log.getStackTraceString(e2));
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.C : invokeV.longValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public void o(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            try {
                if (TextUtils.equals(this.B, "1") || TextUtils.equals(this.B, "2")) {
                    jSONObject.put("errorno", this.v);
                }
                jSONObject.put("url", j.a(this.w));
                jSONObject.put("netStatus", this.y);
                if (!TextUtils.isEmpty(this.x)) {
                    jSONObject.put("msg", this.x);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    jSONObject.put("requesttype", this.B);
                }
                if (this.D - this.C > 0) {
                    jSONObject.put("startTime", this.C);
                    jSONObject.put("endTime", this.D);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.A = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.z = str;
        }
    }

    public c(int i2, String str, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.v = i2;
        this.w = str;
        this.x = str2;
        this.y = i3;
        this.B = "1";
    }

    public c(int i2, String str, String str2, int i3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.v = i2;
        this.w = str;
        this.x = str2;
        this.y = i3;
        this.C = j;
        this.D = j2;
        if (i2 == 200 && j2 - j >= 5000) {
            this.B = "2";
        } else {
            this.B = "1";
        }
    }
}
