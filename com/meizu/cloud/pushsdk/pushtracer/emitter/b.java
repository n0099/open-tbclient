package com.meizu.cloud.pushsdk.pushtracer.emitter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.meizu.cloud.pushsdk.networking.b.g;
import com.meizu.cloud.pushsdk.networking.b.i;
import com.meizu.cloud.pushsdk.networking.b.j;
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
public abstract class b {
    protected Context d;
    protected Uri.Builder e;
    protected d f;
    protected HttpMethod g;
    protected BufferOption h;
    protected RequestSecurity i;
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
    private final String t = b.class.getSimpleName();
    protected final g c = g.a("application/json; charset=utf-8");
    protected AtomicBoolean s = new AtomicBoolean(false);

    public abstract void a();

    public abstract void a(com.meizu.cloud.pushsdk.pushtracer.a.a aVar);

    /* loaded from: classes3.dex */
    public static class a {
        protected final String a;
        protected final Context b;
        protected d c = null;
        protected HttpMethod d = HttpMethod.POST;
        protected BufferOption e = BufferOption.Single;
        protected RequestSecurity f = RequestSecurity.HTTPS;
        protected int g = 5;
        protected int h = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected TimeUnit l = TimeUnit.SECONDS;
        protected SSLSocketFactory m;
        protected HostnameVerifier n;
        private Class<? extends b> o;

        public a(String str, Context context, Class<? extends b> cls) {
            this.a = str;
            this.b = context;
            this.o = cls;
        }

        public a a(BufferOption bufferOption) {
            this.e = bufferOption;
            return this;
        }

        public a a(d dVar) {
            this.c = dVar;
            return this;
        }

        public a a(int i) {
            this.g = i;
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

    public b(a aVar) {
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
        com.meizu.cloud.pushsdk.pushtracer.utils.b.c(this.t, "Emitter created successfully!", new Object[0]);
    }

    private void c() {
        com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "security " + this.i, new Object[0]);
        if (this.i == RequestSecurity.HTTP) {
            this.e = Uri.parse("http://" + this.l).buildUpon();
        } else {
            this.e = Uri.parse(SapiUtils.COOKIE_HTTPS_URL_PREFIX + this.l).buildUpon();
        }
        if (this.g == HttpMethod.GET) {
            this.e.appendPath("i");
        } else {
            this.e.appendEncodedPath("push_data_report/mobile");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(i iVar) {
        try {
            com.meizu.cloud.pushsdk.pushtracer.utils.b.b(this.t, "Sending request: %s", iVar);
            return new com.meizu.cloud.pushsdk.networking.b.e(iVar).a().a();
        } catch (IOException e) {
            com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Request sending failed: %s", e.toString());
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinkedList<c> a(com.meizu.cloud.pushsdk.pushtracer.emitter.a aVar) {
        int size = aVar.a().size();
        LinkedList<Long> b = aVar.b();
        LinkedList<c> linkedList = new LinkedList<>();
        if (this.g == HttpMethod.GET) {
            for (int i = 0; i < size; i++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b.get(i));
                com.meizu.cloud.pushsdk.pushtracer.a.a aVar2 = aVar.a().get(i);
                linkedList.add(new c(aVar2.b() + ((long) this.b) > this.p, b(aVar2), linkedList2));
            }
        } else {
            int i2 = 0;
            while (i2 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.pushtracer.a.a> arrayList = new ArrayList<>();
                LinkedList linkedList4 = linkedList3;
                long j = 0;
                for (int i3 = i2; i3 < this.h.getCode() + i2 && i3 < size; i3++) {
                    com.meizu.cloud.pushsdk.pushtracer.a.a aVar3 = aVar.a().get(i3);
                    long b2 = aVar3.b() + this.b;
                    if (this.a + b2 > this.q) {
                        ArrayList<com.meizu.cloud.pushsdk.pushtracer.a.a> arrayList2 = new ArrayList<>();
                        LinkedList linkedList5 = new LinkedList();
                        arrayList2.add(aVar3);
                        linkedList5.add(b.get(i3));
                        linkedList.add(new c(true, a(arrayList2), linkedList5));
                    } else if (j + b2 + this.a + (arrayList.size() - 1) > this.q) {
                        linkedList.add(new c(false, a(arrayList), linkedList4));
                        arrayList = new ArrayList<>();
                        linkedList4 = new LinkedList();
                        arrayList.add(aVar3);
                        linkedList4.add(b.get(i3));
                        j = b2;
                    } else {
                        j += b2;
                        arrayList.add(aVar3);
                        linkedList4.add(b.get(i3));
                    }
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new c(false, a(arrayList), linkedList4));
                }
                i2 += this.h.getCode();
            }
        }
        return linkedList;
    }

    private i b(com.meizu.cloud.pushsdk.pushtracer.a.a aVar) {
        a(aVar, "");
        this.e.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.e.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.e.build().toString()).a().c();
    }

    private i a(ArrayList<com.meizu.cloud.pushsdk.pushtracer.a.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.meizu.cloud.pushsdk.pushtracer.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.meizu.cloud.pushsdk.pushtracer.a.a next = it.next();
            stringBuffer.append(next.toString());
            arrayList2.add(next.a());
        }
        String uri = this.e.build().toString();
        String stringBuffer2 = stringBuffer.toString();
        com.meizu.cloud.pushsdk.pushtracer.utils.b.b(this.t, "post final String " + stringBuffer2, new Object[0]);
        return new i.a().a(uri).a(j.a(this.c, stringBuffer2)).c();
    }

    private void a(com.meizu.cloud.pushsdk.pushtracer.a.a aVar, String str) {
        if (str.equals("")) {
            str = com.meizu.cloud.pushsdk.pushtracer.utils.d.a();
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
