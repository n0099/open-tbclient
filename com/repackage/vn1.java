package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class vn1 implements sn1 {
    public static /* synthetic */ Interceptable $ic;
    public static final JSONObject c;
    public static final Pair<sr1, JSONObject> d;
    public static final Pair<sr1, JSONObject> e;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public tn1 a;
    @NonNull
    public CallbackHandler b;

    /* loaded from: classes7.dex */
    public interface a {
        sr1 a(sz2 sz2Var, JSONObject jSONObject, @Nullable String str);
    }

    /* loaded from: classes7.dex */
    public interface b {
        sr1 a(sz2 sz2Var);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755225512, "Lcom/repackage/vn1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755225512, "Lcom/repackage/vn1;");
                return;
            }
        }
        c = new JSONObject();
        d = new Pair<>(sr1.d(), c);
        e = new Pair<>(sr1.e(), c);
    }

    public vn1(@NonNull tn1 tn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tn1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tn1Var;
        this.b = tn1Var.i();
    }

    @Nullable
    public static JSONObject r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static Pair<rr1, JSONObject> t(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jsObject)) == null) {
            if (jsObject == null) {
                return new Pair<>(new sr1(202, "parseParams(JsObject): jsObject cannot be null"), null);
            }
            int type = jsObject.getType();
            int length = jsObject.length();
            if (type != 9) {
                String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
                jsObject.release();
                return new Pair<>(new sr1(202, str), null);
            }
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < length; i++) {
                try {
                    int propertyType = jsObject.getPropertyType(i);
                    String propertyName = jsObject.getPropertyName(i);
                    switch (propertyType) {
                        case 1:
                            jSONObject.put(propertyName, jsObject.toBoolean(i));
                            break;
                        case 2:
                            jSONObject.put(propertyName, jsObject.toInteger(i));
                            break;
                        case 3:
                            jSONObject.put(propertyName, jsObject.toLong(i));
                            break;
                        case 5:
                            try {
                                jSONObject.put(propertyName, jsObject.toDouble(i));
                                break;
                            } catch (JSONException unused) {
                                break;
                            }
                        case 6:
                            JsObject[] objectArray = jsObject.toObjectArray(i);
                            if (objectArray == null) {
                                break;
                            } else {
                                jSONObject.put(propertyName, v(objectArray));
                                break;
                            }
                        case 7:
                            jSONObject.put(propertyName, jsObject.toString(i));
                            break;
                        case 8:
                            jSONObject.put(propertyName, jsObject.toJsFunction(i));
                            break;
                        case 9:
                            jSONObject.put(propertyName, t(jsObject.toJsObject(i)).second);
                            break;
                        case 10:
                            jSONObject.put(propertyName, jsObject.toJsArrayBuffer(i));
                            break;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    String str2 = "parseParams(JsObject): with exception " + e2.getMessage();
                    jsObject.release();
                    return new Pair<>(new sr1(202, str2), null);
                }
            }
            jsObject.release();
            return new Pair<>(new sr1(0), jSONObject);
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    public static Pair<rr1, JSONObject> u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Pair<>(new sr1(202, "parseParams(String): json string cannot be empty"), null);
            }
            try {
                return new Pair<>(new sr1(0), new JSONObject(str));
            } catch (JSONException unused) {
                return new Pair<>(new sr1(202, "parseParams(String): with json exception "), null);
            }
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static JSONArray v(@NonNull JsObject[] jsObjectArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jsObjectArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (JsObject jsObject : jsObjectArr) {
                if (jsObject == null) {
                    jSONArray.put((Object) null);
                } else {
                    switch (jsObject.getType()) {
                        case 0:
                            jSONArray.put((Object) null);
                            continue;
                        case 1:
                            jSONArray.put(jsObject.toBoolean(0));
                            continue;
                        case 2:
                            jSONArray.put(jsObject.toInteger(0));
                            continue;
                        case 3:
                            jSONArray.put(jsObject.toLong(0));
                            continue;
                        case 5:
                            try {
                                jSONArray.put(jsObject.toDouble(0));
                                continue;
                            } catch (JSONException unused) {
                                jSONArray.put((Object) null);
                                break;
                            }
                        case 6:
                            JsObject[] objectArray = jsObject.toObjectArray(0);
                            if (objectArray == null) {
                                jSONArray.put((Object) null);
                                continue;
                            } else {
                                jSONArray.put(v(objectArray));
                                break;
                            }
                        case 7:
                            jSONArray.put(jsObject.toString(0));
                            continue;
                        case 8:
                            jSONArray.put(jsObject.toJsFunction(0));
                            continue;
                        case 9:
                            jSONArray.put(t(jsObject).second);
                            continue;
                        case 10:
                            jSONArray.put(jsObject.toJsArrayBuffer(0));
                            continue;
                        case 11:
                            jSONArray.put((Object) null);
                            continue;
                        case 12:
                            jSONArray.put((Object) null);
                            continue;
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.repackage.sn1
    @NonNull
    public final tn1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (tn1) invokeV.objValue;
    }

    @Override // com.repackage.sn1
    @SuppressLint({"BDThrowableCheck"})
    public final void d(@NonNull String str, @NonNull sr1 sr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, sr1Var) == null) {
            if (TextUtils.isEmpty(str)) {
                p("callback is empty", null, true);
            } else if (sr1Var == null) {
                p("api result is empty", null, true);
            } else {
                w(str, sr1Var);
            }
        }
    }

    @NonNull
    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    public abstract String h();

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "API-" + h();
        }
        return (String) invokeV.objValue;
    }

    public abstract String j();

    public sr1 k(boolean z, @NonNull b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, bVar)) == null) {
            sz2 b0 = sz2.b0();
            if (b0 == null) {
                p("swan app is null", null, false);
                return sr1.j();
            } else if (z && b0.x() == null) {
                p("swan activity is null", null, true);
                return sr1.i();
            } else {
                return bVar.a(b0);
            }
        }
        return (sr1) invokeZL.objValue;
    }

    public sr1 l(String str, boolean z, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            sz2 b0 = sz2.b0();
            String str2 = null;
            if (b0 == null) {
                p("swan app is null", null, false);
                return new sr1(1001, "swan app is null");
            }
            Pair<sr1, JSONObject> s = s(str);
            sr1 sr1Var = (sr1) s.first;
            if (!sr1Var.isSuccess()) {
                p("json str parse fail", null, true);
                return sr1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (z) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new sr1(202, "cb is empty");
                }
                str2 = optString;
            }
            return aVar.a(b0, jSONObject, str2);
        }
        return (sr1) invokeCommon.objValue;
    }

    public sr1 m(@Nullable String str, @NonNull un1 un1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, un1Var)) == null) {
            Pair<sr1, JSONObject> s = s(str);
            sr1 sr1Var = (sr1) s.first;
            if (!sr1Var.isSuccess()) {
                p("json str parse fail", null, true);
                return sr1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new sr1(202, "cb is empty");
            }
            return un1Var.f(jSONObject, optString, this);
        }
        return (sr1) invokeLL.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            sz2 b0 = sz2.b0();
            if (b0 == null) {
                return true;
            }
            return b0.n0();
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void p(String str, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048587, this, str, th, z) == null) && o()) {
            sw1.e(j(), i(), str, th, z);
        }
    }

    public void q(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) && o()) {
            sw1.j(j(), i(), str, z);
        }
    }

    @NonNull
    public Pair<sr1, JSONObject> s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                p("json str is empty", null, true);
                return d;
            }
            try {
                return new Pair<>(sr1.f(), new JSONObject(str));
            } catch (JSONException e2) {
                p("json str parse fail", e2, true);
                return e;
            }
        }
        return (Pair) invokeL.objValue;
    }

    @UiThread
    public final void w(@NonNull String str, @NonNull sr1 sr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, sr1Var) == null) {
            if (TextUtils.isEmpty(str) && !(this.b instanceof NullableCallbackHandler)) {
                q("#realInvokeCallback check-fail callback=" + str, false);
                return;
            }
            this.b.handleSchemeDispatchCallback(str, sr1Var.a());
        }
    }
}
