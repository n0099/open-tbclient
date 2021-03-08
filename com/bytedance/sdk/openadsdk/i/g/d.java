package com.bytedance.sdk.openadsdk.i.g;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.http.Headers;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.i.e.f;
import com.bytedance.sdk.openadsdk.i.i;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class d {
    private static final Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f4848a = Charset.forName("UTF-8");

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable th) {
            }
        }
    }

    public static boolean a(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    public static int b(String str) {
        return a(str, 0);
    }

    public static int a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i;
    }

    public static String a(com.bytedance.sdk.openadsdk.i.e.a aVar, int i) {
        int a2;
        boolean z;
        if (aVar == null || !aVar.b()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.e().toUpperCase()).append(' ').append(aVar.a()).append(' ').append(aVar.f()).append("\r\n");
        if (e.c) {
            Log.i("TAG_PROXY_headers", aVar.e().toUpperCase() + " " + aVar.a() + " " + aVar.f());
        }
        boolean z2 = true;
        List<i.b> a3 = a(aVar.c());
        if (a3 != null) {
            int size = a3.size();
            int i2 = 0;
            while (i2 < size) {
                i.b bVar = a3.get(i2);
                if (bVar != null) {
                    String str = bVar.f4853a;
                    String str2 = bVar.b;
                    sb.append(str).append(": ").append(str2).append("\r\n");
                    if (Headers.CONTENT_RANGE.equalsIgnoreCase(str)) {
                        z = false;
                    } else if ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2)) {
                        z = false;
                    }
                    i2++;
                    z2 = z;
                }
                z = z2;
                i2++;
                z2 = z;
            }
        }
        if (z2 && (a2 = a(aVar)) > 0) {
            sb.append("Content-Range: bytes ").append(Math.max(i, 0)).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(a2 - 1).append("/").append(a2).append("\r\n");
        }
        sb.append("Connection: close").append("\r\n");
        sb.append("\r\n");
        String sb2 = sb.toString();
        if (e.c) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb2);
            return sb2;
        }
        return sb2;
    }

    public static String a(int i, int i2) {
        String b2 = b(i, i2);
        if (b2 == null) {
            return null;
        }
        return "bytes=" + b2;
    }

    public static String b(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
        }
        if (i > 0) {
            return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        if (i < 0 && i2 > 0) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
        }
        return null;
    }

    public static List<String> a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (a(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String a(com.bytedance.sdk.openadsdk.i.b.a aVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK").append("\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content").append("\r\n");
        }
        sb.append("Accept-Ranges: bytes").append("\r\n");
        sb.append("Content-Type: ").append(aVar.b).append("\r\n");
        if (i <= 0) {
            sb.append("Content-Length: ").append(aVar.c).append("\r\n");
        } else {
            sb.append("Content-Range: bytes ").append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(aVar.c - 1).append("/").append(aVar.c).append("\r\n");
            sb.append("Content-Length: ").append(aVar.c - i).append("\r\n");
        }
        sb.append("Connection: close").append("\r\n");
        sb.append("\r\n");
        String sb2 = sb.toString();
        if (e.c) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static int a() {
        File[] listFiles;
        if (Build.VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || (listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.i.g.d.1

                /* renamed from: a  reason: collision with root package name */
                private Pattern f4849a = Pattern.compile("^cpu[0-9]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return this.f4849a.matcher(str).matches();
                }
            })) == null) {
                return 1;
            }
            return Math.max(listFiles.length, 1);
        } catch (Throwable th) {
            return 1;
        }
    }

    public static int a(com.bytedance.sdk.openadsdk.i.e.a aVar) {
        int lastIndexOf;
        if (aVar == null) {
            return -1;
        }
        if (aVar.a() == 200) {
            return a(aVar.a("Content-Length", null), -1);
        }
        if (aVar.a() == 206) {
            String a2 = aVar.a(Headers.CONTENT_RANGE, null);
            if (TextUtils.isEmpty(a2) || (lastIndexOf = a2.lastIndexOf("/")) < 0 || lastIndexOf >= a2.length() - 1) {
                return -1;
            }
            return a(a2.substring(lastIndexOf + 1), -1);
        }
        return -1;
    }

    public static String a(com.bytedance.sdk.openadsdk.i.e.a aVar, boolean z, boolean z2) {
        String a2;
        if (aVar == null) {
            if (e.c) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        } else if (!aVar.b()) {
            if (e.c) {
                Log.e("TAG_PROXY_Response", "response code: " + aVar.a());
            }
            return "response code: " + aVar.a();
        } else {
            String a3 = aVar.a("Content-Type", null);
            if (!c(a3)) {
                if (e.c) {
                    Log.e("TAG_PROXY_Response", "Content-Type: " + a3);
                }
                return "Content-Type: " + a3;
            }
            int a4 = a(aVar);
            if (a4 <= 0) {
                if (e.c) {
                    Log.e("TAG_PROXY_Response", "Content-Length: " + a4);
                }
                return "Content-Length: " + a4;
            } else if (z && ((a2 = aVar.a("Accept-Ranges", null)) == null || !a2.contains("bytes"))) {
                if (e.c) {
                    Log.e("TAG_PROXY_Response", "Accept-Ranges: " + a2);
                }
                return "Accept-Ranges: " + a2;
            } else if (z2 && aVar.d() == null) {
                if (e.c) {
                    Log.e("TAG_PROXY_Response", "response body null");
                }
                return "response body null";
            } else {
                return null;
            }
        }
    }

    public static boolean c(String str) {
        return str != null && (str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str));
    }

    public static boolean b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            if (b()) {
                com.bytedance.sdk.openadsdk.j.e.a().execute(runnable);
                if (e.c) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            runnable.run();
            if (e.c) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void b(Runnable runnable) {
        if (runnable != null) {
            if (b()) {
                runnable.run();
            } else {
                b.post(runnable);
            }
        }
    }

    public static List<i.b> a(List<i.b> list) {
        i.b bVar;
        i.b bVar2;
        if (list == null || list.size() == 0) {
            return null;
        }
        if (e.c) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null) {
                    Log.i("TAG_PROXY_PRE_FILTER", bVar2.f4853a + ": " + bVar2.f4853a);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (i.b bVar3 : list) {
            if ("Host".equals(bVar3.f4853a) || HTTP.CONN_KEEP_ALIVE.equals(bVar3.f4853a) || HTTP.CONN_DIRECTIVE.equals(bVar3.f4853a) || "Proxy-Connection".equals(bVar3.f4853a)) {
                arrayList.add(bVar3);
            }
        }
        list.removeAll(arrayList);
        if (e.c) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (list.get(i2) != null) {
                    Log.i("TAG_PROXY_POST_FILTER", bVar.f4853a + ": " + bVar.b);
                }
            }
            return list;
        }
        return list;
    }

    public static List<i.b> a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : entrySet) {
                arrayList.add(new i.b(entry.getKey(), entry.getValue()));
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static com.bytedance.sdk.openadsdk.i.b.a a(com.bytedance.sdk.openadsdk.i.e.a aVar, com.bytedance.sdk.openadsdk.i.b.c cVar, String str, int i) {
        String str2;
        com.bytedance.sdk.openadsdk.i.b.a a2 = cVar.a(str, i);
        if (a2 == null) {
            int a3 = a(aVar);
            String a4 = aVar.a("Content-Type", null);
            if (a3 > 0 && !TextUtils.isEmpty(a4)) {
                String str3 = "";
                String str4 = "";
                f g = aVar.g();
                if (g != null) {
                    str3 = g.b;
                    str4 = b(g.e);
                }
                String b2 = b(aVar.c());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("requestUrl", str3);
                    jSONObject.put("requestHeaders", str4);
                    jSONObject.put("responseHeaders", b2);
                    str2 = jSONObject.toString();
                } catch (Throwable th) {
                    str2 = "";
                }
                com.bytedance.sdk.openadsdk.i.b.a aVar2 = new com.bytedance.sdk.openadsdk.i.b.a(str, a4, a3, i, str2);
                cVar.a(aVar2);
                return aVar2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(List<i.b> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            i.b bVar = list.get(0);
            if (bVar != null) {
                sb.append(bVar.f4853a).append(": ").append(bVar.b).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey()).append(": ").append((Object) entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }

    public static String a(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iArr.length; i++) {
            if (i < iArr.length - 1) {
                stringBuffer.append(iArr[i] + ",");
            } else {
                stringBuffer.append(iArr[i]);
            }
        }
        return stringBuffer.toString();
    }
}
