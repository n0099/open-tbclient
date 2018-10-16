package com.meizu.cloud.pushsdk.pushtracer.d;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.pushtracer.utils.LogLevel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class c {
    private static final String n = c.class.getSimpleName();
    protected com.meizu.cloud.pushsdk.pushtracer.emitter.b b;
    protected b c;
    protected com.meizu.cloud.pushsdk.pushtracer.d.a d;
    protected String e;
    protected String f;
    protected boolean g;
    protected LogLevel h;
    protected boolean i;
    protected long j;
    protected int k;
    protected TimeUnit l;
    protected final String a = PushManager.TAG;
    protected AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes3.dex */
    public static class a {
        protected final com.meizu.cloud.pushsdk.pushtracer.emitter.b a;
        protected final String b;
        protected final String c;
        protected final Context d;
        protected b e = null;
        protected boolean f = false;
        protected LogLevel g = LogLevel.OFF;
        protected boolean h = false;
        protected long i = 600;
        protected long j = 300;
        protected long k = 15;
        protected int l = 10;
        protected TimeUnit m = TimeUnit.SECONDS;
        private Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.pushtracer.emitter.b bVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = bVar;
            this.b = str;
            this.c = str2;
            this.d = context;
            this.n = cls;
        }

        public a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f = bool.booleanValue();
            return this;
        }

        public a a(LogLevel logLevel) {
            this.g = logLevel;
            return this;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }
    }

    public c(a aVar) {
        this.b = aVar.a;
        this.f = aVar.c;
        this.g = aVar.f;
        this.e = aVar.b;
        this.c = aVar.e;
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.k;
        this.k = aVar.l >= 2 ? aVar.l : 2;
        this.l = aVar.m;
        if (this.i) {
            this.d = new com.meizu.cloud.pushsdk.pushtracer.d.a(aVar.i, aVar.j, aVar.m, aVar.d);
        }
        com.meizu.cloud.pushsdk.pushtracer.utils.b.a(aVar.g);
        com.meizu.cloud.pushsdk.pushtracer.utils.b.c(n, "Tracker created successfully.", new Object[0]);
    }

    private void a(com.meizu.cloud.pushsdk.pushtracer.a.c cVar, List<com.meizu.cloud.pushsdk.pushtracer.a.b> list) {
        if (this.c != null) {
            cVar.a(new HashMap(this.c.c()));
        }
        cVar.a("extra", a(list).a());
        com.meizu.cloud.pushsdk.pushtracer.utils.b.c(n, "Adding new payload to event storage: %s", cVar);
        this.b.a(cVar);
    }

    private com.meizu.cloud.pushsdk.pushtracer.a.b a(List<com.meizu.cloud.pushsdk.pushtracer.a.b> list) {
        if (this.i) {
            list.add(this.d.a());
        }
        if (this.c != null) {
            if (!this.c.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.pushtracer.a.b(NgWebView.APP_GEO_PATH, this.c.a()));
            }
            if (!this.c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.pushtracer.a.b("mobileinfo", this.c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.pushtracer.a.b bVar : list) {
            linkedList.add(bVar.a());
        }
        return new com.meizu.cloud.pushsdk.pushtracer.a.b("push_extra_info", linkedList);
    }

    public void a(com.meizu.cloud.pushsdk.pushtracer.b.b bVar) {
        if (this.m.get()) {
            a(bVar.e(), bVar.a());
        }
    }

    public void a() {
        if (this.m.get()) {
            b().a();
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public com.meizu.cloud.pushsdk.pushtracer.emitter.b b() {
        return this.b;
    }
}
