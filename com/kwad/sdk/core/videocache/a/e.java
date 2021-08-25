package com.kwad.sdk.core.videocache.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f72151a;

    /* loaded from: classes10.dex */
    public class a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f72152a;

        /* renamed from: b  reason: collision with root package name */
        public final File f72153b;

        public a(e eVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72152a = eVar;
            this.f72153b = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f72152a.b(this.f72153b);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    public e() {
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
        this.f72151a = com.kwad.sdk.core.i.b.b();
    }

    private void a(List<File> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            long b2 = b(list);
            int size = list.size();
            for (File file : list) {
                if (!a(file, b2, size)) {
                    long length = file.length();
                    if (file.delete()) {
                        size--;
                        b2 -= length;
                    } else {
                        com.kwad.sdk.core.d.a.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                    }
                }
            }
        }
    }

    private long b(List<File> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
            long j2 = 0;
            for (File file : list) {
                j2 += file.length();
            }
            return j2;
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, file) == null) {
            d.c(file);
            a(d.b(file.getParentFile()));
        }
    }

    @Override // com.kwad.sdk.core.videocache.a.a
    public void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
            this.f72151a.submit(new a(this, file));
        }
    }

    public abstract boolean a(File file, long j2, int i2);
}
