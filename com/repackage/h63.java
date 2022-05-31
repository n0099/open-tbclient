package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h63 extends k63 {
    public static /* synthetic */ Interceptable $ic;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755696340, "Lcom/repackage/h63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755696340, "Lcom/repackage/h63;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public h63(String str, int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.w = str;
        this.y = i;
        this.C = j;
        this.D = j2;
        this.B = "0";
    }

    @Override // com.repackage.k63, com.repackage.j63
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                if (TextUtils.equals(this.B, "1") || TextUtils.equals(this.B, "2")) {
                    this.h.put("errorno", this.v);
                }
                String b = z53.b(this.w);
                this.w = b;
                this.h.put("url", b);
                this.h.put("netStatus", this.y);
                if (!TextUtils.isEmpty(this.x)) {
                    this.h.put("msg", this.x);
                }
                if (!TextUtils.isEmpty(this.z)) {
                    this.h.put("pagetype", this.z);
                }
                if (!TextUtils.isEmpty(this.A)) {
                    this.h.put("curpage", this.A);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    this.h.put("requesttype", this.B);
                }
                if (this.D - this.C > 0) {
                    this.h.put(FetchLog.START_TIME, this.C);
                    this.h.put(FetchLog.END_TIME, this.D);
                }
                ExtensionCore T = b62.U().T();
                if (T != null) {
                    this.h.put("extension_ver", T.extensionCoreVersionName);
                }
            } catch (JSONException e) {
                hw1.e("SwanAppRequestEvent", "834", "#toJSONObject error", e, false);
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

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = this.h;
            return jSONObject != null && TextUtils.equals(jSONObject.optString("requesttype"), "0");
        }
        return invokeV.booleanValue;
    }

    public void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            try {
                if (TextUtils.equals(this.B, "1") || TextUtils.equals(this.B, "2")) {
                    jSONObject.put("errorno", this.v);
                }
                jSONObject.put("url", z53.b(this.w));
                jSONObject.put("netStatus", this.y);
                if (!TextUtils.isEmpty(this.x)) {
                    jSONObject.put("msg", this.x);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    jSONObject.put("requesttype", this.B);
                }
                if (this.D - this.C > 0) {
                    jSONObject.put(FetchLog.START_TIME, this.C);
                    jSONObject.put(FetchLog.END_TIME, this.D);
                }
            } catch (JSONException e) {
                hw1.e("SwanAppRequestEvent", "834", "#mergeRequestInfo error", e, false);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.A = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.z = str;
        }
    }

    public h63(int i, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.v = i;
        this.w = str;
        this.x = str2;
        this.y = i2;
        this.B = "1";
    }

    public h63(int i, String str, String str2, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.v = i;
        this.w = str;
        this.x = str2;
        this.y = i2;
        this.C = j;
        this.D = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.B = "2";
        } else {
            this.B = "1";
        }
    }
}
