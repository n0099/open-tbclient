package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.m;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static c a(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(String str, Map<String, String> map, String str2, boolean z) {
        OutputStream outputStream;
        c cVar = new c();
        HttpURLConnection httpURLConnection = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                m.a(httpURLConnection2);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", z ? "application/json" : "application/x-www-form-urlencoded");
                httpURLConnection2.setRequestProperty("User-Agent", k.c());
                httpURLConnection2.setRequestProperty("BrowserUa", k.d());
                httpURLConnection2.setRequestProperty("SystemUa", k.a());
                a(httpURLConnection2, map);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream2 = httpURLConnection2.getOutputStream();
                    outputStream2.write(str2.getBytes());
                    outputStream2.flush();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                cVar.a = responseCode;
                if (responseCode == 200) {
                    cVar.b = a(httpURLConnection2.getInputStream());
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                com.kwad.sdk.crash.utils.b.a(outputStream2);
            } catch (Exception e) {
                e = e;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream3;
                try {
                    a(cVar, e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    com.kwad.sdk.crash.utils.b.a(outputStream);
                    return cVar;
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    com.kwad.sdk.crash.utils.b.a(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                OutputStream outputStream4 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream4;
                if (httpURLConnection != null) {
                }
                com.kwad.sdk.crash.utils.b.a(outputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        return cVar;
    }

    public static c a(String str, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String a = a(entry.getValue());
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(a);
                sb.append("&");
            }
            str2 = sb.substring(0, sb.length() - 1);
        } else {
            str2 = null;
        }
        return a(str, map, str2, false);
    }

    public static c a(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(String str, Map<String, String> map, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        c cVar = new c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        InputStream inputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e) {
            e = e;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            m.a(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", k.c());
            httpURLConnection.setRequestProperty("BrowserUa", k.d());
            httpURLConnection.setRequestProperty("SystemUa", k.a());
            cVar.a = httpURLConnection.getResponseCode();
            StringBuilder sb = new StringBuilder();
            if (z) {
                inputStream2 = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
            }
            cVar.b = sb.toString();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            com.kwad.sdk.crash.utils.b.a(inputStream2);
        } catch (Exception e2) {
            e = e2;
            InputStream inputStream3 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream3;
            try {
                a(cVar, e);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                com.kwad.sdk.crash.utils.b.a(inputStream);
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                com.kwad.sdk.crash.utils.b.a(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream4 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream4;
            if (httpURLConnection2 != null) {
            }
            com.kwad.sdk.crash.utils.b.a(inputStream);
            throw th;
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(InputStream inputStream) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String str = new String(byteArrayOutputStream.toByteArray());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            com.kwad.sdk.core.d.a.b(e);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                    return str;
                } catch (IOException e3) {
                    e = e3;
                    com.kwad.sdk.core.d.a.b(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            com.kwad.sdk.core.d.a.b(e4);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e5) {
                            com.kwad.sdk.core.d.a.b(e5);
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        com.kwad.sdk.core.d.a.b(e6);
                    }
                }
                if (0 != 0) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e7) {
                        com.kwad.sdk.core.d.a.b(e7);
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
            }
            if (0 != 0) {
            }
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.a.a(e);
            return "";
        }
    }

    public static void a(@NonNull c cVar, Exception exc) {
        f fVar = exc instanceof SocketTimeoutException ? f.a : f.b;
        cVar.a = fVar.n;
        cVar.b = fVar.o;
        if (com.kwad.sdk.b.c.booleanValue()) {
            com.kwad.sdk.core.d.a.b(exc);
        }
    }

    public static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
