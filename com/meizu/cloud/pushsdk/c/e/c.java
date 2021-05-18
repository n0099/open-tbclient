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
    public com.meizu.cloud.pushsdk.c.b.c f34958b;

    /* renamed from: c  reason: collision with root package name */
    public b f34959c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f34960d;

    /* renamed from: e  reason: collision with root package name */
    public String f34961e;

    /* renamed from: f  reason: collision with root package name */
    public String f34962f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34963g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f34964h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34965i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f34957a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f34966a;

        /* renamed from: b  reason: collision with root package name */
        public final String f34967b;

        /* renamed from: c  reason: collision with root package name */
        public final String f34968c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f34969d;

        /* renamed from: e  reason: collision with root package name */
        public b f34970e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34971f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f34972g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f34973h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f34974i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f34966a = cVar;
            this.f34967b = str;
            this.f34968c = str2;
            this.f34969d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f34970e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f34972g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f34971f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f34958b = aVar.f34966a;
        this.f34962f = aVar.f34968c;
        this.f34963g = aVar.f34971f;
        this.f34961e = aVar.f34967b;
        this.f34959c = aVar.f34970e;
        this.f34964h = aVar.f34972g;
        this.f34965i = aVar.f34973h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f34965i) {
            this.f34960d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f34974i, aVar.j, aVar.m, aVar.f34969d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f34972g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f34965i) {
            list.add(this.f34960d.a());
        }
        b bVar = this.f34959c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f34959c.a()));
            }
            if (!this.f34959c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f34959c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f34959c != null) {
            cVar.a(new HashMap(this.f34959c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f34958b.a(cVar, z);
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
        this.f34959c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f34958b;
    }
}
