package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class bg {
    public static bg a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, HashMap<String, b>> f922a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public List<a> f921a = new ArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f923a;

        /* renamed from: a  reason: collision with other field name */
        public Messenger f925a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService f927a;

        /* renamed from: a  reason: collision with other field name */
        public j f930a;

        /* renamed from: a  reason: collision with other field name */
        public String f931a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f933a;

        /* renamed from: b  reason: collision with other field name */
        public String f934b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        public c f929a = c.unbind;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public List<a> f932a = new ArrayList();
        public c b = null;

        /* renamed from: b  reason: collision with other field name */
        public boolean f935b = false;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService.c f926a = new XMPushService.c(this);

        /* renamed from: a  reason: collision with other field name */
        public IBinder.DeathRecipient f924a = null;

        /* renamed from: a  reason: collision with other field name */
        public final C0758b f928a = new C0758b();

        /* loaded from: classes10.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.bg$b$b  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0758b extends XMPushService.j {

            /* renamed from: a  reason: collision with other field name */
            public String f936a;
            public int b;

            /* renamed from: b  reason: collision with other field name */
            public String f937b;
            public int c;

            public C0758b() {
                super(0);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f937b = str2;
                this.f936a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public String mo765a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo482a() {
                if (b.this.a(this.b, this.c, this.f937b)) {
                    b.this.a(this.b, this.c, this.f936a, this.f937b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }
        }

        /* loaded from: classes10.dex */
        public class c implements IBinder.DeathRecipient {
            public final Messenger a;

            /* renamed from: a  reason: collision with other field name */
            public final b f938a;

            public c(b bVar, Messenger messenger) {
                this.f938a = bVar;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f938a.g);
                b.this.f927a.a(new bi(this, 0), 0L);
                if ("9".equals(this.f938a.g) && "com.xiaomi.xmsf".equals(b.this.f927a.getPackageName())) {
                    b.this.f927a.a(new bj(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f927a = xMPushService;
            a(new bh(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.f929a;
            this.b = cVar;
            if (i == 2) {
                this.f930a.a(this.f923a, this, i2);
            } else if (i == 3) {
                this.f930a.a(this.f923a, this, str2, str);
            } else if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f925a != null) {
                        try {
                            this.f925a.send(Message.obtain(null, 16, this.f927a.f840a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f930a.a(this.f927a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            c cVar = this.b;
            if (cVar == null || !(z = this.f935b)) {
                return true;
            }
            if (cVar == this.f929a) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else if (this.f925a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            } else {
                sb = new StringBuilder();
                str2 = "peer died, ignore notify ";
            }
            sb.append(str2);
            sb.append(this.g);
            com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
            return false;
        }

        private boolean b(int i, int i2, String str) {
            if (i == 1) {
                return (this.f929a == c.binded || !this.f927a.m763c() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
            } else if (i != 2) {
                if (i != 3) {
                    return false;
                }
                return !"wait".equals(str);
            } else {
                return this.f927a.m763c();
            }
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.a + 1) * 15)) * 1000;
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m809a() {
            try {
                Messenger messenger = this.f925a;
                if (messenger != null && this.f924a != null) {
                    messenger.getBinder().unlinkToDeath(this.f924a, 0);
                }
            } catch (Exception unused) {
            }
            this.b = null;
        }

        public void a(Messenger messenger) {
            m809a();
            try {
                if (messenger != null) {
                    this.f925a = messenger;
                    this.f935b = true;
                    this.f924a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f924a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f925a = null;
                this.f935b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f932a) {
                this.f932a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            synchronized (this.f932a) {
                for (a aVar : this.f932a) {
                    aVar.a(this.f929a, cVar, i2);
                }
            }
            c cVar2 = this.f929a;
            int i3 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m190a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), bk.a(i2), str, str2, this.g));
                this.f929a = cVar;
            }
            if (this.f930a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.b != null && (z = this.f935b)) {
                    i3 = (this.f925a == null || !z) ? 10100 : 1000;
                }
                this.f927a.b(this.f928a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f927a.a(this.f928a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f932a) {
                this.f932a.remove(aVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    public static synchronized bg a() {
        bg bgVar;
        synchronized (bg.class) {
            if (a == null) {
                a = new bg();
            }
            bgVar = a;
        }
        return bgVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m801a() {
        return this.f922a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap = this.f922a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m802a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f922a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m803a(String str) {
        if (this.f922a.containsKey(str)) {
            return ((HashMap) this.f922a.get(str).clone()).values();
        }
        return new ArrayList();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m804a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f922a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f931a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m805a() {
        Iterator<b> it = m802a().iterator();
        while (it.hasNext()) {
            it.next().m809a();
        }
        this.f922a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f922a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f922a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f921a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f922a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f922a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f934b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m190a("add active client. " + bVar.f931a);
        for (a aVar : this.f921a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m806a(String str) {
        HashMap<String, b> hashMap = this.f922a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m809a();
            }
            hashMap.clear();
            this.f922a.remove(str);
        }
        for (a aVar : this.f921a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m807a(String str, String str2) {
        HashMap<String, b> hashMap = this.f922a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m809a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f922a.remove(str);
            }
        }
        for (a aVar : this.f921a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f921a.clear();
    }
}
