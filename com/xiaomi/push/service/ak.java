package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class ak {
    private static ak a;
    private ConcurrentHashMap<String, HashMap<String, b>> b = new ConcurrentHashMap<>();
    private List<a> c = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes2.dex */
    public static class b {
        public String a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public com.xiaomi.push.service.b k;
        public Context l;
        private XMPushService p;
        c m = c.unbind;
        private int n = 0;
        private List<a> o = new ArrayList();
        private XMPushService.b q = new XMPushService.b(this);

        /* loaded from: classes2.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.p = xMPushService;
            a(new al(this));
        }

        public long a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.n + 1) * 15));
        }

        public String a(int i) {
            switch (i) {
                case 1:
                    return "OPEN";
                case 2:
                    return "CLOSE";
                case 3:
                    return "KICK";
                default:
                    return "unknown";
            }
        }

        public void a(a aVar) {
            synchronized (this.o) {
                this.o.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            synchronized (this.o) {
                for (a aVar : this.o) {
                    aVar.a(this.m, cVar, i2);
                }
            }
            if (this.m != cVar) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.m, cVar, a(i), am.a(i2), str, str2, this.h));
                this.m = cVar;
            }
            if (this.k == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (i == 2) {
                this.k.a(this.l, this, i2);
            } else if (i == 3) {
                this.k.a(this.l, this, str2, str);
            } else if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.n++;
                } else if (z) {
                    this.n = 0;
                }
                this.k.a(this.l, this, z, i2, str);
            }
        }

        public void b(a aVar) {
            synchronized (this.o) {
                this.o.remove(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    private ak() {
    }

    public static synchronized ak a() {
        ak akVar;
        synchronized (ak.class) {
            if (a == null) {
                a = new ak();
            }
            akVar = a;
        }
        return akVar;
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, null, null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, null, null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.c.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.b.get(bVar.h);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.b.put(bVar.h, hashMap);
        }
        hashMap.put(d(bVar.b), bVar);
        for (a aVar : this.c) {
            aVar.a();
        }
    }

    public synchronized void a(String str) {
        HashMap<String, b> hashMap = this.b.get(str);
        if (hashMap != null) {
            hashMap.clear();
            this.b.remove(str);
        }
        for (a aVar : this.c) {
            aVar.a();
        }
    }

    public synchronized void a(String str, String str2) {
        HashMap<String, b> hashMap = this.b.get(str);
        if (hashMap != null) {
            hashMap.remove(d(str2));
            if (hashMap.isEmpty()) {
                this.b.remove(str);
            }
        }
        for (a aVar : this.c) {
            aVar.a();
        }
    }

    public synchronized b b(String str, String str2) {
        HashMap<String, b> hashMap;
        hashMap = this.b.get(str);
        return hashMap == null ? null : hashMap.get(d(str2));
    }

    public synchronized ArrayList<b> b() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.b.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    public synchronized List<String> b(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.a)) {
                    arrayList.add(bVar.h);
                }
            }
        }
        return arrayList;
    }

    public synchronized int c() {
        return this.b.size();
    }

    public synchronized Collection<b> c(String str) {
        return !this.b.containsKey(str) ? new ArrayList<>() : ((HashMap) this.b.get(str).clone()).values();
    }

    public synchronized void d() {
        this.b.clear();
    }

    public synchronized void e() {
        this.c.clear();
    }
}
