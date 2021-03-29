package com.bytedance.sdk.openadsdk.f.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
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
public class u {

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, c> f29361b;

    /* renamed from: c  reason: collision with root package name */
    public final k.a f29362c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29363d;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<b>> f29360a = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f29364e = false;

    /* loaded from: classes6.dex */
    public static class a extends IllegalStateException {
        public a(String str) {
            super(str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Pattern f29367a;

        /* renamed from: b  reason: collision with root package name */
        public w f29368b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f29369c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f29370d;

        public b() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public w f29371a = w.PUBLIC;

        /* renamed from: b  reason: collision with root package name */
        public Set<String> f29372b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        public Set<String> f29373c = new HashSet();
    }

    @WorkerThread
    public u(@NonNull String str, int i, @NonNull k.a aVar, @NonNull final Executor executor, @Nullable JSONObject jSONObject) {
        this.f29363d = str;
        if (i <= 0) {
            this.f29361b = new LruCache<>(16);
        } else {
            this.f29361b = new LruCache<>(i);
        }
        this.f29362c = aVar;
        if (jSONObject == null) {
            aVar.a(d(str), new k.a.InterfaceC0320a() { // from class: com.bytedance.sdk.openadsdk.f.a.u.1
            });
        } else {
            a(jSONObject);
        }
    }

    @WorkerThread
    private void b(JSONObject jSONObject) {
        this.f29360a.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.f29360a.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(c(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e2) {
            i.b("Parse configurations failed, response: " + jSONObject.toString(), e2);
        }
        this.f29364e = true;
    }

    private List<b> c(String str) throws a {
        if (this.f29364e) {
            return this.f29360a.get(str);
        }
        throw new a("Permission config is outdated!");
    }

    public static String d(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig." + str;
    }

    public void a(JSONObject jSONObject) {
        b(jSONObject);
        this.f29362c.a(d(this.f29363d), jSONObject.toString());
    }

    @NonNull
    public c a(String str, Set<String> set) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        c cVar = new c();
        if (authority != null && !authority.isEmpty()) {
            for (String str2 : set) {
                if (!authority.equals(str2)) {
                    if (authority.endsWith("." + str2)) {
                    }
                }
                cVar.f29371a = w.PRIVATE;
                return cVar;
            }
            c cVar2 = this.f29361b.get(builder);
            return cVar2 != null ? cVar2 : a(builder);
        }
        cVar.f29371a = w.PUBLIC;
        return cVar;
    }

    @WorkerThread
    public static b c(JSONObject jSONObject) throws JSONException {
        b bVar = new b();
        bVar.f29367a = Pattern.compile(jSONObject.getString("pattern"));
        bVar.f29368b = w.a(jSONObject.getString("group"));
        bVar.f29369c = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                bVar.f29369c.add(optJSONArray.getString(i));
            }
        }
        bVar.f29370d = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                bVar.f29370d.add(optJSONArray2.getString(i2));
            }
        }
        return bVar;
    }

    public static String b(String str) {
        String[] split;
        int length;
        if (str != null && (length = (split = str.split("[.]")).length) >= 2) {
            if (length == 2) {
                return str;
            }
            return split[length - 2] + "." + split[length - 1];
        }
        return null;
    }

    @NonNull
    private c a(String str) throws a {
        c cVar = new c();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String b2 = b(authority);
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && b2 != null) {
            List<b> c2 = c(b2);
            if (c2 == null) {
                return cVar;
            }
            for (b bVar : c2) {
                if (bVar.f29367a.matcher(str).find()) {
                    if (bVar.f29368b.compareTo(cVar.f29371a) >= 0) {
                        cVar.f29371a = bVar.f29368b;
                    }
                    cVar.f29372b.addAll(bVar.f29369c);
                    cVar.f29373c.addAll(bVar.f29370d);
                }
            }
            this.f29361b.put(str, cVar);
            return cVar;
        }
        cVar.f29371a = w.PUBLIC;
        return cVar;
    }
}
