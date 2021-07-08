package ms.bd.c;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        int i2;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (context == null) {
                return jSONArray.toString();
            }
            String str = null;
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                Method declaredMethod = wifiManager.getClass().getDeclaredMethod(new String(c0.b("6765745363616e526573756c7473")), new Class[0]);
                list = declaredMethod != null ? (List) declaredMethod.invoke(wifiManager, new Object[0]) : null;
            } catch (Throwable unused) {
            }
            if (list != null && list.size() > 0) {
                Collections.sort(list, new r1());
                for (i2 = 0; i2 < list.size() && i2 < 10; i2++) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ss", a2.a(((ScanResult) list.get(i2)).SSID));
                        jSONObject.put("bs", a2.a(((ScanResult) list.get(i2)).BSSID));
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused2) {
                    }
                }
                str = jSONArray.toString();
                return str == null ? "[]" : str.trim();
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }
}
