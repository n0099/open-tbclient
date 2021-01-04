package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
import com.xiaomi.push.service.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static volatile a f14090a;

        /* renamed from: a  reason: collision with other field name */
        private Context f107a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f109a;

        /* renamed from: a  reason: collision with other field name */
        private String f110a;

        /* renamed from: a  reason: collision with other field name */
        private C1253a f108a = new C1253a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hq> f111a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1253a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f114a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f115a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hq> f113a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f112a = new ae(this);

            public C1253a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f114a == null) {
                    this.f114a = this.f115a.scheduleAtFixedRate(this.f112a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hq remove = this.f113a.remove(0);
                for (il ilVar : bi.a(Arrays.asList(remove), a.this.f107a.getPackageName(), b.m113a(a.this.f107a).m114a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    aq.a(a.this.f107a).a((aq) ilVar, hm.Notification, true, (hz) null);
                }
            }

            public void a(hq hqVar) {
                this.f115a.execute(new ad(this, hqVar));
            }
        }

        public static a a() {
            if (f14090a == null) {
                synchronized (a.class) {
                    if (f14090a == null) {
                        f14090a = new a();
                    }
                }
            }
            return f14090a;
        }

        private void a(hq hqVar) {
            synchronized (this.f111a) {
                if (!this.f111a.contains(hqVar)) {
                    this.f111a.add(hqVar);
                    if (this.f111a.size() > 100) {
                        this.f111a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (aq.a(context).m106a()) {
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
            return b.m113a(context).m114a() == null && !a(this.f107a);
        }

        private boolean b(hq hqVar) {
            if (bi.a(hqVar, false)) {
                return false;
            }
            if (this.f109a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hqVar.d());
                aq.a(this.f107a).a(hqVar);
            } else {
                this.f108a.a(hqVar);
            }
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m86a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m73a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f107a = context;
            this.f109a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m73a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f110a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m87a() {
            return this.f107a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m88a(hq hqVar) {
            boolean z = false;
            synchronized (this) {
                if (hqVar != null) {
                    if (!bi.a(hqVar, true)) {
                        boolean z2 = TextUtils.isEmpty(hqVar.m365a()) && TextUtils.isEmpty(this.f110a);
                        boolean z3 = !m87a();
                        if (this.f107a == null || b(this.f107a)) {
                            z = true;
                        }
                        if (z3 || z2 || z) {
                            if (z2) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + hqVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL);
                            } else if (z3) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + hqVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT);
                            } else if (z) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + hqVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID);
                            }
                            a(hqVar);
                            z = true;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + hqVar.d());
                            if (TextUtils.isEmpty(hqVar.d())) {
                                hqVar.f(com.xiaomi.push.service.an.a());
                            }
                            if (TextUtils.isEmpty(hqVar.m365a())) {
                                hqVar.a(this.f110a);
                            }
                            if (TextUtils.isEmpty(hqVar.c())) {
                                hqVar.e(this.f107a.getPackageName());
                            }
                            if (hqVar.a() <= 0) {
                                hqVar.b(System.currentTimeMillis());
                            }
                            z = b(hqVar);
                        }
                    }
                }
            }
            return z;
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f111a) {
                arrayList.addAll(this.f111a);
                this.f111a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m88a((hq) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m86a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hq hqVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hqVar.d());
        if (!a.a().m87a()) {
            a.a().m86a(context);
        }
        return a.a().m88a(hqVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        hq hqVar = new hq();
        hqVar.d(str);
        hqVar.c(str2);
        hqVar.a(j);
        hqVar.b(str3);
        hqVar.a(true);
        hqVar.a("push_sdk_channel");
        return upload(context, hqVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        hq hqVar = new hq();
        hqVar.d(str);
        hqVar.c(str2);
        hqVar.a(j);
        hqVar.b(str3);
        return a.a().m88a(hqVar);
    }
}
