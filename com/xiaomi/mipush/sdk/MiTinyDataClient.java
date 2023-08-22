package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.xiaomi.push.hh;
import com.xiaomi.push.hl;
import com.xiaomi.push.hu;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes10.dex */
    public static class a {
        public static volatile a a;

        /* renamed from: a  reason: collision with other field name */
        public Context f38a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f40a;

        /* renamed from: a  reason: collision with other field name */
        public String f41a;

        /* renamed from: a  reason: collision with other field name */
        public C0786a f39a = new C0786a();

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<hl> f42a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0786a {

            /* renamed from: a  reason: collision with other field name */
            public ScheduledFuture<?> f45a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledThreadPoolExecutor f46a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hl> f44a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            public final Runnable f43a = new ab(this);

            public C0786a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f45a == null) {
                    this.f45a = this.f46a.scheduleAtFixedRate(this.f43a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hl remove = this.f44a.remove(0);
                for (ig igVar : bz.a(Arrays.asList(remove), a.this.f38a.getPackageName(), b.m224a(a.this.f38a).m225a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ao.a(a.this.f38a).a((ao) igVar, hh.Notification, true, (hu) null);
                }
            }

            public void a(hl hlVar) {
                this.f46a.execute(new aa(this, hlVar));
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

        private void a(hl hlVar) {
            synchronized (this.f42a) {
                if (!this.f42a.contains(hlVar)) {
                    this.f42a.add(hlVar);
                    if (this.f42a.size() > 100) {
                        this.f42a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ao.a(context).m217a()) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                    if (packageInfo == null) {
                        return false;
                    }
                    return packageInfo.versionCode >= 108;
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }

        private boolean b(Context context) {
            return b.m224a(context).m225a() == null && !a(this.f38a);
        }

        private boolean b(hl hlVar) {
            if (bz.a(hlVar, false)) {
                return false;
            }
            if (!this.f40a.booleanValue()) {
                this.f39a.a(hlVar);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hlVar.d());
            ao.a(this.f38a).a(hlVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m195a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m180a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f38a = context;
            this.f40a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m180a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f41a = str;
            b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m196a() {
            return this.f38a != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL;
         */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean m197a(hl hlVar) {
            String str;
            boolean z = false;
            if (hlVar == null) {
                return false;
            }
            if (bz.a(hlVar, true)) {
                return false;
            }
            boolean z2 = TextUtils.isEmpty(hlVar.m552a()) && TextUtils.isEmpty(this.f41a);
            boolean z3 = !m196a();
            z = (this.f38a == null || b(this.f38a)) ? true : true;
            if (!z3 && !z2 && !z) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + hlVar.d());
                if (TextUtils.isEmpty(hlVar.d())) {
                    hlVar.f(bd.a());
                }
                if (TextUtils.isEmpty(hlVar.m552a())) {
                    hlVar.a(this.f41a);
                }
                if (TextUtils.isEmpty(hlVar.c())) {
                    hlVar.e(this.f38a.getPackageName());
                }
                if (hlVar.a() <= 0) {
                    hlVar.b(System.currentTimeMillis());
                }
                return b(hlVar);
            }
            if (!z3) {
                if (z) {
                    str = "MiTinyDataClient Pending " + hlVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID;
                }
                a(hlVar);
                return true;
            }
            str = "MiTinyDataClient Pending " + hlVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT;
            com.xiaomi.channel.commonutils.logger.b.c(str);
            a(hlVar);
            return true;
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + SmallTailInfo.EMOTION_SUFFIX);
            ArrayList arrayList = new ArrayList();
            synchronized (this.f42a) {
                arrayList.addAll(this.f42a);
                this.f42a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m197a((hl) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m180a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m195a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m180a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hl hlVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hlVar.d());
        if (!a.a().m196a()) {
            a.a().m195a(context);
        }
        return a.a().m197a(hlVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        hl hlVar = new hl();
        hlVar.d(str);
        hlVar.c(str2);
        hlVar.a(j);
        hlVar.b(str3);
        hlVar.a(true);
        hlVar.a("push_sdk_channel");
        return upload(context, hlVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        hl hlVar = new hl();
        hlVar.d(str);
        hlVar.c(str2);
        hlVar.a(j);
        hlVar.b(str3);
        return a.a().m197a(hlVar);
    }
}
