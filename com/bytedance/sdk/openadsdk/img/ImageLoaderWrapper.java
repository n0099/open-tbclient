package com.bytedance.sdk.openadsdk.img;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.image.IHttpClient;
import com.bytedance.sdk.component.image.IImageLoader;
import com.bytedance.sdk.component.image.ImageLoader;
import com.bytedance.sdk.component.image.LoadConfig;
import com.bytedance.sdk.component.image.b.c;
import com.bytedance.sdk.component.image.b.d;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.p;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ImageLoaderWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-178998728, "Lcom/bytedance/sdk/openadsdk/img/ImageLoaderWrapper$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-178998728, "Lcom/bytedance/sdk/openadsdk/img/ImageLoaderWrapper$a;");
                    return;
                }
            }
            a(o.a());
        }

        public static IImageLoader c(l lVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, lVar)) == null) ? a(ImageLoader.from(lVar.a()).width(lVar.b()).height(lVar.c()).key(lVar.g())) : (IImageLoader) invokeL.objValue;
        }

        public static byte[] d(l lVar) {
            InterceptResult invokeL;
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65546, null, lVar)) != null) {
                return (byte[]) invokeL.objValue;
            }
            InputStream cacheStream = ImageLoader.getCacheStream(lVar.a(), lVar.g());
            if (cacheStream == null) {
                return null;
            }
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = cacheStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            com.bytedance.sdk.component.image.c.c.a.a(cacheStream);
                            com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
                            return byteArray;
                        }
                    } catch (Exception unused) {
                        com.bytedance.sdk.component.image.c.c.a.a(cacheStream);
                        com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.bytedance.sdk.component.image.c.c.a.a(cacheStream);
                        com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        }

        public static IImageLoader b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? a(ImageLoader.from(str)) : (IImageLoader) invokeL.objValue;
        }

        public static void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
                ImageLoader.initialize(context, new LoadConfig.ConfigBuilder().threadPool(e.a()).httpClient(new IHttpClient() { // from class: com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    private Map<String, String> a(c cVar, ab abVar) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(65538, this, cVar, abVar)) == null) {
                            if (cVar.b()) {
                                s g2 = abVar.g();
                                HashMap hashMap = new HashMap();
                                int a2 = g2.a();
                                for (int i2 = 0; i2 < a2; i2++) {
                                    String a3 = g2.a(i2);
                                    String b2 = g2.b(i2);
                                    if (a3 != null) {
                                        hashMap.put(a3, b2);
                                    }
                                }
                                return hashMap;
                            }
                            return null;
                        }
                        return (Map) invokeLL.objValue;
                    }

                    @Override // com.bytedance.sdk.component.image.IHttpClient
                    public d call(c cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cVar)) == null) {
                            w wVar = new w();
                            z d2 = new z.a().a(cVar.a()).a().d();
                            ab abVar = null;
                            com.bytedance.sdk.component.image.b.e eVar = cVar.c() ? new com.bytedance.sdk.component.image.b.e() : null;
                            if (eVar != null) {
                                eVar.a(System.currentTimeMillis());
                            }
                            try {
                                abVar = wVar.a(d2).b();
                                if (eVar != null) {
                                    eVar.b(System.currentTimeMillis());
                                }
                                Map<String, String> a2 = a(cVar, abVar);
                                byte[] e2 = abVar.h().e();
                                if (eVar != null) {
                                    eVar.c(System.currentTimeMillis());
                                }
                                d dVar = new d(abVar.c(), e2, "", a2);
                                dVar.a(eVar);
                                return dVar;
                            } catch (Throwable th) {
                                try {
                                    return a(eVar, th);
                                } finally {
                                    com.bytedance.sdk.component.image.c.c.a.a(abVar);
                                }
                            }
                        }
                        return (d) invokeL.objValue;
                    }

                    private d a(com.bytedance.sdk.component.image.b.e eVar, Throwable th) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(65537, this, eVar, th)) == null) {
                            k.d("ImageLoaderWrapper", th.getMessage());
                            if (eVar != null) {
                                eVar.c(System.currentTimeMillis());
                            }
                            d dVar = new d(0, th, "net failed");
                            dVar.a(eVar);
                            return dVar;
                        }
                        return (d) invokeLL.objValue;
                    }
                }).build());
            }
        }

        public static InputStream b(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? ImageLoader.getCacheStream(str, str2) : (InputStream) invokeLL.objValue;
        }

        public static IImageLoader a(IImageLoader iImageLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iImageLoader)) == null) ? p.a() ? iImageLoader.track(new com.bytedance.sdk.openadsdk.img.a()) : iImageLoader : (IImageLoader) invokeL.objValue;
        }
    }

    public ImageLoaderWrapper() {
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

    public static InputStream a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? a.b(str, str2) : (InputStream) invokeLL.objValue;
    }

    public static IImageLoader from(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? a.b(str) : (IImageLoader) invokeL.objValue;
    }

    public static byte[] a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) ? a.d(lVar) : (byte[]) invokeL.objValue;
    }

    public static IImageLoader from(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lVar)) == null) ? a.c(lVar) : (IImageLoader) invokeL.objValue;
    }
}
