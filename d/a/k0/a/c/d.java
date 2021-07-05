package d.a.k0.a.c;

import android.util.LruCache;
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
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes8.dex */
public class d extends LruCache<String, d.a.k0.a.c.c<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<e> f46013a;

    /* renamed from: b  reason: collision with root package name */
    public final String f46014b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<d.a.k0.a.c.c<File>, byte[]> f46015c;

    /* renamed from: d  reason: collision with root package name */
    public long f46016d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f46017e;

    /* renamed from: f  reason: collision with root package name */
    public int f46018f;

    /* renamed from: g  reason: collision with root package name */
    public long f46019g;

    /* loaded from: classes8.dex */
    public static class a extends d.a.k0.a.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46020g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f46021h;

        public a(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46020g = str;
            this.f46021h = dVar;
        }

        @Override // d.a.k0.a.l.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.f46020g);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f46021h.r(file.listFiles(), currentTimeMillis);
                    return null;
                } catch (Exception e2) {
                    this.f46021h.f46017e = true;
                    d.a.k0.a.k.b i2 = d.a.k0.a.k.b.i();
                    i2.a("Disk cache initialize failed for " + e2.getMessage());
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.k0.a.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f46022g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.a.c.c f46023h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f46024i;

        public b(d dVar, byte[] bArr, d.a.k0.a.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bArr, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46024i = dVar;
            this.f46022g = bArr;
            this.f46023h = cVar;
        }

        @Override // d.a.k0.a.l.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    d.a.k0.a.k.d.b(this.f46022g, (File) this.f46023h.a());
                    this.f46024i.put(((File) this.f46023h.a()).getName(), this.f46023h);
                    d.b(this.f46024i);
                    if (!this.f46024i.f46013a.isEmpty()) {
                        for (e eVar : this.f46024i.f46013a) {
                            eVar.c(((File) this.f46023h.a()).getName(), this.f46023h);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    d dVar = this.f46024i;
                    dVar.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.f46023h.a()).getName() + "\nStatus:" + this.f46024i.t());
                    this.f46024i.g();
                    return null;
                } catch (Throwable th) {
                    if (!this.f46024i.f46013a.isEmpty()) {
                        for (e eVar2 : this.f46024i.f46013a) {
                            eVar2.b(((File) this.f46023h.a()).getName(), this.f46023h);
                        }
                    }
                    d.a.k0.a.k.b i2 = d.a.k0.a.k.b.i();
                    i2.a("Failed to save file. " + th);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.k0.a.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.a.c.c f46025g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f46026h;

        public c(d dVar, d.a.k0.a.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46026h = dVar;
            this.f46025g = cVar;
        }

        @Override // d.a.k0.a.l.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.f46025g != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String name = ((File) this.f46025g.a()).getName();
                        d.c(this.f46026h);
                        this.f46025g.e();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        d dVar = this.f46026h;
                        dVar.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                    }
                    this.f46026h.g();
                    return null;
                } catch (Throwable th) {
                    d.a.k0.a.k.b i2 = d.a.k0.a.k.b.i();
                    i2.a("Failed to delete file. " + th);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* renamed from: d.a.k0.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0652d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0652d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) ? Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified())) : invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(String str, d.a.k0.a.c.c<File> cVar);

        void b(String str, d.a.k0.a.c.c<File> cVar);

        void c(String str, d.a.k0.a.c.c<File> cVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1205267338, "Ld/a/k0/a/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1205267338, "Ld/a/k0/a/c/d;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, String str) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46013a = new ArrayList();
        this.f46017e = false;
        this.f46018f = 0;
        this.f46019g = 2592000000L;
        this.f46014b = str;
        this.f46015c = new HashMap<>();
    }

    public static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f46018f;
        dVar.f46018f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f46018f;
        dVar.f46018f = i2 - 1;
        return i2;
    }

    public static d o(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i2)) == null) {
            d dVar = new d(i2, str);
            dVar.f46017e = false;
            d.a.k0.a.l.c.a().c(new a(str, dVar));
            return dVar;
        }
        return (d) invokeLI.objValue;
    }

    public void f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            this.f46013a.add(eVar);
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f46016d < this.f46019g) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.f46016d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    d.a.k0.a.c.c cVar = (d.a.k0.a.c.c) snapshot.get(str);
                    if (cVar.d(this.f46019g)) {
                        ((File) ((d.a.k0.a.c.c) super.remove(str)).a()).delete();
                        this.f46018f--;
                    } else if (((File) cVar.a()).lastModified() < this.f46016d) {
                        this.f46016d = ((File) cVar.a()).lastModified();
                    }
                }
                m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
            }
        }
    }

    public final void h(d.a.k0.a.c.c<File> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            d.a.k0.a.l.c.a().c(new c(this, cVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, d.a.k0.a.c.c<File> cVar, d.a.k0.a.c.c<File> cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, cVar, cVar2}) == null) {
            super.entryRemoved(z, str, cVar, cVar2);
            if (z && cVar != null) {
                h(cVar);
            }
            if (!z || this.f46013a.isEmpty()) {
                return;
            }
            for (e eVar : this.f46013a) {
                eVar.a(str, cVar);
            }
        }
    }

    public d.a.k0.a.c.c<File> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            d.a.k0.a.c.c<File> cVar = (d.a.k0.a.c.c) super.get(str);
            if (cVar != null) {
                try {
                    cVar.a().setLastModified(System.currentTimeMillis());
                    m("Fetch resource for " + str + ",\nStatus:" + t());
                } catch (Throwable th) {
                    d.a.k0.a.k.b i2 = d.a.k0.a.k.b.i();
                    i2.a("Failed to update file. " + th);
                }
            }
            return cVar;
        }
        return (d.a.k0.a.c.c) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f46014b : (String) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.maxSize() : invokeV.longValue;
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    public final synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                this.f46017e = true;
                if (this.f46015c != null) {
                    for (d.a.k0.a.c.c<File> cVar : this.f46015c.keySet()) {
                        v(cVar, this.f46015c.get(cVar));
                    }
                    this.f46015c.clear();
                    this.f46015c = null;
                }
            }
        }
    }

    public final void p(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, file) == null) && file.exists()) {
            super.put(str, new d.a.k0.a.c.c(file));
            this.f46018f++;
        }
    }

    public void q(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) && this.f46013a.contains(eVar)) {
            this.f46013a.remove(eVar);
        }
    }

    public final void r(File[] fileArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048588, this, fileArr, j) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new C0652d(this));
                if (priorityQueue.size() > 0) {
                    this.f46016d = ((File) priorityQueue.peek()).lastModified();
                } else {
                    this.f46016d = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file = (File) priorityQueue.poll();
                    p(file.getName(), file);
                }
            }
            m("Complete restore cache using " + (System.currentTimeMillis() - j) + "ms: ");
            n();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: s */
    public int sizeOf(String str, d.a.k0.a.c.c<File> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, cVar)) == null) {
            if (cVar == null) {
                return super.sizeOf(null, null);
            }
            return cVar.f();
        }
        return invokeLL.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int hitCount = hitCount() + missCount();
            return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f46018f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
        }
        return (String) invokeV.objValue;
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            synchronized (this) {
                super.trimToSize(i2);
            }
        }
    }

    public void u(byte[] bArr, d.a.k0.a.c.c<File> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, bArr, cVar) == null) || cVar == null) {
            return;
        }
        if (this.f46017e) {
            v(cVar, bArr);
        } else {
            this.f46015c.put(cVar, bArr);
        }
    }

    public final void v(d.a.k0.a.c.c<File> cVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, cVar, bArr) == null) {
            d.a.k0.a.l.c.a().c(new b(this, bArr, cVar));
        }
    }
}
