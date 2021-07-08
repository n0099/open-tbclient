package d.m.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f72091e;

    /* renamed from: f  reason: collision with root package name */
    public String f72092f;

    /* renamed from: g  reason: collision with root package name */
    public String f72093g;

    /* renamed from: h  reason: collision with root package name */
    public String f72094h;

    /* renamed from: i  reason: collision with root package name */
    public String f72095i;
    public String j;
    public String k;
    public HashMap<String, String> l;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72092f = "";
        this.f72093g = "";
        this.f72094h = "";
        this.f72095i = "";
        this.j = "";
        this.k = "";
        this.l = new HashMap<>();
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                return o(this.f72092f);
            }
            return this.f72092f;
        }
        return (String) invokeZ.objValue;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                c cVar = (c) super.clone();
                HashMap<String, String> hashMap = new HashMap<>();
                for (Map.Entry<String, String> entry : cVar.l.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
                cVar.l = hashMap;
                return cVar;
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    public Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72091e : (Context) invokeV.objValue;
    }

    public String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (this.l.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                    return "";
                }
            }
            if (z) {
                return o(jSONObject.toString());
            }
            return jSONObject.toString();
        }
        return (String) invokeZ.objValue;
    }

    public String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (z) {
                return o(this.f72094h);
            }
            return this.f72094h;
        }
        return (String) invokeZ.objValue;
    }

    public String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                return o(this.j);
            }
            return this.j;
        }
        return (String) invokeZ.objValue;
    }

    public String h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                return o(this.f72093g);
            }
            return this.f72093g;
        }
        return (String) invokeZ.objValue;
    }

    public String i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                return o(this.k);
            }
            return this.k;
        }
        return (String) invokeZ.objValue;
    }

    public String j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                return o(this.f72095i);
            }
            return this.f72095i;
        }
        return (String) invokeZ.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f72092f = str;
        }
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            this.f72091e = context.getApplicationContext();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f72094h = str;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f72095i = str;
        }
    }

    public final String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.f72091e == null || TextUtils.isEmpty(this.f72092f) || TextUtils.isEmpty(this.f72094h) || TextUtils.isEmpty(this.f72095i)) ? false : true : invokeV.booleanValue;
    }
}
