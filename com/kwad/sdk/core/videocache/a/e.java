package com.kwad.sdk.core.videocache.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f36660a;

    /* loaded from: classes7.dex */
    public class a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f36661a;

        /* renamed from: b  reason: collision with root package name */
        public final File f36662b;

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
            this.f36661a = eVar;
            this.f36662b = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f36661a.b(this.f36662b);
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
        this.f36660a = Executors.newSingleThreadExecutor();
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
                        com.kwad.sdk.core.d.a.d("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                    }
                }
            }
        }
    }

    private long b(List<File> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
            long j = 0;
            for (File file : list) {
                j += file.length();
            }
            return j;
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, file) == null) {
            d.c(file);
            a(d.b(file.getParentFile()));
        }
    }

    @Override // com.kwad.sdk.core.videocache.a.a
    public void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
            this.f36660a.submit(new a(this, file));
        }
    }

    public abstract boolean a(File file, long j, int i2);
}
