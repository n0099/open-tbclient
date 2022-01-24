package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f58787b;

    /* renamed from: c  reason: collision with root package name */
    public b f58788c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f58789d;

    /* renamed from: e  reason: collision with root package name */
    public String f58790e;

    /* renamed from: f  reason: collision with root package name */
    public String f58791f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58792g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f58793h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58794i;

    /* renamed from: j  reason: collision with root package name */
    public long f58795j;
    public int k;
    public TimeUnit l;
    public final String a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes3.dex */
    public static class a {
        public final com.meizu.cloud.pushsdk.c.b.c a;

        /* renamed from: b  reason: collision with root package name */
        public final String f58796b;

        /* renamed from: c  reason: collision with root package name */
        public final String f58797c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f58798d;

        /* renamed from: e  reason: collision with root package name */
        public b f58799e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f58800f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f58801g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f58802h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f58803i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f58804j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.f58796b = str;
            this.f58797c = str2;
            this.f58798d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f58799e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f58801g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f58800f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f58787b = aVar.a;
        this.f58791f = aVar.f58797c;
        this.f58792g = aVar.f58800f;
        this.f58790e = aVar.f58796b;
        this.f58788c = aVar.f58799e;
        this.f58793h = aVar.f58801g;
        this.f58794i = aVar.f58802h;
        this.f58795j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f58794i) {
            this.f58789d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f58803i, aVar.f58804j, aVar.m, aVar.f58798d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f58801g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f58794i) {
            list.add(this.f58789d.a());
        }
        b bVar = this.f58788c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f58788c.a()));
            }
            if (!this.f58788c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f58788c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f58788c != null) {
            cVar.a(new HashMap(this.f58788c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f58787b.a(cVar, z);
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
        this.f58788c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f58787b;
    }
}
