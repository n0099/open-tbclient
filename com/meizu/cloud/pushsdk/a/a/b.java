package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.player.model.YYOption;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static final String a = "b";
    public static final Object b = new Object();
    public static b c;

    public b(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", YYOption.IsLive.VALUE_TRUE);
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
            map = new HashMap<>(2);
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: boolean */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ff, code lost:
        if (r8 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0101, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0126, code lost:
        if (r8 != null) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed A[Catch: Exception -> 0x00e8, all -> 0x0129, TryCatch #4 {Exception -> 0x00e8, blocks: (B:21:0x00b7, B:23:0x00bd, B:24:0x00d8, B:27:0x00e4, B:32:0x00ed, B:33:0x00f9), top: B:62:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9 A[Catch: Exception -> 0x00e8, all -> 0x0129, TRY_LEAVE, TryCatch #4 {Exception -> 0x00e8, blocks: (B:21:0x00b7, B:23:0x00bd, B:24:0x00d8, B:27:0x00e4, B:32:0x00ed, B:33:0x00f9), top: B:62:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c b(String str, Map<String, String> map, String str2) throws Exception {
        HttpURLConnection httpURLConnection;
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
                httpURLConnection = (HttpURLConnection) new URL(PushConstants.URL_UPLOAD_DATA).openConnection();
                httpURLConnection.setRequestMethod(str);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                Map<String, String> map2 = map;
                try {
                    if (map != null) {
                        int size = map.size();
                        map2 = map;
                        if (size > 0) {
                            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                            while (true) {
                                boolean hasNext = it.hasNext();
                                map2 = hasNext;
                                if (hasNext != 0) {
                                    Map.Entry<String, String> next = it.next();
                                    httpURLConnection.setRequestProperty(next.getKey(), next.getValue());
                                }
                            }
                            if (str3 != null) {
                                try {
                                    a(httpURLConnection, str3.getBytes());
                                } catch (Exception e) {
                                    e = e;
                                    inputStream = null;
                                    DebugLogger.e(a, "realStringPartRequest error " + e.getMessage());
                                } catch (Throwable th) {
                                    th = th;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            }
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
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    DebugLogger.e(a, "realStringPartRequest error " + e.getMessage());
                                }
                            } else {
                                a2 = null;
                            }
                            cVar = a2 == null ? new c(responseCode, new String(a2)) : new c(responseCode, null);
                        }
                    }
                    if (str3 != null) {
                    }
                    int responseCode2 = httpURLConnection.getResponseCode();
                    DebugLogger.d(a, "code = " + responseCode2);
                    a(httpURLConnection);
                    b(httpURLConnection);
                    inputStream = httpURLConnection.getInputStream();
                    if (inputStream == null) {
                    }
                    if (a2 == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = map2;
                }
            } catch (MalformedURLException e4) {
                e4.printStackTrace();
            }
        }
        return cVar;
        httpURLConnection.disconnect();
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

    public c a(String str, Map<String, String> map, String str2) {
        try {
            return b(str, a(map), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
