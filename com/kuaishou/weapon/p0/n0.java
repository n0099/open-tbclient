package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class n0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "tun";
    public static final String b = "ppp";
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    public n0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        JSONArray b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                b2 = b();
            } catch (Throwable unused) {
            }
            return b2 != null ? b2.toString() : b(context) ? "[\"con\"]" : "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
        if (r2 != null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            JSONArray jSONArray = new JSONArray();
            DataInputStream dataInputStream = null;
            try {
                DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("cat /proc/net/route").getInputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                } catch (Throwable unused) {
                    bufferedReader = null;
                }
                try {
                    HashSet hashSet = new HashSet();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String a2 = o1.a(readLine);
                        if (a2.contains(a) || a2.contains(b)) {
                            hashSet.add(a2.split("\t")[0]);
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    try {
                        dataInputStream2.close();
                    } catch (IOException unused2) {
                    }
                } catch (Throwable unused3) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                }
            } catch (Throwable unused5) {
                bufferedReader = null;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused6) {
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
                if (Build.VERSION.SDK_INT >= 21) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    return networkCapabilities != null && networkCapabilities.hasTransport(4);
                }
                return connectivityManager.getNetworkInfo(17).isConnectedOrConnecting();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c : invokeV.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                c = 0;
                KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                if (keyStore != null) {
                    keyStore.load(null, null);
                    Enumeration<String> aliases = keyStore.aliases();
                    while (aliases.hasMoreElements()) {
                        c++;
                        X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                        if (x509Certificate.getIssuerDN().getName().contains("2021") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains("proxy") || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains("local") || x509Certificate.getIssuerDN().getName().contains("github")) {
                            sb.append(x509Certificate.getIssuerDN().getName());
                            sb.append("|");
                        }
                    }
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } catch (Throwable unused) {
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
