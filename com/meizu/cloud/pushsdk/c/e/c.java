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
    public com.meizu.cloud.pushsdk.c.b.c f75210b;

    /* renamed from: c  reason: collision with root package name */
    public b f75211c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f75212d;

    /* renamed from: e  reason: collision with root package name */
    public String f75213e;

    /* renamed from: f  reason: collision with root package name */
    public String f75214f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f75215g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f75216h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f75217i;

    /* renamed from: j  reason: collision with root package name */
    public long f75218j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f75209a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f75219a;

        /* renamed from: b  reason: collision with root package name */
        public final String f75220b;

        /* renamed from: c  reason: collision with root package name */
        public final String f75221c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f75222d;

        /* renamed from: e  reason: collision with root package name */
        public b f75223e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f75224f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f75225g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f75226h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f75227i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f75228j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f75219a = cVar;
            this.f75220b = str;
            this.f75221c = str2;
            this.f75222d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f75223e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f75225g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f75224f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f75210b = aVar.f75219a;
        this.f75214f = aVar.f75221c;
        this.f75215g = aVar.f75224f;
        this.f75213e = aVar.f75220b;
        this.f75211c = aVar.f75223e;
        this.f75216h = aVar.f75225g;
        this.f75217i = aVar.f75226h;
        this.f75218j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f75217i) {
            this.f75212d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f75227i, aVar.f75228j, aVar.m, aVar.f75222d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f75225g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f75217i) {
            list.add(this.f75212d.a());
        }
        b bVar = this.f75211c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f75211c.a()));
            }
            if (!this.f75211c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f75211c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f75211c != null) {
            cVar.a(new HashMap(this.f75211c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f75210b.a(cVar, z);
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
        this.f75211c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f75210b;
    }
}
