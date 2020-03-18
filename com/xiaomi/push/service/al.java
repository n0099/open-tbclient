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
/* loaded from: classes8.dex */
public class al {
    private static al a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f851a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f850a = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f852a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f854a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f856a;

        /* renamed from: a  reason: collision with other field name */
        public d f859a;

        /* renamed from: a  reason: collision with other field name */
        public String f860a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f862a;

        /* renamed from: b  reason: collision with other field name */
        public String f863b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f858a = c.unbind;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f861a = new ArrayList();
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f864b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.b f855a = new XMPushService.b(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f853a = null;

        /* renamed from: a  reason: collision with other field name */
        final C0756b f857a = new C0756b();

        /* loaded from: classes8.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.al$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0756b extends XMPushService.i {

            /* renamed from: a  reason: collision with other field name */
            String f865a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f866b;
            int c;

            public C0756b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f866b = str2;
                this.f865a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.b, this.c, this.f866b)) {
                    b.this.a(this.b, this.c, this.f865a, this.f866b);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public class c implements IBinder.DeathRecipient {
            final Messenger a;

            /* renamed from: a  reason: collision with other field name */
            final b f867a;

            c(b bVar, Messenger messenger) {
                this.f867a = bVar;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f867a.g);
                b.this.f856a.a(new an(this, 0), 0L);
                if ("9".equals(this.f867a.g) && "com.xiaomi.xmsf".equals(b.this.f856a.getPackageName())) {
                    b.this.f856a.a(new ao(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f856a = xMPushService;
            a(new am(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            this.b = this.f858a;
            if (i == 2) {
                this.f859a.a(this.f852a, this, i2);
            } else if (i == 3) {
                this.f859a.a(this.f852a, this, str2, str);
            } else if (i == 1) {
                boolean z = this.f858a == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f854a != null) {
                        try {
                            this.f854a.send(Message.obtain(null, 16, this.f856a.f811a));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.f859a.a(this.f856a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            if (this.b == null || !this.f864b) {
                return true;
            }
            if (this.b == this.f858a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            } else if (this.f854a == null || !this.f864b) {
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
                    if (this.f858a == c.binded || !this.f856a.m504c() || i2 == 21) {
                        return false;
                    }
                    return (i2 == 7 && "wait".equals(str)) ? false : true;
                case 2:
                    return this.f856a.m504c();
                case 3:
                    return "wait".equals(str) ? false : true;
                default:
                    return false;
            }
        }

        public long a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.a + 1) * 15));
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
        void m516a() {
            try {
                Messenger messenger = this.f854a;
                if (messenger != null && this.f853a != null) {
                    messenger.getBinder().unlinkToDeath(this.f853a, 0);
                }
            } catch (Exception e) {
            }
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m516a();
            try {
                if (messenger != null) {
                    this.f854a = messenger;
                    this.f864b = true;
                    this.f853a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f853a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f854a = null;
                this.f864b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f861a) {
                this.f861a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            synchronized (this.f861a) {
                for (a aVar : this.f861a) {
                    aVar.a(this.f858a, cVar, i2);
                }
            }
            if (this.f858a != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m45a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.f858a, cVar, a(i), ap.a(i2), str, str2, this.g));
                this.f858a = cVar;
            }
            if (this.f859a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                int i3 = Constants.REQUEST_API;
                if (this.b == null || !this.f864b) {
                    i3 = 0;
                } else if (this.f854a != null && this.f864b) {
                    i3 = 1000;
                }
                this.f856a.b(this.f857a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f856a.a(this.f857a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f861a) {
                this.f861a.remove(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    private al() {
    }

    public static synchronized al a() {
        al alVar;
        synchronized (al.class) {
            if (a == null) {
                a = new al();
            }
            alVar = a;
        }
        return alVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m508a() {
        return this.f851a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap;
        hashMap = this.f851a.get(str);
        return hashMap == null ? null : hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m509a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f851a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m510a(String str) {
        return !this.f851a.containsKey(str) ? new ArrayList<>() : ((HashMap) this.f851a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m511a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f851a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f860a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m512a() {
        Iterator<b> it = m509a().iterator();
        while (it.hasNext()) {
            it.next().m516a();
        }
        this.f851a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f851a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f851a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f850a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f851a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f851a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f863b), bVar);
        for (a aVar : this.f850a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m513a(String str) {
        HashMap<String, b> hashMap = this.f851a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m516a();
            }
            hashMap.clear();
            this.f851a.remove(str);
        }
        for (a aVar : this.f850a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m514a(String str, String str2) {
        HashMap<String, b> hashMap = this.f851a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m516a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f851a.remove(str);
            }
        }
        for (a aVar : this.f850a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f850a.clear();
    }
}
