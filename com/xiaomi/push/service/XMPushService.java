package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.cu;
import com.xiaomi.push.dd;
import com.xiaomi.push.ek;
import com.xiaomi.push.eu;
import com.xiaomi.push.ev;
import com.xiaomi.push.ew;
import com.xiaomi.push.ff;
import com.xiaomi.push.fk;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fp;
import com.xiaomi.push.fr;
import com.xiaomi.push.fs;
import com.xiaomi.push.fx;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gd;
import com.xiaomi.push.gf;
import com.xiaomi.push.gr;
import com.xiaomi.push.gy;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.ic;
import com.xiaomi.push.ig;
import com.xiaomi.push.iq;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class XMPushService extends Service implements fp {
    public static int a;
    private static final int b = Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f810a;

    /* renamed from: a  reason: collision with other field name */
    private fk f812a;

    /* renamed from: a  reason: collision with other field name */
    private fm f813a;

    /* renamed from: a  reason: collision with other field name */
    private fn f814a;

    /* renamed from: a  reason: collision with other field name */
    private e f816a;

    /* renamed from: a  reason: collision with other field name */
    private av f818a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.d f819a;

    /* renamed from: a  reason: collision with other field name */
    private String f822a;

    /* renamed from: a  reason: collision with other field name */
    private long f809a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected Class f821a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private ak f817a = null;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.g f820a = null;

    /* renamed from: a  reason: collision with other field name */
    Messenger f811a = null;

    /* renamed from: a  reason: collision with other field name */
    private Collection<ae> f824a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<l> f823a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private fr f815a = new bh(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends i {

        /* renamed from: a  reason: collision with other field name */
        al.b f825a;

        public a(al.b bVar) {
            super(9);
            this.f825a = null;
            this.f825a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind the client. " + this.f825a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                if (XMPushService.this.m489c()) {
                    al.b a = al.a().a(this.f825a.g, this.f825a.f863b);
                    if (a == null) {
                        com.xiaomi.channel.commonutils.logger.b.m30a("ignore bind because the channel " + this.f825a.g + " is removed ");
                    } else if (a.f858a == al.c.unbind) {
                        a.a(al.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f813a.a(a);
                        ha.a(XMPushService.this, a);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m30a("trying duplicate bind, ingore! " + a.f858a);
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b extends i {
        private final al.b a;

        public b(al.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind time out. chid=" + this.a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            this.a.a(al.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return TextUtils.equals(((b) obj).a.g, this.a.g);
            }
            return false;
        }

        public int hashCode() {
            return this.a.g.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    class c extends i {
        private ff a;

        public c(ff ffVar) {
            super(8);
            this.a = null;
            this.a = ffVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f817a.a(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends i {
        /* JADX INFO: Access modifiers changed from: package-private */
        public d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.m485a()) {
                XMPushService.this.f();
            } else {
                com.xiaomi.channel.commonutils.logger.b.m30a("should not connect. quit the job.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, XMPushService.a);
        }
    }

    /* loaded from: classes3.dex */
    public class f extends i {

        /* renamed from: a  reason: collision with other field name */
        public Exception f827a;
        public int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f827a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(this.b, this.f827a);
        }
    }

    /* loaded from: classes3.dex */
    class g extends i {
        g() {
            super(SupportMenu.USER_MASK);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h extends i {
        private Intent a;

        public h(Intent intent) {
            super(15);
            this.a = null;
            this.a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "Handle intent action = " + this.a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.c(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class i extends g.b {
        public i(int i) {
            super(i);
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m491a();

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != 4 && this.a != 8) {
                com.xiaomi.channel.commonutils.logger.b.m30a("JOB: " + a());
            }
            m491a();
        }
    }

    /* loaded from: classes3.dex */
    class j extends i {
        public j() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f820a.m517a();
        }
    }

    /* loaded from: classes3.dex */
    class k extends i {
        private gd a;

        public k(gd gdVar) {
            super(8);
            this.a = null;
            this.a = gdVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f817a.a(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public interface l {
        /* renamed from: a */
        void mo313a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m extends i {

        /* renamed from: a  reason: collision with other field name */
        boolean f830a;

        public m(boolean z) {
            super(4);
            this.f830a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.m489c()) {
                try {
                    if (!this.f830a) {
                        ha.a();
                    }
                    XMPushService.this.f813a.b(this.f830a);
                } catch (fx e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n extends i {

        /* renamed from: a  reason: collision with other field name */
        al.b f831a;

        public n(al.b bVar) {
            super(4);
            this.f831a = null;
            this.f831a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "rebind the client. " + this.f831a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                this.f831a.a(al.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f813a.a(this.f831a.g, this.f831a.f863b);
                this.f831a.a(al.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.f813a.a(this.f831a);
            } catch (fx e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o extends i {
        o() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m485a()) {
                XMPushService.this.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p extends i {

        /* renamed from: a  reason: collision with other field name */
        al.b f832a;

        /* renamed from: a  reason: collision with other field name */
        String f833a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f834b;

        public p(al.b bVar, int i, String str, String str2) {
            super(9);
            this.f832a = null;
            this.f832a = bVar;
            this.b = i;
            this.f833a = str;
            this.f834b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "unbind the channel. " + this.f832a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (this.f832a.f858a != al.c.unbind && XMPushService.this.f813a != null) {
                try {
                    XMPushService.this.f813a.a(this.f832a.g, this.f832a.f863b);
                } catch (fx e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f832a.a(al.c.unbind, this.b, 0, this.f834b, this.f833a);
        }
    }

    static {
        cu.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
        a = 1;
    }

    @TargetApi(11)
    public static Notification a(Context context) {
        Intent intent = new Intent(context, XMPushService.class);
        if (Build.VERSION.SDK_INT >= 11) {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setSmallIcon(context.getApplicationInfo().icon);
            builder.setContentTitle("Push Service");
            builder.setContentText("Push Service");
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
            return builder.getNotification();
        }
        Notification notification = new Notification();
        try {
            notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, "Push Service", "Push Service", PendingIntent.getService(context, 0, intent, 0));
            return notification;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return notification;
        }
    }

    private gd a(gd gdVar, String str, String str2) {
        al a2 = al.a();
        List<String> m496a = a2.m496a(str);
        if (m496a.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.m30a("open channel should be called first before sending a packet, pkg=" + str);
        } else {
            gdVar.o(str);
            String k2 = gdVar.k();
            if (TextUtils.isEmpty(k2)) {
                k2 = m496a.get(0);
                gdVar.l(k2);
            }
            al.b a3 = a2.a(k2, gdVar.m());
            if (!m489c()) {
                com.xiaomi.channel.commonutils.logger.b.m30a("drop a packet as the channel is not connected, chid=" + k2);
            } else if (a3 == null || a3.f858a != al.c.binded) {
                com.xiaomi.channel.commonutils.logger.b.m30a("drop a packet as the channel is not opened, chid=" + k2);
            } else if (TextUtils.equals(str2, a3.i)) {
                return gdVar;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m30a("invalid session. " + str2);
            }
        }
        return null;
    }

    private al.b a(String str, Intent intent) {
        al.b a2 = al.a().a(str, intent.getStringExtra(ap.p));
        al.b bVar = a2 == null ? new al.b(this) : a2;
        bVar.g = intent.getStringExtra(ap.r);
        bVar.f863b = intent.getStringExtra(ap.p);
        bVar.c = intent.getStringExtra(ap.t);
        bVar.f860a = intent.getStringExtra(ap.z);
        bVar.e = intent.getStringExtra(ap.x);
        bVar.f = intent.getStringExtra(ap.y);
        bVar.f862a = intent.getBooleanExtra(ap.w, false);
        bVar.h = intent.getStringExtra(ap.v);
        bVar.i = intent.getStringExtra(ap.C);
        bVar.d = intent.getStringExtra(ap.u);
        bVar.f859a = this.f819a;
        bVar.a((Messenger) intent.getParcelableExtra(ap.G));
        bVar.f852a = getApplicationContext();
        al.a().a(bVar);
        return bVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m473a() {
        String b2;
        String str = null;
        com.xiaomi.push.ao.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            as a2 = as.a(this);
            b2 = null;
            while (true) {
                if (!TextUtils.isEmpty(b2) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(b2)) {
                    b2 = com.xiaomi.push.l.m464a("ro.miui.region");
                    if (TextUtils.isEmpty(b2)) {
                        b2 = com.xiaomi.push.l.m464a("ro.product.locale.region");
                    }
                }
                try {
                    synchronized (obj) {
                        obj.wait(100L);
                    }
                } catch (InterruptedException e2) {
                }
            }
        } else {
            b2 = com.xiaomi.push.l.b();
        }
        if (!TextUtils.isEmpty(b2)) {
            com.xiaomi.push.service.a.a(getApplicationContext()).b(b2);
            str = com.xiaomi.push.l.a(b2).name();
        }
        com.xiaomi.channel.commonutils.logger.b.m30a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return str;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private void a(Intent intent) {
        ff ffVar;
        String stringExtra = intent.getStringExtra(ap.z);
        String stringExtra2 = intent.getStringExtra(ap.C);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        al a2 = al.a();
        if (bundleExtra != null) {
            gc gcVar = (gc) a(new gc(bundleExtra), stringExtra, stringExtra2);
            if (gcVar == null) {
                return;
            }
            ffVar = ff.a(gcVar, a2.a(gcVar.k(), gcVar.m()).h);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                long longExtra = intent.getLongExtra(ap.p, 0L);
                String stringExtra3 = intent.getStringExtra(ap.q);
                String stringExtra4 = intent.getStringExtra("ext_chid");
                al.b a3 = a2.a(stringExtra4, Long.toString(longExtra));
                if (a3 != null) {
                    ffVar = new ff();
                    try {
                        ffVar.a(Integer.parseInt(stringExtra4));
                    } catch (NumberFormatException e2) {
                    }
                    ffVar.a("SECMSG", (String) null);
                    ffVar.a(longExtra, "xiaomi.com", stringExtra3);
                    ffVar.a(intent.getStringExtra("ext_pkt_id"));
                    ffVar.a(byteArrayExtra, a3.h);
                }
            }
            ffVar = null;
        }
        if (ffVar != null) {
            c(new aw(this, ffVar));
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        Cif cif = new Cif();
        try {
            iq.a(cif, byteArrayExtra);
            com.xiaomi.push.ai.a(getApplicationContext()).a((ai.a) new com.xiaomi.push.service.b(cif, new WeakReference(this), booleanExtra), i2);
        } catch (iw e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(String str, int i2) {
        Collection<al.b> m495a = al.a().m495a(str);
        if (m495a != null) {
            for (al.b bVar : m495a) {
                if (bVar != null) {
                    a(new p(bVar, i2, null, null));
                }
            }
        }
        al.a().m498a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m477a(String str, Intent intent) {
        al.b a2 = al.a().a(str, intent.getStringExtra(ap.p));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(ap.C);
        String stringExtra2 = intent.getStringExtra(ap.v);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m30a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m30a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.ax.a(stringExtra2));
        return true;
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra(ap.z);
        String stringExtra2 = intent.getStringExtra(ap.C);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        gc[] gcVarArr = new gc[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            gcVarArr[i2] = new gc((Bundle) parcelableArrayExtra[i2]);
            gcVarArr[i2] = (gc) a(gcVarArr[i2], stringExtra, stringExtra2);
            if (gcVarArr[i2] == null) {
                return;
            }
        }
        al a2 = al.a();
        ff[] ffVarArr = new ff[gcVarArr.length];
        for (int i3 = 0; i3 < gcVarArr.length; i3++) {
            gc gcVar = gcVarArr[i3];
            ffVarArr[i3] = ff.a(gcVar, a2.a(gcVar.k(), gcVar.m()).h);
        }
        c(new com.xiaomi.push.service.c(this, ffVarArr));
    }

    private void b(boolean z) {
        this.f809a = System.currentTimeMillis();
        if (!m489c()) {
            a(true);
        } else if (this.f813a.m272d() || this.f813a.e() || com.xiaomi.push.as.d(this)) {
            c(new m(z));
        } else {
            c(new f(17, null));
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.xiaomi.push.service.a a2 = com.xiaomi.push.service.a.a(getApplicationContext());
        String a3 = a2.a();
        com.xiaomi.channel.commonutils.logger.b.m30a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = m473a();
        }
        if (TextUtils.isEmpty(a3)) {
            this.f822a = com.xiaomi.push.o.China.name();
        } else {
            this.f822a = a3;
            a2.a(a3);
            if (com.xiaomi.push.o.Global.name().equals(this.f822a)) {
                fn.a("app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.Europe.name().equals(this.f822a)) {
                fn.a("fr.app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.Russia.name().equals(this.f822a)) {
                fn.a("ru.app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.India.name().equals(this.f822a)) {
                fn.a("idmb.app.chat.global.xiaomi.net");
            }
        }
        if (com.xiaomi.push.o.China.name().equals(this.f822a)) {
            fn.a("cn.app.chat.xiaomi.net");
        }
        if (m480g()) {
            bp bpVar = new bp(this, 11);
            a(bpVar);
            com.xiaomi.push.service.l.a(new bq(this, bpVar));
        }
        try {
            if (com.xiaomi.push.t.m547a()) {
                this.f819a.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        String b2;
        int i2;
        al.b bVar = null;
        boolean z = true;
        al a2 = al.a();
        if (ap.d.equalsIgnoreCase(intent.getAction()) || ap.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(ap.r);
            if (TextUtils.isEmpty(intent.getStringExtra(ap.v))) {
                com.xiaomi.channel.commonutils.logger.b.m30a("security is empty. ignore.");
            } else if (stringExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
            } else {
                boolean m477a = m477a(stringExtra, intent);
                al.b a3 = a(stringExtra, intent);
                if (!com.xiaomi.push.as.b(this)) {
                    this.f819a.a(this, a3, false, 2, null);
                } else if (!m489c()) {
                    a(true);
                } else if (a3.f858a == al.c.unbind) {
                    c(new a(a3));
                } else if (m477a) {
                    c(new n(a3));
                } else if (a3.f858a == al.c.binding) {
                    com.xiaomi.channel.commonutils.logger.b.m30a(String.format("the client is binding. %1$s %2$s.", a3.g, al.b.a(a3.f863b)));
                } else if (a3.f858a == al.c.binded) {
                    this.f819a.a(this, a3, true, 0, null);
                }
            }
        } else if (ap.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(ap.z);
            String stringExtra3 = intent.getStringExtra(ap.r);
            String stringExtra4 = intent.getStringExtra(ap.p);
            com.xiaomi.channel.commonutils.logger.b.m30a("Service called close channel chid = " + stringExtra3 + " res = " + al.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str : a2.m496a(stringExtra2)) {
                    a(str, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
            }
        } else if (ap.e.equalsIgnoreCase(intent.getAction())) {
            a(intent);
        } else if (ap.g.equalsIgnoreCase(intent.getAction())) {
            b(intent);
        } else if (ap.f.equalsIgnoreCase(intent.getAction())) {
            gd a4 = a(new gb(intent.getBundleExtra("ext_packet")), intent.getStringExtra(ap.z), intent.getStringExtra(ap.C));
            if (a4 != null) {
                c(new aw(this, ff.a(a4, a2.a(a4.k(), a4.m()).h)));
            }
        } else if (ap.h.equalsIgnoreCase(intent.getAction())) {
            gd a5 = a(new gf(intent.getBundleExtra("ext_packet")), intent.getStringExtra(ap.z), intent.getStringExtra(ap.C));
            if (a5 != null) {
                c(new aw(this, ff.a(a5, a2.a(a5.k(), a5.m()).h)));
            }
        } else if (ap.k.equals(intent.getAction())) {
            String stringExtra5 = intent.getStringExtra(ap.r);
            String stringExtra6 = intent.getStringExtra(ap.p);
            if (stringExtra5 != null) {
                com.xiaomi.channel.commonutils.logger.b.m30a("request reset connection from chid = " + stringExtra5);
                al.b a6 = al.a().a(stringExtra5, stringExtra6);
                if (a6 != null && a6.h.equals(intent.getStringExtra(ap.v)) && a6.f858a == al.c.binded) {
                    fm m482a = m482a();
                    if (m482a == null || !m482a.a(System.currentTimeMillis() - 15000)) {
                        c(new o());
                    }
                }
            }
        } else if (ap.l.equals(intent.getAction())) {
            String stringExtra7 = intent.getStringExtra(ap.z);
            List<String> m496a = a2.m496a(stringExtra7);
            if (m496a.isEmpty()) {
                com.xiaomi.channel.commonutils.logger.b.m30a("open channel should be called first before update info, pkg=" + stringExtra7);
                return;
            }
            String stringExtra8 = intent.getStringExtra(ap.r);
            String stringExtra9 = intent.getStringExtra(ap.p);
            if (TextUtils.isEmpty(stringExtra8)) {
                stringExtra8 = m496a.get(0);
            }
            if (TextUtils.isEmpty(stringExtra9)) {
                Collection<al.b> m495a = a2.m495a(stringExtra8);
                if (m495a != null && !m495a.isEmpty()) {
                    bVar = m495a.iterator().next();
                }
            } else {
                bVar = a2.a(stringExtra8, stringExtra9);
            }
            if (bVar != null) {
                if (intent.hasExtra(ap.x)) {
                    bVar.e = intent.getStringExtra(ap.x);
                }
                if (intent.hasExtra(ap.y)) {
                    bVar.f = intent.getStringExtra(ap.y);
                }
            }
        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            if (as.a(getApplicationContext()).m503a() && as.a(getApplicationContext()).a() == 0) {
                com.xiaomi.channel.commonutils.logger.b.m30a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                return;
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            String stringExtra10 = intent.getStringExtra("mipush_app_package");
            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
            int intExtra = intent.getIntExtra("mipush_env_type", 1);
            com.xiaomi.push.service.m.a(this).d(stringExtra10);
            if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                a(byteArrayExtra, stringExtra10);
            } else {
                c(new br(this, 14, intExtra, byteArrayExtra, stringExtra10));
            }
        } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
            String stringExtra11 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                com.xiaomi.push.service.m.a(this).a(stringExtra11);
            }
            a(stringExtra11, byteArrayExtra2, booleanExtra2);
        } else if (at.a.equals(intent.getAction())) {
            String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra12 == null || TextUtils.isEmpty(stringExtra12.trim())) {
                return;
            }
            try {
                getPackageManager().getPackageInfo(stringExtra12, 0);
                z = false;
            } catch (PackageManager.NameNotFoundException e2) {
            }
            if ("com.xiaomi.channel".equals(stringExtra12) && !al.a().m495a("1").isEmpty() && z) {
                a("1", 0);
                com.xiaomi.channel.commonutils.logger.b.m30a("close the miliao channel as the app is uninstalled.");
                return;
            }
            SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
            String string = sharedPreferences.getString(stringExtra12, null);
            if (TextUtils.isEmpty(string) || !z) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(stringExtra12);
            edit.commit();
            if (z.m542b((Context) this, stringExtra12)) {
                z.m541b((Context) this, stringExtra12);
            }
            z.m536a((Context) this, stringExtra12);
            if (!m489c() || string == null) {
                return;
            }
            try {
                w.a(this, w.a(stringExtra12, string));
                com.xiaomi.channel.commonutils.logger.b.m30a("uninstall " + stringExtra12 + " msg sent");
            } catch (fx e3) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                a(10, e3);
            }
        } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
            String stringExtra13 = intent.getStringExtra(ap.z);
            int intExtra2 = intent.getIntExtra(ap.A, -2);
            if (TextUtils.isEmpty(stringExtra13)) {
                return;
            }
            if (intExtra2 >= -1) {
                z.a(this, stringExtra13, intExtra2);
            } else {
                z.a(this, stringExtra13, intent.getStringExtra(ap.E), intent.getStringExtra(ap.F));
            }
        } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
            String stringExtra14 = intent.getStringExtra(ap.z);
            String stringExtra15 = intent.getStringExtra(ap.D);
            if (intent.hasExtra(ap.B)) {
                i2 = intent.getIntExtra(ap.B, 0);
                b2 = com.xiaomi.push.ax.b(stringExtra14 + i2);
            } else {
                b2 = com.xiaomi.push.ax.b(stringExtra14);
                i2 = 0;
                r3 = true;
            }
            if (TextUtils.isEmpty(stringExtra14) || !TextUtils.equals(stringExtra15, b2)) {
                com.xiaomi.channel.commonutils.logger.b.d("invalid notification for " + stringExtra14);
            } else if (r3) {
                z.m541b((Context) this, stringExtra14);
            } else {
                z.b(this, stringExtra14, i2);
            }
        } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
            String stringExtra16 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra16)) {
                com.xiaomi.push.service.m.a(this).b(stringExtra16);
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            a(19, (Exception) null);
            e();
            stopSelf();
        } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
            String stringExtra17 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            String stringExtra18 = intent.getStringExtra("mipush_app_id");
            String stringExtra19 = intent.getStringExtra("mipush_app_token");
            if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                com.xiaomi.push.service.m.a(this).c(stringExtra17);
            }
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                com.xiaomi.push.service.m.a(this).e(stringExtra17);
                com.xiaomi.push.service.m.a(this).f(stringExtra17);
            }
            if (byteArrayExtra3 == null) {
                com.xiaomi.push.service.o.a(this, stringExtra17, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                return;
            }
            com.xiaomi.push.service.o.b(stringExtra17, byteArrayExtra3);
            a(new com.xiaomi.push.service.n(this, stringExtra17, stringExtra18, stringExtra19, byteArrayExtra3));
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f816a == null) {
                this.f816a = new e();
                registerReceiver(this.f816a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
            String stringExtra20 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
            hk hkVar = new hk();
            try {
                iq.a(hkVar, byteArrayExtra4);
                he.a(this).a(hkVar, stringExtra20);
            } catch (iw e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            }
        } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.m30a("Service called on timer");
            ew.a(false);
            if (m478e()) {
                b(false);
            }
        } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.m30a("Service called on check alive.");
            if (m478e()) {
                b(false);
            }
        } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.m30a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
            ew.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            d();
        } else if ("action_cr_config".equals(intent.getAction())) {
            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
            Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(com.xiaomi.push.be.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                return;
            }
            eu.a(getApplicationContext(), build);
        } else if (!"action_help_ping".equals(intent.getAction())) {
            if ("action_aw_app_logic".equals(intent.getAction())) {
                d(intent);
            }
        } else {
            boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
            int intExtra3 = intent.getIntExtra("extra_help_ping_frequency", 0);
            if (intExtra3 >= 0 && intExtra3 < 30) {
                com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                intExtra3 = 30;
            }
            r3 = intExtra3 >= 0 ? booleanExtra6 : false;
            com.xiaomi.channel.commonutils.logger.b.m30a("aw_ping: receive a aw_ping message. switch: " + r3 + " frequency: " + intExtra3);
            if (!r3 || intExtra3 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            a(intent, intExtra3);
        }
    }

    private void c(i iVar) {
        this.f820a.a(iVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.t.m547a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ae aeVar : (ae[]) this.f824a.toArray(new ae[0])) {
                    aeVar.mo516a();
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void d() {
        NetworkInfo networkInfo;
        StringBuilder sb;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            networkInfo = null;
        }
        if (networkInfo != null) {
            new StringBuilder("[").append("type: ").append(networkInfo.getTypeName()).append("[").append(networkInfo.getSubtypeName()).append("], state: ").append(networkInfo.getState()).append("/").append(networkInfo.getDetailedState());
            com.xiaomi.channel.commonutils.logger.b.m30a("network changed," + sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m30a("network changed, no active network");
        }
        if (gy.a() != null) {
            gy.a().m305a();
        }
        gr.m302a((Context) this);
        this.f812a.d();
        if (com.xiaomi.push.as.b(this)) {
            if (m489c() && m478e()) {
                b(false);
            }
            if (!m489c() && !m490d()) {
                this.f820a.a(1);
                a(new d());
            }
            dd.a(this).a();
        } else {
            a(new f(2, null));
        }
        e();
    }

    private void d(Intent intent) {
        int i2;
        try {
            ek.a(getApplicationContext()).a(new ar());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            Cif cif = new Cif();
            iq.a(cif, byteArrayExtra);
            String b2 = cif.b();
            Map<String, String> m399a = cif.m399a();
            if (m399a != null) {
                String str = m399a.get("extra_help_aw_info");
                String str2 = m399a.get("extra_aw_app_online_cmd");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException e2) {
                    i2 = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
                    return;
                }
                ek.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
            }
        } catch (iw e3) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m485a()) {
            ew.a();
        } else if (ew.m246a()) {
        } else {
            ew.a(true);
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m478e() {
        if (System.currentTimeMillis() - this.f809a < StatisticConfig.MIN_UPLOAD_INTERVAL) {
            return false;
        }
        return com.xiaomi.push.as.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f813a != null && this.f813a.m270b()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
        } else if (this.f813a != null && this.f813a.m271c()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
        } else {
            this.f814a.b(com.xiaomi.push.as.m115a((Context) this));
            g();
            if (this.f813a == null) {
                al.a().a(this);
                c(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f  reason: collision with other method in class */
    public boolean m479f() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    private void g() {
        try {
            this.f812a.a(this.f815a, new bj(this));
            this.f812a.e();
            this.f813a = this.f812a;
        } catch (fx e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f812a.b(3, e2);
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private boolean m480g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !com.xiaomi.push.service.m.a(this).m531b(getPackageName());
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(b, new Notification());
        } else {
            bindService(new Intent(this, this.f821a), new bk(this), 1);
        }
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m481h() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ag.a(this).a(hl.ForegroundServiceSwitch.a(), false);
    }

    private void i() {
        synchronized (this.f823a) {
            this.f823a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fm m482a() {
        return this.f813a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.d m483a() {
        return new com.xiaomi.push.service.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m484a() {
        if (System.currentTimeMillis() - this.f809a >= fs.a() && com.xiaomi.push.as.c(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f820a.a(i2);
    }

    public void a(int i2, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.m30a("disconnect " + hashCode() + ", " + (this.f813a == null ? null : Integer.valueOf(this.f813a.hashCode())));
        if (this.f813a != null) {
            this.f813a.b(i2, exc);
            this.f813a = null;
        }
        a(7);
        a(4);
        al.a().a(this, i2);
    }

    public void a(ff ffVar) {
        if (this.f813a == null) {
            throw new fx("try send msg while connection is null.");
        }
        this.f813a.b(ffVar);
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar) {
        gy.a().a(fmVar);
        c(true);
        this.f818a.m505a();
        Iterator<al.b> it = al.a().m494a().iterator();
        while (it.hasNext()) {
            a(new a(it.next()));
        }
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, int i2, Exception exc) {
        gy.a().a(fmVar, i2, exc);
        a(false);
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, Exception exc) {
        gy.a().a(fmVar, exc);
        c(false);
        a(false);
    }

    public void a(i iVar) {
        a(iVar, 0L);
    }

    public void a(i iVar, long j2) {
        try {
            this.f820a.a(iVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m30a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(l lVar) {
        synchronized (this.f823a) {
            this.f823a.add(lVar);
        }
    }

    public void a(al.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m30a("schedule rebind job in " + (a2 / 1000));
            a(new a(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        al.b a2 = al.a().a(str, str2);
        if (a2 != null) {
            a(new p(a2, i2, str4, str3));
        }
        al.a().m499a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<al.b> m495a = al.a().m495a("5");
        if (m495a.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.o.b(str, bArr);
            }
        } else if (m495a.iterator().next().f858a == al.c.binded) {
            a(new bs(this, 4, str, bArr));
        } else if (z) {
            com.xiaomi.push.service.o.b(str, bArr);
        }
    }

    public void a(boolean z) {
        this.f818a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m30a("register request without payload");
            return;
        }
        ic icVar = new ic();
        try {
            iq.a(icVar, bArr);
            if (icVar.f610a == hg.Registration) {
                ig igVar = new ig();
                try {
                    iq.a(igVar, icVar.m390a());
                    com.xiaomi.push.service.o.a(icVar.b(), bArr);
                    a(new com.xiaomi.push.service.n(this, icVar.b(), igVar.b(), igVar.c(), bArr));
                    ev.a(getApplicationContext()).a(icVar.b(), "E100003", igVar.a(), 6002, "send a register message to server");
                } catch (iw e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m30a("register request with invalid payload");
            }
        } catch (iw e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(ff[] ffVarArr) {
        if (this.f813a == null) {
            throw new fx("try send msg while connection is null.");
        }
        this.f813a.a(ffVarArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a() {
        return com.xiaomi.push.as.b(this) && al.a().m493a() > 0 && !m488b() && m480g() && !m479f();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m486a(int i2) {
        return this.f820a.m519a(i2);
    }

    public com.xiaomi.push.service.d b() {
        return this.f819a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public void m487b() {
        Iterator it = new ArrayList(this.f823a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).mo313a();
        }
    }

    @Override // com.xiaomi.push.fp
    public void b(fm fmVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        gy.a().b(fmVar);
    }

    public void b(i iVar) {
        this.f820a.a(iVar.a, iVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m488b() {
        try {
            Class<?> cls = Class.forName("miui.os.Build");
            Field field = cls.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = cls.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = cls.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m489c() {
        return this.f813a != null && this.f813a.m271c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m490d() {
        return this.f813a != null && this.f813a.m270b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f811a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Uri uriFor;
        super.onCreate();
        com.xiaomi.push.t.m546a((Context) this);
        com.xiaomi.push.service.k a2 = com.xiaomi.push.service.l.a((Context) this);
        if (a2 != null) {
            com.xiaomi.push.ab.a(a2.a);
        }
        this.f811a = new Messenger(new bl(this));
        aq.a(this);
        this.f814a = new bm(this, null, 5222, "xiaomi.com", null);
        this.f814a.a(true);
        this.f812a = new fk(this, this.f814a);
        this.f819a = m483a();
        ew.a(this);
        this.f812a.a(this);
        this.f817a = new ak(this);
        this.f818a = new av(this);
        new com.xiaomi.push.service.e().a();
        gy.m306a().a(this);
        this.f820a = new com.xiaomi.push.service.g("Connection Controller Thread");
        al a3 = al.a();
        a3.b();
        a3.a(new bn(this));
        if (m481h()) {
            h();
        }
        he.a(this).a(new com.xiaomi.push.service.i(this), "UPLOADER_PUSH_CHANNEL");
        a(new hb(this));
        a(new g());
        this.f824a.add(bc.a(this));
        if (m480g()) {
            this.f816a = new e();
            registerReceiver(this.f816a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && (uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE")) != null) {
            this.f810a = new bo(this, new Handler(Looper.getMainLooper()));
            try {
                getContentResolver().registerContentObserver(uriFor, false, this.f810a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m30a("register observer err:" + th.getMessage());
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m30a("XMPushService created pid = " + b);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f816a != null) {
            a(this.f816a);
            this.f816a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f810a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f810a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m30a("unregister observer err:" + th.getMessage());
            }
        }
        this.f824a.clear();
        this.f820a.m520b();
        a(new bi(this, 2));
        a(new j());
        al.a().b();
        al.a().a(this, 15);
        al.a().m497a();
        this.f812a.b(this);
        ba.a().m514a();
        ew.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m30a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.c(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, from-bridge = %s", intent.getAction(), intent.getStringExtra(ap.r), intent.getStringExtra(ap.z), intent.getStringExtra("mipush_app_package"), intent.getStringExtra("ext_is_xmpushservice_bridge")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f820a.m518a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    al.a().a(this, 14);
                    stopSelf();
                } else {
                    a(new h(intent));
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                a(new h(intent));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return a;
    }
}
