package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.i.b;
import com.kwad.sdk.utils.aq;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class ApkCacheManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Future a;

    /* renamed from: b  reason: collision with root package name */
    public File f57844b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f57845c;

    /* renamed from: d  reason: collision with root package name */
    public final Callable<Void> f57846d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Holder {
        public static final /* synthetic */ Holder[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Holder INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;
        public ApkCacheManager mInstance;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1999167059, "Lcom/kwad/sdk/core/diskcache/ApkCacheManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1999167059, "Lcom/kwad/sdk/core/diskcache/ApkCacheManager$Holder;");
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
            this.mInstance = new ApkCacheManager();
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

        public ApkCacheManager getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInstance : (ApkCacheManager) invokeV.objValue;
        }
    }

    public ApkCacheManager() {
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
        this.f57845c = b.j();
        this.f57846d = new Callable<Void>(this) { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ApkCacheManager a;

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
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (ApkCacheManager.class) {
                        if (this.a.f57844b != null && this.a.f57844b.exists() && !this.a.c()) {
                            for (File file : this.a.d(this.a.f57844b)) {
                                if (file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                                    this.a.c(file);
                                    if (this.a.c()) {
                                        return null;
                                    }
                                }
                            }
                            return null;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        if (KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        try {
            this.f57844b = aq.c(KsAdSDKImpl.get().getContext());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    private int a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, file)) == null) ? (int) ((((float) b(file)) / 1000.0f) / 1000.0f) : invokeL.intValue;
    }

    public static ApkCacheManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Holder.INSTANCE.getInstance() : (ApkCacheManager) invokeV.objValue;
    }

    private void a(List<File> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, list) == null) {
            Collections.sort(list, new Comparator<File>(this) { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ApkCacheManager a;

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

    private long b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, file)) == null) {
            File[] listFiles = file.listFiles();
            long j2 = 0;
            if (listFiles != null) {
                int length = listFiles.length;
                for (int i2 = 0; i2 < length; i2++) {
                    j2 += listFiles[i2].isDirectory() ? b(listFiles[i2]) : listFiles[i2].length();
                }
            }
            return j2;
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, file) == null) && file != null && file.exists()) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        c(file2);
                    }
                } else if (!file.exists()) {
                    return;
                }
                file.delete();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            File file = this.f57844b;
            if (file == null || !file.exists()) {
                return false;
            }
            File[] listFiles = this.f57844b.listFiles();
            return listFiles.length <= 5 || (listFiles.length <= 10 && a(this.f57844b) <= 400);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> d(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, file)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (file = this.f57844b) != null && file.exists()) {
            Future future = this.a;
            if (future == null || future.isDone()) {
                this.a = this.f57845c.submit(this.f57846d);
            }
        }
    }
}
