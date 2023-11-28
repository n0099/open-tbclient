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
        public Context f33a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f35a;

        /* renamed from: a  reason: collision with other field name */
        public String f36a;

        /* renamed from: a  reason: collision with other field name */
        public C0756a f34a = new C0756a();

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<hl> f37a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0756a {

            /* renamed from: a  reason: collision with other field name */
            public ScheduledFuture<?> f40a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledThreadPoolExecutor f41a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hl> f39a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            public final Runnable f38a = new ab(this);

            public C0756a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f40a == null) {
                    this.f40a = this.f41a.scheduleAtFixedRate(this.f38a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hl remove = this.f39a.remove(0);
                for (ig igVar : bz.a(Arrays.asList(remove), a.this.f33a.getPackageName(), b.m234a(a.this.f33a).m235a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ao.a(a.this.f33a).a((ao) igVar, hh.Notification, true, (hu) null);
                }
            }

            public void a(hl hlVar) {
                this.f41a.execute(new aa(this, hlVar));
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
            synchronized (this.f37a) {
                if (!this.f37a.contains(hlVar)) {
                    this.f37a.add(hlVar);
                    if (this.f37a.size() > 100) {
                        this.f37a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ao.a(context).m227a()) {
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
            return b.m234a(context).m235a() == null && !a(this.f33a);
        }

        private boolean b(hl hlVar) {
            if (bz.a(hlVar, false)) {
                return false;
            }
            if (!this.f35a.booleanValue()) {
                this.f34a.a(hlVar);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hlVar.d());
            ao.a(this.f33a).a(hlVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m205a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m190a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f33a = context;
            this.f35a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m190a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f36a = str;
            b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m206a() {
            return this.f33a != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL;
         */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean m207a(hl hlVar) {
            String str;
            boolean z = false;
            if (hlVar == null) {
                return false;
            }
            if (bz.a(hlVar, true)) {
                return false;
            }
            boolean z2 = TextUtils.isEmpty(hlVar.m562a()) && TextUtils.isEmpty(this.f36a);
            boolean z3 = !m206a();
            z = (this.f33a == null || b(this.f33a)) ? true : true;
            if (!z3 && !z2 && !z) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + hlVar.d());
                if (TextUtils.isEmpty(hlVar.d())) {
                    hlVar.f(bd.a());
                }
                if (TextUtils.isEmpty(hlVar.m562a())) {
                    hlVar.a(this.f36a);
                }
                if (TextUtils.isEmpty(hlVar.c())) {
                    hlVar.e(this.f33a.getPackageName());
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
            synchronized (this.f37a) {
                arrayList.addAll(this.f37a);
                this.f37a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m207a((hl) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m190a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m205a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m190a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hl hlVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hlVar.d());
        if (!a.a().m206a()) {
            a.a().m205a(context);
        }
        return a.a().m207a(hlVar);
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
        return a.a().m207a(hlVar);
    }
}
