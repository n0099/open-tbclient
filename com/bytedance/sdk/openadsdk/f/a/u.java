package com.bytedance.sdk.openadsdk.f.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.bytedance.sdk.openadsdk.f.a.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class u {

    /* renamed from: b  reason: collision with root package name */
    private final LruCache<String, c> f7144b;
    private final k.a c;
    private final String d;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, List<b>> f7143a = new ConcurrentHashMap();
    private volatile boolean e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        w f7149a = w.PUBLIC;

        /* renamed from: b  reason: collision with root package name */
        Set<String> f7150b = new HashSet();
        Set<String> c = new HashSet();

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public u(@NonNull String str, int i, @NonNull k.a aVar, @NonNull final Executor executor, @Nullable JSONObject jSONObject) {
        this.d = str;
        if (i <= 0) {
            this.f7144b = new LruCache<>(16);
        } else {
            this.f7144b = new LruCache<>(i);
        }
        this.c = aVar;
        if (jSONObject == null) {
            aVar.a(d(str), new k.a.InterfaceC1018a() { // from class: com.bytedance.sdk.openadsdk.f.a.u.1
            });
        } else {
            a(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        b(jSONObject);
        this.c.a(d(this.d), jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c a(String str, Set<String> set) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        c cVar = new c();
        if (authority == null || authority.isEmpty()) {
            cVar.f7149a = w.PUBLIC;
            return cVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith("." + str2)) {
                cVar.f7149a = w.PRIVATE;
                return cVar;
            }
            while (r4.hasNext()) {
            }
        }
        c cVar2 = this.f7144b.get(builder);
        if (cVar2 == null) {
            return a(builder);
        }
        return cVar2;
    }

    @WorkerThread
    private void b(JSONObject jSONObject) {
        this.f7143a.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.f7143a.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(c(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            i.b("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.e = true;
    }

    @NonNull
    private c a(String str) throws a {
        c cVar = new c();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String b2 = b(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || b2 == null) {
            cVar.f7149a = w.PUBLIC;
            return cVar;
        }
        List<b> c2 = c(b2);
        if (c2 == null) {
            return cVar;
        }
        for (b bVar : c2) {
            if (bVar.f7147a.matcher(str).find()) {
                if (bVar.f7148b.compareTo(cVar.f7149a) >= 0) {
                    cVar.f7149a = bVar.f7148b;
                }
                cVar.f7150b.addAll(bVar.c);
                cVar.c.addAll(bVar.d);
            }
        }
        this.f7144b.put(str, cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends IllegalStateException {
        a(String str) {
            super(str);
        }
    }

    private static String b(String str) {
        String[] split;
        int length;
        if (str != null && (length = (split = str.split("[.]")).length) >= 2) {
            return length != 2 ? split[length - 2] + "." + split[length - 1] : str;
        }
        return null;
    }

    private List<b> c(String str) throws a {
        if (!this.e) {
            throw new a("Permission config is outdated!");
        }
        return this.f7143a.get(str);
    }

    @WorkerThread
    private static b c(JSONObject jSONObject) throws JSONException {
        b bVar = new b();
        bVar.f7147a = Pattern.compile(jSONObject.getString("pattern"));
        bVar.f7148b = w.a(jSONObject.getString(TbEnum.ParamKey.GROUP));
        bVar.c = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                bVar.c.add(optJSONArray.getString(i));
            }
        }
        bVar.d = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                bVar.d.add(optJSONArray2.getString(i2));
            }
        }
        return bVar;
    }

    private static String d(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig." + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        Pattern f7147a;

        /* renamed from: b  reason: collision with root package name */
        w f7148b;
        List<String> c;
        List<String> d;

        private b() {
        }
    }
}
