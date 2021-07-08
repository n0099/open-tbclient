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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f34036a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f34037b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f34038c = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f34039d;

    /* renamed from: e  reason: collision with root package name */
    public int f34040e;

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
        this.f34040e = f34036a;
        this.f34039d = str;
        this.f34040e = i2;
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
            String str = this.f34039d;
            return ((str.startsWith("com.android.") || this.f34039d.startsWith("android.permission")) && (lastIndexOf = this.f34039d.lastIndexOf(".")) < this.f34039d.length() + (-1)) ? this.f34039d.substring(lastIndexOf + 1) : str;
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
                jSONObject.put("state", this.f34040e);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
