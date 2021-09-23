package com.dxmpay.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.a.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.ChannelUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class ImageLoader {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f69639f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f69640g;

    /* renamed from: h  reason: collision with root package name */
    public static ImageLoader f69641h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f69642a;

    /* renamed from: b  reason: collision with root package name */
    public com.dxmpay.apollon.imagemanager.b f69643b;

    /* renamed from: c  reason: collision with root package name */
    public c.f.a.e.a f69644c;

    /* renamed from: d  reason: collision with root package name */
    public ImageProcessor f69645d;

    /* renamed from: e  reason: collision with root package name */
    public ThreadPoolExecutor f69646e;

    /* loaded from: classes9.dex */
    public interface OnGetBitmapListener {
        boolean needCancel(String str, Object obj);

        void onError(String str, Object obj);

        void onGetBitmap(String str, Object obj, Bitmap bitmap);
    }

    /* loaded from: classes9.dex */
    public class a implements a.InterfaceC1466a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ImageLoader imageLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.f.a.e.a.InterfaceC1466a
        public List<File> a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                if (file.exists() && file.isDirectory()) {
                    LinkedList linkedList = new LinkedList();
                    File[] listFiles = file.listFiles();
                    long currentTimeMillis = System.currentTimeMillis() - com.baidu.apollon.imagemanager.ImageLoader.f37991d;
                    for (File file2 : listFiles) {
                        if (file2.lastModified() < currentTimeMillis) {
                            linkedList.add(file2);
                        }
                    }
                    return linkedList;
                }
                return null;
            }
            return (List) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ImageLoader imageLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                AtomicInteger atomicInteger = new AtomicInteger(1);
                return new Thread(runnable, "DxmImageLoader #" + atomicInteger.getAndIncrement());
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f69647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OnGetBitmapListener f69648f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f69649g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f69650h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ImageLoader f69651i;

        public c(ImageLoader imageLoader, String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageLoader, str, onGetBitmapListener, obj, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69651i = imageLoader;
            this.f69647e = str;
            this.f69648f = onGetBitmapListener;
            this.f69649g = obj;
            this.f69650h = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f69651i.e(this.f69647e, this.f69648f, this.f69649g, this.f69650h)) {
                return;
            }
            this.f69651i.g(this.f69647e, this.f69648f, this.f69649g, this.f69650h);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1681575412, "Lcom/dxmpay/apollon/imagemanager/ImageLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1681575412, "Lcom/dxmpay/apollon/imagemanager/ImageLoader;");
                return;
            }
        }
        f69639f = ApollonConstants.DEBUG;
        f69640g = ImageLoader.class.getSimpleName();
        f69641h = null;
    }

    public ImageLoader(Context context) {
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
        this.f69646e = null;
        Context applicationContext = context.getApplicationContext();
        this.f69642a = applicationContext;
        this.f69645d = new ImageProcessor(applicationContext);
        this.f69643b = new com.dxmpay.apollon.imagemanager.b();
        this.f69644c = new c.f.a.e.a(this.f69642a, "dxmpay/wallet/image_cache", new a(this));
    }

    public static ImageLoader getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            boolean z = f69639f;
            if (f69641h == null) {
                synchronized (ImageLoader.class) {
                    if (f69641h == null) {
                        f69641h = new ImageLoader(context.getApplicationContext());
                    }
                }
            }
            return f69641h;
        }
        return (ImageLoader) invokeL.objValue;
    }

    public final Bitmap a(String str, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, str, obj, i2)) == null) {
            boolean z = f69639f;
            File a2 = this.f69644c.a(str);
            Bitmap bitmap = null;
            if (a2 != null && a2.exists()) {
                boolean z2 = f69639f;
                try {
                    bitmap = this.f69645d.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                }
                if (bitmap != null) {
                    boolean z3 = f69639f;
                    this.f69643b.e(str, bitmap);
                    this.f69643b.d();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public final void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            if (this.f69646e == null) {
                this.f69646e = new ThreadPoolExecutor(3, 6, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(this), new ThreadPoolExecutor.DiscardOldestPolicy());
                if (ChannelUtils.isSpecailPackage()) {
                    this.f69646e.allowCoreThreadTimeOut(true);
                }
            }
            this.f69646e.execute(runnable);
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(str.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        InterceptResult invokeLLLI;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, str, onGetBitmapListener, obj, i2)) == null) {
            if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
                boolean z = f69639f;
                File a2 = this.f69644c.a(str);
                if (a2 == null || !a2.exists()) {
                    return false;
                }
                boolean z2 = f69639f;
                try {
                    bitmap = this.f69645d.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    boolean z3 = f69639f;
                    this.f69643b.e(str, bitmap);
                    this.f69643b.d();
                    if (onGetBitmapListener != null) {
                        onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        return invokeLLLI.booleanValue;
    }

    public final void g(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, str, onGetBitmapListener, obj, i2) == null) {
            if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
                boolean z = f69639f;
                Context context = this.f69642a;
                RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), ApollonConstants.HTTP_REQUEST_TYPE_IMAGE_LOAD);
                restTemplate.setMessageConverter(new c.f.a.g.b.a());
                Bitmap bitmap = null;
                try {
                    bArr = (byte[]) restTemplate.d(str, null, "utf-8", byte[].class);
                } catch (RestRuntimeException e2) {
                    e2.printStackTrace();
                    bArr = null;
                }
                if (bArr == null) {
                    return;
                }
                this.f69644c.d(str, bArr);
                File a2 = this.f69644c.a(str);
                if (a2 == null || !a2.exists()) {
                    return;
                }
                try {
                    bitmap = this.f69645d.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                }
                if (bitmap != null) {
                    boolean z2 = f69639f;
                    this.f69643b.e(str, bitmap);
                    this.f69643b.d();
                    if (onGetBitmapListener != null) {
                        onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                    }
                }
            }
        }
    }

    public void getBitmap(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048581, this, str, onGetBitmapListener, obj, i2) == null) && d(str)) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
            if (bitmapFromMemCache != null) {
                boolean z = f69639f;
                onGetBitmapListener.onGetBitmap(str, obj, bitmapFromMemCache);
                return;
            }
            getBitmapFromDiskOrNet(str, onGetBitmapListener, obj, i2);
        }
    }

    public void getBitmapFromDiskOrNet(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, str, onGetBitmapListener, obj, i2) == null) {
            b(new c(this, str, onGetBitmapListener, obj, i2));
        }
    }

    public Bitmap getBitmapFromMemCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            boolean z = f69639f;
            if (d(str)) {
                return this.f69643b.a(str);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public Bitmap getBitmapFromMemCacheOrDeskSynch(String str, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj, i2)) == null) {
            if (d(str)) {
                Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
                if (bitmapFromMemCache != null) {
                    boolean z = f69639f;
                    return bitmapFromMemCache;
                }
                Bitmap a2 = a(str, obj, i2);
                if (a2 != null) {
                    boolean z2 = f69639f;
                }
                return a2;
            }
            return null;
        }
        return (Bitmap) invokeLLI.objValue;
    }
}
