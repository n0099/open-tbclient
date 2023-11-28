package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.searchbox.player.model.YYOption;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
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
    public static final Map<String, com.kwad.sdk.core.webview.b.a.b> aDk = new ConcurrentHashMap();
    public static final Map<String, String> aDl = new ConcurrentHashMap();

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.h.a.b bVar, b.a aVar, boolean z) {
        com.kwad.sdk.core.webview.b.a.b bVar2;
        try {
            bVar2 = a(context, bVar, str, aVar);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        } else if (TextUtils.isEmpty(bVar2.aDs)) {
            b(z, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        } else if (!com.kwad.sdk.core.webview.b.c.c.eB(bVar2.aDo)) {
            b(z, "mimetype为: " + bVar2.aDo + "不在拦截范围的文件");
            aVar.msg = "mimetype为: " + bVar2.aDo + "不在拦截范围的文件";
            return null;
        } else {
            BufferedInputStream fJ = q.fJ(bVar2.aDs);
            if (fJ == null) {
                b(z, "getResource [" + str + "] inputStream is null");
                StringBuilder sb = new StringBuilder("inputStream is null,本地加载路径：");
                sb.append(bVar2.aDs);
                aVar.msg = sb.toString();
                return null;
            }
            return a(fJ, bVar2);
        }
    }

    public static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aDo;
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap hashMap = new HashMap();
            hashMap.put("Access-Control-Allow-Origin", bVar.aDr.aDm);
            hashMap.put("Access-Control-Allow-Credentials", YYOption.IsLive.VALUE_TRUE);
            hashMap.put("Timing-Allow-Origin", bVar.aDr.aDn);
            hashMap.put(Headers.CONTENT_TYPE, str);
            hashMap.put("Date", bVar.aDr.aDp);
            hashMap.put("union-cache ", "1");
            return new WebResourceResponse(bVar.aDo, "", bVar.status, bx.k, hashMap, inputStream);
        }
        return new WebResourceResponse(str, "UTF-8", inputStream);
    }

    public static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.h.a.b bVar, String str, b.a aVar) {
        InputStreamReader inputStreamReader;
        com.kwad.sdk.core.webview.b.a.b bVar2;
        FileInputStream fileInputStream = null;
        try {
            String eu = eu(bVar.aGS);
            if (!TextUtils.isEmpty(eu)) {
                bVar2 = et(aa(eu, str));
            } else {
                bVar2 = null;
            }
            if (bVar2 != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return bVar2;
            }
            String I = com.kwad.sdk.core.webview.b.c.a.I(context, bVar.aGT);
            if (I == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(I);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + I;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
                try {
                    String b = h.b(inputStreamReader);
                    if (TextUtils.isEmpty(b)) {
                        aVar.msg = "获取配置文件失败 mainfest文件不存在";
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(b);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        com.kwad.sdk.core.webview.b.a.b bVar3 = new com.kwad.sdk.core.webview.b.a.b();
                        bVar3.parseJson(jSONObject2);
                        String host = Uri.parse("https://" + next).getHost();
                        bVar3.aDt = host;
                        bVar3.aDs = com.kwad.sdk.core.webview.b.c.a.H(context, bVar.aGT) + "/" + next;
                        if (TextUtils.isEmpty(bVar3.aDo)) {
                            bVar3.aDo = URLConnection.getFileNameMap().getContentTypeFor(bVar3.aDs);
                        }
                        a(next, bVar3);
                        eu = host;
                    }
                    ab(bVar.aGS, eu);
                    com.kwad.sdk.core.webview.b.a.b et = et(aa(eu, str));
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return et;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    public static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aDk.put(String.valueOf(str.hashCode()), bVar);
    }

    public static String aa(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    public static void ab(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            aDl.put(str, str2);
        }
    }

    public static void b(boolean z, String str) {
        if (z) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    public static com.kwad.sdk.core.webview.b.a.b et(String str) {
        return aDk.get(String.valueOf(str.hashCode()));
    }

    public static String eu(String str) {
        return aDl.get(str);
    }
}
