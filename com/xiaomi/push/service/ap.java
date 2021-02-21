package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kwad.sdk.collector.AppStatusRules;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static ap f14243a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f929a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f928a = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f930a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f932a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f934a;

        /* renamed from: a  reason: collision with other field name */
        public d f937a;

        /* renamed from: a  reason: collision with other field name */
        public String f938a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f940a;

        /* renamed from: b  reason: collision with other field name */
        public String f941b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f936a = c.unbind;

        /* renamed from: a  reason: collision with root package name */
        private int f14244a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f939a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        c f14245b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f942b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.b f933a = new XMPushService.b(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f931a = null;

        /* renamed from: a  reason: collision with other field name */
        final C1285b f935a = new C1285b();

        /* loaded from: classes6.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.ap$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1285b extends XMPushService.i {

            /* renamed from: a  reason: collision with other field name */
            String f943a;

            /* renamed from: b  reason: collision with root package name */
            int f14247b;

            /* renamed from: b  reason: collision with other field name */
            String f944b;
            int c;

            public C1285b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.f14247b = i;
                this.c = i2;
                this.f944b = str2;
                this.f943a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.f14247b, this.c, this.f944b)) {
                    b.this.a(this.f14247b, this.c, this.f943a, this.f944b);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            final Messenger f14248a;

            /* renamed from: a  reason: collision with other field name */
            final b f945a;

            c(b bVar, Messenger messenger) {
                this.f945a = bVar;
                this.f14248a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f945a.g);
                b.this.f934a.a(new ar(this, 0), 0L);
                if ("9".equals(this.f945a.g) && "com.xiaomi.xmsf".equals(b.this.f934a.getPackageName())) {
                    b.this.f934a.a(new as(this, 0), AppStatusRules.DEFAULT_GRANULARITY);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f934a = xMPushService;
            a(new aq(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            this.f14245b = this.f936a;
            if (i == 2) {
                this.f937a.a(this.f930a, this, i2);
            } else if (i == 3) {
                this.f937a.a(this.f930a, this, str2, str);
            } else if (i == 1) {
                boolean z = this.f936a == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f14244a++;
                } else if (z) {
                    this.f14244a = 0;
                    if (this.f932a != null) {
                        try {
                            this.f932a.send(Message.obtain(null, 16, this.f934a.f878a));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.f937a.a(this.f934a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            if (this.f14245b == null || !this.f942b) {
                return true;
            }
            if (this.f14245b == this.f936a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            } else if (this.f932a == null || !this.f942b) {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.g);
                return false;
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            }
        }

        private boolean b(int i, int i2, String str) {
            switch (i) {
                case 1:
                    if (this.f936a == c.binded || !this.f934a.m551c() || i2 == 21) {
                        return false;
                    }
                    return (i2 == 7 && "wait".equals(str)) ? false : true;
                case 2:
                    return this.f934a.m551c();
                case 3:
                    return "wait".equals(str) ? false : true;
                default:
                    return false;
            }
        }

        public long a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f14244a + 1) * 15));
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

        /* renamed from: a  reason: collision with other method in class */
        void m576a() {
            try {
                Messenger messenger = this.f932a;
                if (messenger != null && this.f931a != null) {
                    messenger.getBinder().unlinkToDeath(this.f931a, 0);
                }
            } catch (Exception e) {
            }
            this.f14245b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m576a();
            try {
                if (messenger != null) {
                    this.f932a = messenger;
                    this.f942b = true;
                    this.f931a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f931a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f932a = null;
                this.f942b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f939a) {
                this.f939a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            synchronized (this.f939a) {
                for (a aVar : this.f939a) {
                    aVar.a(this.f936a, cVar, i2);
                }
            }
            if (this.f936a != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m79a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.f936a, cVar, a(i), at.a(i2), str, str2, this.g));
                this.f936a = cVar;
            }
            if (this.f937a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                int i3 = 10100;
                if (this.f14245b == null || !this.f942b) {
                    i3 = 0;
                } else if (this.f932a != null && this.f942b) {
                    i3 = 1000;
                }
                this.f934a.b(this.f935a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f934a.a(this.f935a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f939a) {
                this.f939a.remove(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    private ap() {
    }

    public static synchronized ap a() {
        ap apVar;
        synchronized (ap.class) {
            if (f14243a == null) {
                f14243a = new ap();
            }
            apVar = f14243a;
        }
        return apVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m568a() {
        return this.f929a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap;
        hashMap = this.f929a.get(str);
        return hashMap == null ? null : hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m569a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f929a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m570a(String str) {
        return !this.f929a.containsKey(str) ? new ArrayList<>() : ((HashMap) this.f929a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m571a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f929a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f938a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m572a() {
        Iterator<b> it = m569a().iterator();
        while (it.hasNext()) {
            it.next().m576a();
        }
        this.f929a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f929a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f929a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f928a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f929a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f929a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f941b), bVar);
        for (a aVar : this.f928a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m573a(String str) {
        HashMap<String, b> hashMap = this.f929a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m576a();
            }
            hashMap.clear();
            this.f929a.remove(str);
        }
        for (a aVar : this.f928a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m574a(String str, String str2) {
        HashMap<String, b> hashMap = this.f929a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m576a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f929a.remove(str);
            }
        }
        for (a aVar : this.f928a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f928a.clear();
    }
}
