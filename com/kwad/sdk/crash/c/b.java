package com.kwad.sdk.crash.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f73001a;

    /* renamed from: b  reason: collision with root package name */
    public static File f73002b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public e f73003c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f73004d;

    /* renamed from: e  reason: collision with root package name */
    public File f73005e;

    /* renamed from: f  reason: collision with root package name */
    public File f73006f;

    /* renamed from: g  reason: collision with root package name */
    public File f73007g;

    /* renamed from: h  reason: collision with root package name */
    public File f73008h;

    /* renamed from: i  reason: collision with root package name */
    public File f73009i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.crash.report.c f73010j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1106860088, "Lcom/kwad/sdk/crash/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1106860088, "Lcom/kwad/sdk/crash/c/b;");
                return;
            }
        }
        f73001a = UUID.randomUUID().toString();
    }

    public b() {
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
        this.f73004d = new AtomicInteger();
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            f73002b = file;
            if (file.exists()) {
                return;
            }
            f73002b.mkdirs();
        }
    }

    public final com.kwad.sdk.crash.report.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f73010j : (com.kwad.sdk.crash.report.c) invokeV.objValue;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, eVar, cVar) == null) {
            this.f73005e = file;
            if (!file.exists()) {
                this.f73005e.mkdirs();
            }
            File file2 = this.f73005e;
            this.f73006f = new File(file2, f73001a + "-" + this.f73004d + ".dump");
            File file3 = this.f73005e;
            this.f73007g = new File(file3, f73001a + "-" + this.f73004d + ".log");
            File file4 = this.f73005e;
            this.f73008h = new File(file4, f73001a + "-" + this.f73004d + ".jtrace");
            this.f73003c = eVar;
            this.f73010j = cVar;
        }
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (listFiles = this.f73005e.listFiles(new FileFilter(this) { // from class: com.kwad.sdk.crash.c.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f73011a;

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
                this.f73011a = this;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? file.getName().endsWith(".dump") : invokeL.booleanValue;
            }
        })) == null || listFiles.length <= 2) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(listFiles.length);
        a(listFiles, countDownLatch);
        try {
            countDownLatch.await(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public void b(File file) {
        File file2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, file) == null) || (file2 = f73002b) == null) {
            return;
        }
        if (!file2.exists()) {
            f73002b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f73002b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
