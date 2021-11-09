package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f68973a = 8;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f68974b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public a<Integer, Bitmap> f68975c;

    /* loaded from: classes2.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f68979a;

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
            this.f68979a = i2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) ? size() > this.f68979a : invokeL.booleanValue;
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
        this.f68975c = null;
        int i4 = f68973a;
        this.f68975c = new a<>(i4, i4 / 2);
    }

    public static ByteArrayOutputStream b(InputStream inputStream) throws IOException {
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

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f68974b == null) {
                synchronized (c.class) {
                    if (f68974b == null) {
                        f68974b = new c();
                    }
                }
            }
            return f68974b;
        }
        return (c) invokeV.objValue;
    }

    public Bitmap a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f68975c.get(Integer.valueOf(i2)) : (Bitmap) invokeI.objValue;
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && !TextUtils.isEmpty(str) && a(i2) == null) {
            com.ss.android.socialbase.downloader.downloader.c.m().submit(new Runnable(this, str, i2) { // from class: com.ss.android.socialbase.appdownloader.e.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68976a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f68977b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ c f68978c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68978c = this;
                    this.f68976a = str;
                    this.f68977b = i2;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    int i3 = 4;
                    i3 = 4;
                    i3 = 4;
                    i3 = 4;
                    i3 = 4;
                    try {
                        try {
                            i a2 = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, this.f68976a, null);
                            if (a2 == null) {
                                f.a(null, null, null, null);
                                return;
                            }
                            inputStream = a2.a();
                            try {
                                byteArrayOutputStream = c.b(inputStream);
                                try {
                                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                    try {
                                        byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                        try {
                                            BitmapFactory.Options options = new BitmapFactory.Options();
                                            options.inJustDecodeBounds = true;
                                            BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                            int a3 = com.ss.android.socialbase.appdownloader.c.a(com.ss.android.socialbase.downloader.downloader.c.N(), 44.0f);
                                            options.inSampleSize = c.a(a3, a3, options);
                                            options.inJustDecodeBounds = false;
                                            this.f68978c.f68975c.put(Integer.valueOf(this.f68977b), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                            f.a(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                                        } catch (Exception e3) {
                                            e2 = e3;
                                            e2.printStackTrace();
                                            i3 = new Closeable[]{inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                                            f.a((Closeable[]) i3);
                                        }
                                    } catch (Exception e4) {
                                        byteArrayInputStream2 = null;
                                        e2 = e4;
                                    } catch (Throwable th2) {
                                        byteArrayInputStream2 = null;
                                        th = th2;
                                        Closeable[] closeableArr = new Closeable[i3];
                                        closeableArr[0] = inputStream;
                                        closeableArr[1] = byteArrayOutputStream;
                                        closeableArr[2] = byteArrayInputStream;
                                        closeableArr[3] = byteArrayInputStream2;
                                        f.a(closeableArr);
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
            });
        }
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
}
