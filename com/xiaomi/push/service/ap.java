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
/* loaded from: classes12.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static ap f5056a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f848a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f847a = new ArrayList();

    /* loaded from: classes12.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f849a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f851a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f853a;

        /* renamed from: a  reason: collision with other field name */
        public d f856a;

        /* renamed from: a  reason: collision with other field name */
        public String f857a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f859a;

        /* renamed from: b  reason: collision with other field name */
        public String f860b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f855a = c.unbind;

        /* renamed from: a  reason: collision with root package name */
        private int f5057a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f858a = new ArrayList();
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f861b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.b f852a = new XMPushService.b(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f850a = null;

        /* renamed from: a  reason: collision with other field name */
        final C1036b f854a = new C1036b();

        /* loaded from: classes12.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.ap$b$b  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C1036b extends XMPushService.i {

            /* renamed from: a  reason: collision with other field name */
            String f862a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f863b;
            int c;

            public C1036b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f863b = str2;
                this.f862a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.b, this.c, this.f863b)) {
                    b.this.a(this.b, this.c, this.f862a, this.f863b);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes12.dex */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            final Messenger f5059a;

            /* renamed from: a  reason: collision with other field name */
            final b f864a;

            c(b bVar, Messenger messenger) {
                this.f864a = bVar;
                this.f5059a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f864a.g);
                b.this.f853a.a(new ar(this, 0), 0L);
                if ("9".equals(this.f864a.g) && "com.xiaomi.xmsf".equals(b.this.f853a.getPackageName())) {
                    b.this.f853a.a(new as(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f853a = xMPushService;
            a(new aq(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            this.b = this.f855a;
            if (i == 2) {
                this.f856a.a(this.f849a, this, i2);
            } else if (i == 3) {
                this.f856a.a(this.f849a, this, str2, str);
            } else if (i == 1) {
                boolean z = this.f855a == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f5057a++;
                } else if (z) {
                    this.f5057a = 0;
                    if (this.f851a != null) {
                        try {
                            this.f851a.send(Message.obtain(null, 16, this.f853a.f797a));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.f856a.a(this.f853a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            if (this.b == null || !this.f861b) {
                return true;
            }
            if (this.b == this.f855a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            } else if (this.f851a == null || !this.f861b) {
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
                    if (this.f855a == c.binded || !this.f853a.m526c() || i2 == 21) {
                        return false;
                    }
                    return (i2 == 7 && "wait".equals(str)) ? false : true;
                case 2:
                    return this.f853a.m526c();
                case 3:
                    return "wait".equals(str) ? false : true;
                default:
                    return false;
            }
        }

        public long a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f5057a + 1) * 15));
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
        void m551a() {
            try {
                Messenger messenger = this.f851a;
                if (messenger != null && this.f850a != null) {
                    messenger.getBinder().unlinkToDeath(this.f850a, 0);
                }
            } catch (Exception e) {
            }
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m551a();
            try {
                if (messenger != null) {
                    this.f851a = messenger;
                    this.f861b = true;
                    this.f850a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f850a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f851a = null;
                this.f861b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f858a) {
                this.f858a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            synchronized (this.f858a) {
                for (a aVar : this.f858a) {
                    aVar.a(this.f855a, cVar, i2);
                }
            }
            if (this.f855a != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m54a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.f855a, cVar, a(i), at.a(i2), str, str2, this.g));
                this.f855a = cVar;
            }
            if (this.f856a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                int i3 = Constants.REQUEST_API;
                if (this.b == null || !this.f861b) {
                    i3 = 0;
                } else if (this.f851a != null && this.f861b) {
                    i3 = 1000;
                }
                this.f853a.b(this.f854a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f853a.a(this.f854a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f858a) {
                this.f858a.remove(aVar);
            }
        }
    }

    /* loaded from: classes12.dex */
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
            if (f5056a == null) {
                f5056a = new ap();
            }
            apVar = f5056a;
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
    public synchronized int m543a() {
        return this.f848a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap;
        hashMap = this.f848a.get(str);
        return hashMap == null ? null : hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m544a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f848a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m545a(String str) {
        return !this.f848a.containsKey(str) ? new ArrayList<>() : ((HashMap) this.f848a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m546a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f848a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f857a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m547a() {
        Iterator<b> it = m544a().iterator();
        while (it.hasNext()) {
            it.next().m551a();
        }
        this.f848a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f848a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f848a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f847a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f848a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f848a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f860b), bVar);
        for (a aVar : this.f847a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m548a(String str) {
        HashMap<String, b> hashMap = this.f848a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m551a();
            }
            hashMap.clear();
            this.f848a.remove(str);
        }
        for (a aVar : this.f847a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m549a(String str, String str2) {
        HashMap<String, b> hashMap = this.f848a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m551a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f848a.remove(str);
            }
        }
        for (a aVar : this.f847a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f847a.clear();
    }
}
