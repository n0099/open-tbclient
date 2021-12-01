package com.kwad.sdk.collector;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f57096b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f57097c = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f57098d;

    /* renamed from: e  reason: collision with root package name */
    public int f57099e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1320780847, "Lcom/kwad/sdk/collector/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1320780847, "Lcom/kwad/sdk/collector/g;");
        }
    }

    public g(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57099e = a;
        this.f57098d = str;
        this.f57099e = i2;
    }

    public static JSONArray a(List<g> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list == null) {
                return jSONArray;
            }
            for (g gVar : list) {
                jSONArray.put(gVar.a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    private String b() {
        InterceptResult invokeV;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            String str = this.f57098d;
            return ((str.startsWith("com.android.") || this.f57098d.startsWith("android.permission")) && (lastIndexOf = this.f57098d.lastIndexOf(".")) < this.f57098d.length() + (-1)) ? this.f57098d.substring(lastIndexOf + 1) : str;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", b());
                jSONObject.put("state", this.f57099e);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
