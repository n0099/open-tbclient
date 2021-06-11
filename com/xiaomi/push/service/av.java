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
/* loaded from: classes7.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    public static av f41741a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, HashMap<String, b>> f899a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public List<a> f898a = new ArrayList();

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f900a;

        /* renamed from: a  reason: collision with other field name */
        public Messenger f902a;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService f904a;

        /* renamed from: a  reason: collision with other field name */
        public e f907a;

        /* renamed from: a  reason: collision with other field name */
        public String f908a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f910a;

        /* renamed from: b  reason: collision with other field name */
        public String f911b;

        /* renamed from: c  reason: collision with root package name */
        public String f41744c;

        /* renamed from: d  reason: collision with root package name */
        public String f41745d;

        /* renamed from: e  reason: collision with root package name */
        public String f41746e;

        /* renamed from: f  reason: collision with root package name */
        public String f41747f;

        /* renamed from: g  reason: collision with root package name */
        public String f41748g;

        /* renamed from: h  reason: collision with root package name */
        public String f41749h;

        /* renamed from: i  reason: collision with root package name */
        public String f41750i;

        /* renamed from: a  reason: collision with other field name */
        public c f906a = c.unbind;

        /* renamed from: a  reason: collision with root package name */
        public int f41742a = 0;

        /* renamed from: a  reason: collision with other field name */
        public List<a> f909a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public c f41743b = null;

        /* renamed from: b  reason: collision with other field name */
        public boolean f912b = false;

        /* renamed from: a  reason: collision with other field name */
        public XMPushService.b f903a = new XMPushService.b(this);

        /* renamed from: a  reason: collision with other field name */
        public IBinder.DeathRecipient f901a = null;

        /* renamed from: a  reason: collision with other field name */
        public final C0523b f905a = new C0523b();

        /* loaded from: classes7.dex */
        public interface a {
            void a(c cVar, c cVar2, int i2);
        }

        /* renamed from: com.xiaomi.push.service.av$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0523b extends XMPushService.i {

            /* renamed from: a  reason: collision with other field name */
            public String f913a;

            /* renamed from: b  reason: collision with root package name */
            public int f41752b;

            /* renamed from: b  reason: collision with other field name */
            public String f914b;

            /* renamed from: c  reason: collision with root package name */
            public int f41753c;

            public C0523b() {
                super(0);
            }

            public XMPushService.i a(int i2, int i3, String str, String str2) {
                this.f41752b = i2;
                this.f41753c = i3;
                this.f914b = str2;
                this.f913a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.f41752b, this.f41753c, this.f914b)) {
                    b.this.a(this.f41752b, this.f41753c, this.f913a, this.f914b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.f41748g);
            }
        }

        /* loaded from: classes7.dex */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            public final Messenger f41754a;

            /* renamed from: a  reason: collision with other field name */
            public final b f915a;

            public c(b bVar, Messenger messenger) {
                this.f915a = bVar;
                this.f41754a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f915a.f41748g);
                b.this.f904a.a(new ax(this, 0), 0L);
                if ("9".equals(this.f915a.f41748g) && "com.xiaomi.xmsf".equals(b.this.f904a.getPackageName())) {
                    b.this.f904a.a(new ay(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f904a = xMPushService;
            a(new aw(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) {
            c cVar = this.f906a;
            this.f41743b = cVar;
            if (i2 == 2) {
                this.f907a.a(this.f900a, this, i3);
            } else if (i2 == 3) {
                this.f907a.a(this.f900a, this, str2, str);
            } else if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f41742a++;
                } else if (z) {
                    this.f41742a = 0;
                    if (this.f902a != null) {
                        try {
                            this.f902a.send(Message.obtain(null, 16, this.f904a.f838a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f907a.a(this.f904a, this, z, i3, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i2, int i3, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            c cVar = this.f41743b;
            if (cVar == null || !(z = this.f912b)) {
                return true;
            }
            if (cVar == this.f906a) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else if (this.f902a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.f41748g);
                return true;
            } else {
                sb = new StringBuilder();
                str2 = "peer died, ignore notify ";
            }
            sb.append(str2);
            sb.append(this.f41748g);
            com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
            return false;
        }

        private boolean b(int i2, int i3, String str) {
            if (i2 == 1) {
                return (this.f906a == c.binded || !this.f904a.m553c() || i3 == 21 || (i3 == 7 && "wait".equals(str))) ? false : true;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return false;
                }
                return !"wait".equals(str);
            } else {
                return this.f904a.m553c();
            }
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f41742a + 1) * 15)) * 1000;
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m593a() {
            try {
                Messenger messenger = this.f902a;
                if (messenger != null && this.f901a != null) {
                    messenger.getBinder().unlinkToDeath(this.f901a, 0);
                }
            } catch (Exception unused) {
            }
            this.f41743b = null;
        }

        public void a(Messenger messenger) {
            m593a();
            try {
                if (messenger != null) {
                    this.f902a = messenger;
                    this.f912b = true;
                    this.f901a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f901a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.f41748g);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e2.getMessage());
                this.f902a = null;
                this.f912b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f909a) {
                this.f909a.add(aVar);
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            synchronized (this.f909a) {
                for (a aVar : this.f909a) {
                    aVar.a(this.f906a, cVar, i3);
                }
            }
            c cVar2 = this.f906a;
            int i4 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m56a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), az.a(i3), str, str2, this.f41748g));
                this.f906a = cVar;
            }
            if (this.f907a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.f41743b != null && (z = this.f912b)) {
                    i4 = (this.f902a == null || !z) ? 10100 : 1000;
                }
                this.f904a.b(this.f905a);
                if (b(i2, i3, str2)) {
                    a(i2, i3, str, str2);
                } else {
                    this.f904a.a(this.f905a.a(i2, i3, str, str2), i4);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f909a) {
                this.f909a.remove(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    public static synchronized av a() {
        av avVar;
        synchronized (av.class) {
            if (f41741a == null) {
                f41741a = new av();
            }
            avVar = f41741a;
        }
        return avVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m585a() {
        return this.f899a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap = this.f899a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m586a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f899a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m587a(String str) {
        if (this.f899a.containsKey(str)) {
            return ((HashMap) this.f899a.get(str).clone()).values();
        }
        return new ArrayList();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m588a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f899a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f908a)) {
                    arrayList.add(bVar.f41748g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m589a() {
        Iterator<b> it = m586a().iterator();
        while (it.hasNext()) {
            it.next().m593a();
        }
        this.f899a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f899a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i2) {
        for (HashMap<String, b> hashMap : this.f899a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i2, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f898a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f899a.get(bVar.f41748g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f899a.put(bVar.f41748g, hashMap);
        }
        hashMap.put(a(bVar.f911b), bVar);
        for (a aVar : this.f898a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m590a(String str) {
        HashMap<String, b> hashMap = this.f899a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m593a();
            }
            hashMap.clear();
            this.f899a.remove(str);
        }
        for (a aVar : this.f898a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m591a(String str, String str2) {
        HashMap<String, b> hashMap = this.f899a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m593a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f899a.remove(str);
            }
        }
        for (a aVar : this.f898a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f898a.clear();
    }
}
