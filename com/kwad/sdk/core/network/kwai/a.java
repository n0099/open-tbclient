package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.g;
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
public final class a {
    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z) {
        OutputStream outputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                p.a(httpURLConnection2);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", z ? "application/json" : "application/x-www-form-urlencoded");
                httpURLConnection2.setRequestProperty("User-Agent", n.c());
                httpURLConnection2.setRequestProperty("BrowserUa", n.d());
                httpURLConnection2.setRequestProperty("SystemUa", n.a());
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
                cVar.b = responseCode;
                if (responseCode == 200) {
                    cVar.d = a(httpURLConnection2.getInputStream());
                }
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.a(outputStream2);
            } catch (Exception e) {
                e = e;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream3;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.a(outputStream);
                    return cVar;
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.a(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                OutputStream outputStream4 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream4;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
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

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, Map<String, String> map2) {
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

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
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
            p.a(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", n.c());
            httpURLConnection.setRequestProperty("BrowserUa", n.d());
            httpURLConnection.setRequestProperty("SystemUa", n.a());
            int responseCode = httpURLConnection.getResponseCode();
            cVar.a = responseCode;
            cVar.b = responseCode;
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
            cVar.d = sb.toString();
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.a(inputStream2);
        } catch (Exception e2) {
            e = e2;
            InputStream inputStream3 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.a(inputStream);
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.a(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream4 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream4;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.a(inputStream);
            throw th;
        }
        return cVar;
    }

    public static String a(InputStream inputStream) {
        try {
            try {
                return g.a(inputStream);
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.b(e);
                com.kwad.sdk.crash.utils.b.a(inputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.a(inputStream);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.b.a(e);
            return "";
        }
    }

    public static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        int i = cVar.a;
        if (i == 0) {
            i = -1;
        }
        cVar.b = i;
        cVar.c = exc;
        if (exc instanceof SocketTimeoutException) {
            f fVar = f.a;
            cVar.a = fVar.p;
            cVar.d = fVar.q;
        } else {
            cVar.a = f.b.p;
            try {
                cVar.d = f.b.q + "/n" + Log.getStackTraceString(exc);
            } catch (Exception unused) {
            }
        }
        if (com.kwad.b.kwai.a.b.booleanValue()) {
            com.kwad.sdk.core.d.b.b(exc);
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
