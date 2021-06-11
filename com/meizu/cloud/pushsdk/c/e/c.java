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
    public com.meizu.cloud.pushsdk.c.b.c f38566b;

    /* renamed from: c  reason: collision with root package name */
    public b f38567c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f38568d;

    /* renamed from: e  reason: collision with root package name */
    public String f38569e;

    /* renamed from: f  reason: collision with root package name */
    public String f38570f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38571g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f38572h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38573i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f38565a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f38574a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38575b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38576c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f38577d;

        /* renamed from: e  reason: collision with root package name */
        public b f38578e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38579f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f38580g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38581h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f38582i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f38574a = cVar;
            this.f38575b = str;
            this.f38576c = str2;
            this.f38577d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f38578e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f38580g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f38579f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f38566b = aVar.f38574a;
        this.f38570f = aVar.f38576c;
        this.f38571g = aVar.f38579f;
        this.f38569e = aVar.f38575b;
        this.f38567c = aVar.f38578e;
        this.f38572h = aVar.f38580g;
        this.f38573i = aVar.f38581h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f38573i) {
            this.f38568d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f38582i, aVar.j, aVar.m, aVar.f38577d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f38580g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f38573i) {
            list.add(this.f38568d.a());
        }
        b bVar = this.f38567c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f38567c.a()));
            }
            if (!this.f38567c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f38567c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f38567c != null) {
            cVar.a(new HashMap(this.f38567c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f38566b.a(cVar, z);
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
        this.f38567c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f38566b;
    }
}
