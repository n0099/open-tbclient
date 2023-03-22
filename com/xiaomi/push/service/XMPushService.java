package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.aj;
import com.xiaomi.push.dc;
import com.xiaomi.push.de;
import com.xiaomi.push.ec;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.et;
import com.xiaomi.push.fg;
import com.xiaomi.push.fi;
import com.xiaomi.push.fk;
import com.xiaomi.push.fr;
import com.xiaomi.push.fv;
import com.xiaomi.push.fw;
import com.xiaomi.push.fy;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.go;
import com.xiaomi.push.ha;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hh;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.ir;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class XMPushService extends Service implements fy {
    public static boolean b;

    /* renamed from: a  reason: collision with other field name */
    public ContentObserver f843a;

    /* renamed from: a  reason: collision with other field name */
    public fr f845a;

    /* renamed from: a  reason: collision with other field name */
    public fv f846a;

    /* renamed from: a  reason: collision with other field name */
    public fw f847a;

    /* renamed from: a  reason: collision with other field name */
    public a f849a;

    /* renamed from: a  reason: collision with other field name */
    public f f850a;

    /* renamed from: a  reason: collision with other field name */
    public k f851a;

    /* renamed from: a  reason: collision with other field name */
    public r f852a;

    /* renamed from: a  reason: collision with other field name */
    public t f853a;

    /* renamed from: a  reason: collision with other field name */
    public bq f855a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.j f856a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f861a = false;
    public int a = 0;

    /* renamed from: b  reason: collision with other field name */
    public int f862b = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f842a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Class f858a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    public be f854a = null;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.p f857a = null;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f844a = null;

    /* renamed from: a  reason: collision with other field name */
    public Collection<ar> f860a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<n> f859a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public ga f848a = new ci(this);

    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        public final Object f863a;

        public a() {
            this.f863a = new Object();
        }

        public /* synthetic */ a(XMPushService xMPushService, ci ciVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f863a) {
                try {
                    this.f863a.notifyAll();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m99a("[Alarm] notify lock. " + e);
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f863a) {
                try {
                    this.f863a.wait(j);
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.m99a("[Alarm] interrupt from waiting state. " + e);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!bk.p.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.m99a("[Alarm] cancel the old ping timer");
                et.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000L);
                    com.xiaomi.channel.commonutils.logger.b.m99a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends j {

        /* renamed from: a  reason: collision with other field name */
        public bg.b f864a;

        public b(bg.b bVar) {
            super(9);
            this.f864a = null;
            this.f864a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "bind the client. " + this.f864a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            String str;
            try {
                if (!XMPushService.this.m672c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                bg.b a = bg.a().a(this.f864a.g, this.f864a.f938b);
                if (a == null) {
                    str = "ignore bind because the channel " + this.f864a.g + " is removed ";
                } else if (a.f933a == bg.c.unbind) {
                    a.a(bg.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.f846a.a(a);
                    fi.a(XMPushService.this, a);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a.f933a;
                }
                com.xiaomi.channel.commonutils.logger.b.m99a(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e);
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends j {
        public final bg.b a;

        public c(bg.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "bind time out. chid=" + this.a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            this.a.a(bg.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).a.g, this.a.g);
            }
            return false;
        }

        public int hashCode() {
            return this.a.g.hashCode();
        }
    }

    /* loaded from: classes8.dex */
    public class d extends j {
        public fk a;

        public d(fk fkVar) {
            super(8);
            this.a = null;
            this.a = fkVar;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.service.XMPushService.j.a()Ljava/lang/String; */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.service.XMPushService.j.a()V */
        public fk a() {
            return this.a;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public String mo674a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            an anVar = this.a.f375a;
            if (anVar != null) {
                anVar.c = System.currentTimeMillis();
            }
            XMPushService.this.f854a.a(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends j {
        public e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            if (XMPushService.this.m667a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m99a("should not connect. quit the job.");
        }
    }

    /* loaded from: classes8.dex */
    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m99a("network changed, " + com.xiaomi.push.j.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class g extends j {

        /* renamed from: a  reason: collision with other field name */
        public Exception f866a;
        public int b;

        public g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f866a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            XMPushService.this.a(this.b, this.f866a);
        }
    }

    /* loaded from: classes8.dex */
    public class h extends j {
        public h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            XMPushService.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public class i extends j {
        public Intent a;

        public i(Intent intent) {
            super(15);
            this.a = null;
            this.a = intent;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.service.XMPushService.j.a()Ljava/lang/String; */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.service.XMPushService.j.a()V */
        public Intent a() {
            return this.a;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "Handle intent action = " + this.a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            XMPushService.this.d(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class j extends p.b {
        public j(int i) {
            super(i);
        }

        /* renamed from: a */
        public abstract String mo674a();

        /* renamed from: a */
        public abstract void mo391a();

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i != 4 && i != 8) {
                com.xiaomi.channel.commonutils.logger.b.m100a(com.xiaomi.channel.commonutils.logger.a.a, mo674a());
            }
            mo391a();
        }
    }

    /* loaded from: classes8.dex */
    public class k extends BroadcastReceiver {
        public k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m99a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            XMPushService.this.f857a.m744a();
        }
    }

    /* loaded from: classes8.dex */
    public class m extends j {
        public gm a;

        public m(gm gmVar) {
            super(8);
            this.a = null;
            this.a = gmVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            XMPushService.this.f854a.a(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public interface n {
        /* renamed from: a */
        void mo466a();
    }

    /* loaded from: classes8.dex */
    public class o extends j {

        /* renamed from: a  reason: collision with other field name */
        public boolean f869a;

        public o(boolean z) {
            super(4);
            this.f869a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            if (XMPushService.this.m672c()) {
                try {
                    if (!this.f869a) {
                        fi.a();
                    }
                    XMPushService.this.f846a.b(this.f869a);
                } catch (gg e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p extends j {

        /* renamed from: a  reason: collision with other field name */
        public bg.b f870a;

        public p(bg.b bVar) {
            super(4);
            this.f870a = null;
            this.f870a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "rebind the client. " + this.f870a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            try {
                this.f870a.a(bg.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f846a.a(this.f870a.g, this.f870a.f938b);
                XMPushService.this.a(new b(this.f870a), 300L);
            } catch (gg e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends j {
        public q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m667a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends BroadcastReceiver {
        public r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class s extends j {

        /* renamed from: a  reason: collision with other field name */
        public bg.b f871a;

        /* renamed from: a  reason: collision with other field name */
        public String f872a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public String f873b;

        public s(bg.b bVar, int i, String str, String str2) {
            super(9);
            this.f871a = null;
            this.f871a = bVar;
            this.b = i;
            this.f872a = str;
            this.f873b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo674a() {
            return "unbind the channel. " + this.f871a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo391a() {
            if (this.f871a.f933a != bg.c.unbind && XMPushService.this.f846a != null) {
                try {
                    XMPushService.this.f846a.a(this.f871a.g, this.f871a.f938b);
                } catch (gg e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f871a.a(bg.c.unbind, this.b, 0, this.f873b, this.f872a);
        }
    }

    /* loaded from: classes8.dex */
    public class t extends BroadcastReceiver {
        public t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f861a) {
                XMPushService.this.f861a = true;
            }
            com.xiaomi.channel.commonutils.logger.b.m99a("[HB] wifi changed, " + com.xiaomi.push.j.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    private gm a(gm gmVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        bg a2 = bg.a();
        List<String> m713a = a2.m713a(str);
        if (m713a.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            gmVar.o(str);
            str = gmVar.k();
            if (TextUtils.isEmpty(str)) {
                str = m713a.get(0);
                gmVar.l(str);
            }
            bg.b a3 = a2.a(str, gmVar.m());
            if (!m672c()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a3 != null && a3.f933a == bg.c.binded) {
                if (TextUtils.equals(str2, a3.i)) {
                    return gmVar;
                }
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.m99a(sb.toString());
                return null;
            } else {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.m99a(sb.toString());
        return null;
    }

    private bg.b a(String str, Intent intent) {
        bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
        if (a2 == null) {
            a2 = new bg.b(this);
        }
        a2.g = intent.getStringExtra(bk.t);
        a2.f938b = intent.getStringExtra(bk.q);
        a2.c = intent.getStringExtra(bk.v);
        a2.f935a = intent.getStringExtra(bk.B);
        a2.e = intent.getStringExtra(bk.z);
        a2.f = intent.getStringExtra(bk.A);
        a2.f937a = intent.getBooleanExtra(bk.y, false);
        a2.h = intent.getStringExtra(bk.x);
        a2.i = intent.getStringExtra(bk.F);
        a2.d = intent.getStringExtra(bk.w);
        a2.f934a = this.f856a;
        a2.a((Messenger) intent.getParcelableExtra(bk.J));
        a2.f927a = getApplicationContext();
        bg.a().a(a2);
        return a2;
    }

    private String a() {
        String m627a = com.xiaomi.push.j.m627a("ro.miui.region");
        return TextUtils.isEmpty(m627a) ? com.xiaomi.push.j.m627a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP) : m627a;
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
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        com.xiaomi.push.service.o.a(getApplicationContext()).m740a(extras.getString("digest"));
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ig igVar = new ig();
        try {
            ir.a(igVar, byteArrayExtra);
            com.xiaomi.push.aj.a(getApplicationContext()).a((aj.a) new com.xiaomi.push.service.b(igVar, new WeakReference(this), booleanExtra), i2);
        } catch (ix unused) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    public static void a(String str) {
        if (com.xiaomi.push.n.China.name().equals(str)) {
            com.xiaomi.push.cu.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            com.xiaomi.push.cu.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            com.xiaomi.push.cu.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            com.xiaomi.push.cu.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            com.xiaomi.push.cu.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            com.xiaomi.push.cu.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            com.xiaomi.push.cu.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    private void a(String str, int i2) {
        Collection<bg.b> m712a = bg.a().m712a(str);
        if (m712a != null) {
            for (bg.b bVar : m712a) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        bg.a().m715a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            com.xiaomi.push.ap.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.bi.c(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m99a("network connectivity ok.");
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
    private boolean m656a(String str, Intent intent) {
        bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(bk.F);
        String stringExtra2 = intent.getStringExtra(bk.x);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m99a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m99a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bn.a(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m657a() {
        String[] split;
        String a2 = ba.a(getApplicationContext()).a(hm.FallDownTimeRange.a(), "");
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

    private String b() {
        String str;
        com.xiaomi.push.ap.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bn a2 = bn.a(this);
            String str2 = null;
            while (true) {
                if (!TextUtils.isEmpty(str2) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
            str = a();
        } else {
            str = "CN";
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.xiaomi.channel.commonutils.logger.b.m99a("wait coutrycode :" + str + " cost = " + elapsedRealtime2 + " , count = " + i2);
        return str;
    }

    private void b(Intent intent) {
        long j2;
        String str;
        fk fkVar;
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        bg a2 = bg.a();
        if (bundleExtra != null) {
            gl glVar = (gl) a(new gl(bundleExtra), stringExtra, stringExtra2);
            if (glVar == null) {
                return;
            }
            fkVar = fk.a(glVar, a2.a(glVar.k(), glVar.m()).h);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(bk.q));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(bk.r);
                String stringExtra4 = intent.getStringExtra(bk.s);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                bg.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                if (a3 != null) {
                    fk fkVar2 = new fk();
                    if ("10".equals(stringExtra5)) {
                        fkVar2.b(Integer.parseInt("10"));
                        fkVar2.f375a.f901a = intent.getBooleanExtra("screen_on", true);
                        fkVar2.f375a.f903b = intent.getBooleanExtra("wifi", true);
                        str = stringExtra3;
                        fkVar2.f375a.f900a = intent.getLongExtra("rx_msg", -1L);
                        fkVar2.f375a.f902b = intent.getLongExtra("enqueue", -1L);
                        fkVar2.f375a.b = intent.getIntExtra("num", -1);
                        fkVar2.f375a.c = intent.getLongExtra("run", -1L);
                    } else {
                        str = stringExtra3;
                    }
                    try {
                        fkVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    fkVar2.a("SECMSG", (String) null);
                    fkVar2.a(j2, TextUtils.isEmpty(str) ? "xiaomi.com" : str, stringExtra4);
                    fkVar2.a(intent.getStringExtra("ext_pkt_id"));
                    fkVar2.a(byteArrayExtra, a3.h);
                    com.xiaomi.channel.commonutils.logger.b.m99a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    fkVar = fkVar2;
                }
            }
            fkVar = null;
        }
        if (fkVar != null) {
            c(new bt(this, fkVar));
        }
    }

    private void b(boolean z) {
        this.f842a = SystemClock.elapsedRealtime();
        if (m672c()) {
            if (com.xiaomi.push.bi.b(this)) {
                c(new o(z));
                return;
            }
            c(new g(17, null));
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af A[Catch: Exception -> 0x00b5, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b5, blocks: (B:23:0x00a9, B:25:0x00af), top: B:30:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        com.xiaomi.push.service.o.a(getApplicationContext()).m739a();
        com.xiaomi.push.service.a a2 = com.xiaomi.push.service.a.a(getApplicationContext());
        String a3 = a2.a();
        com.xiaomi.channel.commonutils.logger.b.m99a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = com.xiaomi.push.j.a(b()).name();
        }
        String str = "CN";
        try {
            if (TextUtils.isEmpty(a3) || !com.xiaomi.push.n.China.name().equals(a3)) {
                if (TextUtils.isEmpty(a3)) {
                    a3 = com.xiaomi.push.n.China.name();
                    if (com.xiaomi.push.n.China.name().equals(a3)) {
                        fw.a("cn.app.chat.xiaomi.net");
                    }
                    a(a3);
                    if (m662h()) {
                        cs csVar = new cs(this, 11);
                        a(csVar);
                        u.a(new ct(this, csVar));
                    }
                    if (com.xiaomi.push.s.m643a()) {
                        return;
                    }
                    this.f856a.a(this);
                    return;
                } else if ("com.xiaomi.xmsf".equals(getPackageName())) {
                    a3 = "";
                    str = a3;
                } else {
                    a3 = com.xiaomi.push.n.China.name();
                }
            }
            if (com.xiaomi.push.s.m643a()) {
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return;
        }
        a2.a(a3, true);
        a2.b(str, true);
        if (com.xiaomi.push.n.China.name().equals(a3)) {
        }
        a(a3);
        if (m662h()) {
        }
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        gl[] glVarArr = new gl[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            glVarArr[i2] = new gl((Bundle) parcelableArrayExtra[i2]);
            glVarArr[i2] = (gl) a(glVarArr[i2], stringExtra, stringExtra2);
            if (glVarArr[i2] == null) {
                return;
            }
        }
        bg a2 = bg.a();
        fk[] fkVarArr = new fk[length];
        for (int i3 = 0; i3 < length; i3++) {
            gl glVar = glVarArr[i3];
            fkVarArr[i3] = fk.a(glVar, a2.a(glVar.k(), glVar.m()).h);
        }
        c(new com.xiaomi.push.service.c(this, fkVarArr));
    }

    private void c(j jVar) {
        this.f857a.a(jVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.s.m643a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ar arVar : (ar[]) this.f860a.toArray(new ar[0])) {
                    arVar.mo730a();
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
        com.xiaomi.push.service.o.a(getApplicationContext()).a(networkInfo);
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append(PreferencesUtil.LEFT_MOUNT + "type: " + networkInfo.getTypeName() + PreferencesUtil.LEFT_MOUNT + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            com.xiaomi.channel.commonutils.logger.b.m99a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m99a("network changed, no active network");
        }
        if (fg.a() != null) {
            fg.a().m393a();
        }
        ha.m464a((Context) this);
        this.f845a.d();
        if (com.xiaomi.push.bi.b(this)) {
            if (m672c() && m660f()) {
                b(false);
            }
            if (!m672c() && !m673d()) {
                this.f857a.a(1);
                a(new e());
            }
            de.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:376:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(Intent intent) {
        String str;
        com.xiaomi.push.service.j jVar;
        boolean z;
        int i2;
        String format;
        j pVar;
        int i3;
        String b2;
        SharedPreferences sharedPreferences;
        String str2;
        bt btVar;
        bg a2 = bg.a();
        boolean z2 = true;
        int i4 = 0;
        if (bk.d.equalsIgnoreCase(intent.getAction()) || bk.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(bk.t);
            if (!TextUtils.isEmpty(intent.getStringExtra(bk.x))) {
                if (TextUtils.isEmpty(stringExtra)) {
                    str = "channel id is empty, do nothing!";
                    com.xiaomi.channel.commonutils.logger.b.d(str);
                    return;
                }
                boolean m656a = m656a(stringExtra, intent);
                bg.b a3 = a(stringExtra, intent);
                if (com.xiaomi.push.bi.c(this)) {
                    if (m672c()) {
                        bg.c cVar = a3.f933a;
                        if (cVar == bg.c.unbind) {
                            pVar = new b(a3);
                        } else if (m656a) {
                            pVar = new p(a3);
                        } else if (cVar == bg.c.binding) {
                            format = String.format("the client is binding. %1$s %2$s.", a3.g, bg.b.a(a3.f938b));
                        } else if (cVar != bg.c.binded) {
                            return;
                        } else {
                            jVar = this.f856a;
                            z = true;
                            i2 = 0;
                        }
                        c(pVar);
                        return;
                    }
                    a(true);
                    return;
                }
                jVar = this.f856a;
                z = false;
                i2 = 2;
                jVar.a(this, a3, z, i2, null);
                return;
            }
            format = "security is empty. ignore.";
            com.xiaomi.channel.commonutils.logger.b.m99a(format);
        } else if (bk.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(bk.B);
            String stringExtra3 = intent.getStringExtra(bk.t);
            String stringExtra4 = intent.getStringExtra(bk.q);
            com.xiaomi.channel.commonutils.logger.b.m99a("Service called close channel chid = " + stringExtra3 + " res = " + bg.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str3 : a2.m713a(stringExtra2)) {
                    a(str3, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
            }
        } else if (bk.e.equalsIgnoreCase(intent.getAction())) {
            if ("10".equals(intent.getStringExtra("ext_chid"))) {
                intent.putExtra("run", System.currentTimeMillis());
            }
            b(intent);
        } else if (bk.g.equalsIgnoreCase(intent.getAction())) {
            c(intent);
        } else {
            if (bk.f.equalsIgnoreCase(intent.getAction())) {
                gm a4 = a(new gk(intent.getBundleExtra("ext_packet")), intent.getStringExtra(bk.B), intent.getStringExtra(bk.F));
                if (a4 == null) {
                    return;
                }
                btVar = new bt(this, fk.a(a4, a2.a(a4.k(), a4.m()).h));
            } else if (!bk.h.equalsIgnoreCase(intent.getAction())) {
                if (!bk.k.equals(intent.getAction())) {
                    String str4 = null;
                    r2 = null;
                    bg.b a5 = null;
                    str4 = null;
                    if (bk.l.equals(intent.getAction())) {
                        String stringExtra5 = intent.getStringExtra(bk.B);
                        List<String> m713a = a2.m713a(stringExtra5);
                        if (!m713a.isEmpty()) {
                            String stringExtra6 = intent.getStringExtra(bk.t);
                            String stringExtra7 = intent.getStringExtra(bk.q);
                            if (TextUtils.isEmpty(stringExtra6)) {
                                stringExtra6 = m713a.get(0);
                            }
                            if (TextUtils.isEmpty(stringExtra7)) {
                                Collection<bg.b> m712a = a2.m712a(stringExtra6);
                                if (m712a != null && !m712a.isEmpty()) {
                                    a5 = m712a.iterator().next();
                                }
                            } else {
                                a5 = a2.a(stringExtra6, stringExtra7);
                            }
                            if (a5 != null) {
                                if (intent.hasExtra(bk.z)) {
                                    a5.e = intent.getStringExtra(bk.z);
                                }
                                if (intent.hasExtra(bk.A)) {
                                    a5.f = intent.getStringExtra(bk.A);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = "open channel should be called first before update info, pkg=" + stringExtra5;
                    } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        if (!"android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m663i() && et.m385a()) {
                                com.xiaomi.channel.commonutils.logger.b.m99a("enter falldown mode, stop alarm.");
                                et.a();
                                return;
                            }
                            return;
                        } else if (m663i()) {
                            return;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.m99a("exit falldown mode, activate alarm.");
                            e();
                            if (m672c() || m673d()) {
                                return;
                            }
                            a(true);
                            return;
                        }
                    } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                        if (bn.a(getApplicationContext()).m720a() && bn.a(getApplicationContext()).a() == 0) {
                            str2 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                        } else {
                            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                            String stringExtra8 = intent.getStringExtra("mipush_app_package");
                            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                            int intExtra = intent.getIntExtra("mipush_env_type", 1);
                            v.a(this).d(stringExtra8);
                            if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                                a(byteArrayExtra, stringExtra8);
                                return;
                            }
                            pVar = new cu(this, 14, intExtra, stringExtra8, byteArrayExtra);
                        }
                    } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                        String stringExtra9 = intent.getStringExtra("mipush_app_package");
                        byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                        boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                        if (com.xiaomi.push.service.m.a(byteArrayExtra2, stringExtra9)) {
                            format = "duplicate msg from: " + String.valueOf(stringExtra9);
                            com.xiaomi.channel.commonutils.logger.b.m99a(format);
                        }
                        if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                            v.a(this).a(stringExtra9);
                            if (com.xiaomi.push.j.m630a(getApplicationContext())) {
                                ag.a(stringExtra9);
                            }
                        }
                        a(stringExtra9, byteArrayExtra2, booleanExtra2);
                        return;
                    } else if (!bo.a.equals(intent.getAction())) {
                        if (bo.b.equals(intent.getAction())) {
                            String stringExtra10 = intent.getStringExtra("data_cleared_pkg_name");
                            if (TextUtils.isEmpty(stringExtra10)) {
                                return;
                            }
                            try {
                                sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                if (sharedPreferences != null) {
                                    try {
                                        str4 = sharedPreferences.getString(stringExtra10, null);
                                    } catch (Throwable th) {
                                        th = th;
                                        com.xiaomi.channel.commonutils.logger.b.m99a("Fail to get sp or appId : " + th);
                                        if (!TextUtils.isEmpty(str4)) {
                                        }
                                        at.a((Context) this, stringExtra10);
                                        if (com.xiaomi.push.j.m630a(getApplicationContext())) {
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                sharedPreferences = null;
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.remove(stringExtra10);
                                edit.commit();
                                if (ak.m687b((Context) this, stringExtra10)) {
                                    ak.c(this, stringExtra10);
                                }
                                ak.m681a((Context) this, stringExtra10);
                                a(stringExtra10, ir.a(ah.b(stringExtra10, str4)), true);
                            }
                            at.a((Context) this, stringExtra10);
                            if (com.xiaomi.push.j.m630a(getApplicationContext())) {
                                return;
                            }
                            ag.a(stringExtra10);
                            return;
                        } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                            String stringExtra11 = intent.getStringExtra(bk.B);
                            int intExtra2 = intent.getIntExtra(bk.C, -2);
                            if (TextUtils.isEmpty(stringExtra11)) {
                                return;
                            }
                            if (intExtra2 >= -1) {
                                ak.a(this, stringExtra11, intExtra2, intent.getIntExtra(bk.D, -1));
                                return;
                            } else {
                                ak.a(this, stringExtra11, intent.getStringExtra(bk.H), intent.getStringExtra(bk.I));
                                return;
                            }
                        } else if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(intent.getAction())) {
                            String stringExtra12 = intent.getStringExtra(bk.B);
                            if (TextUtils.isEmpty(stringExtra12)) {
                                return;
                            }
                            ak.m686b((Context) this, stringExtra12);
                            return;
                        } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                            String stringExtra13 = intent.getStringExtra(bk.B);
                            String stringExtra14 = intent.getStringExtra(bk.G);
                            if (intent.hasExtra(bk.E)) {
                                int intExtra3 = intent.getIntExtra(bk.E, 0);
                                b2 = com.xiaomi.push.bn.b(stringExtra13 + intExtra3);
                                i4 = intExtra3;
                                z2 = false;
                            } else {
                                b2 = com.xiaomi.push.bn.b(stringExtra13);
                            }
                            if (!TextUtils.isEmpty(stringExtra13) && TextUtils.equals(stringExtra14, b2)) {
                                if (z2) {
                                    ak.c(this, stringExtra13);
                                    return;
                                } else {
                                    ak.b(this, stringExtra13, i4);
                                    return;
                                }
                            }
                            str = "invalid notification for " + stringExtra13;
                            com.xiaomi.channel.commonutils.logger.b.d(str);
                            return;
                        } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                            String stringExtra15 = intent.getStringExtra("mipush_app_package");
                            if (!TextUtils.isEmpty(stringExtra15)) {
                                v.a(this).b(stringExtra15);
                            }
                            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                                return;
                            }
                            a(19, (Exception) null);
                            e();
                            stopSelf();
                            return;
                        } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                            String stringExtra16 = intent.getStringExtra("mipush_app_package");
                            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                            String stringExtra17 = intent.getStringExtra("mipush_app_id");
                            String stringExtra18 = intent.getStringExtra("mipush_app_token");
                            if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                v.a(this).c(stringExtra16);
                            }
                            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                v.a(this).e(stringExtra16);
                                v.a(this).f(stringExtra16);
                            }
                            if (byteArrayExtra3 == null) {
                                x.a(this, stringExtra16, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                                return;
                            }
                            x.b(stringExtra16, byteArrayExtra3);
                            a(new w(this, stringExtra16, stringExtra17, stringExtra18, byteArrayExtra3));
                            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f850a == null) {
                                this.f850a = new f();
                                registerReceiver(this.f850a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                return;
                            }
                            return;
                        } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                            String stringExtra19 = intent.getStringExtra("mipush_app_package");
                            byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                            hl hlVar = new hl();
                            try {
                                ir.a(hlVar, byteArrayExtra4);
                                hf.a(this).a(hlVar, stringExtra19);
                                return;
                            } catch (ix e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                return;
                            }
                        } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m99a("[Alarm] Service called on timer");
                            if (!m663i()) {
                                et.a(false);
                                if (m660f()) {
                                    b(false);
                                }
                            } else if (et.m385a()) {
                                com.xiaomi.channel.commonutils.logger.b.m99a("enter falldown mode, stop alarm");
                                et.a();
                            }
                            a aVar = this.f849a;
                            if (aVar != null) {
                                aVar.a();
                                return;
                            }
                            return;
                        } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m99a("Service called on check alive.");
                            if (m660f()) {
                                b(false);
                                return;
                            }
                            return;
                        } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m99a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                            et.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                            return;
                        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            d();
                            return;
                        } else if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                            a(intent);
                            return;
                        } else if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
                            if (intent.getExtras() == null || (i3 = intent.getExtras().getInt("effectivePeriod", 0)) <= 0 || i3 > 604800) {
                                return;
                            }
                            com.xiaomi.push.service.o.a(getApplicationContext()).a(i3);
                            return;
                        } else if ("action_cr_config".equals(intent.getAction())) {
                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                            Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(com.xiaomi.push.bs.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
                            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                return;
                            }
                            em.a(getApplicationContext(), build);
                            return;
                        } else if (!"action_help_ping".equals(intent.getAction())) {
                            if ("action_aw_app_logic".equals(intent.getAction())) {
                                e(intent);
                                return;
                            } else if (bk.n.equals(intent.getAction())) {
                                com.xiaomi.push.service.n.a(getApplicationContext(), intent);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                            int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                            if (intExtra4 >= 0 && intExtra4 < 30) {
                                com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                                intExtra4 = 30;
                            }
                            boolean z3 = intExtra4 >= 0 ? booleanExtra6 : false;
                            com.xiaomi.channel.commonutils.logger.b.m99a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
                            if (!z3 || intExtra4 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                                return;
                            }
                            a(intent, intExtra4);
                            return;
                        }
                    } else {
                        String stringExtra20 = intent.getStringExtra("uninstall_pkg_name");
                        if (stringExtra20 == null || TextUtils.isEmpty(stringExtra20.trim())) {
                            return;
                        }
                        try {
                            PackageInfo packageInfo = getPackageManager().getPackageInfo(stringExtra20, 0);
                            if (packageInfo == null || packageInfo.applicationInfo == null || !com.xiaomi.push.i.a(this, packageInfo.packageName)) {
                                z2 = false;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m99a("dual space's app uninstalled " + stringExtra20);
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if (!"com.xiaomi.channel".equals(stringExtra20) || bg.a().m712a("1").isEmpty() || !z2) {
                            SharedPreferences sharedPreferences2 = getSharedPreferences("pref_registered_pkg_names", 0);
                            String string = sharedPreferences2.getString(stringExtra20, null);
                            if (TextUtils.isEmpty(string) || !z2) {
                                return;
                            }
                            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                            edit2.remove(stringExtra20);
                            edit2.commit();
                            if (ak.m687b((Context) this, stringExtra20)) {
                                ak.c(this, stringExtra20);
                            }
                            ak.m681a((Context) this, stringExtra20);
                            at.a(getApplicationContext(), stringExtra20);
                            if (!m672c() || string == null) {
                                return;
                            }
                            try {
                                ah.a(this, ah.a(stringExtra20, string));
                                com.xiaomi.channel.commonutils.logger.b.m99a("uninstall " + stringExtra20 + " msg sent");
                                return;
                            } catch (gg e3) {
                                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                                a(10, e3);
                                return;
                            }
                        }
                        a("1", 0);
                        str2 = "close the miliao channel as the app is uninstalled.";
                    }
                    com.xiaomi.channel.commonutils.logger.b.m99a(str2);
                    return;
                }
                String stringExtra21 = intent.getStringExtra(bk.t);
                String stringExtra22 = intent.getStringExtra(bk.q);
                if (stringExtra21 == null) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m99a("request reset connection from chid = " + stringExtra21);
                bg.b a6 = bg.a().a(stringExtra21, stringExtra22);
                if (a6 == null || !a6.h.equals(intent.getStringExtra(bk.x)) || a6.f933a != bg.c.binded) {
                    return;
                }
                fv m664a = m664a();
                if (m664a != null && m664a.a(SystemClock.elapsedRealtime() - 15000)) {
                    return;
                }
                pVar = new q();
                c(pVar);
                return;
            } else {
                gm a7 = a(new go(intent.getBundleExtra("ext_packet")), intent.getStringExtra(bk.B), intent.getStringExtra(bk.F));
                if (a7 == null) {
                    return;
                }
                btVar = new bt(this, fk.a(a7, a2.a(a7.k(), a7.m()).h));
            }
            c(btVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m667a()) {
            et.a();
        } else if (et.m385a()) {
        } else {
            et.a(true);
        }
    }

    private void e(Intent intent) {
        int i2;
        try {
            ec.a(getApplicationContext()).a(new bm());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            ig igVar = new ig();
            ir.a(igVar, byteArrayExtra);
            String b2 = igVar.b();
            Map<String, String> m559a = igVar.m559a();
            if (m559a != null) {
                String str = m559a.get("extra_help_aw_info");
                String str2 = m559a.get("extra_aw_app_online_cmd");
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
                ec.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
            }
        } catch (ix e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m659e() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        fv fvVar = this.f846a;
        if (fvVar == null || !fvVar.m427b()) {
            fv fvVar2 = this.f846a;
            if (fvVar2 == null || !fvVar2.m428c()) {
                this.f847a.b(com.xiaomi.push.bi.m207a((Context) this));
                g();
                if (this.f846a == null) {
                    bg.a().a(this);
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

    /* renamed from: f  reason: collision with other method in class */
    private boolean m660f() {
        if (SystemClock.elapsedRealtime() - this.f842a < 30000) {
            return false;
        }
        return com.xiaomi.push.bi.d(this);
    }

    private void g() {
        try {
            this.f845a.a(this.f848a, new cl(this));
            this.f845a.e();
            this.f846a = this.f845a;
        } catch (gg e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f845a.b(3, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m661g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m662h() {
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.m99a("current sdk expect region is cn");
            return com.xiaomi.push.n.China.name().equals(com.xiaomi.push.service.a.a(getApplicationContext()).a());
        }
        return !v.a(this).m760b(getPackageName());
    }

    private void i() {
        synchronized (this.f859a) {
            this.f859a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m663i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m529b((Context) this) && !com.xiaomi.push.i.m527a(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.a;
        int i3 = this.f862b;
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
        return ba.a(this).a(hm.ForegroundServiceSwitch.a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public fv m664a() {
        return this.f846a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.j m665a() {
        return new com.xiaomi.push.service.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m666a() {
        if (SystemClock.elapsedRealtime() - this.f842a >= gb.a() && com.xiaomi.push.bi.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f857a.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        fv fvVar = this.f846a;
        sb.append(fvVar == null ? null : Integer.valueOf(fvVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m99a(sb.toString());
        fv fvVar2 = this.f846a;
        if (fvVar2 != null) {
            fvVar2.b(i2, exc);
            this.f846a = null;
        }
        a(7);
        a(4);
        bg.a().a(this, i2);
    }

    public void a(fk fkVar) {
        fv fvVar = this.f846a;
        if (fvVar == null) {
            throw new gg("try send msg while connection is null.");
        }
        fvVar.b(fkVar);
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        fg.a().a(fvVar);
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar, int i2, Exception exc) {
        fg.a().a(fvVar, i2, exc);
        if (m663i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar, Exception exc) {
        fg.a().a(fvVar, exc);
        c(false);
        if (m663i()) {
            return;
        }
        a(false);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.f857a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m99a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(n nVar) {
        synchronized (this.f859a) {
            this.f859a.add(nVar);
        }
    }

    public void a(bg.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m99a("schedule rebind job in " + (a2 / 1000));
            a(new b(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        bg.b a2 = bg.a().a(str, str2);
        if (a2 != null) {
            a(new s(a2, i2, str4, str3));
        }
        bg.a().m716a(str, str2);
    }

    public void a(String str, byte[] bArr, boolean z) {
        Collection<bg.b> m712a = bg.a().m712a("5");
        if (m712a.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (m712a.iterator().next().f933a == bg.c.binded) {
            a(new cj(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        x.b(str, bArr);
    }

    public void a(boolean z) {
        this.f855a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m99a("register request without payload");
            return;
        }
        id idVar = new id();
        try {
            ir.a(idVar, bArr);
            if (idVar.f631a == hh.Registration) {
                ih ihVar = new ih();
                try {
                    ir.a(ihVar, idVar.m549a());
                    a(new w(this, idVar.b(), ihVar.b(), ihVar.c(), bArr));
                    en.a(getApplicationContext()).a(idVar.b(), "E100003", ihVar.a(), 6002, null);
                } catch (ix e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m99a("register request with invalid payload");
            }
        } catch (ix e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(fk[] fkVarArr) {
        fv fvVar = this.f846a;
        if (fvVar == null) {
            throw new gg("try send msg while connection is null.");
        }
        fvVar.a(fkVarArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m667a() {
        boolean b2 = com.xiaomi.push.bi.b(this);
        boolean z = bg.a().m710a() > 0;
        boolean z2 = !m671b();
        boolean m662h = m662h();
        boolean z3 = !m661g();
        boolean z4 = b2 && z && z2 && m662h && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m662h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m668a(int i2) {
        return this.f857a.m746a(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public com.xiaomi.push.service.j m669b() {
        return this.f856a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m670b() {
        com.xiaomi.push.service.o.a(getApplicationContext()).m743d();
        Iterator it = new ArrayList(this.f859a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).mo466a();
        }
    }

    @Override // com.xiaomi.push.fy
    public void b(fv fvVar) {
        fg.a().b(fvVar);
        c(true);
        this.f855a.m722a();
        if (!et.m385a() && !m663i()) {
            com.xiaomi.channel.commonutils.logger.b.m99a("reconnection successful, reactivate alarm.");
            et.a(true);
        }
        Iterator<bg.b> it = bg.a().m711a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f861a || !com.xiaomi.push.j.m630a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.aj.a(getApplicationContext()).a(new cm(this));
    }

    public void b(j jVar) {
        this.f857a.a(jVar.a, jVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m671b() {
        try {
            Class<?> a2 = com.xiaomi.push.s.a(this, "miui.os.Build");
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
    public boolean m672c() {
        fv fvVar = this.f846a;
        return fvVar != null && fvVar.m428c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m673d() {
        fv fvVar = this.f846a;
        return fvVar != null && fvVar.m427b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f844a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.s.a((Context) this);
        com.xiaomi.push.service.t m755a = u.m755a((Context) this);
        if (m755a != null) {
            com.xiaomi.push.ab.a(m755a.a);
        }
        if (com.xiaomi.push.j.m630a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f849a = new a(this, null);
            registerReceiver(this.f849a, new IntentFilter(bk.p), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler);
            b = true;
            handler.post(new cn(this));
        }
        this.f844a = new Messenger(new co(this));
        bl.a(this);
        cp cpVar = new cp(this, null, 5222, "xiaomi.com", null);
        this.f847a = cpVar;
        cpVar.a(true);
        this.f845a = new fr(this, this.f847a);
        this.f856a = m665a();
        et.a(this);
        this.f845a.a(this);
        this.f854a = new be(this);
        this.f855a = new bq(this);
        new com.xiaomi.push.service.k().a();
        fg.m394a().a(this);
        this.f857a = new com.xiaomi.push.service.p("Connection Controller Thread");
        bg a2 = bg.a();
        a2.b();
        a2.a(new cq(this));
        if (k()) {
            h();
        }
        hf.a(this).a(new com.xiaomi.push.service.r(this), "UPLOADER_PUSH_CHANNEL");
        a(new hc(this));
        a(new cg(this));
        if (com.xiaomi.push.j.m630a((Context) this)) {
            a(new bf());
        }
        a(new h());
        this.f860a.add(bx.a(this));
        if (m662h()) {
            this.f850a = new f();
            registerReceiver(this.f850a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (com.xiaomi.push.j.m630a(getApplicationContext())) {
            this.f853a = new t();
            registerReceiver(this.f853a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null);
            k kVar = new k();
            this.f851a = kVar;
            registerReceiver(kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f843a = new cr(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f843a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] m657a = m657a();
            if (m657a != null) {
                this.f852a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f852a, intentFilter);
                this.a = m657a[0];
                this.f862b = m657a[1];
                com.xiaomi.channel.commonutils.logger.b.m99a("falldown initialized: " + this.a + "," + this.f862b);
            }
        }
        String str = "";
        if (m755a != null) {
            try {
                if (!TextUtils.isEmpty(m755a.f1005a) && (split = m755a.f1005a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        dc.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f850a;
        if (fVar != null) {
            a(fVar);
            this.f850a = null;
        }
        t tVar = this.f853a;
        if (tVar != null) {
            a(tVar);
            this.f853a = null;
        }
        k kVar = this.f851a;
        if (kVar != null) {
            a(kVar);
            this.f851a = null;
        }
        r rVar = this.f852a;
        if (rVar != null) {
            a(rVar);
            this.f852a = null;
        }
        a aVar = this.f849a;
        if (aVar != null) {
            a(aVar);
            this.f849a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f843a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f843a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f860a.clear();
        this.f857a.m747b();
        a(new ck(this, 2));
        a(new l());
        bg.a().b();
        bg.a().a(this, 15);
        bg.a().m714a();
        this.f845a.b(this);
        bv.a().m728a();
        et.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m99a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                com.xiaomi.channel.commonutils.logger.b.m99a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(bk.t), intent.getStringExtra(bk.B), intent.getStringExtra("mipush_app_package")));
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f857a.m745a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    bg.a().a(this, 14);
                    stopSelf();
                } else {
                    iVar = new i(intent);
                    a(iVar);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                if ("10".equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("rx_msg", System.currentTimeMillis());
                    intent.putExtra("screen_on", com.xiaomi.push.t.a(getApplicationContext()));
                    intent.putExtra("wifi", com.xiaomi.push.bi.e(getApplicationContext()));
                }
                iVar = new i(intent);
                a(iVar);
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
