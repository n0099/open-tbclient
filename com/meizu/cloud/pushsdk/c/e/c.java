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
    public com.meizu.cloud.pushsdk.c.b.c f67570b;

    /* renamed from: c  reason: collision with root package name */
    public b f67571c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f67572d;

    /* renamed from: e  reason: collision with root package name */
    public String f67573e;

    /* renamed from: f  reason: collision with root package name */
    public String f67574f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67575g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f67576h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67577i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f67569a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f67578a;

        /* renamed from: b  reason: collision with root package name */
        public final String f67579b;

        /* renamed from: c  reason: collision with root package name */
        public final String f67580c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f67581d;

        /* renamed from: e  reason: collision with root package name */
        public b f67582e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67583f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f67584g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f67585h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f67586i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f67578a = cVar;
            this.f67579b = str;
            this.f67580c = str2;
            this.f67581d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f67582e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f67584g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f67583f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f67570b = aVar.f67578a;
        this.f67574f = aVar.f67580c;
        this.f67575g = aVar.f67583f;
        this.f67573e = aVar.f67579b;
        this.f67571c = aVar.f67582e;
        this.f67576h = aVar.f67584g;
        this.f67577i = aVar.f67585h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f67577i) {
            this.f67572d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f67586i, aVar.j, aVar.m, aVar.f67581d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f67584g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f67577i) {
            list.add(this.f67572d.a());
        }
        b bVar = this.f67571c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f67571c.a()));
            }
            if (!this.f67571c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f67571c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f67571c != null) {
            cVar.a(new HashMap(this.f67571c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f67570b.a(cVar, z);
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
        this.f67571c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f67570b;
    }
}
