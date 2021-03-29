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
    public static final String f38489a = "com.sdk.base.framework.a.k";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f38490b = Boolean.valueOf(com.sdk.base.framework.c.f.f38520b);

    /* renamed from: d  reason: collision with root package name */
    public String f38492d;

    /* renamed from: e  reason: collision with root package name */
    public TreeMap<String, Object> f38493e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<File> f38494f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Object> f38495g;
    public com.sdk.base.framework.b.b<T> i;

    /* renamed from: c  reason: collision with root package name */
    public String f38491c = j.f38481a.toString();

    /* renamed from: h  reason: collision with root package name */
    public int f38496h = 0;

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
                        boolean z = com.sdk.base.framework.c.f.f38523e;
                        sb.append(key);
                        sb.append("=");
                        sb.append(encode);
                        sb.append("&");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f38489a, e2.getMessage(), f38490b);
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
        return this.f38491c;
    }

    public final void a(int i) {
        this.f38496h = i;
    }

    public final void a(com.sdk.base.framework.b.b<T> bVar) {
        this.i = bVar;
    }

    public final void a(String str) {
        if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
            this.f38491c = str;
        }
    }

    public final void a(ArrayList<File> arrayList) {
        this.f38494f = arrayList;
    }

    public final void a(HashMap<String, Object> hashMap) {
        this.f38495g = hashMap;
    }

    public final void a(TreeMap<String, Object> treeMap) {
        this.f38493e = treeMap;
    }

    public final ArrayList<File> b() {
        return this.f38494f;
    }

    public final void b(String str) {
        this.f38492d = str;
    }

    public final boolean c() {
        ArrayList<File> arrayList = this.f38494f;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    public final String d() {
        return this.f38492d;
    }

    public final TreeMap<String, Object> e() {
        return this.f38493e;
    }

    public final int f() {
        return this.f38496h;
    }

    public final com.sdk.base.framework.b.b<T> g() {
        return this.i;
    }

    public final HashMap<String, Object> h() {
        return this.f38495g;
    }
}
