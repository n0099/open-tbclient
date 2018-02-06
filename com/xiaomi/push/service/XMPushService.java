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
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.i;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class XMPushService extends Service implements com.xiaomi.smack.d {
    public static int b;
    private static final int g = Process.myPid();
    private com.xiaomi.smack.b c;
    private ar d;
    private e e;
    private com.xiaomi.slim.f h;
    private com.xiaomi.smack.a i;
    private com.xiaomi.push.service.b j;
    private long f = 0;
    private PacketSync k = null;
    private com.xiaomi.push.service.i l = null;
    private com.xiaomi.smack.f m = new az(this);
    final BroadcastReceiver a = new bg(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends h {
        ak.b b;

        public a(ak.b bVar) {
            super(9);
            this.b = null;
            this.b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            try {
                if (XMPushService.this.f()) {
                    ak.b b = ak.a().b(this.b.h, this.b.b);
                    if (b == null) {
                        com.xiaomi.channel.commonutils.logger.b.a("ignore bind because the channel " + this.b.h + " is removed ");
                    } else if (b.m == ak.c.unbind) {
                        b.a(ak.c.binding, 0, 0, null, null);
                        XMPushService.this.i.a(b);
                        com.xiaomi.stats.h.a(XMPushService.this, b);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.a("trying duplicate bind, ingore! " + b.m);
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                }
            } catch (com.xiaomi.smack.l e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "bind the client. " + this.b.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends h {
        private final ak.b b;

        public b(ak.b bVar) {
            super(12);
            this.b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            this.b.a(ak.c.unbind, 1, 21, null, null);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "bind time out. chid=" + this.b.h;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return TextUtils.equals(((b) obj).b.h, this.b.h);
            }
            return false;
        }

        public int hashCode() {
            return this.b.h.hashCode();
        }
    }

    /* loaded from: classes2.dex */
    class c extends h {
        private com.xiaomi.slim.b c;

        public c(com.xiaomi.slim.b bVar) {
            super(8);
            this.c = null;
            this.c = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            XMPushService.this.k.a(this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "receive a message.";
        }
    }

    /* loaded from: classes2.dex */
    public class d extends h {
        /* JADX INFO: Access modifiers changed from: package-private */
        public d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            if (XMPushService.this.b()) {
                XMPushService.this.o();
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("should not connect. quit the job.");
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "do reconnect..";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.k();
        }
    }

    /* loaded from: classes2.dex */
    public class f extends h {
        public int b;
        public Exception c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, Exception exc) {
            super(2);
            this.b = i;
            this.c = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            XMPushService.this.a(this.b, this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "disconnect the connection.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends h {
        private Intent c;

        public g(Intent intent) {
            super(15);
            this.c = null;
            this.c = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            XMPushService.this.c(this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "Handle intent action = " + this.c.getAction();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class h extends i.b {
        public h(int i) {
            super(i);
        }

        public abstract void a();

        public abstract String b();

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != 4 && this.a != 8) {
                com.xiaomi.channel.commonutils.logger.b.a("JOB: " + b());
            }
            a();
        }
    }

    /* loaded from: classes2.dex */
    class i extends h {
        public i() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            XMPushService.this.l.b();
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "ask the job queue to quit";
        }
    }

    /* loaded from: classes2.dex */
    public class j extends Binder {
        public j() {
        }
    }

    /* loaded from: classes2.dex */
    class k extends h {
        private com.xiaomi.smack.packet.d c;

        public k(com.xiaomi.smack.packet.d dVar) {
            super(8);
            this.c = null;
            this.c = dVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            XMPushService.this.k.a(this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "receive a message.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l extends h {
        boolean b;

        public l(boolean z) {
            super(4);
            this.b = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            if (XMPushService.this.f()) {
                try {
                    if (!this.b) {
                        com.xiaomi.stats.h.a();
                    }
                    XMPushService.this.i.b(this.b);
                } catch (com.xiaomi.smack.l e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "send ping..";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m extends h {
        ak.b b;

        public m(ak.b bVar) {
            super(4);
            this.b = null;
            this.b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            try {
                this.b.a(ak.c.unbind, 1, 16, null, null);
                XMPushService.this.i.a(this.b.h, this.b.b);
                this.b.a(ak.c.binding, 1, 16, null, null);
                XMPushService.this.i.a(this.b);
            } catch (com.xiaomi.smack.l e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "rebind the client. " + this.b.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class n extends h {
        n() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.b()) {
                XMPushService.this.o();
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "reset the connection.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o extends h {
        ak.b b;
        int c;
        String d;
        String e;

        public o(ak.b bVar, int i, String str, String str2) {
            super(9);
            this.b = null;
            this.b = bVar;
            this.c = i;
            this.d = str;
            this.e = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public void a() {
            if (this.b.m != ak.c.unbind && XMPushService.this.i != null) {
                try {
                    XMPushService.this.i.a(this.b.h, this.b.b);
                } catch (com.xiaomi.smack.l e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.b.a(ak.c.unbind, this.c, 0, this.e, this.d);
        }

        @Override // com.xiaomi.push.service.XMPushService.h
        public String b() {
            return "unbind the channel. " + this.b.h;
        }
    }

    static {
        HostManager.addReservedHost("app.chat.xiaomi.net", "app.chat.xiaomi.net");
        HostManager.addReservedHost("app.chat.xiaomi.net", "42.62.94.2:443");
        HostManager.addReservedHost("app.chat.xiaomi.net", "114.54.23.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.13.142.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.206.200.2");
        b = 1;
    }

    @TargetApi(11)
    public static Notification a(Context context) {
        Intent intent = new Intent(context, XMPushService.class);
        if (Build.VERSION.SDK_INT < 11) {
            Notification notification = new Notification();
            notification.setLatestEventInfo(context, "Push Service", "Push Service", PendingIntent.getService(context, 0, intent, 0));
            return notification;
        }
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(context.getApplicationInfo().icon);
        builder.setContentTitle("Push Service");
        builder.setContentText("Push Service");
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
        return builder.getNotification();
    }

    private com.xiaomi.smack.packet.c a(com.xiaomi.smack.packet.c cVar, String str) {
        byte[] a2 = aq.a(str, cVar.k());
        com.xiaomi.smack.packet.c cVar2 = new com.xiaomi.smack.packet.c();
        cVar2.n(cVar.n());
        cVar2.m(cVar.m());
        cVar2.k(cVar.k());
        cVar2.l(cVar.l());
        cVar2.b(true);
        String a3 = aq.a(a2, com.xiaomi.smack.util.d.c(cVar.c()));
        com.xiaomi.smack.packet.a aVar = new com.xiaomi.smack.packet.a(NotifyType.SOUND, null, null, null);
        aVar.b(a3);
        cVar2.a(aVar);
        return cVar2;
    }

    private com.xiaomi.smack.packet.d a(com.xiaomi.smack.packet.d dVar, String str, String str2, boolean z) {
        ak a2 = ak.a();
        List<String> b2 = a2.b(str);
        if (b2.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before sending a packet, pkg=" + str);
        } else {
            dVar.o(str);
            String l2 = dVar.l();
            if (TextUtils.isEmpty(l2)) {
                l2 = b2.get(0);
                dVar.l(l2);
            }
            ak.b b3 = a2.b(l2, dVar.n());
            if (!f()) {
                com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not connected, chid=" + l2);
            } else if (b3 == null || b3.m != ak.c.binded) {
                com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not opened, chid=" + l2);
            } else if (TextUtils.equals(str2, b3.j)) {
                return ((dVar instanceof com.xiaomi.smack.packet.c) && z) ? a((com.xiaomi.smack.packet.c) dVar, b3.i) : dVar;
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("invalid session. " + str2);
            }
        }
        return null;
    }

    private void a(Intent intent) {
        com.xiaomi.smack.a h2;
        String stringExtra = intent.getStringExtra(am.y);
        String stringExtra2 = intent.getStringExtra(am.B);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        boolean booleanExtra = intent.getBooleanExtra("ext_encrypt", true);
        com.xiaomi.smack.packet.c cVar = (com.xiaomi.smack.packet.c) a((com.xiaomi.smack.packet.d) new com.xiaomi.smack.packet.c(bundleExtra), stringExtra, stringExtra2, false);
        if (cVar == null) {
            return;
        }
        ak.b b2 = ak.a().b(cVar.l(), cVar.n());
        if (booleanExtra && "3".equals(cVar.l()) && (h2 = h()) != null && h2.a()) {
            c(new as(this, com.xiaomi.slim.b.a(cVar, b2.i)));
            return;
        }
        if (booleanExtra) {
            cVar = a(cVar, b2.i);
        }
        if (cVar != null) {
            c(new as(this, cVar));
        }
    }

    private void a(String str, int i2) {
        Collection<ak.b> c2 = ak.a().c(str);
        if (c2 != null) {
            for (ak.b bVar : c2) {
                if (bVar != null) {
                    a(new o(bVar, i2, null, null));
                }
            }
        }
        ak.a().a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<ak.b> c2 = ak.a().c("5");
        if (c2.isEmpty()) {
            if (z) {
                r.b(str, bArr);
            }
        } else if (c2.iterator().next().m == ak.c.binded) {
            c(new bm(this, 4, str, bArr));
        } else if (z) {
            r.b(str, bArr);
        }
    }

    public static boolean a(int i2, String str) {
        if (TextUtils.equals(str, "Enter") && i2 == 1) {
            return true;
        }
        return TextUtils.equals(str, "Leave") && i2 == 2;
    }

    private boolean a(String str, Intent intent) {
        ak.b b2 = ak.a().b(str, intent.getStringExtra(am.p));
        boolean z = false;
        if (b2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(am.B);
        String stringExtra2 = intent.getStringExtra(am.u);
        if (!TextUtils.isEmpty(b2.j) && !TextUtils.equals(stringExtra, b2.j)) {
            com.xiaomi.channel.commonutils.logger.b.a("session changed. old session=" + b2.j + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(b2.i)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.a("security changed. chid = " + str + " sechash = " + com.xiaomi.channel.commonutils.string.c.a(stringExtra2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, Context context) {
        if (!TextUtils.equals("Leave", str) || TextUtils.equals("Enter", com.xiaomi.push.service.e.a(context).c(str2))) {
            if (com.xiaomi.push.service.e.a(context).a(str2, str) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("update geofence statue failed geo_id:" + str2);
                return false;
            }
            return true;
        }
        return false;
    }

    private ak.b b(String str, Intent intent) {
        ak.b b2 = ak.a().b(str, intent.getStringExtra(am.p));
        if (b2 == null) {
            b2 = new ak.b(this);
        }
        b2.h = intent.getStringExtra(am.q);
        b2.b = intent.getStringExtra(am.p);
        b2.c = intent.getStringExtra(am.s);
        b2.a = intent.getStringExtra(am.y);
        b2.f = intent.getStringExtra(am.w);
        b2.g = intent.getStringExtra(am.x);
        b2.e = intent.getBooleanExtra(am.v, false);
        b2.i = intent.getStringExtra(am.u);
        b2.j = intent.getStringExtra(am.B);
        b2.d = intent.getStringExtra(am.t);
        b2.k = this.j;
        b2.l = getApplicationContext();
        ak.a().a(b2);
        return b2;
    }

    private void b(Intent intent) {
        com.xiaomi.smack.a h2;
        int i2 = 0;
        String stringExtra = intent.getStringExtra(am.y);
        String stringExtra2 = intent.getStringExtra(am.B);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        com.xiaomi.smack.packet.c[] cVarArr = new com.xiaomi.smack.packet.c[parcelableArrayExtra.length];
        boolean booleanExtra = intent.getBooleanExtra("ext_encrypt", true);
        for (int i3 = 0; i3 < parcelableArrayExtra.length; i3++) {
            cVarArr[i3] = new com.xiaomi.smack.packet.c((Bundle) parcelableArrayExtra[i3]);
            cVarArr[i3] = (com.xiaomi.smack.packet.c) a((com.xiaomi.smack.packet.d) cVarArr[i3], stringExtra, stringExtra2, false);
            if (cVarArr[i3] == null) {
                return;
            }
        }
        ak a2 = ak.a();
        if (!booleanExtra || !"3".equals(cVarArr[0].l()) || (h2 = h()) == null || !h2.a()) {
            while (i2 < cVarArr.length) {
                cVarArr[i2] = booleanExtra ? a(cVarArr[i2], a2.b(cVarArr[i2].l(), cVarArr[i2].n()).i) : cVarArr[i2];
                i2++;
            }
            c(new com.xiaomi.push.service.a(this, cVarArr));
            return;
        }
        com.xiaomi.slim.b[] bVarArr = new com.xiaomi.slim.b[cVarArr.length];
        while (i2 < cVarArr.length) {
            com.xiaomi.smack.packet.c cVar = cVarArr[i2];
            bVarArr[i2] = com.xiaomi.slim.b.a(cVar, a2.b(cVar.l(), cVar.n()).i);
            i2++;
        }
        c(new com.xiaomi.push.service.a(this, bVarArr));
    }

    private void b(boolean z) {
        this.f = System.currentTimeMillis();
        if (this.l.d()) {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
            ak.a().a(this, 14);
            stopSelf();
        } else if (!f()) {
            a(true);
        } else if (this.i.o() || com.xiaomi.channel.commonutils.network.d.f(this)) {
            a(new l(z));
        } else {
            a(new f(17, null));
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        String b2;
        int i2;
        ak.b bVar = null;
        boolean z = true;
        boolean z2 = false;
        ak a2 = ak.a();
        if (am.d.equalsIgnoreCase(intent.getAction()) || am.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(am.q);
            if (TextUtils.isEmpty(intent.getStringExtra(am.u))) {
                com.xiaomi.channel.commonutils.logger.b.a("security is empty. ignore.");
            } else if (stringExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
            } else {
                boolean a3 = a(stringExtra, intent);
                ak.b b3 = b(stringExtra, intent);
                if (!com.xiaomi.channel.commonutils.network.d.d(this)) {
                    this.j.a(this, b3, false, 2, null);
                } else if (!f()) {
                    a(true);
                } else if (b3.m == ak.c.unbind) {
                    c(new a(b3));
                } else if (a3) {
                    c(new m(b3));
                } else if (b3.m == ak.c.binding) {
                    com.xiaomi.channel.commonutils.logger.b.a(String.format("the client is binding. %1$s %2$s.", b3.h, b3.b));
                } else if (b3.m == ak.c.binded) {
                    this.j.a(this, b3, true, 0, null);
                }
            }
        } else if (am.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(am.y);
            String stringExtra3 = intent.getStringExtra(am.q);
            String stringExtra4 = intent.getStringExtra(am.p);
            com.xiaomi.channel.commonutils.logger.b.a("Service called closechannel chid = " + stringExtra3 + " userId = " + stringExtra4);
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str : a2.b(stringExtra2)) {
                    a(str, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
            }
        } else if (am.e.equalsIgnoreCase(intent.getAction())) {
            a(intent);
        } else if (am.g.equalsIgnoreCase(intent.getAction())) {
            b(intent);
        } else if (am.f.equalsIgnoreCase(intent.getAction())) {
            String stringExtra5 = intent.getStringExtra(am.y);
            String stringExtra6 = intent.getStringExtra(am.B);
            com.xiaomi.smack.packet.b bVar2 = new com.xiaomi.smack.packet.b(intent.getBundleExtra("ext_packet"));
            if (a((com.xiaomi.smack.packet.d) bVar2, stringExtra5, stringExtra6, false) != null) {
                c(new as(this, bVar2));
            }
        } else if (am.h.equalsIgnoreCase(intent.getAction())) {
            String stringExtra7 = intent.getStringExtra(am.y);
            String stringExtra8 = intent.getStringExtra(am.B);
            com.xiaomi.smack.packet.f fVar = new com.xiaomi.smack.packet.f(intent.getBundleExtra("ext_packet"));
            if (a((com.xiaomi.smack.packet.d) fVar, stringExtra7, stringExtra8, false) != null) {
                c(new as(this, fVar));
            }
        } else if (am.k.equals(intent.getAction())) {
            String stringExtra9 = intent.getStringExtra(am.q);
            String stringExtra10 = intent.getStringExtra(am.p);
            if (stringExtra9 != null) {
                com.xiaomi.channel.commonutils.logger.b.a("request reset connection from chid = " + stringExtra9);
                ak.b b4 = ak.a().b(stringExtra9, stringExtra10);
                if (b4 != null && b4.i.equals(intent.getStringExtra(am.u)) && b4.m == ak.c.binded) {
                    com.xiaomi.smack.a h2 = h();
                    if (h2 == null || !h2.a(System.currentTimeMillis() - 15000)) {
                        c(new n());
                    }
                }
            }
        } else if (am.l.equals(intent.getAction())) {
            String stringExtra11 = intent.getStringExtra(am.y);
            List<String> b5 = a2.b(stringExtra11);
            if (b5.isEmpty()) {
                com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before update info, pkg=" + stringExtra11);
                return;
            }
            String stringExtra12 = intent.getStringExtra(am.q);
            String stringExtra13 = intent.getStringExtra(am.p);
            if (TextUtils.isEmpty(stringExtra12)) {
                stringExtra12 = b5.get(0);
            }
            if (TextUtils.isEmpty(stringExtra13)) {
                Collection<ak.b> c2 = a2.c(stringExtra12);
                if (c2 != null && !c2.isEmpty()) {
                    bVar = c2.iterator().next();
                }
            } else {
                bVar = a2.b(stringExtra12, stringExtra13);
            }
            if (bVar != null) {
                if (intent.hasExtra(am.w)) {
                    bVar.f = intent.getStringExtra(am.w);
                }
                if (intent.hasExtra(am.x)) {
                    bVar.g = intent.getStringExtra(am.x);
                }
            }
        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            if (ao.a(getApplicationContext()).a() && ao.a(getApplicationContext()).b() == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                return;
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            String stringExtra14 = intent.getStringExtra("mipush_app_package");
            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
            int intExtra = intent.getIntExtra("mipush_env_type", 1);
            p.a(this).g(stringExtra14);
            if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                a(byteArrayExtra, stringExtra14);
            } else {
                c(new bk(this, 14, intExtra, byteArrayExtra, stringExtra14));
            }
        } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
            String stringExtra15 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                p.a(this).d(stringExtra15);
            }
            a(stringExtra15, byteArrayExtra2, booleanExtra2);
        } else if (ap.a.equals(intent.getAction())) {
            String stringExtra16 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra16 == null || TextUtils.isEmpty(stringExtra16.trim())) {
                return;
            }
            try {
                getPackageManager().getPackageInfo(stringExtra16, 8192);
                z = false;
            } catch (PackageManager.NameNotFoundException e2) {
            }
            if ("com.xiaomi.channel".equals(stringExtra16) && !ak.a().c("1").isEmpty() && z) {
                a("1", 0);
                com.xiaomi.channel.commonutils.logger.b.a("close the miliao channel as the app is uninstalled.");
                return;
            }
            SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
            String string = sharedPreferences.getString(stringExtra16, null);
            if (TextUtils.isEmpty(string) || !z) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(stringExtra16);
            edit.commit();
            if (ac.e(this, stringExtra16)) {
                ac.d(this, stringExtra16);
            }
            ac.b(this, stringExtra16);
            if (!f() || string == null) {
                return;
            }
            try {
                aa.a(this, aa.a(stringExtra16, string));
                com.xiaomi.channel.commonutils.logger.b.a("uninstall " + stringExtra16 + " msg sent");
            } catch (com.xiaomi.smack.l e3) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                a(10, e3);
            }
        } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
            String stringExtra17 = intent.getStringExtra(am.y);
            int intExtra2 = intent.getIntExtra(am.z, -2);
            if (TextUtils.isEmpty(stringExtra17)) {
                return;
            }
            if (intExtra2 >= -1) {
                ac.a(this, stringExtra17, intExtra2);
            } else {
                ac.a(this, stringExtra17, intent.getStringExtra(am.D), intent.getStringExtra(am.E));
            }
        } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
            String stringExtra18 = intent.getStringExtra(am.y);
            String stringExtra19 = intent.getStringExtra(am.C);
            if (intent.hasExtra(am.A)) {
                i2 = intent.getIntExtra(am.A, 0);
                b2 = com.xiaomi.channel.commonutils.string.c.b(stringExtra18 + i2);
            } else {
                b2 = com.xiaomi.channel.commonutils.string.c.b(stringExtra18);
                i2 = 0;
                z2 = true;
            }
            if (TextUtils.isEmpty(stringExtra18) || !TextUtils.equals(stringExtra19, b2)) {
                com.xiaomi.channel.commonutils.logger.b.d("invalid notification for " + stringExtra18);
            } else if (z2) {
                ac.d(this, stringExtra18);
            } else {
                ac.b(this, stringExtra18, i2);
            }
        } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
            String stringExtra20 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra20)) {
                p.a(this).e(stringExtra20);
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            if (this.e != null) {
                unregisterReceiver(this.e);
                this.e = null;
            }
            this.l.c();
            a(new bl(this, 2));
            ak.a().e();
            ak.a().a(this, 0);
            ak.a().d();
            at.a().b();
            com.xiaomi.push.service.timers.a.a();
        } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
            String stringExtra21 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            String stringExtra22 = intent.getStringExtra("mipush_app_id");
            String stringExtra23 = intent.getStringExtra("mipush_app_token");
            if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                p.a(this).f(stringExtra21);
            }
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                p.a(this).h(stringExtra21);
                p.a(this).i(stringExtra21);
            }
            if (byteArrayExtra3 == null) {
                r.a(this, stringExtra21, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                return;
            }
            r.b(stringExtra21, byteArrayExtra3);
            a(new q(this, stringExtra21, stringExtra22, stringExtra23, byteArrayExtra3));
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.e == null) {
                this.e = new e();
                registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        }
    }

    private void c(h hVar) {
        this.l.a(hVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.channel.commonutils.android.j.d()) {
                if (z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                } else {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private aw.b j() {
        return new bi(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            networkInfo = null;
        }
        if (networkInfo != null) {
            com.xiaomi.channel.commonutils.logger.b.a("network changed, " + networkInfo.toString());
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("network changed, no active network");
        }
        if (com.xiaomi.stats.f.b() != null) {
            com.xiaomi.stats.f.b().b();
        }
        this.h.p();
        if (com.xiaomi.channel.commonutils.network.d.d(this)) {
            if (f() && l()) {
                b(false);
            }
            if (!f() && !g()) {
                this.l.b(1);
                a(new d());
            }
            com.xiaomi.push.log.b.a(this).a();
        } else {
            a(new f(2, null));
        }
        n();
    }

    private boolean l() {
        if (System.currentTimeMillis() - this.f < StatisticConfig.MIN_UPLOAD_INTERVAL) {
            return false;
        }
        return com.xiaomi.channel.commonutils.network.d.e(this);
    }

    private boolean m() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !p.a(this).b(getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!b()) {
            com.xiaomi.push.service.timers.a.a();
        } else if (com.xiaomi.push.service.timers.a.b()) {
        } else {
            com.xiaomi.push.service.timers.a.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.i != null && this.i.j()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
        } else if (this.i != null && this.i.k()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
        } else {
            this.c.a(com.xiaomi.channel.commonutils.network.d.k(this));
            p();
            if (this.i == null) {
                ak.a().a(this);
                c(false);
            }
        }
    }

    private void p() {
        try {
            this.h.a(this.m, new bb(this));
            this.h.r();
            this.i = this.h;
        } catch (com.xiaomi.smack.l e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.h.b(3, e2);
        }
    }

    private boolean q() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ah.a(this).a(com.xiaomi.xmpush.thrift.e.ForegroundServiceSwitch.a(), false);
    }

    private void r() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(g, new Notification());
        } else {
            bindService(new Intent(this, XMJobService.class), new bc(this), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (System.currentTimeMillis() - this.f >= com.xiaomi.smack.g.c() && com.xiaomi.channel.commonutils.network.d.e(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.l.b(i2);
    }

    public void a(int i2, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.a("disconnect " + hashCode() + ", " + (this.i == null ? null : Integer.valueOf(this.i.hashCode())));
        if (this.i != null) {
            this.i.b(i2, exc);
            this.i = null;
        }
        a(7);
        a(4);
        ak.a().a(this, i2);
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.metok.geofencing.state_change");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void a(h hVar) {
        a(hVar, 0L);
    }

    public void a(h hVar, long j2) {
        try {
            this.l.a(hVar, j2);
        } catch (IllegalStateException e2) {
        }
    }

    public void a(ak.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.a("schedule rebind job in " + (a2 / 1000));
            a(new a(bVar), a2);
        }
    }

    public void a(com.xiaomi.slim.b bVar) {
        if (this.i == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        this.i.b(bVar);
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar) {
        com.xiaomi.stats.f.b().a(aVar);
        c(true);
        this.d.a();
        Iterator<ak.b> it = ak.a().b().iterator();
        while (it.hasNext()) {
            a(new a(it.next()));
        }
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar, int i2, Exception exc) {
        com.xiaomi.stats.f.b().a(aVar, i2, exc);
        a(false);
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar, Exception exc) {
        com.xiaomi.stats.f.b().a(aVar, exc);
        c(false);
        a(false);
    }

    public void a(com.xiaomi.smack.packet.d dVar) {
        if (this.i == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        this.i.a(dVar);
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        ak.b b2 = ak.a().b(str, str2);
        if (b2 != null) {
            a(new o(b2, i2, str4, str3));
        }
        ak.a().a(str, str2);
    }

    public void a(boolean z) {
        this.d.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            r.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.a("register request without payload");
            return;
        }
        com.xiaomi.xmpush.thrift.ab abVar = new com.xiaomi.xmpush.thrift.ab();
        try {
            com.xiaomi.xmpush.thrift.aq.a(abVar, bArr);
            if (abVar.a == com.xiaomi.xmpush.thrift.a.Registration) {
                com.xiaomi.xmpush.thrift.af afVar = new com.xiaomi.xmpush.thrift.af();
                try {
                    com.xiaomi.xmpush.thrift.aq.a(afVar, abVar.f());
                    r.a(abVar.j(), bArr);
                    a(new q(this, abVar.j(), afVar.d(), afVar.h(), bArr));
                } catch (org.apache.thrift.f e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    r.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                r.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.a("register request with invalid payload");
            }
        } catch (org.apache.thrift.f e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            r.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(com.xiaomi.slim.b[] bVarArr) {
        if (this.i == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        this.i.a(bVarArr);
    }

    public void a(com.xiaomi.smack.packet.d[] dVarArr) {
        if (this.i == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        this.i.a(dVarArr);
    }

    public void b(h hVar) {
        this.l.a(hVar.a, hVar);
    }

    @Override // com.xiaomi.smack.d
    public void b(com.xiaomi.smack.a aVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        com.xiaomi.stats.f.b().b(aVar);
    }

    public boolean b() {
        return com.xiaomi.channel.commonutils.network.d.d(this) && ak.a().c() > 0 && !c() && m();
    }

    public boolean b(int i2) {
        return this.l.a(i2);
    }

    public boolean c() {
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

    public com.xiaomi.push.service.b d() {
        return new com.xiaomi.push.service.b();
    }

    public com.xiaomi.push.service.b e() {
        return this.j;
    }

    public boolean f() {
        return this.i != null && this.i.k();
    }

    public boolean g() {
        return this.i != null && this.i.j();
    }

    public com.xiaomi.smack.a h() {
        return this.i;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new j();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.xiaomi.channel.commonutils.android.j.a(this);
        com.xiaomi.push.service.n a2 = com.xiaomi.push.service.o.a(this);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.misc.a.a(a2.g);
        }
        an.a(this);
        this.c = new bd(this, null, 5222, "xiaomi.com", null);
        this.c.a(true);
        this.h = new com.xiaomi.slim.f(this, this.c);
        this.j = d();
        try {
            if (com.xiaomi.channel.commonutils.android.j.d()) {
                this.j.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        com.xiaomi.push.service.timers.a.a(this);
        this.h.a(this);
        this.k = new PacketSync(this);
        this.d = new ar(this);
        new com.xiaomi.push.service.c().a();
        com.xiaomi.stats.f.a().a(this);
        this.l = new com.xiaomi.push.service.i("Connection Controller Thread");
        if (m()) {
            a(new be(this, 11));
        }
        ak a3 = ak.a();
        a3.e();
        a3.a(new bf(this));
        if (m()) {
            this.e = new e();
            registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (q()) {
            r();
        }
        if (!getPackageName().equals(com.xiaomi.channel.commonutils.android.b.c(this))) {
            aw a4 = aw.a();
            if (a4.b()) {
                a4.a(this);
            }
            a4.a(j(), "UPLOADER_FROM_XMPUSHSERVICE");
        }
        a(this.a);
        com.xiaomi.channel.commonutils.misc.f.a(this).a((f.a) new com.xiaomi.push.service.d(this), 86400);
        com.xiaomi.channel.commonutils.logger.b.a("XMPushService created pid = " + g);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.e != null) {
            unregisterReceiver(this.e);
        }
        unregisterReceiver(this.a);
        this.l.c();
        a(new ba(this, 2));
        a(new i());
        ak.a().e();
        ak.a().a(this, 15);
        ak.a().d();
        this.h.b(this);
        at.a().b();
        com.xiaomi.push.service.timers.a.a();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.c(String.format("onStart() with intent.Action = %s, chid = %s", intent.getAction(), intent.getStringExtra(am.q)));
        }
        if (intent == null || intent.getAction() == null) {
            return;
        }
        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.a("Service called on timer");
            if (l()) {
                b(false);
            }
        } else if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            if ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                return;
            }
            a(new g(intent));
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("Service called on check alive.");
            if (l()) {
                b(false);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return b;
    }
}
