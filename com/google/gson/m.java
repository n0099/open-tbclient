package com.google.gson;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class m {
    private boolean g;
    private String h;
    private boolean k;
    private boolean l;
    private boolean n;
    private boolean o;

    /* renamed from: a  reason: collision with root package name */
    private com.google.gson.internal.k f1670a = com.google.gson.internal.k.f1655a;
    private LongSerializationPolicy b = LongSerializationPolicy.DEFAULT;
    private d c = FieldNamingPolicy.IDENTITY;
    private final Map d = new HashMap();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private int i = 2;
    private int j = 2;
    private boolean m = true;

    public e a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f);
        a(this.h, this.i, this.j, arrayList);
        return new e(this.f1670a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.l, this.b, arrayList);
    }

    private void a(String str, int i, int i2, List list) {
        a aVar;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a(str);
        } else if (i != 2 && i2 != 2) {
            aVar = new a(i, i2);
        } else {
            return;
        }
        list.add(x.a(com.google.gson.b.a.b(Date.class), aVar));
        list.add(x.a(com.google.gson.b.a.b(Timestamp.class), aVar));
        list.add(x.a(com.google.gson.b.a.b(java.sql.Date.class), aVar));
    }
}
