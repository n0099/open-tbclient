package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
import com.xiaomi.push.service.bm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f38042a;

        /* renamed from: a  reason: collision with other field name */
        public Context f45a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f47a;

        /* renamed from: a  reason: collision with other field name */
        public String f48a;

        /* renamed from: a  reason: collision with other field name */
        public C0482a f46a = new C0482a();

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<hj> f49a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0482a {

            /* renamed from: a  reason: collision with other field name */
            public ScheduledFuture<?> f52a;

            /* renamed from: a  reason: collision with other field name */
            public ScheduledThreadPoolExecutor f53a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hj> f51a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            public final Runnable f50a = new aa(this);

            public C0482a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f52a == null) {
                    this.f52a = this.f53a.scheduleAtFixedRate(this.f50a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hj remove = this.f51a.remove(0);
                for (ie ieVar : bm.a(Arrays.asList(remove), a.this.f45a.getPackageName(), b.m99a(a.this.f45a).m100a(), TbConfig.VOICE_CHUNK_UPLOAD_SIZE)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    an.a(a.this.f45a).a((an) ieVar, hf.Notification, true, (hs) null);
                }
            }

            public void a(hj hjVar) {
                this.f53a.execute(new z(this, hjVar));
            }
        }

        public static a a() {
            if (f38042a == null) {
                synchronized (a.class) {
                    if (f38042a == null) {
                        f38042a = new a();
                    }
                }
            }
            return f38042a;
        }

        private void a(hj hjVar) {
            synchronized (this.f49a) {
                if (!this.f49a.contains(hjVar)) {
                    this.f49a.add(hjVar);
                    if (this.f49a.size() > 100) {
                        this.f49a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (an.a(context).m92a()) {
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
            return b.m99a(context).m100a() == null && !a(this.f45a);
        }

        private boolean b(hj hjVar) {
            if (bm.a(hjVar, false)) {
                return false;
            }
            if (!this.f47a.booleanValue()) {
                this.f46a.a(hjVar);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hjVar.d());
            an.a(this.f45a).a(hjVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m72a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m58a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f45a = context;
            this.f47a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m58a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f48a = str;
            b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m73a() {
            return this.f45a != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL;
         */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean m74a(hj hjVar) {
            String str;
            boolean z = false;
            if (hjVar == null) {
                return false;
            }
            if (bm.a(hjVar, true)) {
                return false;
            }
            boolean z2 = TextUtils.isEmpty(hjVar.m363a()) && TextUtils.isEmpty(this.f48a);
            boolean z3 = !m73a();
            z = (this.f45a == null || b(this.f45a)) ? true : true;
            if (!z3 && !z2 && !z) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + hjVar.d());
                if (TextUtils.isEmpty(hjVar.d())) {
                    hjVar.f(com.xiaomi.push.service.at.a());
                }
                if (TextUtils.isEmpty(hjVar.m363a())) {
                    hjVar.a(this.f48a);
                }
                if (TextUtils.isEmpty(hjVar.c())) {
                    hjVar.e(this.f45a.getPackageName());
                }
                if (hjVar.a() <= 0) {
                    hjVar.b(System.currentTimeMillis());
                }
                return b(hjVar);
            }
            if (!z3) {
                if (z) {
                    str = "MiTinyDataClient Pending " + hjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID;
                }
                a(hjVar);
                return true;
            }
            str = "MiTinyDataClient Pending " + hjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT;
            com.xiaomi.channel.commonutils.logger.b.c(str);
            a(hjVar);
            return true;
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + SmallTailInfo.EMOTION_SUFFIX);
            ArrayList arrayList = new ArrayList();
            synchronized (this.f49a) {
                arrayList.addAll(this.f49a);
                this.f49a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m74a((hj) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m58a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m72a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m58a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hj hjVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hjVar.d());
        if (!a.a().m73a()) {
            a.a().m72a(context);
        }
        return a.a().m74a(hjVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        hj hjVar = new hj();
        hjVar.d(str);
        hjVar.c(str2);
        hjVar.a(j);
        hjVar.b(str3);
        hjVar.a(true);
        hjVar.a("push_sdk_channel");
        return upload(context, hjVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        hj hjVar = new hj();
        hjVar.d(str);
        hjVar.c(str2);
        hjVar.a(j);
        hjVar.b(str3);
        return a.a().m74a(hjVar);
    }
}
