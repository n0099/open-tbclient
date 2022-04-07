package com.repackage;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class zv1 implements bw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    @Nullable
    public pq2 h;
    public String i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755098660, "Lcom/repackage/zv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755098660, "Lcom/repackage/zv1;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    public zv1(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "unknown";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = false;
        this.g = false;
        this.i = "id";
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
        } else {
            cx1.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.i = str2;
        } else {
            cx1.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // com.repackage.iq2
    @CallSuper
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.i, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.b = optString;
            if (TextUtils.isEmpty(optString)) {
                this.b = jSONObject.optString(this.i);
            }
        } else {
            String optString2 = jSONObject.optString(this.i);
            this.b = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.b = jSONObject.optString("componentId");
            }
        }
        if (TextUtils.isEmpty(this.b)) {
            jx1.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            jx1.c("Component-Model-Base", this.a + " component slaveId is empty");
        }
        this.d = jSONObject.optString("parentId");
        this.e = jSONObject.optString("cb");
        this.f = jSONObject.optBoolean("hide", false);
        this.g = TextUtils.equals(jSONObject.optString("gesture"), "1");
        f(jSONObject);
    }

    public final FrameLayout.LayoutParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            pq2 pq2Var = this.h;
            int f = pq2Var != null ? pq2Var.f() : -1;
            pq2 pq2Var2 = this.h;
            int c = pq2Var2 != null ? pq2Var2.c() : -1;
            pq2 pq2Var3 = this.h;
            int d = pq2Var3 != null ? pq2Var3.d() : 0;
            pq2 pq2Var4 = this.h;
            int e = pq2Var4 != null ? pq2Var4.e() : 0;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, c);
            layoutParams.setMargins(d, e, 0, 0);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public final float c(JSONObject jSONObject, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONObject, str, Float.valueOf(f)})) == null) ? jSONObject == null ? f : (float) jSONObject.optDouble(str, f) : invokeCommon.floatValue;
    }

    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            zv1 zv1Var = (zv1) super.clone();
            pq2 pq2Var = this.h;
            if (pq2Var != null) {
                zv1Var.h = (pq2) pq2Var.clone();
            } else {
                zv1Var.h = null;
            }
            return zv1Var;
        }
        return invokeV.objValue;
    }

    @NonNull
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("【");
            sb.append(this.a);
            sb.append("#");
            sb.append(TextUtils.isEmpty(this.b) ? "" : this.b);
            sb.append("】");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void e(JSONObject jSONObject, @NonNull zv1 zv1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, zv1Var) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.i, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.b = optString;
            if (TextUtils.isEmpty(optString)) {
                this.b = jSONObject.optString(this.i, zv1Var.b);
            }
        } else {
            String optString2 = jSONObject.optString(this.i);
            this.b = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.b = jSONObject.optString("componentId", zv1Var.b);
            }
        }
        if (TextUtils.isEmpty(this.b)) {
            jx1.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", zv1Var.c);
        this.c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            jx1.c("Component-Model-Base", this.a + " component slaveId is empty");
        }
        this.d = jSONObject.optString("parentId", zv1Var.d);
        this.e = jSONObject.optString("cb", zv1Var.e);
        this.f = jSONObject.optBoolean("hide", zv1Var.f);
        this.g = TextUtils.equals(jSONObject.optString("gesture", zv1Var.g ? "1" : "0"), "1");
        pq2 pq2Var = zv1Var.h;
        this.h = pq2Var;
        if (pq2Var == null) {
            this.h = new pq2();
        }
        f(jSONObject);
    }

    public final void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("position")) == null) {
            return;
        }
        pq2 pq2Var = new pq2();
        this.h = pq2Var;
        pq2Var.l(ae3.g(c(optJSONObject, "left", 0.0f)));
        this.h.m(ae3.g(c(optJSONObject, "top", 0.0f)));
        this.h.n(ae3.g(c(optJSONObject, "width", 0.0f)));
        this.h.j(ae3.g(c(optJSONObject, "height", 0.0f)));
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            if (!TextUtils.equals(this.i, "ARCameraId")) {
                String optString = jSONObject.optString("componentId");
                this.b = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.b = jSONObject.optString(this.i, this.b);
                }
            } else {
                String optString2 = jSONObject.optString(this.i);
                this.b = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.b = jSONObject.optString("componentId", this.b);
                }
            }
            if (TextUtils.isEmpty(this.b)) {
                jx1.c("Component-Model-Base", this.a + " component componentId is empty");
            }
            String optString3 = jSONObject.optString("slaveId", this.c);
            this.c = optString3;
            if (TextUtils.isEmpty(optString3)) {
                jx1.c("Component-Model-Base", this.a + " component slaveId is empty");
            }
            this.d = jSONObject.optString("parentId", this.d);
            this.e = jSONObject.optString("cb", this.e);
            this.f = jSONObject.optBoolean("hide", this.f);
            this.g = TextUtils.equals(jSONObject.optString("gesture", this.g ? "1" : "0"), "1");
            f(jSONObject);
        }
    }

    @Override // com.repackage.iq2
    public boolean isValid() {
        InterceptResult invokeV;
        pq2 pq2Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || (pq2Var = this.h) == null || !pq2Var.h()) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "SwanAppBaseComponentModel{componentType='" + this.a + "', componentId='" + this.b + "', slaveId='" + this.c + "', parentId='" + this.d + "', callback='" + this.e + "', hidden=" + this.f + ", gesture=" + this.g + ", position=" + this.h + ", mComponentIdKey='" + this.i + "'}";
        }
        return (String) invokeV.objValue;
    }
}
