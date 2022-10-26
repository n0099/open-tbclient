package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.meizu.cloud.pushinternal.DebugLogger;
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
/* loaded from: classes8.dex */
public class b {
    public static final String a = "b";
    public static final Object b = new Object();
    public static b c;
    public Context d;

    public b(Context context) {
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

    private Map a(Map map) {
        if (map == null) {
            map = new HashMap();
        }
        byte[] c2 = a.a().c();
        if (c2 == null || c2.length <= 0) {
            byte[] b2 = a.a().b();
            if (b2 != null && b2.length > 0) {
                String str = new String(a.a().b());
                String str2 = a;
                DebugLogger.d(str2, "attach x_a_key: " + str);
                map.put("X-A-Key", str);
            }
        } else {
            String str3 = new String(c2);
            String str4 = a;
            DebugLogger.d(str4, "attach x_s_key: " + str3);
            map.put("X-S-Key", str3);
        }
        return map;
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(httpURLConnection.getOutputStream());
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.flush();
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            String str = a;
            DebugLogger.d(str, "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            a.a().a(headerField);
        } catch (NullPointerException unused) {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
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
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.io.InputStream */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0104, code lost:
        if (r9 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0106, code lost:
        r9.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012f, code lost:
        if (r9 == null) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00eb A[Catch: Exception -> 0x00e6, all -> 0x0132, TryCatch #2 {all -> 0x0132, blocks: (B:19:0x00b5, B:21:0x00bb, B:22:0x00d6, B:25:0x00e2, B:30:0x00eb, B:31:0x00f7, B:43:0x010e), top: B:66:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f7 A[Catch: Exception -> 0x00e6, all -> 0x0132, TRY_LEAVE, TryCatch #2 {all -> 0x0132, blocks: (B:19:0x00b5, B:21:0x00bb, B:22:0x00d6, B:25:0x00e2, B:30:0x00eb, B:31:0x00f7, B:43:0x010e), top: B:66:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c b(String str, Map map, String str2) throws Exception {
        InputStream inputStream;
        byte[] a2;
        c cVar = null;
        cVar = null;
        cVar = null;
        InputStream inputStream2 = null;
        cVar = null;
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
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                Map map2 = map;
                try {
                    try {
                        if (map != null) {
                            int size = map.size();
                            map2 = map;
                            if (size > 0) {
                                Iterator it = map.entrySet().iterator();
                                while (true) {
                                    boolean hasNext = it.hasNext();
                                    map2 = hasNext;
                                    if (hasNext) {
                                        Map.Entry entry = (Map.Entry) it.next();
                                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                    }
                                }
                                a(httpURLConnection, str3.getBytes());
                                int responseCode = httpURLConnection.getResponseCode();
                                DebugLogger.d(a, "code = " + responseCode);
                                a(httpURLConnection);
                                b(httpURLConnection);
                                inputStream = httpURLConnection.getInputStream();
                                if (inputStream == null) {
                                    try {
                                        a2 = a(inputStream);
                                        if (a2 != null) {
                                            String str4 = new String(a2);
                                            DebugLogger.d(a, "body = " + str4);
                                            try {
                                                new JSONObject(str4).getInt("code");
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        DebugLogger.e(a, "realStringPartRequest error " + e.getMessage());
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused) {
                                            }
                                        }
                                    }
                                } else {
                                    a2 = null;
                                }
                                cVar = a2 == null ? new c(responseCode, new String(a2)) : new c(responseCode, null);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                            }
                        }
                        a(httpURLConnection, str3.getBytes());
                        int responseCode2 = httpURLConnection.getResponseCode();
                        DebugLogger.d(a, "code = " + responseCode2);
                        a(httpURLConnection);
                        b(httpURLConnection);
                        inputStream = httpURLConnection.getInputStream();
                        if (inputStream == null) {
                        }
                        if (a2 == null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = map2;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream2 != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (MalformedURLException e4) {
                e4.printStackTrace();
            }
        }
        return cVar;
    }

    private void b(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("Key-Timeout");
            String str = a;
            DebugLogger.d(str, "get keyTimeout = " + headerField);
        } catch (NullPointerException unused) {
        }
    }

    public c a(String str, Map map, String str2) {
        try {
            return b(str, a(map), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
