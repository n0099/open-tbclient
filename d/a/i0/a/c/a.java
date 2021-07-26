package d.a.i0.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.cache.CacheEngine;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.i0.a.c.d;
import d.a.i0.a.k.i;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f42919g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f42920h = 30000000;

    /* renamed from: i  reason: collision with root package name */
    public static int f42921i = 50000000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, d.a.i0.a.c.c<?>> f42922a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.i0.a.c.d f42923b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.i0.a.c.d f42924c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.a.i0.a.c.d> f42925d;

    /* renamed from: e  reason: collision with root package name */
    public final String f42926e;

    /* renamed from: f  reason: collision with root package name */
    public final String f42927f;

    /* renamed from: d.a.i0.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0603a implements d<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0603a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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
        @Override // d.a.i0.a.c.a.d
        /* renamed from: a */
        public Bitmap parseFromBytes(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                if (bArr == null) {
                    return null;
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    return BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                } catch (OutOfMemoryError unused) {
                    d.a.i0.a.k.b.i().h(CacheEngine.TAG, "图片请求失败，OOM");
                    return null;
                } catch (Throwable unused2) {
                    d.a.i0.a.k.b.i().h(CacheEngine.TAG, "图片请求失败，解析异常");
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.c.a.d
        /* renamed from: b */
        public <D> Bitmap rawGet(D d2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2)) == null) {
                if (d2 instanceof Bitmap) {
                    return (Bitmap) d2;
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42928a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f42929b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.c.d f42930c;

        public b(a aVar, String str, c cVar, d.a.i0.a.c.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42928a = str;
            this.f42929b = cVar;
            this.f42930c = dVar;
        }

        @Override // d.a.i0.a.c.d.e
        public void a(String str, d.a.i0.a.c.c<File> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            }
        }

        @Override // d.a.i0.a.c.d.e
        public void b(String str, d.a.i0.a.c.c<File> cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) && this.f42928a.equals(str)) {
                this.f42929b.onCacheFailed();
                this.f42930c.q(this);
            }
        }

        @Override // d.a.i0.a.c.d.e
        public void c(String str, d.a.i0.a.c.c<File> cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) && this.f42928a.equals(str)) {
                this.f42929b.onCacheComplete();
                this.f42930c.q(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onCacheComplete();

        void onCacheFailed();
    }

    /* loaded from: classes7.dex */
    public interface d<T> {
        T parseFromBytes(byte[] bArr);

        <D> T rawGet(D d2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1885325801, "Ld/a/i0/a/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1885325801, "Ld/a/i0/a/c/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42922a = new LruCache<>(6);
        String d2 = i.d(context);
        this.f42926e = d2 + MaterialLoader.IMAGE_CACHE_PATH;
        this.f42927f = d2 + MaterialLoader.VIDEO_CACHE_PATH;
        this.f42923b = d.a.i0.a.c.d.o(this.f42926e, f42920h);
        this.f42924c = d.a.i0.a.c.d.o(this.f42927f, f42921i);
        this.f42925d = new ConcurrentHashMap();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim() : (String) invokeL.objValue;
    }

    public static a e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f42919g == null) {
                synchronized (a.class) {
                    if (f42919g == null && context != null) {
                        f42919g = new a(context.getApplicationContext());
                    }
                }
            }
            return f42919g;
        }
        return (a) invokeL.objValue;
    }

    public final String b(String str, d.a.i0.a.c.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, dVar)) == null) {
            String a2 = a(str);
            return dVar.k() + a2;
        }
        return (String) invokeLL.objValue;
    }

    public final d.a.i0.a.c.d c(MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, materialCacheType)) == null) {
            if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
                return this.f42924c;
            }
            return this.f42923b;
        }
        return (d.a.i0.a.c.d) invokeL.objValue;
    }

    public String d(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, materialCacheType)) == null) {
            String a2 = a(str);
            if (f(str, materialCacheType)) {
                return c(materialCacheType).k() + a2;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public boolean f(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, materialCacheType)) == null) {
            boolean z = g(a(str), materialCacheType) != null;
            d.a.i0.a.c.d c2 = c(materialCacheType);
            return (z || c2.f42937e) ? z : new File(b(str, c2)).exists();
        }
        return invokeLL.booleanValue;
    }

    public d.a.i0.a.c.c<?> g(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        d.a.i0.a.c.c<?> i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, materialCacheType)) == null) ? (materialCacheType != MaterialLoader.MaterialCacheType.PICTURE || (i2 = i(str)) == null) ? h(str, materialCacheType) : i2 : (d.a.i0.a.c.c) invokeLL.objValue;
    }

    public final d.a.i0.a.c.c<File> h(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, materialCacheType)) == null) ? c(materialCacheType).j(str) : (d.a.i0.a.c.c) invokeLL.objValue;
    }

    public final d.a.i0.a.c.c<?> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.f42922a.get(str) : (d.a.i0.a.c.c) invokeL.objValue;
    }

    public Bitmap j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? (Bitmap) k(str, MaterialLoader.MaterialCacheType.PICTURE, new C0603a(this)) : (Bitmap) invokeL.objValue;
    }

    public final <T> T k(String str, MaterialLoader.MaterialCacheType materialCacheType, d<T> dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, materialCacheType, dVar)) == null) {
            d.a.i0.a.c.c<?> g2 = g(a(str), materialCacheType);
            if (g2 != null) {
                if (File.class.equals(g2.c())) {
                    return dVar.parseFromBytes(g2.b());
                }
                if (Byte.TYPE.equals(g2.c())) {
                    return null;
                }
                return dVar.rawGet(g2.a());
            }
            if (!c(materialCacheType).f42937e) {
                File file = new File(b(str, c(materialCacheType)));
                if (file.exists()) {
                    return dVar.parseFromBytes(new d.a.i0.a.c.c(file).b());
                }
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public void l(String str, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, str, bitmap, z) == null) {
            m(str, new d.a.i0.a.c.c<>(bitmap), this.f42923b, z, null);
        }
    }

    public final void m(String str, d.a.i0.a.c.c<?> cVar, d.a.i0.a.c.d dVar, boolean z, c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, cVar, dVar, Boolean.valueOf(z), cVar2}) == null) {
            try {
                String a2 = a(str);
                if (z) {
                    this.f42922a.put(a2, cVar);
                }
                File file = new File(dVar.k() + a2);
                if (cVar2 != null) {
                    dVar.f(new b(this, a2, cVar2, dVar));
                }
                dVar.u(cVar.b(), new d.a.i0.a.c.c<>(file));
            } catch (Throwable th) {
                d.a.i0.a.k.b.i().c("Failed to cache resource.", th);
            }
        }
    }

    public void n(String str, byte[] bArr, MaterialLoader.MaterialCacheType materialCacheType, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, bArr, materialCacheType, Boolean.valueOf(z), cVar}) == null) {
            d.a.i0.a.c.c<?> cVar2 = new d.a.i0.a.c.c<>(bArr);
            d.a.i0.a.c.d dVar = this.f42923b;
            if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
                dVar = this.f42924c;
            }
            m(str, cVar2, dVar, z, cVar);
        }
    }

    public void o(String str, byte[] bArr, String str2, int i2, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, bArr, str2, Integer.valueOf(i2), Boolean.valueOf(z), cVar}) == null) {
            d.a.i0.a.c.c<?> cVar2 = new d.a.i0.a.c.c<>(bArr);
            d.a.i0.a.c.d dVar = this.f42925d.get(str2);
            if (dVar == null) {
                dVar = d.a.i0.a.c.d.o(str2, i2);
                this.f42925d.put(str2, dVar);
            } else if (dVar.l() != i2) {
                dVar.trimToSize(i2);
            }
            m(str, cVar2, dVar, z, cVar);
        }
    }
}
