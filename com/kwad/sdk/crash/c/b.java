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
/* loaded from: classes2.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f65446a;

    /* renamed from: b  reason: collision with root package name */
    public static File f65447b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public e f65448c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f65449d;

    /* renamed from: e  reason: collision with root package name */
    public File f65450e;

    /* renamed from: f  reason: collision with root package name */
    public File f65451f;

    /* renamed from: g  reason: collision with root package name */
    public File f65452g;

    /* renamed from: h  reason: collision with root package name */
    public File f65453h;

    /* renamed from: i  reason: collision with root package name */
    public File f65454i;
    public com.kwad.sdk.crash.report.c j;

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
        f65446a = UUID.randomUUID().toString();
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
        this.f65449d = new AtomicInteger();
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            f65447b = file;
            if (file.exists()) {
                return;
            }
            f65447b.mkdirs();
        }
    }

    public final com.kwad.sdk.crash.report.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (com.kwad.sdk.crash.report.c) invokeV.objValue;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, eVar, cVar) == null) {
            this.f65450e = file;
            if (!file.exists()) {
                this.f65450e.mkdirs();
            }
            File file2 = this.f65450e;
            this.f65451f = new File(file2, f65446a + "-" + this.f65449d + ".dump");
            File file3 = this.f65450e;
            this.f65452g = new File(file3, f65446a + "-" + this.f65449d + ".log");
            File file4 = this.f65450e;
            this.f65453h = new File(file4, f65446a + "-" + this.f65449d + ".jtrace");
            this.f65448c = eVar;
            this.j = cVar;
        }
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (listFiles = this.f65450e.listFiles(new FileFilter(this) { // from class: com.kwad.sdk.crash.c.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f65455a;

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
                this.f65455a = this;
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, file) == null) || (file2 = f65447b) == null) {
            return;
        }
        if (!file2.exists()) {
            f65447b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f65447b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
