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
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f {
    public static Handler XX;
    public static Messenger aMG;
    public static volatile ExecutorService aMH;
    public static volatile AppStatusRules aMI;
    public static WeakReference<Context> aMJ;
    public static com.kwad.sdk.collector.h aMK;
    public static ServiceConnection auT = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (f.access$000()) {
                    obtain.replyTo = f.aMG;
                    try {
                        messenger.send(obtain);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                com.kwad.sdk.core.e.c.w("AppStatusHelper", "clientMessenger init error");
            } catch (SecurityException e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.service.c.gatherException(e);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface b {
        void s(List<com.kwad.sdk.collector.model.b> list);
    }

    /* renamed from: com.kwad.sdk.utils.f$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Context gq;

        public AnonymousClass2(Context context) {
            this.gq = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.collector.c.a(this.gq, new c.a() { // from class: com.kwad.sdk.utils.f.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    boolean z;
                    appStatusRules.initStatus(AnonymousClass2.this.gq);
                    AppStatusRules unused = f.aMI = appStatusRules;
                    f.b(AnonymousClass2.this.gq, f.aMI);
                    f.bH(AnonymousClass2.this.gq);
                    boolean di = bi.di(AnonymousClass2.this.gq);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.aMI);
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + di);
                    if (di && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = f.aMI.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval <= 0) {
                            f.bJ(AnonymousClass2.this.gq);
                        } else {
                            f.c(AnonymousClass2.this.gq, obtainDefaultScanInterval);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.aMI);
                    if (f.aMI.obtainUploadConfigFileMaxSize() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && di) {
                        f.Js();
                        f.aMH.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.gq, f.aMI);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.c.gatherException(th);
                                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void p(int i, String str) {
                    com.kwad.sdk.core.e.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class a implements com.kwad.sdk.core.b {
        public List<Long> aMQ = new ArrayList();
        public String appName;
        public String packageName;

        public a() {
        }

        public a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        public static JSONArray H(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = I(list);
            } catch (Exception e) {
                com.kwad.sdk.service.c.gatherException(e);
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

        private void aw(long j) {
            this.aMQ.add(Long.valueOf(j));
        }

        @Nullable
        public static List<a> I(List<com.kwad.sdk.collector.model.b> list) {
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
                            aVar.aw(c);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
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
                this.aMQ.clear();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.aMQ.add(Long.valueOf(optJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "appName", this.appName);
            t.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.aMQ) {
                jSONArray.put(l.longValue());
            }
            t.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        public static void J(List<a> list) {
            if (list == null) {
                return;
            }
            f.aMK.c(t.K(list));
        }

        public static void b(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray H;
            if (arrayList != null && (H = a.H(arrayList)) != null) {
                f.aMK.c(H);
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 101) {
                try {
                    c(message);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        private void c(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = t.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.f.c.1
                            public static a JB() {
                                return new a();
                            }

                            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a Ac() {
                                return JB();
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
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    b(arrayList);
                }
                if (list != null) {
                    J(list);
                }
            }
            if (f.aMJ != null && f.aMJ.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = t.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            public static AppStatusRules.Strategy JC() {
                                return new AppStatusRules.Strategy();
                            }

                            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy Ac() {
                                return JC();
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
                            com.kwad.sdk.collector.i.a((Context) f.aMJ.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (f.aMJ != null && f.auT != null) {
                com.kwad.sdk.core.e.c.d("AppStatusHelper", "unbindASService");
                com.kwad.sdk.collector.b.a.b((Context) f.aMJ.get(), f.auT);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements b {
        public b aMS = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.f.b
        public final void s(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray H = a.H(list);
            if (H != null) {
                f.aMK.c(H);
            }
            b bVar = this.aMS;
            if (bVar != null) {
                bVar.s(list);
            }
        }
    }

    public static AppStatusRules Jq() {
        return aMI;
    }

    public static boolean Jr() {
        if (aMG == null) {
            try {
                aMG = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        if (aMG != null) {
            return true;
        }
        return false;
    }

    public static void Js() {
        if (aMH == null) {
            synchronized (f.class) {
                if (aMH == null) {
                    ExecutorService EA = GlobalThreadPools.EA();
                    aMH = EA;
                    com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) EA, "appStatusHelper");
                }
            }
        }
    }

    public static boolean Jt() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = ServiceProvider.getContext();
                if (context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() <= 0) {
                    return false;
                }
                return true;
            }
        } catch (ClassNotFoundException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        return false;
    }

    public static /* synthetic */ boolean access$000() {
        return Jr();
    }

    public static List<com.kwad.sdk.collector.model.b> G(List<com.kwad.sdk.collector.model.b> list) {
        if (list.isEmpty()) {
            return list;
        }
        return new ArrayList(new LinkedHashSet(list));
    }

    @WorkerThread
    public static void bH(Context context) {
        if (aMI == null) {
            aMI = bI(context);
        }
    }

    public static void bJ(Context context) {
        if (context == null) {
            return;
        }
        boolean Jt = Jt();
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "isServiceAvailable: " + Jt);
        if (Jt) {
            com.kwad.sdk.collector.b.a.a(context, auT);
        } else {
            a(context, new d(null));
        }
    }

    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> bK(Context context) {
        if (!bi.di(context)) {
            return new ArrayList();
        }
        if (aMI == null) {
            aMI = bI(context);
        }
        return bL(context);
    }

    @NonNull
    public static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        if (!isNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.zA().a(strategy);
    }

    @Nullable
    @WorkerThread
    public static AppStatusRules bI(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String I = com.kwad.sdk.crash.utils.h.I(file);
            if (TextUtils.isEmpty(I)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.dl(I)) {
                I = com.kwad.sdk.core.a.c.dk(I);
            }
            JSONObject jSONObject = new JSONObject(I);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (au.KP() || com.kwad.sdk.core.config.d.T(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || context == null || com.kwad.sdk.utils.c.bF(context)) {
            return;
        }
        aMK = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (!isInMainProcess) {
            return;
        }
        aMJ = new WeakReference<>(context);
        if (XX == null) {
            XX = new Handler(Looper.getMainLooper());
        }
        XX.postDelayed(new AnonymousClass2(context), 30000L);
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || au.KP() || com.kwad.sdk.core.config.d.T(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bF(context)) {
            return;
        }
        Js();
        aMH.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            @Override // java.lang.Runnable
            public final void run() {
                List bK;
                try {
                    HashSet hashSet = new HashSet();
                    if (bi.di(context) && (bK = f.bK(context)) != null) {
                        Iterator it = bK.iterator();
                        while (it.hasNext()) {
                            com.kwad.sdk.core.e.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                        }
                        hashSet.addAll(bK);
                        if (bVar != null) {
                            bVar.s(new ArrayList(hashSet));
                        }
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    com.kwad.sdk.service.c.gatherException(th);
                }
            }
        });
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.k(file.getAbsolutePath(), com.kwad.sdk.core.a.c.dj(jSONObject), false);
    }

    public static void c(final Context context, final long j) {
        if (XX == null) {
            XX = new Handler(Looper.getMainLooper());
        }
        XX.post(new Runnable() { // from class: com.kwad.sdk.utils.f.3
            @Override // java.lang.Runnable
            public final void run() {
                f.bJ(context);
                f.XX.postDelayed(this, j);
            }
        });
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    public static List<com.kwad.sdk.collector.model.b> bL(Context context) {
        ArrayList arrayList = new ArrayList();
        if (!au.KP() && !com.kwad.sdk.core.config.d.T(PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            if (com.kwad.sdk.utils.c.bF(context)) {
                return arrayList;
            }
            AppStatusRules Jq = Jq();
            for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(Jq)) {
                arrayList.addAll(a(strategy));
                strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
            }
            AppStatusRules.Strategy d2 = com.kwad.sdk.collector.i.d(Jq);
            arrayList.addAll(a(d2));
            d2.setNeedSaveLaunchTime(System.currentTimeMillis());
            return G(arrayList);
        }
        return arrayList;
    }
}
