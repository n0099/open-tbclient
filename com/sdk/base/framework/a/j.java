package com.sdk.base.framework.a;

import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class j<T> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12805a = j.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private static final Boolean f12806b = Boolean.valueOf(com.sdk.base.framework.c.f.f12821b);
    private String d;
    private TreeMap<String, Object> e;
    private ArrayList<File> f;
    private HashMap<String, Object> g;
    private com.sdk.base.framework.b.b<T> i;
    private com.sdk.base.framework.f.h.g j;
    private String c = i.f12803a.toString();
    private int h = 0;

    public static String b(TreeMap<String, Object> treeMap) {
        StringBuilder sb;
        if (treeMap != null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null && com.sdk.base.framework.a.a.c.b(key).booleanValue()) {
                        String encode = URLEncoder.encode(value.toString(), "UTF-8");
                        boolean z = com.sdk.base.framework.c.f.e;
                        sb2.append(key).append("=").append(encode).append(ETAG.ITEM_SEPARATOR);
                    }
                }
                sb2.deleteCharAt(sb2.length() - 1);
                sb = sb2;
            } catch (Exception e) {
                com.sdk.base.framework.a.a.c.b(f12805a, e.getMessage(), f12806b);
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
        return this.c;
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void a(com.sdk.base.framework.b.b<T> bVar) {
        this.i = bVar;
    }

    public final void a(com.sdk.base.framework.f.h.g gVar) {
        this.j = gVar;
    }

    public final void a(String str) {
        if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
            this.c = str;
        }
    }

    public final void a(ArrayList<File> arrayList) {
        this.f = arrayList;
    }

    public final void a(HashMap<String, Object> hashMap) {
        this.g = hashMap;
    }

    public final void a(TreeMap<String, Object> treeMap) {
        this.e = treeMap;
    }

    public final com.sdk.base.framework.f.h.g b() {
        return this.j;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final ArrayList<File> c() {
        return this.f;
    }

    public final boolean d() {
        return (this.f == null || this.f.size() == 0) ? false : true;
    }

    public final String e() {
        return this.d;
    }

    public final TreeMap<String, Object> f() {
        return this.e;
    }

    public final int g() {
        return this.h;
    }

    public final com.sdk.base.framework.b.b<T> h() {
        return this.i;
    }

    public final HashMap<String, Object> i() {
        return this.g;
    }
}
