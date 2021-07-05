package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
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
/* loaded from: classes7.dex */
public class DownloadStatusManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static com.ksad.download.f f36004f;

    /* renamed from: g  reason: collision with root package name */
    public static final BroadcastReceiver f36005g;

    /* renamed from: h  reason: collision with root package name */
    public static final BroadcastReceiver f36006h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap<d, AdTemplate> f36007a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<d, AdTemplate> f36008b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f36009c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, AdTemplate> f36010d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, AdTemplate> f36011e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? (Holder) Enum.valueOf(Holder.class, str) : (Holder) invokeL.objValue;
        }

        public static Holder[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (Holder[]) $VALUES.clone() : (Holder[]) invokeV.objValue;
        }

        public DownloadStatusManager getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.mInstance.f36009c) {
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
        f36004f = new com.kwad.sdk.core.download.c.a();
        f36005g = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.1
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
        f36006h = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.2
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
                    DownloadStatusManager.a().b(intent);
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
        WeakHashMap<d, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.f36007a = weakHashMap;
        this.f36008b = Collections.synchronizedMap(weakHashMap);
        this.f36009c = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.f36010d = hashMap;
        this.f36011e = Collections.synchronizedMap(hashMap);
        b();
    }

    public static DownloadStatusManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Holder.INSTANCE.getInstance() : (DownloadStatusManager) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, null, context) == null) && Holder.INSTANCE.mInstance.f36009c) {
            try {
                synchronized (Holder.INSTANCE.lock) {
                    if (Holder.INSTANCE.mInstance.f36009c) {
                        context.unregisterReceiver(f36005g);
                        context.unregisterReceiver(f36006h);
                        Holder.INSTANCE.mInstance.f36008b.clear();
                        Holder.INSTANCE.mInstance.f36011e.clear();
                        Holder.INSTANCE.mInstance.f36009c = false;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        Bundle extras;
        String str;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, intent) == null) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("RESULT_DOWNLOAD_ID");
        String action = intent.getAction();
        char c3 = 2;
        if (TextUtils.equals(a.f36013b, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 1;
        } else if (TextUtils.equals(a.f36014c, action)) {
            i2 = extras.getInt("KEY_RESULT_PROGRESS", 0);
            i5 = extras.getInt("KEY_RESULT_PROGRESS_SOFARBYTES", 0);
            str2 = null;
            c2 = 2;
            i4 = extras.getInt("KEY_RESULT_PROGRESS_TOTALBYTES", 0);
            str = "";
            i3 = 0;
        } else if (TextUtils.equals(a.f36015d, action)) {
            String string2 = extras.getString("KEY_REUSLT_FILEPATH");
            str = "";
            str2 = string2;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 3;
        } else if (TextUtils.equals(a.f36016e, action)) {
            int i6 = extras.getInt("KEY_RESULT_ERROR_CODE", 0);
            str = extras.getString("KEY_RESULT_ERROR_MSG", "");
            str2 = null;
            i4 = 0;
            i5 = 0;
            c2 = 4;
            i3 = i6;
            i2 = 0;
        } else if (TextUtils.equals(a.f36017f, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 5;
        } else if (TextUtils.equals(a.f36018g, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 6;
        } else if (TextUtils.equals(a.f36019h, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 7;
        } else if (TextUtils.equals(a.f36020i, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = '\b';
        } else if (TextUtils.equals(a.j, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = '\t';
        } else if (TextUtils.equals(a.k, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = '\n';
        } else if (TextUtils.equals(a.l, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 11;
        } else if (a.n.equals(action)) {
            com.ksad.download.d.a().c(intent.getIntExtra("download.intent.action.EXTRA_TASK_ID", 0));
            com.ksad.download.e.a().a(intent.getIntExtra("download.intent.action.EXTRA_TASK_ID", 0));
            return;
        } else {
            str = "";
            str2 = null;
            if (TextUtils.equals(a.m, action)) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                c2 = '\f';
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                c2 = 0;
            }
        }
        f fVar = new f();
        Set<d> keySet = this.f36008b.keySet();
        synchronized (this.f36008b) {
            for (d dVar : keySet) {
                if (dVar != null) {
                    if (TextUtils.equals(dVar.a(), string)) {
                        if (c2 == 1) {
                            dVar.a(string, fVar);
                        } else if (c2 == c3) {
                            dVar.a(string, i2, i5, i4);
                        } else if (c2 == 3) {
                            dVar.a(string, str2, fVar);
                        } else {
                            if (c2 == 4) {
                                dVar.a(string, i3, str, fVar);
                            } else if (c2 == 5) {
                                dVar.b(string, fVar);
                            } else if (c2 == 6) {
                                dVar.c(string, fVar);
                            } else if (c2 == 7) {
                                dVar.d(string, fVar);
                            } else if (c2 == '\b') {
                                dVar.e(string, fVar);
                            } else if (c2 == '\t') {
                                dVar.a(string);
                            } else if (c2 == '\n') {
                                dVar.a(string, 0, fVar);
                            } else if (c2 == 11) {
                                dVar.b(string);
                            } else {
                                if (c2 == '\f') {
                                    dVar.f(string, fVar);
                                }
                                c3 = 2;
                            }
                            c3 = 2;
                        }
                    }
                    c3 = 2;
                }
            }
        }
        if (c2 == 3) {
            a(string, fVar);
        }
    }

    private void a(String str, f fVar) {
        AdTemplate value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, fVar) == null) {
            for (Map.Entry<String, AdTemplate> entry : this.f36011e.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    AdInfo j = com.kwad.sdk.core.response.b.c.j(value);
                    com.kwad.sdk.core.a.a().a(str, value);
                    if (!TextUtils.isEmpty(str) && j.downloadId.equals(str) && !value.mDownloadFinishReported) {
                        if (fVar.b()) {
                            com.kwad.sdk.core.report.b.c(value);
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
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f36009c || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(a.f36013b);
        intentFilter.addAction(a.f36014c);
        intentFilter.addAction(a.f36015d);
        intentFilter.addAction(a.f36016e);
        intentFilter.addAction(a.f36017f);
        intentFilter.addAction(a.f36018g);
        intentFilter.addAction(a.f36019h);
        intentFilter.addAction(a.f36020i);
        intentFilter.addAction(a.j);
        intentFilter.addAction(a.k);
        intentFilter.addAction(a.m);
        intentFilter.addAction(a.l);
        intentFilter.addAction(a.n);
        KsAdSDKImpl.get().getContext().registerReceiver(f36005g, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter2.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        KsAdSDKImpl.get().getContext().registerReceiver(f36006h, intentFilter2);
        this.f36009c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, intent) == null) {
            String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            f fVar = new f();
            Set<d> keySet = this.f36008b.keySet();
            synchronized (this.f36008b) {
                for (d dVar : keySet) {
                    if (dVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, dVar.b())) {
                        dVar.a((String) null, 0, fVar);
                    }
                }
            }
            f36004f.a(schemeSpecificPart);
            Set<Map.Entry<String, AdTemplate>> entrySet = this.f36011e.entrySet();
            synchronized (this.f36011e) {
                Iterator<Map.Entry<String, AdTemplate>> it = entrySet.iterator();
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

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f36008b.remove(dVar);
        }
    }

    public void a(d dVar, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, adTemplate) == null) {
            this.f36008b.put(dVar, adTemplate);
        }
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            try {
                String s = com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(adTemplate));
                if (TextUtils.isEmpty(s)) {
                    return;
                }
                this.f36011e.put(s, adTemplate);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }
}
