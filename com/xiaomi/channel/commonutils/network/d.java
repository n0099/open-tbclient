package com.xiaomi.channel.commonutils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class d {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* loaded from: classes2.dex */
    public static final class a extends FilterInputStream {
        private boolean a;

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

    /* loaded from: classes2.dex */
    public static class b {
        public int a;
        public Map<String, String> b;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.a), this.b.toString());
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[Catch: IOException -> 0x011e, TRY_LEAVE, TryCatch #10 {IOException -> 0x011e, blocks: (B:19:0x004a, B:21:0x004f), top: B:81:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.xiaomi.channel.commonutils.network.b a(Context context, String str, String str2, Map<String, String> map, String str3) {
        ?? r1;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        BufferedReader bufferedReader2 = null;
        com.xiaomi.channel.commonutils.network.b bVar = new com.xiaomi.channel.commonutils.network.b();
        try {
            try {
                try {
                    HttpURLConnection b2 = b(context, b(str));
                    b2.setConnectTimeout(10000);
                    b2.setReadTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                    if (str2 == null) {
                        str2 = HttpGet.METHOD_NAME;
                    }
                    b2.setRequestMethod(str2);
                    if (map != null) {
                        for (String str4 : map.keySet()) {
                            b2.setRequestProperty(str4, map.get(str4));
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        outputStream = null;
                    } else {
                        b2.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        OutputStream outputStream2 = b2.getOutputStream();
                        try {
                            outputStream2.write(bytes, 0, bytes.length);
                            outputStream2.flush();
                            outputStream2.close();
                            outputStream = null;
                        } catch (IOException e) {
                            e = e;
                            bufferedReader2 = outputStream2;
                            bufferedReader = null;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                BufferedReader bufferedReader3 = bufferedReader;
                                r1 = bufferedReader2;
                                bufferedReader2 = bufferedReader3;
                                if (r1 != 0) {
                                    try {
                                        r1.close();
                                    } catch (IOException e2) {
                                        Log.e("com.xiaomi.common.Network", "error while closing strean", e2);
                                        throw th;
                                    }
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw new IOException(th.getMessage());
                        }
                    }
                    bVar.a = b2.getResponseCode();
                    Log.d("com.xiaomi.common.Network", "Http POST Response Code: " + bVar.a);
                    int i = 0;
                    while (true) {
                        String headerFieldKey = b2.getHeaderFieldKey(i);
                        String headerField = b2.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException e3) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new a(b2.getErrorStream())));
                            }
                        } else {
                            bVar.b.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new a(b2.getInputStream())));
                } catch (IOException e4) {
                    e = e4;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
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
            bVar.c = stringBuffer.toString();
            bufferedReader.close();
            BufferedReader bufferedReader4 = null;
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.e("com.xiaomi.common.Network", "error while closing strean", e5);
                }
            }
            if (0 != 0) {
                bufferedReader4.close();
            }
            return bVar;
        } catch (IOException e6) {
            e = e6;
            throw e;
        } catch (Throwable th5) {
            th = th5;
            BufferedReader bufferedReader5 = bufferedReader;
            r1 = 0;
            bufferedReader2 = bufferedReader5;
            if (r1 != 0) {
            }
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    public static com.xiaomi.channel.commonutils.network.b a(Context context, String str, Map<String, String> map) {
        return a(context, str, HttpPost.METHOD_NAME, (Map<String, String>) null, a(map));
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
            HttpURLConnection b2 = b(context, url2);
            b2.setConnectTimeout(10000);
            b2.setReadTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
            if (!TextUtils.isEmpty(str)) {
                b2.setRequestProperty(HTTP.USER_AGENT, str);
            }
            if (str2 != null) {
                b2.setRequestProperty(SM.COOKIE, str2);
            }
            if (map != null) {
                for (String str3 : map.keySet()) {
                    b2.setRequestProperty(str3, map.get(str3));
                }
            }
            if (bVar != null && (url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME) || url.getProtocol().equals("https"))) {
                bVar.a = b2.getResponseCode();
                if (bVar.b == null) {
                    bVar.b = new HashMap();
                }
                int i = 0;
                while (true) {
                    String headerFieldKey = b2.getHeaderFieldKey(i);
                    String headerField = b2.getHeaderField(i);
                    if (headerFieldKey == null && headerField == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                        bVar.b.put(headerFieldKey, headerField);
                    }
                    i++;
                }
            }
            return new a(b2.getInputStream());
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, HTTP.UTF_8, null);
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
                    break;
                }
                sb.append(cArr, 0, read);
            }
            return sb.toString();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + e.toString());
                }
            }
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, com.xiaomi.channel.commonutils.string.c.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x017d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083 A[Catch: IOException -> 0x0180, TryCatch #12 {IOException -> 0x0180, blocks: (B:20:0x007e, B:22:0x0083, B:24:0x0088), top: B:77:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088 A[Catch: IOException -> 0x0180, TRY_LEAVE, TryCatch #12 {IOException -> 0x0180, blocks: (B:20:0x007e, B:22:0x0083, B:24:0x0088), top: B:77:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Object obj;
        BufferedReader bufferedReader = null;
        if (!file.exists()) {
            return null;
        }
        ?? name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.writeBytes("--*****\r\n");
                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                    dataOutputStream.writeBytes("\r\n");
                    name = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = name.read(bArr);
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
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (IOException e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                dataOutputStream2 = dataOutputStream;
                                obj = name;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    name = obj;
                                    dataOutputStream = dataOutputStream2;
                                    if (name != 0) {
                                        try {
                                            name.close();
                                        } catch (IOException e2) {
                                            Log.e("com.xiaomi.common.Network", "error while closing strean", e2);
                                            throw th;
                                        }
                                    }
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                throw new IOException(th.getMessage());
                            }
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        if (name != 0) {
                            try {
                                name.close();
                            } catch (IOException e3) {
                                Log.e("com.xiaomi.common.Network", "error while closing strean", e3);
                                return stringBuffer2;
                            }
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                            return stringBuffer2;
                        }
                        return stringBuffer2;
                    } catch (IOException e4) {
                        e = e4;
                        dataOutputStream2 = dataOutputStream;
                        obj = name;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e5) {
                    e = e5;
                    dataOutputStream2 = dataOutputStream;
                    obj = null;
                } catch (Throwable th4) {
                    th = th4;
                    name = 0;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException e6) {
            e = e6;
            dataOutputStream2 = null;
            obj = null;
        } catch (Throwable th6) {
            th = th6;
            dataOutputStream = null;
            name = 0;
        }
    }

    public static String a(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol()).append("://").append("10.0.0.172").append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery())) {
            sb.append("?").append(url.getQuery());
        }
        return sb.toString();
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), HTTP.UTF_8));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), HTTP.UTF_8));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + e.toString());
                    Log.d("com.xiaomi.common.Network", "map: " + map.toString());
                    return null;
                }
            }
        }
        return (stringBuffer.length() > 0 ? stringBuffer.deleteCharAt(stringBuffer.length() - 1) : stringBuffer).toString();
    }

    public static HttpURLConnection b(Context context, URL url) {
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(url.getProtocol())) {
            if (c(context)) {
                return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
            }
            if (b(context)) {
                String host = url.getHost();
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a(url)).openConnection();
                httpURLConnection.addRequestProperty("X-Online-Host", host);
                return httpURLConnection;
            }
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    private static URL b(String str) {
        return new URL(str);
    }

    public static boolean b(Context context) {
        if ("CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSimCountryIso())) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    try {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            String extraInfo = activeNetworkInfo.getExtraInfo();
                            if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || extraInfo.contains(Apn.APN_CTWAP)) {
                                return false;
                            }
                            return extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3);
                        }
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        if ("CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSimCountryIso())) {
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
                    return extraInfo.contains(Apn.APN_CTWAP);
                } catch (Exception e) {
                    return false;
                }
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    public static boolean d(Context context) {
        return a(context) >= 0;
    }

    public static boolean e(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean f(Context context) {
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

    public static boolean g(Context context) {
        NetworkInfo j = j(context);
        return j != null && j.getType() == 0 && 13 == j.getSubtype();
    }

    public static boolean h(Context context) {
        NetworkInfo j = j(context);
        if (j != null && j.getType() == 0) {
            String subtypeName = j.getSubtypeName();
            if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName)) {
                return true;
            }
            switch (j.getSubtype()) {
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

    public static boolean i(Context context) {
        NetworkInfo j = j(context);
        if (j != null && j.getType() == 0) {
            switch (j.getSubtype()) {
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

    public static NetworkInfo j(Context context) {
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

    public static String k(Context context) {
        if (f(context)) {
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
}
