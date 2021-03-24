package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
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
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.FNode;
import com.kwad.sdk.collector.NodeFilter;
import com.kwad.sdk.collector.a;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AppStatusHelper {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f36671a;

    /* renamed from: b  reason: collision with root package name */
    public static c f36672b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static Messenger f36673c = new Messenger(f36672b);

    /* renamed from: d  reason: collision with root package name */
    public static ServiceConnection f36674d = new ServiceConnection() { // from class: com.kwad.sdk.utils.AppStatusHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Messenger messenger = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.replyTo = AppStatusHelper.f36673c;
            try {
                messenger.send(obtain);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static volatile ExecutorService f36675e = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.utils.AppStatusHelper.2
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(3);
            return thread;
        }
    });

    /* renamed from: f  reason: collision with root package name */
    public static volatile AppStatusRules f36676f;

    /* renamed from: g  reason: collision with root package name */
    public static WeakReference<Context> f36677g;

    /* loaded from: classes6.dex */
    public static class ASService extends Service {

        /* renamed from: a  reason: collision with root package name */
        public a f36686a = new a();

        /* renamed from: b  reason: collision with root package name */
        public Messenger f36687b = new Messenger(this.f36686a);

        /* renamed from: c  reason: collision with root package name */
        public ASService f36688c;

        /* loaded from: classes6.dex */
        public static class a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<ASService> f36689a;

            public a() {
            }

            @Nullable
            public static String a() {
                if (Build.VERSION.SDK_INT >= 28) {
                    return Application.getProcessName();
                }
                try {
                    Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return (String) declaredMethod.invoke(null, new Object[0]);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(Context context) {
                String a2 = a();
                if (a2 == null) {
                    return false;
                }
                return !context.getPackageName().equals(a2);
            }

            public void a(@Nullable ASService aSService) {
                if (aSService != null) {
                    this.f36689a = new WeakReference<>(aSService);
                } else {
                    this.f36689a = null;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                WeakReference<ASService> weakReference = this.f36689a;
                final ASService aSService = weakReference != null ? weakReference.get() : null;
                if (aSService == null) {
                    return;
                }
                final Messenger messenger = message.replyTo;
                if (message.what != 100) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("AppStatusHelper", "ASService: WHAT_START_WORK");
                AppStatusHelper.a(aSService, new b() { // from class: com.kwad.sdk.utils.AppStatusHelper.ASService.a.1
                    @Override // com.kwad.sdk.utils.AppStatusHelper.b
                    public void a(List<AppRunningInfo> list) {
                        com.kwad.sdk.core.d.a.a("AppStatusHelper", "ASService: onAppStatusResult: " + list.size());
                        ArrayList arrayList = new ArrayList(list);
                        Message obtain = Message.obtain();
                        obtain.what = 101;
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("data", arrayList);
                        obtain.setData(bundle);
                        try {
                            messenger.send(obtain);
                        } catch (RemoteException unused) {
                        }
                        aSService.stopSelf();
                        if (a.this.a((Context) aSService)) {
                            com.kwad.sdk.core.d.a.a("AppStatusHelper", "gotta kill myself");
                            Process.killProcess(Process.myPid());
                        }
                    }
                });
            }
        }

        public static boolean a(@NonNull Context context) {
            return context.getPackageManager().queryIntentServices(new Intent(context, ASService.class), 65536).size() > 0;
        }

        public static void c(@NonNull Context context, ServiceConnection serviceConnection) {
            context.bindService(new Intent(context, ASService.class), serviceConnection, 1);
        }

        public static void d(@NonNull Context context, ServiceConnection serviceConnection) {
            context.unbindService(serviceConnection);
        }

        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            com.kwad.sdk.core.d.a.a("AppStatusHelper", "onBind");
            return this.f36687b.getBinder();
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            this.f36688c = this;
            this.f36686a.a(this);
        }

        @Override // android.app.Service
        public void onDestroy() {
            super.onDestroy();
            this.f36688c = null;
            this.f36686a.a((ASService) null);
        }
    }

    /* loaded from: classes6.dex */
    public static class AppRunningInfo implements Serializable, Comparable<AppRunningInfo> {
        public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        public static long granularity = 60000;
        public static final long serialVersionUID = 7014997764778342190L;
        public long lastRunningTime = -1;
        public String name;
        public String packageName;

        public static AppRunningInfo createInstance(InstalledAppInfoManager.AppPackageInfo appPackageInfo) {
            AppRunningInfo appRunningInfo = new AppRunningInfo();
            appRunningInfo.setPackageName(appPackageInfo.packageName);
            appRunningInfo.setName(appPackageInfo.appName);
            return appRunningInfo;
        }

        public static AppRunningInfo createInstance(String str) {
            AppRunningInfo appRunningInfo = new AppRunningInfo();
            appRunningInfo.setPackageName(str);
            return appRunningInfo;
        }

        public static boolean samePackageTimeTo(AppRunningInfo appRunningInfo, AppRunningInfo appRunningInfo2) {
            if (appRunningInfo == appRunningInfo2) {
                return true;
            }
            return appRunningInfo != null && appRunningInfo2 != null && appRunningInfo.getPackageName().equals(appRunningInfo2.getPackageName()) && appRunningInfo.getLastRunningTime() == appRunningInfo2.getLastRunningTime();
        }

        public AppRunningInfo cloneNewOne() {
            AppRunningInfo appRunningInfo = new AppRunningInfo();
            appRunningInfo.setName(this.name);
            appRunningInfo.setLastRunningTime(this.lastRunningTime);
            appRunningInfo.setPackageName(this.packageName);
            return appRunningInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(AppRunningInfo appRunningInfo) {
            if (appRunningInfo == null) {
                return 1;
            }
            long lastRunningTime = this.lastRunningTime - appRunningInfo.getLastRunningTime();
            if (lastRunningTime == 0) {
                return 0;
            }
            return lastRunningTime > 0 ? 1 : -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AppRunningInfo.class != obj.getClass()) {
                return false;
            }
            AppRunningInfo appRunningInfo = (AppRunningInfo) obj;
            long j = granularity;
            if (this.lastRunningTime / j == appRunningInfo.getLastRunningTime() / j && this.name.equals(appRunningInfo.name)) {
                return this.packageName.equals(appRunningInfo.packageName);
            }
            return false;
        }

        public String formatTime(long j) {
            return format.format(new Date(j));
        }

        public String getFormattedLastRunningTime() {
            return formatTime(getLastRunningTime());
        }

        public long getLastRunningTime() {
            return this.lastRunningTime;
        }

        public String getName() {
            return this.name;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public int hashCode() {
            long j = this.lastRunningTime / granularity;
            return (((this.name.hashCode() * 31) + this.packageName.hashCode()) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public void setLastRunningTime(long j) {
            this.lastRunningTime = j;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "name", this.name);
            o.a(jSONObject, InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, this.packageName);
            o.a(jSONObject, "lastRunningTime", this.lastRunningTime);
            return jSONObject;
        }

        public String toString() {
            return "AppRunningInfo{packageName='" + this.packageName + "', lastRunningTime=" + formatTime(this.lastRunningTime) + '}';
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

        public Map<String, AppRunningInfo> createByPackages(Set<String> set) {
            HashMap hashMap = new HashMap();
            if (set == null) {
                return hashMap;
            }
            for (String str : set) {
                InstalledAppInfoManager.AppPackageInfo appPackageInfo = this.installedApp.get(str);
                if (appPackageInfo != null) {
                    hashMap.put(str, AppRunningInfo.createInstance(appPackageInfo));
                }
            }
            return hashMap;
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public void onChildNodeCreate(FNode fNode) {
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = this.installedApp.get(fNode.getRealFile().getName());
            if (appPackageInfo != null) {
                fNode.setAppRunningInfo(AppRunningInfo.createInstance(appPackageInfo));
            }
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public boolean onFilterChild(File file) {
            return this.packageSet.contains(file.getName());
        }
    }

    /* loaded from: classes6.dex */
    public static class SDCardRootNodeFilter implements NodeFilter {
        @Override // com.kwad.sdk.collector.NodeFilter
        public void onChildNodeCreate(FNode fNode) {
            fNode.setAppRunningInfo(AppRunningInfo.createInstance(com.kwad.sdk.collector.b.a(fNode.getRealFile().getName())));
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public boolean onFilterChild(File file) {
            return com.kwad.sdk.collector.b.a(file.getName()) != null;
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f36693a;

        /* renamed from: b  reason: collision with root package name */
        public String f36694b;

        /* renamed from: c  reason: collision with root package name */
        public List<Long> f36695c = new ArrayList();

        public a(String str, String str2) {
            this.f36693a = str;
            this.f36694b = str2;
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
            o.a(jSONObject, "appName", this.f36693a);
            o.a(jSONObject, InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, this.f36694b);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.f36695c) {
                jSONArray.put(l.longValue());
            }
            o.a(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public void a(long j) {
            this.f36695c.add(Long.valueOf(j));
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(List<AppRunningInfo> list);
    }

    /* loaded from: classes6.dex */
    public static class c extends Handler {
        public c() {
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
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            Bundle data = message.getData();
            if (data != null) {
                ArrayList arrayList = null;
                try {
                    arrayList = (ArrayList) data.getSerializable("data");
                } catch (Exception unused) {
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    a(arrayList);
                }
            }
            if (AppStatusHelper.f36677g == null || AppStatusHelper.f36677g.get() == null) {
                return;
            }
            ASService.d((Context) AppStatusHelper.f36677g.get(), AppStatusHelper.f36674d);
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        public b f36696a;

        public d(b bVar) {
            this.f36696a = bVar;
        }

        @Override // com.kwad.sdk.utils.AppStatusHelper.b
        public void a(List<AppRunningInfo> list) {
            JSONArray a2 = a.a(list);
            if (a2 != null) {
                com.kwad.sdk.core.report.e.a(a2);
            }
            b bVar = this.f36696a;
            if (bVar != null) {
                bVar.a(list);
            }
        }
    }

    @WorkerThread
    public static void a(Context context) {
        if (f36676f == null) {
            f36676f = g(context);
        }
        if (f36676f.targetNotEmpty()) {
            com.kwad.sdk.collector.b.c();
            com.kwad.sdk.collector.b.a(f36676f);
        }
        com.kwad.sdk.collector.b.a(f36676f.obtainStartTime());
        com.kwad.sdk.collector.b.b(f36676f.obtainHistoryGranularity());
    }

    public static void a(final Context context, long j) {
        if (context == null) {
            return;
        }
        f36677g = new WeakReference<>(context);
        if (j <= 0) {
            j = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        }
        if (f36671a == null) {
            f36671a = new Handler(Looper.getMainLooper());
        }
        f36671a.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.3
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.collector.a.a(context, new a.InterfaceC0358a() { // from class: com.kwad.sdk.utils.AppStatusHelper.3.1
                    @Override // com.kwad.sdk.collector.a.InterfaceC0358a
                    public void a(int i, String str) {
                        com.kwad.sdk.core.d.a.d("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                    }

                    @Override // com.kwad.sdk.collector.a.InterfaceC0358a
                    public void a(AppStatusRules appStatusRules) {
                        AppStatusRules unused = AppStatusHelper.f36676f = appStatusRules;
                        AppStatusHelper.b(context, AppStatusHelper.f36676f);
                        AppStatusHelper.a(context);
                        long obtainScanInterval = AppStatusHelper.f36676f.obtainScanInterval();
                        if (obtainScanInterval > 0) {
                            AppStatusHelper.b(context, obtainScanInterval);
                        } else {
                            AppStatusHelper.h(context);
                        }
                    }
                });
            }
        }, j);
    }

    public static void a(Context context, b bVar) {
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            b(context, bVar);
        } else {
            c(context, bVar);
        }
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
        if (f36671a == null) {
            f36671a = new Handler(Looper.getMainLooper());
        }
        f36671a.post(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.4
            @Override // java.lang.Runnable
            public void run() {
                AppStatusHelper.h(context);
                AppStatusHelper.f36671a.postDelayed(this, j);
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
        f36675e.submit(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (AppStatusHelper.k(context)) {
                    com.kwad.sdk.collector.b.b();
                    List<AppRunningInfo> j = AppStatusHelper.j(context);
                    if (j != null) {
                        Iterator<AppRunningInfo> it = j.iterator();
                        while (it.hasNext()) {
                            com.kwad.sdk.core.d.a.a("AppStatusHelper", "AppRunningInfo: " + it.next());
                        }
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(j);
                        }
                    }
                }
            }
        });
    }

    public static void c(final Context context, final b bVar) {
        f36675e.submit(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.6
            @Override // java.lang.Runnable
            public void run() {
                List<AppRunningInfo> i = AppStatusHelper.i(context);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(i);
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
        boolean a2 = ASService.a(context);
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "isServiceAvailable: " + a2);
        if (a2) {
            ASService.c(context, f36674d);
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
                    AppRunningInfo appRunningInfo = new AppRunningInfo();
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
            PackageNameFilter packageNameFilter = new PackageNameFilter(context);
            com.kwad.sdk.collector.b bVar = new com.kwad.sdk.collector.b();
            if (com.kwad.sdk.collector.b.d()) {
                a(context);
            }
            List<AppRunningInfo> a2 = bVar.a(packageNameFilter);
            AppRunningInfo.granularity = com.kwad.sdk.collector.b.a();
            return bVar.a(a2);
        }
        return new ArrayList();
    }

    public static boolean k(@NonNull Context context) {
        return context.checkCallingOrSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0;
    }
}
