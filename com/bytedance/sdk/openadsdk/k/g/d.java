package com.bytedance.sdk.openadsdk.k.g;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.searchbox.bddownload.core.Util;
import com.bytedance.sdk.openadsdk.k.e;
import com.bytedance.sdk.openadsdk.k.e.f;
import com.bytedance.sdk.openadsdk.k.i;
import com.bytedance.sdk.openadsdk.l.g;
import com.sina.weibo.sdk.utils.FileUtils;
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
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f30299b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f30298a = Charset.forName("UTF-8");

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int b(String str) {
        return a(str, 0);
    }

    public static boolean c(String str) {
        return str != null && (str.startsWith(FileUtils.VIDEO_FILE_START) || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str));
    }

    public static void a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b(int i2, int i3) {
        if (i2 >= 0 && i3 > 0) {
            return i2 + "-" + i3;
        } else if (i2 > 0) {
            return i2 + "-";
        } else if (i2 >= 0 || i3 <= 0) {
            return null;
        } else {
            return "-" + i3;
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean a(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith("https://"));
    }

    public static String b(List<i.b> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            i.b bVar = list.get(0);
            if (bVar != null) {
                sb.append(bVar.f30312a);
                sb.append(": ");
                sb.append(bVar.f30313b);
                sb.append(Part.CRLF);
            }
        }
        return sb.toString();
    }

    public static int a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static String a(com.bytedance.sdk.openadsdk.k.e.a aVar, int i2) {
        int a2;
        if (aVar == null || !aVar.b()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.e().toUpperCase());
        sb.append(' ');
        sb.append(aVar.a());
        sb.append(' ');
        sb.append(aVar.f());
        sb.append(Part.CRLF);
        if (e.f30227c) {
            Log.i("TAG_PROXY_headers", aVar.e().toUpperCase() + " " + aVar.a() + " " + aVar.f());
        }
        List<i.b> a3 = a(aVar.c());
        boolean z = true;
        if (a3 != null) {
            int size = a3.size();
            for (int i3 = 0; i3 < size; i3++) {
                i.b bVar = a3.get(i3);
                if (bVar != null) {
                    String str = bVar.f30312a;
                    String str2 = bVar.f30313b;
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    sb.append(Part.CRLF);
                    if ("Content-Range".equalsIgnoreCase(str) || (Util.ACCEPT_RANGES.equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        }
        if (z && (a2 = a(aVar)) > 0) {
            sb.append("Content-Range: bytes ");
            sb.append(Math.max(i2, 0));
            sb.append("-");
            sb.append(a2 - 1);
            sb.append("/");
            sb.append(a2);
            sb.append(Part.CRLF);
        }
        sb.append("Connection: close");
        sb.append(Part.CRLF);
        sb.append(Part.CRLF);
        String sb2 = sb.toString();
        if (e.f30227c) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey());
            sb.append(": ");
            sb.append((Object) entry.getValue());
            sb.append(Part.CRLF);
        }
        return sb.toString();
    }

    public static String a(int i2, int i3) {
        String b2 = b(i2, i3);
        if (b2 == null) {
            return null;
        }
        return "bytes=" + b2;
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

    public static String a(com.bytedance.sdk.openadsdk.k.b.a aVar, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 <= 0) {
            sb.append("HTTP/1.1 200 OK");
            sb.append(Part.CRLF);
        } else {
            sb.append("HTTP/1.1 206 Partial Content");
            sb.append(Part.CRLF);
        }
        sb.append("Accept-Ranges: bytes");
        sb.append(Part.CRLF);
        sb.append(Part.CONTENT_TYPE);
        sb.append(aVar.f30176b);
        sb.append(Part.CRLF);
        if (i2 <= 0) {
            sb.append("Content-Length: ");
            sb.append(aVar.f30177c);
            sb.append(Part.CRLF);
        } else {
            sb.append("Content-Range: bytes ");
            sb.append(i2);
            sb.append("-");
            sb.append(aVar.f30177c - 1);
            sb.append("/");
            sb.append(aVar.f30177c);
            sb.append(Part.CRLF);
            sb.append("Content-Length: ");
            sb.append(aVar.f30177c - i2);
            sb.append(Part.CRLF);
        }
        sb.append("Connection: close");
        sb.append(Part.CRLF);
        sb.append(Part.CRLF);
        String sb2 = sb.toString();
        if (e.f30227c) {
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
            if (!file.exists() || (listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.k.g.d.1

                /* renamed from: a  reason: collision with root package name */
                public Pattern f30300a = Pattern.compile("^cpu[0-9]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return this.f30300a.matcher(str).matches();
                }
            })) == null) {
                return 1;
            }
            return Math.max(listFiles.length, 1);
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static int a(com.bytedance.sdk.openadsdk.k.e.a aVar) {
        int lastIndexOf;
        if (aVar == null) {
            return -1;
        }
        if (aVar.a() == 200) {
            return a(aVar.a("Content-Length", null), -1);
        }
        if (aVar.a() == 206) {
            String a2 = aVar.a("Content-Range", null);
            if (!TextUtils.isEmpty(a2) && (lastIndexOf = a2.lastIndexOf("/")) >= 0 && lastIndexOf < a2.length() - 1) {
                return a(a2.substring(lastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String a(com.bytedance.sdk.openadsdk.k.e.a aVar, boolean z, boolean z2) {
        String a2;
        if (aVar == null) {
            if (e.f30227c) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        } else if (!aVar.b()) {
            if (e.f30227c) {
                Log.e("TAG_PROXY_Response", "response code: " + aVar.a());
            }
            return "response code: " + aVar.a();
        } else {
            String a3 = aVar.a("Content-Type", null);
            if (!c(a3)) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_Response", Part.CONTENT_TYPE + a3);
                }
                return Part.CONTENT_TYPE + a3;
            }
            int a4 = a(aVar);
            if (a4 <= 0) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_Response", "Content-Length: " + a4);
                }
                return "Content-Length: " + a4;
            } else if (z && ((a2 = aVar.a(Util.ACCEPT_RANGES, null)) == null || !a2.contains("bytes"))) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_Response", "Accept-Ranges: " + a2);
                }
                return "Accept-Ranges: " + a2;
            } else if (z2 && aVar.d() == null) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_Response", "response body null");
                }
                return "response body null";
            } else {
                return null;
            }
        }
    }

    public static void a(g gVar) {
        if (gVar != null) {
            if (b()) {
                com.bytedance.sdk.openadsdk.l.e.a(gVar);
                if (e.f30227c) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            gVar.run();
            if (e.f30227c) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            if (b()) {
                runnable.run();
            } else {
                f30299b.post(runnable);
            }
        }
    }

    public static List<i.b> a(List<i.b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (e.f30227c) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                i.b bVar = list.get(i2);
                if (bVar != null) {
                    Log.i("TAG_PROXY_PRE_FILTER", bVar.f30312a + ": " + bVar.f30312a);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (i.b bVar2 : list) {
            if ("Host".equals(bVar2.f30312a) || HTTP.CONN_KEEP_ALIVE.equals(bVar2.f30312a) || HTTP.CONN_DIRECTIVE.equals(bVar2.f30312a) || "Proxy-Connection".equals(bVar2.f30312a)) {
                arrayList.add(bVar2);
            }
        }
        list.removeAll(arrayList);
        if (e.f30227c) {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                i.b bVar3 = list.get(i3);
                if (bVar3 != null) {
                    Log.i("TAG_PROXY_POST_FILTER", bVar3.f30312a + ": " + bVar3.f30313b);
                }
            }
        }
        return list;
    }

    public static List<i.b> a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : entrySet) {
                    arrayList.add(new i.b(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static com.bytedance.sdk.openadsdk.k.b.a a(com.bytedance.sdk.openadsdk.k.e.a aVar, com.bytedance.sdk.openadsdk.k.b.c cVar, String str, int i2) {
        String str2;
        String str3;
        String str4;
        com.bytedance.sdk.openadsdk.k.b.a a2 = cVar.a(str, i2);
        if (a2 == null) {
            int a3 = a(aVar);
            String a4 = aVar.a("Content-Type", null);
            if (a3 <= 0 || TextUtils.isEmpty(a4)) {
                return a2;
            }
            f g2 = aVar.g();
            if (g2 != null) {
                str3 = g2.f30239b;
                str2 = b(g2.f30242e);
            } else {
                str2 = "";
                str3 = str2;
            }
            String b2 = b(aVar.c());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("requestUrl", str3);
                jSONObject.put("requestHeaders", str2);
                jSONObject.put("responseHeaders", b2);
                str4 = jSONObject.toString();
            } catch (Throwable unused) {
                str4 = "";
            }
            com.bytedance.sdk.openadsdk.k.b.a aVar2 = new com.bytedance.sdk.openadsdk.k.b.a(str, a4, a3, i2, str4);
            cVar.a(aVar2);
            return aVar2;
        }
        return a2;
    }

    public static String a(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 < iArr.length - 1) {
                stringBuffer.append(iArr[i2] + ",");
            } else {
                stringBuffer.append(iArr[i2]);
            }
        }
        return stringBuffer.toString();
    }
}
