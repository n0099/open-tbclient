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
/* loaded from: classes9.dex */
public class XMPushService extends Service implements fv {
    public static int a;
    private static final int d = Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f798a;

    /* renamed from: a  reason: collision with other field name */
    private fq f800a;

    /* renamed from: a  reason: collision with other field name */
    private fs f801a;

    /* renamed from: a  reason: collision with other field name */
    private ft f802a;

    /* renamed from: a  reason: collision with other field name */
    private e f804a;

    /* renamed from: a  reason: collision with other field name */
    private p f805a;

    /* renamed from: a  reason: collision with other field name */
    private az f807a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.d f808a;

    /* renamed from: a  reason: collision with other field name */
    private String f811a;

    /* renamed from: b  reason: collision with other field name */
    private ContentObserver f814b;
    private int b = 0;
    private int c = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f797a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected Class f810a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private ao f806a = null;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.g f809a = null;

    /* renamed from: a  reason: collision with other field name */
    Messenger f799a = null;

    /* renamed from: a  reason: collision with other field name */
    private Collection<af> f813a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<l> f812a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private fx f803a = new bl(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends i {

        /* renamed from: a  reason: collision with other field name */
        ap.b f815a;

        public a(ap.b bVar) {
            super(9);
            this.f815a = null;
            this.f815a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind the client. " + this.f815a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                if (XMPushService.this.m526c()) {
                    ap.b a = ap.a().a(this.f815a.g, this.f815a.f862b);
                    if (a == null) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("ignore bind because the channel " + this.f815a.g + " is removed ");
                    } else if (a.f857a == ap.c.unbind) {
                        a.a(ap.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f801a.a(a);
                        hg.a(XMPushService.this, a);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m54a("trying duplicate bind, ingore! " + a.f857a);
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
    /* loaded from: classes9.dex */
    public static class b extends i {
        private final ap.b a;

        public b(ap.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind time out. chid=" + this.a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            this.a.a(ap.c.unbind, 1, 21, (String) null, (String) null);
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

    /* loaded from: classes9.dex */
    class c extends i {
        private fl a;

        public c(fl flVar) {
            super(8);
            this.a = null;
            this.a = flVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f806a.a(this.a);
        }
    }

    /* loaded from: classes9.dex */
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
            if (XMPushService.this.m522a()) {
                XMPushService.this.f();
            } else {
                com.xiaomi.channel.commonutils.logger.b.m54a("should not connect. quit the job.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, XMPushService.a);
        }
    }

    /* loaded from: classes9.dex */
    public class f extends i {

        /* renamed from: a  reason: collision with other field name */
        public Exception f817a;
        public int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f817a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(this.b, this.f817a);
        }
    }

    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static abstract class i extends g.b {
        public i(int i) {
            super(i);
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m528a();

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != 4 && this.a != 8) {
                com.xiaomi.channel.commonutils.logger.b.m54a("JOB: " + a());
            }
            m528a();
        }
    }

    /* loaded from: classes9.dex */
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
            XMPushService.this.f809a.m567a();
        }
    }

    /* loaded from: classes9.dex */
    class k extends i {
        private gj a;

        public k(gj gjVar) {
            super(8);
            this.a = null;
            this.a = gjVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f806a.a(this.a);
        }
    }

    /* loaded from: classes9.dex */
    public interface l {
        /* renamed from: a */
        void mo341a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class m extends i {

        /* renamed from: a  reason: collision with other field name */
        boolean f820a;

        public m(boolean z) {
            super(4);
            this.f820a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.m526c()) {
                try {
                    if (!this.f820a) {
                        hg.a();
                    }
                    XMPushService.this.f801a.b(this.f820a);
                } catch (gd e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class n extends i {

        /* renamed from: a  reason: collision with other field name */
        ap.b f821a;

        public n(ap.b bVar) {
            super(4);
            this.f821a = null;
            this.f821a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "rebind the client. " + this.f821a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                this.f821a.a(ap.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f801a.a(this.f821a.g, this.f821a.f862b);
                this.f821a.a(ap.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.f801a.a(this.f821a);
            } catch (gd e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
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
            if (XMPushService.this.m522a()) {
                XMPushService.this.f();
            }
        }
    }

    /* loaded from: classes9.dex */
    class p extends BroadcastReceiver {
        p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class q extends i {

        /* renamed from: a  reason: collision with other field name */
        ap.b f822a;

        /* renamed from: a  reason: collision with other field name */
        String f823a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f824b;

        public q(ap.b bVar, int i, String str, String str2) {
            super(9);
            this.f822a = null;
            this.f822a = bVar;
            this.b = i;
            this.f823a = str;
            this.f824b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "unbind the channel. " + this.f822a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (this.f822a.f857a != ap.c.unbind && XMPushService.this.f801a != null) {
                try {
                    XMPushService.this.f801a.a(this.f822a.g, this.f822a.f862b);
                } catch (gd e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f822a.a(ap.c.unbind, this.b, 0, this.f824b, this.f823a);
        }
    }

    static {
        cz.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
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

    private gj a(gj gjVar, String str, String str2) {
        ap a2 = ap.a();
        List<String> m546a = a2.m546a(str);
        if (m546a.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("open channel should be called first before sending a packet, pkg=" + str);
        } else {
            gjVar.o(str);
            String k2 = gjVar.k();
            if (TextUtils.isEmpty(k2)) {
                k2 = m546a.get(0);
                gjVar.l(k2);
            }
            ap.b a3 = a2.a(k2, gjVar.m());
            if (!m526c()) {
                com.xiaomi.channel.commonutils.logger.b.m54a("drop a packet as the channel is not connected, chid=" + k2);
            } else if (a3 == null || a3.f857a != ap.c.binded) {
                com.xiaomi.channel.commonutils.logger.b.m54a("drop a packet as the channel is not opened, chid=" + k2);
            } else if (TextUtils.equals(str2, a3.i)) {
                return gjVar;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m54a("invalid session. " + str2);
            }
        }
        return null;
    }

    private ap.b a(String str, Intent intent) {
        ap.b a2 = ap.a().a(str, intent.getStringExtra(at.p));
        ap.b bVar = a2 == null ? new ap.b(this) : a2;
        bVar.g = intent.getStringExtra(at.r);
        bVar.f862b = intent.getStringExtra(at.p);
        bVar.c = intent.getStringExtra(at.t);
        bVar.f859a = intent.getStringExtra(at.z);
        bVar.e = intent.getStringExtra(at.x);
        bVar.f = intent.getStringExtra(at.y);
        bVar.f861a = intent.getBooleanExtra(at.w, false);
        bVar.h = intent.getStringExtra(at.v);
        bVar.i = intent.getStringExtra(at.C);
        bVar.d = intent.getStringExtra(at.u);
        bVar.f858a = this.f808a;
        bVar.a((Messenger) intent.getParcelableExtra(at.G));
        bVar.f851a = getApplicationContext();
        ap.a().a(bVar);
        return bVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m507a() {
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
                    b2 = com.xiaomi.push.l.m498a("ro.miui.region");
                    if (TextUtils.isEmpty(b2)) {
                        b2 = com.xiaomi.push.l.m498a("ro.product.locale.region");
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
        com.xiaomi.channel.commonutils.logger.b.m54a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
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
        Collection<ap.b> m545a = ap.a().m545a(str);
        if (m545a != null) {
            for (ap.b bVar : m545a) {
                if (bVar != null) {
                    a(new q(bVar, i2, null, null));
                }
            }
        }
        ap.a().m548a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m511a(String str, Intent intent) {
        ap.b a2 = ap.a().a(str, intent.getStringExtra(at.p));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(at.C);
        String stringExtra2 = intent.getStringExtra(at.v);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.be.a(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m512a() {
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
        this.f797a = System.currentTimeMillis();
        if (!m526c()) {
            a(true);
        } else if (this.f801a.m300d() || this.f801a.e() || com.xiaomi.push.az.d(this)) {
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
        com.xiaomi.channel.commonutils.logger.b.m54a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = m507a();
        }
        if (TextUtils.isEmpty(a3)) {
            this.f811a = com.xiaomi.push.o.China.name();
        } else {
            this.f811a = a3;
            a2.a(a3);
            if (com.xiaomi.push.o.Global.name().equals(this.f811a)) {
                ft.a("app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.Europe.name().equals(this.f811a)) {
                ft.a("fr.app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.Russia.name().equals(this.f811a)) {
                ft.a("ru.app.chat.global.xiaomi.net");
            } else if (com.xiaomi.push.o.India.name().equals(this.f811a)) {
                ft.a("idmb.app.chat.global.xiaomi.net");
            }
        }
        if (com.xiaomi.push.o.China.name().equals(this.f811a)) {
            ft.a("cn.app.chat.xiaomi.net");
        }
        if (m517h()) {
            bv bvVar = new bv(this, 11);
            a(bvVar);
            com.xiaomi.push.service.l.a(new bw(this, bvVar));
        }
        try {
            if (com.xiaomi.push.t.m586a()) {
                this.f808a.a(this);
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
                com.xiaomi.channel.commonutils.logger.b.m54a("security is empty. ignore.");
            } else if (stringExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
            } else {
                boolean m511a = m511a(stringExtra, intent);
                ap.b a3 = a(stringExtra, intent);
                if (!com.xiaomi.push.az.b(this)) {
                    this.f808a.a(this, a3, false, 2, null);
                } else if (!m526c()) {
                    a(true);
                } else if (a3.f857a == ap.c.unbind) {
                    c(new a(a3));
                } else if (m511a) {
                    c(new n(a3));
                } else if (a3.f857a == ap.c.binding) {
                    com.xiaomi.channel.commonutils.logger.b.m54a(String.format("the client is binding. %1$s %2$s.", a3.g, ap.b.a(a3.f862b)));
                } else if (a3.f857a == ap.c.binded) {
                    this.f808a.a(this, a3, true, 0, null);
                }
            }
        } else if (at.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(at.z);
            String stringExtra3 = intent.getStringExtra(at.r);
            String stringExtra4 = intent.getStringExtra(at.p);
            com.xiaomi.channel.commonutils.logger.b.m54a("Service called close channel chid = " + stringExtra3 + " res = " + ap.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str : a2.m546a(stringExtra2)) {
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
                com.xiaomi.channel.commonutils.logger.b.m54a("request reset connection from chid = " + stringExtra5);
                ap.b a6 = ap.a().a(stringExtra5, stringExtra6);
                if (a6 != null && a6.h.equals(intent.getStringExtra(at.v)) && a6.f857a == ap.c.binded) {
                    fs m519a = m519a();
                    if (m519a == null || !m519a.a(System.currentTimeMillis() - 15000)) {
                        c(new o());
                    }
                }
            }
        } else if (at.l.equals(intent.getAction())) {
            String stringExtra7 = intent.getStringExtra(at.z);
            List<String> m546a = a2.m546a(stringExtra7);
            if (m546a.isEmpty()) {
                com.xiaomi.channel.commonutils.logger.b.m54a("open channel should be called first before update info, pkg=" + stringExtra7);
                return;
            }
            String stringExtra8 = intent.getStringExtra(at.r);
            String stringExtra9 = intent.getStringExtra(at.p);
            if (TextUtils.isEmpty(stringExtra8)) {
                stringExtra8 = m546a.get(0);
            }
            if (TextUtils.isEmpty(stringExtra9)) {
                Collection<ap.b> m545a = a2.m545a(stringExtra8);
                if (m545a != null && !m545a.isEmpty()) {
                    bVar = m545a.iterator().next();
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
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m518i() && fc.m274a()) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("enter falldown mode, stop alarm.");
                    fc.a();
                }
            } else if (!m518i()) {
                com.xiaomi.channel.commonutils.logger.b.m54a("exit falldown mode, activate alarm.");
                e();
                if (m526c() || m527d()) {
                    return;
                }
                a(true);
            }
        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            if (aw.a(getApplicationContext()).m553a() && aw.a(getApplicationContext()).a() == 0) {
                com.xiaomi.channel.commonutils.logger.b.m54a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
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
        } else if (ax.a.equals(intent.getAction())) {
            String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra12 == null || TextUtils.isEmpty(stringExtra12.trim())) {
                return;
            }
            try {
                getPackageManager().getPackageInfo(stringExtra12, 0);
                z = false;
            } catch (PackageManager.NameNotFoundException e2) {
            }
            if ("com.xiaomi.channel".equals(stringExtra12) && !ap.a().m545a("1").isEmpty() && z) {
                a("1", 0);
                com.xiaomi.channel.commonutils.logger.b.m54a("close the miliao channel as the app is uninstalled.");
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
            if (aa.m536b((Context) this, stringExtra12)) {
                aa.m535b((Context) this, stringExtra12);
            }
            aa.m531a((Context) this, stringExtra12);
            if (!m526c() || string == null) {
                return;
            }
            try {
                w.a(this, w.a(stringExtra12, string));
                com.xiaomi.channel.commonutils.logger.b.m54a("uninstall " + stringExtra12 + " msg sent");
            } catch (gd e3) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                a(10, e3);
            }
        } else if (ax.b.equals(intent.getAction())) {
            String stringExtra13 = intent.getStringExtra("data_cleared_pkg_name");
            if (stringExtra13 == null || TextUtils.isEmpty(stringExtra13.trim())) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("clear notifications of package " + stringExtra13);
            aa.m531a((Context) this, stringExtra13);
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
                aa.m535b((Context) this, stringExtra15);
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
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f804a == null) {
                this.f804a = new e();
                registerReceiver(this.f804a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
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
            com.xiaomi.channel.commonutils.logger.b.m54a("Service called on timer");
            if (m518i()) {
                if (fc.m274a()) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("enter falldown mode, stop alarm");
                    fc.a();
                    return;
                }
                return;
            }
            fc.a(false);
            if (m514e()) {
                b(false);
            }
        } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Service called on check alive.");
            if (m514e()) {
                b(false);
            }
        } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.m54a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
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
            com.xiaomi.channel.commonutils.logger.b.m54a("aw_ping: receive a aw_ping message. switch: " + r3 + " frequency: " + intExtra3);
            if (!r3 || intExtra3 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            a(intent, intExtra3);
        }
    }

    private void c(i iVar) {
        this.f809a.a(iVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.t.m586a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (af afVar : (af[]) this.f813a.toArray(new af[0])) {
                    afVar.mo566a();
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
            com.xiaomi.channel.commonutils.logger.b.m54a("network changed," + sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m54a("network changed, no active network");
        }
        if (he.a() != null) {
            he.a().m333a();
        }
        gx.m330a((Context) this);
        this.f800a.d();
        if (com.xiaomi.push.az.b(this)) {
            if (m526c() && m514e()) {
                b(false);
            }
            if (!m526c() && !m527d()) {
                this.f809a.a(1);
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
            Map<String, String> m433a = ilVar.m433a();
            if (m433a != null) {
                String str = m433a.get("extra_help_aw_info");
                String str2 = m433a.get("extra_aw_app_online_cmd");
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
        if (!m522a()) {
            fc.a();
        } else if (fc.m274a()) {
        } else {
            fc.a(true);
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m514e() {
        if (System.currentTimeMillis() - this.f797a < 30000) {
            return false;
        }
        return com.xiaomi.push.az.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f801a != null && this.f801a.m298b()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
        } else if (this.f801a != null && this.f801a.m299c()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
        } else {
            this.f802a.b(com.xiaomi.push.az.m140a((Context) this));
            g();
            if (this.f801a == null) {
                ap.a().a(this);
                c(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f  reason: collision with other method in class */
    public boolean m515f() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    private void g() {
        try {
            this.f800a.a(this.f803a, new bo(this));
            this.f800a.e();
            this.f801a = this.f800a;
        } catch (gd e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f800a.b(3, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m516g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(d, new Notification());
        } else {
            bindService(new Intent(this, this.f810a), new bp(this), 1);
        }
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m517h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !com.xiaomi.push.service.m.a(this).m581b(getPackageName());
    }

    private void i() {
        synchronized (this.f812a) {
            this.f812a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m518i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m393b((Context) this) && !com.xiaomi.push.i.m390a(getApplicationContext());
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
    public fs m519a() {
        return this.f801a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.d m520a() {
        return new com.xiaomi.push.service.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m521a() {
        if (System.currentTimeMillis() - this.f797a >= fy.a() && com.xiaomi.push.az.c(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f809a.a(i2);
    }

    public void a(int i2, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.m54a("disconnect " + hashCode() + ", " + (this.f801a == null ? null : Integer.valueOf(this.f801a.hashCode())));
        if (this.f801a != null) {
            this.f801a.b(i2, exc);
            this.f801a = null;
        }
        a(7);
        a(4);
        ap.a().a(this, i2);
    }

    public void a(fl flVar) {
        if (this.f801a == null) {
            throw new gd("try send msg while connection is null.");
        }
        this.f801a.b(flVar);
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        he.a().a(fsVar);
        c(true);
        this.f807a.m555a();
        if (!fc.m274a() && !m518i()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("reconnection successful, reactivate alarm.");
            fc.a(true);
        }
        Iterator<ap.b> it = ap.a().m544a().iterator();
        while (it.hasNext()) {
            a(new a(it.next()));
        }
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i2, Exception exc) {
        he.a().a(fsVar, i2, exc);
        if (m518i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        he.a().a(fsVar, exc);
        c(false);
        if (m518i()) {
            return;
        }
        a(false);
    }

    public void a(i iVar) {
        a(iVar, 0L);
    }

    public void a(i iVar, long j2) {
        try {
            this.f809a.a(iVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m54a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(l lVar) {
        synchronized (this.f812a) {
            this.f812a.add(lVar);
        }
    }

    public void a(ap.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m54a("schedule rebind job in " + (a2 / 1000));
            a(new a(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        ap.b a2 = ap.a().a(str, str2);
        if (a2 != null) {
            a(new q(a2, i2, str4, str3));
        }
        ap.a().m549a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<ap.b> m545a = ap.a().m545a("5");
        if (m545a.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.o.b(str, bArr);
            }
        } else if (m545a.iterator().next().f857a == ap.c.binded) {
            a(new bm(this, 4, str, bArr));
        } else if (z) {
            com.xiaomi.push.service.o.b(str, bArr);
        }
    }

    public void a(boolean z) {
        this.f807a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m54a("register request without payload");
            return;
        }
        ii iiVar = new ii();
        try {
            iw.a(iiVar, bArr);
            if (iiVar.f598a == hm.Registration) {
                im imVar = new im();
                try {
                    iw.a(imVar, iiVar.m424a());
                    com.xiaomi.push.service.o.a(iiVar.b(), bArr);
                    a(new com.xiaomi.push.service.n(this, iiVar.b(), imVar.b(), imVar.c(), bArr));
                    fb.a(getApplicationContext()).a(iiVar.b(), "E100003", imVar.a(), NodeType.E_TRAFFIC_UGC, null);
                } catch (jc e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m54a("register request with invalid payload");
            }
        } catch (jc e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            com.xiaomi.push.service.o.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(fl[] flVarArr) {
        if (this.f801a == null) {
            throw new gd("try send msg while connection is null.");
        }
        this.f801a.a(flVarArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m522a() {
        return com.xiaomi.push.az.b(this) && ap.a().m543a() > 0 && !m525b() && m517h() && !m516g() && !m515f();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m523a(int i2) {
        return this.f809a.m569a(i2);
    }

    public com.xiaomi.push.service.d b() {
        return this.f808a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public void m524b() {
        Iterator it = new ArrayList(this.f812a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).mo341a();
        }
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        he.a().b(fsVar);
    }

    public void b(i iVar) {
        this.f809a.a(iVar.a, iVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m525b() {
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
    public boolean m526c() {
        return this.f801a != null && this.f801a.m299c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m527d() {
        return this.f801a != null && this.f801a.m298b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f799a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.xiaomi.push.t.m585a((Context) this);
        com.xiaomi.push.service.k a2 = com.xiaomi.push.service.l.a((Context) this);
        if (a2 != null) {
            com.xiaomi.push.ab.a(a2.a);
        }
        this.f799a = new Messenger(new bq(this));
        au.a(this);
        this.f802a = new br(this, null, 5222, "xiaomi.com", null);
        this.f802a.a(true);
        this.f800a = new fq(this, this.f802a);
        this.f808a = m520a();
        fc.a(this);
        this.f800a.a(this);
        this.f806a = new ao(this);
        this.f807a = new az(this);
        new com.xiaomi.push.service.e().a();
        he.m334a().a(this);
        this.f809a = new com.xiaomi.push.service.g("Connection Controller Thread");
        ap a3 = ap.a();
        a3.b();
        a3.a(new bs(this));
        if (k()) {
            h();
        }
        hk.a(this).a(new com.xiaomi.push.service.i(this), "UPLOADER_PUSH_CHANNEL");
        a(new hh(this));
        a(new g());
        this.f813a.add(bg.a(this));
        if (m517h()) {
            this.f804a = new e();
            registerReceiver(this.f804a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.f798a = new bt(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f798a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.f814b = new bu(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.f814b);
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] m512a = m512a();
            if (m512a != null) {
                this.f805a = new p();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f805a, intentFilter);
                this.b = m512a[0];
                this.c = m512a[1];
                com.xiaomi.channel.commonutils.logger.b.m54a("falldown initialized: " + this.b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.c);
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("XMPushService created pid = " + d);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f804a != null) {
            a(this.f804a);
            this.f804a = null;
        }
        if (this.f805a != null) {
            a(this.f805a);
            this.f805a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f798a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f798a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m54a("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f814b != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f814b);
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.f813a.clear();
        this.f809a.m570b();
        a(new bn(this, 2));
        a(new j());
        ap.a().b();
        ap.a().a(this, 15);
        ap.a().m547a();
        this.f800a.b(this);
        be.a().m564a();
        fc.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m54a("Service destroyed");
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
                if (this.f809a.m568a()) {
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
        return a;
    }
}
