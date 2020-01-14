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
/* loaded from: classes6.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes6.dex */
    public static class a {
        private static a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f26a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f28a;

        /* renamed from: a  reason: collision with other field name */
        private String f29a;

        /* renamed from: a  reason: collision with other field name */
        private C0745a f27a = new C0745a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hk> f30a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0745a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f33a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f34a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hk> f32a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f31a = new am(this);

            public C0745a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f33a == null) {
                    this.f33a = this.f34a.scheduleAtFixedRate(this.f31a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hk remove = this.f32a.remove(0);
                for (Cif cif : com.xiaomi.push.service.be.a(Arrays.asList(remove), a.this.f26a.getPackageName(), d.m80a(a.this.f26a).m81a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ay.a(a.this.f26a).a((ay) cif, hg.Notification, true, (ht) null);
                }
            }

            public void a(hk hkVar) {
                this.f34a.execute(new al(this, hkVar));
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
            synchronized (this.f30a) {
                if (!this.f30a.contains(hkVar)) {
                    this.f30a.add(hkVar);
                    if (this.f30a.size() > 100) {
                        this.f30a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ay.a(context).m71a()) {
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
            return d.m80a(context).m81a() == null && !a(this.f26a);
        }

        private boolean b(hk hkVar) {
            if (com.xiaomi.push.service.be.a(hkVar, false)) {
                return false;
            }
            if (this.f28a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hkVar.d());
                ay.a(this.f26a).a(hkVar);
            } else {
                this.f27a.a(hkVar);
            }
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m52a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m42a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f26a = context;
            this.f28a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m42a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f29a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m53a() {
            return this.f26a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m54a(hk hkVar) {
            boolean z = false;
            synchronized (this) {
                if (hkVar != null) {
                    if (!com.xiaomi.push.service.be.a(hkVar, true)) {
                        boolean z2 = TextUtils.isEmpty(hkVar.m330a()) && TextUtils.isEmpty(this.f29a);
                        boolean z3 = !m53a();
                        if (this.f26a == null || b(this.f26a)) {
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
                            if (TextUtils.isEmpty(hkVar.m330a())) {
                                hkVar.a(this.f29a);
                            }
                            if (TextUtils.isEmpty(hkVar.c())) {
                                hkVar.e(this.f26a.getPackageName());
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
            synchronized (this.f30a) {
                arrayList.addAll(this.f30a);
                this.f30a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m54a((hk) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m42a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m52a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m42a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hk hkVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hkVar.d());
        if (!a.a().m53a()) {
            a.a().m52a(context);
        }
        return a.a().m54a(hkVar);
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
        return a.a().m54a(hkVar);
    }
}
