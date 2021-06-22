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
    public static final String f39407a = "com.sdk.base.framework.a.k";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f39408b = Boolean.valueOf(com.sdk.base.framework.c.f.f39439b);

    /* renamed from: d  reason: collision with root package name */
    public String f39410d;

    /* renamed from: e  reason: collision with root package name */
    public TreeMap<String, Object> f39411e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<File> f39412f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Object> f39413g;

    /* renamed from: i  reason: collision with root package name */
    public com.sdk.base.framework.b.b<T> f39415i;

    /* renamed from: c  reason: collision with root package name */
    public String f39409c = j.f39398a.toString();

    /* renamed from: h  reason: collision with root package name */
    public int f39414h = 0;

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
                        boolean z = com.sdk.base.framework.c.f.f39442e;
                        sb.append(key);
                        sb.append("=");
                        sb.append(encode);
                        sb.append("&");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f39407a, e2.getMessage(), f39408b);
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
        return this.f39409c;
    }

    public final void a(int i2) {
        this.f39414h = i2;
    }

    public final void a(com.sdk.base.framework.b.b<T> bVar) {
        this.f39415i = bVar;
    }

    public final void a(String str) {
        if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
            this.f39409c = str;
        }
    }

    public final void a(ArrayList<File> arrayList) {
        this.f39412f = arrayList;
    }

    public final void a(HashMap<String, Object> hashMap) {
        this.f39413g = hashMap;
    }

    public final void a(TreeMap<String, Object> treeMap) {
        this.f39411e = treeMap;
    }

    public final ArrayList<File> b() {
        return this.f39412f;
    }

    public final void b(String str) {
        this.f39410d = str;
    }

    public final boolean c() {
        ArrayList<File> arrayList = this.f39412f;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    public final String d() {
        return this.f39410d;
    }

    public final TreeMap<String, Object> e() {
        return this.f39411e;
    }

    public final int f() {
        return this.f39414h;
    }

    public final com.sdk.base.framework.b.b<T> g() {
        return this.f39415i;
    }

    public final HashMap<String, Object> h() {
        return this.f39413g;
    }
}
