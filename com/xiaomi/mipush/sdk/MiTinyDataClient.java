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
/* loaded from: classes5.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes5.dex */
    public static class a {
        private static a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f27a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f29a;

        /* renamed from: a  reason: collision with other field name */
        private String f30a;

        /* renamed from: a  reason: collision with other field name */
        private C0705a f28a = new C0705a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hk> f31a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0705a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f34a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f35a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hk> f33a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f32a = new am(this);

            public C0705a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f34a == null) {
                    this.f34a = this.f35a.scheduleAtFixedRate(this.f32a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hk remove = this.f33a.remove(0);
                for (Cif cif : com.xiaomi.push.service.be.a(Arrays.asList(remove), a.this.f27a.getPackageName(), d.m71a(a.this.f27a).m72a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ay.a(a.this.f27a).a((ay) cif, hg.Notification, true, (ht) null);
                }
            }

            public void a(hk hkVar) {
                this.f35a.execute(new al(this, hkVar));
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
            synchronized (this.f31a) {
                if (!this.f31a.contains(hkVar)) {
                    this.f31a.add(hkVar);
                    if (this.f31a.size() > 100) {
                        this.f31a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ay.a(context).m62a()) {
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
            return d.m71a(context).m72a() == null && !a(this.f27a);
        }

        private boolean b(hk hkVar) {
            if (com.xiaomi.push.service.be.a(hkVar, false)) {
                return false;
            }
            if (this.f29a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hkVar.d());
                ay.a(this.f27a).a(hkVar);
            } else {
                this.f28a.a(hkVar);
            }
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m43a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m33a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f27a = context;
            this.f29a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m33a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f30a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m44a() {
            return this.f27a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m45a(hk hkVar) {
            boolean z = false;
            synchronized (this) {
                if (hkVar != null) {
                    if (!com.xiaomi.push.service.be.a(hkVar, true)) {
                        boolean z2 = TextUtils.isEmpty(hkVar.m321a()) && TextUtils.isEmpty(this.f30a);
                        boolean z3 = !m44a();
                        if (this.f27a == null || b(this.f27a)) {
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
                            if (TextUtils.isEmpty(hkVar.m321a())) {
                                hkVar.a(this.f30a);
                            }
                            if (TextUtils.isEmpty(hkVar.c())) {
                                hkVar.e(this.f27a.getPackageName());
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
            synchronized (this.f31a) {
                arrayList.addAll(this.f31a);
                this.f31a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m45a((hk) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m33a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m43a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m33a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hk hkVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hkVar.d());
        if (!a.a().m44a()) {
            a.a().m43a(context);
        }
        return a.a().m45a(hkVar);
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
        return a.a().m45a(hkVar);
    }
}
