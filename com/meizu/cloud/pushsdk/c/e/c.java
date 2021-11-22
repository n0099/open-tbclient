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
    public com.meizu.cloud.pushsdk.c.b.c f68482b;

    /* renamed from: c  reason: collision with root package name */
    public b f68483c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f68484d;

    /* renamed from: e  reason: collision with root package name */
    public String f68485e;

    /* renamed from: f  reason: collision with root package name */
    public String f68486f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68487g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f68488h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68489i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f68481a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f68490a;

        /* renamed from: b  reason: collision with root package name */
        public final String f68491b;

        /* renamed from: c  reason: collision with root package name */
        public final String f68492c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f68493d;

        /* renamed from: e  reason: collision with root package name */
        public b f68494e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68495f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f68496g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f68497h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f68498i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f68490a = cVar;
            this.f68491b = str;
            this.f68492c = str2;
            this.f68493d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f68494e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f68496g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f68495f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f68482b = aVar.f68490a;
        this.f68486f = aVar.f68492c;
        this.f68487g = aVar.f68495f;
        this.f68485e = aVar.f68491b;
        this.f68483c = aVar.f68494e;
        this.f68488h = aVar.f68496g;
        this.f68489i = aVar.f68497h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f68489i) {
            this.f68484d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f68498i, aVar.j, aVar.m, aVar.f68493d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f68496g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f68489i) {
            list.add(this.f68484d.a());
        }
        b bVar = this.f68483c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f68483c.a()));
            }
            if (!this.f68483c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f68483c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f68483c != null) {
            cVar.a(new HashMap(this.f68483c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f68482b.a(cVar, z);
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
        this.f68483c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f68482b;
    }
}
