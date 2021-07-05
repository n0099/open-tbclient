package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f40427b;

    /* renamed from: c  reason: collision with root package name */
    public b f40428c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f40429d;

    /* renamed from: e  reason: collision with root package name */
    public String f40430e;

    /* renamed from: f  reason: collision with root package name */
    public String f40431f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40432g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f40433h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40434i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f40426a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f40435a;

        /* renamed from: b  reason: collision with root package name */
        public final String f40436b;

        /* renamed from: c  reason: collision with root package name */
        public final String f40437c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f40438d;

        /* renamed from: e  reason: collision with root package name */
        public b f40439e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f40440f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f40441g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f40442h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f40443i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f40435a = cVar;
            this.f40436b = str;
            this.f40437c = str2;
            this.f40438d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f40439e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f40441g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f40440f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f40427b = aVar.f40435a;
        this.f40431f = aVar.f40437c;
        this.f40432g = aVar.f40440f;
        this.f40430e = aVar.f40436b;
        this.f40428c = aVar.f40439e;
        this.f40433h = aVar.f40441g;
        this.f40434i = aVar.f40442h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f40434i) {
            this.f40429d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f40443i, aVar.j, aVar.m, aVar.f40438d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f40441g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f40434i) {
            list.add(this.f40429d.a());
        }
        b bVar = this.f40428c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f40428c.a()));
            }
            if (!this.f40428c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f40428c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f40428c != null) {
            cVar.a(new HashMap(this.f40428c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f40427b.a(cVar, z);
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
        this.f40428c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f40427b;
    }
}
