package d.a.q0.a.v0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.k2.g.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51187a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51188b;

    /* renamed from: c  reason: collision with root package name */
    public String f51189c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f51190d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d.a.q0.a.a2.d.g().l() == 0) {
                return c(this.f51190d, "bbasp_guide_");
            }
            if (d.a.q0.a.a2.d.g().l() == 1) {
                return c(this.f51190d, "bbaspg_guide_");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONArray optJSONArray = this.f51190d.optJSONArray("custom_guide_list");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("appid", "");
                    if (e.V() == null || TextUtils.equals(e.V(), optString)) {
                        return c(optJSONObject, "");
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        boolean i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            boolean z = false;
            if (jSONObject == null) {
                return false;
            }
            String optString = jSONObject.optString(str + "count", "3");
            try {
                int intValue = !TextUtils.isEmpty(optString) ? Integer.valueOf(optString).intValue() : 0;
                String optString2 = jSONObject.optString(str + "interval", "72");
                long longValue = !TextUtils.isEmpty(optString2) ? Long.valueOf(optString2).longValue() : 0L;
                long optLong = jSONObject.optLong(str + "last_time", 0L);
                int optInt = jSONObject.optInt(str + "shown_count", 0);
                int optInt2 = jSONObject.optInt(str + "image_index", 0);
                boolean z2 = System.currentTimeMillis() - optLong > longValue * 3600000;
                if (d.a.q0.a.a2.d.g().l() == 1) {
                    i2 = j();
                } else {
                    i2 = i(jSONObject.optJSONArray("scenes"));
                }
                if (optInt < intValue && z2 && i2) {
                    z = true;
                }
                if (z) {
                    g(jSONObject, optInt2, str + "images");
                }
            } catch (NumberFormatException unused) {
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String string = h.a().getString("swan_guide_toast", "");
            if (d.a.q0.a.a2.d.g() != null && d.a.q0.a.a2.d.g().l() == 1) {
                string = h.a().getString("swan_game_guide_toast", "");
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f51187a) {
                return "special";
            }
            if (this.f51188b) {
                return "normal";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51189c : (String) invokeV.objValue;
    }

    public final int g(JSONObject jSONObject, int i2, String str) {
        InterceptResult invokeLIL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, jSONObject, i2, str)) == null) {
            if (jSONObject == null || i2 < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return 0;
            }
            if (i2 >= optJSONArray.length()) {
                i2 = 0;
            }
            this.f51189c = optJSONArray.optString(i2);
            return i2;
        }
        return invokeLIL.intValue;
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f51187a = false;
            this.f51188b = false;
            this.f51189c = null;
            JSONObject d2 = d();
            this.f51190d = d2;
            if (d2 != null && d2.length() != 0) {
                boolean b2 = b();
                this.f51187a = b2;
                if (b2) {
                    return this;
                }
                this.f51188b = a();
            }
            return this;
        }
        return (b) invokeV.objValue;
    }

    public final boolean i(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return true;
            }
            String T = d.a.q0.a.a2.d.g().r().L().T();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.equals(T, jSONArray.optString(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
        if (r0.startsWith("120") != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b.a L = d.a.q0.a.a2.d.g().r().L();
            String T = L.T();
            boolean z = false;
            boolean z2 = TextUtils.isEmpty(T) || T.startsWith("120");
            String string = L.P().getString(UBCCloudControlProcessor.UBC_KEY);
            if (!TextUtils.isEmpty(string)) {
                try {
                    String optString = new JSONObject(string).optString("pre_source");
                    if (!TextUtils.isEmpty(optString)) {
                    }
                    z = z2;
                    z2 = z;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return !z2;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f51188b || this.f51187a : invokeV.booleanValue;
    }
}
