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
/* loaded from: classes8.dex */
public class ap {
    private static ap a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f849a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f848a = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f850a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f852a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f854a;

        /* renamed from: a  reason: collision with other field name */
        public d f857a;

        /* renamed from: a  reason: collision with other field name */
        public String f858a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f860a;

        /* renamed from: b  reason: collision with other field name */
        public String f861b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f856a = c.unbind;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f859a = new ArrayList();
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f862b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.b f853a = new XMPushService.b(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f851a = null;

        /* renamed from: a  reason: collision with other field name */
        final C0861b f855a = new C0861b();

        /* loaded from: classes8.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.ap$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0861b extends XMPushService.i {

            /* renamed from: a  reason: collision with other field name */
            String f863a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f864b;
            int c;

            public C0861b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f864b = str2;
                this.f863a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.b, this.c, this.f864b)) {
                    b.this.a(this.b, this.c, this.f863a, this.f864b);
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
            final b f865a;

            c(b bVar, Messenger messenger) {
                this.f865a = bVar;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f865a.g);
                b.this.f854a.a(new ar(this, 0), 0L);
                if ("9".equals(this.f865a.g) && "com.xiaomi.xmsf".equals(b.this.f854a.getPackageName())) {
                    b.this.f854a.a(new as(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f854a = xMPushService;
            a(new aq(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            this.b = this.f856a;
            if (i == 2) {
                this.f857a.a(this.f850a, this, i2);
            } else if (i == 3) {
                this.f857a.a(this.f850a, this, str2, str);
            } else if (i == 1) {
                boolean z = this.f856a == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f852a != null) {
                        try {
                            this.f852a.send(Message.obtain(null, 16, this.f854a.f798a));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.f857a.a(this.f854a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            if (this.b == null || !this.f862b) {
                return true;
            }
            if (this.b == this.f856a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            } else if (this.f852a == null || !this.f862b) {
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
                    if (this.f856a == c.binded || !this.f854a.m524c() || i2 == 21) {
                        return false;
                    }
                    return (i2 == 7 && "wait".equals(str)) ? false : true;
                case 2:
                    return this.f854a.m524c();
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
        void m549a() {
            try {
                Messenger messenger = this.f852a;
                if (messenger != null && this.f851a != null) {
                    messenger.getBinder().unlinkToDeath(this.f851a, 0);
                }
            } catch (Exception e) {
            }
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m549a();
            try {
                if (messenger != null) {
                    this.f852a = messenger;
                    this.f862b = true;
                    this.f851a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f851a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f852a = null;
                this.f862b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f859a) {
                this.f859a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            synchronized (this.f859a) {
                for (a aVar : this.f859a) {
                    aVar.a(this.f856a, cVar, i2);
                }
            }
            if (this.f856a != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m52a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.f856a, cVar, a(i), at.a(i2), str, str2, this.g));
                this.f856a = cVar;
            }
            if (this.f857a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                int i3 = Constants.REQUEST_API;
                if (this.b == null || !this.f862b) {
                    i3 = 0;
                } else if (this.f852a != null && this.f862b) {
                    i3 = 1000;
                }
                this.f854a.b(this.f855a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f854a.a(this.f855a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f859a) {
                this.f859a.remove(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if (a == null) {
                a = new ap();
            }
            apVar = a;
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
    public synchronized int m541a() {
        return this.f849a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap;
        hashMap = this.f849a.get(str);
        return hashMap == null ? null : hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m542a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f849a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m543a(String str) {
        return !this.f849a.containsKey(str) ? new ArrayList<>() : ((HashMap) this.f849a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m544a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f849a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f858a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m545a() {
        Iterator<b> it = m542a().iterator();
        while (it.hasNext()) {
            it.next().m549a();
        }
        this.f849a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f849a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f849a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f848a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f849a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f849a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f861b), bVar);
        for (a aVar : this.f848a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m546a(String str) {
        HashMap<String, b> hashMap = this.f849a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m549a();
            }
            hashMap.clear();
            this.f849a.remove(str);
        }
        for (a aVar : this.f848a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m547a(String str, String str2) {
        HashMap<String, b> hashMap = this.f849a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m549a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f849a.remove(str);
            }
        }
        for (a aVar : this.f848a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f848a.clear();
    }
}
