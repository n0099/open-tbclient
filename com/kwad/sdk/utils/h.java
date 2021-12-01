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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static Handler a;

    /* renamed from: b  reason: collision with root package name */
    public static Messenger f59645b;

    /* renamed from: c  reason: collision with root package name */
    public static ServiceConnection f59646c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ExecutorService f59647d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile AppStatusRules f59648e;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<Context> f59649f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.utils.h$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static class AnonymousClass2 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public AnonymousClass2(Context context) {
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
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.kwad.sdk.collector.c.a(this.a, new c.a(this) { // from class: com.kwad.sdk.utils.h.2.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass2 a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.collector.c.a
                    public void a(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            com.kwad.sdk.core.d.a.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i2);
                        }
                    }

                    @Override // com.kwad.sdk.collector.c.a
                    public void a(AppStatusRules appStatusRules) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appStatusRules) == null) {
                            appStatusRules.initStatus(this.a.a);
                            AppStatusRules unused = h.f59648e = appStatusRules;
                            h.b(this.a.a, h.f59648e);
                            h.a(this.a.a);
                            boolean l = h.l(this.a.a);
                            boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(h.f59648e);
                            com.kwad.sdk.core.d.a.a("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + l);
                            if (l && isAppStatusTargetNotEmpty) {
                                long obtainDefaultScanInterval = h.f59648e.obtainDefaultScanInterval();
                                if (obtainDefaultScanInterval > 0) {
                                    h.b(this.a.a, obtainDefaultScanInterval);
                                } else {
                                    h.i(this.a.a);
                                }
                            }
                            boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(h.f59648e);
                            boolean z = h.f59648e.obtainUploadConfigFileMaxSize() > 0;
                            com.kwad.sdk.core.d.a.a("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                            if (isUploadTargetNotEmpty && z && l) {
                                h.k();
                                h.f59647d.submit(new Runnable(this) { // from class: com.kwad.sdk.utils.h.2.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 a;

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
                                        this.a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            try {
                                                com.kwad.sdk.collector.j.a(this.a.a.a, h.f59648e);
                                            } catch (Throwable th) {
                                                com.kwad.sdk.crash.a.a(th);
                                                com.kwad.sdk.core.d.a.b(th);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f59652b;

        /* renamed from: c  reason: collision with root package name */
        public List<Long> f59653c;

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
                    return;
                }
            }
            this.f59653c = new ArrayList();
        }

        public a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f59653c = new ArrayList();
            this.a = str;
            this.f59652b = str2;
        }

        @Nullable
        public static JSONArray a(List<com.kwad.sdk.collector.model.b> list) {
            InterceptResult invokeL;
            List<a> list2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
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
            return (JSONArray) invokeL.objValue;
        }

        @Nullable
        public static List<a> b(List<com.kwad.sdk.collector.model.b> list) {
            InterceptResult invokeL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
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
            return (List) invokeL.objValue;
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f59653c.add(Long.valueOf(j2));
            }
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("appName");
            this.f59652b = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.f59653c.clear();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        this.f59653c.add(Long.valueOf(optJSONArray.getLong(i2)));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                t.a(jSONObject, "appName", this.a);
                t.a(jSONObject, "packageName", this.f59652b);
                JSONArray jSONArray = new JSONArray();
                for (Long l : this.f59653c) {
                    jSONArray.put(l.longValue());
                }
                t.a(jSONObject, "runningTimes", jSONArray);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(List<com.kwad.sdk.collector.model.b> list);
    }

    /* loaded from: classes2.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NonNull Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private void a(Message message) {
            ArrayList arrayList;
            List list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, message) == null) {
                Bundle data = message.getData();
                List<AppStatusRules.Strategy> list2 = null;
                if (data != null) {
                    try {
                        if (data.containsKey("resultJson")) {
                            list = t.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>(this) { // from class: com.kwad.sdk.utils.h.c.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ c a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.kwad.sdk.core.c
                                /* renamed from: b */
                                public a a() {
                                    InterceptResult invokeV;
                                    Interceptable interceptable2 = $ic;
                                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a() : (a) invokeV.objValue;
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
                if (h.f59649f != null && h.f59649f.get() != null && data != null) {
                    if (data.containsKey("allStrategyJson")) {
                        String string = data.getString("allStrategyJson");
                        if (string != null) {
                            list2 = t.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>(this) { // from class: com.kwad.sdk.utils.h.c.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ c a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.kwad.sdk.core.c
                                /* renamed from: b */
                                public AppStatusRules.Strategy a() {
                                    InterceptResult invokeV;
                                    Interceptable interceptable2 = $ic;
                                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new AppStatusRules.Strategy() : (AppStatusRules.Strategy) invokeV.objValue;
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
                                com.kwad.sdk.collector.h.a((Context) h.f59649f.get(), strategy, needSaveLaunchTime);
                            }
                        }
                    }
                }
                if (h.f59649f == null || h.f59646c == null) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("AppStatusHelper", "unbindASService");
                com.kwad.sdk.collector.b.a.b((Context) h.f59649f.get(), h.f59646c);
            }
        }

        public static void a(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, null, arrayList) == null) || arrayList == null || (a = a.a(arrayList)) == null) {
                return;
            }
            com.kwad.sdk.core.report.d.a(a);
        }

        public static void a(List<a> list) {
            JSONArray b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65539, null, list) == null) || list == null || (b2 = t.b(list)) == null) {
                return;
            }
            com.kwad.sdk.core.report.d.a(b2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
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
    }

    /* loaded from: classes2.dex */
    public static class d implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b a;

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
            this.a = bVar;
        }

        @Override // com.kwad.sdk.utils.h.b
        public void a(List<com.kwad.sdk.collector.model.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510835508, "Lcom/kwad/sdk/utils/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1510835508, "Lcom/kwad/sdk/utils/h;");
                return;
            }
        }
        f59646c = new ServiceConnection() { // from class: com.kwad.sdk.utils.h.1
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
                    if (!h.j()) {
                        com.kwad.sdk.core.d.a.d("AppStatusHelper", "clientMessenger init error");
                        return;
                    }
                    obtain.replyTo = h.f59645b;
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
    }

    public static AppStatusRules a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f59648e : (AppStatusRules) invokeV.objValue;
    }

    @NonNull
    public static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, strategy, map)) == null) {
            boolean isNeedLaunch = strategy.isNeedLaunch();
            com.kwad.sdk.core.d.a.a("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
            return !isNeedLaunch ? new ArrayList() : com.kwad.sdk.collector.b.a().a(strategy, map);
        }
        return (List) invokeLL.objValue;
    }

    public static List<com.kwad.sdk.collector.model.b> a(List<com.kwad.sdk.collector.model.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) ? (list == null || list.isEmpty()) ? list : new ArrayList(new LinkedHashSet(list)) : (List) invokeL.objValue;
    }

    @WorkerThread
    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, context) == null) && f59648e == null) {
            f59648e = h(context);
        }
    }

    public static void a(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65542, null, context, j2) == null) || ao.l() || com.kwad.sdk.core.config.b.a(8192L) || context == null || m(context)) {
            return;
        }
        boolean b2 = SystemUtil.b(context);
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "isMainProcess: " + b2);
        if (b2) {
            f59649f = new WeakReference<>(context);
            if (j2 <= 0) {
                j2 = 30000;
            }
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            a.postDelayed(new AnonymousClass2(context), j2);
        }
    }

    public static void a(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, context, bVar) == null) || context == null || ao.l() || com.kwad.sdk.core.config.b.a(8192L) || m(context)) {
            return;
        }
        k();
        f59647d.submit(new Runnable(context, bVar) { // from class: com.kwad.sdk.utils.h.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f59651b;

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
                this.a = context;
                this.f59651b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                List k2;
                List j2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        HashSet hashSet = new HashSet();
                        if (Build.VERSION.SDK_INT < 21 && (j2 = h.j(this.a)) != null) {
                            hashSet.addAll(j2);
                        }
                        if (!h.l(this.a) || (k2 = h.k(this.a)) == null) {
                            return;
                        }
                        Iterator it = k2.iterator();
                        while (it.hasNext()) {
                            com.kwad.sdk.core.d.a.a("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                        }
                        hashSet.addAll(k2);
                        if (this.f59651b != null) {
                            this.f59651b.a(new ArrayList(hashSet));
                        }
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.a.b(th);
                        com.kwad.sdk.crash.a.a(th);
                    }
                }
            }
        });
    }

    @Nullable
    public static List<String> b(@NonNull Context context) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static void b(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, context, j2) == null) {
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            a.post(new Runnable(context, j2) { // from class: com.kwad.sdk.utils.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f59650b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.f59650b = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        h.i(this.a);
                        h.a.postDelayed(this, this.f59650b);
                    }
                }
            });
        }
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, appStatusRules) == null) {
            File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
            com.kwad.sdk.crash.utils.h.a(file.getAbsolutePath(), appStatusRules.toJson().toString(), false);
        }
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    public static List<com.kwad.sdk.collector.model.b> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
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
        return (List) invokeL.objValue;
    }

    @Nullable
    @WorkerThread
    public static AppStatusRules h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
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
        return (AppStatusRules) invokeL.objValue;
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, context) == null) || context == null) {
            return;
        }
        boolean l = l();
        com.kwad.sdk.core.d.a.a("AppStatusHelper", "isServiceAvailable: " + l);
        if (l) {
            com.kwad.sdk.collector.b.a.a(context, f59646c);
        } else {
            a(context, new d(null));
        }
    }

    @Nullable
    public static List<com.kwad.sdk.collector.model.b> j(Context context) {
        InterceptResult invokeL;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            if ((av.a(context, com.kuaishou.weapon.un.s.f56840e) == 0) && (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100)) != null) {
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
        return (List) invokeL.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            if (f59645b == null) {
                try {
                    f59645b = new Messenger(new c(Looper.getMainLooper()));
                } catch (Throwable unused) {
                }
            }
            return f59645b != null;
        }
        return invokeV.booleanValue;
    }

    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            if (l(context)) {
                if (f59648e == null) {
                    f59648e = h(context);
                }
                return c(context);
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public static synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            synchronized (h.class) {
                if (f59647d != null) {
                    return;
                }
                f59647d = com.kwad.sdk.core.i.b.m();
            }
        }
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
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
        return invokeV.booleanValue;
    }

    public static boolean l(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) ? context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 : invokeL.booleanValue;
    }

    public static boolean m(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) ? context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy() : invokeL.booleanValue;
    }
}
