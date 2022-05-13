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
/* loaded from: classes6.dex */
public abstract class kw1 implements mw1 {
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
    public ar2 h;
    public String i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755544564, "Lcom/repackage/kw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755544564, "Lcom/repackage/kw1;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public kw1(@NonNull String str, @NonNull String str2) {
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
            nx1.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.i = str2;
        } else {
            nx1.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // com.repackage.tq2
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
            ux1.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            ux1.c("Component-Model-Base", this.a + " component slaveId is empty");
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
            ar2 ar2Var = this.h;
            int f = ar2Var != null ? ar2Var.f() : -1;
            ar2 ar2Var2 = this.h;
            int c = ar2Var2 != null ? ar2Var2.c() : -1;
            ar2 ar2Var3 = this.h;
            int d = ar2Var3 != null ? ar2Var3.d() : 0;
            ar2 ar2Var4 = this.h;
            int e = ar2Var4 != null ? ar2Var4.e() : 0;
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
            kw1 kw1Var = (kw1) super.clone();
            ar2 ar2Var = this.h;
            if (ar2Var != null) {
                kw1Var.h = (ar2) ar2Var.clone();
            } else {
                kw1Var.h = null;
            }
            return kw1Var;
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

    public final void e(JSONObject jSONObject, @NonNull kw1 kw1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, kw1Var) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.i, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.b = optString;
            if (TextUtils.isEmpty(optString)) {
                this.b = jSONObject.optString(this.i, kw1Var.b);
            }
        } else {
            String optString2 = jSONObject.optString(this.i);
            this.b = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.b = jSONObject.optString("componentId", kw1Var.b);
            }
        }
        if (TextUtils.isEmpty(this.b)) {
            ux1.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", kw1Var.c);
        this.c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            ux1.c("Component-Model-Base", this.a + " component slaveId is empty");
        }
        this.d = jSONObject.optString("parentId", kw1Var.d);
        this.e = jSONObject.optString("cb", kw1Var.e);
        this.f = jSONObject.optBoolean("hide", kw1Var.f);
        this.g = TextUtils.equals(jSONObject.optString("gesture", kw1Var.g ? "1" : "0"), "1");
        ar2 ar2Var = kw1Var.h;
        this.h = ar2Var;
        if (ar2Var == null) {
            this.h = new ar2();
        }
        f(jSONObject);
    }

    public final void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("position")) == null) {
            return;
        }
        ar2 ar2Var = new ar2();
        this.h = ar2Var;
        ar2Var.l(le3.g(c(optJSONObject, "left", 0.0f)));
        this.h.m(le3.g(c(optJSONObject, "top", 0.0f)));
        this.h.n(le3.g(c(optJSONObject, "width", 0.0f)));
        this.h.j(le3.g(c(optJSONObject, "height", 0.0f)));
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
                ux1.c("Component-Model-Base", this.a + " component componentId is empty");
            }
            String optString3 = jSONObject.optString("slaveId", this.c);
            this.c = optString3;
            if (TextUtils.isEmpty(optString3)) {
                ux1.c("Component-Model-Base", this.a + " component slaveId is empty");
            }
            this.d = jSONObject.optString("parentId", this.d);
            this.e = jSONObject.optString("cb", this.e);
            this.f = jSONObject.optBoolean("hide", this.f);
            this.g = TextUtils.equals(jSONObject.optString("gesture", this.g ? "1" : "0"), "1");
            f(jSONObject);
        }
    }

    @Override // com.repackage.tq2
    public boolean isValid() {
        InterceptResult invokeV;
        ar2 ar2Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || (ar2Var = this.h) == null || !ar2Var.h()) ? false : true : invokeV.booleanValue;
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
