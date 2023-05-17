package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class f {
    public static Handler MX;
    public static ServiceConnection Zq = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!f.access$000()) {
                    com.kwad.sdk.core.e.b.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = f.amL;
                try {
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                com.kwad.sdk.service.a.gatherException(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    public static Messenger amL;
    public static volatile ExecutorService amM;
    public static volatile AppStatusRules amN;
    public static WeakReference<Context> amO;
    public static com.kwad.sdk.collector.h amP;

    /* renamed from: com.kwad.sdk.utils.f$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Context gC;

        public AnonymousClass2(Context context) {
            this.gC = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.collector.c.a(this.gC, new c.a() { // from class: com.kwad.sdk.utils.f.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.gC);
                    AppStatusRules unused = f.amN = appStatusRules;
                    f.b(AnonymousClass2.this.gC, f.amN);
                    f.bS(AnonymousClass2.this.gC);
                    boolean dy = az.dy(AnonymousClass2.this.gC);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.amN);
                    com.kwad.sdk.core.e.b.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + dy);
                    if (dy && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = f.amN.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            f.e(AnonymousClass2.this.gC, obtainDefaultScanInterval);
                        } else {
                            f.bU(AnonymousClass2.this.gC);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.amN);
                    boolean z = f.amN.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.e.b.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && dy) {
                        f.yX();
                        f.amM.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.gC, f.amN);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.a.gatherException(th);
                                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void g(int i, String str) {
                    com.kwad.sdk.core.e.b.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements com.kwad.sdk.core.b {
        public List<Long> amV = new ArrayList();
        public String appName;
        public String packageName;

        public a() {
        }

        public a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        private void S(long j) {
            this.amV.add(Long.valueOf(j));
        }

        @Nullable
        public static JSONArray y(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = z(list);
            } catch (Exception e) {
                com.kwad.sdk.service.a.gatherException(e);
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar : list2) {
                jSONArray.put(aVar.toJson());
            }
            return jSONArray;
        }

        @Nullable
        public static List<a> z(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String b = com.kwad.sdk.collector.model.c.b(bVar);
                        if (hashMap.containsKey(b)) {
                            aVar = (a) hashMap.get(b);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            hashMap.put(b, aVar2);
                            aVar = aVar2;
                        }
                        long c = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.S(c);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                }
            }
            return null;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.amV.clear();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.amV.add(Long.valueOf(optJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.putValue(jSONObject, "appName", this.appName);
            r.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.amV) {
                jSONArray.put(l.longValue());
            }
            r.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void m(List<com.kwad.sdk.collector.model.b> list);
    }

    /* loaded from: classes9.dex */
    public static class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        public static void A(List<a> list) {
            if (list == null) {
                return;
            }
            f.amP.c(r.B(list));
        }

        public static void a(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray y;
            if (arrayList == null || (y = a.y(arrayList)) == null) {
                return;
            }
            f.amP.c(y);
        }

        private void b(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = r.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.f.c.1
                            public static a zg() {
                                return new a();
                            }

                            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a qt() {
                                return zg();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        list = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.e.b.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    a(arrayList);
                }
                if (list != null) {
                    A(list);
                }
            }
            if (f.amO != null && f.amO.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = r.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            public static AppStatusRules.Strategy zh() {
                                return new AppStatusRules.Strategy();
                            }

                            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy qt() {
                                return zh();
                            }
                        });
                    }
                } else {
                    list2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (list2 != null) {
                    for (AppStatusRules.Strategy strategy : list2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) f.amO.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (f.amO == null || f.Zq == null) {
                return;
            }
            com.kwad.sdk.core.e.b.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.a.a.b((Context) f.amO.get(), f.Zq);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                b(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements b {
        public b amX = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.f.b
        public final void m(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray y = a.y(list);
            if (y != null) {
                f.amP.c(y);
            }
            b bVar = this.amX;
            if (bVar != null) {
                bVar.m(list);
            }
        }
    }

    @NonNull
    public static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.e.b.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        return !isNeedLaunch ? new ArrayList() : com.kwad.sdk.collector.b.rp().a(strategy, map);
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (aq.Ae() || com.kwad.sdk.core.config.d.i(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || context == null || com.kwad.sdk.utils.c.bQ(context)) {
            return;
        }
        amP = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.e.b.d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (isInMainProcess) {
            amO = new WeakReference<>(context);
            if (MX == null) {
                MX = new Handler(Looper.getMainLooper());
            }
            MX.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || aq.Ae() || com.kwad.sdk.core.config.d.i(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bQ(context)) {
            return;
        }
        yX();
        amM.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            @Override // java.lang.Runnable
            public final void run() {
                List bV;
                try {
                    HashSet hashSet = new HashSet();
                    if (!az.dy(context) || (bV = f.bV(context)) == null) {
                        return;
                    }
                    Iterator it = bV.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.e.b.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(bV);
                    if (bVar != null) {
                        bVar.m(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                    com.kwad.sdk.service.a.gatherException(th);
                }
            }
        });
    }

    public static /* synthetic */ boolean access$000() {
        return yW();
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.g.g(file.getAbsolutePath(), com.kwad.sdk.core.a.c.bN(jSONObject), false);
    }

    @WorkerThread
    public static void bS(Context context) {
        if (amN == null) {
            amN = bT(context);
        }
    }

    @Nullable
    @WorkerThread
    public static AppStatusRules bT(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (file.exists()) {
            try {
                String F = com.kwad.sdk.crash.utils.g.F(file);
                if (TextUtils.isEmpty(F)) {
                    return null;
                }
                if (com.kwad.sdk.core.a.c.bP(F)) {
                    F = com.kwad.sdk.core.a.c.bO(F);
                }
                JSONObject jSONObject = new JSONObject(F);
                AppStatusRules appStatusRules = new AppStatusRules();
                appStatusRules.parseJson(jSONObject);
                return appStatusRules;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static void bU(Context context) {
        if (context == null) {
            return;
        }
        boolean yY = yY();
        com.kwad.sdk.core.e.b.d("AppStatusHelper", "isServiceAvailable: " + yY);
        if (yY) {
            com.kwad.sdk.collector.a.a.a(context, Zq);
        } else {
            a(context, new d(null));
        }
    }

    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> bV(Context context) {
        if (az.dy(context)) {
            if (amN == null) {
                amN = bT(context);
            }
            return bW(context);
        }
        return new ArrayList();
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    public static List<com.kwad.sdk.collector.model.b> bW(Context context) {
        ArrayList arrayList = new ArrayList();
        if (aq.Ae() || com.kwad.sdk.core.config.d.i(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bQ(context)) {
            return arrayList;
        }
        AppStatusRules yV = yV();
        Map<String, InstalledAppInfoManager.AppPackageInfo> cT = ar.cT(context);
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(yV)) {
            arrayList.addAll(a(strategy, cT));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy d2 = com.kwad.sdk.collector.i.d(yV);
        arrayList.addAll(a(d2, cT));
        d2.setNeedSaveLaunchTime(System.currentTimeMillis());
        return x(arrayList);
    }

    public static void e(final Context context, final long j) {
        if (MX == null) {
            MX = new Handler(Looper.getMainLooper());
        }
        MX.post(new Runnable() { // from class: com.kwad.sdk.utils.f.3
            @Override // java.lang.Runnable
            public final void run() {
                f.bU(context);
                f.MX.postDelayed(this, j);
            }
        });
    }

    public static List<com.kwad.sdk.collector.model.b> x(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static AppStatusRules yV() {
        return amN;
    }

    public static boolean yW() {
        if (amL == null) {
            try {
                amL = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return amL != null;
    }

    public static synchronized void yX() {
        synchronized (f.class) {
            if (amM != null) {
                return;
            }
            amM = com.kwad.sdk.core.threads.b.vp();
        }
    }

    public static boolean yY() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = KsAdSDK.getContext();
                return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
            }
        } catch (ClassNotFoundException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        return false;
    }
}
