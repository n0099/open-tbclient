package com.kwad.sdk.core.diskcache;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.f;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.a;
import com.kwad.sdk.utils.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class ApkInstallCheckManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Future f35949a;

    /* renamed from: b  reason: collision with root package name */
    public File f35950b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f35951c;

    /* renamed from: d  reason: collision with root package name */
    public PackageManager f35952d;

    /* renamed from: e  reason: collision with root package name */
    public final f f35953e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f35954f;

    /* renamed from: g  reason: collision with root package name */
    public final Callable<PackageInfo> f35955g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Holder {
        public static final /* synthetic */ Holder[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Holder INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;
        public ApkInstallCheckManager mInstance;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1832061742, "Lcom/kwad/sdk/core/diskcache/ApkInstallCheckManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1832061742, "Lcom/kwad/sdk/core/diskcache/ApkInstallCheckManager$Holder;");
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
            this.mInstance = new ApkInstallCheckManager();
        }

        public static Holder valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Holder) Enum.valueOf(Holder.class, str) : (Holder) invokeL.objValue;
        }

        public static Holder[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Holder[]) $VALUES.clone() : (Holder[]) invokeV.objValue;
        }

        public ApkInstallCheckManager getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInstance : (ApkInstallCheckManager) invokeV.objValue;
        }
    }

    public ApkInstallCheckManager() {
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
        this.f35951c = Executors.newSingleThreadExecutor();
        this.f35954f = false;
        this.f35955g = new Callable<PackageInfo>(this) { // from class: com.kwad.sdk.core.diskcache.ApkInstallCheckManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ApkInstallCheckManager f35956a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35956a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public PackageInfo call() {
                InterceptResult invokeV;
                PackageInfo a2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (ApkInstallCheckManager.class) {
                        if (this.f35956a.f35950b != null && this.f35956a.f35950b.exists()) {
                            for (File file : this.f35956a.b(this.f35956a.f35950b)) {
                                if (file.getName().endsWith(".apk") && a.a().a(file.getAbsolutePath()) != null && (a2 = this.f35956a.a(file)) != null) {
                                    this.f35956a.f35953e.a(file);
                                    return a2;
                                }
                            }
                            return null;
                        }
                        return null;
                    }
                }
                return (PackageInfo) invokeV.objValue;
            }
        };
        this.f35953e = new com.kwad.sdk.core.download.c.a();
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        try {
            this.f35950b = ad.c(KsAdSDKImpl.get().getContext());
            this.f35952d = KsAdSDKImpl.get().getContext().getPackageManager();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.f35954f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, file)) == null) {
            if (file != null && file.exists()) {
                try {
                    if (file.exists() & (!file.isDirectory())) {
                        PackageInfo packageArchiveInfo = this.f35952d.getPackageArchiveInfo(file.getPath(), 65);
                        if (this.f35952d.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                            return null;
                        }
                        return packageArchiveInfo;
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            return null;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static ApkInstallCheckManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Holder.INSTANCE.getInstance() : (ApkInstallCheckManager) invokeV.objValue;
    }

    private void a(List<File> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, list) == null) {
            Collections.sort(list, new Comparator<File>(this) { // from class: com.kwad.sdk.core.diskcache.ApkInstallCheckManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ApkInstallCheckManager f35957a;

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
                    this.f35957a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file, File file2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, file2)) == null) {
                        if (file.lastModified() >= file2.lastModified()) {
                            return file.lastModified() == file2.lastModified() ? 0 : 1;
                        }
                        return -1;
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> b(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, file)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            arrayList.addAll(Arrays.asList(listFiles));
            a(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f35954f && (file = this.f35950b) != null && file.exists()) {
            Future future = this.f35949a;
            if (future == null || future.isDone()) {
                this.f35949a = this.f35951c.submit(this.f35955g);
            }
        }
    }
}
