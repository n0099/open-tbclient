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
    public com.meizu.cloud.pushsdk.c.b.c f74676b;

    /* renamed from: c  reason: collision with root package name */
    public b f74677c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f74678d;

    /* renamed from: e  reason: collision with root package name */
    public String f74679e;

    /* renamed from: f  reason: collision with root package name */
    public String f74680f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74681g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f74682h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74683i;

    /* renamed from: j  reason: collision with root package name */
    public long f74684j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f74675a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f74685a;

        /* renamed from: b  reason: collision with root package name */
        public final String f74686b;

        /* renamed from: c  reason: collision with root package name */
        public final String f74687c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f74688d;

        /* renamed from: e  reason: collision with root package name */
        public b f74689e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f74690f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f74691g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f74692h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f74693i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f74694j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f74685a = cVar;
            this.f74686b = str;
            this.f74687c = str2;
            this.f74688d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f74689e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f74691g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f74690f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f74676b = aVar.f74685a;
        this.f74680f = aVar.f74687c;
        this.f74681g = aVar.f74690f;
        this.f74679e = aVar.f74686b;
        this.f74677c = aVar.f74689e;
        this.f74682h = aVar.f74691g;
        this.f74683i = aVar.f74692h;
        this.f74684j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f74683i) {
            this.f74678d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f74693i, aVar.f74694j, aVar.m, aVar.f74688d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f74691g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f74683i) {
            list.add(this.f74678d.a());
        }
        b bVar = this.f74677c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f74677c.a()));
            }
            if (!this.f74677c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f74677c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f74677c != null) {
            cVar.a(new HashMap(this.f74677c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f74676b.a(cVar, z);
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
        this.f74677c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f74676b;
    }
}
