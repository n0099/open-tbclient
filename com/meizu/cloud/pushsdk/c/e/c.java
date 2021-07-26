package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f37630b;

    /* renamed from: c  reason: collision with root package name */
    public b f37631c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f37632d;

    /* renamed from: e  reason: collision with root package name */
    public String f37633e;

    /* renamed from: f  reason: collision with root package name */
    public String f37634f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37635g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f37636h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37637i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f37629a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f37638a;

        /* renamed from: b  reason: collision with root package name */
        public final String f37639b;

        /* renamed from: c  reason: collision with root package name */
        public final String f37640c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f37641d;

        /* renamed from: e  reason: collision with root package name */
        public b f37642e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37643f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f37644g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37645h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f37646i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f37638a = cVar;
            this.f37639b = str;
            this.f37640c = str2;
            this.f37641d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f37642e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f37644g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f37643f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f37630b = aVar.f37638a;
        this.f37634f = aVar.f37640c;
        this.f37635g = aVar.f37643f;
        this.f37633e = aVar.f37639b;
        this.f37631c = aVar.f37642e;
        this.f37636h = aVar.f37644g;
        this.f37637i = aVar.f37645h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f37637i) {
            this.f37632d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f37646i, aVar.j, aVar.m, aVar.f37641d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f37644g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f37637i) {
            list.add(this.f37632d.a());
        }
        b bVar = this.f37631c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f37631c.a()));
            }
            if (!this.f37631c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f37631c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f37631c != null) {
            cVar.a(new HashMap(this.f37631c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f37630b.a(cVar, z);
    }

    public void a() {
        if (this.m.get()) {
            b().a();
        }
    }

    public void a(com.meizu.cloud.pushsdk.c.c.b bVar, boolean z) {
        if (this.m.get()) {
            a(bVar.e(), bVar.a(), z);
        }
    }

    public void a(b bVar) {
        this.f37631c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f37630b;
    }
}
