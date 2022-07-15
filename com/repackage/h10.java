package com.repackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes6.dex */
public class h10 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public static String c;
    public static HashMap<String, Integer> d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755701238, "Lcom/repackage/h10;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755701238, "Lcom/repackage/h10;");
                return;
            }
        }
        b = AppConfig.isDebug();
        c = "networkparam";
        HashMap<String, Integer> hashMap = new HashMap<>();
        d = hashMap;
        hashMap.put("WIFI", 1);
        d.put("3GNET", 21);
        d.put("3GWAP", 22);
        d.put("CMNET", 31);
        d.put("UNINET", 32);
        d.put("CTNET", 33);
        d.put("CMWAP", 41);
        d.put("UNIWAP", 42);
        d.put("CTWAP", 43);
    }

    public h10() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = AppRuntime.getAppContext();
    }

    public String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                String b2 = b();
                if (TextUtils.equals(b2, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                    return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.a.getApplicationContext()).getString(NetworkParam.LAST_NETWORK_TYPE, NetworkParam.NET_TYPE_ID_DISCONNECT));
                }
                if (TextUtils.isEmpty(b2)) {
                    return str;
                }
                if (!TextUtils.equals(b2, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a.getApplicationContext()).edit();
                    edit.putString(NetworkParam.LAST_NETWORK_TYPE, b2);
                    edit.apply();
                }
                return UrlUtil.addParam(str, "network", b2);
            }
            return UrlUtil.addParam(str, "network", b());
        }
        return (String) invokeLZ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long uptimeMillis = b ? SystemClock.uptimeMillis() : 0L;
            ConnectManager connectManager = new ConnectManager(this.a);
            String netType = connectManager.getNetType();
            int subType = connectManager.getSubType();
            if (!TextUtils.isEmpty(netType)) {
                netType = netType.toUpperCase(Locale.getDefault());
                Integer num = d.get(netType);
                if (num == null) {
                    num = 5;
                }
                str = num + "_" + subType;
            } else {
                str = ((Object) 5) + "_" + subType;
            }
            if (b) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                Log.i(c, "getCurrentNetTypeId cost " + (uptimeMillis2 - uptimeMillis) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName());
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
