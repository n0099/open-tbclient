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
    public static final String f38873a = "com.sdk.base.framework.a.k";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f38874b = Boolean.valueOf(com.sdk.base.framework.c.f.f38904b);

    /* renamed from: d  reason: collision with root package name */
    public String f38876d;

    /* renamed from: e  reason: collision with root package name */
    public TreeMap<String, Object> f38877e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<File> f38878f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Object> f38879g;
    public com.sdk.base.framework.b.b<T> i;

    /* renamed from: c  reason: collision with root package name */
    public String f38875c = j.f38865a.toString();

    /* renamed from: h  reason: collision with root package name */
    public int f38880h = 0;

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
                        boolean z = com.sdk.base.framework.c.f.f38907e;
                        sb.append(key);
                        sb.append("=");
                        sb.append(encode);
                        sb.append("&");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f38873a, e2.getMessage(), f38874b);
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
        return this.f38875c;
    }

    public final void a(int i) {
        this.f38880h = i;
    }

    public final void a(com.sdk.base.framework.b.b<T> bVar) {
        this.i = bVar;
    }

    public final void a(String str) {
        if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
            this.f38875c = str;
        }
    }

    public final void a(ArrayList<File> arrayList) {
        this.f38878f = arrayList;
    }

    public final void a(HashMap<String, Object> hashMap) {
        this.f38879g = hashMap;
    }

    public final void a(TreeMap<String, Object> treeMap) {
        this.f38877e = treeMap;
    }

    public final ArrayList<File> b() {
        return this.f38878f;
    }

    public final void b(String str) {
        this.f38876d = str;
    }

    public final boolean c() {
        ArrayList<File> arrayList = this.f38878f;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    public final String d() {
        return this.f38876d;
    }

    public final TreeMap<String, Object> e() {
        return this.f38877e;
    }

    public final int f() {
        return this.f38880h;
    }

    public final com.sdk.base.framework.b.b<T> g() {
        return this.i;
    }

    public final HashMap<String, Object> h() {
        return this.f38879g;
    }
}
