package com.win.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k1 {
    public static /* synthetic */ Interceptable $ic;
    public static k1 d;
    public static String e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public long b;
    public long c;

    public k1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static k1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (k1.class) {
                    if (d == null) {
                        d = new k1(context);
                    }
                }
            }
            return d;
        }
        return (k1) invokeL.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? e : (String) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Z1.c(this.a, new Date().getTime());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639705367, "Lcom/win/opensdk/k1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639705367, "Lcom/win/opensdk/k1;");
                return;
            }
        }
        e = x1.d + "jy/cf?";
    }

    public final void a(y1 y1Var) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y1Var) == null) && y1Var != null && (jSONObject = y1Var.c) != null && jSONObject.length() != 0) {
            try {
                JSONObject jSONObject2 = y1Var.c;
                Z1.c(this.a, jSONObject2.optString("bt", ""));
                int optInt = jSONObject2.optInt("time", 12);
                SharedPreferences.Editor edit = this.a.getSharedPreferences("_prefs", 0).edit();
                edit.putInt("interval", optInt);
                edit.apply();
                int optInt2 = jSONObject2.optInt("wt", 15);
                SharedPreferences.Editor edit2 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit2.putInt("timeout_sec", optInt2);
                edit2.apply();
                JSONArray optJSONArray = jSONObject2.optJSONArray("ids");
                Context context = this.a;
                String jSONArray = optJSONArray.toString();
                SharedPreferences.Editor edit3 = context.getSharedPreferences("_prefs", 0).edit();
                edit3.putString("pids", jSONArray);
                edit3.apply();
                String optString = jSONObject2.optString("psdid");
                SharedPreferences.Editor edit4 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit4.putString("psdid", optString);
                edit4.apply();
                int optInt3 = jSONObject2.optInt("psdt");
                SharedPreferences.Editor edit5 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit5.putInt("psdt", optInt3);
                edit5.apply();
                int optInt4 = jSONObject2.optInt("psd");
                SharedPreferences.Editor edit6 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit6.putInt("psd", optInt4);
                edit6.apply();
                int optInt5 = jSONObject2.optInt("hbsw");
                SharedPreferences.Editor edit7 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit7.putInt("hbsw", optInt5);
                edit7.apply();
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("bp");
                Context context2 = this.a;
                String jSONArray2 = optJSONArray2.toString();
                SharedPreferences.Editor edit8 = context2.getSharedPreferences("_prefs", 0).edit();
                edit8.putString("bp", jSONArray2);
                edit8.apply();
                int optInt6 = jSONObject2.optInt("bs", 0);
                SharedPreferences.Editor edit9 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit9.putInt("bro_high", optInt6);
                edit9.apply();
                int optInt7 = jSONObject2.optInt("pro", 4);
                SharedPreferences.Editor edit10 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit10.putInt("re_pro", optInt7);
                edit10.apply();
                int optInt8 = jSONObject2.optInt("scbsw", 0);
                SharedPreferences.Editor edit11 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit11.putInt("scb_sw", optInt8);
                edit11.apply();
                int optInt9 = jSONObject2.optInt("scbtsi", 300);
                SharedPreferences.Editor edit12 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit12.putInt("scb_tsi", optInt9);
                edit12.apply();
                long optInt10 = jSONObject2.optInt("bdtsi", 24);
                SharedPreferences.Editor edit13 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit13.putLong("bdtsi", optInt10);
                edit13.apply();
                long optInt11 = jSONObject2.optInt("las", 12);
                SharedPreferences.Editor edit14 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit14.putLong("las", optInt11);
                edit14.apply();
                int optInt12 = jSONObject2.optInt("jumpsw", 0);
                SharedPreferences.Editor edit15 = this.a.getSharedPreferences("_prefs", 0).edit();
                edit15.putInt("jumpsw", optInt12);
                edit15.apply();
                Z1.c(this.a, new Date().getTime());
            } catch (Exception e2) {
                e1.a(this.a).a(101, this.c).a();
                e2.printStackTrace();
            }
        }
    }
}
