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
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.FNode;
import com.kwad.sdk.collector.NodeFilter;
import com.kwad.sdk.collector.a;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes3.dex */
public class AppStatusHelper {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f10753a;

    /* renamed from: b  reason: collision with root package name */
    private static c f10754b = new c();
    private static Messenger c = new Messenger(f10754b);
    private static ServiceConnection d = new ServiceConnection() { // from class: com.kwad.sdk.utils.AppStatusHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Messenger messenger = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.replyTo = AppStatusHelper.c;
            try {
                messenger.send(obtain);
            } catch (RemoteException e2) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private static volatile ExecutorService e = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.utils.AppStatusHelper.2
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(3);
            return thread;
        }
    });
    private static volatile AppStatusRules f;
    private static WeakReference<Context> g;

    /* loaded from: classes3.dex */
    public static class ASService extends Service {

        /* renamed from: a  reason: collision with root package name */
        private a f10763a = new a();

        /* renamed from: b  reason: collision with root package name */
        private Messenger f10764b = new Messenger(this.f10763a);
        private ASService c;

        /* loaded from: classes3.dex */
        private static class a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference<ASService> f10765a;

            private a() {
            }

            @Nullable
            static String a() {
                if (Build.VERSION.SDK_INT >= 28) {
                    return Application.getProcessName();
                }
                try {
                    Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return (String) declaredMethod.invoke(null, new Object[0]);
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.a(e);
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(Context context) {
                String a2 = a();
                return (a2 == null || context.getPackageName().equals(a2)) ? false : true;
            }

            public void a(@Nullable ASService aSService) {
                if (aSService != null) {
                    this.f10765a = new WeakReference<>(aSService);
                } else {
                    this.f10765a = null;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                final ASService aSService = this.f10765a != null ? this.f10765a.get() : null;
                if (aSService == null) {
                    return;
                }
                final Messenger messenger = message.replyTo;
                switch (message.what) {
                    case 100:
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
                                } catch (RemoteException e) {
                                }
                                aSService.stopSelf();
                                if (a.this.a((Context) aSService)) {
                                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "gotta kill myself");
                                    Process.killProcess(Process.myPid());
                                }
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        }

        public static boolean a(@NonNull Context context) {
            return context.getPackageManager().queryIntentServices(new Intent(context, ASService.class), 65536).size() > 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(@NonNull Context context, ServiceConnection serviceConnection) {
            context.bindService(new Intent(context, ASService.class), serviceConnection, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(@NonNull Context context, ServiceConnection serviceConnection) {
            context.unbindService(serviceConnection);
        }

        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            com.kwad.sdk.core.d.a.a("AppStatusHelper", "onBind");
            return this.f10764b.getBinder();
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            this.c = this;
            this.f10763a.a(this.c);
        }

        @Override // android.app.Service
        public void onDestroy() {
            super.onDestroy();
            this.c = null;
            this.f10763a.a((ASService) null);
        }
    }

    /* loaded from: classes3.dex */
    public static class AppRunningInfo implements Serializable, Comparable<AppRunningInfo> {
        private static final long serialVersionUID = 7014997764778342190L;
        private long lastRunningTime = -1;
        private String name;
        private String packageName;
        public static long granularity = AppStatusRules.DEFAULT_GRANULARITY;
        private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

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
            if (appRunningInfo == null || appRunningInfo2 == null) {
                return false;
            }
            return appRunningInfo.getPackageName().equals(appRunningInfo2.getPackageName()) && appRunningInfo.getLastRunningTime() == appRunningInfo2.getLastRunningTime();
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
            return lastRunningTime <= 0 ? -1 : 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
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
            return ((int) (j ^ (j >>> 32))) + (((this.name.hashCode() * 31) + this.packageName.hashCode()) * 31);
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
            o.a(jSONObject, "packageName", this.packageName);
            o.a(jSONObject, "lastRunningTime", this.lastRunningTime);
            return jSONObject;
        }

        public String toString() {
            return "AppRunningInfo{packageName='" + this.packageName + "', lastRunningTime=" + formatTime(this.lastRunningTime) + '}';
        }
    }

    /* loaded from: classes3.dex */
    public static class PackageNameFilter implements NodeFilter {
        private HashMap<String, InstalledAppInfoManager.AppPackageInfo> installedApp;
        private HashSet<String> packageSet;

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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f10768a;

        /* renamed from: b  reason: collision with root package name */
        private String f10769b;
        private List<Long> c = new ArrayList();

        public a(String str, String str2) {
            this.f10768a = str;
            this.f10769b = str2;
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
                    aVar = new a(appRunningInfo.getName(), appRunningInfo.getPackageName());
                    hashMap.put(packageName, aVar);
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
            o.a(jSONObject, "appName", this.f10768a);
            o.a(jSONObject, "packageName", this.f10769b);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.c) {
                jSONArray.put(l.longValue());
            }
            o.a(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public void a(long j) {
            this.c.add(Long.valueOf(j));
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(List<AppRunningInfo> list);
    }

    /* loaded from: classes3.dex */
    private static class c extends Handler {
        private c() {
        }

        private static void a(ArrayList<AppRunningInfo> arrayList) {
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
            switch (message.what) {
                case 101:
                    Bundle data = message.getData();
                    if (data != null) {
                        try {
                            arrayList = (ArrayList) data.getSerializable("data");
                        } catch (Exception e) {
                            arrayList = null;
                        }
                        if (arrayList != null) {
                            com.kwad.sdk.core.d.a.a("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                            a(arrayList);
                        }
                    }
                    if (AppStatusHelper.g == null || AppStatusHelper.g.get() == null) {
                        return;
                    }
                    ASService.d((Context) AppStatusHelper.g.get(), AppStatusHelper.d);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        private b f10770a;

        public d(b bVar) {
            this.f10770a = bVar;
        }

        @Override // com.kwad.sdk.utils.AppStatusHelper.b
        public void a(List<AppRunningInfo> list) {
            JSONArray a2 = a.a(list);
            if (a2 != null) {
                com.kwad.sdk.core.report.e.a(a2);
            }
            if (this.f10770a != null) {
                this.f10770a.a(list);
            }
        }
    }

    @WorkerThread
    public static void a(Context context) {
        if (f == null) {
            f = g(context);
        }
        if (f.targetNotEmpty()) {
            com.kwad.sdk.collector.b.c();
            com.kwad.sdk.collector.b.a(f);
        }
        com.kwad.sdk.collector.b.a(f.obtainStartTime());
        com.kwad.sdk.collector.b.b(f.obtainHistoryGranularity());
    }

    public static void a(final Context context, long j) {
        if (context == null) {
            return;
        }
        g = new WeakReference<>(context);
        if (j <= 0) {
            j = 30000;
        }
        if (f10753a == null) {
            f10753a = new Handler(Looper.getMainLooper());
        }
        f10753a.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.3
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.collector.a.a(context, new a.InterfaceC1074a() { // from class: com.kwad.sdk.utils.AppStatusHelper.3.1
                    @Override // com.kwad.sdk.collector.a.InterfaceC1074a
                    public void a(int i, String str) {
                        com.kwad.sdk.core.d.a.d("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                    }

                    @Override // com.kwad.sdk.collector.a.InterfaceC1074a
                    public void a(AppStatusRules appStatusRules) {
                        AppStatusRules unused = AppStatusHelper.f = appStatusRules;
                        AppStatusHelper.b(context, AppStatusHelper.f);
                        AppStatusHelper.a(context);
                        long obtainScanInterval = AppStatusHelper.f.obtainScanInterval();
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
        if (f10753a == null) {
            f10753a = new Handler(Looper.getMainLooper());
        }
        f10753a.post(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.4
            @Override // java.lang.Runnable
            public void run() {
                AppStatusHelper.h(context);
                AppStatusHelper.f10753a.postDelayed(this, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    private static void b(final Context context, final b bVar) {
        e.submit(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.5
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
                        if (bVar != null) {
                            bVar.a(j);
                        }
                    }
                }
            }
        });
    }

    private static void c(final Context context, final b bVar) {
        e.submit(new Runnable() { // from class: com.kwad.sdk.utils.AppStatusHelper.6
            @Override // java.lang.Runnable
            public void run() {
                List<AppRunningInfo> i = AppStatusHelper.i(context);
                if (bVar != null) {
                    bVar.a(i);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004e A[Catch: Exception -> 0x0052, TRY_LEAVE, TryCatch #7 {Exception -> 0x0052, blocks: (B:27:0x0049, B:29:0x004e), top: B:50:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static AppStatusRules g(Context context) {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES");
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    try {
                        AppStatusRules appStatusRules = (AppStatusRules) objectInputStream.readObject();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e2) {
                                return appStatusRules;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return appStatusRules;
                        }
                        return appStatusRules;
                    } catch (Exception e3) {
                        e = e3;
                        com.kwad.sdk.core.d.a.a(e);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e4) {
                                return null;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e5) {
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                objectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                if (objectInputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            objectInputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            fileInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Context context) {
        if (context == null) {
            return;
        }
        boolean a2 = ASService.a(context);
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "isServiceAvailable: " + a2);
        if (a2) {
            ASService.c(context, d);
        } else {
            a(context, new d(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AppRunningInfo> i(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(100);
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(@NonNull Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
