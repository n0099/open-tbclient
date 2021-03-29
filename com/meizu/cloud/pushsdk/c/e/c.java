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
    public com.meizu.cloud.pushsdk.c.b.c f37772b;

    /* renamed from: c  reason: collision with root package name */
    public b f37773c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f37774d;

    /* renamed from: e  reason: collision with root package name */
    public String f37775e;

    /* renamed from: f  reason: collision with root package name */
    public String f37776f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37777g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f37778h;
    public boolean i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f37771a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f37779a;

        /* renamed from: b  reason: collision with root package name */
        public final String f37780b;

        /* renamed from: c  reason: collision with root package name */
        public final String f37781c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f37782d;

        /* renamed from: e  reason: collision with root package name */
        public b f37783e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37784f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f37785g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37786h = false;
        public long i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f37779a = cVar;
            this.f37780b = str;
            this.f37781c = str2;
            this.f37782d = context;
            this.n = cls;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(b bVar) {
            this.f37783e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f37785g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f37784f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f37772b = aVar.f37779a;
        this.f37776f = aVar.f37781c;
        this.f37777g = aVar.f37784f;
        this.f37775e = aVar.f37780b;
        this.f37773c = aVar.f37783e;
        this.f37778h = aVar.f37785g;
        this.i = aVar.f37786h;
        this.j = aVar.k;
        int i = aVar.l;
        this.k = i < 2 ? 2 : i;
        this.l = aVar.m;
        if (this.i) {
            this.f37774d = new com.meizu.cloud.pushsdk.c.e.a(aVar.i, aVar.j, aVar.m, aVar.f37782d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f37785g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.i) {
            list.add(this.f37774d.a());
        }
        b bVar = this.f37773c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f37773c.a()));
            }
            if (!this.f37773c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f37773c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f37773c != null) {
            cVar.a(new HashMap(this.f37773c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f37772b.a(cVar, z);
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
        this.f37773c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f37772b;
    }
}
