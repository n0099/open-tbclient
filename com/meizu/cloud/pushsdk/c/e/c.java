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
    public com.meizu.cloud.pushsdk.c.b.c f35713b;

    /* renamed from: c  reason: collision with root package name */
    public b f35714c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f35715d;

    /* renamed from: e  reason: collision with root package name */
    public String f35716e;

    /* renamed from: f  reason: collision with root package name */
    public String f35717f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35718g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f35719h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35720i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f35712a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f35721a;

        /* renamed from: b  reason: collision with root package name */
        public final String f35722b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35723c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f35724d;

        /* renamed from: e  reason: collision with root package name */
        public b f35725e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f35726f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f35727g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f35728h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f35729i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f35721a = cVar;
            this.f35722b = str;
            this.f35723c = str2;
            this.f35724d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f35725e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f35727g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f35726f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f35713b = aVar.f35721a;
        this.f35717f = aVar.f35723c;
        this.f35718g = aVar.f35726f;
        this.f35716e = aVar.f35722b;
        this.f35714c = aVar.f35725e;
        this.f35719h = aVar.f35727g;
        this.f35720i = aVar.f35728h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f35720i) {
            this.f35715d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f35729i, aVar.j, aVar.m, aVar.f35724d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f35727g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f35720i) {
            list.add(this.f35715d.a());
        }
        b bVar = this.f35714c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f35714c.a()));
            }
            if (!this.f35714c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f35714c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f35714c != null) {
            cVar.a(new HashMap(this.f35714c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f35713b.a(cVar, z);
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
        this.f35714c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f35713b;
    }
}
