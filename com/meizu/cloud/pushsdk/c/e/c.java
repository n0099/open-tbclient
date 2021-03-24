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
    public com.meizu.cloud.pushsdk.c.b.c f37771b;

    /* renamed from: c  reason: collision with root package name */
    public b f37772c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f37773d;

    /* renamed from: e  reason: collision with root package name */
    public String f37774e;

    /* renamed from: f  reason: collision with root package name */
    public String f37775f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37776g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f37777h;
    public boolean i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f37770a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f37778a;

        /* renamed from: b  reason: collision with root package name */
        public final String f37779b;

        /* renamed from: c  reason: collision with root package name */
        public final String f37780c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f37781d;

        /* renamed from: e  reason: collision with root package name */
        public b f37782e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37783f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f37784g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37785h = false;
        public long i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f37778a = cVar;
            this.f37779b = str;
            this.f37780c = str2;
            this.f37781d = context;
            this.n = cls;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(b bVar) {
            this.f37782e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f37784g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f37783f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f37771b = aVar.f37778a;
        this.f37775f = aVar.f37780c;
        this.f37776g = aVar.f37783f;
        this.f37774e = aVar.f37779b;
        this.f37772c = aVar.f37782e;
        this.f37777h = aVar.f37784g;
        this.i = aVar.f37785h;
        this.j = aVar.k;
        int i = aVar.l;
        this.k = i < 2 ? 2 : i;
        this.l = aVar.m;
        if (this.i) {
            this.f37773d = new com.meizu.cloud.pushsdk.c.e.a(aVar.i, aVar.j, aVar.m, aVar.f37781d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f37784g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.i) {
            list.add(this.f37773d.a());
        }
        b bVar = this.f37772c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f37772c.a()));
            }
            if (!this.f37772c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f37772c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f37772c != null) {
            cVar.a(new HashMap(this.f37772c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f37771b.a(cVar, z);
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
        this.f37772c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f37771b;
    }
}
