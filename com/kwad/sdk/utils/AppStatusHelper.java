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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class AppStatusHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f39288a;

    /* renamed from: b  reason: collision with root package name */
    public static c f39289b;

    /* renamed from: c  reason: collision with root package name */
    public static Messenger f39290c;

    /* renamed from: d  reason: collision with root package name */
    public static ServiceConnection f39291d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ExecutorService f39292e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile AppStatusRules f39293f;

    /* renamed from: g  reason: collision with root package name */
    public static WeakReference<Context> f39294g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class ASService extends Service {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f39303a;

        /* renamed from: b  reason: collision with root package name */
        public Messenger f39304b;

        /* renamed from: c  reason: collision with root package name */
        public ASService f39305c;

        /* loaded from: classes7.dex */
        public static class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<ASService> f39306a;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Nullable
            public static String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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
                return (String) invokeV.objValue;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
                    String a2 = a();
                    if (a2 == null) {
                        return false;
                    }
                    return !context.getPackageName().equals(a2);
                }
                return invokeL.booleanValue;
            }

            public void a(@Nullable ASService aSService) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aSService) == null) {
                    if (aSService != null) {
                        this.f39306a = new WeakReference<>(aSService);
                    } else {
                        this.f39306a = null;
                    }
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                    super.handleMessage(message);
                    WeakReference<ASService> weakReference = this.f39306a;
                    ASService aSService = weakReference != null ? weakReference.get() : null;
                    if (aSService == null) {
                        return;
                    }
                    Messenger messenger = message.replyTo;
                    if (message.what != 100) {
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "ASService: WHAT_START_WORK");
                    AppStatusHelper.a(aSService, new b(this, messenger, aSService) { // from class: com.kwad.sdk.utils.AppStatusHelper.ASService.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Messenger f39307a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ ASService f39308b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ a f39309c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, messenger, aSService};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f39309c = this;
                            this.f39307a = messenger;
                            this.f39308b = aSService;
                        }

                        @Override // com.kwad.sdk.utils.AppStatusHelper.b
                        public void a(List<AppRunningInfo> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                                com.kwad.sdk.core.d.a.a("AppStatusHelper", "ASService: onAppStatusResult: " + list.size());
                                ArrayList arrayList = new ArrayList(list);
                                Message obtain = Message.obtain();
                                obtain.what = 101;
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("data", arrayList);
                                obtain.setData(bundle);
                                try {
                                    this.f39307a.send(obtain);
                                } catch (RemoteException unused) {
                                }
                                this.f39308b.stopSelf();
                                if (this.f39309c.a((Context) this.f39308b)) {
                                    com.kwad.sdk.core.d.a.a("AppStatusHelper", "gotta kill myself");
                                    Process.killProcess(Process.myPid());
                                }
                            }
                        }
                    });
                }
            }
        }

        public ASService() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39303a = new a();
            this.f39304b = new Messenger(this.f39303a);
        }

        public static boolean a(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? context.getPackageManager().queryIntentServices(new Intent(context, ASService.class), 65536).size() > 0 : invokeL.booleanValue;
        }

        public static void c(@NonNull Context context, ServiceConnection serviceConnection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65540, null, context, serviceConnection) == null) {
                context.bindService(new Intent(context, ASService.class), serviceConnection, 1);
            }
        }

        public static void d(@NonNull Context context, ServiceConnection serviceConnection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, serviceConnection) == null) {
                context.unbindService(serviceConnection);
            }
        }

        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
                com.kwad.sdk.core.d.a.a("AppStatusHelper", "onBind");
                return this.f39304b.getBinder();
            }
            return (IBinder) invokeL.objValue;
        }

        @Override // android.app.Service
        public void onCreate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onCreate();
                this.f39305c = this;
                this.f39303a.a(this);
            }
        }

        @Override // android.app.Service
        public void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.onDestroy();
                this.f39305c = null;
                this.f39303a.a((ASService) null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class AppRunningInfo implements Serializable, Comparable<AppRunningInfo> {
        public static /* synthetic */ Interceptable $ic = null;
        public static SimpleDateFormat format = null;
        public static long granularity = 60000;
        public static final long serialVersionUID = 7014997764778342190L;
        public transient /* synthetic */ FieldHolder $fh;
        public long lastRunningTime;
        public String name;
        public String packageName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1596119981, "Lcom/kwad/sdk/utils/AppStatusHelper$AppRunningInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1596119981, "Lcom/kwad/sdk/utils/AppStatusHelper$AppRunningInfo;");
                    return;
                }
            }
            format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        }

        public AppRunningInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.lastRunningTime = -1L;
        }

        public static AppRunningInfo createInstance(InstalledAppInfoManager.AppPackageInfo appPackageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, appPackageInfo)) == null) {
                AppRunningInfo appRunningInfo = new AppRunningInfo();
                appRunningInfo.setPackageName(appPackageInfo.packageName);
                appRunningInfo.setName(appPackageInfo.appName);
                return appRunningInfo;
            }
            return (AppRunningInfo) invokeL.objValue;
        }

        public static AppRunningInfo createInstance(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                AppRunningInfo appRunningInfo = new AppRunningInfo();
                appRunningInfo.setPackageName(str);
                return appRunningInfo;
            }
            return (AppRunningInfo) invokeL.objValue;
        }

        public static boolean samePackageTimeTo(AppRunningInfo appRunningInfo, AppRunningInfo appRunningInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, appRunningInfo, appRunningInfo2)) == null) {
                if (appRunningInfo == appRunningInfo2) {
                    return true;
                }
                return appRunningInfo != null && appRunningInfo2 != null && appRunningInfo.getPackageName().equals(appRunningInfo2.getPackageName()) && appRunningInfo.getLastRunningTime() == appRunningInfo2.getLastRunningTime();
            }
            return invokeLL.booleanValue;
        }

        public AppRunningInfo cloneNewOne() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                AppRunningInfo appRunningInfo = new AppRunningInfo();
                appRunningInfo.setName(this.name);
                appRunningInfo.setLastRunningTime(this.lastRunningTime);
                appRunningInfo.setPackageName(this.packageName);
                return appRunningInfo;
            }
            return (AppRunningInfo) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(AppRunningInfo appRunningInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appRunningInfo)) == null) {
                if (appRunningInfo == null) {
                    return 1;
                }
                int i2 = ((this.lastRunningTime - appRunningInfo.getLastRunningTime()) > 0L ? 1 : ((this.lastRunningTime - appRunningInfo.getLastRunningTime()) == 0L ? 0 : -1));
                if (i2 == 0) {
                    return 0;
                }
                return i2 > 0 ? 1 : -1;
            }
            return invokeL.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
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
            return invokeL.booleanValue;
        }

        public String formatTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) ? format.format(new Date(j)) : (String) invokeJ.objValue;
        }

        public String getFormattedLastRunningTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? formatTime(getLastRunningTime()) : (String) invokeV.objValue;
        }

        public long getLastRunningTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.lastRunningTime : invokeV.longValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.packageName : (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                long j = this.lastRunningTime / granularity;
                return (((this.name.hashCode() * 31) + this.packageName.hashCode()) * 31) + ((int) (j ^ (j >>> 32)));
            }
            return invokeV.intValue;
        }

        public void setLastRunningTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
                this.lastRunningTime = j;
            }
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.name = str;
            }
        }

        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.packageName = str;
            }
        }

        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "name", this.name);
                o.a(jSONObject, "packageName", this.packageName);
                o.a(jSONObject, "lastRunningTime", this.lastRunningTime);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return "AppRunningInfo{packageName='" + this.packageName + "', lastRunningTime=" + formatTime(this.lastRunningTime) + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class PackageNameFilter implements NodeFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, InstalledAppInfoManager.AppPackageInfo> installedApp;
        public HashSet<String> packageSet;

        public PackageNameFilter(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, set)) == null) {
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
            return (Map) invokeL.objValue;
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public void onChildNodeCreate(FNode fNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fNode) == null) {
                InstalledAppInfoManager.AppPackageInfo appPackageInfo = this.installedApp.get(fNode.getRealFile().getName());
                if (appPackageInfo != null) {
                    fNode.setAppRunningInfo(AppRunningInfo.createInstance(appPackageInfo));
                }
            }
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public boolean onFilterChild(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) ? this.packageSet.contains(file.getName()) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class SDCardRootNodeFilter implements NodeFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SDCardRootNodeFilter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public void onChildNodeCreate(FNode fNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fNode) == null) {
                fNode.setAppRunningInfo(AppRunningInfo.createInstance(com.kwad.sdk.collector.b.a(fNode.getRealFile().getName())));
            }
        }

        @Override // com.kwad.sdk.collector.NodeFilter
        public boolean onFilterChild(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? com.kwad.sdk.collector.b.a(file.getName()) != null : invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f39310a;

        /* renamed from: b  reason: collision with root package name */
        public String f39311b;

        /* renamed from: c  reason: collision with root package name */
        public List<Long> f39312c;

        public a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39312c = new ArrayList();
            this.f39310a = str;
            this.f39311b = str2;
        }

        @Nullable
        public static JSONArray a(List<AppRunningInfo> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
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
            return (JSONArray) invokeL.objValue;
        }

        @Nullable
        public static List<a> b(List<AppRunningInfo> list) {
            InterceptResult invokeL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
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
            return (List) invokeL.objValue;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "appName", this.f39310a);
                o.a(jSONObject, "packageName", this.f39311b);
                JSONArray jSONArray = new JSONArray();
                for (Long l : this.f39312c) {
                    jSONArray.put(l.longValue());
                }
                o.a(jSONObject, "runningTimes", jSONArray);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f39312c.add(Long.valueOf(j));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(List<AppRunningInfo> list);
    }

    /* loaded from: classes7.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void a(ArrayList<AppRunningInfo> arrayList) {
            JSONArray a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, null, arrayList) == null) || arrayList == null || (a2 = a.a(arrayList)) == null) {
                return;
            }
            com.kwad.sdk.core.report.e.a(a2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
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
                if (AppStatusHelper.f39294g == null || AppStatusHelper.f39294g.get() == null) {
                    return;
                }
                ASService.d((Context) AppStatusHelper.f39294g.get(), AppStatusHelper.f39291d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f39313a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39313a = bVar;
        }

        @Override // com.kwad.sdk.utils.AppStatusHelper.b
        public void a(List<AppRunningInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                JSONArray a2 = a.a(list);
                if (a2 != null) {
                    com.kwad.sdk.core.report.e.a(a2);
                }
                b bVar = this.f39313a;
                if (bVar != null) {
                    bVar.a(list);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2109831091, "Lcom/kwad/sdk/utils/AppStatusHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2109831091, "Lcom/kwad/sdk/utils/AppStatusHelper;");
                return;
            }
        }
        f39289b = new c();
        f39290c = new Messenger(f39289b);
        f39291d = new ServiceConnection() { // from class: com.kwad.sdk.utils.AppStatusHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    Messenger messenger = new Messenger(iBinder);
                    Message obtain = Message.obtain();
                    obtain.what = 100;
                    obtain.replyTo = AppStatusHelper.f39290c;
                    try {
                        messenger.send(obtain);
                    } catch (RemoteException unused) {
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                }
            }
        };
        f39292e = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.utils.AppStatusHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    Thread thread = new Thread(runnable);
                    thread.setPriority(3);
                    return thread;
                }
                return (Thread) invokeL.objValue;
            }
        });
    }

    @WorkerThread
    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            if (f39293f == null) {
                f39293f = g(context);
            }
            if (f39293f.targetNotEmpty()) {
                com.kwad.sdk.collector.b.c();
                com.kwad.sdk.collector.b.a(f39293f);
            }
            com.kwad.sdk.collector.b.a(f39293f.obtainStartTime());
            com.kwad.sdk.collector.b.b(f39293f.obtainHistoryGranularity());
        }
    }

    public static void a(Context context, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65540, null, context, j) == null) || context == null) {
            return;
        }
        f39294g = new WeakReference<>(context);
        if (j <= 0) {
            j = 30000;
        }
        if (f39288a == null) {
            f39288a = new Handler(Looper.getMainLooper());
        }
        f39288a.postDelayed(new Runnable(context) { // from class: com.kwad.sdk.utils.AppStatusHelper.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f39295a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f39295a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.collector.a.a(this.f39295a, new a.InterfaceC0406a(this) { // from class: com.kwad.sdk.utils.AppStatusHelper.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass3 f39296a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f39296a = this;
                        }

                        @Override // com.kwad.sdk.collector.a.InterfaceC0406a
                        public void a(int i2, String str) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                com.kwad.sdk.core.d.a.d("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i2);
                            }
                        }

                        @Override // com.kwad.sdk.collector.a.InterfaceC0406a
                        public void a(AppStatusRules appStatusRules) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appStatusRules) == null) {
                                AppStatusRules unused = AppStatusHelper.f39293f = appStatusRules;
                                AppStatusHelper.b(this.f39296a.f39295a, AppStatusHelper.f39293f);
                                AppStatusHelper.a(this.f39296a.f39295a);
                                long obtainScanInterval = AppStatusHelper.f39293f.obtainScanInterval();
                                if (obtainScanInterval > 0) {
                                    AppStatusHelper.b(this.f39296a.f39295a, obtainScanInterval);
                                } else {
                                    AppStatusHelper.h(this.f39296a.f39295a);
                                }
                            }
                        }
                    });
                }
            }
        }, j);
    }

    public static void a(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, bVar) == null) || context == null) {
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
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static void b(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, null, context, j) == null) {
            if (f39288a == null) {
                f39288a = new Handler(Looper.getMainLooper());
            }
            f39288a.post(new Runnable(context, j) { // from class: com.kwad.sdk.utils.AppStatusHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f39297a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f39298b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39297a = context;
                    this.f39298b = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AppStatusHelper.h(this.f39297a);
                        AppStatusHelper.f39288a.postDelayed(this, this.f39298b);
                    }
                }
            });
        }
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, appStatusRules) == null) {
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
    }

    public static void b(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, bVar) == null) {
            f39292e.submit(new Runnable(context, bVar) { // from class: com.kwad.sdk.utils.AppStatusHelper.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f39299a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f39300b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39299a = context;
                    this.f39300b = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && AppStatusHelper.k(this.f39299a)) {
                        com.kwad.sdk.collector.b.b();
                        List<AppRunningInfo> j = AppStatusHelper.j(this.f39299a);
                        if (j != null) {
                            Iterator<AppRunningInfo> it = j.iterator();
                            while (it.hasNext()) {
                                com.kwad.sdk.core.d.a.a("AppStatusHelper", "AppRunningInfo: " + it.next());
                            }
                            b bVar2 = this.f39300b;
                            if (bVar2 != null) {
                                bVar2.a(j);
                            }
                        }
                    }
                }
            });
        }
    }

    public static void c(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bVar) == null) {
            f39292e.submit(new Runnable(context, bVar) { // from class: com.kwad.sdk.utils.AppStatusHelper.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f39301a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f39302b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39301a = context;
                    this.f39302b = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        List<AppRunningInfo> i2 = AppStatusHelper.i(this.f39301a);
                        b bVar2 = this.f39302b;
                        if (bVar2 != null) {
                            bVar2.a(i2);
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0056 A[Catch: Exception -> 0x0059, TRY_LEAVE, TryCatch #5 {Exception -> 0x0059, blocks: (B:30:0x0051, B:32:0x0056), top: B:47:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AppStatusRules g(Context context) {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        Throwable th;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65556, null, context)) != null) {
            return (AppStatusRules) invokeL.objValue;
        }
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
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        return appStatusRules;
                    } catch (Exception e2) {
                        e = e2;
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
                } catch (Throwable th2) {
                    th = th2;
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
            } catch (Exception e3) {
                e = e3;
                objectInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            objectInputStream = null;
        } catch (Throwable th4) {
            objectInputStream = null;
            th = th4;
            fileInputStream = null;
        }
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, context) == null) || context == null) {
            return;
        }
        boolean a2 = ASService.a(context);
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "isServiceAvailable: " + a2);
        if (a2) {
            ASService.c(context, f39291d);
        } else {
            a(context, new d(null));
        }
    }

    public static List<AppRunningInfo> i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
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
        return (List) invokeL.objValue;
    }

    @WorkerThread
    public static List<AppRunningInfo> j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static boolean k(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) ? context.checkCallingOrSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0 : invokeL.booleanValue;
    }
}
