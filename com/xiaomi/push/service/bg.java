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
/* loaded from: classes9.dex */
public class bg {
    public static bg a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, HashMap<String, b>> f926a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public List<a> f925a = new ArrayList();

    /* loaded from: classes9.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f927a;

        /* renamed from: a  reason: collision with other field name */
        public Messenger f929a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService f931a;

        /* renamed from: a  reason: collision with other field name */
        public j f934a;

        /* renamed from: a  reason: collision with other field name */
        public String f935a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f937a;

        /* renamed from: b  reason: collision with other field name */
        public String f938b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        public c f933a = c.unbind;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public List<a> f936a = new ArrayList();
        public c b = null;

        /* renamed from: b  reason: collision with other field name */
        public boolean f939b = false;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService.c f930a = new XMPushService.c(this);

        /* renamed from: a  reason: collision with other field name */
        public IBinder.DeathRecipient f928a = null;

        /* renamed from: a  reason: collision with other field name */
        public final C0740b f932a = new C0740b();

        /* loaded from: classes9.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.bg$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0740b extends XMPushService.j {

            /* renamed from: a  reason: collision with other field name */
            public String f940a;
            public int b;

            /* renamed from: b  reason: collision with other field name */
            public String f941b;
            public int c;

            public C0740b() {
                super(0);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f941b = str2;
                this.f940a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public String mo676a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo393a() {
                if (b.this.a(this.b, this.c, this.f941b)) {
                    b.this.a(this.b, this.c, this.f940a, this.f941b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }
        }

        /* loaded from: classes9.dex */
        public class c implements IBinder.DeathRecipient {
            public final Messenger a;

            /* renamed from: a  reason: collision with other field name */
            public final b f942a;

            public c(b bVar, Messenger messenger) {
                this.f942a = bVar;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f942a.g);
                b.this.f931a.a(new bi(this, 0), 0L);
                if ("9".equals(this.f942a.g) && "com.xiaomi.xmsf".equals(b.this.f931a.getPackageName())) {
                    b.this.f931a.a(new bj(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f931a = xMPushService;
            a(new bh(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.f933a;
            this.b = cVar;
            if (i == 2) {
                this.f934a.a(this.f927a, this, i2);
            } else if (i == 3) {
                this.f934a.a(this.f927a, this, str2, str);
            } else if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f929a != null) {
                        try {
                            this.f929a.send(Message.obtain(null, 16, this.f931a.f844a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f934a.a(this.f931a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            c cVar = this.b;
            if (cVar == null || !(z = this.f939b)) {
                return true;
            }
            if (cVar == this.f933a) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else if (this.f929a != null && z) {
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
                return (this.f933a == c.binded || !this.f931a.m674c() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
            } else if (i != 2) {
                if (i != 3) {
                    return false;
                }
                return !"wait".equals(str);
            } else {
                return this.f931a.m674c();
            }
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.a + 1) * 15)) * 1000;
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m720a() {
            try {
                Messenger messenger = this.f929a;
                if (messenger != null && this.f928a != null) {
                    messenger.getBinder().unlinkToDeath(this.f928a, 0);
                }
            } catch (Exception unused) {
            }
            this.b = null;
        }

        public void a(Messenger messenger) {
            m720a();
            try {
                if (messenger != null) {
                    this.f929a = messenger;
                    this.f939b = true;
                    this.f928a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f928a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f929a = null;
                this.f939b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f936a) {
                this.f936a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            synchronized (this.f936a) {
                for (a aVar : this.f936a) {
                    aVar.a(this.f933a, cVar, i2);
                }
            }
            c cVar2 = this.f933a;
            int i3 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m101a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), bk.a(i2), str, str2, this.g));
                this.f933a = cVar;
            }
            if (this.f934a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.b != null && (z = this.f939b)) {
                    i3 = (this.f929a == null || !z) ? 10100 : 1000;
                }
                this.f931a.b(this.f932a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f931a.a(this.f932a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f936a) {
                this.f936a.remove(aVar);
            }
        }
    }

    /* loaded from: classes9.dex */
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
    public synchronized int m712a() {
        return this.f926a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap = this.f926a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m713a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f926a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m714a(String str) {
        if (this.f926a.containsKey(str)) {
            return ((HashMap) this.f926a.get(str).clone()).values();
        }
        return new ArrayList();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m715a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f926a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f935a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m716a() {
        Iterator<b> it = m713a().iterator();
        while (it.hasNext()) {
            it.next().m720a();
        }
        this.f926a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f926a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f926a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f925a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f926a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f926a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f938b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m101a("add active client. " + bVar.f935a);
        for (a aVar : this.f925a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m717a(String str) {
        HashMap<String, b> hashMap = this.f926a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m720a();
            }
            hashMap.clear();
            this.f926a.remove(str);
        }
        for (a aVar : this.f925a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m718a(String str, String str2) {
        HashMap<String, b> hashMap = this.f926a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m720a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f926a.remove(str);
            }
        }
        for (a aVar : this.f925a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f925a.clear();
    }
}
