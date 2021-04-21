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
    public com.meizu.cloud.pushsdk.c.b.c f38156b;

    /* renamed from: c  reason: collision with root package name */
    public b f38157c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f38158d;

    /* renamed from: e  reason: collision with root package name */
    public String f38159e;

    /* renamed from: f  reason: collision with root package name */
    public String f38160f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38161g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f38162h;
    public boolean i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f38155a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f38163a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38164b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38165c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f38166d;

        /* renamed from: e  reason: collision with root package name */
        public b f38167e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38168f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f38169g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38170h = false;
        public long i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f38163a = cVar;
            this.f38164b = str;
            this.f38165c = str2;
            this.f38166d = context;
            this.n = cls;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(b bVar) {
            this.f38167e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f38169g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f38168f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f38156b = aVar.f38163a;
        this.f38160f = aVar.f38165c;
        this.f38161g = aVar.f38168f;
        this.f38159e = aVar.f38164b;
        this.f38157c = aVar.f38167e;
        this.f38162h = aVar.f38169g;
        this.i = aVar.f38170h;
        this.j = aVar.k;
        int i = aVar.l;
        this.k = i < 2 ? 2 : i;
        this.l = aVar.m;
        if (this.i) {
            this.f38158d = new com.meizu.cloud.pushsdk.c.e.a(aVar.i, aVar.j, aVar.m, aVar.f38166d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f38169g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.i) {
            list.add(this.f38158d.a());
        }
        b bVar = this.f38157c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f38157c.a()));
            }
            if (!this.f38157c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f38157c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f38157c != null) {
            cVar.a(new HashMap(this.f38157c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f38156b.a(cVar, z);
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
        this.f38157c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f38156b;
    }
}
