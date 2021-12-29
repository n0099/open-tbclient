package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public static Handler a;

    /* renamed from: b  reason: collision with root package name */
    public static Messenger f60226b;

    /* renamed from: c  reason: collision with root package name */
    public static ServiceConnection f60227c = new ServiceConnection() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Messenger messenger = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.what = 100;
            if (!h.j()) {
                com.kwad.sdk.core.d.a.d("AppStatusHelper", "clientMessenger init error");
                return;
            }
            obtain.replyTo = h.f60226b;
            try {
                messenger.send(obtain);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static volatile ExecutorService f60228d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile AppStatusRules f60229e;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<Context> f60230f;

    /* renamed from: com.kwad.sdk.utils.h$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Context a;

        public AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.collector.c.a(this.a, new c.a() { // from class: com.kwad.sdk.utils.h.2.1
                @Override // com.kwad.sdk.collector.c.a
                public void a(int i2, String str) {
                    com.kwad.sdk.core.d.a.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i2);
                }

                @Override // com.kwad.sdk.collector.c.a
                public void a(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.a);
                    AppStatusRules unused = h.f60229e = appStatusRules;
                    h.b(AnonymousClass2.this.a, h.f60229e);
                    h.a(AnonymousClass2.this.a);
                    boolean l = h.l(AnonymousClass2.this.a);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(h.f60229e);
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + l);
                    if (l && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = h.f60229e.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            h.b(AnonymousClass2.this.a, obtainDefaultScanInterval);
                        } else {
                            h.i(AnonymousClass2.this.a);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(h.f60229e);
                    boolean z = h.f60229e.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && l) {
                        h.k();
                        h.f60228d.submit(new Runnable() { // from class: com.kwad.sdk.utils.h.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.a, h.f60229e);
                                } catch (Throwable th) {
                                    com.kwad.sdk.crash.a.a(th);
                                    com.kwad.sdk.core.d.a.b(th);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements com.kwad.sdk.core.b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f60233b;

        /* renamed from: c  reason: collision with root package name */
        public List<Long> f60234c = new ArrayList();

        public a() {
        }

        public a(String str, String str2) {
            this.a = str;
            this.f60233b = str2;
        }

        @Nullable
        public static JSONArray a(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = b(list);
            } catch (Exception e2) {
                com.kwad.sdk.crash.a.a(e2);
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
        public static List<a> b(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list == null || list.size() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (com.kwad.sdk.collector.model.b bVar : list) {
                String b2 = com.kwad.sdk.collector.model.c.b(bVar);
                if (hashMap.containsKey(b2)) {
                    aVar = (a) hashMap.get(b2);
                } else {
                    a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                    hashMap.put(b2, aVar2);
                    aVar = aVar2;
                }
                long c2 = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                if (aVar != null) {
                    aVar.a(c2);
                }
            }
            return new ArrayList(hashMap.values());
        }

        public void a(long j2) {
            this.f60234c.add(Long.valueOf(j2));
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("appName");
            this.f60233b = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.f60234c.clear();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        this.f60234c.add(Long.valueOf(optJSONArray.getLong(i2)));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "appName", this.a);
            t.a(jSONObject, "packageName", this.f60233b);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.f60234c) {
                jSONArray.put(l.longValue());
            }
            t.a(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(List<com.kwad.sdk.collector.model.b> list);
    }

    /* loaded from: classes3.dex */
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
                        list = t.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.h.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.kwad.sdk.core.c
                            /* renamed from: b */
                            public a a() {
                                return new a();
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
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    a((ArrayList<com.kwad.sdk.collector.model.b>) arrayList);
                }
                if (list != null) {
                    a(list);
                }
            }
            if (h.f60230f != null && h.f60230f.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = t.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.h.c.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.kwad.sdk.core.c
                            /* renamed from: b */
                            public AppStatusRules.Strategy a() {
                                return new AppStatusRules.Strategy();
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
                            com.kwad.sdk.collector.h.a((Context) h.f60230f.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (h.f60230f == null || h.f60227c == null) {
                return;
            }
            com.kwad.sdk.core.d.a.a("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.b.a.b((Context) h.f60230f.get(), h.f60227c);
        }

        public static void a(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray a;
            if (arrayList == null || (a = a.a(arrayList)) == null) {
                return;
            }
            com.kwad.sdk.core.report.d.a(a);
        }

        public static void a(List<a> list) {
            JSONArray b2;
            if (list == null || (b2 = t.b(list)) == null) {
                return;
            }
            com.kwad.sdk.core.report.d.a(b2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                a(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements b {
        public b a;

        public d(b bVar) {
            this.a = bVar;
        }

        @Override // com.kwad.sdk.utils.h.b
        public void a(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray a = a.a(list);
            if (a != null) {
                com.kwad.sdk.core.report.d.a(a);
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(list);
            }
        }
    }

    public static AppStatusRules a() {
        return f60229e;
    }

    @NonNull
    public static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        return !isNeedLaunch ? new ArrayList() : com.kwad.sdk.collector.b.a().a(strategy, map);
    }

    public static List<com.kwad.sdk.collector.model.b> a(List<com.kwad.sdk.collector.model.b> list) {
        return (list == null || list.isEmpty()) ? list : new ArrayList(new LinkedHashSet(list));
    }

    @WorkerThread
    public static void a(Context context) {
        if (f60229e == null) {
            f60229e = h(context);
        }
    }

    public static void a(Context context, long j2) {
        if (ao.l() || com.kwad.sdk.core.config.b.a(8192L) || context == null || m(context)) {
            return;
        }
        boolean b2 = SystemUtil.b(context);
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "isMainProcess: " + b2);
        if (b2) {
            f60230f = new WeakReference<>(context);
            if (j2 <= 0) {
                j2 = 30000;
            }
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            a.postDelayed(new AnonymousClass2(context), j2);
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || ao.l() || com.kwad.sdk.core.config.b.a(8192L) || m(context)) {
            return;
        }
        k();
        f60228d.submit(new Runnable() { // from class: com.kwad.sdk.utils.h.4
            @Override // java.lang.Runnable
            public void run() {
                List k2;
                List j2;
                try {
                    HashSet hashSet = new HashSet();
                    if (Build.VERSION.SDK_INT < 21 && (j2 = h.j(context)) != null) {
                        hashSet.addAll(j2);
                    }
                    if (!h.l(context) || (k2 = h.k(context)) == null) {
                        return;
                    }
                    Iterator it = k2.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.a.a("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(k2);
                    if (bVar != null) {
                        bVar.a(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                    com.kwad.sdk.crash.a.a(th);
                }
            }
        });
    }

    @Nullable
    public static List<String> b(@NonNull Context context) {
        String[] list;
        if (ao.l() || com.kwad.sdk.core.config.b.a(8192L)) {
            return new ArrayList();
        }
        if (!m(context) && l(context)) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
            if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return new ArrayList();
    }

    public static void b(final Context context, final long j2) {
        if (a == null) {
            a = new Handler(Looper.getMainLooper());
        }
        a.post(new Runnable() { // from class: com.kwad.sdk.utils.h.3
            @Override // java.lang.Runnable
            public void run() {
                h.i(context);
                h.a.postDelayed(this, j2);
            }
        });
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        com.kwad.sdk.crash.utils.h.a(file.getAbsolutePath(), appStatusRules.toJson().toString(), false);
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    public static List<com.kwad.sdk.collector.model.b> c(Context context) {
        ArrayList arrayList = new ArrayList();
        if (ao.l() || com.kwad.sdk.core.config.b.a(8192L) || m(context)) {
            return arrayList;
        }
        AppStatusRules a2 = a();
        Map<String, InstalledAppInfoManager.AppPackageInfo> b2 = InstalledAppInfoManager.b(context);
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.h.a(a2)) {
            arrayList.addAll(a(strategy, b2));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy b3 = com.kwad.sdk.collector.h.b(a2);
        arrayList.addAll(a(b3, b2));
        b3.setNeedSaveLaunchTime(System.currentTimeMillis());
        return a(arrayList);
    }

    @Nullable
    @WorkerThread
    public static AppStatusRules h(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(com.kwad.sdk.crash.utils.h.a(file));
                AppStatusRules appStatusRules = new AppStatusRules();
                appStatusRules.parseJson(jSONObject);
                return appStatusRules;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static void i(Context context) {
        if (context == null) {
            return;
        }
        boolean l = l();
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "isServiceAvailable: " + l);
        if (l) {
            com.kwad.sdk.collector.b.a.a(context, f60227c);
        } else {
            a(context, new d(null));
        }
    }

    @Nullable
    public static List<com.kwad.sdk.collector.model.b> j(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if ((av.a(context, com.kuaishou.weapon.un.s.f57421e) == 0) && (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100)) != null) {
            LinkedList linkedList = new LinkedList();
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                ComponentName componentName = runningTaskInfo.topActivity;
                if (componentName != null) {
                    String packageName = componentName.getPackageName();
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "packageName:" + packageName);
                    linkedList.add(new com.kwad.sdk.collector.model.kwai.b(-1L, null, packageName));
                }
            }
            return linkedList;
        }
        return null;
    }

    public static boolean j() {
        if (f60226b == null) {
            try {
                f60226b = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return f60226b != null;
    }

    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> k(Context context) {
        if (l(context)) {
            if (f60229e == null) {
                f60229e = h(context);
            }
            return c(context);
        }
        return new ArrayList();
    }

    public static synchronized void k() {
        synchronized (h.class) {
            if (f60228d != null) {
                return;
            }
            f60228d = com.kwad.sdk.core.i.b.m();
        }
    }

    public static boolean l() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = KsAdSDK.getContext();
                return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
            }
        } catch (ClassNotFoundException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        return false;
    }

    public static boolean l(@NonNull Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean m(@NonNull Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy();
    }
}
