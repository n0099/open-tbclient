package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class x04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x04 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public volatile ArrayList<w04> b;

    public x04() {
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
        this.b = new ArrayList<>(20);
    }

    public static x04 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (x04.class) {
                    if (c == null) {
                        c = new x04();
                    }
                }
            }
            return c;
        }
        return (x04) invokeV.objValue;
    }

    public synchronized void a(w04 w04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w04Var) == null) {
            synchronized (this) {
                if (w04Var == null) {
                    return;
                }
                if (this.b.size() < 20) {
                    this.b.add(w04Var);
                } else {
                    this.a++;
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.b.clear();
                this.a = 0;
            }
        }
    }

    public synchronized JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                int size = this.b.size();
                if (size == 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("dropcnt", this.a);
                    jSONObject.put("errorcnt", size);
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put("errors", jSONArray);
                    Iterator<w04> it = this.b.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().a());
                    }
                } catch (JSONException unused) {
                }
                this.b.clear();
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
