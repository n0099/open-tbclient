package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private static final String a = b.class.getSimpleName();
    private static final Object b = new Object();
    private static b c;
    private Context d;

    private b(Context context) {
        this.d = context;
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a.a(context);
    }

    public static b a(Context context) {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new b(context);
                }
            }
        }
        return c;
    }

    private Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        byte[] c2 = a.a().c();
        if (c2 == null || c2.length <= 0) {
            byte[] b2 = a.a().b();
            if (b2 != null && b2.length > 0) {
                String str = new String(a.a().b());
                com.meizu.cloud.a.a.d(a, "attach x_a_key: " + str);
                map.put("X-A-Key", str);
            }
        } else {
            String str2 = new String(c2);
            com.meizu.cloud.a.a.d(a, "attach x_s_key: " + str2);
            map.put("X-S-Key", str2);
        }
        return map;
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
        }
    }

    private void a(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            com.meizu.cloud.a.a.d(a, "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            a.a().a(headerField);
        } catch (NullPointerException e) {
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0149 */
    /* JADX WARN: Can't wrap try/catch for region: R(14:3|(1:5)(1:72)|6|7|8|(2:10|(9:12|(2:13|(1:15)(0))|17|(3:34|35|(5:37|38|39|40|(0)))(1:19)|(1:21)(1:33)|(2:29|30)|(1:24)(1:28)|25|26)(0))(0)|16|17|(0)(0)|(0)(0)|(0)|(0)(0)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015b, code lost:
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015c, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015e, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015f, code lost:
        r2 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc A[Catch: Exception -> 0x0118, all -> 0x0149, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0118, blocks: (B:21:0x00c5, B:23:0x00cb, B:24:0x00e9, B:35:0x0114, B:28:0x00fc, B:43:0x0142), top: B:73:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0142 A[Catch: Exception -> 0x0118, all -> 0x0149, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0118, blocks: (B:21:0x00c5, B:23:0x00cb, B:24:0x00e9, B:35:0x0114, B:28:0x00fc, B:43:0x0142), top: B:73:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.meizu.cloud.pushsdk.a.a.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c b(String str, Map<String, String> map, String str2) throws IOException {
        c cVar;
        InputStream inputStream;
        byte[] a2;
        if (str2 != null) {
            byte[] a3 = a.a().a(str2.getBytes());
            String str3 = a3 != null ? new String(Base64.encode(a3, 2)) : null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://norma-external-collect.meizu.com/push/android/external/add.do").openConnection();
                httpURLConnection.setRequestMethod(str);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                String str4 = "gzip";
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                ?? r2 = str4;
                try {
                    if (map != null) {
                        r2 = str4;
                        if (map.size() > 0) {
                            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                            String str5 = str4;
                            while (true) {
                                r2 = str5;
                                if (it.hasNext()) {
                                    Map.Entry<String, String> next = it.next();
                                    String key = next.getKey();
                                    httpURLConnection.setRequestProperty(key, next.getValue());
                                    str5 = key;
                                }
                            }
                            a(httpURLConnection, str3.getBytes());
                            int responseCode = httpURLConnection.getResponseCode();
                            com.meizu.cloud.a.a.d(a, "code = " + responseCode);
                            a(httpURLConnection);
                            b(httpURLConnection);
                            inputStream = httpURLConnection.getInputStream();
                            if (inputStream == null) {
                                try {
                                    a2 = a(inputStream);
                                    if (a2 != null) {
                                        String str6 = new String(a2);
                                        com.meizu.cloud.a.a.d(a, "body = " + str6);
                                        try {
                                            if (new JSONObject(str6).getInt("code") == 198003) {
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    com.meizu.cloud.a.a.e(a, "realStringPartRequest error " + e.getMessage());
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                        cVar = null;
                                        return cVar;
                                    }
                                    cVar = null;
                                    return cVar;
                                }
                            } else {
                                a2 = null;
                            }
                            c cVar2 = a2 == null ? new c(responseCode, new String(a2)) : new c(responseCode, null);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (httpURLConnection == null) {
                                httpURLConnection.disconnect();
                                cVar = cVar2;
                            } else {
                                cVar = cVar2;
                            }
                            return cVar;
                        }
                    }
                    a(httpURLConnection, str3.getBytes());
                    int responseCode2 = httpURLConnection.getResponseCode();
                    com.meizu.cloud.a.a.d(a, "code = " + responseCode2);
                    a(httpURLConnection);
                    b(httpURLConnection);
                    inputStream = httpURLConnection.getInputStream();
                    if (inputStream == null) {
                    }
                    if (a2 == null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection == null) {
                    }
                    return cVar;
                } catch (Throwable th) {
                    th = th;
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (MalformedURLException e6) {
                e6.printStackTrace();
                return null;
            }
        }
        cVar = null;
        return cVar;
    }

    private void b(URLConnection uRLConnection) {
        try {
            com.meizu.cloud.a.a.d(a, "get keyTimeout = " + uRLConnection.getHeaderField("Key-Timeout"));
        } catch (NullPointerException e) {
        }
    }

    public c a(String str, Map<String, String> map, String str2) {
        try {
            return b(str, a(map), str2);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
