package com.meizu.cloud.pushsdk.c.b;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import com.meizu.cloud.pushsdk.b.c.i;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.c.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes3.dex */
public abstract class c {
    protected Context d;
    protected Uri.Builder e;
    protected f f;
    protected d g;
    protected com.meizu.cloud.pushsdk.c.b.a h;
    protected h i;
    protected SSLSocketFactory j;
    protected HostnameVerifier k;
    protected String l;
    protected int m;
    protected int n;
    protected int o;
    protected long p;
    protected long q;
    protected TimeUnit r;
    protected com.meizu.cloud.pushsdk.b.c.a s;
    protected int a = 88;
    protected int b = 22;
    private final String u = c.class.getSimpleName();
    protected final com.meizu.cloud.pushsdk.b.c.g c = com.meizu.cloud.pushsdk.b.c.g.a("application/json; charset=utf-8");
    protected AtomicBoolean t = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public static class a {
        protected final String a;
        protected final Context b;
        protected SSLSocketFactory m;
        protected HostnameVerifier n;
        private Class<? extends c> p;
        protected f c = null;
        protected d d = d.POST;
        protected com.meizu.cloud.pushsdk.c.b.a e = com.meizu.cloud.pushsdk.c.b.a.Single;
        protected h f = h.HTTPS;
        protected int g = 5;
        protected int h = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected TimeUnit l = TimeUnit.SECONDS;
        protected com.meizu.cloud.pushsdk.b.c.a o = new com.meizu.cloud.pushsdk.b.c.e();

        public a(String str, Context context, Class<? extends c> cls) {
            this.a = str;
            this.b = context;
            this.p = cls;
        }

        public a a(int i) {
            this.g = i;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.b.c.a aVar) {
            if (aVar != null) {
                this.o = aVar;
                com.meizu.cloud.pushsdk.c.f.c.c(a.class.getSimpleName(), "set new call " + aVar, new Object[0]);
            }
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.b.a aVar) {
            this.e = aVar;
            return this;
        }

        public a a(f fVar) {
            this.c = fVar;
            return this;
        }

        public a b(int i) {
            this.h = i;
            return this;
        }

        public a c(int i) {
            this.i = i;
            return this;
        }
    }

    public c(a aVar) {
        this.g = aVar.d;
        this.f = aVar.c;
        this.d = aVar.b;
        this.h = aVar.e;
        this.i = aVar.f;
        this.j = aVar.m;
        this.k = aVar.n;
        this.m = aVar.g;
        this.n = aVar.i;
        this.o = aVar.h;
        this.p = aVar.j;
        this.q = aVar.k;
        this.l = aVar.a;
        this.r = aVar.l;
        this.s = aVar.o;
        c();
        com.meizu.cloud.pushsdk.c.f.c.c(this.u, "Emitter created successfully!", new Object[0]);
    }

    private i a(com.meizu.cloud.pushsdk.c.a.a aVar) {
        a(aVar, "");
        this.e.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.e.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.e.build().toString()).a().c();
    }

    private i a(ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.meizu.cloud.pushsdk.c.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.meizu.cloud.pushsdk.c.a.a next = it.next();
            stringBuffer.append(next.toString());
            arrayList2.add(next.a());
        }
        com.meizu.cloud.pushsdk.c.a.b bVar = new com.meizu.cloud.pushsdk.c.a.b("push_group_data", arrayList2);
        com.meizu.cloud.pushsdk.c.f.c.b(this.u, "final SelfDescribingJson " + bVar, new Object[0]);
        String uri = this.e.build().toString();
        return new i.a().a(uri).a(j.a(this.c, bVar.toString())).c();
    }

    private void a(com.meizu.cloud.pushsdk.c.a.a aVar, String str) {
        if (str.equals("")) {
            str = com.meizu.cloud.pushsdk.c.f.e.a();
        }
        aVar.a("stm", str);
    }

    private void c() {
        com.meizu.cloud.pushsdk.c.f.c.a(this.u, "security " + this.i, new Object[0]);
        if (this.i == h.HTTP) {
            this.e = Uri.parse("http://" + this.l).buildUpon();
        } else {
            this.e = Uri.parse("https://" + this.l).buildUpon();
        }
        if (this.g == d.GET) {
            this.e.appendPath("i");
        } else {
            this.e.appendEncodedPath("push_data_report/mobile");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(i iVar) {
        k kVar = null;
        try {
            try {
                com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Sending request: %s", iVar);
                kVar = this.s.a(iVar);
                int a2 = kVar.a();
                a(kVar);
                return a2;
            } catch (IOException e) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Request sending failed: %s", Log.getStackTraceString(e));
                a(kVar);
                return -1;
            }
        } catch (Throwable th) {
            a(kVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinkedList<e> a(b bVar) {
        int size = bVar.a().size();
        LinkedList<Long> b = bVar.b();
        LinkedList<e> linkedList = new LinkedList<>();
        if (this.g == d.GET) {
            for (int i = 0; i < size; i++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b.get(i));
                com.meizu.cloud.pushsdk.c.a.a aVar = bVar.a().get(i);
                linkedList.add(new e(aVar.b() + ((long) this.b) > this.p, a(aVar), linkedList2));
            }
        } else {
            int i2 = 0;
            while (i2 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList = new ArrayList<>();
                LinkedList linkedList4 = linkedList3;
                long j = 0;
                for (int i3 = i2; i3 < this.h.a() + i2 && i3 < size; i3++) {
                    com.meizu.cloud.pushsdk.c.a.a aVar2 = bVar.a().get(i3);
                    long b2 = aVar2.b() + this.b;
                    if (this.a + b2 > this.q) {
                        ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList2 = new ArrayList<>();
                        LinkedList linkedList5 = new LinkedList();
                        arrayList2.add(aVar2);
                        linkedList5.add(b.get(i3));
                        linkedList.add(new e(true, a(arrayList2), linkedList5));
                    } else if (j + b2 + this.a + (arrayList.size() - 1) > this.q) {
                        linkedList.add(new e(false, a(arrayList), linkedList4));
                        arrayList = new ArrayList<>();
                        linkedList4 = new LinkedList();
                        arrayList.add(aVar2);
                        linkedList4.add(b.get(i3));
                        j = b2;
                    } else {
                        j += b2;
                        arrayList.add(aVar2);
                        linkedList4.add(b.get(i3));
                    }
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new e(false, a(arrayList), linkedList4));
                }
                i2 += this.h.a();
            }
        }
        return linkedList;
    }

    public abstract void a();

    protected void a(k kVar) {
        if (kVar != null) {
            try {
                if (kVar.b() != null) {
                    kVar.b().close();
                }
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Unable to close source data", new Object[0]);
            }
        }
    }

    public abstract void a(com.meizu.cloud.pushsdk.c.a.a aVar, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public String b() {
        return this.e.clearQuery().build().toString();
    }
}
