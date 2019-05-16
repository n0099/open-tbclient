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
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.k;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class XMPushService extends Service implements com.xiaomi.smack.d {
    public static int d;
    private static final int j = Process.myPid();
    private com.xiaomi.smack.b e;
    private bc f;
    private String g;
    private e h;
    private com.xiaomi.slim.g k;
    private com.xiaomi.smack.a l;
    private com.xiaomi.push.service.d m;
    private long i = 0;
    protected Class a = XMJobService.class;
    private ar n = null;
    private com.xiaomi.push.service.k o = null;
    Messenger b = null;
    private ArrayList<l> p = new ArrayList<>();
    private com.xiaomi.smack.f q = new bn(this);
    final BroadcastReceiver c = new bx(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends i {
        as.b b;

        public a(as.b bVar) {
            super(9);
            this.b = null;
            this.b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                if (XMPushService.this.e()) {
                    as.b b = as.a().b(this.b.h, this.b.b);
                    if (b == null) {
                        com.xiaomi.channel.commonutils.logger.b.a("ignore bind because the channel " + this.b.h + " is removed ");
                    } else if (b.m == as.c.unbind) {
                        b.a(as.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.l.a(b);
                        com.xiaomi.stats.h.a(XMPushService.this, b);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.a("trying duplicate bind, ingore! " + b.m);
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

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "bind the client. " + this.b.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b extends i {
        private final as.b b;

        public b(as.b bVar) {
            super(12);
            this.b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            this.b.a(as.c.unbind, 1, 21, (String) null, (String) null);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
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

    /* loaded from: classes3.dex */
    class c extends i {
        private com.xiaomi.slim.b c;

        public c(com.xiaomi.slim.b bVar) {
            super(8);
            this.c = null;
            this.c = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.n.a(this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "receive a message.";
        }
    }

    /* loaded from: classes3.dex */
    public class d extends i {
        /* JADX INFO: Access modifiers changed from: package-private */
        public d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.a()) {
                XMPushService.this.p();
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("should not connect. quit the job.");
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "do reconnect..";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, XMPushService.d);
        }
    }

    /* loaded from: classes3.dex */
    public class f extends i {
        public int b;
        public Exception c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, Exception exc) {
            super(2);
            this.b = i;
            this.c = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(this.b, this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "disconnect the connection.";
        }
    }

    /* loaded from: classes3.dex */
    class g extends i {
        g() {
            super(SupportMenu.USER_MASK);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.k();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "Init Job";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h extends i {
        private Intent c;

        public h(Intent intent) {
            super(15);
            this.c = null;
            this.c = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.c(this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "Handle intent action = " + this.c.getAction();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class i extends k.b {
        public i(int i) {
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

    /* loaded from: classes3.dex */
    class j extends i {
        public j() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.o.b();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "ask the job queue to quit";
        }
    }

    /* loaded from: classes3.dex */
    class k extends i {
        private com.xiaomi.smack.packet.d c;

        public k(com.xiaomi.smack.packet.d dVar) {
            super(8);
            this.c = null;
            this.c = dVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.n.a(this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "receive a message.";
        }
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m extends i {
        boolean b;

        public m(boolean z) {
            super(4);
            this.b = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.e()) {
                try {
                    if (!this.b) {
                        com.xiaomi.stats.h.a();
                    }
                    XMPushService.this.l.b(this.b);
                } catch (com.xiaomi.smack.l e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "send ping..";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n extends i {
        as.b b;

        public n(as.b bVar) {
            super(4);
            this.b = null;
            this.b = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                this.b.a(as.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.l.a(this.b.h, this.b.b);
                this.b.a(as.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.l.a(this.b);
            } catch (com.xiaomi.smack.l e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "rebind the client. " + this.b.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o extends i {
        o() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.a()) {
                XMPushService.this.p();
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "reset the connection.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p extends i {
        as.b b;
        int c;
        String d;
        String e;

        public p(as.b bVar, int i, String str, String str2) {
            super(9);
            this.b = null;
            this.b = bVar;
            this.c = i;
            this.d = str;
            this.e = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (this.b.m != as.c.unbind && XMPushService.this.l != null) {
                try {
                    XMPushService.this.l.a(this.b.h, this.b.b);
                } catch (com.xiaomi.smack.l e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.b.a(as.c.unbind, this.c, 0, this.e, this.d);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
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
        d = 1;
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

    private com.xiaomi.smack.packet.d a(com.xiaomi.smack.packet.d dVar, String str, String str2) {
        as a2 = as.a();
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
            as.b b3 = a2.b(l2, dVar.n());
            if (!e()) {
                com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not connected, chid=" + l2);
            } else if (b3 == null || b3.m != as.c.binded) {
                com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not opened, chid=" + l2);
            } else if (TextUtils.equals(str2, b3.j)) {
                return dVar;
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("invalid session. " + str2);
            }
        }
        return null;
    }

    private void a(Intent intent) {
        com.xiaomi.slim.b bVar;
        String stringExtra = intent.getStringExtra(aw.z);
        String stringExtra2 = intent.getStringExtra(aw.C);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        as a2 = as.a();
        if (bundleExtra != null) {
            com.xiaomi.smack.packet.c cVar = (com.xiaomi.smack.packet.c) a(new com.xiaomi.smack.packet.c(bundleExtra), stringExtra, stringExtra2);
            if (cVar == null) {
                return;
            }
            bVar = com.xiaomi.slim.b.a(cVar, a2.b(cVar.l(), cVar.n()).i);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                long longExtra = intent.getLongExtra(aw.p, 0L);
                String stringExtra3 = intent.getStringExtra(aw.q);
                String stringExtra4 = intent.getStringExtra("ext_chid");
                as.b b2 = a2.b(stringExtra4, Long.toString(longExtra));
                if (b2 != null) {
                    bVar = new com.xiaomi.slim.b();
                    try {
                        bVar.a(Integer.parseInt(stringExtra4));
                    } catch (NumberFormatException e2) {
                    }
                    bVar.a("SECMSG", (String) null);
                    bVar.a(longExtra, "xiaomi.com", stringExtra3);
                    bVar.a(intent.getStringExtra("ext_pkt_id"));
                    bVar.a(byteArrayExtra, b2.i);
                }
            }
            bVar = null;
        }
        if (bVar != null) {
            c(new bd(this, bVar));
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        try {
            com.xiaomi.xmpush.thrift.at.a(aiVar, byteArrayExtra);
            com.xiaomi.channel.commonutils.misc.h.a(getApplicationContext()).a((h.a) new com.xiaomi.push.service.b(aiVar, new WeakReference(this), booleanExtra), i2);
        } catch (org.apache.thrift.f e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(String str, int i2) {
        Collection<as.b> c2 = as.a().c(str);
        if (c2 != null) {
            for (as.b bVar : c2) {
                if (bVar != null) {
                    a(new p(bVar, i2, null, null));
                }
            }
        }
        as.a().a(str);
    }

    public static boolean a(int i2, String str) {
        if (TextUtils.equals(str, "Enter") && i2 == 1) {
            return true;
        }
        return TextUtils.equals(str, "Leave") && i2 == 2;
    }

    private boolean a(String str, Intent intent) {
        as.b b2 = as.a().b(str, intent.getStringExtra(aw.p));
        boolean z = false;
        if (b2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(aw.C);
        String stringExtra2 = intent.getStringExtra(aw.v);
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
        if (!TextUtils.equals("Leave", str) || TextUtils.equals("Enter", com.xiaomi.push.service.g.a(context).c(str2))) {
            if (com.xiaomi.push.service.g.a(context).a(str2, str) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("update geofence statue failed geo_id:" + str2);
                return false;
            }
            return true;
        }
        return false;
    }

    private as.b b(String str, Intent intent) {
        as.b b2 = as.a().b(str, intent.getStringExtra(aw.p));
        as.b bVar = b2 == null ? new as.b(this) : b2;
        bVar.h = intent.getStringExtra(aw.r);
        bVar.b = intent.getStringExtra(aw.p);
        bVar.c = intent.getStringExtra(aw.t);
        bVar.a = intent.getStringExtra(aw.z);
        bVar.f = intent.getStringExtra(aw.x);
        bVar.g = intent.getStringExtra(aw.y);
        bVar.e = intent.getBooleanExtra(aw.w, false);
        bVar.i = intent.getStringExtra(aw.v);
        bVar.j = intent.getStringExtra(aw.C);
        bVar.d = intent.getStringExtra(aw.u);
        bVar.k = this.m;
        bVar.a((Messenger) intent.getParcelableExtra(aw.G));
        bVar.l = getApplicationContext();
        as.a().a(bVar);
        return bVar;
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra(aw.z);
        String stringExtra2 = intent.getStringExtra(aw.C);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        com.xiaomi.smack.packet.c[] cVarArr = new com.xiaomi.smack.packet.c[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            cVarArr[i2] = new com.xiaomi.smack.packet.c((Bundle) parcelableArrayExtra[i2]);
            cVarArr[i2] = (com.xiaomi.smack.packet.c) a(cVarArr[i2], stringExtra, stringExtra2);
            if (cVarArr[i2] == null) {
                return;
            }
        }
        as a2 = as.a();
        com.xiaomi.slim.b[] bVarArr = new com.xiaomi.slim.b[cVarArr.length];
        for (int i3 = 0; i3 < cVarArr.length; i3++) {
            com.xiaomi.smack.packet.c cVar = cVarArr[i3];
            bVarArr[i3] = com.xiaomi.slim.b.a(cVar, a2.b(cVar.l(), cVar.n()).i);
        }
        c(new com.xiaomi.push.service.c(this, bVarArr));
    }

    private void b(boolean z) {
        this.i = System.currentTimeMillis();
        if (!e()) {
            a(true);
        } else if (this.l.o() || this.l.p() || com.xiaomi.channel.commonutils.network.d.e(this)) {
            c(new m(z));
        } else {
            c(new f(17, null));
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        String b2;
        int i2;
        as.b bVar = null;
        boolean z = true;
        as a2 = as.a();
        if (aw.d.equalsIgnoreCase(intent.getAction()) || aw.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(aw.r);
            if (TextUtils.isEmpty(intent.getStringExtra(aw.v))) {
                com.xiaomi.channel.commonutils.logger.b.a("security is empty. ignore.");
            } else if (stringExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
            } else {
                boolean a3 = a(stringExtra, intent);
                as.b b3 = b(stringExtra, intent);
                if (!com.xiaomi.channel.commonutils.network.d.c(this)) {
                    this.m.a(this, b3, false, 2, null);
                } else if (!e()) {
                    a(true);
                } else if (b3.m == as.c.unbind) {
                    c(new a(b3));
                } else if (a3) {
                    c(new n(b3));
                } else if (b3.m == as.c.binding) {
                    com.xiaomi.channel.commonutils.logger.b.a(String.format("the client is binding. %1$s %2$s.", b3.h, as.b.a(b3.b)));
                } else if (b3.m == as.c.binded) {
                    this.m.a(this, b3, true, 0, null);
                }
            }
        } else if (aw.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(aw.z);
            String stringExtra3 = intent.getStringExtra(aw.r);
            String stringExtra4 = intent.getStringExtra(aw.p);
            com.xiaomi.channel.commonutils.logger.b.a("Service called close channel chid = " + stringExtra3 + " res = " + as.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str : a2.b(stringExtra2)) {
                    a(str, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
            }
        } else if (aw.e.equalsIgnoreCase(intent.getAction())) {
            a(intent);
        } else if (aw.g.equalsIgnoreCase(intent.getAction())) {
            b(intent);
        } else if (aw.f.equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.smack.packet.d a4 = a(new com.xiaomi.smack.packet.b(intent.getBundleExtra("ext_packet")), intent.getStringExtra(aw.z), intent.getStringExtra(aw.C));
            if (a4 != null) {
                c(new bd(this, com.xiaomi.slim.b.a(a4, a2.b(a4.l(), a4.n()).i)));
            }
        } else if (aw.h.equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.smack.packet.d a5 = a(new com.xiaomi.smack.packet.f(intent.getBundleExtra("ext_packet")), intent.getStringExtra(aw.z), intent.getStringExtra(aw.C));
            if (a5 != null) {
                c(new bd(this, com.xiaomi.slim.b.a(a5, a2.b(a5.l(), a5.n()).i)));
            }
        } else if (aw.k.equals(intent.getAction())) {
            String stringExtra5 = intent.getStringExtra(aw.r);
            String stringExtra6 = intent.getStringExtra(aw.p);
            if (stringExtra5 != null) {
                com.xiaomi.channel.commonutils.logger.b.a("request reset connection from chid = " + stringExtra5);
                as.b b4 = as.a().b(stringExtra5, stringExtra6);
                if (b4 != null && b4.i.equals(intent.getStringExtra(aw.v)) && b4.m == as.c.binded) {
                    com.xiaomi.smack.a g2 = g();
                    if (g2 == null || !g2.a(System.currentTimeMillis() - 15000)) {
                        c(new o());
                    }
                }
            }
        } else if (aw.l.equals(intent.getAction())) {
            String stringExtra7 = intent.getStringExtra(aw.z);
            List<String> b5 = a2.b(stringExtra7);
            if (b5.isEmpty()) {
                com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before update info, pkg=" + stringExtra7);
                return;
            }
            String stringExtra8 = intent.getStringExtra(aw.r);
            String stringExtra9 = intent.getStringExtra(aw.p);
            if (TextUtils.isEmpty(stringExtra8)) {
                stringExtra8 = b5.get(0);
            }
            if (TextUtils.isEmpty(stringExtra9)) {
                Collection<as.b> c2 = a2.c(stringExtra8);
                if (c2 != null && !c2.isEmpty()) {
                    bVar = c2.iterator().next();
                }
            } else {
                bVar = a2.b(stringExtra8, stringExtra9);
            }
            if (bVar != null) {
                if (intent.hasExtra(aw.x)) {
                    bVar.f = intent.getStringExtra(aw.x);
                }
                if (intent.hasExtra(aw.y)) {
                    bVar.g = intent.getStringExtra(aw.y);
                }
            }
        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            if (az.a(getApplicationContext()).a() && az.a(getApplicationContext()).b() == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                return;
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            String stringExtra10 = intent.getStringExtra("mipush_app_package");
            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
            int intExtra = intent.getIntExtra("mipush_env_type", 1);
            u.a(this).g(stringExtra10);
            if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                a(byteArrayExtra, stringExtra10);
            } else {
                c(new bz(this, 14, intExtra, byteArrayExtra, stringExtra10));
            }
        } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
            String stringExtra11 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                u.a(this).d(stringExtra11);
            }
            a(stringExtra11, byteArrayExtra2, booleanExtra2);
        } else if (ba.a.equals(intent.getAction())) {
            String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra12 == null || TextUtils.isEmpty(stringExtra12.trim())) {
                return;
            }
            try {
                getPackageManager().getPackageInfo(stringExtra12, 0);
                z = false;
            } catch (PackageManager.NameNotFoundException e2) {
            }
            if ("com.xiaomi.channel".equals(stringExtra12) && !as.a().c("1").isEmpty() && z) {
                a("1", 0);
                com.xiaomi.channel.commonutils.logger.b.a("close the miliao channel as the app is uninstalled.");
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
            if (ah.e(this, stringExtra12)) {
                ah.d(this, stringExtra12);
            }
            ah.b(this, stringExtra12);
            if (!e() || string == null) {
                return;
            }
            try {
                af.a(this, af.a(stringExtra12, string));
                com.xiaomi.channel.commonutils.logger.b.a("uninstall " + stringExtra12 + " msg sent");
            } catch (com.xiaomi.smack.l e3) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                a(10, e3);
            }
        } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
            String stringExtra13 = intent.getStringExtra(aw.z);
            int intExtra2 = intent.getIntExtra(aw.A, -2);
            if (TextUtils.isEmpty(stringExtra13)) {
                return;
            }
            if (intExtra2 >= -1) {
                ah.a(this, stringExtra13, intExtra2);
            } else {
                ah.a(this, stringExtra13, intent.getStringExtra(aw.E), intent.getStringExtra(aw.F));
            }
        } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
            String stringExtra14 = intent.getStringExtra(aw.z);
            String stringExtra15 = intent.getStringExtra(aw.D);
            if (intent.hasExtra(aw.B)) {
                i2 = intent.getIntExtra(aw.B, 0);
                b2 = com.xiaomi.channel.commonutils.string.c.b(stringExtra14 + i2);
            } else {
                b2 = com.xiaomi.channel.commonutils.string.c.b(stringExtra14);
                i2 = 0;
                r3 = true;
            }
            if (TextUtils.isEmpty(stringExtra14) || !TextUtils.equals(stringExtra15, b2)) {
                com.xiaomi.channel.commonutils.logger.b.d("invalid notification for " + stringExtra14);
            } else if (r3) {
                ah.d(this, stringExtra14);
            } else {
                ah.b(this, stringExtra14, i2);
            }
        } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
            String stringExtra16 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra16)) {
                u.a(this).e(stringExtra16);
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            if (this.h != null) {
                unregisterReceiver(this.h);
                this.h = null;
            }
            this.o.c();
            a(new ca(this, 2));
            as.a().e();
            as.a().a(this, 0);
            as.a().d();
            bh.a().b();
            com.xiaomi.push.service.timers.a.a();
        } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
            String stringExtra17 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            String stringExtra18 = intent.getStringExtra("mipush_app_id");
            String stringExtra19 = intent.getStringExtra("mipush_app_token");
            if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                u.a(this).f(stringExtra17);
            }
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                u.a(this).h(stringExtra17);
                u.a(this).i(stringExtra17);
            }
            if (byteArrayExtra3 == null) {
                w.a(this, stringExtra17, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                return;
            }
            w.b(stringExtra17, byteArrayExtra3);
            a(new v(this, stringExtra17, stringExtra18, stringExtra19, byteArrayExtra3));
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.h == null) {
                this.h = new e();
                registerReceiver(this.h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
            String stringExtra20 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
            com.xiaomi.xmpush.thrift.f fVar = new com.xiaomi.xmpush.thrift.f();
            try {
                com.xiaomi.xmpush.thrift.at.a(fVar, byteArrayExtra4);
                com.xiaomi.tinyData.d.a(this).a(fVar, stringExtra20);
            } catch (org.apache.thrift.f e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            }
        } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.a("Service called on timer");
            com.xiaomi.push.service.timers.a.a(false);
            if (m()) {
                b(false);
            }
        } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.a("Service called on check alive.");
            if (m()) {
                b(false);
            }
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            l();
        } else if ("action_cr_config".equals(intent.getAction())) {
            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
            Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(com.xiaomi.clientreport.util.a.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                return;
            }
            com.xiaomi.push.service.clientReport.c.a(getApplicationContext(), build);
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
            com.xiaomi.channel.commonutils.logger.b.a("aw_ping: receive a aw_ping message. switch: " + r3 + " frequency: " + intExtra3);
            if (!r3 || intExtra3 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            a(intent, intExtra3);
        }
    }

    private void c(i iVar) {
        this.o.a(iVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.channel.commonutils.android.n.c()) {
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

    private void d(Intent intent) {
        int i2;
        try {
            com.xiaomi.push.service.awake.module.c.a(getApplicationContext()).a(new ay());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
            com.xiaomi.xmpush.thrift.at.a(aiVar, byteArrayExtra);
            String e2 = aiVar.e();
            Map<String, String> j2 = aiVar.j();
            if (j2 != null) {
                String str = j2.get("extra_help_aw_info");
                String str2 = j2.get("extra_aw_app_online_cmd");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException e3) {
                    i2 = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(e2) || TextUtils.isEmpty(str)) {
                    return;
                }
                com.xiaomi.push.service.awake.module.c.a(getApplicationContext()).a(this, str, i2, stringExtra, e2);
            }
        } catch (org.apache.thrift.f e4) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e4.getMessage());
        }
    }

    private String j() {
        com.xiaomi.channel.commonutils.misc.n.a();
        String str = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            az a2 = az.a(this);
            while (true) {
                if (!TextUtils.isEmpty(str) && a2.b() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str)) {
                    str = com.xiaomi.channel.commonutils.android.f.a("ro.miui.region");
                    if (TextUtils.isEmpty(str)) {
                        str = com.xiaomi.channel.commonutils.android.f.a("ro.product.locale.region");
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
            str = com.xiaomi.channel.commonutils.android.f.f();
        }
        if (!TextUtils.isEmpty(str)) {
            str = com.xiaomi.channel.commonutils.android.f.b(str).name();
        }
        com.xiaomi.channel.commonutils.logger.b.a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.xiaomi.push.service.a a2 = com.xiaomi.push.service.a.a(getApplicationContext());
        String a3 = a2.a();
        if (TextUtils.isEmpty(a3)) {
            a3 = j();
        }
        if (TextUtils.isEmpty(a3)) {
            this.g = com.xiaomi.channel.commonutils.android.i.China.name();
        } else {
            this.g = a3;
            a2.a(a3);
            if (com.xiaomi.channel.commonutils.android.i.Global.name().equals(this.g)) {
                com.xiaomi.smack.b.a("app.chat.global.xiaomi.net");
            } else if (com.xiaomi.channel.commonutils.android.i.Europe.name().equals(this.g)) {
                com.xiaomi.smack.b.a("fr.app.chat.global.xiaomi.net");
            } else if (com.xiaomi.channel.commonutils.android.i.Russia.name().equals(this.g)) {
                com.xiaomi.smack.b.a("ru.app.chat.global.xiaomi.net");
            }
        }
        if (n()) {
            bv bvVar = new bv(this, 11);
            a(bvVar);
            t.a(new bw(this, bvVar));
        }
        com.xiaomi.channel.commonutils.misc.h.a(this).a((h.a) new com.xiaomi.push.service.f(this), 86400);
        try {
            if (com.xiaomi.channel.commonutils.android.n.c()) {
                this.m.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void l() {
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
            com.xiaomi.channel.commonutils.logger.b.a("network changed," + sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("network changed, no active network");
        }
        if (com.xiaomi.stats.f.b() != null) {
            com.xiaomi.stats.f.b().b();
        }
        com.xiaomi.smack.util.g.a(this);
        this.k.q();
        if (com.xiaomi.channel.commonutils.network.d.c(this)) {
            if (e() && m()) {
                b(false);
            }
            if (!e() && !f()) {
                this.o.b(1);
                a(new d());
            }
            com.xiaomi.push.log.b.a(this).a();
        } else {
            a(new f(2, null));
        }
        o();
    }

    private boolean m() {
        if (System.currentTimeMillis() - this.i < StatisticConfig.MIN_UPLOAD_INTERVAL) {
            return false;
        }
        return com.xiaomi.channel.commonutils.network.d.d(this);
    }

    private boolean n() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !u.a(this).b(getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!a()) {
            com.xiaomi.push.service.timers.a.a();
        } else if (com.xiaomi.push.service.timers.a.b()) {
        } else {
            com.xiaomi.push.service.timers.a.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.l != null && this.l.j()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
        } else if (this.l != null && this.l.k()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
        } else {
            this.e.b(com.xiaomi.channel.commonutils.network.d.k(this));
            q();
            if (this.l == null) {
                as.a().a(this);
                c(false);
            }
        }
    }

    private void q() {
        try {
            this.k.a(this.q, new bq(this));
            this.k.s();
            this.l = this.k;
        } catch (com.xiaomi.smack.l e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.k.b(3, e2);
        }
    }

    private boolean r() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return an.a(this).a(com.xiaomi.xmpush.thrift.g.ForegroundServiceSwitch.a(), false);
    }

    private void s() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(j, new Notification());
        } else {
            bindService(new Intent(this, this.a), new br(this), 1);
        }
    }

    private void t() {
        synchronized (this.p) {
            this.p.clear();
        }
    }

    public void a(int i2) {
        this.o.b(i2);
    }

    public void a(int i2, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.a("disconnect " + hashCode() + ", " + (this.l == null ? null : Integer.valueOf(this.l.hashCode())));
        if (this.l != null) {
            this.l.b(i2, exc);
            this.l = null;
        }
        a(7);
        a(4);
        as.a().a(this, i2);
    }

    public void a(i iVar) {
        a(iVar, 0L);
    }

    public void a(i iVar, long j2) {
        try {
            this.o.a(iVar, j2);
        } catch (IllegalStateException e2) {
        }
    }

    public void a(l lVar) {
        synchronized (this.p) {
            this.p.add(lVar);
        }
    }

    public void a(as.b bVar) {
        if (bVar != null) {
            long b2 = bVar.b();
            com.xiaomi.channel.commonutils.logger.b.a("schedule rebind job in " + (b2 / 1000));
            a(new a(bVar), b2);
        }
    }

    public void a(com.xiaomi.slim.b bVar) {
        if (this.l == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        this.l.b(bVar);
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar) {
        com.xiaomi.stats.f.b().a(aVar);
        c(true);
        this.f.a();
        Iterator<as.b> it = as.a().b().iterator();
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

    public void a(String str, String str2, int i2, String str3, String str4) {
        as.b b2 = as.a().b(str, str2);
        if (b2 != null) {
            a(new p(b2, i2, str4, str3));
        }
        as.a().a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<as.b> c2 = as.a().c("5");
        if (c2.isEmpty()) {
            if (z) {
                w.b(str, bArr);
            }
        } else if (c2.iterator().next().m == as.c.binded) {
            a(new bo(this, 4, str, bArr));
        } else if (z) {
            w.b(str, bArr);
        }
    }

    public void a(boolean z) {
        this.f.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            w.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.a("register request without payload");
            return;
        }
        com.xiaomi.xmpush.thrift.af afVar = new com.xiaomi.xmpush.thrift.af();
        try {
            com.xiaomi.xmpush.thrift.at.a(afVar, bArr);
            if (afVar.a == com.xiaomi.xmpush.thrift.a.Registration) {
                com.xiaomi.xmpush.thrift.aj ajVar = new com.xiaomi.xmpush.thrift.aj();
                try {
                    com.xiaomi.xmpush.thrift.at.a(ajVar, afVar.f());
                    w.a(afVar.j(), bArr);
                    a(new v(this, afVar.j(), ajVar.e(), ajVar.i(), bArr));
                } catch (org.apache.thrift.f e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    w.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                w.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.a("register request with invalid payload");
            }
        } catch (org.apache.thrift.f e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            w.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(com.xiaomi.slim.b[] bVarArr) {
        if (this.l == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        this.l.a(bVarArr);
    }

    public boolean a() {
        return com.xiaomi.channel.commonutils.network.d.c(this) && as.a().c() > 0 && !b() && n();
    }

    public void b(i iVar) {
        this.o.a(iVar.a, iVar);
    }

    @Override // com.xiaomi.smack.d
    public void b(com.xiaomi.smack.a aVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        com.xiaomi.stats.f.b().b(aVar);
    }

    public boolean b() {
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

    public boolean b(int i2) {
        return this.o.a(i2);
    }

    public com.xiaomi.push.service.d c() {
        return new com.xiaomi.push.service.d();
    }

    public com.xiaomi.push.service.d d() {
        return this.m;
    }

    public boolean e() {
        return this.l != null && this.l.k();
    }

    public boolean f() {
        return this.l != null && this.l.j();
    }

    public com.xiaomi.smack.a g() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Iterator it = new ArrayList(this.p).iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.b.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.xiaomi.channel.commonutils.android.n.a(this);
        s a2 = t.a(this);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.misc.a.a(a2.g);
        }
        this.b = new Messenger(new bs(this));
        ax.a(this);
        this.e = new bt(this, null, 5222, "xiaomi.com", null);
        this.e.a(true);
        this.k = new com.xiaomi.slim.g(this, this.e);
        this.m = c();
        com.xiaomi.push.service.timers.a.a(this);
        this.k.a(this);
        this.n = new ar(this);
        this.f = new bc(this);
        new com.xiaomi.push.service.e().a();
        com.xiaomi.stats.f.a().a(this);
        this.o = new com.xiaomi.push.service.k("Connection Controller Thread");
        as a3 = as.a();
        a3.e();
        a3.a(new bu(this));
        if (r()) {
            s();
        }
        com.xiaomi.tinyData.d.a(this).a(new com.xiaomi.push.service.m(this), "UPLOADER_PUSH_CHANNEL");
        a(new com.xiaomi.tinyData.a(this));
        a(new g());
        if (n()) {
            this.h = new e();
            registerReceiver(this.h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.xiaomi.channel.commonutils.logger.b.a("XMPushService created pid = " + j);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.h != null) {
            unregisterReceiver(this.h);
        }
        this.o.c();
        a(new bp(this, 2));
        a(new j());
        as.a().e();
        as.a().a(this, 15);
        as.a().d();
        this.k.b(this);
        bh.a().b();
        com.xiaomi.push.service.timers.a.a();
        t();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.c(String.format("onStart() with intent.Action = %s, chid = %s", intent.getAction(), intent.getStringExtra(aw.r)));
        }
        if (intent == null || intent.getAction() == null) {
            return;
        }
        if (!"com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) && !"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            if ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                return;
            }
            a(new h(intent));
        } else if (!this.o.d()) {
            a(new h(intent));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
            as.a().a(this, 14);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return d;
    }
}
