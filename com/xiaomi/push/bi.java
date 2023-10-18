package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
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
import java.util.zip.GZIPOutputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public class bi {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* loaded from: classes10.dex */
    public static final class a extends FilterInputStream {
        public boolean a;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (this.a || (read = super.read(bArr, i, i2)) == -1) {
                this.a = true;
                return -1;
            }
            return read;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Map<String, String> f143a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.a), this.f143a.toString());
        }
    }

    public static int a(Context context) {
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

    /* renamed from: a  reason: collision with other method in class */
    public static NetworkInfo m289a(Context context) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    public static bg a(Context context, String str, String str2, Map<String, String> map, String str3) {
        boolean z;
        BufferedReader bufferedReader;
        bg bgVar = new bg();
        try {
            try {
                try {
                    HttpURLConnection m291a = m291a(context, m292a(str));
                    m291a.setConnectTimeout(10000);
                    m291a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    m291a.setRequestMethod(str4);
                    int i = 0;
                    if (map != null) {
                        z = "gzip".equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            m291a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m291a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        OutputStream gZIPOutputStream = z ? new GZIPOutputStream(m291a.getOutputStream()) : m291a.getOutputStream();
                        try {
                            gZIPOutputStream.write(bytes, 0, bytes.length);
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                        } catch (IOException e) {
                            e = e;
                            throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    bgVar.a = m291a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.m182a("Http POST Response Code: " + bgVar.a);
                    while (true) {
                        String headerFieldKey = m291a.getHeaderFieldKey(i);
                        String headerField = m291a.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new a(m291a.getErrorStream())));
                            }
                        } else {
                            bgVar.f142a.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new a(m291a.getInputStream())));
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String property = System.getProperty("line.separator");
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(property);
                }
                bgVar.f141a = stringBuffer.toString();
                bufferedReader.close();
                y.a((Closeable) null);
                y.a((Closeable) null);
                return bgVar;
            } catch (IOException e3) {
                e = e3;
                throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
            } catch (Throwable th3) {
                th = th3;
                throw new IOException(th.getMessage());
            }
        } catch (Throwable th4) {
            y.a((Closeable) null);
            y.a((Closeable) str2);
            throw th4;
        }
    }

    public static bg a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context != null) {
            if (url != null) {
                URL url2 = !z ? new URL(a(url.toString())) : url;
                try {
                    HttpURLConnection.setFollowRedirects(true);
                    HttpURLConnection m291a = m291a(context, url2);
                    m291a.setConnectTimeout(10000);
                    m291a.setReadTimeout(15000);
                    if (!TextUtils.isEmpty(str)) {
                        m291a.setRequestProperty("User-Agent", str);
                    }
                    if (str2 != null) {
                        m291a.setRequestProperty("Cookie", str2);
                    }
                    if (map != null) {
                        for (String str3 : map.keySet()) {
                            m291a.setRequestProperty(str3, map.get(str3));
                        }
                    }
                    if (bVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                        bVar.a = m291a.getResponseCode();
                        if (bVar.f143a == null) {
                            bVar.f143a = new HashMap();
                        }
                        int i = 0;
                        while (true) {
                            String headerFieldKey = m291a.getHeaderFieldKey(i);
                            String headerField = m291a.getHeaderField(i);
                            if (headerFieldKey == null && headerField == null) {
                                break;
                            }
                            if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                                bVar.f143a.put(headerFieldKey, headerField);
                            }
                            i++;
                        }
                    }
                    return new a(m291a.getInputStream());
                } catch (IOException e) {
                    throw new IOException("IOException:" + e.getClass().getSimpleName());
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }
            throw new IllegalArgumentException("url");
        }
        throw new IllegalArgumentException("context");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m290a(Context context) {
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

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
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
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, bn.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.io.File */
    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
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
                        } catch (IOException e) {
                            e = e;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                y.a((Closeable) null);
                y.a((Closeable) file);
                throw th3;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Throwable th4) {
            th = th4;
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
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("Failed to convert from params map to string: " + e);
                    com.xiaomi.channel.commonutils.logger.b.m182a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HttpURLConnection m291a(Context context, URL url) {
        return (HttpURLConnection) (("http".equals(url.getProtocol()) && m293a(context)) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static URL m292a(String str) {
        return new URL(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m293a(Context context) {
        ConnectivityManager connectivityManager;
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

    public static boolean b(Context context) {
        return a(context) >= 0;
    }

    public static boolean c(Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (Exception unused) {
                }
            } else {
                z = b(context);
            }
            return z && d(context);
        }
        z = false;
        if (z) {
            return false;
        }
    }

    public static boolean d(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean e(Context context) {
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

    public static boolean f(Context context) {
        NetworkInfo m289a = m289a(context);
        return m289a != null && m289a.getType() == 0 && 20 == m289a.getSubtype();
    }

    public static boolean g(Context context) {
        NetworkInfo m289a = m289a(context);
        return m289a != null && m289a.getType() == 0 && 13 == m289a.getSubtype();
    }

    public static boolean h(Context context) {
        NetworkInfo m289a = m289a(context);
        if (m289a != null && m289a.getType() == 0) {
            String subtypeName = m289a.getSubtypeName();
            if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
                switch (m289a.getSubtype()) {
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

    public static boolean i(Context context) {
        NetworkInfo m289a = m289a(context);
        if (m289a != null && m289a.getType() == 0) {
            int subtype = m289a.getSubtype();
            return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
        }
        return false;
    }
}
