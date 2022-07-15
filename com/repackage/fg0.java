package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.repackage.hg0;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class fg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern d;
    public static volatile fg0 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, gg0<?>> a;
    public final hg0 b;
    public final String c;

    /* loaded from: classes6.dex */
    public class a implements d<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(fg0 fg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg0Var};
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
        /* JADX DEBUG: Throwable added to exception handler: 'OutOfMemoryError', keep only Throwable */
        @Override // com.repackage.fg0.d
        /* renamed from: c */
        public Bitmap b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                if (bArr != null) {
                    try {
                        if (bArr.length != 0) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                            options.inPurgeable = true;
                            options.inInputShareable = true;
                            return BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                        }
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg0.d
        /* renamed from: d */
        public <D> Bitmap a(D d) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d)) == null) {
                if (d instanceof Bitmap) {
                    return (Bitmap) d;
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements hg0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ c b;
        public final /* synthetic */ fg0 c;

        public b(fg0 fg0Var, String str, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg0Var, str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fg0Var;
            this.a = str;
            this.b = cVar;
        }

        @Override // com.repackage.hg0.e
        public void a(String str, gg0<File> gg0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, gg0Var) == null) && this.a.equals(str)) {
                this.b.a();
                this.c.b.n(this);
            }
        }

        @Override // com.repackage.hg0.e
        public void b(String str, gg0<File> gg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gg0Var) == null) {
            }
        }

        @Override // com.repackage.hg0.e
        public void c(String str, gg0<File> gg0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, gg0Var) == null) && this.a.equals(str)) {
                this.b.b();
                this.c.b.n(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public interface d<T> {
        <D> T a(D d);

        T b(byte[] bArr);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755708926, "Lcom/repackage/fg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755708926, "Lcom/repackage/fg0;");
                return;
            }
        }
        d = Pattern.compile("[^a-zA-Z0-9]");
    }

    public fg0(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        File cacheDir = context.getCacheDir();
        this.c = (cacheDir.getPath() + "/nad/") + "nad_image_cache/";
        this.a = new LruCache<>(i);
        this.b = hg0.l(this.c, i2);
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.length() >= 160) {
                return t01.c(str, false);
            }
            return d.matcher(str).replaceAll("").trim();
        }
        return (String) invokeL.objValue;
    }

    public static fg0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (fg0.class) {
                    if (e == null) {
                        e = new fg0(hh0.b(), 6, 50000000);
                    }
                }
            }
            return e;
        }
        return (fg0) invokeV.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String b2 = b(str);
            return this.c + b2;
        }
        return (String) invokeL.objValue;
    }

    public gg0<?> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            gg0<?> g = g(str);
            return g != null ? g : f(str);
        }
        return (gg0) invokeL.objValue;
    }

    public final gg0<File> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.b.i(str) : (gg0) invokeL.objValue;
    }

    public final gg0<?> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.a.get(str) : (gg0) invokeL.objValue;
    }

    @Nullable
    public Bitmap h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? (Bitmap) i(str, new a(this)) : (Bitmap) invokeL.objValue;
    }

    public final <T> T i(String str, d<T> dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, dVar)) == null) {
            gg0<?> e2 = e(b(str));
            if (e2 != null) {
                if (File.class.equals(e2.c())) {
                    return dVar.b(e2.b());
                }
                if (Byte.TYPE.equals(e2.c())) {
                    return null;
                }
                return dVar.a(e2.a());
            }
            if (!this.b.e) {
                File file = new File(c(str));
                if (file.exists()) {
                    return dVar.b(new gg0(file).b());
                }
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public void j(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bitmap) == null) {
            k(str, new gg0<>(bitmap), true, null);
        }
    }

    public final void k(String str, gg0<?> gg0Var, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, gg0Var, Boolean.valueOf(z), cVar}) == null) {
            try {
                String b2 = b(str);
                if (z) {
                    this.a.put(b2, gg0Var);
                }
                File file = new File(this.b.j() + b2);
                if (cVar != null) {
                    this.b.e(new b(this, b2, cVar));
                }
                this.b.q(gg0Var.b(), new gg0<>(file));
            } catch (Throwable unused) {
            }
        }
    }
}
