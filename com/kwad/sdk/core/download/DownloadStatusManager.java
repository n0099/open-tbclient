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
/* loaded from: classes3.dex */
public class DownloadStatusManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static com.ksad.download.f f57892f;

    /* renamed from: g  reason: collision with root package name */
    public static final BroadcastReceiver f57893g;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakHashMap<c, AdTemplate> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<c, AdTemplate> f57894b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f57895c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, AdTemplate> f57896d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, AdTemplate> f57897e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
                if (!this.mInstance.f57895c) {
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
        f57893g = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.3
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
        this.f57894b = Collections.synchronizedMap(weakHashMap);
        this.f57895c = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.f57896d = hashMap;
        this.f57897e = Collections.synchronizedMap(hashMap);
        b();
    }

    public static DownloadStatusManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Holder.INSTANCE.getInstance() : (DownloadStatusManager) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) && Holder.INSTANCE.mInstance.f57895c) {
            try {
                synchronized (Holder.INSTANCE.lock) {
                    if (Holder.INSTANCE.mInstance.f57895c) {
                        context.unregisterReceiver(f57893g);
                        Holder.INSTANCE.mInstance.f57894b.clear();
                        Holder.INSTANCE.mInstance.f57897e.clear();
                        Holder.INSTANCE.mInstance.f57895c = false;
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
            synchronized (this.f57894b) {
                for (c cVar : this.f57894b.keySet()) {
                    if (cVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, cVar.b())) {
                        cVar.a((String) null, 0, fVar);
                    }
                }
            }
            f57892f.a(schemeSpecificPart);
            synchronized (this.f57897e) {
                Iterator<Map.Entry<String, AdTemplate>> it = this.f57897e.entrySet().iterator();
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
            Set<c> keySet = this.f57894b.keySet();
            synchronized (this.f57894b) {
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
            for (Map.Entry<String, AdTemplate> entry : this.f57897e.entrySet()) {
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
            if (this.f57895c || context == null) {
                return;
            }
            f57892f = new com.kwad.sdk.core.download.b.a(context);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            context.registerReceiver(f57893g, intentFilter);
            this.f57895c = true;
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f57894b.remove(cVar);
        }
    }

    public void a(c cVar, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, adTemplate) == null) {
            this.f57894b.put(cVar, adTemplate);
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
                this.f57897e.put(v, adTemplate);
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
                public final /* synthetic */ f f57898b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57899c;

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
                    this.f57899c = this;
                    this.a = str;
                    this.f57898b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.a(this.a, this.f57898b);
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
                public final /* synthetic */ int f57902b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f57903c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f57904d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57905e;

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
                    this.f57905e = this;
                    this.a = str;
                    this.f57902b = i2;
                    this.f57903c = i3;
                    this.f57904d = i4;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.a(this.a, this.f57902b, this.f57903c, this.f57904d);
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
                public final /* synthetic */ int f57909b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f57910c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f57911d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57912e;

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
                    this.f57912e = this;
                    this.a = str;
                    this.f57909b = i2;
                    this.f57910c = str2;
                    this.f57911d = r10;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.a(this.a, this.f57909b, this.f57910c, this.f57911d);
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
                public final /* synthetic */ String f57906b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ f f57907c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57908d;

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
                    this.f57908d = this;
                    this.a = str;
                    this.f57906b = str2;
                    this.f57907c = fVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.a(this.a, this.f57906b, this.f57907c);
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
                public final /* synthetic */ f f57913b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57914c;

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
                    this.f57914c = this;
                    this.a = str;
                    this.f57913b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.b(this.a, this.f57913b);
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
                public final /* synthetic */ f f57915b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57916c;

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
                    this.f57916c = this;
                    this.a = str;
                    this.f57915b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.c(this.a, this.f57915b);
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
                public final /* synthetic */ f f57917b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57918c;

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
                    this.f57918c = this;
                    this.a = str;
                    this.f57917b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.d(this.a, this.f57917b);
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
                public final /* synthetic */ f f57900b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusManager f57901c;

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
                    this.f57901c = this;
                    this.a = str;
                    this.f57900b = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.b.a
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        cVar.e(this.a, this.f57900b);
                    }
                }
            });
        }
    }
}
