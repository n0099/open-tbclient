package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    public static c a(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
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
                l.a(httpURLConnection2);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", z ? "application/json" : "application/x-www-form-urlencoded");
                httpURLConnection2.setRequestProperty("User-Agent", k.a());
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
                cVar.f32392a = responseCode;
                if (responseCode == 200) {
                    cVar.f32393b = a(httpURLConnection2.getInputStream());
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                com.kwad.sdk.crash.utils.b.a(outputStream2);
            } catch (Exception e2) {
                e = e2;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream3;
                try {
                    com.kwad.sdk.core.d.a.a(e);
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
        } catch (Exception e3) {
            e = e3;
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
                String a2 = a(entry.getValue());
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(a2);
                sb.append("&");
            }
            str2 = sb.substring(0, sb.length() - 1);
        } else {
            str2 = null;
        }
        return a(str, map, str2, false);
    }

    public static c a(String str, Map<String, String> map, boolean z) {
        StringBuilder sb = new StringBuilder();
        c cVar = new c();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            l.a(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", k.a());
            cVar.f32392a = httpURLConnection.getResponseCode();
            if (z) {
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
            }
        } catch (MalformedURLException | IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        cVar.f32393b = sb.toString();
        return cVar;
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        com.kwad.sdk.core.d.a.a(e3);
                    }
                    throw th;
                }
            } catch (IOException e4) {
                com.kwad.sdk.core.d.a.a(e4);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        com.kwad.sdk.core.d.a.a(e5);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (IOException e6) {
                    com.kwad.sdk.core.d.a.a(e6);
                    return null;
                }
            }
        }
        String str = new String(byteArrayOutputStream.toByteArray());
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e7) {
                com.kwad.sdk.core.d.a.a(e7);
            }
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e8) {
            com.kwad.sdk.core.d.a.a(e8);
        }
        return str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return "";
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

    public static c b(String str, Map<String, String> map) {
        return a(str, map, false);
    }
}
