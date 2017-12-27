package com.meizu.cloud.pushsdk.b.b;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.meizu.cloud.pushsdk.a.d.i;
import com.meizu.cloud.pushsdk.a.d.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes2.dex */
public abstract class c {
    protected Context d;
    protected Uri.Builder e;
    protected f f;
    protected d g;
    protected com.meizu.cloud.pushsdk.b.b.a h;
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
    protected int a = 88;
    protected int b = 22;
    private final String t = c.class.getSimpleName();
    protected final com.meizu.cloud.pushsdk.a.d.g c = com.meizu.cloud.pushsdk.a.d.g.a("application/json; charset=utf-8");
    protected AtomicBoolean s = new AtomicBoolean(false);

    public abstract void a();

    public abstract void a(com.meizu.cloud.pushsdk.b.a.a aVar);

    /* loaded from: classes2.dex */
    public static class a {
        protected final String a;
        protected final Context b;
        protected f c = null;
        protected d d = d.POST;
        protected com.meizu.cloud.pushsdk.b.b.a e = com.meizu.cloud.pushsdk.b.b.a.Single;
        protected h f = h.HTTPS;
        protected int g = 5;
        protected int h = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected TimeUnit l = TimeUnit.SECONDS;
        protected SSLSocketFactory m;
        protected HostnameVerifier n;
        private Class<? extends c> o;

        public a(String str, Context context, Class<? extends c> cls) {
            this.a = str;
            this.b = context;
            this.o = cls;
        }

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.m = sSLSocketFactory;
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            this.n = hostnameVerifier;
            return this;
        }

        public a a(f fVar) {
            this.c = fVar;
            return this;
        }

        public a a(int i) {
            this.g = i;
            return this;
        }

        public a b(int i) {
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
        c();
        com.meizu.cloud.pushsdk.b.f.c.c(this.t, "Emitter created successfully!", new Object[0]);
    }

    private void c() {
        com.meizu.cloud.pushsdk.b.f.c.a(this.t, "security " + this.i, new Object[0]);
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
        try {
            com.meizu.cloud.pushsdk.b.f.c.b(this.t, "Sending request: %s", iVar);
            return new com.meizu.cloud.pushsdk.a.d.e(iVar).a().a();
        } catch (IOException e) {
            com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Request sending failed: %s", e.toString());
            return -1;
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
                com.meizu.cloud.pushsdk.b.a.a aVar = bVar.a().get(i);
                linkedList.add(new e(aVar.b() + ((long) this.b) > this.p, b(aVar), linkedList2));
            }
        } else {
            int i2 = 0;
            while (i2 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.b.a.a> arrayList = new ArrayList<>();
                LinkedList linkedList4 = linkedList3;
                long j = 0;
                for (int i3 = i2; i3 < this.h.a() + i2 && i3 < size; i3++) {
                    com.meizu.cloud.pushsdk.b.a.a aVar2 = bVar.a().get(i3);
                    long b2 = aVar2.b() + this.b;
                    if (this.a + b2 > this.q) {
                        ArrayList<com.meizu.cloud.pushsdk.b.a.a> arrayList2 = new ArrayList<>();
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

    private i b(com.meizu.cloud.pushsdk.b.a.a aVar) {
        a(aVar, "");
        this.e.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.e.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.e.build().toString()).a().c();
    }

    private i a(ArrayList<com.meizu.cloud.pushsdk.b.a.a> arrayList) {
        new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.meizu.cloud.pushsdk.b.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        String uri = this.e.build().toString();
        String stringBuffer2 = stringBuffer.toString();
        com.meizu.cloud.pushsdk.b.f.c.b(this.t, "post final String " + stringBuffer2, new Object[0]);
        return new i.a().a(uri).a(j.a(this.c, stringBuffer2)).c();
    }

    private void a(com.meizu.cloud.pushsdk.b.a.a aVar, String str) {
        if (str.equals("")) {
            str = com.meizu.cloud.pushsdk.b.f.e.a();
        }
        aVar.a("stm", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public String b() {
        return this.e.clearQuery().build().toString();
    }
}
