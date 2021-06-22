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
    public com.meizu.cloud.pushsdk.c.b.c f38664b;

    /* renamed from: c  reason: collision with root package name */
    public b f38665c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f38666d;

    /* renamed from: e  reason: collision with root package name */
    public String f38667e;

    /* renamed from: f  reason: collision with root package name */
    public String f38668f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38669g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f38670h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38671i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f38663a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f38672a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38673b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38674c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f38675d;

        /* renamed from: e  reason: collision with root package name */
        public b f38676e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38677f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f38678g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38679h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f38680i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f38672a = cVar;
            this.f38673b = str;
            this.f38674c = str2;
            this.f38675d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f38676e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f38678g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f38677f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f38664b = aVar.f38672a;
        this.f38668f = aVar.f38674c;
        this.f38669g = aVar.f38677f;
        this.f38667e = aVar.f38673b;
        this.f38665c = aVar.f38676e;
        this.f38670h = aVar.f38678g;
        this.f38671i = aVar.f38679h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f38671i) {
            this.f38666d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f38680i, aVar.j, aVar.m, aVar.f38675d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f38678g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f38671i) {
            list.add(this.f38666d.a());
        }
        b bVar = this.f38665c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f38665c.a()));
            }
            if (!this.f38665c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f38665c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f38665c != null) {
            cVar.a(new HashMap(this.f38665c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f38664b.a(cVar, z);
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
        this.f38665c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f38664b;
    }
}
