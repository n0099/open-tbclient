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
import android.text.TextUtils;
import com.baidu.platform.comapi.map.NodeType;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.ai;
import com.xiaomi.push.cz;
import com.xiaomi.push.di;
import com.xiaomi.push.eq;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fl;
import com.xiaomi.push.fq;
import com.xiaomi.push.fs;
import com.xiaomi.push.ft;
import com.xiaomi.push.fv;
import com.xiaomi.push.fx;
import com.xiaomi.push.fy;
import com.xiaomi.push.gd;
import com.xiaomi.push.gh;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gl;
import com.xiaomi.push.gx;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.iw;
import com.xiaomi.push.jc;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes18.dex */
public class XMPushService extends Service implements fv {

    /* renamed from: a  reason: collision with root package name */
    public static int f5022a;
    private static final int d = Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f801a;

    /* renamed from: a  reason: collision with other field name */
    private fq f803a;

    /* renamed from: a  reason: collision with other field name */
    private fs f804a;

    /* renamed from: a  reason: collision with other field name */
    private ft f805a;

    /* renamed from: a  reason: collision with other field name */
    private e f807a;

    /* renamed from: a  reason: collision with other field name */
    private p f808a;

    /* renamed from: a  reason: collision with other field name */
    private az f810a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.d f811a;

    /* renamed from: a  reason: collision with other field name */
    private String f814a;

    /* renamed from: b  reason: collision with other field name */
    private ContentObserver f817b;
    private int b = 0;
    private int c = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f800a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected Class f813a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private ao f809a = null;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.g f812a = null;

    /* renamed from: a  reason: collision with other field name */
    Messenger f802a = null;

