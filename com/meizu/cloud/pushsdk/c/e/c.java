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
    public com.meizu.cloud.pushsdk.c.b.c f75175b;

    /* renamed from: c  reason: collision with root package name */
    public b f75176c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f75177d;

    /* renamed from: e  reason: collision with root package name */
    public String f75178e;

    /* renamed from: f  reason: collision with root package name */
    public String f75179f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f75180g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f75181h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f75182i;

    /* renamed from: j  reason: collision with root package name */
    public long f75183j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f75174a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f75184a;

        /* renamed from: b  reason: collision with root package name */
        public final String f75185b;

        /* renamed from: c  reason: collision with root package name */
        public final String f75186c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f75187d;

        /* renamed from: e  reason: collision with root package name */
        public b f75188e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f75189f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f75190g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f75191h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f75192i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f75193j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f75184a = cVar;
            this.f75185b = str;
            this.f75186c = str2;
            this.f75187d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f75188e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f75190g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f75189f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f75175b = aVar.f75184a;
        this.f75179f = aVar.f75186c;
        this.f75180g = aVar.f75189f;
        this.f75178e = aVar.f75185b;
        this.f75176c = aVar.f75188e;
        this.f75181h = aVar.f75190g;
        this.f75182i = aVar.f75191h;
        this.f75183j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f75182i) {
            this.f75177d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f75192i, aVar.f75193j, aVar.m, aVar.f75187d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f75190g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f75182i) {
            list.add(this.f75177d.a());
        }
        b bVar = this.f75176c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f75176c.a()));
            }
            if (!this.f75176c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f75176c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f75176c != null) {
            cVar.a(new HashMap(this.f75176c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f75175b.a(cVar, z);
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
        this.f75176c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f75175b;
    }
}
