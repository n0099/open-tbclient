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
    public com.meizu.cloud.pushsdk.c.b.c f67569b;

    /* renamed from: c  reason: collision with root package name */
    public b f67570c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f67571d;

    /* renamed from: e  reason: collision with root package name */
    public String f67572e;

    /* renamed from: f  reason: collision with root package name */
    public String f67573f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67574g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f67575h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67576i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f67568a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f67577a;

        /* renamed from: b  reason: collision with root package name */
        public final String f67578b;

        /* renamed from: c  reason: collision with root package name */
        public final String f67579c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f67580d;

        /* renamed from: e  reason: collision with root package name */
        public b f67581e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67582f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f67583g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f67584h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f67585i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f67577a = cVar;
            this.f67578b = str;
            this.f67579c = str2;
            this.f67580d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f67581e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f67583g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f67582f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f67569b = aVar.f67577a;
        this.f67573f = aVar.f67579c;
        this.f67574g = aVar.f67582f;
        this.f67572e = aVar.f67578b;
        this.f67570c = aVar.f67581e;
        this.f67575h = aVar.f67583g;
        this.f67576i = aVar.f67584h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f67576i) {
            this.f67571d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f67585i, aVar.j, aVar.m, aVar.f67580d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f67583g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f67576i) {
            list.add(this.f67571d.a());
        }
        b bVar = this.f67570c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f67570c.a()));
            }
            if (!this.f67570c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f67570c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f67570c != null) {
            cVar.a(new HashMap(this.f67570c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f67569b.a(cVar, z);
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
        this.f67570c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f67569b;
    }
}
