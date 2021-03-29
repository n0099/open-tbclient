package com.xiaomi.push.service;

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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.cs;
import com.xiaomi.push.db;
import com.xiaomi.push.ea;
import com.xiaomi.push.ek;
import com.xiaomi.push.el;
import com.xiaomi.push.er;
import com.xiaomi.push.fa;
import com.xiaomi.push.fh;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fo;
import com.xiaomi.push.fq;
import com.xiaomi.push.fr;
import com.xiaomi.push.fw;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.ge;
import com.xiaomi.push.gq;
import com.xiaomi.push.gx;
import com.xiaomi.push.gz;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.iv;
import com.xiaomi.push.service.av;
import com.xiaomi.push.service.h;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class XMPushService extends Service implements fo {

    /* renamed from: a  reason: collision with other field name */
    public ContentObserver f837a;

    /* renamed from: a  reason: collision with other field name */
    public fh f839a;

    /* renamed from: a  reason: collision with other field name */
    public fl f840a;

    /* renamed from: a  reason: collision with other field name */
    public fm f841a;

    /* renamed from: a  reason: collision with other field name */
    public e f843a;

    /* renamed from: a  reason: collision with other field name */
    public p f844a;

    /* renamed from: a  reason: collision with other field name */
    public bf f846a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.e f847a;

    /* renamed from: a  reason: collision with other field name */
    public String f850a;

    /* renamed from: b  reason: collision with other field name */
    public ContentObserver f853b;

    /* renamed from: a  reason: collision with root package name */
    public int f40907a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f40908b = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f836a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Class f849a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    public au f845a = null;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.h f848a = null;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f838a = null;

    /* renamed from: a  reason: collision with other field name */
    public Collection<ai> f852a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<l> f851a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public fq f842a = new br(this);

    /* loaded from: classes7.dex */
    public class a extends i {

        /* renamed from: a  reason: collision with other field name */
        public av.b f854a;

        public a(av.b bVar) {
            super(9);
            this.f854a = null;
            this.f854a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind the client. " + this.f854a.f40967g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            String str;
            try {
                if (!XMPushService.this.m548c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                av.b a2 = av.a().a(this.f854a.f40967g, this.f854a.f911b);
                if (a2 == null) {
                    str = "ignore bind because the channel " + this.f854a.f40967g + " is removed ";
                } else if (a2.f906a == av.c.unbind) {
                    a2.a(av.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.f840a.a(a2);
                    gz.a(XMPushService.this, a2);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a2.f906a;
                }
                com.xiaomi.channel.commonutils.logger.b.m51a(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                XMPushService.this.a(10, e2);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends i {

        /* renamed from: a  reason: collision with root package name */
        public final av.b f40910a;

        public b(av.b bVar) {
            super(12);
            this.f40910a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind time out. chid=" + this.f40910a.f40967g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            this.f40910a.a(av.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return TextUtils.equals(((b) obj).f40910a.f40967g, this.f40910a.f40967g);
            }
            return false;
        }

        public int hashCode() {
            return this.f40910a.f40967g.hashCode();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends i {

        /* renamed from: a  reason: collision with root package name */
        public fa f40911a;

        public c(fa faVar) {
            super(8);
            this.f40911a = null;
            this.f40911a = faVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f845a.a(this.f40911a);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends i {
        public d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.m544a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m51a("should not connect. quit the job.");
        }
    }

    /* loaded from: classes7.dex */
    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends i {

        /* renamed from: a  reason: collision with other field name */
        public Exception f856a;

        /* renamed from: b  reason: collision with root package name */
        public int f40915b;

        public f(int i, Exception exc) {
            super(2);
            this.f40915b = i;
            this.f856a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(this.f40915b, this.f856a);
        }
    }

    /* loaded from: classes7.dex */
    public class g extends i {
        public g() {
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

    /* loaded from: classes7.dex */
    public class h extends i {

        /* renamed from: a  reason: collision with root package name */
        public Intent f40917a;

        public h(Intent intent) {
            super(15);
            this.f40917a = null;
            this.f40917a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "Handle intent action = " + this.f40917a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.c(this.f40917a);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class i extends h.b {
        public i(int i) {
            super(i);
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m550a();

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f41032a;
            if (i != 4 && i != 8) {
                com.xiaomi.channel.commonutils.logger.b.m52a(com.xiaomi.channel.commonutils.logger.a.f40119a, a());
            }
            m550a();
        }
    }

    /* loaded from: classes7.dex */
    public class j extends i {
        public j() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f848a.m601a();
        }
    }

    /* loaded from: classes7.dex */
    public class k extends i {

        /* renamed from: a  reason: collision with root package name */
        public gc f40919a;

        public k(gc gcVar) {
            super(8);
            this.f40919a = null;
            this.f40919a = gcVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.f845a.a(this.f40919a);
        }
    }

    /* loaded from: classes7.dex */
    public interface l {
        /* renamed from: a */
        void mo351a();
    }

    /* loaded from: classes7.dex */
    public class m extends i {

        /* renamed from: a  reason: collision with other field name */
        public boolean f859a;

        public m(boolean z) {
            super(4);
            this.f859a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.m548c()) {
                try {
                    if (!this.f859a) {
                        gz.a();
                    }
                    XMPushService.this.f840a.b(this.f859a);
                } catch (fw e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends i {

        /* renamed from: a  reason: collision with other field name */
        public av.b f860a;

        public n(av.b bVar) {
            super(4);
            this.f860a = null;
            this.f860a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "rebind the client. " + this.f860a.f40967g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                this.f860a.a(av.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f840a.a(this.f860a.f40967g, this.f860a.f911b);
                this.f860a.a(av.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.f840a.a(this.f860a);
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                XMPushService.this.a(10, e2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends i {
        public o() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m544a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends BroadcastReceiver {
        public p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes7.dex */
    public class q extends i {

        /* renamed from: a  reason: collision with other field name */
        public av.b f861a;

        /* renamed from: a  reason: collision with other field name */
        public String f862a;

        /* renamed from: b  reason: collision with root package name */
        public int f40925b;

        /* renamed from: b  reason: collision with other field name */
        public String f863b;

        public q(av.b bVar, int i, String str, String str2) {
            super(9);
            this.f861a = null;
            this.f861a = bVar;
            this.f40925b = i;
            this.f862a = str;
            this.f863b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "unbind the channel. " + this.f861a.f40967g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (this.f861a.f906a != av.c.unbind && XMPushService.this.f840a != null) {
                try {
                    XMPushService.this.f840a.a(this.f861a.f40967g, this.f861a.f911b);
                } catch (fw e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
            this.f861a.a(av.c.unbind, this.f40925b, 0, this.f863b, this.f862a);
        }
    }

    static {
        cs.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
    }

    private gc a(gc gcVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        av a2 = av.a();
        List<String> m583a = a2.m583a(str);
        if (m583a.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            gcVar.o(str);
            str = gcVar.k();
            if (TextUtils.isEmpty(str)) {
                str = m583a.get(0);
                gcVar.l(str);
            }
            av.b a3 = a2.a(str, gcVar.m());
            if (!m548c()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a3 != null && a3.f906a == av.c.binded) {
                if (TextUtils.equals(str2, a3.i)) {
                    return gcVar;
                }
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.m51a(sb.toString());
                return null;
            } else {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.m51a(sb.toString());
        return null;
    }

    private av.b a(String str, Intent intent) {
        av.b a2 = av.a().a(str, intent.getStringExtra(az.p));
        if (a2 == null) {
            a2 = new av.b(this);
        }
        a2.f40967g = intent.getStringExtra(az.s);
        a2.f911b = intent.getStringExtra(az.p);
        a2.f40963c = intent.getStringExtra(az.u);
        a2.f908a = intent.getStringExtra(az.A);
        a2.f40965e = intent.getStringExtra(az.y);
        a2.f40966f = intent.getStringExtra(az.z);
        a2.f910a = intent.getBooleanExtra(az.x, false);
        a2.f40968h = intent.getStringExtra(az.w);
        a2.i = intent.getStringExtra(az.D);
        a2.f40964d = intent.getStringExtra(az.v);
        a2.f907a = this.f847a;
        a2.a((Messenger) intent.getParcelableExtra(az.H));
        a2.f900a = getApplicationContext();
        av.a().a(a2);
        return a2;
    }

    private String a() {
        String b2;
        com.xiaomi.push.ao.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bc a2 = bc.a(this);
            b2 = null;
            while (true) {
                if (!TextUtils.isEmpty(b2) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(b2)) {
                    b2 = com.xiaomi.push.l.m514a("ro.miui.region");
                    if (TextUtils.isEmpty(b2)) {
                        b2 = com.xiaomi.push.l.m514a("ro.product.locale.region");
                    }
                }
                try {
                    synchronized (obj) {
                        obj.wait(100L);
                    }
                } catch (InterruptedException unused) {
                }
            }
        } else {
            b2 = com.xiaomi.push.l.b();
        }
        if (!TextUtils.isEmpty(b2)) {
            com.xiaomi.push.service.a.a(getApplicationContext()).b(b2);
            str = com.xiaomi.push.l.a(b2).name();
        }
        com.xiaomi.channel.commonutils.logger.b.m51a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
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
        long j2;
        String stringExtra = intent.getStringExtra(az.A);
        String stringExtra2 = intent.getStringExtra(az.D);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        av a2 = av.a();
        fa faVar = null;
        if (bundleExtra != null) {
            gb gbVar = (gb) a(new gb(bundleExtra), stringExtra, stringExtra2);
            if (gbVar == null) {
                return;
            }
            faVar = fa.a(gbVar, a2.a(gbVar.k(), gbVar.m()).f40968h);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(az.p));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(az.q);
                String stringExtra4 = intent.getStringExtra(az.r);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                av.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                if (a3 != null) {
                    fa faVar2 = new fa();
                    try {
                        faVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    faVar2.a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    faVar2.a(j2, stringExtra3, stringExtra4);
                    faVar2.a(intent.getStringExtra("ext_pkt_id"));
                    faVar2.a(byteArrayExtra, a3.f40968h);
                    com.xiaomi.channel.commonutils.logger.b.m51a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    faVar = faVar2;
                }
            }
        }
        if (faVar != null) {
            c(new bg(this, faVar));
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ie ieVar = new ie();
        try {
            ip.a(ieVar, byteArrayExtra);
            com.xiaomi.push.ai.a(getApplicationContext()).a((ai.a) new com.xiaomi.push.service.b(ieVar, new WeakReference(this), booleanExtra), i2);
        } catch (iv unused) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(String str, int i2) {
        Collection<av.b> m582a = av.a().m582a(str);
        if (m582a != null) {
            for (av.b bVar : m582a) {
                if (bVar != null) {
                    a(new q(bVar, i2, null, null));
                }
            }
        }
        av.a().m585a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            com.xiaomi.push.ao.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.bg.c(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m533a(String str, Intent intent) {
        av.b a2 = av.a().a(str, intent.getStringExtra(az.p));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(az.D);
        String stringExtra2 = intent.getStringExtra(az.w);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m51a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.f40968h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m51a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bl.a(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m534a() {
        String[] split;
        String a2 = aq.a(getApplicationContext()).a(hk.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
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
            }
        }
        return null;
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra(az.A);
        String stringExtra2 = intent.getStringExtra(az.D);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        gb[] gbVarArr = new gb[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            gbVarArr[i2] = new gb((Bundle) parcelableArrayExtra[i2]);
            gbVarArr[i2] = (gb) a(gbVarArr[i2], stringExtra, stringExtra2);
            if (gbVarArr[i2] == null) {
                return;
            }
        }
        av a2 = av.a();
        fa[] faVarArr = new fa[length];
        for (int i3 = 0; i3 < length; i3++) {
            gb gbVar = gbVarArr[i3];
            faVarArr[i3] = fa.a(gbVar, a2.a(gbVar.k(), gbVar.m()).f40968h);
        }
        c(new com.xiaomi.push.service.c(this, faVarArr));
    }

    private void b(boolean z) {
        this.f836a = System.currentTimeMillis();
        if (m548c()) {
            if (com.xiaomi.push.bg.b(this)) {
                c(new m(z));
                return;
            }
            c(new f(17, null));
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        com.xiaomi.push.service.a a2 = com.xiaomi.push.service.a.a(getApplicationContext());
        String a3 = a2.a();
        com.xiaomi.channel.commonutils.logger.b.m51a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = a();
        }
        if (TextUtils.isEmpty(a3)) {
            this.f850a = com.xiaomi.push.o.China.name();
        } else {
            this.f850a = a3;
            a2.a(a3);
            if (com.xiaomi.push.o.Global.name().equals(this.f850a)) {
                str = "app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.Europe.name().equals(this.f850a)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.Russia.name().equals(this.f850a)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.India.name().equals(this.f850a)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            fm.a(str);
        }
        if (com.xiaomi.push.o.China.name().equals(this.f850a)) {
            fm.a("cn.app.chat.xiaomi.net");
        }
        if (m539h()) {
            ca caVar = new ca(this, 11);
            a(caVar);
            com.xiaomi.push.service.m.a(new cb(this, caVar));
        }
        try {
            if (com.xiaomi.push.t.m620a()) {
                this.f847a.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        String str;
        com.xiaomi.push.service.e eVar;
        boolean z;
        int i2;
        String format;
        i nVar;
        String str2;
        String b2;
        String str3;
        bg bgVar;
        av a2 = av.a();
        boolean z2 = true;
        int i3 = 0;
        if (az.f40983d.equalsIgnoreCase(intent.getAction()) || az.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(az.s);
            if (!TextUtils.isEmpty(intent.getStringExtra(az.w))) {
                if (stringExtra == null) {
                    str = "channel id is empty, do nothing!";
                    com.xiaomi.channel.commonutils.logger.b.d(str);
                    return;
                }
                boolean m533a = m533a(stringExtra, intent);
                av.b a3 = a(stringExtra, intent);
                if (com.xiaomi.push.bg.b(this)) {
                    if (m548c()) {
                        av.c cVar = a3.f906a;
                        if (cVar == av.c.unbind) {
                            nVar = new a(a3);
                        } else if (m533a) {
                            nVar = new n(a3);
                        } else if (cVar == av.c.binding) {
                            format = String.format("the client is binding. %1$s %2$s.", a3.f40967g, av.b.a(a3.f911b));
                        } else if (cVar != av.c.binded) {
                            return;
                        } else {
                            eVar = this.f847a;
                            z = true;
                            i2 = 0;
                        }
                        c(nVar);
                        return;
                    }
                    a(true);
                    return;
                }
                eVar = this.f847a;
                z = false;
                i2 = 2;
                eVar.a(this, a3, z, i2, null);
                return;
            }
            format = "security is empty. ignore.";
            com.xiaomi.channel.commonutils.logger.b.m51a(format);
        } else if (az.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(az.A);
            String stringExtra3 = intent.getStringExtra(az.s);
            String stringExtra4 = intent.getStringExtra(az.p);
            com.xiaomi.channel.commonutils.logger.b.m51a("Service called close channel chid = " + stringExtra3 + " res = " + av.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str4 : a2.m583a(stringExtra2)) {
                    a(str4, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
            }
        } else if (az.f40984e.equalsIgnoreCase(intent.getAction())) {
            a(intent);
        } else if (az.f40986g.equalsIgnoreCase(intent.getAction())) {
            b(intent);
        } else {
            if (az.f40985f.equalsIgnoreCase(intent.getAction())) {
                gc a4 = a(new ga(intent.getBundleExtra("ext_packet")), intent.getStringExtra(az.A), intent.getStringExtra(az.D));
                if (a4 == null) {
                    return;
                }
                bgVar = new bg(this, fa.a(a4, a2.a(a4.k(), a4.m()).f40968h));
            } else if (!az.f40987h.equalsIgnoreCase(intent.getAction())) {
                if (!az.k.equals(intent.getAction())) {
                    av.b bVar = null;
                    if (!az.l.equals(intent.getAction())) {
                        if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                                if (m540i()) {
                                    return;
                                }
                                com.xiaomi.channel.commonutils.logger.b.m51a("exit falldown mode, activate alarm.");
                                e();
                                if (m548c() || m549d()) {
                                    return;
                                }
                                a(true);
                                return;
                            } else if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) || !m540i() || !er.m277a()) {
                                return;
                            } else {
                                str2 = "enter falldown mode, stop alarm.";
                            }
                        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                            if (bc.a(getApplicationContext()).m590a() && bc.a(getApplicationContext()).a() == 0) {
                                str3 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                            } else {
                                byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                                String stringExtra5 = intent.getStringExtra("mipush_app_package");
                                boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                                int intExtra = intent.getIntExtra("mipush_env_type", 1);
                                com.xiaomi.push.service.n.a(this).d(stringExtra5);
                                if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                                    a(byteArrayExtra, stringExtra5);
                                    return;
                                }
                                nVar = new cc(this, 14, intExtra, byteArrayExtra, stringExtra5);
                            }
                        } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                            String stringExtra6 = intent.getStringExtra("mipush_app_package");
                            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                                com.xiaomi.push.service.n.a(this).a(stringExtra6);
                            }
                            a(stringExtra6, byteArrayExtra2, booleanExtra2);
                            return;
                        } else if (!bd.f40991a.equals(intent.getAction())) {
                            if (bd.f40992b.equals(intent.getAction())) {
                                String stringExtra7 = intent.getStringExtra("data_cleared_pkg_name");
                                if (stringExtra7 == null || TextUtils.isEmpty(stringExtra7.trim())) {
                                    return;
                                }
                                com.xiaomi.channel.commonutils.logger.b.m51a("clear notifications of package " + stringExtra7);
                                ac.m553a((Context) this, stringExtra7);
                                ak.a((Context) this, stringExtra7);
                                return;
                            } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                                String stringExtra8 = intent.getStringExtra(az.A);
                                int intExtra2 = intent.getIntExtra(az.B, -2);
                                if (TextUtils.isEmpty(stringExtra8)) {
                                    return;
                                }
                                if (intExtra2 >= -1) {
                                    ac.a(this, stringExtra8, intExtra2);
                                    return;
                                } else {
                                    ac.a(this, stringExtra8, intent.getStringExtra(az.F), intent.getStringExtra(az.G));
                                    return;
                                }
                            } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                                String stringExtra9 = intent.getStringExtra(az.A);
                                String stringExtra10 = intent.getStringExtra(az.E);
                                if (intent.hasExtra(az.C)) {
                                    int intExtra3 = intent.getIntExtra(az.C, 0);
                                    b2 = com.xiaomi.push.bl.b(stringExtra9 + intExtra3);
                                    i3 = intExtra3;
                                    z2 = false;
                                } else {
                                    b2 = com.xiaomi.push.bl.b(stringExtra9);
                                }
                                if (!TextUtils.isEmpty(stringExtra9) && TextUtils.equals(stringExtra10, b2)) {
                                    if (z2) {
                                        ac.m558b((Context) this, stringExtra9);
                                        return;
                                    } else {
                                        ac.b(this, stringExtra9, i3);
                                        return;
                                    }
                                }
                                str = "invalid notification for " + stringExtra9;
                                com.xiaomi.channel.commonutils.logger.b.d(str);
                                return;
                            } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                                String stringExtra11 = intent.getStringExtra("mipush_app_package");
                                if (!TextUtils.isEmpty(stringExtra11)) {
                                    com.xiaomi.push.service.n.a(this).b(stringExtra11);
                                }
                                if ("com.xiaomi.xmsf".equals(getPackageName())) {
                                    return;
                                }
                                a(19, (Exception) null);
                                e();
                                stopSelf();
                                return;
                            } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                String stringExtra12 = intent.getStringExtra("mipush_app_package");
                                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                                String stringExtra13 = intent.getStringExtra("mipush_app_id");
                                String stringExtra14 = intent.getStringExtra("mipush_app_token");
                                if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                    com.xiaomi.push.service.n.a(this).c(stringExtra12);
                                }
                                if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                    com.xiaomi.push.service.n.a(this).e(stringExtra12);
                                    com.xiaomi.push.service.n.a(this).f(stringExtra12);
                                }
                                if (byteArrayExtra3 == null) {
                                    com.xiaomi.push.service.p.a(this, stringExtra12, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                                    return;
                                }
                                com.xiaomi.push.service.p.b(stringExtra12, byteArrayExtra3);
                                a(new com.xiaomi.push.service.o(this, stringExtra12, stringExtra13, stringExtra14, byteArrayExtra3));
                                if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f843a == null) {
                                    this.f843a = new e();
                                    registerReceiver(this.f843a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                    return;
                                }
                                return;
                            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                                String stringExtra15 = intent.getStringExtra("mipush_app_package");
                                byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                                hj hjVar = new hj();
                                try {
                                    ip.a(hjVar, byteArrayExtra4);
                                    hd.a(this).a(hjVar, stringExtra15);
                                    return;
                                } catch (iv e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    return;
                                }
                            } else {
                                if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                                    com.xiaomi.channel.commonutils.logger.b.m51a("Service called on timer");
                                    if (!m540i()) {
                                        er.a(false);
                                        if (!m536e()) {
                                            return;
                                        }
                                    } else if (!er.m277a()) {
                                        return;
                                    } else {
                                        str2 = "enter falldown mode, stop alarm";
                                    }
                                } else if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                                    if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                                        com.xiaomi.channel.commonutils.logger.b.m51a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                                        er.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                                        return;
                                    } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                                        d();
                                        return;
                                    } else if ("action_cr_config".equals(intent.getAction())) {
                                        boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                                        long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                                        boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                                        long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                                        boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                                        long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                                        Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(com.xiaomi.push.bq.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
                                        if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                            return;
                                        }
                                        ek.a(getApplicationContext(), build);
                                        return;
                                    } else if (!"action_help_ping".equals(intent.getAction())) {
                                        if ("action_aw_app_logic".equals(intent.getAction())) {
                                            d(intent);
                                            return;
                                        }
                                        return;
                                    } else {
                                        boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                                        int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                                        if (intExtra4 >= 0 && intExtra4 < 30) {
                                            com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                                            intExtra4 = 30;
                                        }
                                        boolean z3 = intExtra4 >= 0 ? booleanExtra6 : false;
                                        com.xiaomi.channel.commonutils.logger.b.m51a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
                                        if (!z3 || intExtra4 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                                            return;
                                        }
                                        a(intent, intExtra4);
                                        return;
                                    }
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.m51a("Service called on check alive.");
                                    if (!m536e()) {
                                        return;
                                    }
                                }
                                b(false);
                                return;
                            }
                        } else {
                            String stringExtra16 = intent.getStringExtra("uninstall_pkg_name");
                            if (stringExtra16 == null || TextUtils.isEmpty(stringExtra16.trim())) {
                                return;
                            }
                            try {
                                getPackageManager().getPackageInfo(stringExtra16, 0);
                                z2 = false;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                            if (!"com.xiaomi.channel".equals(stringExtra16) || av.a().m582a("1").isEmpty() || !z2) {
                                SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                String string = sharedPreferences.getString(stringExtra16, null);
                                if (TextUtils.isEmpty(string) || !z2) {
                                    return;
                                }
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.remove(stringExtra16);
                                edit.commit();
                                if (ac.m559b((Context) this, stringExtra16)) {
                                    ac.m558b((Context) this, stringExtra16);
                                }
                                ac.m553a((Context) this, stringExtra16);
                                if (!m548c() || string == null) {
                                    return;
                                }
                                try {
                                    y.a(this, y.a(stringExtra16, string));
                                    com.xiaomi.channel.commonutils.logger.b.m51a("uninstall " + stringExtra16 + " msg sent");
                                    return;
                                } catch (fw e3) {
                                    com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                                    a(10, e3);
                                    return;
                                }
                            }
                            a("1", 0);
                            str3 = "close the miliao channel as the app is uninstalled.";
                        }
                        com.xiaomi.channel.commonutils.logger.b.m51a(str2);
                        er.a();
                        return;
                    }
                    String stringExtra17 = intent.getStringExtra(az.A);
                    List<String> m583a = a2.m583a(stringExtra17);
                    if (!m583a.isEmpty()) {
                        String stringExtra18 = intent.getStringExtra(az.s);
                        String stringExtra19 = intent.getStringExtra(az.p);
                        if (TextUtils.isEmpty(stringExtra18)) {
                            stringExtra18 = m583a.get(0);
                        }
                        if (TextUtils.isEmpty(stringExtra19)) {
                            Collection<av.b> m582a = a2.m582a(stringExtra18);
                            if (m582a != null && !m582a.isEmpty()) {
                                bVar = m582a.iterator().next();
                            }
                        } else {
                            bVar = a2.a(stringExtra18, stringExtra19);
                        }
                        if (bVar != null) {
                            if (intent.hasExtra(az.y)) {
                                bVar.f40965e = intent.getStringExtra(az.y);
                            }
                            if (intent.hasExtra(az.z)) {
                                bVar.f40966f = intent.getStringExtra(az.z);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    str3 = "open channel should be called first before update info, pkg=" + stringExtra17;
                    com.xiaomi.channel.commonutils.logger.b.m51a(str3);
                    return;
                }
                String stringExtra20 = intent.getStringExtra(az.s);
                String stringExtra21 = intent.getStringExtra(az.p);
                if (stringExtra20 == null) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m51a("request reset connection from chid = " + stringExtra20);
                av.b a5 = av.a().a(stringExtra20, stringExtra21);
                if (a5 == null || !a5.f40968h.equals(intent.getStringExtra(az.w)) || a5.f906a != av.c.binded) {
                    return;
                }
                fl m541a = m541a();
                if (m541a != null && m541a.a(System.currentTimeMillis() - 15000)) {
                    return;
                }
                nVar = new o();
                c(nVar);
                return;
            } else {
                gc a6 = a(new ge(intent.getBundleExtra("ext_packet")), intent.getStringExtra(az.A), intent.getStringExtra(az.D));
                if (a6 == null) {
                    return;
                }
                bgVar = new bg(this, fa.a(a6, a2.a(a6.k(), a6.m()).f40968h));
            }
            c(bgVar);
        }
    }

    private void c(i iVar) {
        this.f848a.a(iVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.t.m620a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ai aiVar : (ai[]) this.f852a.toArray(new ai[0])) {
                    aiVar.mo600a();
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            networkInfo = null;
        }
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            com.xiaomi.channel.commonutils.logger.b.m51a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m51a("network changed, no active network");
        }
        if (gx.a() != null) {
            gx.a().m343a();
        }
        gq.m340a((Context) this);
        this.f839a.d();
        if (com.xiaomi.push.bg.b(this)) {
            if (m548c() && m536e()) {
                b(false);
            }
            if (!m548c() && !m549d()) {
                this.f848a.a(1);
                a(new d());
            }
            db.a(this).a();
        } else {
            a(new f(2, null));
        }
        e();
    }

    private void d(Intent intent) {
        int i2;
        try {
            ea.a(getApplicationContext()).a(new bb());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            ie ieVar = new ie();
            ip.a(ieVar, byteArrayExtra);
            String b2 = ieVar.b();
            Map<String, String> m447a = ieVar.m447a();
            if (m447a != null) {
                String str = m447a.get("extra_help_aw_info");
                String str2 = m447a.get("extra_aw_app_online_cmd");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
                    return;
                }
                ea.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
            }
        } catch (iv e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m544a()) {
            er.a();
        } else if (er.m277a()) {
        } else {
            er.a(true);
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m536e() {
        if (System.currentTimeMillis() - this.f836a < StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
            return false;
        }
        return com.xiaomi.push.bg.d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        fl flVar = this.f840a;
        if (flVar == null || !flVar.m307b()) {
            fl flVar2 = this.f840a;
            if (flVar2 == null || !flVar2.m308c()) {
                this.f841a.b(com.xiaomi.push.bg.m153a((Context) this));
                g();
                if (this.f840a == null) {
                    av.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f  reason: collision with other method in class */
    public boolean m537f() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    private void g() {
        try {
            this.f839a.a(this.f842a, new bu(this));
            this.f839a.e();
            this.f840a = this.f839a;
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f839a.b(3, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m538g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m539h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !com.xiaomi.push.service.n.a(this).m615b(getPackageName());
    }

    private void i() {
        synchronized (this.f851a) {
            this.f851a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m540i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m421b((Context) this) && !com.xiaomi.push.i.m418a(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f40907a;
        int i3 = this.f40908b;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return aq.a(this).a(hk.ForegroundServiceSwitch.a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public fl m541a() {
        return this.f840a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.e m542a() {
        return new com.xiaomi.push.service.e();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m543a() {
        if (System.currentTimeMillis() - this.f836a >= fr.a() && com.xiaomi.push.bg.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f848a.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        fl flVar = this.f840a;
        sb.append(flVar == null ? null : Integer.valueOf(flVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m51a(sb.toString());
        fl flVar2 = this.f840a;
        if (flVar2 != null) {
            flVar2.b(i2, exc);
            this.f840a = null;
        }
        a(7);
        a(4);
        av.a().a(this, i2);
    }

    public void a(fa faVar) {
        fl flVar = this.f840a;
        if (flVar == null) {
            throw new fw("try send msg while connection is null.");
        }
        flVar.b(faVar);
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        gx.a().a(flVar);
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        gx.a().a(flVar, i2, exc);
        if (m540i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        gx.a().a(flVar, exc);
        c(false);
        if (m540i()) {
            return;
        }
        a(false);
    }

    public void a(i iVar) {
        a(iVar, 0L);
    }

    public void a(i iVar, long j2) {
        try {
            this.f848a.a(iVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(l lVar) {
        synchronized (this.f851a) {
            this.f851a.add(lVar);
        }
    }

    public void a(av.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m51a("schedule rebind job in " + (a2 / 1000));
            a(new a(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        av.b a2 = av.a().a(str, str2);
        if (a2 != null) {
            a(new q(a2, i2, str4, str3));
        }
        av.a().m586a(str, str2);
    }

    public void a(String str, byte[] bArr, boolean z) {
        Collection<av.b> m582a = av.a().m582a("5");
        if (m582a.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (m582a.iterator().next().f906a == av.c.binded) {
            a(new bs(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        com.xiaomi.push.service.p.b(str, bArr);
    }

    public void a(boolean z) {
        this.f846a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m51a("register request without payload");
            return;
        }
        ib ibVar = new ib();
        try {
            ip.a(ibVar, bArr);
            if (ibVar.f628a == hf.Registration) {
                Cif cif = new Cif();
                try {
                    ip.a(cif, ibVar.m437a());
                    com.xiaomi.push.service.p.a(ibVar.b(), bArr);
                    a(new com.xiaomi.push.service.o(this, ibVar.b(), cif.b(), cif.c(), bArr));
                    el.a(getApplicationContext()).a(ibVar.b(), "E100003", cif.a(), 6002, null);
                } catch (iv e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m51a("register request with invalid payload");
            }
        } catch (iv e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(fa[] faVarArr) {
        fl flVar = this.f840a;
        if (flVar == null) {
            throw new fw("try send msg while connection is null.");
        }
        flVar.a(faVarArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m544a() {
        boolean b2 = com.xiaomi.push.bg.b(this);
        boolean z = av.a().m580a() > 0;
        boolean z2 = !m547b();
        boolean m539h = m539h();
        boolean z3 = !m538g();
        boolean z4 = !m537f();
        boolean z5 = b2 && z && z2 && m539h && z3 && z4;
        if (!z5) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;!eps=%s", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m539h), Boolean.valueOf(z3), Boolean.valueOf(z4)));
        }
        return z5;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m545a(int i2) {
        return this.f848a.m603a(i2);
    }

    public com.xiaomi.push.service.e b() {
        return this.f847a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m546b() {
        Iterator it = new ArrayList(this.f851a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).mo351a();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        gx.a().b(flVar);
        c(true);
        this.f846a.m592a();
        if (!er.m277a() && !m540i()) {
            com.xiaomi.channel.commonutils.logger.b.m51a("reconnection successful, reactivate alarm.");
            er.a(true);
        }
        Iterator<av.b> it = av.a().m581a().iterator();
        while (it.hasNext()) {
            a(new a(it.next()));
        }
    }

    public void b(i iVar) {
        this.f848a.a(iVar.f41032a, iVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m547b() {
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
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m548c() {
        fl flVar = this.f840a;
        return flVar != null && flVar.m308c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m549d() {
        fl flVar = this.f840a;
        return flVar != null && flVar.m307b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f838a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.t.m619a((Context) this);
        com.xiaomi.push.service.l a2 = com.xiaomi.push.service.m.a((Context) this);
        if (a2 != null) {
            com.xiaomi.push.ab.a(a2.f41044a);
        }
        this.f838a = new Messenger(new bv(this));
        ba.a(this);
        bw bwVar = new bw(this, null, 5222, "xiaomi.com", null);
        this.f841a = bwVar;
        bwVar.a(true);
        this.f839a = new fh(this, this.f841a);
        this.f847a = m542a();
        er.a(this);
        this.f839a.a(this);
        this.f845a = new au(this);
        this.f846a = new bf(this);
        new com.xiaomi.push.service.f().a();
        gx.m344a().a(this);
        this.f848a = new com.xiaomi.push.service.h("Connection Controller Thread");
        av a3 = av.a();
        a3.b();
        a3.a(new bx(this));
        if (k()) {
            h();
        }
        hd.a(this).a(new com.xiaomi.push.service.j(this), "UPLOADER_PUSH_CHANNEL");
        a(new ha(this));
        a(new g());
        this.f852a.add(bk.a(this));
        if (m539h()) {
            this.f843a = new e();
            registerReceiver(this.f843a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.f837a = new by(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f837a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.f853b = new bz(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.f853b);
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] m534a = m534a();
            if (m534a != null) {
                this.f844a = new p();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f844a, intentFilter);
                this.f40907a = m534a[0];
                this.f40908b = m534a[1];
                com.xiaomi.channel.commonutils.logger.b.m51a("falldown initialized: " + this.f40907a + "," + this.f40908b);
            }
        }
        String str = "";
        if (a2 != null) {
            try {
                if (!TextUtils.isEmpty(a2.f959a) && (split = a2.f959a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        e eVar = this.f843a;
        if (eVar != null) {
            a(eVar);
            this.f843a = null;
        }
        p pVar = this.f844a;
        if (pVar != null) {
            a(pVar);
            this.f844a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f837a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f837a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m51a("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f853b != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f853b);
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.f852a.clear();
        this.f848a.m604b();
        a(new bt(this, 2));
        a(new j());
        av.a().b();
        av.a().a(this, 15);
        av.a().m584a();
        this.f839a.b(this);
        bi.a().m598a();
        er.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m51a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        h hVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.m51a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(az.s), intent.getStringExtra(az.A), intent.getStringExtra("mipush_app_package")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f848a.m602a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    av.a().a(this, 14);
                    stopSelf();
                } else {
                    hVar = new h(intent);
                    a(hVar);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                hVar = new h(intent);
                a(hVar);
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
        return 1;
    }
}
