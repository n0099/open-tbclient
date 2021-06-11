package com.sdk.base.framework.a;

import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class k<T> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39309a = "com.sdk.base.framework.a.k";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f39310b = Boolean.valueOf(com.sdk.base.framework.c.f.f39341b);

    /* renamed from: d  reason: collision with root package name */
    public String f39312d;

    /* renamed from: e  reason: collision with root package name */
    public TreeMap<String, Object> f39313e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<File> f39314f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Object> f39315g;

    /* renamed from: i  reason: collision with root package name */
    public com.sdk.base.framework.b.b<T> f39317i;

    /* renamed from: c  reason: collision with root package name */
    public String f39311c = j.f39300a.toString();

    /* renamed from: h  reason: collision with root package name */
    public int f39316h = 0;

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
                        boolean z = com.sdk.base.framework.c.f.f39344e;
                        sb.append(key);
                        sb.append("=");
                        sb.append(encode);
                        sb.append("&");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f39309a, e2.getMessage(), f39310b);
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
        return this.f39311c;
    }

    public final void a(int i2) {
        this.f39316h = i2;
    }

    public final void a(com.sdk.base.framework.b.b<T> bVar) {
        this.f39317i = bVar;
    }

    public final void a(String str) {
        if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
            this.f39311c = str;
        }
    }

    public final void a(ArrayList<File> arrayList) {
        this.f39314f = arrayList;
    }

    public final void a(HashMap<String, Object> hashMap) {
        this.f39315g = hashMap;
    }

    public final void a(TreeMap<String, Object> treeMap) {
        this.f39313e = treeMap;
    }

    public final ArrayList<File> b() {
        return this.f39314f;
    }

    public final void b(String str) {
        this.f39312d = str;
    }

    public final boolean c() {
        ArrayList<File> arrayList = this.f39314f;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    public final String d() {
        return this.f39312d;
    }

    public final TreeMap<String, Object> e() {
        return this.f39313e;
    }

    public final int f() {
        return this.f39316h;
    }

    public final com.sdk.base.framework.b.b<T> g() {
        return this.f39317i;
    }

    public final HashMap<String, Object> h() {
        return this.f39315g;
    }
}
