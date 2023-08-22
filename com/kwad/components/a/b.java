package com.kwad.components.a;

import android.content.Context;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.model.YYOption;
import com.kwad.components.a.b.b;
import com.kwad.components.a.b.c;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.o;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static final Map<String, com.kwad.components.a.kwai.b> PQ = new ConcurrentHashMap();
    public static final Map<String, String> PR = new ConcurrentHashMap();

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.e.kwai.b bVar, b.a aVar, boolean z) {
        com.kwad.components.a.kwai.b bVar2;
        try {
            bVar2 = a(context, bVar, str);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            aVar.Qd = "获取配置文件失败" + Log.getStackTraceString(e);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z, "获取配置文件失败");
            aVar.Qd = "获取配置文件失败";
            return null;
        } else if (TextUtils.isEmpty(bVar2.PY)) {
            b(z, "getResource [" + str + "] getFilePath from url fail");
            aVar.Qd = "getFilePath from url fail";
            return null;
        } else if (!c.aX(bVar2.PU)) {
            b(z, "mimetype为: " + bVar2.PU + "不在拦截范围的文件");
            aVar.Qd = "mimetype为: " + bVar2.PU + "不在拦截范围的文件";
            return null;
        } else {
            BufferedInputStream dy = o.dy(bVar2.PY);
            if (dy == null) {
                b(z, "getResource [" + str + "] inputStream is null");
                StringBuilder sb = new StringBuilder("inputStream is null,本地加载路径：");
                sb.append(bVar2.PY);
                aVar.Qd = sb.toString();
                return null;
            }
            return a(dy, bVar2);
        }
    }

    public static WebResourceResponse a(InputStream inputStream, com.kwad.components.a.kwai.b bVar) {
        String str = bVar.PU;
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap hashMap = new HashMap();
            hashMap.put("Access-Control-Allow-Origin", bVar.PX.PS);
            hashMap.put("Access-Control-Allow-Credentials", YYOption.IsLive.VALUE_TRUE);
            hashMap.put("Timing-Allow-Origin", bVar.PX.PT);
            hashMap.put(Headers.CONTENT_TYPE, str);
            hashMap.put("Date", bVar.PX.PV);
            hashMap.put("union-cache ", "1");
            return new WebResourceResponse(bVar.PU, "", bVar.status, "OK", hashMap, inputStream);
        }
        return new WebResourceResponse(str, "UTF-8", inputStream);
    }

    public static com.kwad.components.a.kwai.b a(Context context, com.kwad.sdk.e.kwai.b bVar, String str) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String aQ = aQ(bVar.ait);
            com.kwad.components.a.kwai.b aP = !TextUtils.isEmpty(aQ) ? aP(o(aQ, str)) : null;
            if (aP != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return aP;
            }
            String k = com.kwad.components.a.b.a.k(context, bVar.aiu);
            if (k == null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(k);
            if (!file.exists()) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
            }
            try {
                String b = g.b(inputStreamReader);
                if (TextUtils.isEmpty(b)) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(b);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    com.kwad.components.a.kwai.b bVar2 = new com.kwad.components.a.kwai.b();
                    bVar2.parseJson(jSONObject2);
                    String host = Uri.parse("https://" + next).getHost();
                    bVar2.PZ = host;
                    bVar2.PY = com.kwad.components.a.b.a.j(context, bVar.aiu) + "/" + next;
                    if (TextUtils.isEmpty(bVar2.PU)) {
                        bVar2.PU = URLConnection.getFileNameMap().getContentTypeFor(bVar2.PY);
                    }
                    a(next, bVar2);
                    aQ = host;
                }
                p(bVar.ait, aQ);
                com.kwad.components.a.kwai.b aP2 = aP(o(aQ, str));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                return aP2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    public static void a(String str, com.kwad.components.a.kwai.b bVar) {
        PQ.put(String.valueOf(str.hashCode()), bVar);
    }

    public static com.kwad.components.a.kwai.b aP(String str) {
        return PQ.get(String.valueOf(str.hashCode()));
    }

    public static String aQ(String str) {
        return PR.get(str);
    }

    public static void b(boolean z, String str) {
        if (z) {
            return;
        }
        com.kwad.sdk.core.e.b.d("HybridResourceManager", str);
    }

    public static String o(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    public static void p(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        PR.put(str, str2);
    }
}
