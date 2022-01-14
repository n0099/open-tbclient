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
    public com.meizu.cloud.pushsdk.c.b.c f58742b;

    /* renamed from: c  reason: collision with root package name */
    public b f58743c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f58744d;

    /* renamed from: e  reason: collision with root package name */
    public String f58745e;

    /* renamed from: f  reason: collision with root package name */
    public String f58746f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58747g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f58748h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58749i;

    /* renamed from: j  reason: collision with root package name */
    public long f58750j;
    public int k;
    public TimeUnit l;
    public final String a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes3.dex */
    public static class a {
        public final com.meizu.cloud.pushsdk.c.b.c a;

        /* renamed from: b  reason: collision with root package name */
        public final String f58751b;

        /* renamed from: c  reason: collision with root package name */
        public final String f58752c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f58753d;

        /* renamed from: e  reason: collision with root package name */
        public b f58754e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f58755f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f58756g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f58757h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f58758i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f58759j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.f58751b = str;
            this.f58752c = str2;
            this.f58753d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f58754e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f58756g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f58755f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f58742b = aVar.a;
        this.f58746f = aVar.f58752c;
        this.f58747g = aVar.f58755f;
        this.f58745e = aVar.f58751b;
        this.f58743c = aVar.f58754e;
        this.f58748h = aVar.f58756g;
        this.f58749i = aVar.f58757h;
        this.f58750j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f58749i) {
            this.f58744d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f58758i, aVar.f58759j, aVar.m, aVar.f58753d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f58756g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f58749i) {
            list.add(this.f58744d.a());
        }
        b bVar = this.f58743c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f58743c.a()));
            }
            if (!this.f58743c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f58743c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f58743c != null) {
            cVar.a(new HashMap(this.f58743c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f58742b.a(cVar, z);
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
        this.f58743c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f58742b;
    }
}
