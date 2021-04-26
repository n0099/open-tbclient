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
    public static final String f36456a = "com.sdk.base.framework.a.k";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f36457b = Boolean.valueOf(com.sdk.base.framework.c.f.f36488b);

    /* renamed from: d  reason: collision with root package name */
    public String f36459d;

    /* renamed from: e  reason: collision with root package name */
    public TreeMap<String, Object> f36460e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<File> f36461f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Object> f36462g;

    /* renamed from: i  reason: collision with root package name */
    public com.sdk.base.framework.b.b<T> f36464i;

    /* renamed from: c  reason: collision with root package name */
    public String f36458c = j.f36447a.toString();

    /* renamed from: h  reason: collision with root package name */
    public int f36463h = 0;

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
                        boolean z = com.sdk.base.framework.c.f.f36491e;
                        sb.append(key);
                        sb.append("=");
                        sb.append(encode);
                        sb.append("&");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f36456a, e2.getMessage(), f36457b);
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
        return this.f36458c;
    }

    public final void a(int i2) {
        this.f36463h = i2;
    }

    public final void a(com.sdk.base.framework.b.b<T> bVar) {
        this.f36464i = bVar;
    }

    public final void a(String str) {
        if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
            this.f36458c = str;
        }
    }

    public final void a(ArrayList<File> arrayList) {
        this.f36461f = arrayList;
    }

    public final void a(HashMap<String, Object> hashMap) {
        this.f36462g = hashMap;
    }

    public final void a(TreeMap<String, Object> treeMap) {
        this.f36460e = treeMap;
    }

    public final ArrayList<File> b() {
        return this.f36461f;
    }

    public final void b(String str) {
        this.f36459d = str;
    }

    public final boolean c() {
        ArrayList<File> arrayList = this.f36461f;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    public final String d() {
        return this.f36459d;
    }

    public final TreeMap<String, Object> e() {
        return this.f36460e;
    }

    public final int f() {
        return this.f36463h;
    }

    public final com.sdk.base.framework.b.b<T> g() {
        return this.f36464i;
    }

    public final HashMap<String, Object> h() {
        return this.f36462g;
    }
}
