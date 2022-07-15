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
/* loaded from: classes5.dex */
public final class f {
    public static Handler a;
    public static Messenger b;
    public static ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!f.k()) {
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = f.b;
                try {
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e2) {
                com.kwad.sdk.core.d.b.b(e2);
                com.kwad.sdk.service.a.a(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    public static volatile ExecutorService d;
    public static volatile AppStatusRules e;
    public static WeakReference<Context> f;
    public static com.kwad.sdk.collector.h g;

    /* renamed from: com.kwad.sdk.utils.f$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Context a;

        public AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.collector.c.a(this.a, new c.a() { // from class: com.kwad.sdk.utils.f.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void a(int i, String str) {
                    com.kwad.sdk.core.d.b.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void a(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.a);
                    AppStatusRules unused = f.e = appStatusRules;
                    f.b(AnonymousClass2.this.a, f.e);
                    f.a(AnonymousClass2.this.a);
                    boolean p = av.p(AnonymousClass2.this.a);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.e);
                    com.kwad.sdk.core.d.b.a("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + p);
                    if (p && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = f.e.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            f.a(AnonymousClass2.this.a, obtainDefaultScanInterval);
                        } else {
                            f.e(AnonymousClass2.this.a);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.e);
                    boolean z = f.e.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.b.a("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && p) {
                        f.l();
                        f.d.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.a, f.e);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.a.a(th);
                                    com.kwad.sdk.core.d.b.b(th);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements com.kwad.sdk.core.b {
        public String a;
        public String b;
        public List<Long> c = new ArrayList();

        public a() {
        }

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Nullable
        public static JSONArray a(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = b(list);
            } catch (Exception e) {
                com.kwad.sdk.service.a.a(e);
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

        private void a(long j) {
            this.c.add(Long.valueOf(j));
        }

        @Nullable
        public static List<a> b(List<com.kwad.sdk.collector.model.b> list) {
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
                            aVar.a(c);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e) {
                    com.kwad.sdk.core.d.b.b(e);
                }
            }
            return null;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("appName");
            this.b = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.c.clear();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.c.add(Long.valueOf(optJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.b.b(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "appName", this.a);
            r.a(jSONObject, "packageName", this.b);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.c) {
                jSONArray.put(l.longValue());
            }
            r.a(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<com.kwad.sdk.collector.model.b> list);
    }

    /* loaded from: classes5.dex */
    public static class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        private void a(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = r.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.f.c.1
                            public static a b() {
                                return new a();
                            }

                            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a a() {
                                return b();
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
                    com.kwad.sdk.core.d.b.a("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    a((ArrayList<com.kwad.sdk.collector.model.b>) arrayList);
                }
                if (list != null) {
                    a(list);
                }
            }
            if (f.f != null && f.f.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = r.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            public static AppStatusRules.Strategy b() {
                                return new AppStatusRules.Strategy();
                            }

                            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy a() {
                                return b();
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
                            com.kwad.sdk.collector.i.a((Context) f.f.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (f.f == null || f.c == null) {
                return;
            }
            com.kwad.sdk.core.d.b.a("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.a.a.b((Context) f.f.get(), f.c);
        }

        public static void a(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray a;
            if (arrayList == null || (a = a.a(arrayList)) == null) {
                return;
            }
            f.g.a(a);
        }

        public static void a(List<a> list) {
            if (list == null) {
                return;
            }
            f.g.a(r.b(list));
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                a(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements b {
        public b a = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.f.b
        public final void a(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray a = a.a(list);
            if (a != null) {
                f.g.a(a);
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(list);
            }
        }
    }

    public static AppStatusRules a() {
        return e;
    }

    @NonNull
    public static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.b.a("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        return !isNeedLaunch ? new ArrayList() : com.kwad.sdk.collector.b.a().a(strategy, map);
    }

    public static List<com.kwad.sdk.collector.model.b> a(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    @WorkerThread
    public static void a(Context context) {
        if (e == null) {
            e = d(context);
        }
    }

    public static void a(final Context context, final long j) {
        if (a == null) {
            a = new Handler(Looper.getMainLooper());
        }
        a.post(new Runnable() { // from class: com.kwad.sdk.utils.f.3
            @Override // java.lang.Runnable
            public final void run() {
                f.e(context);
                f.a.postDelayed(this, j);
            }
        });
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (an.l() || com.kwad.sdk.core.config.d.a((long) PlaybackStateCompat.ACTION_PLAY_FROM_URI) || context == null || com.kwad.sdk.utils.c.a(context)) {
            return;
        }
        g = hVar;
        boolean c2 = SystemUtil.c(context);
        com.kwad.sdk.core.d.b.a("AppStatusHelper", "isMainProcess: " + c2);
        if (c2) {
            f = new WeakReference<>(context);
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            a.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || an.l() || com.kwad.sdk.core.config.d.a((long) PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.a(context)) {
            return;
        }
        l();
        d.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            @Override // java.lang.Runnable
            public final void run() {
                List f2;
                try {
                    HashSet hashSet = new HashSet();
                    if (!av.p(context) || (f2 = f.f(context)) == null) {
                        return;
                    }
                    Iterator it = f2.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.b.a("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(f2);
                    if (bVar != null) {
                        bVar.a(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.b(th);
                    com.kwad.sdk.service.a.a(th);
                }
            }
        });
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        com.kwad.sdk.crash.utils.g.a(file.getAbsolutePath(), appStatusRules.toJson().toString(), false);
    }

    @Nullable
    @WorkerThread
    public static AppStatusRules d(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(com.kwad.sdk.crash.utils.g.a(file));
                AppStatusRules appStatusRules = new AppStatusRules();
                appStatusRules.parseJson(jSONObject);
                return appStatusRules;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static void e(Context context) {
        if (context == null) {
            return;
        }
        boolean m = m();
        com.kwad.sdk.core.d.b.a("AppStatusHelper", "isServiceAvailable: " + m);
        if (m) {
            com.kwad.sdk.collector.a.a.a(context, c);
        } else {
            a(context, new d(null));
        }
    }

    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> f(Context context) {
        if (av.p(context)) {
            if (e == null) {
                e = d(context);
            }
            return g(context);
        }
        return new ArrayList();
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    public static List<com.kwad.sdk.collector.model.b> g(Context context) {
        ArrayList arrayList = new ArrayList();
        if (an.l() || com.kwad.sdk.core.config.d.a((long) PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.a(context)) {
            return arrayList;
        }
        AppStatusRules a2 = a();
        Map<String, InstalledAppInfoManager.AppPackageInfo> k = ao.k(context);
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.a(a2)) {
            arrayList.addAll(a(strategy, k));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy b2 = com.kwad.sdk.collector.i.b(a2);
        arrayList.addAll(a(b2, k));
        b2.setNeedSaveLaunchTime(System.currentTimeMillis());
        return a(arrayList);
    }

    public static boolean k() {
        if (b == null) {
            try {
                b = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return b != null;
    }

    public static synchronized void l() {
        synchronized (f.class) {
            if (d != null) {
                return;
            }
            d = com.kwad.sdk.core.threads.b.i();
        }
    }

    public static boolean m() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = KsAdSDK.getContext();
                return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
            }
        } catch (ClassNotFoundException e2) {
            com.kwad.sdk.core.d.b.b(e2);
        }
        return false;
    }
}
