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
/* loaded from: classes9.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes9.dex */
    public static class a {
        private static volatile a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f30a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f32a;

        /* renamed from: a  reason: collision with other field name */
        private String f33a;

        /* renamed from: a  reason: collision with other field name */
        private C0889a f31a = new C0889a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hq> f34a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0889a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f37a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f38a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hq> f36a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f35a = new ae(this);

            public C0889a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f37a == null) {
                    this.f37a = this.f38a.scheduleAtFixedRate(this.f35a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hq remove = this.f36a.remove(0);
                for (il ilVar : bi.a(Arrays.asList(remove), a.this.f30a.getPackageName(), b.m89a(a.this.f30a).m90a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    aq.a(a.this.f30a).a((aq) ilVar, hm.Notification, true, (hz) null);
                }
            }

            public void a(hq hqVar) {
                this.f38a.execute(new ad(this, hqVar));
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

        private void a(hq hqVar) {
            synchronized (this.f34a) {
                if (!this.f34a.contains(hqVar)) {
                    this.f34a.add(hqVar);
                    if (this.f34a.size() > 100) {
                        this.f34a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (aq.a(context).m82a()) {
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
            return b.m89a(context).m90a() == null && !a(this.f30a);
        }

        private boolean b(hq hqVar) {
            if (bi.a(hqVar, false)) {
                return false;
            }
            if (this.f32a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hqVar.d());
                aq.a(this.f30a).a(hqVar);
            } else {
                this.f31a.a(hqVar);
            }
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m62a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m49a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f30a = context;
            this.f32a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m49a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f33a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m63a() {
            return this.f30a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m64a(hq hqVar) {
            boolean z = false;
            synchronized (this) {
                if (hqVar != null) {
                    if (!bi.a(hqVar, true)) {
                        boolean z2 = TextUtils.isEmpty(hqVar.m341a()) && TextUtils.isEmpty(this.f33a);
                        boolean z3 = !m63a();
                        if (this.f30a == null || b(this.f30a)) {
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
                            if (TextUtils.isEmpty(hqVar.m341a())) {
                                hqVar.a(this.f33a);
                            }
                            if (TextUtils.isEmpty(hqVar.c())) {
                                hqVar.e(this.f30a.getPackageName());
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
            synchronized (this.f34a) {
                arrayList.addAll(this.f34a);
                this.f34a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m64a((hq) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m49a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m62a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m49a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hq hqVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hqVar.d());
        if (!a.a().m63a()) {
            a.a().m62a(context);
        }
        return a.a().m64a(hqVar);
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
        return a.a().m64a(hqVar);
    }
}
