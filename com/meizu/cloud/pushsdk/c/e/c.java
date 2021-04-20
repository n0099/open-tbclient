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
    public com.meizu.cloud.pushsdk.c.b.c f38061b;

    /* renamed from: c  reason: collision with root package name */
    public b f38062c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f38063d;

    /* renamed from: e  reason: collision with root package name */
    public String f38064e;

    /* renamed from: f  reason: collision with root package name */
    public String f38065f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38066g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f38067h;
    public boolean i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f38060a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f38068a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38069b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38070c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f38071d;

        /* renamed from: e  reason: collision with root package name */
        public b f38072e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38073f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f38074g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38075h = false;
        public long i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f38068a = cVar;
            this.f38069b = str;
            this.f38070c = str2;
            this.f38071d = context;
            this.n = cls;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(b bVar) {
            this.f38072e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f38074g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f38073f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f38061b = aVar.f38068a;
        this.f38065f = aVar.f38070c;
        this.f38066g = aVar.f38073f;
        this.f38064e = aVar.f38069b;
        this.f38062c = aVar.f38072e;
        this.f38067h = aVar.f38074g;
        this.i = aVar.f38075h;
        this.j = aVar.k;
        int i = aVar.l;
        this.k = i < 2 ? 2 : i;
        this.l = aVar.m;
        if (this.i) {
            this.f38063d = new com.meizu.cloud.pushsdk.c.e.a(aVar.i, aVar.j, aVar.m, aVar.f38071d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f38074g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.i) {
            list.add(this.f38063d.a());
        }
        b bVar = this.f38062c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f38062c.a()));
            }
            if (!this.f38062c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f38062c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f38062c != null) {
            cVar.a(new HashMap(this.f38062c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f38061b.a(cVar, z);
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
        this.f38062c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f38061b;
    }
}
