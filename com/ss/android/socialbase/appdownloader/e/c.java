package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.a.d;
import c.p.a.e.b.g.e;
import c.p.a.e.b.l.f;
import c.p.a.e.b.o.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f75556b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f75557c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a<Integer, Bitmap> f75558a;

    /* loaded from: classes10.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f75559a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, int i3) {
            super(i3, 0.75f, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue(), ((Boolean) objArr2[2]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75559a = i2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) ? size() > this.f75559a : invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f75560e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f75561f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f75562g;

        public b(c cVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75562g = cVar;
            this.f75560e = str;
            this.f75561f = i2;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00b8 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x000a */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable[]] */
        @Override // java.lang.Runnable
        public void run() {
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayInputStream byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream2;
            Throwable th;
            InputStream inputStream;
            Exception e2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            int i2 = 4;
            i2 = 4;
            i2 = 4;
            i2 = 4;
            i2 = 4;
            try {
                try {
                    k B = e.B(true, 0, this.f75560e, null);
                    if (B == null) {
                        f.E(null, null, null, null);
                        return;
                    }
                    inputStream = B.a();
                    try {
                        byteArrayOutputStream = c.g(inputStream);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                    int c2 = d.c(e.n(), 44.0f);
                                    options.inSampleSize = c.a(c2, c2, options);
                                    options.inJustDecodeBounds = false;
                                    this.f75562g.f75558a.put(Integer.valueOf(this.f75561f), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                    f.E(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                                } catch (Exception e3) {
                                    e2 = e3;
                                    e2.printStackTrace();
                                    i2 = new Closeable[]{inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                                    f.E(i2);
                                }
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e2 = e4;
                            } catch (Throwable th2) {
                                byteArrayInputStream2 = null;
                                th = th2;
                                Closeable[] closeableArr = new Closeable[i2];
                                closeableArr[0] = inputStream;
                                closeableArr[1] = byteArrayOutputStream;
                                closeableArr[2] = byteArrayInputStream;
                                closeableArr[3] = byteArrayInputStream2;
                                f.E(closeableArr);
                                throw th;
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream2 = null;
                            e2 = e5;
                            byteArrayInputStream = null;
                        } catch (Throwable th3) {
                            byteArrayInputStream2 = null;
                            th = th3;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e6) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e6;
                        byteArrayOutputStream = null;
                    } catch (Throwable th4) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th4;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e7) {
                byteArrayOutputStream = null;
                byteArrayInputStream = null;
                byteArrayInputStream2 = null;
                e2 = e7;
                inputStream = null;
            } catch (Throwable th6) {
                byteArrayOutputStream = null;
                byteArrayInputStream = null;
                byteArrayInputStream2 = null;
                th = th6;
                inputStream = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1108220553, "Lcom/ss/android/socialbase/appdownloader/e/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1108220553, "Lcom/ss/android/socialbase/appdownloader/e/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f75558a = null;
        int i4 = f75556b;
        this.f75558a = new a<>(i4, i4 / 2);
    }

    public static int a(int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, options)) == null) {
            if (options.outWidth > i2 || options.outHeight > i3) {
                return Math.min(Math.round(options.outWidth / i2), Math.round(options.outHeight / i3));
            }
            return 1;
        }
        return invokeIIL.intValue;
    }

    public static c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f75557c == null) {
                synchronized (c.class) {
                    if (f75557c == null) {
                        f75557c = new c();
                    }
                }
            }
            return f75557c;
        }
        return (c) invokeV.objValue;
    }

    public static ByteArrayOutputStream g(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, inputStream)) != null) {
            return (ByteArrayOutputStream) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }

    public Bitmap b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f75558a.get(Integer.valueOf(i2)) : (Bitmap) invokeI.objValue;
    }

    public void f(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && !TextUtils.isEmpty(str) && b(i2) == null) {
            e.B0().submit(new b(this, str, i2));
        }
    }
}