    /* renamed from: a  reason: collision with other field name */
    private Collection<af> f816a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<l> f815a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private fx f806a = new bl(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a extends i {

        /* renamed from: a  reason: collision with other field name */
        ap.b f818a;

        public a(ap.b bVar) {
            super(9);
            this.f818a = null;
            this.f818a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind the client. " + this.f818a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                if (XMPushService.this.m529c()) {
                    ap.b a2 = ap.a().a(this.f818a.g, this.f818a.f865b);
                    if (a2 == null) {
                        com.xiaomi.channel.commonutils.logger.b.m57a("ignore bind because the channel " + this.f818a.g + " is removed ");
                    } else if (a2.f860a == ap.c.unbind) {
                        a2.a(ap.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f804a.a(a2);
                        hg.a(XMPushService.this, a2);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m57a("trying duplicate bind, ingore! " + a2.f860a);
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
    /* loaded from: classes18.dex */
    public static class b extends i {

        /* renamed from: a  reason: collision with root package name */
        private final ap.b f5024a;

        public b(ap.b bVar) {
            super(12);
            this.f5024a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind time out. chid=" + this.f5024a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            this.f5024a.a(ap.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return TextUtils.equals(((b) obj).f5024a.g, this.f5024a.g);
            }
            return false;
        }

        public int hashCode() {
            return this.f5024a.g.hashCode();
        }
    }

    /* loaded from: classes18.dex */
    class c extends i {

        /* renamed from: a  reason: collision with root package name */
        private fl f5025a;

        public c(fl flVar) {
            super(8);
            this.f5025a = null;
            this.f5025a = flVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f809a.a(this.f5025a);
        }
    }

    /* loaded from: classes18.dex */
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
            if (XMPushService.this.m525a()) {
                XMPushService.this.f();
            } else {
                com.xiaomi.channel.commonutils.logger.b.m57a("should not connect. quit the job.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, XMPushService.f5022a);
        }
    }

    /* loaded from: classes18.dex */
    public class f extends i {

        /* renamed from: a  reason: collision with other field name */
        public Exception f820a;
        public int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f820a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(this.b, this.f820a);
        }
    }

    /* loaded from: classes18.dex */
    class g extends i {
        g() {
            super(65535);
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
    /* loaded from: classes18.dex */
    public class h extends i {

        /* renamed from: a  reason: collision with root package name */
        private Intent f5030a;

        public h(Intent intent) {
            super(15);
            this.f5030a = null;
            this.f5030a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "Handle intent action = " + this.f5030a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.c(this.f5030a);
        }
    }

    /* loaded from: classes18.dex */
    public static abstract class i extends g.b {
        public i(int i) {
            super(i);
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m531a();

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5102a != 4 && this.f5102a != 8) {
                com.xiaomi.channel.commonutils.logger.b.m57a("JOB: " + a());
            }
            m531a();
        }
    }

    /* loaded from: classes18.dex */
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
            XMPushService.this.f812a.m570a();
        }
    }

    /* loaded from: classes18.dex */
    class k extends i {

        /* renamed from: a  reason: collision with root package name */
        private gj f5032a;

        public k(gj gjVar) {
            super(8);
            this.f5032a = null;
            this.f5032a = gjVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f809a.a(this.f5032a);
        }
    }

    /* loaded from: classes18.dex */
    public interface l {
        /* renamed from: a */
        void mo344a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class m extends i {

        /* renamed from: a  reason: collision with other field name */
        boolean f823a;

        public m(boolean z) {
            super(4);
            this.f823a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.m529c()) {
                try {
                    if (!this.f823a) {
                        hg.a();
                    }
                    XMPushService.this.f804a.b(this.f823a);
                } catch (gd e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class n extends i {

        /* renamed from: a  reason: collision with other field name */
        ap.b f824a;

        public n(ap.b bVar) {
            super(4);
            this.f824a = null;
            this.f824a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "rebind the client. " + this.f824a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                this.f824a.a(ap.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f804a.a(this.f824a.g, this.f824a.f865b);
                this.f824a.a(ap.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.f804a.a(this.f824a);
            } catch (gd e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
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
            if (XMPushService.this.m525a()) {
                XMPushService.this.f();
            }
        }
    }

    /* loaded from: classes18.dex */
    class p extends BroadcastReceiver {
        p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class q extends i {

        /* renamed from: a  reason: collision with other field name */
        ap.b f825a;

        /* renamed from: a  reason: collision with other field name */
        String f826a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f827b;

        public q(ap.b bVar, int i, String str, String str2) {
            super(9);
            this.f825a = null;
            this.f825a = bVar;
            this.b = i;
            this.f826a = str;
            this.f827b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "unbind the channel. " + this.f825a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (this.f825a.f860a != ap.c.unbind && XMPushService.this.f804a != null) {
                try {
                    XMPushService.this.f804a.a(this.f825a.g, this.f825a.f865b);
                } catch (gd e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f825a.a(ap.c.unbind, this.b, 0, this.f827b, this.f826a);
        }
    }

    static {
        cz.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
        f5022a = 1;
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

    private gj a(gj gjVar, String str, String str2) {
        ap a2 = ap.a();
        List<String> m549a = a2.m549a(str);
        if (m549a.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.m57a("open channel should be called first before sending a packet, pkg=" + str);
        } else {
            gjVar.o(str);
            String k2 = gjVar.k();
            if (TextUtils.isEmpty(k2)) {
                k2 = m549a.get(0);
                gjVar.l(k2);
            }
            ap.b a3 = a2.a(k2, gjVar.m());
            if (!m529c()) {
                com.xiaomi.channel.commonutils.logger.b.m57a("drop a packet as the channel is not connected, chid=" + k2);
            } else if (a3 == null || a3.f860a != ap.c.binded) {
                com.xiaomi.channel.commonutils.logger.b.m57a("drop a packet as the channel is not opened, chid=" + k2);
            } else if (TextUtils.equals(str2, a3.i)) {
                return gjVar;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m57a("invalid session. " + str2);
            }
        }
        return null;
    }

    private ap.b a(String str, Intent intent) {
        ap.b a2 = ap.a().a(str, intent.getStringExtra(at.p));
        ap.b bVar = a2 == null ? new ap.b(this) : a2;
        bVar.g = intent.getStringExtra(at.r);
        bVar.f865b = intent.getStringExtra(at.p);
        bVar.c = intent.getStringExtra(at.t);
        bVar.f862a = intent.getStringExtra(at.z);
        bVar.e = intent.getStringExtra(at.x);
        bVar.f = intent.getStringExtra(at.y);
        bVar.f864a = intent.getBooleanExtra(at.w, false);
        bVar.h = intent.getStringExtra(at.v);
        bVar.i = intent.getStringExtra(at.C);
        bVar.d = intent.getStringExtra(at.u);
        bVar.f861a = this.f811a;
        bVar.a((Messenger) intent.getParcelableExtra(at.G));
        bVar.f854a = getApplicationContext();
        ap.a().a(bVar);
        return bVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m510a() {
        String b2;
        String str = null;
        com.xiaomi.push.ao.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            aw a2 = aw.a(this);
            b2 = null;
            while (true) {
                if (!TextUtils.isEmpty(b2) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(b2)) {
                    b2 = com.xiaomi.push.l.m501a("ro.miui.region");
                    if (TextUtils.isEmpty(b2)) {
                        b2 = com.xiaomi.push.l.m501a("ro.product.locale.region");
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
        com.xiaomi.channel.commonutils.logger.b.m57a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
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
        fl flVar;
        String stringExtra = intent.getStringExtra(at.z);
        String stringExtra2 = intent.getStringExtra(at.C);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        ap a2 = ap.a();
        if (bundleExtra != null) {
            gi giVar = (gi) a(new gi(bundleExtra), stringExtra, stringExtra2);
            if (giVar == null) {
                return;
            }
            flVar = fl.a(giVar, a2.a(giVar.k(), giVar.m()).h);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                long longExtra = intent.getLongExtra(at.p, 0L);
                String stringExtra3 = intent.getStringExtra(at.q);
                String stringExtra4 = intent.getStringExtra("ext_chid");
                ap.b a3 = a2.a(stringExtra4, Long.toString(longExtra));
                if (a3 != null) {
                    flVar = new fl();
                    try {
                        flVar.a(Integer.parseInt(stringExtra4));
                    } catch (NumberFormatException e2) {
                    }
                    flVar.a("SECMSG", (String) null);
                    flVar.a(longExtra, "xiaomi.com", stringExtra3);
                    flVar.a(intent.getStringExtra("ext_pkt_id"));
                    flVar.a(byteArrayExtra, a3.h);
                }
            }
            flVar = null;
        }
        if (flVar != null) {
            c(new ba(this, flVar));
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        il ilVar = new il();
        try {
            iw.a(ilVar, byteArrayExtra);
            com.xiaomi.push.ai.a(getApplicationContext()).a((ai.a) new com.xiaomi.push.service.b(ilVar, new WeakReference(this), booleanExtra), i2);
        } catch (jc e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(String str, int i2) {
        Collection<ap.b> m548a = ap.a().m548a(str);
        if (m548a != null) {
            for (ap.b bVar : m548a) {
                if (bVar != null) {
                    a(new q(bVar, i2, null, null));
                }
            }
        }
        ap.a().m551a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m514a(String str, Intent intent) {
        ap.b a2 = ap.a().a(str, intent.getStringExtra(at.p));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(at.C);
        String stringExtra2 = intent.getStringExtra(at.v);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m57a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.be.a(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m515a() {
        String[] split;
        String a2 = ak.a(getApplicationContext()).a(hr.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
                return null;
            }
        }
        return null;
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra(at.z);
        String stringExtra2 = intent.getStringExtra(at.C);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        gi[] giVarArr = new gi[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            giVarArr[i2] = new gi((Bundle) parcelableArrayExtra[i2]);
            giVarArr[i2] = (gi) a(giVarArr[i2], stringExtra, stringExtra2);
            if (giVarArr[i2] == null) {
                return;
            }
        }
        ap a2 = ap.a();
        fl[] flVarArr = new fl[giVarArr.length];
        for (int i3 = 0; i3 < giVarArr.length; i3++) {
            gi giVar = giVarArr[i3];
            flVarArr[i3] = fl.a(giVar, a2.a(giVar.k(), giVar.m()).h);
        }
        c(new com.xiaomi.push.service.c(this, flVarArr));
    }

    private void b(boolean z) {
        this.f800a = System.currentTimeMillis();
        if (!m529c()) {
            a(true);
        } else if (this.f804a.m303d() || this.f804a.e() || com.xiaomi.push.az.d(this)) {
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
        com.xiaomi.channel.commonutils.logger.b.m57a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = m510a();
        }
        if (TextUtils.isEmpty(a3)) {
            this.f814a = com.xiaomi.push.o.China.name();
        } else {
            this.f814a = a3;
            a2.a(a3);
            if (com.xiaomi.push.o.Global.name().equals(this.f814a)) {
                ft.a("app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.Europe.name().equals(this.f814a)) {
                ft.a("fr.app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.Russia.name().equals(this.f814a)) {
                ft.a("ru.app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.India.name().equals(this.f814a)) {
                ft.a("idmb.app.chat.global.xiaomi.net");
            }
        }
        if (com.xiaomi.push.o.China.name().equals(this.f814a)) {
            ft.a("cn.app.chat.xiaomi.net");
        }
        if (m520h()) {
            bv bvVar = new bv(this, 11);
            a(bvVar);
            com.xiaomi.push.service.l.a(new bw(this, bvVar));
        }
        try {
            if (com.xiaomi.push.t.m589a()) {
                this.f811a.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        String b2;
        int i2;
        ap.b bVar = null;
        boolean z = true;
        ap a2 = ap.a();
        if (at.d.equalsIgnoreCase(intent.getAction()) || at.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(at.r);
            if (TextUtils.isEmpty(intent.getStringExtra(at.v))) {
                com.xiaomi.channel.commonutils.logger.b.m57a("security is empty. ignore.");
            } else if (stringExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
            } else {
                boolean m514a = m514a(stringExtra, intent);
                ap.b a3 = a(stringExtra, intent);
                if (!com.xiaomi.push.az.b(this)) {
                    this.f811a.a(this, a3, false, 2, null);
                } else if (!m529c()) {
                    a(true);
                } else if (a3.f860a == ap.c.unbind) {
                    c(new a(a3));
                } else if (m514a) {
                    c(new n(a3));
                } else if (a3.f860a == ap.c.binding) {
                    com.xiaomi.channel.commonutils.logger.b.m57a(String.format("the client is binding. %1$s %2$s.", a3.g, ap.b.a(a3.f865b)));
                } else if (a3.f860a == ap.c.binded) {
                    this.f811a.a(this, a3, true, 0, null);
                }
            }
        } else if (at.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(at.z);
            String stringExtra3 = intent.getStringExtra(at.r);
            String stringExtra4 = intent.getStringExtra(at.p);
            com.xiaomi.channel.commonutils.logger.b.m57a("Service called close channel chid = " + stringExtra3 + " res = " + ap.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str : a2.m549a(stringExtra2)) {
                    a(str, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
            }
        } else if (at.e.equalsIgnoreCase(intent.getAction())) {
            a(intent);
        } else if (at.g.equalsIgnoreCase(intent.getAction())) {
            b(intent);
        } else if (at.f.equalsIgnoreCase(intent.getAction())) {
            gj a4 = a(new gh(intent.getBundleExtra("ext_packet")), intent.getStringExtra(at.z), intent.getStringExtra(at.C));
            if (a4 != null) {
                c(new ba(this, fl.a(a4, a2.a(a4.k(), a4.m()).h)));
            }
        } else if (at.h.equalsIgnoreCase(intent.getAction())) {
            gj a5 = a(new gl(intent.getBundleExtra("ext_packet")), intent.getStringExtra(at.z), intent.getStringExtra(at.C));
            if (a5 != null) {
                c(new ba(this, fl.a(a5, a2.a(a5.k(), a5.m()).h)));
            }
        } else if (at.k.equals(intent.getAction())) {
            String stringExtra5 = intent.getStringExtra(at.r);
            String stringExtra6 = intent.getStringExtra(at.p);
            if (stringExtra5 != null) {
                com.xiaomi.channel.commonutils.logger.b.m57a("request reset connection from chid = " + stringExtra5);
                ap.b a6 = ap.a().a(stringExtra5, stringExtra6);
                if (a6 != null && a6.h.equals(intent.getStringExtra(at.v)) && a6.f860a == ap.c.binded) {
                    fs m522a = m522a();
                    if (m522a == null || !m522a.a(System.currentTimeMillis() - 15000)) {
                        c(new o());
                    }
                }
            }
        } else if (at.l.equals(intent.getAction())) {
            String stringExtra7 = intent.getStringExtra(at.z);
            List<String> m549a = a2.m549a(stringExtra7);
            if (m549a.isEmpty()) {
                com.xiaomi.channel.commonutils.logger.b.m57a("open channel should be called first before update info, pkg=" + stringExtra7);
                return;
            }
            String stringExtra8 = intent.getStringExtra(at.r);
            String stringExtra9 = intent.getStringExtra(at.p);
            if (TextUtils.isEmpty(stringExtra8)) {
                stringExtra8 = m549a.get(0);
            }
            if (TextUtils.isEmpty(stringExtra9)) {
                Collection<ap.b> m548a = a2.m548a(stringExtra8);
                if (m548a != null && !m548a.isEmpty()) {
                    bVar = m548a.iterator().next();
                }
            } else {
                bVar = a2.a(stringExtra8, stringExtra9);
            }
            if (bVar != null) {
                if (intent.hasExtra(at.x)) {
                    bVar.e = intent.getStringExtra(at.x);
                }
                if (intent.hasExtra(at.y)) {
                    bVar.f = intent.getStringExtra(at.y);
                }
            }
        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            if (!"android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m521i() && fc.m277a()) {
                    com.xiaomi.channel.commonutils.logger.b.m57a("enter falldown mode, stop alarm.");
                    fc.a();
                }
            } else if (!m521i()) {
                com.xiaomi.channel.commonutils.logger.b.m57a("exit falldown mode, activate alarm.");
                e();
                if (m529c() || m530d()) {
                    return;
                }
                a(true);
            }
        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            if (aw.a(getApplicationContext()).m556a() && aw.a(getApplicationContext()).a() == 0) {
                com.xiaomi.channel.commonutils.logger.b.m57a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
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
                c(new bx(this, 14, intExtra, byteArrayExtra, stringExtra10));
            }
        } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
            String stringExtra11 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                com.xiaomi.push.service.m.a(this).a(stringExtra11);
            }
            a(stringExtra11, byteArrayExtra2, booleanExtra2);
        } else if (ax.f5069a.equals(intent.getAction())) {
            String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra12 == null || TextUtils.isEmpty(stringExtra12.trim())) {
                return;
            }
            try {
                getPackageManager().getPackageInfo(stringExtra12, 0);
                z = false;
            } catch (PackageManager.NameNotFoundException e2) {
            }
            if ("com.xiaomi.channel".equals(stringExtra12) && !ap.a().m548a("1").isEmpty() && z) {
                a("1", 0);
                com.xiaomi.channel.commonutils.logger.b.m57a("close the miliao channel as the app is uninstalled.");
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
            if (aa.m539b((Context) this, stringExtra12)) {
                aa.m538b((Context) this, stringExtra12);
            }
            aa.m534a((Context) this, stringExtra12);
            if (!m529c() || string == null) {
                return;
            }
            try {
                w.a(this, w.a(stringExtra12, string));
                com.xiaomi.channel.commonutils.logger.b.m57a("uninstall " + stringExtra12 + " msg sent");
            } catch (gd e3) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                a(10, e3);
            }
        } else if (ax.b.equals(intent.getAction())) {
            String stringExtra13 = intent.getStringExtra("data_cleared_pkg_name");
            if (stringExtra13 == null || TextUtils.isEmpty(stringExtra13.trim())) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m57a("clear notifications of package " + stringExtra13);
            aa.m534a((Context) this, stringExtra13);
        } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
            String stringExtra14 = intent.getStringExtra(at.z);
            int intExtra2 = intent.getIntExtra(at.A, -2);
            if (TextUtils.isEmpty(stringExtra14)) {
                return;
            }
            if (intExtra2 >= -1) {
                aa.a(this, stringExtra14, intExtra2);
            } else {
                aa.a(this, stringExtra14, intent.getStringExtra(at.E), intent.getStringExtra(at.F));
            }
        } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
            String stringExtra15 = intent.getStringExtra(at.z);
            String stringExtra16 = intent.getStringExtra(at.D);
            if (intent.hasExtra(at.B)) {
                i2 = intent.getIntExtra(at.B, 0);
                b2 = com.xiaomi.push.be.b(stringExtra15 + i2);
            } else {
                b2 = com.xiaomi.push.be.b(stringExtra15);
                i2 = 0;
                r3 = true;
            }
            if (TextUtils.isEmpty(stringExtra15) || !TextUtils.equals(stringExtra16, b2)) {
                com.xiaomi.channel.commonutils.logger.b.d("invalid notification for " + stringExtra15);
            } else if (r3) {
                aa.m538b((Context) this, stringExtra15);
            } else {
                aa.b(this, stringExtra15, i2);
            }
        } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
            String stringExtra17 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra17)) {
                com.xiaomi.push.service.m.a(this).b(stringExtra17);
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            a(19, (Exception) null);
            e();
            stopSelf();
        } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
            String stringExtra18 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            String stringExtra19 = intent.getStringExtra("mipush_app_id");
            String stringExtra20 = intent.getStringExtra("mipush_app_token");
            if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                com.xiaomi.push.service.m.a(this).c(stringExtra18);
            }
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                com.xiaomi.push.service.m.a(this).e(stringExtra18);
                com.xiaomi.push.service.m.a(this).f(stringExtra18);
            }
            if (byteArrayExtra3 == null) {
                com.xiaomi.push.service.o.a(this, stringExtra18, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                return;
            }
            com.xiaomi.push.service.o.b(stringExtra18, byteArrayExtra3);
            a(new com.xiaomi.push.service.n(this, stringExtra18, stringExtra19, stringExtra20, byteArrayExtra3));
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f807a == null) {
                this.f807a = new e();
                registerReceiver(this.f807a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
            String stringExtra21 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
            hq hqVar = new hq();
            try {
                iw.a(hqVar, byteArrayExtra4);
                hk.a(this).a(hqVar, stringExtra21);
            } catch (jc e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            }
        } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Service called on timer");
            if (m521i()) {
                if (fc.m277a()) {
                    com.xiaomi.channel.commonutils.logger.b.m57a("enter falldown mode, stop alarm");
                    fc.a();
                    return;
                }
                return;
            }
            fc.a(false);
            if (m517e()) {
                b(false);
            }
        } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Service called on check alive.");
            if (m517e()) {
                b(false);
            }
        } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.m57a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
            fc.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            d();
        } else if ("action_cr_config".equals(intent.getAction())) {
            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
            Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(com.xiaomi.push.bj.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                return;
            }
            fa.a(getApplicationContext(), build);
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
            com.xiaomi.channel.commonutils.logger.b.m57a("aw_ping: receive a aw_ping message. switch: " + r3 + " frequency: " + intExtra3);
            if (!r3 || intExtra3 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            a(intent, intExtra3);
        }
    }

    private void c(i iVar) {
        this.f812a.a(iVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.t.m589a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (af afVar : (af[]) this.f816a.toArray(new af[0])) {
                    afVar.mo569a();
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
            com.xiaomi.channel.commonutils.logger.b.m57a("network changed," + sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m57a("network changed, no active network");
        }
        if (he.a() != null) {
            he.a().m336a();
        }
        gx.m333a((Context) this);
        this.f803a.d();
        if (com.xiaomi.push.az.b(this)) {
            if (m529c() && m517e()) {
                b(false);
            }
            if (!m529c() && !m530d()) {
                this.f812a.a(1);
                a(new d());
            }
            di.a(this).a();
        } else {
            a(new f(2, null));
        }
        e();
    }

    private void d(Intent intent) {
        int i2;
        try {
            eq.a(getApplicationContext()).a(new av());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            il ilVar = new il();
            iw.a(ilVar, byteArrayExtra);
            String b2 = ilVar.b();
            Map<String, String> m436a = ilVar.m436a();
            if (m436a != null) {
                String str = m436a.get("extra_help_aw_info");
                String str2 = m436a.get("extra_aw_app_online_cmd");
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
                eq.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
            }
        } catch (jc e3) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m525a()) {
            fc.a();
        } else if (fc.m277a()) {
        } else {
            fc.a(true);
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m517e() {
        if (System.currentTimeMillis() - this.f800a < 30000) {
            return false;
        }
        return com.xiaomi.push.az.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f804a != null && this.f804a.m301b()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
        } else if (this.f804a != null && this.f804a.m302c()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
        } else {
            this.f805a.b(com.xiaomi.push.az.m143a((Context) this));
            g();
            if (this.f804a == null) {
                ap.a().a(this);
                c(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f  reason: collision with other method in class */
    public boolean m518f() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    private void g() {
        try {
            this.f803a.a(this.f806a, new bo(this));
            this.f803a.e();
            this.f804a = this.f803a;
        } catch (gd e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f803a.b(3, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m519g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(d, new Notification());
        } else {
            bindService(new Intent(this, this.f813a), new bp(this), 1);
        }
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m520h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !com.xiaomi.push.service.m.a(this).m584b(getPackageName());
    }

    private void i() {
        synchronized (this.f815a) {
            this.f815a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m521i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m396b((Context) this) && !com.xiaomi.push.i.m393a(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        return this.b > this.c ? intValue >= this.b || intValue < this.c : this.b < this.c && intValue >= this.b && intValue < this.c;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ak.a(this).a(hr.ForegroundServiceSwitch.a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public fs m522a() {
        return this.f804a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.d m523a() {
        return new com.xiaomi.push.service.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m524a() {
        if (System.currentTimeMillis() - this.f800a >= fy.a() && com.xiaomi.push.az.c(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f812a.a(i2);
    }

    public void a(int i2, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.m57a("disconnect " + hashCode() + ", " + (this.f804a == null ? null : Integer.valueOf(this.f804a.hashCode())));
        if (this.f804a != null) {
            this.f804a.b(i2, exc);
            this.f804a = null;
        }
        a(7);
        a(4);
        ap.a().a(this, i2);
    }

    public void a(fl flVar) {
        if (this.f804a == null) {
            throw new gd("try send msg while connection is null.");
        }
        this.f804a.b(flVar);
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        he.a().a(fsVar);
        c(true);
        this.f810a.m558a();
        if (!fc.m277a() && !m521i()) {
            com.xiaomi.channel.commonutils.logger.b.m57a("reconnection successful, reactivate alarm.");
            fc.a(true);
        }
        Iterator<ap.b> it = ap.a().m547a().iterator();
        while (it.hasNext()) {
            a(new a(it.next()));
        }
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i2, Exception exc) {
        he.a().a(fsVar, i2, exc);
        if (m521i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        he.a().a(fsVar, exc);
        c(false);
        if (m521i()) {
            return;
        }
        a(false);
    }

    public void a(i iVar) {
        a(iVar, 0L);
    }

    public void a(i iVar, long j2) {
        try {
            this.f812a.a(iVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m57a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(l lVar) {
        synchronized (this.f815a) {
            this.f815a.add(lVar);
        }
    }

    public void a(ap.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m57a("schedule rebind job in " + (a2 / 1000));
            a(new a(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        ap.b a2 = ap.a().a(str, str2);
        if (a2 != null) {
            a(new q(a2, i2, str4, str3));
        }
        ap.a().m552a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<ap.b> m548a = ap.a().m548a("5");
        if (m548a.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.o.b(str, bArr);
            }
        } else if (m548a.iterator().next().f860a == ap.c.binded) {
            a(new bm(this, 4, str, bArr));
        } else if (z) {
            com.xiaomi.push.service.o.b(str, bArr);
        }
    }

    public void a(boolean z) {
        this.f810a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m57a("register request without payload");
            return;
        }
        ii iiVar = new ii();
        try {
            iw.a(iiVar, bArr);
            if (iiVar.f601a == hm.Registration) {
                im imVar = new im();
                try {
                    iw.a(imVar, iiVar.m427a());
                    com.xiaomi.push.service.o.a(iiVar.b(), bArr);
                    a(new com.xiaomi.push.service.n(this, iiVar.b(), imVar.b(), imVar.c(), bArr));
                    fb.a(getApplicationContext()).a(iiVar.b(), "E100003", imVar.a(), NodeType.E_TRAFFIC_UGC, null);
                } catch (jc e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m57a("register request with invalid payload");
            }
        } catch (jc e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(fl[] flVarArr) {
        if (this.f804a == null) {
            throw new gd("try send msg while connection is null.");
        }
        this.f804a.a(flVarArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m525a() {
        return com.xiaomi.push.az.b(this) && ap.a().m546a() > 0 && !m528b() && m520h() && !m519g() && !m518f();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m526a(int i2) {
        return this.f812a.m572a(i2);
    }

    public com.xiaomi.push.service.d b() {
        return this.f811a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public void m527b() {
        Iterator it = new ArrayList(this.f815a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).mo344a();
        }
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        he.a().b(fsVar);
    }

    public void b(i iVar) {
        this.f812a.a(iVar.f5102a, iVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m528b() {
        try {
            Class<?> a2 = com.xiaomi.push.t.a(this, "miui.os.Build");
            Field field = a2.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = a2.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = a2.getField("IS_CT_CUSTOMIZATION_TEST");
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
    public boolean m529c() {
        return this.f804a != null && this.f804a.m302c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m530d() {
        return this.f804a != null && this.f804a.m301b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f802a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.xiaomi.push.t.m588a((Context) this);
        com.xiaomi.push.service.k a2 = com.xiaomi.push.service.l.a((Context) this);
        if (a2 != null) {
            com.xiaomi.push.ab.a(a2.f5108a);
        }
        this.f802a = new Messenger(new bq(this));
        au.a(this);
        this.f805a = new br(this, null, 5222, "xiaomi.com", null);
        this.f805a.a(true);
        this.f803a = new fq(this, this.f805a);
        this.f811a = m523a();
        fc.a(this);
        this.f803a.a(this);
        this.f809a = new ao(this);
        this.f810a = new az(this);
        new com.xiaomi.push.service.e().a();
        he.m337a().a(this);
        this.f812a = new com.xiaomi.push.service.g("Connection Controller Thread");
        ap a3 = ap.a();
        a3.b();
        a3.a(new bs(this));
        if (k()) {
            h();
        }
        hk.a(this).a(new com.xiaomi.push.service.i(this), "UPLOADER_PUSH_CHANNEL");
        a(new hh(this));
        a(new g());
        this.f816a.add(bg.a(this));
        if (m520h()) {
            this.f807a = new e();
            registerReceiver(this.f807a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.f801a = new bt(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f801a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.m57a("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.f817b = new bu(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.f817b);
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] m515a = m515a();
            if (m515a != null) {
                this.f808a = new p();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f808a, intentFilter);
                this.b = m515a[0];
                this.c = m515a[1];
                com.xiaomi.channel.commonutils.logger.b.m57a("falldown initialized: " + this.b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.c);
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m57a("XMPushService created pid = " + d);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f807a != null) {
            a(this.f807a);
            this.f807a = null;
        }
        if (this.f808a != null) {
            a(this.f808a);
            this.f808a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f801a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f801a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m57a("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f817b != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f817b);
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.f816a.clear();
        this.f812a.m573b();
        a(new bn(this, 2));
        a(new j());
        ap.a().b();
        ap.a().a(this, 15);
        ap.a().m550a();
        this.f803a.b(this);
        be.a().m567a();
        fc.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m57a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.c(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, from-bridge = %s", intent.getAction(), intent.getStringExtra(at.r), intent.getStringExtra(at.z), intent.getStringExtra("mipush_app_package"), intent.getStringExtra("ext_is_xmpushservice_bridge")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f812a.m571a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    ap.a().a(this, 14);
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
        return f5022a;
    }
}
