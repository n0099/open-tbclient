package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    public aw(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.k).intValue(), 0, 1, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            JSONObject jSONObject = null;
            try {
                if (Engine.loadSuccess) {
                    String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.j).intValue(), 1, 3, "");
                    if (!TextUtils.isEmpty(pqr)) {
                        jSONObject = new JSONObject(pqr);
                    }
                }
                if (bh.a(context, "com.freeze.kusr")) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("com.freeze.kusr", 1);
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                if (Engine.loadSuccess) {
                    String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.j).intValue(), 1, 0, "");
                    if (!TextUtils.isEmpty(pqr)) {
                        return new JSONObject(pqr);
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                if (Engine.loadSuccess) {
                    String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.j).intValue(), 1, 2, "");
                    if (!TextUtils.isEmpty(pqr) && pqr.length() > 2) {
                        return new JSONObject(pqr);
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            try {
                if (Engine.loadSuccess) {
                    String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.j).intValue(), 2, 1, "");
                    if (!TextUtils.isEmpty(pqr)) {
                        return new JSONObject(pqr);
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                if (this.a != null) {
                    Iterator<String> keys = this.a.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = this.a.getString(next);
                        if (!TextUtils.isEmpty(string)) {
                            jSONObject.put(next, string);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
