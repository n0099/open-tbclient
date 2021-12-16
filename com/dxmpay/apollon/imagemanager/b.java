package com.dxmpay.apollon.imagemanager;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static ConcurrentHashMap<String, SoftReference<Bitmap>> a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Bitmap> f55682b;

    /* renamed from: c  reason: collision with root package name */
    public static HandlerThread f55683c;

    /* renamed from: d  reason: collision with root package name */
    public static Handler f55684d;

    /* renamed from: e  reason: collision with root package name */
    public static Runnable f55685e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.i();
            }
        }
    }

    /* renamed from: com.dxmpay.apollon.imagemanager.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2031b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1932663746, "Lcom/dxmpay/apollon/imagemanager/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1932663746, "Lcom/dxmpay/apollon/imagemanager/b$b;");
                    return;
                }
            }
            HandlerThread unused = b.f55683c = new HandlerThread("sb_imagecache_loop", 10);
            b.f55683c.start();
            Handler unused2 = b.f55684d = new Handler(b.f55683c.getLooper());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1217652224, "Lcom/dxmpay/apollon/imagemanager/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1217652224, "Lcom/dxmpay/apollon/imagemanager/b;");
                return;
            }
        }
        a = new ConcurrentHashMap<>(7);
        f55682b = new LinkedHashMap<String, Bitmap>(7, 0.75f, true) { // from class: com.dxmpay.apollon.imagemanager.ImageMemoryCache$1
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 1;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10, r11);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(r9), Float.valueOf(r10), Boolean.valueOf(r11)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue(), ((Boolean) objArr2[2]).booleanValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
                InterceptResult invokeL;
                ConcurrentHashMap concurrentHashMap;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, entry)) == null) {
                    if (size() > 15) {
                        concurrentHashMap = b.a;
                        concurrentHashMap.put(entry.getKey(), new SoftReference(entry.getValue()));
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        };
        f55685e = new a();
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
            }
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (f55682b) {
                for (Map.Entry<String, Bitmap> entry : f55682b.entrySet()) {
                    a.put(entry.getKey(), new SoftReference<>(entry.getValue()));
                }
                f55682b.clear();
            }
            LinkedList linkedList = new LinkedList();
            for (Map.Entry<String, SoftReference<Bitmap>> entry2 : a.entrySet()) {
                if (entry2.getValue().get() == null) {
                    linkedList.add(entry2.getKey());
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                a.remove((String) it.next());
            }
        }
    }

    public Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (f55682b) {
                Bitmap bitmap = f55682b.get(str);
                if (bitmap != null) {
                    return bitmap;
                }
                SoftReference<Bitmap> softReference = a.get(str);
                if (softReference != null) {
                    Bitmap bitmap2 = softReference.get();
                    if (bitmap2 != null) {
                        e(str, bitmap2);
                        return bitmap2;
                    }
                    a.remove(str);
                    return null;
                }
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f55684d == null) {
            }
            Handler handler = f55684d;
            if (handler != null) {
                handler.removeCallbacks(f55685e);
                f55684d.postDelayed(f55685e, 10000L);
            }
        }
    }

    public void e(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bitmap) == null) || bitmap == null) {
            return;
        }
        synchronized (f55682b) {
            f55682b.put(str, bitmap);
        }
    }
}
