package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
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
import org.apache.http.HttpHost;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HTTP;
/* loaded from: classes12.dex */
public class az {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f4801a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* loaded from: classes12.dex */
    public static final class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4802a;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (this.f4802a || (read = super.read(bArr, i, i2)) == -1) {
                this.f4802a = true;
                return -1;
            }
            return read;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4803a;

        /* renamed from: a  reason: collision with other field name */
        public Map<String, String> f115a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f4803a), this.f115a.toString());
        }
    }

    public static int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return -1;
                }
                return activeNetworkInfo.getType();
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static NetworkInfo m139a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }

    public static ax a(Context context, String str, String str2, Map<String, String> map, String str3) {
        OutputStream outputStream;
        BufferedReader bufferedReader;
        OutputStream outputStream2 = null;
        ax axVar = new ax();
        try {
            try {
                try {
                    HttpURLConnection m141a = m141a(context, m142a(str));
                    m141a.setConnectTimeout(10000);
                    m141a.setReadTimeout(15000);
                    if (str2 == null) {
                        str2 = "GET";
                    }
                    m141a.setRequestMethod(str2);
                    if (map != null) {
                        for (String str4 : map.keySet()) {
                            m141a.setRequestProperty(str4, map.get(str4));
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m141a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        OutputStream outputStream3 = m141a.getOutputStream();
                        try {
                            outputStream3.write(bytes, 0, bytes.length);
                            outputStream3.flush();
                            outputStream3.close();
                        } catch (IOException e) {
                            e = e;
                            outputStream2 = outputStream3;
                            bufferedReader = null;
                            try {
                                throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
                            } catch (Throwable th) {
                                th = th;
                                BufferedReader bufferedReader2 = bufferedReader;
                                outputStream = outputStream2;
                                outputStream2 = bufferedReader2;
                                y.a(outputStream);
                                y.a(outputStream2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw new IOException(th.getMessage());
                        }
                    }
                    axVar.f4800a = m141a.getResponseCode();
                    Log.d("com.xiaomi.common.Network", "Http POST Response Code: " + axVar.f4800a);
                    int i = 0;
                    while (true) {
                        String headerFieldKey = m141a.getHeaderFieldKey(i);
                        String headerField = m141a.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException e2) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new a(m141a.getErrorStream())));
                            }
                        } else {
                            axVar.f114a.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new a(m141a.getInputStream())));
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String property = System.getProperty("line.separator");
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuffer.append(readLine);
                stringBuffer.append(property);
            }
            axVar.f113a = stringBuffer.toString();
            bufferedReader.close();
            y.a((Closeable) null);
            y.a((Closeable) null);
            return axVar;
        } catch (IOException e4) {
            e = e4;
            throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
        } catch (Throwable th5) {
            th = th5;
            BufferedReader bufferedReader3 = bufferedReader;
            outputStream = null;
            outputStream2 = bufferedReader3;
            y.a(outputStream);
            y.a(outputStream2);
            throw th;
        }
    }

    public static ax a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        }
        if (url == null) {
            throw new IllegalArgumentException("url");
        }
        URL url2 = !z ? new URL(a(url.toString())) : url;
        try {
            HttpURLConnection.setFollowRedirects(true);
            HttpURLConnection m141a = m141a(context, url2);
            m141a.setConnectTimeout(10000);
            m141a.setReadTimeout(15000);
            if (!TextUtils.isEmpty(str)) {
                m141a.setRequestProperty("User-Agent", str);
            }
            if (str2 != null) {
                m141a.setRequestProperty(SM.COOKIE, str2);
            }
            if (map != null) {
                for (String str3 : map.keySet()) {
                    m141a.setRequestProperty(str3, map.get(str3));
                }
            }
            if (bVar != null && (url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME) || url.getProtocol().equals("https"))) {
                bVar.f4803a = m141a.getResponseCode();
                if (bVar.f115a == null) {
                    bVar.f115a = new HashMap();
                }
                int i = 0;
                while (true) {
                    String headerFieldKey = m141a.getHeaderFieldKey(i);
                    String headerField = m141a.getHeaderField(i);
                    if (headerFieldKey == null && headerField == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                        bVar.f115a.put(headerFieldKey, headerField);
                    }
                    i++;
                }
            }
            return new a(m141a.getInputStream());
        } catch (IOException e) {
            throw new IOException("IOException:" + e.getClass().getSimpleName());
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m140a(Context context) {
        if (d(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? "" : (activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getExtraInfo()).toLowerCase();
            } catch (Exception e) {
                return "";
            }
        } catch (Exception e2) {
            return "";
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream = null;
        try {
            inputStream = a(context, url, z, str, str3);
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
            y.a(inputStream);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, be.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    public static String a(String str, Map<String, String> map, File file, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader = null;
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
                fileInputStream = new FileInputStream(file);
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
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new a(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                String stringBuffer2 = stringBuffer.toString();
                                y.a(fileInputStream);
                                y.a(bufferedReader2);
                                return stringBuffer2;
                            }
                            stringBuffer.append(readLine);
                        } catch (IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            fileInputStream2 = fileInputStream;
                            try {
                                throw new IOException("IOException:" + e.getClass().getSimpleName());
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                y.a(fileInputStream);
                                y.a(bufferedReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            y.a(fileInputStream);
                            y.a(bufferedReader);
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(ETAG.EQUAL);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append(ETAG.ITEM_SEPARATOR);
                } catch (UnsupportedEncodingException e) {
                    Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + e.toString());
                    Log.d("com.xiaomi.common.Network", "map: " + map.toString());
                    return null;
                }
            }
        }
        return (stringBuffer.length() > 0 ? stringBuffer.deleteCharAt(stringBuffer.length() - 1) : stringBuffer).toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HttpURLConnection m141a(Context context, URL url) {
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(url.getProtocol()) && m143a(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: a  reason: collision with other method in class */
    private static URL m142a(String str) {
        return new URL(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m143a(Context context) {
        if ("CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return false;
                }
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        return false;
                    }
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3) {
                        return false;
                    }
                    return extraInfo.contains("ctwap");
                } catch (Exception e) {
                    return false;
                }
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        return a(context) >= 0;
    }

    public static boolean c(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean d(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return 1 == activeNetworkInfo.getType();
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean e(Context context) {
        return f(context) || g(context) || h(context);
    }

    public static boolean f(Context context) {
        NetworkInfo m139a = m139a(context);
        return m139a != null && m139a.getType() == 0 && 13 == m139a.getSubtype();
    }

    public static boolean g(Context context) {
        NetworkInfo m139a = m139a(context);
        if (m139a != null && m139a.getType() == 0) {
            String subtypeName = m139a.getSubtypeName();
            if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName)) {
                return true;
            }
            switch (m139a.getSubtype()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return true;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return false;
    }

    public static boolean h(Context context) {
        NetworkInfo m139a = m139a(context);
        if (m139a != null && m139a.getType() == 0) {
            switch (m139a.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return true;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                default:
                    return false;
            }
        }
        return false;
    }
}
