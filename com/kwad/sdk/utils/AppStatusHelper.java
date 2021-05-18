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
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.collector.AppRunningInfo;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.FNode;
import com.kwad.sdk.collector.NodeFilter;
import com.kwad.sdk.collector.b;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AppStatusHelper {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f34064a;

    /* renamed from: b  reason: collision with root package name */
    public static Messenger f34065b;

    /* renamed from: c  reason: collision with root package name */
    public static ServiceConnection f34066c = new ServiceConnection() { // from class: com.kwad.sdk.utils.AppStatusHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Messenger messenger = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.what = 100;
            if (!AppStatusHelper.j()) {
                com.kwad.sdk.core.d.a.d("AppStatusHelper", "clientMessenger init error");
                return;
            }
            obtain.replyTo = AppStatusHelper.f34065b;
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
    public static volatile ExecutorService f34067d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile AppStatusRules f34068e;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<Context> f34069f;

    /* renamed from: com.kwad.sdk.utils.AppStatusHelper$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34070a;

        public AnonymousClass2(Context context) {
            this.f34070a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.collector.b.a(this.f34070a, new b.a() { // from class: com.kwad.sdk.utils.AppStatusHelper.2.1
                @Override // com.kwad.sdk.collector.b.a
                public void a(int i2, String str) {
                    com.kwad.sdk.core.d.a.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i2);
                }

                @Override // com.kwad.sdk.collector.b.a
                public void a(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.f34070a);
                    AppStatusRules unused = AppStatusHelper.f34068e = appStatusRules;
                    AppStatusHelper.b(AnonymousClass2.this.f34070a, AppStatusHelper.f34068e);
                    AppStatusHelper.a(AnonymousClass2.this.f34070a);
                    long obtainDefaultScanInterval = AppStatusHelper.f34068e.obtainDefaultScanInterval();
                    if (obtainDefaultScanInterval > 0) {
                        AppStatusHelper.b(AnonymousClass2.this.f34070a, obtainDefaultScanInterval);
                    } else {
                        AppStatusHelper.h(AnonymousClass2.this.f34070a);
                    }
                    boolean z = AppStatusHelper.f34068e.obtainUploadConfigFileMaxSize() > 0;
                    boolean k = AppStatusHelper.k(AnonymousClass2.this.f34070a);
                    if (z && k) {
                        AppStatusHelper.k();
                        AppStatusHelper.f34067d.submit(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.kwad.sdk.collector.i.a(AnonymousClass2.this.f34070a, AppStatusHelper.f34068e);
                            }
                        });
                    }
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static class PackageNameFilter implements NodeFilter {
        public HashMap<String, InstalledAppInfoManager.AppPackageInfo> installedApp;
        public HashSet<String> packageSet;

        public PackageNameFilter(Context context) {
            this.installedApp = new HashMap<>(InstalledAppInfoManager.b(context));
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, InstalledAppInfoManager.AppPackageInfo> entry : this.installedApp.entrySet()) {
                InstalledAppInfoManager.AppPackageInfo value = entry.getValue();
                String key = entry.getKey();
                if (!value.isSystemApp) {
                    hashMap.put(key, value);
                }
            }
            this.packageSet = new HashSet<>(this.installedApp.keySet());
        }

        public HashMap<String, InstalledAppInfoManager.AppPackageInfo> getInstalledApp() {
            return this.installedApp;
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public void onChildNodeCreate(FNode fNode) {
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = this.installedApp.get(fNode.getRealFile().getName());
            if (appPackageInfo != null) {
                fNode.setAppRunningInfo(AppRunningInfo.createInstance(appPackageInfo, null));
            }
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public boolean onFilterChild(File file) {
            return this.packageSet.contains(file.getName());
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f34077a;

        /* renamed from: b  reason: collision with root package name */
        public String f34078b;

        /* renamed from: c  reason: collision with root package name */
        public List<Long> f34079c = new ArrayList();

        public a(String str, String str2) {
            this.f34077a = str;
            this.f34078b = str2;
        }

        @Nullable
        public static JSONArray a(List<AppRunningInfo> list) {
            List<a> b2 = b(list);
            if (b2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar : b2) {
                jSONArray.put(aVar.a());
            }
            return jSONArray;
        }

        @Nullable
        public static List<a> b(List<AppRunningInfo> list) {
            a aVar;
            if (list == null || list.size() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (AppRunningInfo appRunningInfo : list) {
                String packageName = appRunningInfo.getPackageName();
                if (hashMap.containsKey(packageName)) {
                    aVar = (a) hashMap.get(packageName);
                } else {
                    a aVar2 = new a(appRunningInfo.getName(), appRunningInfo.getPackageName());
                    hashMap.put(packageName, aVar2);
                    aVar = aVar2;
                }
                long lastRunningTime = appRunningInfo.getLastRunningTime() / 1000;
                if (aVar != null) {
                    aVar.a(lastRunningTime);
                }
            }
            return new ArrayList(hashMap.values());
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "appName", this.f34077a);
            o.a(jSONObject, "packageName", this.f34078b);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.f34079c) {
                jSONArray.put(l.longValue());
            }
            o.a(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public void a(long j) {
            this.f34079c.add(Long.valueOf(j));
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(List<AppRunningInfo> list);
    }

    /* loaded from: classes6.dex */
    public static class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        public static void a(ArrayList<AppRunningInfo> arrayList) {
            JSONArray a2;
            if (arrayList == null || (a2 = a.a(arrayList)) == null) {
                return;
            }
            com.kwad.sdk.core.report.e.a(a2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            ArrayList arrayList;
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                Bundle data = message.getData();
                if (data != null && (arrayList = (ArrayList) data.getSerializable("data")) != null) {
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    a(arrayList);
                }
                if (AppStatusHelper.f34069f == null || AppStatusHelper.f34069f.get() == null) {
                    return;
                }
                com.kwad.sdk.collector.c.a.b((Context) AppStatusHelper.f34069f.get(), AppStatusHelper.f34066c);
                ArrayList arrayList2 = (ArrayList) data.getSerializable("allStrategy");
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        AppStatusRules.Strategy strategy = (AppStatusRules.Strategy) it.next();
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.g.a((Context) AppStatusHelper.f34069f.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        public b f34080a;

        public d(b bVar) {
            this.f34080a = bVar;
        }

        @Override // com.kwad.sdk.utils.AppStatusHelper.b
        public void a(List<AppRunningInfo> list) {
            JSONArray a2 = a.a(list);
            if (a2 != null) {
                com.kwad.sdk.core.report.e.a(a2);
            }
            b bVar = this.f34080a;
            if (bVar != null) {
                bVar.a(list);
            }
        }
    }

    public static AppStatusRules a() {
        return f34068e;
    }

    @WorkerThread
    public static void a(Context context) {
        if (f34068e == null) {
            f34068e = g(context);
        }
    }

    public static void a(Context context, long j) {
        if (context == null) {
            return;
        }
        f34069f = new WeakReference<>(context);
        if (j <= 0) {
            j = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        }
        if (f34064a == null) {
            f34064a = new Handler(Looper.getMainLooper());
        }
        f34064a.postDelayed(new AnonymousClass2(context), j);
    }

    public static void a(Context context, b bVar) {
        if (context == null) {
            return;
        }
        b(context, bVar);
    }

    @Nullable
    public static List<String> b(@NonNull Context context) {
        String[] list;
        if (k(context)) {
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

    public static void b(final Context context, final long j) {
        if (f34064a == null) {
            f34064a = new Handler(Looper.getMainLooper());
        }
        f34064a.post(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.4
            @Override // java.lang.Runnable
            public void run() {
                AppStatusHelper.h(context);
                AppStatusHelper.f34064a.postDelayed(this, j);
            }
        });
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES");
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(appStatusRules);
            objectOutputStream.flush();
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.a(e3);
        }
    }

    public static void b(final Context context, final b bVar) {
        k();
        f34067d.submit(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.5
            @Override // java.lang.Runnable
            public void run() {
                List j;
                List i2;
                HashSet hashSet = new HashSet();
                if (Build.VERSION.SDK_INT < 21 && (i2 = AppStatusHelper.i(context)) != null) {
                    hashSet.addAll(i2);
                }
                if (!AppStatusHelper.k(context) || (j = AppStatusHelper.j(context)) == null) {
                    return;
                }
                Iterator it = j.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "AppRunningInfo: " + ((AppRunningInfo) it.next()));
                }
                hashSet.addAll(j);
                if (bVar != null) {
                    bVar.a(new ArrayList(hashSet));
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0052 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #6 {Exception -> 0x0055, blocks: (B:28:0x004d, B:30:0x0052), top: B:42:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AppStatusRules g(Context context) {
        ObjectInputStream objectInputStream;
        Throwable th;
        FileInputStream fileInputStream;
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES");
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
            objectInputStream = null;
        } catch (Throwable th2) {
            objectInputStream = null;
            th = th2;
            fileInputStream = null;
        }
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                try {
                    AppStatusRules appStatusRules = (AppStatusRules) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        fileInputStream.close();
                    } catch (Exception unused) {
                    }
                    return appStatusRules;
                } catch (Exception e3) {
                    e = e3;
                    com.kwad.sdk.core.d.a.a(e);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception unused2) {
                            return null;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            objectInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            if (objectInputStream != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static void h(Context context) {
        if (context == null) {
            return;
        }
        boolean l = l();
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "isServiceAvailable: " + l);
        if (l) {
            com.kwad.sdk.collector.c.a.a(context, f34066c);
        } else {
            a(context, new d(null));
        }
    }

    public static List<AppRunningInfo> i(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100);
        if (runningTasks != null) {
            LinkedList linkedList = new LinkedList();
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                ComponentName componentName = runningTaskInfo.topActivity;
                if (componentName != null) {
                    String packageName = componentName.getPackageName();
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "packageName:" + packageName);
                    AppRunningInfo appRunningInfo = new AppRunningInfo(-1L);
                    appRunningInfo.setPackageName(packageName);
                    linkedList.add(appRunningInfo);
                }
            }
            return linkedList;
        }
        return null;
    }

    @WorkerThread
    public static List<AppRunningInfo> j(Context context) {
        if (k(context)) {
            com.kwad.sdk.collector.d dVar = new com.kwad.sdk.collector.d();
            if (f34068e == null) {
                f34068e = g(context);
            }
            return dVar.a(context);
        }
        return new ArrayList();
    }

    public static boolean j() {
        if (f34065b == null) {
            try {
                f34065b = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return f34065b != null;
    }

    public static synchronized void k() {
        synchronized (AppStatusHelper.class) {
            if (f34067d != null) {
                return;
            }
            f34067d = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.utils.AppStatusHelper.3
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setPriority(3);
                    return thread;
                }
            });
        }
    }

    public static boolean k(@NonNull Context context) {
        return context.checkCallingOrSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0;
    }

    public static boolean l() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = KsAdSDK.getContext();
                return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
            }
        } catch (ClassNotFoundException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return false;
    }
}
