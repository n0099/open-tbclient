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
    public com.meizu.cloud.pushsdk.c.b.c f74856b;

    /* renamed from: c  reason: collision with root package name */
    public b f74857c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f74858d;

    /* renamed from: e  reason: collision with root package name */
    public String f74859e;

    /* renamed from: f  reason: collision with root package name */
    public String f74860f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74861g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f74862h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74863i;

    /* renamed from: j  reason: collision with root package name */
    public long f74864j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f74855a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f74865a;

        /* renamed from: b  reason: collision with root package name */
        public final String f74866b;

        /* renamed from: c  reason: collision with root package name */
        public final String f74867c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f74868d;

        /* renamed from: e  reason: collision with root package name */
        public b f74869e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f74870f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f74871g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f74872h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f74873i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f74874j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f74865a = cVar;
            this.f74866b = str;
            this.f74867c = str2;
            this.f74868d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f74869e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f74871g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f74870f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f74856b = aVar.f74865a;
        this.f74860f = aVar.f74867c;
        this.f74861g = aVar.f74870f;
        this.f74859e = aVar.f74866b;
        this.f74857c = aVar.f74869e;
        this.f74862h = aVar.f74871g;
        this.f74863i = aVar.f74872h;
        this.f74864j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f74863i) {
            this.f74858d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f74873i, aVar.f74874j, aVar.m, aVar.f74868d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f74871g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f74863i) {
            list.add(this.f74858d.a());
        }
        b bVar = this.f74857c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f74857c.a()));
            }
            if (!this.f74857c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f74857c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f74857c != null) {
            cVar.a(new HashMap(this.f74857c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f74856b.a(cVar, z);
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
        this.f74857c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f74856b;
    }
}
