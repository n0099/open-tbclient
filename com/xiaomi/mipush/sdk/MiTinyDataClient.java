package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.push.service.bj;
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
        private Context b;
        private String c;
        private Boolean d;
        private C0489a e = new C0489a();
        private final ArrayList<com.xiaomi.xmpush.thrift.f> f = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0489a {
            private ScheduledFuture<?> d;
            private ScheduledThreadPoolExecutor c = new ScheduledThreadPoolExecutor(1);
            public final ArrayList<com.xiaomi.xmpush.thrift.f> a = new ArrayList<>();
            private final Runnable e = new an(this);

            public C0489a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.d == null) {
                    this.d = this.c.scheduleAtFixedRate(this.e, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                com.xiaomi.xmpush.thrift.f remove = this.a.remove(0);
                for (com.xiaomi.xmpush.thrift.ai aiVar : bj.a(Arrays.asList(remove), a.this.b.getPackageName(), d.a(a.this.b).c(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.m());
                    az.a(a.this.b).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null);
                }
            }

            public void a(com.xiaomi.xmpush.thrift.f fVar) {
                this.c.execute(new am(this, fVar));
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

        private void b(com.xiaomi.xmpush.thrift.f fVar) {
            synchronized (this.f) {
                if (!this.f.contains(fVar)) {
                    this.f.add(fVar);
                    if (this.f.size() > 100) {
                        this.f.remove(0);
                    }
                }
            }
        }

        private boolean b(Context context) {
            if (az.a(context).c()) {
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

        private boolean c(Context context) {
            return d.a(context).c() == null && !b(this.b);
        }

        private boolean c(com.xiaomi.xmpush.thrift.f fVar) {
            if (bj.a(fVar, false)) {
                return false;
            }
            if (this.d.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + fVar.m());
                az.a(this.b).a(fVar);
            } else {
                this.e.a(fVar);
            }
            return true;
        }

        public void a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.b = context;
            this.d = Boolean.valueOf(b(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.c = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        public synchronized boolean a(com.xiaomi.xmpush.thrift.f fVar) {
            boolean z = false;
            synchronized (this) {
                if (fVar != null) {
                    if (!bj.a(fVar, true)) {
                        boolean z2 = TextUtils.isEmpty(fVar.a()) && TextUtils.isEmpty(this.c);
                        boolean z3 = !b();
                        if (this.b == null || c(this.b)) {
                            z = true;
                        }
                        if (z3 || z2 || z) {
                            if (z2) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + fVar.d() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL);
                            } else if (z3) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + fVar.d() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT);
                            } else if (z) {
                                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + fVar.d() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID);
                            }
                            b(fVar);
                            z = true;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + fVar.m());
                            if (TextUtils.isEmpty(fVar.m())) {
                                fVar.f(com.xiaomi.push.service.aq.a());
                            }
                            if (TextUtils.isEmpty(fVar.a())) {
                                fVar.a(this.c);
                            }
                            if (TextUtils.isEmpty(fVar.k())) {
                                fVar.e(this.b.getPackageName());
                            }
                            if (fVar.g() <= 0) {
                                fVar.b(System.currentTimeMillis());
                            }
                            z = c(fVar);
                        }
                    }
                }
            }
            return z;
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f) {
                arrayList.addAll(this.f);
                this.f.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((com.xiaomi.xmpush.thrift.f) it.next());
            }
        }

        public boolean b() {
            return this.b != null;
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, com.xiaomi.xmpush.thrift.f fVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + fVar.m());
        if (!a.a().b()) {
            a.a().a(context);
        }
        return a.a().a(fVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        com.xiaomi.xmpush.thrift.f fVar = new com.xiaomi.xmpush.thrift.f();
        fVar.d(str);
        fVar.c(str2);
        fVar.a(j);
        fVar.b(str3);
        fVar.c(true);
        fVar.a("push_sdk_channel");
        return upload(context, fVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        com.xiaomi.xmpush.thrift.f fVar = new com.xiaomi.xmpush.thrift.f();
        fVar.d(str);
        fVar.c(str2);
        fVar.a(j);
        fVar.b(str3);
        return a.a().a(fVar);
    }
}
