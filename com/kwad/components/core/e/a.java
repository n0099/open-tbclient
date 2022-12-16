package com.kwad.components.core.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0597a {
        public static /* synthetic */ Interceptable $ic;
        public static final a Ez;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-133575772, "Lcom/kwad/components/core/e/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-133575772, "Lcom/kwad/components/core/e/a$a;");
                    return;
                }
            }
            Ez = new a((byte) 0);
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65538, this, context, j) == null) || (listFiles = ak(context).listFiles(new FileFilter(this) { // from class: com.kwad.components.core.e.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a Ey;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.Ey = this;
            }

            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                    String name = file.getName();
                    return name.startsWith("dynamic-") && name.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                }
                return invokeL.booleanValue;
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        long j2 = 0;
        for (File file : listFiles) {
            j2 = Math.max(j2, file.lastModified());
        }
        long min = Math.min(j, j2);
        for (File file2 : listFiles) {
            if (file2.exists() && file2.lastModified() < min) {
                file2.delete();
            }
        }
    }

    private void aj(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            g.schedule(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.kwad.components.core.e.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long Ex;
                public final /* synthetic */ a Ey;
                public final /* synthetic */ Context gC;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Long.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Ey = this;
                    this.gC = context;
                    this.Ex = r8;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.Ey.a(this.gC, this.Ex);
                        } catch (Throwable th) {
                            b.printStackTraceOnly(th);
                        }
                    }
                }
            }, 10L, TimeUnit.SECONDS);
        }
    }

    public static File ak(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? new File(context.getApplicationInfo().dataDir, "ksad_dynamic") : (File) invokeL.objValue;
    }

    public static a ng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? C0597a.Ez : (a) invokeV.objValue;
    }

    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            aj(context);
        }
    }
}
