package com.repackage;

import android.util.LruCache;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes7.dex */
public class xf0 extends LruCache<String, wf0<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;
    public final String b;
    public HashMap<wf0<File>, byte[]> c;
    public long d;
    public volatile boolean e;
    public int f;
    public long g;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xf0 b;

        public a(String str, xf0 xf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, xf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = xf0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.b.o(file.listFiles(), currentTimeMillis);
                } catch (Exception unused) {
                    this.b.e = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ wf0 b;
        public final /* synthetic */ xf0 c;

        public b(xf0 xf0Var, byte[] bArr, wf0 wf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf0Var, bArr, wf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xf0Var;
            this.a = bArr;
            this.b = wf0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    System.currentTimeMillis();
                    b01.i(this.a, (File) this.b.a());
                    this.c.put(((File) this.b.a()).getName(), this.b);
                    xf0.b(this.c);
                    if (!this.c.a.isEmpty()) {
                        for (e eVar : this.c.a) {
                            eVar.c(((File) this.b.a()).getName(), this.b);
                        }
                    }
                    System.currentTimeMillis();
                    this.c.f();
                } catch (Throwable unused) {
                    if (this.c.a.isEmpty()) {
                        return;
                    }
                    for (e eVar2 : this.c.a) {
                        eVar2.a(((File) this.b.a()).getName(), this.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wf0 a;
        public final /* synthetic */ xf0 b;

        public c(xf0 xf0Var, wf0 wf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf0Var, wf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xf0Var;
            this.a = wf0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a != null) {
                        System.currentTimeMillis();
                        ((File) this.a.a()).getName();
                        xf0.c(this.b);
                        this.a.e();
                        System.currentTimeMillis();
                    }
                    this.b.f();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(xf0 xf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) ? Long.compare(file.lastModified(), file2.lastModified()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str, wf0<File> wf0Var);

        void b(String str, wf0<File> wf0Var);

        void c(String str, wf0<File> wf0Var);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755173649, "Lcom/repackage/xf0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755173649, "Lcom/repackage/xf0;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xf0(int i, String str) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.e = false;
        this.f = 0;
        this.g = 2592000000L;
        this.b = str;
        this.c = new HashMap<>();
    }

    public static /* synthetic */ int b(xf0 xf0Var) {
        int i = xf0Var.f;
        xf0Var.f = i + 1;
        return i;
    }

    public static /* synthetic */ int c(xf0 xf0Var) {
        int i = xf0Var.f;
        xf0Var.f = i - 1;
        return i;
    }

    public static xf0 l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            xf0 xf0Var = new xf0(i, str);
            xf0Var.e = false;
            py0.c(new a(str, xf0Var), "restore_cache_from_disk", 3);
            return xf0Var;
        }
        return (xf0) invokeLI.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || super.get(str) == null) {
            return;
        }
        g((wf0) super.remove(str));
    }

    public void e(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            gx0.b(this.a, eVar);
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.d < this.g) {
                    return;
                }
                System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    wf0 wf0Var = (wf0) snapshot.get(str);
                    if (wf0Var.d(this.g)) {
                        ((File) ((wf0) super.remove(str)).a()).delete();
                        this.f--;
                    } else if (((File) wf0Var.a()).lastModified() < this.d) {
                        this.d = ((File) wf0Var.a()).lastModified();
                    }
                }
                System.currentTimeMillis();
            }
        }
    }

    public final void g(wf0<File> wf0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wf0Var) == null) {
            py0.c(new c(this, wf0Var), "delete_disk_file_async", 3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: h */
    public void entryRemoved(boolean z, String str, wf0<File> wf0Var, wf0<File> wf0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, wf0Var, wf0Var2}) == null) {
            super.entryRemoved(z, str, wf0Var, wf0Var2);
            if (z && wf0Var != null) {
                g(wf0Var);
            }
            if (!z || this.a.isEmpty()) {
                return;
            }
            for (e eVar : this.a) {
                eVar.b(str, wf0Var);
            }
        }
    }

    @Nullable
    public wf0<File> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            wf0<File> wf0Var = (wf0) super.get(str);
            if (wf0Var != null) {
                try {
                    wf0Var.a().setLastModified(System.currentTimeMillis());
                } catch (Throwable unused) {
                }
            }
            return wf0Var;
        }
        return (wf0) invokeL.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.e = true;
                if (this.c != null) {
                    for (wf0<File> wf0Var : this.c.keySet()) {
                        r(wf0Var, this.c.get(wf0Var));
                    }
                    this.c.clear();
                    this.c = null;
                }
            }
        }
    }

    public final void m(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, file) == null) && file.exists()) {
            super.put(str, new wf0(file));
            this.f++;
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) && this.a.contains(eVar)) {
            this.a.remove(eVar);
        }
    }

    public final void o(File[] fileArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, fileArr, j) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new d(this));
                if (priorityQueue.size() > 0) {
                    File file = (File) priorityQueue.peek();
                    if (file != null) {
                        this.d = file.lastModified();
                    }
                } else {
                    this.d = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file2 = (File) priorityQueue.poll();
                    if (file2 != null) {
                        m(file2.getName(), file2);
                    }
                }
            }
            System.currentTimeMillis();
            k();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: p */
    public int sizeOf(String str, wf0<File> wf0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, wf0Var)) == null) {
            if (wf0Var == null) {
                return super.sizeOf(null, null);
            }
            return wf0Var.f();
        }
        return invokeLL.intValue;
    }

    public void q(byte[] bArr, wf0<File> wf0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, bArr, wf0Var) == null) || wf0Var == null) {
            return;
        }
        if (this.e) {
            r(wf0Var, bArr);
        } else {
            this.c.put(wf0Var, bArr);
        }
    }

    public boolean query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            wf0<File> i = i(str);
            return i != null && i.a().exists();
        }
        return invokeL.booleanValue;
    }

    public final void r(wf0<File> wf0Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, wf0Var, bArr) == null) {
            py0.c(new b(this, bArr, wf0Var), "store_cache_to_disk", 3);
        }
    }
}
