package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes18.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static ap f5058a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f853a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f852a = new ArrayList();

    /* loaded from: classes18.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f854a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f856a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f858a;

        /* renamed from: a  reason: collision with other field name */
        public d f861a;

        /* renamed from: a  reason: collision with other field name */
        public String f862a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f864a;

        /* renamed from: b  reason: collision with other field name */
        public String f865b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f860a = c.unbind;

        /* renamed from: a  reason: collision with root package name */
        private int f5059a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f863a = new ArrayList();
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f866b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.b f857a = new XMPushService.b(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f855a = null;

        /* renamed from: a  reason: collision with other field name */
        final C1059b f859a = new C1059b();

        /* loaded from: classes18.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.ap$b$b  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public class C1059b extends XMPushService.i {

            /* renamed from: a  reason: collision with other field name */
            String f867a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f868b;
            int c;

            public C1059b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f868b = str2;
                this.f867a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.b, this.c, this.f868b)) {
                    b.this.a(this.b, this.c, this.f867a, this.f868b);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes18.dex */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            final Messenger f5061a;

            /* renamed from: a  reason: collision with other field name */
            final b f869a;

            c(b bVar, Messenger messenger) {
                this.f869a = bVar;
                this.f5061a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f869a.g);
                b.this.f858a.a(new ar(this, 0), 0L);
                if ("9".equals(this.f869a.g) && "com.xiaomi.xmsf".equals(b.this.f858a.getPackageName())) {
                    b.this.f858a.a(new as(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f858a = xMPushService;
            a(new aq(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            this.b = this.f860a;
            if (i == 2) {
                this.f861a.a(this.f854a, this, i2);
            } else if (i == 3) {
                this.f861a.a(this.f854a, this, str2, str);
            } else if (i == 1) {
                boolean z = this.f860a == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f5059a++;
                } else if (z) {
                    this.f5059a = 0;
                    if (this.f856a != null) {
                        try {
                            this.f856a.send(Message.obtain(null, 16, this.f858a.f802a));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.f861a.a(this.f858a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            if (this.b == null || !this.f866b) {
                return true;
            }
            if (this.b == this.f860a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            } else if (this.f856a == null || !this.f866b) {
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
                    if (this.f860a == c.binded || !this.f858a.m529c() || i2 == 21) {
                        return false;
                    }
                    return (i2 == 7 && "wait".equals(str)) ? false : true;
                case 2:
                    return this.f858a.m529c();
                case 3:
                    return "wait".equals(str) ? false : true;
                default:
                    return false;
            }
        }

        public long a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f5059a + 1) * 15));
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
        void m554a() {
            try {
                Messenger messenger = this.f856a;
                if (messenger != null && this.f855a != null) {
                    messenger.getBinder().unlinkToDeath(this.f855a, 0);
                }
            } catch (Exception e) {
            }
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m554a();
            try {
                if (messenger != null) {
                    this.f856a = messenger;
                    this.f866b = true;
                    this.f855a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f855a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f856a = null;
                this.f866b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f863a) {
                this.f863a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            synchronized (this.f863a) {
                for (a aVar : this.f863a) {
                    aVar.a(this.f860a, cVar, i2);
                }
            }
            if (this.f860a != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m57a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.f860a, cVar, a(i), at.a(i2), str, str2, this.g));
                this.f860a = cVar;
            }
            if (this.f861a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                int i3 = Constants.REQUEST_API;
                if (this.b == null || !this.f866b) {
                    i3 = 0;
                } else if (this.f856a != null && this.f866b) {
                    i3 = 1000;
                }
                this.f858a.b(this.f859a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f858a.a(this.f859a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f863a) {
                this.f863a.remove(aVar);
            }
        }
    }

    /* loaded from: classes18.dex */
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
            if (f5058a == null) {
                f5058a = new ap();
            }
            apVar = f5058a;
        }
        return apVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(UgcConstant.AT_RULE_TAG);
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m546a() {
        return this.f853a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap;
        hashMap = this.f853a.get(str);
        return hashMap == null ? null : hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m547a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f853a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m548a(String str) {
        return !this.f853a.containsKey(str) ? new ArrayList<>() : ((HashMap) this.f853a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m549a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f853a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f862a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m550a() {
        Iterator<b> it = m547a().iterator();
        while (it.hasNext()) {
            it.next().m554a();
        }
        this.f853a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f853a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f853a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f852a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f853a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f853a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f865b), bVar);
        for (a aVar : this.f852a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m551a(String str) {
        HashMap<String, b> hashMap = this.f853a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m554a();
            }
            hashMap.clear();
            this.f853a.remove(str);
        }
        for (a aVar : this.f852a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m552a(String str, String str2) {
        HashMap<String, b> hashMap = this.f853a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m554a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f853a.remove(str);
            }
        }
        for (a aVar : this.f852a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f852a.clear();
    }
}
