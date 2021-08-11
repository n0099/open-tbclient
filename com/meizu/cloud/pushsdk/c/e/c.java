package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f74476b;

    /* renamed from: c  reason: collision with root package name */
    public b f74477c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f74478d;

    /* renamed from: e  reason: collision with root package name */
    public String f74479e;

    /* renamed from: f  reason: collision with root package name */
    public String f74480f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74481g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f74482h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74483i;

    /* renamed from: j  reason: collision with root package name */
    public long f74484j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f74475a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f74485a;

        /* renamed from: b  reason: collision with root package name */
        public final String f74486b;

        /* renamed from: c  reason: collision with root package name */
        public final String f74487c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f74488d;

        /* renamed from: e  reason: collision with root package name */
        public b f74489e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f74490f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f74491g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f74492h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f74493i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f74494j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f74485a = cVar;
            this.f74486b = str;
            this.f74487c = str2;
            this.f74488d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f74489e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f74491g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f74490f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f74476b = aVar.f74485a;
        this.f74480f = aVar.f74487c;
        this.f74481g = aVar.f74490f;
        this.f74479e = aVar.f74486b;
        this.f74477c = aVar.f74489e;
        this.f74482h = aVar.f74491g;
        this.f74483i = aVar.f74492h;
        this.f74484j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f74483i) {
            this.f74478d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f74493i, aVar.f74494j, aVar.m, aVar.f74488d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f74491g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f74483i) {
            list.add(this.f74478d.a());
        }
        b bVar = this.f74477c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f74477c.a()));
            }
            if (!this.f74477c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f74477c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f74477c != null) {
            cVar.a(new HashMap(this.f74477c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f74476b.a(cVar, z);
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
        this.f74477c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f74476b;
    }
}
