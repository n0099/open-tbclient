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
/* loaded from: classes12.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static volatile a f4738a;

        /* renamed from: a  reason: collision with other field name */
        private Context f29a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f31a;

        /* renamed from: a  reason: collision with other field name */
        private String f32a;

        /* renamed from: a  reason: collision with other field name */
        private C0962a f30a = new C0962a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hq> f33a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C0962a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f36a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f37a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hq> f35a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f34a = new ae(this);

            public C0962a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f36a == null) {
                    this.f36a = this.f37a.scheduleAtFixedRate(this.f34a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hq remove = this.f35a.remove(0);
                for (il ilVar : bi.a(Arrays.asList(remove), a.this.f29a.getPackageName(), b.m95a(a.this.f29a).m96a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    aq.a(a.this.f29a).a((aq) ilVar, hm.Notification, true, (hz) null);
                }
            }

            public void a(hq hqVar) {
                this.f37a.execute(new ad(this, hqVar));
            }
        }

        public static a a() {
            if (f4738a == null) {
                synchronized (a.class) {
                    if (f4738a == null) {
                        f4738a = new a();
                    }
                }
            }
            return f4738a;
        }

        private void a(hq hqVar) {
            synchronized (this.f33a) {
                if (!this.f33a.contains(hqVar)) {
                    this.f33a.add(hqVar);
                    if (this.f33a.size() > 100) {
                        this.f33a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (aq.a(context).m88a()) {
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
            return b.m95a(context).m96a() == null && !a(this.f29a);
        }

        private boolean b(hq hqVar) {
            if (bi.a(hqVar, false)) {
                return false;
            }
            if (this.f31a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hqVar.d());
                aq.a(this.f29a).a(hqVar);
            } else {
                this.f30a.a(hqVar);
            }
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m68a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m55a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f29a = context;
            this.f31a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m55a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f32a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m69a() {
            return this.f29a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m70a(hq hqVar) {
            boolean z = false;
            synchronized (this) {
                if (hqVar != null) {
                    if (!bi.a(hqVar, true)) {
                        boolean z2 = TextUtils.isEmpty(hqVar.m347a()) && TextUtils.isEmpty(this.f32a);
                        boolean z3 = !m69a();
                        if (this.f29a == null || b(this.f29a)) {
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
                            if (TextUtils.isEmpty(hqVar.m347a())) {
                                hqVar.a(this.f32a);
                            }
                            if (TextUtils.isEmpty(hqVar.c())) {
                                hqVar.e(this.f29a.getPackageName());
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
            synchronized (this.f33a) {
                arrayList.addAll(this.f33a);
                this.f33a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m70a((hq) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m55a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m68a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m55a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hq hqVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hqVar.d());
        if (!a.a().m69a()) {
            a.a().m68a(context);
        }
        return a.a().m70a(hqVar);
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
        return a.a().m70a(hqVar);
    }
}
