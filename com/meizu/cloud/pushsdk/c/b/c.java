package com.meizu.cloud.pushsdk.c.b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidubce.AbstractBceClient;
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
/* loaded from: classes8.dex */
public abstract class c {
    public Context d;
    public Uri.Builder e;
    public f f;
    public d g;
    public com.meizu.cloud.pushsdk.c.b.a h;
    public h i;
    public SSLSocketFactory j;
    public HostnameVerifier k;
    public String l;
    public int m;
    public int n;
    public int o;
    public long p;
    public long q;
    public TimeUnit r;
    public com.meizu.cloud.pushsdk.b.c.a s;
    public int a = 88;
    public int b = 22;
    public final String u = c.class.getSimpleName();
    public final com.meizu.cloud.pushsdk.b.c.g c = com.meizu.cloud.pushsdk.b.c.g.a(AbstractBceClient.DEFAULT_CONTENT_TYPE);
    public AtomicBoolean t = new AtomicBoolean(false);

    /* loaded from: classes8.dex */
    public static class a {
        public final String a;
        public final Context b;
        public SSLSocketFactory m;
        public HostnameVerifier n;
        public Class<? extends c> p;
        public f c = null;
        public d d = d.POST;
        public com.meizu.cloud.pushsdk.c.b.a e = com.meizu.cloud.pushsdk.c.b.a.Single;
        public h f = h.HTTPS;
        public int g = 5;
        public int h = 250;
        public int i = 5;
        public long j = 40000;
        public long k = 40000;
        public TimeUnit l = TimeUnit.SECONDS;
        public com.meizu.cloud.pushsdk.b.c.a o = new com.meizu.cloud.pushsdk.b.c.e();

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
                String simpleName = a.class.getSimpleName();
                com.meizu.cloud.pushsdk.c.f.c.c(simpleName, "set new call " + aVar, new Object[0]);
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
        String str = this.u;
        com.meizu.cloud.pushsdk.c.f.c.b(str, "final SelfDescribingJson " + bVar, new Object[0]);
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
        StringBuilder sb;
        String str;
        String str2 = this.u;
        com.meizu.cloud.pushsdk.c.f.c.a(str2, "security " + this.i, new Object[0]);
        if (this.i == h.HTTP) {
            sb = new StringBuilder();
            str = "http://";
        } else {
            sb = new StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.l);
        this.e = Uri.parse(sb.toString()).buildUpon();
        if (this.g == d.GET) {
            this.e.appendPath("i");
        } else {
            this.e.appendEncodedPath("push_data_report/mobile");
        }
    }

    public int a(i iVar) {
        k kVar = null;
        try {
            com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Sending request: %s", iVar);
            kVar = this.s.a(iVar);
            return kVar.a();
        } catch (IOException e) {
            com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Request sending failed: %s", Log.getStackTraceString(e));
            return -1;
        } finally {
            a(kVar);
        }
    }

    public LinkedList<e> a(b bVar) {
        int i;
        int size = bVar.a().size();
        LinkedList<Long> b = bVar.b();
        LinkedList<e> linkedList = new LinkedList<>();
        if (this.g == d.GET) {
            for (int i2 = 0; i2 < size; i2++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b.get(i2));
                com.meizu.cloud.pushsdk.c.a.a aVar = bVar.a().get(i2);
                linkedList.add(new e(aVar.b() + ((long) this.b) > this.p, a(aVar), linkedList2));
            }
        } else {
            int i3 = 0;
            while (i3 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList = new ArrayList<>();
                long j = 0;
                int i4 = i3;
                while (i4 < this.h.a() + i3 && i4 < size) {
                    com.meizu.cloud.pushsdk.c.a.a aVar2 = bVar.a().get(i4);
                    ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList2 = arrayList;
                    long b2 = aVar2.b() + this.b;
                    int i5 = this.a;
                    int i6 = i3;
                    LinkedList linkedList4 = linkedList3;
                    if (i5 + b2 > this.q) {
                        ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList3 = new ArrayList<>();
                        LinkedList linkedList5 = new LinkedList();
                        arrayList3.add(aVar2);
                        linkedList5.add(b.get(i4));
                        linkedList.add(new e(true, a(arrayList3), linkedList5));
                        i = i6;
                        linkedList3 = linkedList4;
                        arrayList = arrayList2;
                    } else {
                        j += b2;
                        i = i6;
                        if (i5 + j + (arrayList2.size() - 1) > this.q) {
                            linkedList.add(new e(false, a(arrayList2), linkedList4));
                            ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList4 = new ArrayList<>();
                            linkedList3 = new LinkedList();
                            arrayList4.add(aVar2);
                            linkedList3.add(b.get(i4));
                            arrayList = arrayList4;
                            j = b2;
                        } else {
                            arrayList = arrayList2;
                            arrayList.add(aVar2);
                            linkedList4.add(b.get(i4));
                            linkedList3 = linkedList4;
                        }
                    }
                    i4++;
                    i3 = i;
                }
                int i7 = i3;
                LinkedList linkedList6 = linkedList3;
                if (!arrayList.isEmpty()) {
                    linkedList.add(new e(false, a(arrayList), linkedList6));
                }
                i3 = i7 + this.h.a();
            }
        }
        return linkedList;
    }

    public abstract void a();

    public void a(k kVar) {
        if (kVar != null) {
            try {
                if (kVar.b() != null) {
                    kVar.b().close();
                }
            } catch (Exception unused) {
                com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Unable to close source data", new Object[0]);
            }
        }
    }

    public abstract void a(com.meizu.cloud.pushsdk.c.a.a aVar, boolean z);

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public String b() {
        return this.e.clearQuery().build().toString();
    }
}
