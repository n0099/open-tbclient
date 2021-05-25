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
    public com.meizu.cloud.pushsdk.c.b.c f34887b;

    /* renamed from: c  reason: collision with root package name */
    public b f34888c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f34889d;

    /* renamed from: e  reason: collision with root package name */
    public String f34890e;

    /* renamed from: f  reason: collision with root package name */
    public String f34891f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34892g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f34893h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34894i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f34886a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f34895a;

        /* renamed from: b  reason: collision with root package name */
        public final String f34896b;

        /* renamed from: c  reason: collision with root package name */
        public final String f34897c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f34898d;

        /* renamed from: e  reason: collision with root package name */
        public b f34899e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34900f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f34901g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f34902h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f34903i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f34895a = cVar;
            this.f34896b = str;
            this.f34897c = str2;
            this.f34898d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f34899e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f34901g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f34900f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f34887b = aVar.f34895a;
        this.f34891f = aVar.f34897c;
        this.f34892g = aVar.f34900f;
        this.f34890e = aVar.f34896b;
        this.f34888c = aVar.f34899e;
        this.f34893h = aVar.f34901g;
        this.f34894i = aVar.f34902h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f34894i) {
            this.f34889d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f34903i, aVar.j, aVar.m, aVar.f34898d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f34901g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f34894i) {
            list.add(this.f34889d.a());
        }
        b bVar = this.f34888c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f34888c.a()));
            }
            if (!this.f34888c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f34888c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f34888c != null) {
            cVar.a(new HashMap(this.f34888c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f34887b.a(cVar, z);
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
        this.f34888c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f34887b;
    }
}
