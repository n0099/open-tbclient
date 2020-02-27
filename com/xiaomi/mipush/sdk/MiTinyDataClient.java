package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hk;
import com.xiaomi.push.ht;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes8.dex */
    public static class a {
        private static a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f23a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f25a;

        /* renamed from: a  reason: collision with other field name */
        private String f26a;

        /* renamed from: a  reason: collision with other field name */
        private C0753a f24a = new C0753a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hk> f27a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0753a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f30a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f31a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hk> f29a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f28a = new am(this);

            public C0753a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f30a == null) {
                    this.f30a = this.f31a.scheduleAtFixedRate(this.f28a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hk remove = this.f29a.remove(0);
                for (Cif cif : com.xiaomi.push.service.be.a(Arrays.asList(remove), a.this.f23a.getPackageName(), d.m85a(a.this.f23a).m86a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ay.a(a.this.f23a).a((ay) cif, hg.Notification, true, (ht) null);
                }
            }

            public void a(hk hkVar) {
                this.f31a.execute(new al(this, hkVar));
            }
        }

        public static a a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        private void a(hk hkVar) {
            synchronized (this.f27a) {
                if (!this.f27a.contains(hkVar)) {
                    this.f27a.add(hkVar);
                    if (this.f27a.size() > 100) {
                        this.f27a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ay.a(context).m76a()) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                    if (packageInfo == null) {
                        return false;
                    }
                    return packageInfo.versionCode >= 108;
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }

        private boolean b(Context context) {
            return d.m85a(context).m86a() == null && !a(this.f23a);
        }

        private boolean b(hk hkVar) {
            if (com.xiaomi.push.service.be.a(hkVar, false)) {
                return false;
            }
            if (this.f25a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hkVar.d());
                ay.a(this.f23a).a(hkVar);
            } else {
                this.f24a.a(hkVar);
            }
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m57a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m47a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f23a = context;
            this.f25a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m47a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f26a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m58a() {
            return this.f23a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m59a(hk hkVar) {
            boolean z = false;
            synchronized (this) {
                if (hkVar != null) {
                    if (!com.xiaomi.push.service.be.a(hkVar, true)) {
                        boolean z2 = TextUtils.isEmpty(hkVar.m335a()) && TextUtils.isEmpty(this.f26a);
                        boolean z3 = !m58a();
                        if (this.f23a == null || b(this.f23a)) {
                            z = true;
                        }
                        if (z3 || z2 || z) {
                            if (z2) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + hkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL);
                            } else if (z3) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + hkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT);
                            } else if (z) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + hkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID);
                            }
                            a(hkVar);
                            z = true;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + hkVar.d());
                            if (TextUtils.isEmpty(hkVar.d())) {
                                hkVar.f(com.xiaomi.push.service.aj.a());
                            }
                            if (TextUtils.isEmpty(hkVar.m335a())) {
                                hkVar.a(this.f26a);
                            }
                            if (TextUtils.isEmpty(hkVar.c())) {
                                hkVar.e(this.f23a.getPackageName());
                            }
                            if (hkVar.a() <= 0) {
                                hkVar.b(System.currentTimeMillis());
                            }
                            z = b(hkVar);
                        }
                    }
                }
            }
            return z;
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f27a) {
                arrayList.addAll(this.f27a);
                this.f27a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m59a((hk) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m47a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m57a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hk hkVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hkVar.d());
        if (!a.a().m58a()) {
            a.a().m57a(context);
        }
        return a.a().m59a(hkVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        hk hkVar = new hk();
        hkVar.d(str);
        hkVar.c(str2);
        hkVar.a(j);
        hkVar.b(str3);
        hkVar.a(true);
        hkVar.a("push_sdk_channel");
        return upload(context, hkVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        hk hkVar = new hk();
        hkVar.d(str);
        hkVar.c(str2);
        hkVar.a(j);
        hkVar.b(str3);
        return a.a().m59a(hkVar);
    }
}
