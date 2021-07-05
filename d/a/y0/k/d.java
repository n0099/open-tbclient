package d.a.y0.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71151a;

    /* renamed from: b  reason: collision with root package name */
    public String f71152b;

    /* renamed from: c  reason: collision with root package name */
    public String f71153c;

    /* renamed from: d  reason: collision with root package name */
    public String f71154d;

    /* renamed from: e  reason: collision with root package name */
    public int f71155e;

    /* renamed from: f  reason: collision with root package name */
    public String f71156f;

    /* renamed from: g  reason: collision with root package name */
    public int f71157g;

    /* renamed from: h  reason: collision with root package name */
    public String f71158h;

    public d() {
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
        this.f71151a = "";
        this.f71152b = "";
        this.f71153c = "";
        this.f71154d = "";
        this.f71156f = "";
        this.f71157g = 0;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71154d : (String) invokeV.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f71151a = jSONObject.optString("name");
                this.f71152b = jSONObject.optString("id");
                this.f71153c = jSONObject.optString("image");
                this.f71154d = jSONObject.optString("url");
                this.f71155e = jSONObject.optInt("progress");
                this.f71156f = jSONObject.optString("downloadPerSize");
                this.f71157g = jSONObject.optInt("status");
                this.f71158h = jSONObject.optString("savePath");
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f71156f = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f71155e = i2;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f71158h = str;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f71157g = i2;
        }
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f71151a);
                jSONObject.put("id", this.f71152b);
                jSONObject.put("image", this.f71153c);
                jSONObject.put("url", this.f71154d);
                jSONObject.put("progress", this.f71155e);
                jSONObject.put("downloadPerSize", this.f71156f);
                jSONObject.put("status", this.f71157g);
                jSONObject.put("savePath", this.f71158h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
