package com.meizu.cloud.pushsdk.c.b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.pass.face.platform.common.ConstantHelper;
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
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: d  reason: collision with root package name */
    public Context f58721d;

    /* renamed from: e  reason: collision with root package name */
    public Uri.Builder f58722e;

    /* renamed from: f  reason: collision with root package name */
    public f f58723f;

    /* renamed from: g  reason: collision with root package name */
    public d f58724g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.a f58725h;

    /* renamed from: i  reason: collision with root package name */
    public h f58726i;

    /* renamed from: j  reason: collision with root package name */
    public SSLSocketFactory f58727j;
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

    /* renamed from: b  reason: collision with root package name */
    public int f58719b = 22;
    public final String u = c.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.c.g f58720c = com.meizu.cloud.pushsdk.b.c.g.a(AbstractBceClient.DEFAULT_CONTENT_TYPE);
    public AtomicBoolean t = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public static class a {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f58728b;
        public SSLSocketFactory m;
        public HostnameVerifier n;
        public Class<? extends c> p;

        /* renamed from: c  reason: collision with root package name */
        public f f58729c = null;

        /* renamed from: d  reason: collision with root package name */
        public d f58730d = d.POST;

        /* renamed from: e  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.b.a f58731e = com.meizu.cloud.pushsdk.c.b.a.Single;

        /* renamed from: f  reason: collision with root package name */
        public h f58732f = h.HTTPS;

        /* renamed from: g  reason: collision with root package name */
        public int f58733g = 5;

        /* renamed from: h  reason: collision with root package name */
        public int f58734h = 250;

        /* renamed from: i  reason: collision with root package name */
        public int f58735i = 5;

        /* renamed from: j  reason: collision with root package name */
        public long f58736j = 40000;
        public long k = 40000;
        public TimeUnit l = TimeUnit.SECONDS;
        public com.meizu.cloud.pushsdk.b.c.a o = new com.meizu.cloud.pushsdk.b.c.e();

        public a(String str, Context context, Class<? extends c> cls) {
            this.a = str;
            this.f58728b = context;
            this.p = cls;
        }

        public a a(int i2) {
            this.f58733g = i2;
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
            this.f58731e = aVar;
            return this;
        }

        public a a(f fVar) {
            this.f58729c = fVar;
            return this;
        }

        public a b(int i2) {
            this.f58734h = i2;
            return this;
        }

        public a c(int i2) {
            this.f58735i = i2;
            return this;
        }
    }

    public c(a aVar) {
        this.f58724g = aVar.f58730d;
        this.f58723f = aVar.f58729c;
        this.f58721d = aVar.f58728b;
        this.f58725h = aVar.f58731e;
        this.f58726i = aVar.f58732f;
        this.f58727j = aVar.m;
        this.k = aVar.n;
        this.m = aVar.f58733g;
        this.n = aVar.f58735i;
        this.o = aVar.f58734h;
        this.p = aVar.f58736j;
        this.q = aVar.k;
        this.l = aVar.a;
        this.r = aVar.l;
        this.s = aVar.o;
        c();
        com.meizu.cloud.pushsdk.c.f.c.c(this.u, "Emitter created successfully!", new Object[0]);
    }

    private i a(com.meizu.cloud.pushsdk.c.a.a aVar) {
        a(aVar, "");
        this.f58722e.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.f58722e.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.f58722e.build().toString()).a().c();
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
        String uri = this.f58722e.build().toString();
        return new i.a().a(uri).a(j.a(this.f58720c, bVar.toString())).c();
    }

    private void a(com.meizu.cloud.pushsdk.c.a.a aVar, String str) {
        if (str.equals("")) {
            str = com.meizu.cloud.pushsdk.c.f.e.a();
        }
        aVar.a(ConstantHelper.LOG_STM, str);
    }

    private void c() {
        StringBuilder sb;
        String str;
        String str2 = this.u;
        com.meizu.cloud.pushsdk.c.f.c.a(str2, "security " + this.f58726i, new Object[0]);
        if (this.f58726i == h.HTTP) {
            sb = new StringBuilder();
            str = "http://";
        } else {
            sb = new StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.l);
        this.f58722e = Uri.parse(sb.toString()).buildUpon();
        if (this.f58724g == d.GET) {
            this.f58722e.appendPath("i");
        } else {
            this.f58722e.appendEncodedPath("push_data_report/mobile");
        }
    }

    public int a(i iVar) {
        k kVar = null;
        try {
            com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Sending request: %s", iVar);
            kVar = this.s.a(iVar);
            return kVar.a();
        } catch (IOException e2) {
            com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Request sending failed: %s", Log.getStackTraceString(e2));
            return -1;
        } finally {
            a(kVar);
        }
    }

    public LinkedList<e> a(b bVar) {
        int i2;
        int size = bVar.a().size();
        LinkedList<Long> b2 = bVar.b();
        LinkedList<e> linkedList = new LinkedList<>();
        if (this.f58724g == d.GET) {
            for (int i3 = 0; i3 < size; i3++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b2.get(i3));
                com.meizu.cloud.pushsdk.c.a.a aVar = bVar.a().get(i3);
                linkedList.add(new e(aVar.b() + ((long) this.f58719b) > this.p, a(aVar), linkedList2));
            }
        } else {
            int i4 = 0;
            while (i4 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList = new ArrayList<>();
                long j2 = 0;
                int i5 = i4;
                while (i5 < this.f58725h.a() + i4 && i5 < size) {
                    com.meizu.cloud.pushsdk.c.a.a aVar2 = bVar.a().get(i5);
                    ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList2 = arrayList;
                    long b3 = aVar2.b() + this.f58719b;
                    int i6 = this.a;
                    int i7 = i4;
                    LinkedList linkedList4 = linkedList3;
                    if (i6 + b3 > this.q) {
                        ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList3 = new ArrayList<>();
                        LinkedList linkedList5 = new LinkedList();
                        arrayList3.add(aVar2);
                        linkedList5.add(b2.get(i5));
                        linkedList.add(new e(true, a(arrayList3), linkedList5));
                        i2 = i7;
                        linkedList3 = linkedList4;
                        arrayList = arrayList2;
                    } else {
                        j2 += b3;
                        i2 = i7;
                        if (i6 + j2 + (arrayList2.size() - 1) > this.q) {
                            linkedList.add(new e(false, a(arrayList2), linkedList4));
                            ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList4 = new ArrayList<>();
                            linkedList3 = new LinkedList();
                            arrayList4.add(aVar2);
                            linkedList3.add(b2.get(i5));
                            arrayList = arrayList4;
                            j2 = b3;
                        } else {
                            arrayList = arrayList2;
                            arrayList.add(aVar2);
                            linkedList4.add(b2.get(i5));
                            linkedList3 = linkedList4;
                        }
                    }
                    i5++;
                    i4 = i2;
                }
                int i8 = i4;
                LinkedList linkedList6 = linkedList3;
                if (!arrayList.isEmpty()) {
                    linkedList.add(new e(false, a(arrayList), linkedList6));
                }
                i4 = i8 + this.f58725h.a();
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

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    public String b() {
        return this.f58722e.clearQuery().build().toString();
    }
}
