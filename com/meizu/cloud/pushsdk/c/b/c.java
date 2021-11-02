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
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: d  reason: collision with root package name */
    public Context f67491d;

    /* renamed from: e  reason: collision with root package name */
    public Uri.Builder f67492e;

    /* renamed from: f  reason: collision with root package name */
    public f f67493f;

    /* renamed from: g  reason: collision with root package name */
    public d f67494g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.a f67495h;

    /* renamed from: i  reason: collision with root package name */
    public h f67496i;
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

    /* renamed from: a  reason: collision with root package name */
    public int f67488a = 88;

    /* renamed from: b  reason: collision with root package name */
    public int f67489b = 22;
    public final String u = c.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.c.g f67490c = com.meizu.cloud.pushsdk.b.c.g.a(AbstractBceClient.DEFAULT_CONTENT_TYPE);
    public AtomicBoolean t = new AtomicBoolean(false);

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f67497a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f67498b;
        public SSLSocketFactory m;
        public HostnameVerifier n;
        public Class<? extends c> p;

        /* renamed from: c  reason: collision with root package name */
        public f f67499c = null;

        /* renamed from: d  reason: collision with root package name */
        public d f67500d = d.POST;

        /* renamed from: e  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.b.a f67501e = com.meizu.cloud.pushsdk.c.b.a.Single;

        /* renamed from: f  reason: collision with root package name */
        public h f67502f = h.HTTPS;

        /* renamed from: g  reason: collision with root package name */
        public int f67503g = 5;

        /* renamed from: h  reason: collision with root package name */
        public int f67504h = 250;

        /* renamed from: i  reason: collision with root package name */
        public int f67505i = 5;
        public long j = 40000;
        public long k = 40000;
        public TimeUnit l = TimeUnit.SECONDS;
        public com.meizu.cloud.pushsdk.b.c.a o = new com.meizu.cloud.pushsdk.b.c.e();

        public a(String str, Context context, Class<? extends c> cls) {
            this.f67497a = str;
            this.f67498b = context;
            this.p = cls;
        }

        public a a(int i2) {
            this.f67503g = i2;
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
            this.f67501e = aVar;
            return this;
        }

        public a a(f fVar) {
            this.f67499c = fVar;
            return this;
        }

        public a b(int i2) {
            this.f67504h = i2;
            return this;
        }

        public a c(int i2) {
            this.f67505i = i2;
            return this;
        }
    }

    public c(a aVar) {
        this.f67494g = aVar.f67500d;
        this.f67493f = aVar.f67499c;
        this.f67491d = aVar.f67498b;
        this.f67495h = aVar.f67501e;
        this.f67496i = aVar.f67502f;
        this.j = aVar.m;
        this.k = aVar.n;
        this.m = aVar.f67503g;
        this.n = aVar.f67505i;
        this.o = aVar.f67504h;
        this.p = aVar.j;
        this.q = aVar.k;
        this.l = aVar.f67497a;
        this.r = aVar.l;
        this.s = aVar.o;
        c();
        com.meizu.cloud.pushsdk.c.f.c.c(this.u, "Emitter created successfully!", new Object[0]);
    }

    private i a(com.meizu.cloud.pushsdk.c.a.a aVar) {
        a(aVar, "");
        this.f67492e.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.f67492e.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.f67492e.build().toString()).a().c();
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
        String uri = this.f67492e.build().toString();
        return new i.a().a(uri).a(j.a(this.f67490c, bVar.toString())).c();
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
        com.meizu.cloud.pushsdk.c.f.c.a(str2, "security " + this.f67496i, new Object[0]);
        if (this.f67496i == h.HTTP) {
            sb = new StringBuilder();
            str = "http://";
        } else {
            sb = new StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.l);
        this.f67492e = Uri.parse(sb.toString()).buildUpon();
        if (this.f67494g == d.GET) {
            this.f67492e.appendPath("i");
        } else {
            this.f67492e.appendEncodedPath("push_data_report/mobile");
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
        if (this.f67494g == d.GET) {
            for (int i3 = 0; i3 < size; i3++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b2.get(i3));
                com.meizu.cloud.pushsdk.c.a.a aVar = bVar.a().get(i3);
                linkedList.add(new e(aVar.b() + ((long) this.f67489b) > this.p, a(aVar), linkedList2));
            }
        } else {
            int i4 = 0;
            while (i4 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList = new ArrayList<>();
                long j = 0;
                int i5 = i4;
                while (i5 < this.f67495h.a() + i4 && i5 < size) {
                    com.meizu.cloud.pushsdk.c.a.a aVar2 = bVar.a().get(i5);
                    ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList2 = arrayList;
                    long b3 = aVar2.b() + this.f67489b;
                    int i6 = this.f67488a;
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
                        j += b3;
                        i2 = i7;
                        if (i6 + j + (arrayList2.size() - 1) > this.q) {
                            linkedList.add(new e(false, a(arrayList2), linkedList4));
                            ArrayList<com.meizu.cloud.pushsdk.c.a.a> arrayList4 = new ArrayList<>();
                            linkedList3 = new LinkedList();
                            arrayList4.add(aVar2);
                            linkedList3.add(b2.get(i5));
                            arrayList = arrayList4;
                            j = b3;
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
                i4 = i8 + this.f67495h.a();
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
        return this.f67492e.clearQuery().build().toString();
    }
}
