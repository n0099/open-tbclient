package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public class bg {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f63321b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f63322c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            int read;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
                if (this.a || (read = super.read(bArr, i2, i3)) == -1) {
                    this.a = true;
                    return -1;
                }
                return read;
            }
            return invokeLII.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Map<String, String> f156a;

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.a), this.f156a.toString()) : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56378725, "Lcom/xiaomi/push/bg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56378725, "Lcom/xiaomi/push/bg;");
                return;
            }
        }
        a = Pattern.compile("([^\\s;]+)(.*)");
        f63321b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
        f63322c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return -1;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return -1;
                }
                return activeNetworkInfo.getType();
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static NetworkInfo m223a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return null;
                }
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    public static be a(Context context, String str, String str2, Map<String, String> map, String str3) {
        InterceptResult invokeLLLLL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, context, str, str2, map, str3)) == null) {
            be beVar = new be();
            try {
                try {
                    try {
                        HttpURLConnection m225a = m225a(context, m226a(str));
                        m225a.setConnectTimeout(10000);
                        m225a.setReadTimeout(15000);
                        String str4 = str2;
                        if (str2 == 0) {
                            str4 = "GET";
                        }
                        m225a.setRequestMethod(str4);
                        if (map != null) {
                            for (String str5 : map.keySet()) {
                                m225a.setRequestProperty(str5, map.get(str5));
                            }
                        }
                        int i2 = 0;
                        if (!TextUtils.isEmpty(str3)) {
                            m225a.setDoOutput(true);
                            byte[] bytes = str3.getBytes();
                            OutputStream outputStream = m225a.getOutputStream();
                            try {
                                outputStream.write(bytes, 0, bytes.length);
                                outputStream.flush();
                                outputStream.close();
                            } catch (IOException e2) {
                                e = e2;
                                throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
                            } catch (Throwable th) {
                                th = th;
                                throw new IOException(th.getMessage());
                            }
                        }
                        beVar.a = m225a.getResponseCode();
                        String str6 = "Http POST Response Code: " + beVar.a;
                        while (true) {
                            String headerFieldKey = m225a.getHeaderFieldKey(i2);
                            String headerField = m225a.getHeaderField(i2);
                            if (headerFieldKey == null && headerField == null) {
                                try {
                                    break;
                                } catch (IOException unused) {
                                    bufferedReader = new BufferedReader(new InputStreamReader(new a(m225a.getErrorStream())));
                                }
                            } else {
                                beVar.f155a.put(headerFieldKey, headerField);
                                i2 = i2 + 1 + 1;
                            }
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(new a(m225a.getInputStream())));
                    } catch (Throwable th2) {
                        y.a((Closeable) null);
                        y.a((Closeable) str2);
                        throw th2;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String property = System.getProperty("line.separator");
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(property);
                }
                beVar.f154a = stringBuffer.toString();
                bufferedReader.close();
                y.a((Closeable) null);
                y.a((Closeable) null);
                return beVar;
            } catch (IOException e4) {
                e = e4;
                throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
            } catch (Throwable th4) {
                th = th4;
                throw new IOException(th.getMessage());
            }
        }
        return (be) invokeLLLLL.objValue;
    }

    public static be a(Context context, String str, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, map)) == null) ? a(context, str, "POST", (Map<String, String>) null, a(map)) : (be) invokeLLL.objValue;
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, url, Boolean.valueOf(z), str, str2})) == null) ? a(context, url, z, str, str2, null, null) : (InputStream) invokeCommon.objValue;
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, url, Boolean.valueOf(z), str, str2, map, bVar})) == null) {
            if (context != null) {
                if (url != null) {
                    URL url2 = !z ? new URL(a(url.toString())) : url;
                    try {
                        HttpURLConnection.setFollowRedirects(true);
                        HttpURLConnection m225a = m225a(context, url2);
                        m225a.setConnectTimeout(10000);
                        m225a.setReadTimeout(15000);
                        if (!TextUtils.isEmpty(str)) {
                            m225a.setRequestProperty("User-Agent", str);
                        }
                        if (str2 != null) {
                            m225a.setRequestProperty("Cookie", str2);
                        }
                        if (map != null) {
                            for (String str3 : map.keySet()) {
                                m225a.setRequestProperty(str3, map.get(str3));
                            }
                        }
                        if (bVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                            bVar.a = m225a.getResponseCode();
                            if (bVar.f156a == null) {
                                bVar.f156a = new HashMap();
                            }
                            int i2 = 0;
                            while (true) {
                                String headerFieldKey = m225a.getHeaderFieldKey(i2);
                                String headerField = m225a.getHeaderField(i2);
                                if (headerFieldKey == null && headerField == null) {
                                    break;
                                }
                                if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                                    bVar.f156a.put(headerFieldKey, headerField);
                                }
                                i2++;
                            }
                        }
                        return new a(m225a.getInputStream());
                    } catch (IOException e2) {
                        throw new IOException("IOException:" + e2.getClass().getSimpleName());
                    } catch (Throwable th) {
                        throw new IOException(th.getMessage());
                    }
                }
                throw new IllegalArgumentException("url");
            }
            throw new IllegalArgumentException("context");
        }
        return (InputStream) invokeCommon.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m224a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (e(context)) {
                return "wifi";
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return "";
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return "";
                }
                return (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, URL url) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, url)) == null) ? a(context, url, false, null, "UTF-8", null) : (String) invokeLL.objValue;
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, url, Boolean.valueOf(z), str, str2, str3})) != null) {
            return (String) invokeCommon.objValue;
        }
        try {
            inputStream = a(context, url, z, str, str3);
            try {
                StringBuilder sb = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 == read) {
                        y.a(inputStream);
                        return sb.toString();
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                y.a(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            new String();
            return String.format("%s&key=%s", str, bl.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.io.File */
    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65547, null, str, map, file, str2)) != null) {
            return (String) invokeLLLL.objValue;
        }
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new a(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                String stringBuffer2 = stringBuffer.toString();
                                y.a(fileInputStream);
                                y.a(bufferedReader);
                                return stringBuffer2;
                            }
                            stringBuffer.append(readLine);
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                y.a((Closeable) null);
                y.a((Closeable) file);
                throw th3;
            }
        } catch (IOException e4) {
            e = e4;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, map)) == null) {
            if (map == null || map.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    try {
                        stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                        stringBuffer.append("=");
                        stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                        stringBuffer.append("&");
                    } catch (UnsupportedEncodingException e2) {
                        String str = "Failed to convert from params map to string: " + e2.toString();
                        String str2 = "map: " + map.toString();
                        return null;
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HttpURLConnection m225a(Context context, URL url) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, url)) == null) {
            return (HttpURLConnection) (("http".equals(url.getProtocol()) && m227a(context)) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static URL m226a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? new URL(str) : (URL) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m227a(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if ("CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
                try {
                    connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                } catch (Exception unused) {
                }
                if (connectivityManager == null) {
                    return false;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return !TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && extraInfo.contains(ConectivityUtils.APN_CTWAP);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? a(context) >= 0 : invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                        if (networkCapabilities != null) {
                            return networkCapabilities.hasCapability(16);
                        }
                        return false;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return b(context);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        NetworkInfo networkInfo;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                networkInfo = null;
            }
            return networkInfo != null && networkInfo.isConnected();
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return false;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            NetworkInfo m223a = m223a(context);
            return m223a != null && m223a.getType() == 0 && 20 == m223a.getSubtype();
        }
        return invokeL.booleanValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            NetworkInfo m223a = m223a(context);
            return m223a != null && m223a.getType() == 0 && 13 == m223a.getSubtype();
        }
        return invokeL.booleanValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            NetworkInfo m223a = m223a(context);
            if (m223a != null && m223a.getType() == 0) {
                String subtypeName = m223a.getSubtypeName();
                if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
                    switch (m223a.getSubtype()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            break;
                        case 4:
                        case 7:
                        case 11:
                        case 13:
                        default:
                            return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            NetworkInfo m223a = m223a(context);
            if (m223a != null && m223a.getType() == 0) {
                int subtype = m223a.getSubtype();
                return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
