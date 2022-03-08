package com.dxmpay.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.imagemanager.a;
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
/* loaded from: classes7.dex */
public final class ImageLoader {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f52226b;

    /* renamed from: c  reason: collision with root package name */
    public static ImageLoader f52227c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Context f52228d;

    /* renamed from: e  reason: collision with root package name */
    public b f52229e;

    /* renamed from: f  reason: collision with root package name */
    public a f52230f;

    /* renamed from: g  reason: collision with root package name */
    public ImageProcessor f52231g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadPoolExecutor f52232h;

    /* loaded from: classes7.dex */
    public interface OnGetBitmapListener {
        boolean needCancel(String str, Object obj);

        void onError(String str, Object obj);

        void onGetBitmap(String str, Object obj, Bitmap bitmap);
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
        a = ApollonConstants.DEBUG;
        f52226b = ImageLoader.class.getSimpleName();
        f52227c = null;
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
        this.f52232h = null;
        Context applicationContext = context.getApplicationContext();
        this.f52228d = applicationContext;
        this.f52231g = new ImageProcessor(applicationContext);
        this.f52229e = new b();
        this.f52230f = new a(this.f52228d, "dxmpay/wallet/image_cache", new a.InterfaceC2048a(this) { // from class: com.dxmpay.apollon.imagemanager.ImageLoader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageLoader a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.dxmpay.apollon.imagemanager.a.InterfaceC2048a
            public List<File> a(File file) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                    if (file.exists() && file.isDirectory()) {
                        LinkedList linkedList = new LinkedList();
                        File[] listFiles = file.listFiles();
                        long currentTimeMillis = System.currentTimeMillis() - com.baidu.apollon.imagemanager.ImageLoader.f31112d;
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
        });
    }

    public static ImageLoader getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            boolean z = a;
            if (f52227c == null) {
                synchronized (ImageLoader.class) {
                    if (f52227c == null) {
                        f52227c = new ImageLoader(context.getApplicationContext());
                    }
                }
            }
            return f52227c;
        }
        return (ImageLoader) invokeL.objValue;
    }

    public void getBitmap(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048576, this, str, onGetBitmapListener, obj, i2) == null) && a(str)) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
            if (bitmapFromMemCache != null) {
                boolean z = a;
                onGetBitmapListener.onGetBitmap(str, obj, bitmapFromMemCache);
                return;
            }
            getBitmapFromDiskOrNet(str, onGetBitmapListener, obj, i2);
        }
    }

    public void getBitmapFromDiskOrNet(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, onGetBitmapListener, obj, i2) == null) {
            a(new Runnable(this, str, onGetBitmapListener, obj, i2) { // from class: com.dxmpay.apollon.imagemanager.ImageLoader.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ OnGetBitmapListener f52233b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Object f52234c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f52235d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ ImageLoader f52236e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, onGetBitmapListener, obj, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52236e = this;
                    this.a = str;
                    this.f52233b = onGetBitmapListener;
                    this.f52234c = obj;
                    this.f52235d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f52236e.a(this.a, this.f52233b, this.f52234c, this.f52235d)) {
                        return;
                    }
                    this.f52236e.b(this.a, this.f52233b, this.f52234c, this.f52235d);
                }
            });
        }
    }

    public Bitmap getBitmapFromMemCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = a;
            if (a(str)) {
                return this.f52229e.a(str);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public Bitmap getBitmapFromMemCacheOrDeskSynch(String str, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, str, obj, i2)) == null) {
            if (a(str)) {
                Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
                if (bitmapFromMemCache != null) {
                    boolean z = a;
                    return bitmapFromMemCache;
                }
                Bitmap a2 = a(str, obj, i2);
                if (a2 != null) {
                    boolean z2 = a;
                }
                return a2;
            }
            return null;
        }
        return (Bitmap) invokeLLI.objValue;
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, runnable) == null) {
            if (this.f52232h == null) {
                this.f52232h = new ThreadPoolExecutor(3, 6, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.dxmpay.apollon.imagemanager.ImageLoader.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ImageLoader a;

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
                        this.a = this;
                    }

                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable2)) == null) {
                            AtomicInteger atomicInteger = new AtomicInteger(1);
                            return new Thread(runnable2, "DxmImageLoader #" + atomicInteger.getAndIncrement());
                        }
                        return (Thread) invokeL.objValue;
                    }
                }, new ThreadPoolExecutor.DiscardOldestPolicy());
                if (ChannelUtils.isSpecailPackage()) {
                    this.f52232h.allowCoreThreadTimeOut(true);
                }
            }
            this.f52232h.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65544, this, str, onGetBitmapListener, obj, i2) == null) {
            if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
                boolean z = a;
                Context context = this.f52228d;
                RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), ApollonConstants.HTTP_REQUEST_TYPE_IMAGE_LOAD);
                restTemplate.setMessageConverter(new com.dxmpay.apollon.restnet.converter.a());
                Bitmap bitmap = null;
                try {
                    bArr = (byte[]) restTemplate.a(str, null, "utf-8", byte[].class);
                } catch (RestRuntimeException e2) {
                    e2.printStackTrace();
                    bArr = null;
                }
                if (bArr == null) {
                    return;
                }
                this.f52230f.a(str, bArr);
                File a2 = this.f52230f.a(str);
                if (a2 == null || !a2.exists()) {
                    return;
                }
                try {
                    bitmap = this.f52231g.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                }
                if (bitmap != null) {
                    boolean z2 = a;
                    this.f52229e.a(str, bitmap);
                    this.f52229e.a();
                    if (onGetBitmapListener != null) {
                        onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        InterceptResult invokeLLLI;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65542, this, str, onGetBitmapListener, obj, i2)) == null) {
            if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
                boolean z = a;
                File a2 = this.f52230f.a(str);
                if (a2 == null || !a2.exists()) {
                    return false;
                }
                boolean z2 = a;
                try {
                    bitmap = this.f52231g.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    boolean z3 = a;
                    this.f52229e.a(str, bitmap);
                    this.f52229e.a();
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

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
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

    private Bitmap a(String str, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, this, str, obj, i2)) == null) {
            boolean z = a;
            File a2 = this.f52230f.a(str);
            Bitmap bitmap = null;
            if (a2 != null && a2.exists()) {
                boolean z2 = a;
                try {
                    bitmap = this.f52231g.decode(a2, i2);
                } catch (FileNotFoundException unused) {
                }
                if (bitmap != null) {
                    boolean z3 = a;
                    this.f52229e.a(str, bitmap);
                    this.f52229e.a();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLLI.objValue;
    }
}
