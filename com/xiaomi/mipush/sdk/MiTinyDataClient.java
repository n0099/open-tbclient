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
/* loaded from: classes3.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes3.dex */
    public static class a {
        private static a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f22a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f24a;

        /* renamed from: a  reason: collision with other field name */
        private String f25a;

        /* renamed from: a  reason: collision with other field name */
        private C0590a f23a = new C0590a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hk> f26a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0590a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f29a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f30a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hk> f28a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f27a = new am(this);

            public C0590a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f29a == null) {
                    this.f29a = this.f30a.scheduleAtFixedRate(this.f27a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hk remove = this.f28a.remove(0);
                for (Cif cif : com.xiaomi.push.service.be.a(Arrays.asList(remove), a.this.f22a.getPackageName(), d.m68a(a.this.f22a).m69a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ay.a(a.this.f22a).a((ay) cif, hg.Notification, true, (ht) null);
                }
            }

            public void a(hk hkVar) {
                this.f30a.execute(new al(this, hkVar));
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
            synchronized (this.f26a) {
                if (!this.f26a.contains(hkVar)) {
                    this.f26a.add(hkVar);
                    if (this.f26a.size() > 100) {
                        this.f26a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ay.a(context).m59a()) {
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
            return d.m68a(context).m69a() == null && !a(this.f22a);
        }

        private boolean b(hk hkVar) {
            if (com.xiaomi.push.service.be.a(hkVar, false)) {
                return false;
            }
            if (this.f24a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hkVar.d());
                ay.a(this.f22a).a(hkVar);
            } else {
                this.f23a.a(hkVar);
            }
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m40a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m30a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f22a = context;
            this.f24a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m30a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f25a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m41a() {
            return this.f22a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m42a(hk hkVar) {
            boolean z = false;
            synchronized (this) {
                if (hkVar != null) {
                    if (!com.xiaomi.push.service.be.a(hkVar, true)) {
                        boolean z2 = TextUtils.isEmpty(hkVar.m318a()) && TextUtils.isEmpty(this.f25a);
                        boolean z3 = !m41a();
                        if (this.f22a == null || b(this.f22a)) {
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
                            if (TextUtils.isEmpty(hkVar.m318a())) {
                                hkVar.a(this.f25a);
                            }
                            if (TextUtils.isEmpty(hkVar.c())) {
                                hkVar.e(this.f22a.getPackageName());
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
            synchronized (this.f26a) {
                arrayList.addAll(this.f26a);
                this.f26a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m42a((hk) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m30a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m40a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m30a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hk hkVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hkVar.d());
        if (!a.a().m41a()) {
            a.a().m40a(context);
        }
        return a.a().m42a(hkVar);
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
        return a.a().m42a(hkVar);
    }
}
