package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DownloadStatusManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static com.ksad.download.f f57311f;

    /* renamed from: g  reason: collision with root package name */
    public static final BroadcastReceiver f57312g;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakHashMap<c, AdTemplate> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<c, AdTemplate> f57313b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f57314c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, AdTemplate> f57315d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, AdTemplate> f57316e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Holder {
        public static final /* synthetic */ Holder[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Holder INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object lock;
        public DownloadStatusManager mInstance;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-480746676, "Lcom/kwad/sdk/core/download/DownloadStatusManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-480746676, "Lcom/kwad/sdk/core/download/DownloadStatusManager$Holder;");
                    return;
                }
            }
            Holder holder = new Holder("INSTANCE", 0);
            INSTANCE = holder;
            $VALUES = new Holder[]{holder};
        }

        public Holder(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mInstance = new DownloadStatusManager();
            this.lock = new Object();
        }

        public static Holder valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Holder) Enum.valueOf(Holder.class, str) : (Holder) invokeL.objValue;
        }

        public static Holder[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (Holder[]) $VALUES.clone() : (Holder[]) invokeV.objValue;
        }

        public DownloadStatusManager getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.mInstance.f57314c) {
                    synchronized (this.lock) {
                        this.mInstance.b();
                    }
                }
                return this.mInstance;
            }
            return (DownloadStatusManager) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-732857510, "Lcom/kwad/sdk/core/download/DownloadStatusManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-732857510, "Lcom/kwad/sdk/core/download/DownloadStatusManager;");
                return;
            }
        }
        f57312g = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.3
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

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) {
                    DownloadStatusManager.a().a(intent);
                }
            }
        };
    }

    public DownloadStatusManager() {
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
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.a = weakHashMap;
        this.f57313b = Collections.synchronizedMap(weakHashMap);
        this.f57314c = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.f57315d = hashMap;
        this.f57316e = Collections.synchronizedMap(hashMap);
        b();
    }

    public static DownloadStatusManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Holder.INSTANCE.getInstance() : (DownloadStatusManager) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) && Holder.INSTANCE.mInstance.f57314c) {
            try {
                synchronized (Holder.INSTANCE.lock) {
                    if (Holder.INSTANCE.mInstance.f57314c) {
                        context.unregisterReceiver(f57312g);
                        Holder.INSTANCE.mInstance.f57313b.clear();
                        Holder.INSTANCE.mInstance.f57316e.clear();
                        Holder.INSTANCE.mInstance.f57314c = false;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, intent) == null) {
            String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (KsAdSDKImpl.get().isDebugLogEnable()) {
                com.kwad.sdk.core.d.a.a("DownloadStatusManager", "handleInstallApp(), pkgNameAdded=" + schemeSpecificPart);
            }
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            f fVar = new f();
            synchronized (this.f57313b) {
                for (c cVar : this.f57313b.keySet()) {
                    if (cVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, cVar.b())) {
                        cVar.a((String) null, 0, fVar);
                    }
                }
            }
            f57311f.a(schemeSpecificPart);
            synchronized (this.f57316e) {
                Iterator<Map.Entry<String, AdTemplate>> it = this.f57316e.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, AdTemplate> next = it.next();
                    if (next != null) {
                        String key = next.getKey();
                        if (!TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, key)) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private void a(String str, com.kwad.sdk.b.a<c> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, aVar) == null) {
            Set<c> keySet = this.f57313b.keySet();
            synchronized (this.f57313b) {
                for (c cVar : keySet) {
                    if (cVar != null && TextUtils.equals(cVar.a(), str)) {
                        try {
                            aVar.a(cVar);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                }
            }
        }
    }

    private void a(String str, f fVar) {
        AdTemplate value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, str, fVar) == null) {
            for (Map.Entry<String, AdTemplate> entry : this.f57316e.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    AdInfo j2 = com.kwad.sdk.core.response.a.d.j(value);
                    com.kwad.sdk.core.a.a().a(str, value);
                    if (!TextUtils.isEmpty(str) && j2.downloadId.equals(str) && !value.mDownloadFinishReported) {
                        if (fVar.b()) {
                            com.kwad.sdk.core.report.a.e(value, (JSONObject) null);
                            fVar.a();
                        }
                        value.mDownloadFinishReported = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (this.f57314c || context == null) {
                return;
            }
            f57311f = new com.kwad.sdk.core.download.b.a(context);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            context.registerReceiver(f57312g, intentFilter);
            this.f57314c = true;
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f57313b.remove(cVar);
        }
    }

    public void a(c cVar, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, adTemplate) == null) {
            this.f57313b.put(cVar, adTemplate);
        }
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            try {
                String v = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
                if (TextUtils.isEmpty(v)) {
                    return;
                }
                this.f57316e.put(v, adTemplate);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            a(str, new com.kwad.sdk.b.a<c>(this, str, new f()) { // from class: com.kwad.sdk.core.download.DownloadStatusManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f57317b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57318c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57318c = this;
                    this.a = str;
                    this.f57317b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.a(this.a, this.f57317b);
                    }
                }
            });
        }
    }

    public void a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, str, i2, i3, i4) == null) {
            a(str, new com.kwad.sdk.b.a<c>(this, str, i2, i3, i4) { // from class: com.kwad.sdk.core.download.DownloadStatusManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f57321b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f57322c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f57323d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57324e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57324e = this;
                    this.a = str;
                    this.f57321b = i2;
                    this.f57322c = i3;
                    this.f57323d = i4;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.a(this.a, this.f57321b, this.f57322c, this.f57323d);
                    }
                }
            });
        }
    }

    public void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, str, i2, str2) == null) {
            a(str, new com.kwad.sdk.b.a<c>(this, str, i2, str2, new f()) { // from class: com.kwad.sdk.core.download.DownloadStatusManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f57328b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f57329c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f57330d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57331e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), str2, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57331e = this;
                    this.a = str;
                    this.f57328b = i2;
                    this.f57329c = str2;
                    this.f57330d = r10;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.a(this.a, this.f57328b, this.f57329c, this.f57330d);
                    }
                }
            });
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            f fVar = new f();
            a(str, new com.kwad.sdk.b.a<c>(this, str, str2, fVar) { // from class: com.kwad.sdk.core.download.DownloadStatusManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f57325b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ f f57326c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57327d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, fVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57327d = this;
                    this.a = str;
                    this.f57325b = str2;
                    this.f57326c = fVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.a(this.a, this.f57325b, this.f57326c);
                    }
                }
            });
            a(str, fVar);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            a(str, new com.kwad.sdk.b.a<c>(this, str, new f()) { // from class: com.kwad.sdk.core.download.DownloadStatusManager.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f57332b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57333c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57333c = this;
                    this.a = str;
                    this.f57332b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.b(this.a, this.f57332b);
                    }
                }
            });
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            a(str, new com.kwad.sdk.b.a<c>(this, str, new f()) { // from class: com.kwad.sdk.core.download.DownloadStatusManager.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f57334b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57335c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57335c = this;
                    this.a = str;
                    this.f57334b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.c(this.a, this.f57334b);
                    }
                }
            });
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            a(str, new com.kwad.sdk.b.a<c>(this, str, new f()) { // from class: com.kwad.sdk.core.download.DownloadStatusManager.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f57336b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57337c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57337c = this;
                    this.a = str;
                    this.f57336b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.d(this.a, this.f57336b);
                    }
                }
            });
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            a(str, new com.kwad.sdk.b.a<c>(this, str, new f()) { // from class: com.kwad.sdk.core.download.DownloadStatusManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f57319b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57320c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57320c = this;
                    this.a = str;
                    this.f57319b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.e(this.a, this.f57319b);
                    }
                }
            });
        }
    }
}
