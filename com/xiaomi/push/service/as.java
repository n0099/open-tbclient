package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class as {
    private static as a;
    private ConcurrentHashMap<String, HashMap<String, b>> b = new ConcurrentHashMap<>();
    private List<a> c = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
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
        public d k;
        public Context l;
        Messenger o;
        private XMPushService t;
        c m = c.unbind;
        private int r = 0;
        private List<a> s = new ArrayList();
        c n = null;
        private boolean u = false;
        private XMPushService.b v = new XMPushService.b(this);
        IBinder.DeathRecipient p = null;
        final C0601b q = new C0601b();

        /* loaded from: classes3.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.as$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0601b extends XMPushService.i {
            int b;
            int c;
            String d;
            String e;

            public C0601b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.e = str2;
                this.d = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.b, this.c, this.e)) {
                    b.this.a(this.b, this.c, this.d, this.e);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.h);
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String b() {
                return "notify job";
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class c implements IBinder.DeathRecipient {
            final b a;
            final Messenger b;

            c(b bVar, Messenger messenger) {
                this.a = bVar;
                this.b = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.a.h);
                b.this.t.a(new au(this, 0), 0L);
                if ("9".equals(this.a.h) && "com.xiaomi.xmsf".equals(b.this.t.getPackageName())) {
                    b.this.t.a(new av(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.t = xMPushService;
            a(new at(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            this.n = this.m;
            if (i == 2) {
                this.k.a(this.l, this, i2);
            } else if (i == 3) {
                this.k.a(this.l, this, str2, str);
            } else if (i == 1) {
                boolean z = this.m == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.r++;
                } else if (z) {
                    this.r = 0;
                    if (this.o != null) {
                        try {
                            this.o.send(Message.obtain(null, 16, this.t.b));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.k.a(this.t, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            if (this.n == null || !this.u) {
                return true;
            }
            if (this.n == this.m) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.h);
                return false;
            } else if (this.o == null || !this.u) {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.h);
                return false;
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.h);
                return true;
            }
        }

        private boolean b(int i, int i2, String str) {
            switch (i) {
                case 1:
                    if (this.m == c.binded || !this.t.e() || i2 == 21) {
                        return false;
                    }
                    return (i2 == 7 && "wait".equals(str)) ? false : true;
                case 2:
                    return this.t.e();
                case 3:
                    return "wait".equals(str) ? false : true;
                default:
                    return false;
            }
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

        void a() {
            try {
                Messenger messenger = this.o;
                if (messenger != null && this.p != null) {
                    messenger.getBinder().unlinkToDeath(this.p, 0);
                }
            } catch (Exception e) {
            }
            this.n = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            a();
            try {
                if (messenger != null) {
                    this.o = messenger;
                    this.u = true;
                    this.p = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.p, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.h);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.o = null;
                this.u = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.s) {
                this.s.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            synchronized (this.s) {
                for (a aVar : this.s) {
                    aVar.a(this.m, cVar, i2);
                }
            }
            if (this.m != cVar) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.m, cVar, a(i), aw.a(i2), str, str2, this.h));
                this.m = cVar;
            }
            if (this.k == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                int i3 = Constants.REQUEST_API;
                if (this.n == null || !this.u) {
                    i3 = 0;
                } else if (this.o != null && this.u) {
                    i3 = 1000;
                }
                this.t.b(this.q);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.t.a(this.q.a(i, i2, str, str2), i3);
                }
            }
        }

        public long b() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.r + 1) * 15));
        }

        public void b(a aVar) {
            synchronized (this.s) {
                this.s.remove(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    private as() {
    }

    public static synchronized as a() {
        as asVar;
        synchronized (as.class) {
            if (a == null) {
                a = new as();
            }
            asVar = a;
        }
        return asVar;
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
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
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
            for (b bVar : hashMap.values()) {
                bVar.a();
            }
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
            b bVar = hashMap.get(d(str2));
            if (bVar != null) {
                bVar.a();
            }
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
        Iterator<b> it = b().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.b.clear();
    }

    public synchronized void e() {
        this.c.clear();
    }
}
