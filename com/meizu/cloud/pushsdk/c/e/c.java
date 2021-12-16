package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f61053b;

    /* renamed from: c  reason: collision with root package name */
    public b f61054c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f61055d;

    /* renamed from: e  reason: collision with root package name */
    public String f61056e;

    /* renamed from: f  reason: collision with root package name */
    public String f61057f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61058g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f61059h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61060i;

    /* renamed from: j  reason: collision with root package name */
    public long f61061j;

    /* renamed from: k  reason: collision with root package name */
    public int f61062k;
    public TimeUnit l;
    public final String a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes3.dex */
    public static class a {
        public final com.meizu.cloud.pushsdk.c.b.c a;

        /* renamed from: b  reason: collision with root package name */
        public final String f61063b;

        /* renamed from: c  reason: collision with root package name */
        public final String f61064c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f61065d;

        /* renamed from: e  reason: collision with root package name */
        public b f61066e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f61067f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f61068g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f61069h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f61070i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f61071j = 300;

        /* renamed from: k  reason: collision with root package name */
        public long f61072k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.f61063b = str;
            this.f61064c = str2;
            this.f61065d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f61066e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f61068g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f61067f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f61053b = aVar.a;
        this.f61057f = aVar.f61064c;
        this.f61058g = aVar.f61067f;
        this.f61056e = aVar.f61063b;
        this.f61054c = aVar.f61066e;
        this.f61059h = aVar.f61068g;
        this.f61060i = aVar.f61069h;
        this.f61061j = aVar.f61072k;
        int i2 = aVar.l;
        this.f61062k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f61060i) {
            this.f61055d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f61070i, aVar.f61071j, aVar.m, aVar.f61065d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f61068g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f61060i) {
            list.add(this.f61055d.a());
        }
        b bVar = this.f61054c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f61054c.a()));
            }
            if (!this.f61054c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f61054c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f61054c != null) {
            cVar.a(new HashMap(this.f61054c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f61053b.a(cVar, z);
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
        this.f61054c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f61053b;
    }
}
