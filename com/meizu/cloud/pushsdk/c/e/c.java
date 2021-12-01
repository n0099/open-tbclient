package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f60472b;

    /* renamed from: c  reason: collision with root package name */
    public b f60473c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f60474d;

    /* renamed from: e  reason: collision with root package name */
    public String f60475e;

    /* renamed from: f  reason: collision with root package name */
    public String f60476f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60477g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f60478h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60479i;

    /* renamed from: j  reason: collision with root package name */
    public long f60480j;

    /* renamed from: k  reason: collision with root package name */
    public int f60481k;
    public TimeUnit l;
    public final String a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes2.dex */
    public static class a {
        public final com.meizu.cloud.pushsdk.c.b.c a;

        /* renamed from: b  reason: collision with root package name */
        public final String f60482b;

        /* renamed from: c  reason: collision with root package name */
        public final String f60483c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f60484d;

        /* renamed from: e  reason: collision with root package name */
        public b f60485e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f60486f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f60487g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f60488h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f60489i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f60490j = 300;

        /* renamed from: k  reason: collision with root package name */
        public long f60491k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.f60482b = str;
            this.f60483c = str2;
            this.f60484d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f60485e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f60487g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f60486f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f60472b = aVar.a;
        this.f60476f = aVar.f60483c;
        this.f60477g = aVar.f60486f;
        this.f60475e = aVar.f60482b;
        this.f60473c = aVar.f60485e;
        this.f60478h = aVar.f60487g;
        this.f60479i = aVar.f60488h;
        this.f60480j = aVar.f60491k;
        int i2 = aVar.l;
        this.f60481k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f60479i) {
            this.f60474d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f60489i, aVar.f60490j, aVar.m, aVar.f60484d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f60487g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f60479i) {
            list.add(this.f60474d.a());
        }
        b bVar = this.f60473c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f60473c.a()));
            }
            if (!this.f60473c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f60473c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f60473c != null) {
            cVar.a(new HashMap(this.f60473c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f60472b.a(cVar, z);
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
        this.f60473c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f60472b;
    }
}
