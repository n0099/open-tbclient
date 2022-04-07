package com.kwad.sdk.c;

import android.content.Context;
import android.net.http.Headers;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.kwad.sdk.c.kwai.e;
import com.kwad.sdk.c.kwai.f;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public Context c;
    public Map<String, com.kwad.sdk.c.kwai.b> d = new HashMap();
    public final Map<f, e> a = new ConcurrentHashMap(16);
    public final Lock b = new ReentrantLock();

    /* loaded from: classes5.dex */
    public static class a implements com.kwad.sdk.c.a.c {
        @Override // com.kwad.sdk.c.a.c
        public boolean a(com.kwad.sdk.c.kwai.d dVar) {
            int i;
            String a = dVar.a();
            String a2 = com.kwad.sdk.utils.c.a(dVar.e());
            if (a2 != null && a2.length() > 10) {
                a2 = a2.substring(0, 10);
            }
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2) || !a2.equalsIgnoreCase(a)) {
                return false;
            }
            InputStream inputStream = null;
            try {
                try {
                    inputStream = q.b(dVar.e());
                    i = inputStream != null ? inputStream.available() : 0;
                } catch (IOException e) {
                    com.kwad.sdk.core.d.a.e("resource file is error ", e.getMessage());
                    q.b(inputStream);
                    i = 0;
                }
                return i != 0;
            } finally {
                q.b(inputStream);
            }
        }
    }

    public d(Context context) {
        this.c = context;
    }

    private WebResourceResponse a(InputStream inputStream, e eVar, com.kwad.sdk.c.kwai.b bVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap hashMap = new HashMap();
            hashMap.put("Access-Control-Allow-Origin", bVar.e.a);
            hashMap.put("Access-Control-Allow-Credentials", "true");
            hashMap.put("Timing-Allow-Origin", bVar.e.b);
            hashMap.put(Headers.CONTENT_TYPE, bVar.e.c);
            hashMap.put("Date", bVar.e.d);
            return new WebResourceResponse(bVar.d, "", bVar.a, "OK", hashMap, inputStream);
        }
        return new WebResourceResponse(eVar.c(), "UTF-8", inputStream);
    }

    private com.kwad.sdk.c.kwai.b a(com.kwad.sdk.c.kwai.d dVar, String str) {
        String d = com.kwad.sdk.c.b.a.d(this.c, dVar.f());
        com.kwad.sdk.c.kwai.b bVar = this.d.get(str);
        if (bVar != null) {
            return bVar;
        }
        try {
            return a(str, d);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a A[LOOP:0: B:26:0x004a->B:28:0x0050, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.kwad.sdk.c.kwai.b a(String str, String str2) {
        FileInputStream fileInputStream;
        String str3;
        JSONObject jSONObject;
        Iterator<String> keys;
        File file = new File(str2);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fileInputStream = null;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                try {
                    str3 = h.b(inputStreamReader);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    q.b(fileInputStream);
                    q.b(inputStreamReader);
                    str3 = null;
                }
                if (str3 != null) {
                    try {
                        jSONObject = new JSONObject(str3);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    keys = jSONObject != null ? jSONObject.keys() : null;
                    if (keys != null) {
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                            com.kwad.sdk.c.kwai.b bVar = new com.kwad.sdk.c.kwai.b();
                            bVar.parseJson(jSONObject2);
                            this.d.put(next, bVar);
                        }
                    }
                    return this.d.get(str);
                }
                jSONObject = null;
                if (jSONObject != null) {
                }
                if (keys != null) {
                }
                return this.d.get(str);
            } finally {
                q.b(fileInputStream);
                q.b(inputStreamReader);
            }
        }
        return null;
    }

    private void a(f fVar) {
        if (this.b.tryLock()) {
            this.a.remove(fVar);
            this.b.unlock();
        }
    }

    public WebResourceResponse a(String str, com.kwad.sdk.c.kwai.d dVar, String str2) {
        e d;
        f fVar = new f(str);
        if (this.a.get(fVar) != null) {
            d = this.a.get(fVar);
        } else {
            StringBuilder sb = new StringBuilder(com.kwad.sdk.c.b.a.c(this.c, dVar.f()));
            sb.append("/");
            sb.append(fVar.a());
            d = new e().a(dVar.a).b(str).e(dVar.a()).c(sb.toString()).d(URLConnection.getFileNameMap().getContentTypeFor(sb.toString()));
            this.a.put(new f(d.a()), d);
        }
        if (!com.kwad.sdk.c.b.c.a(d.c())) {
            a(fVar);
            return null;
        }
        InputStream b = q.b(d.b());
        if (b != null) {
            com.kwad.sdk.c.kwai.b a2 = a(dVar, fVar.a());
            if (a2 == null) {
                return null;
            }
            return a(b, d, a2);
        }
        com.kwad.sdk.core.d.a.a("HybridResourceManagerImpl", "getResource [" + str + "] inputStream is null");
        a(fVar);
        return null;
    }

    public String a(String str) {
        return new f(str).b();
    }
}
