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
    private static ap f14541a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f930a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f929a = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f931a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f933a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f935a;

        /* renamed from: a  reason: collision with other field name */
        public d f938a;

        /* renamed from: a  reason: collision with other field name */
        public String f939a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f941a;

        /* renamed from: b  reason: collision with other field name */
        public String f942b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f937a = c.unbind;

        /* renamed from: a  reason: collision with root package name */
        private int f14542a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f940a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        c f14543b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f943b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.b f934a = new XMPushService.b(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f932a = null;

        /* renamed from: a  reason: collision with other field name */
        final C1296b f936a = new C1296b();

        /* loaded from: classes6.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.ap$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1296b extends XMPushService.i {

            /* renamed from: a  reason: collision with other field name */
            String f944a;

            /* renamed from: b  reason: collision with root package name */
            int f14545b;

            /* renamed from: b  reason: collision with other field name */
            String f945b;
            int c;

            public C1296b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.f14545b = i;
                this.c = i2;
                this.f945b = str2;
                this.f944a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.f14545b, this.c, this.f945b)) {
                    b.this.a(this.f14545b, this.c, this.f944a, this.f945b);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            final Messenger f14546a;

            /* renamed from: a  reason: collision with other field name */
            final b f946a;

            c(b bVar, Messenger messenger) {
                this.f946a = bVar;
                this.f14546a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f946a.g);
                b.this.f935a.a(new ar(this, 0), 0L);
                if ("9".equals(this.f946a.g) && "com.xiaomi.xmsf".equals(b.this.f935a.getPackageName())) {
                    b.this.f935a.a(new as(this, 0), AppStatusRules.DEFAULT_GRANULARITY);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f935a = xMPushService;
            a(new aq(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            this.f14543b = this.f937a;
            if (i == 2) {
                this.f938a.a(this.f931a, this, i2);
            } else if (i == 3) {
                this.f938a.a(this.f931a, this, str2, str);
            } else if (i == 1) {
                boolean z = this.f937a == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f14542a++;
                } else if (z) {
                    this.f14542a = 0;
                    if (this.f933a != null) {
                        try {
                            this.f933a.send(Message.obtain(null, 16, this.f935a.f879a));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.f938a.a(this.f935a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            if (this.f14543b == null || !this.f943b) {
                return true;
            }
            if (this.f14543b == this.f937a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            } else if (this.f933a == null || !this.f943b) {
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
                    if (this.f937a == c.binded || !this.f935a.m556c() || i2 == 21) {
                        return false;
                    }
                    return (i2 == 7 && "wait".equals(str)) ? false : true;
                case 2:
                    return this.f935a.m556c();
                case 3:
                    return "wait".equals(str) ? false : true;
                default:
                    return false;
            }
        }

        public long a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f14542a + 1) * 15));
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
        void m581a() {
            try {
                Messenger messenger = this.f933a;
                if (messenger != null && this.f932a != null) {
                    messenger.getBinder().unlinkToDeath(this.f932a, 0);
                }
            } catch (Exception e) {
            }
            this.f14543b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m581a();
            try {
                if (messenger != null) {
                    this.f933a = messenger;
                    this.f943b = true;
                    this.f932a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f932a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f933a = null;
                this.f943b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f940a) {
                this.f940a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            synchronized (this.f940a) {
                for (a aVar : this.f940a) {
                    aVar.a(this.f937a, cVar, i2);
                }
            }
            if (this.f937a != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m84a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.f937a, cVar, a(i), at.a(i2), str, str2, this.g));
                this.f937a = cVar;
            }
            if (this.f938a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                int i3 = 10100;
                if (this.f14543b == null || !this.f943b) {
                    i3 = 0;
                } else if (this.f933a != null && this.f943b) {
                    i3 = 1000;
                }
                this.f935a.b(this.f936a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f935a.a(this.f936a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f940a) {
                this.f940a.remove(aVar);
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
            if (f14541a == null) {
                f14541a = new ap();
            }
            apVar = f14541a;
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
    public synchronized int m573a() {
        return this.f930a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap;
        hashMap = this.f930a.get(str);
        return hashMap == null ? null : hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m574a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f930a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m575a(String str) {
        return !this.f930a.containsKey(str) ? new ArrayList<>() : ((HashMap) this.f930a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m576a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f930a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f939a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m577a() {
        Iterator<b> it = m574a().iterator();
        while (it.hasNext()) {
            it.next().m581a();
        }
        this.f930a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f930a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f930a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f929a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f930a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f930a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f942b), bVar);
        for (a aVar : this.f929a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m578a(String str) {
        HashMap<String, b> hashMap = this.f930a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m581a();
            }
            hashMap.clear();
            this.f930a.remove(str);
        }
        for (a aVar : this.f929a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m579a(String str, String str2) {
        HashMap<String, b> hashMap = this.f930a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m581a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f930a.remove(str);
            }
        }
        for (a aVar : this.f929a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f929a.clear();
    }
}
