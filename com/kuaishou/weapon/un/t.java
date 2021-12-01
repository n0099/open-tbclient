package com.kuaishou.weapon.un;

import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class t {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "tun";

    /* renamed from: b  reason: collision with root package name */
    public static final String f56852b = "ppp";
    public transient /* synthetic */ FieldHolder $fh;

    public t() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String property = System.getProperty("http.proxyHost");
            return TextUtils.isEmpty(property) ? "" : property;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                JSONArray b2 = b();
                return b2 != null ? b2.toString() : b(context) ? "[\"con\"]" : "";
            } catch (Throwable th) {
                x0.a(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONArray b() {
        InterceptResult invokeV;
        DataInputStream dataInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/net/route").getInputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (Throwable th3) {
                dataInputStream = null;
                th = th3;
                bufferedReader = null;
            }
            try {
                HashSet hashSet = new HashSet();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String a2 = c1.a(readLine);
                    if (a2.contains(a) || a2.contains(f56852b)) {
                        hashSet.add(a2.split(TrackUI.SEPERATOR)[0]);
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                    x0.a(e2);
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    x0.a(th);
                } finally {
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                            x0.a(e3);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            x0.a(e4);
                        }
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return false;
                }
                return connectivityManager.getNetworkInfo(17).isConnectedOrConnecting();
            } catch (Throwable th) {
                x0.a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
