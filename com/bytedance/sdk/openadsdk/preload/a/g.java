package com.bytedance.sdk.openadsdk.preload.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: h  reason: collision with root package name */
    public String f30740h;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.a.b.d f30733a = com.bytedance.sdk.openadsdk.preload.a.b.d.f30632a;

    /* renamed from: b  reason: collision with root package name */
    public u f30734b = u.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    public e f30735c = d.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Type, h<?>> f30736d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final List<w> f30737e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<w> f30738f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f30739g = false;

    /* renamed from: i  reason: collision with root package name */
    public int f30741i = 2;
    public int j = 2;
    public boolean k = false;
    public boolean l = false;
    public boolean m = true;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;

    public g a(Type type, Object obj) {
        boolean z = obj instanceof s;
        com.bytedance.sdk.openadsdk.preload.a.b.a.a(z || (obj instanceof k) || (obj instanceof h) || (obj instanceof v));
        if (obj instanceof h) {
            this.f30736d.put(type, (h) obj);
        }
        if (z || (obj instanceof k)) {
            this.f30737e.add(com.bytedance.sdk.openadsdk.preload.a.b.a.l.a(com.bytedance.sdk.openadsdk.preload.a.c.a.a(type), obj));
        }
        if (obj instanceof v) {
            this.f30737e.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(com.bytedance.sdk.openadsdk.preload.a.c.a.a(type), (v) obj));
        }
        return this;
    }

    public f a() {
        List<w> arrayList = new ArrayList<>(this.f30737e.size() + this.f30738f.size() + 3);
        arrayList.addAll(this.f30737e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f30738f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f30740h, this.f30741i, this.j, arrayList);
        return new f(this.f30733a, this.f30735c, this.f30736d, this.f30739g, this.k, this.o, this.m, this.n, this.p, this.l, this.f30734b, this.f30740h, this.f30741i, this.j, this.f30737e, this.f30738f, arrayList);
    }

    private void a(String str, int i2, int i3, List<w> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a(Date.class, str);
            aVar2 = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
        } else if (i2 == 2 || i3 == 2) {
            return;
        } else {
            a aVar4 = new a(Date.class, i2, i3);
            a aVar5 = new a(Timestamp.class, i2, i3);
            a aVar6 = new a(java.sql.Date.class, i2, i3);
            aVar = aVar4;
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Date.class, aVar));
        list.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Timestamp.class, aVar2));
        list.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(java.sql.Date.class, aVar3));
    }
}
