package com.sdk.base.framework.a;

import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class k<T> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38778a = "com.sdk.base.framework.a.k";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f38779b = Boolean.valueOf(com.sdk.base.framework.c.f.f38809b);

    /* renamed from: d  reason: collision with root package name */
    public String f38781d;

    /* renamed from: e  reason: collision with root package name */
    public TreeMap<String, Object> f38782e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<File> f38783f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Object> f38784g;
    public com.sdk.base.framework.b.b<T> i;

    /* renamed from: c  reason: collision with root package name */
    public String f38780c = j.f38770a.toString();

    /* renamed from: h  reason: collision with root package name */
    public int f38785h = 0;

    public static String b(TreeMap<String, Object> treeMap) {
        StringBuilder sb;
        if (treeMap != null) {
            try {
                sb = new StringBuilder();
                for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null && com.sdk.base.framework.a.a.c.b(key).booleanValue()) {
                        String encode = URLEncoder.encode(value.toString(), "UTF-8");
                        boolean z = com.sdk.base.framework.c.f.f38812e;
                        sb.append(key);
                        sb.append("=");
                        sb.append(encode);
                        sb.append("&");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f38778a, e2.getMessage(), f38779b);
                throw new Exception("http请求参数出错");
            }
        } else {
            sb = null;
        }
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public final String a() {
        return this.f38780c;
    }

    public final void a(int i) {
        this.f38785h = i;
    }

    public final void a(com.sdk.base.framework.b.b<T> bVar) {
        this.i = bVar;
    }

    public final void a(String str) {
        if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
            this.f38780c = str;
        }
    }

    public final void a(ArrayList<File> arrayList) {
        this.f38783f = arrayList;
    }

    public final void a(HashMap<String, Object> hashMap) {
        this.f38784g = hashMap;
    }

    public final void a(TreeMap<String, Object> treeMap) {
        this.f38782e = treeMap;
    }

    public final ArrayList<File> b() {
        return this.f38783f;
    }

    public final void b(String str) {
        this.f38781d = str;
    }

    public final boolean c() {
        ArrayList<File> arrayList = this.f38783f;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    public final String d() {
        return this.f38781d;
    }

    public final TreeMap<String, Object> e() {
        return this.f38782e;
    }

    public final int f() {
        return this.f38785h;
    }

    public final com.sdk.base.framework.b.b<T> g() {
        return this.i;
    }

    public final HashMap<String, Object> h() {
        return this.f38784g;
    }
}
