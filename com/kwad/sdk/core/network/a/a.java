package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.k;
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
        StringBuilder sb = new StringBuilder();
        c cVar = new c();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", k.a());
            cVar.f33866a = httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                sb.append(new String(bArr, 0, read));
            }
        } catch (MalformedURLException | IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        cVar.f33867b = sb.toString();
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(String str, Map<String, String> map, String str2, boolean z) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        c cVar = new c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", z ? "application/json" : "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("User-Agent", k.a());
            a(httpURLConnection, map);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                outputStream2 = httpURLConnection.getOutputStream();
                outputStream2.write(str2.getBytes());
                outputStream2.flush();
            }
            int responseCode = httpURLConnection.getResponseCode();
            cVar.f33866a = responseCode;
            if (responseCode == 200) {
                cVar.f33867b = a(httpURLConnection.getInputStream());
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e4) {
            e = e4;
            OutputStream outputStream3 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream3;
            try {
                com.kwad.sdk.core.d.a.a(e);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                        com.kwad.sdk.core.d.a.a(e5);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            OutputStream outputStream4 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream4;
            if (httpURLConnection2 != null) {
            }
            if (outputStream != null) {
            }
            throw th;
        }
        if (outputStream2 != null) {
            outputStream2.close();
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
}
