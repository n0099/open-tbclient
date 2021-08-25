package com.bytedance.sdk.openadsdk.preload.geckox.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.f.a.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f68565a;

    /* renamed from: b  reason: collision with root package name */
    public String f68566b;

    /* renamed from: c  reason: collision with root package name */
    public volatile File f68567c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Long f68568d;

    /* renamed from: e  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.preload.geckox.f.a.a f68569e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f68570f;

    public a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68570f = new AtomicBoolean(false);
        this.f68565a = str2;
        this.f68566b = str3;
    }

    private synchronized com.bytedance.sdk.openadsdk.preload.geckox.f.a.a c(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            synchronized (this) {
                if (this.f68569e != null) {
                    return this.f68569e;
                }
                File d2 = d(str);
                if (d2 != null) {
                    File file = new File(d2, "res.macv");
                    File file2 = new File(d2, UriUtil.LOCAL_RESOURCE_SCHEME);
                    if (file2.exists() && file2.isDirectory()) {
                        this.f68569e = new c(d2);
                    } else if (file.exists() && file.isFile()) {
                        this.f68569e = new com.bytedance.sdk.openadsdk.preload.geckox.f.a.b(d2);
                    } else {
                        throw new RuntimeException("can not find res, dir:" + d2.getAbsolutePath());
                    }
                    return this.f68569e;
                }
                throw new FileNotFoundException("channel no exist，channel:" + str);
            }
        }
        return (com.bytedance.sdk.openadsdk.preload.geckox.f.a.a) invokeL.objValue;
    }

    private synchronized File d(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            synchronized (this) {
                if (this.f68567c != null) {
                    return this.f68567c;
                }
                if (this.f68568d == null || this.f68568d.longValue() != -1) {
                    com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.f68565a + File.separator + str + File.separator + "select.lock");
                    if (this.f68568d == null) {
                        this.f68568d = k.a(new File(this.f68565a, str));
                    }
                    if (this.f68568d == null) {
                        this.f68568d = -1L;
                        a2.a();
                        return null;
                    }
                    String str2 = this.f68565a;
                    File file = new File(str2, File.separator + str + File.separator + this.f68568d + File.separator + "using.lock");
                    this.f68567c = file.getParentFile();
                    com.bytedance.sdk.openadsdk.preload.geckox.g.c.a(file.getAbsolutePath());
                    File file2 = this.f68567c;
                    a2.a();
                    return file2;
                }
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public final InputStream a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? c(this.f68566b).a(a(this.f68566b, str)) : (InputStream) invokeL.objValue;
    }

    public final boolean b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? c(this.f68566b).b(a(this.f68566b, str)) : invokeL.booleanValue;
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) ? str2.substring(str.length() + 1) : (String) invokeLL.objValue;
    }

    private void b() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.f68565a + File.separator + this.f68566b + File.separator + "select.lock");
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-file-lock", "channel version loader clean");
            try {
                if (this.f68567c == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.preload.geckox.g.c.b(this.f68567c.getAbsolutePath() + File.separator + "using.lock");
                a2.a();
                com.bytedance.sdk.openadsdk.preload.geckox.a.c.a(this.f68565a + File.separator + this.f68566b);
            } finally {
                a2.a();
            }
        }
    }

    public void a() throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f68570f.getAndSet(true)) {
            return;
        }
        b();
    }
}
