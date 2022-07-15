package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.sofire.core.ForHostApp;
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
/* renamed from: com.kuaishou.weapon.p0.ﾞﾞ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0455 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f727 = "tun";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String f728 = "ppp";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static int f729;
    public transient /* synthetic */ FieldHolder $fh;

    public C0455() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m1016() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String property = System.getProperty("http.proxyHost");
            return TextUtils.isEmpty(property) ? "" : property;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m1017(Context context) {
        InterceptResult invokeL;
        JSONArray m1018;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                m1018 = m1018();
            } catch (Throwable unused) {
            }
            return m1018 != null ? m1018.toString() : m1019(context) ? "[\"con\"]" : "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
        if (r2 != null) goto L30;
     */
    /* renamed from: ʼ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray m1018() {
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
                        String m155 = C0298.m155(readLine);
                        if (m155.contains(f727) || m155.contains(f728)) {
                            hashSet.add(m155.split("\t")[0]);
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m1019(Context context) {
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

    /* renamed from: ʽ  reason: contains not printable characters */
    public static int m1020() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f729 : invokeV.intValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    /* renamed from: ʾ  reason: contains not printable characters */
    public static String m1021() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                f729 = 0;
                KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                if (keyStore != null) {
                    keyStore.load(null, null);
                    Enumeration<String> aliases = keyStore.aliases();
                    while (aliases.hasMoreElements()) {
                        f729++;
                        X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                        if (x509Certificate.getIssuerDN().getName().contains("2021") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains(IMTrack.AckBuilder.PROXY_TYPE) || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains(ForHostApp.KEY_NAME_LOCAL) || x509Certificate.getIssuerDN().getName().contains("github")) {
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

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        if (r2 != null) goto L23;
     */
    /* renamed from: ʿ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1022() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65543, null)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuilder sb = new StringBuilder();
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /system/etc/security/cacerts/* | grep Issuer:").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        int indexOf = readLine.indexOf("O=");
                        sb.append(readLine.substring(indexOf, readLine.substring(indexOf).indexOf(",")));
                        sb.append("|");
                    } catch (Throwable unused) {
                        dataInputStream2 = dataInputStream;
                        if (dataInputStream2 != null) {
                            try {
                                dataInputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
        try {
            dataInputStream.close();
        } catch (IOException unused5) {
            try {
                bufferedReader.close();
            } catch (IOException unused6) {
            }
            return sb.toString();
        }
    }
}
