package com.bytedance.sdk.openadsdk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f68372a;

    /* renamed from: b  reason: collision with root package name */
    public String f68373b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f68374c;

    /* renamed from: d  reason: collision with root package name */
    public String f68375d;

    public b(Context context, String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68372a = new HashMap();
        this.f68374c = new AtomicBoolean(false);
        if (!TextUtils.isEmpty(str)) {
            this.f68373b = str;
            if (file == null) {
                File filesDir = context.getFilesDir();
                this.f68375d = new File(filesDir, "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
                return;
            }
            this.f68375d = new File(file, str).getAbsolutePath();
            return;
        }
        throw new RuntimeException("access key empty");
    }

    private a c(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            int indexOf = str.indexOf("/");
            if (indexOf == -1) {
                new RuntimeException("缺少channel：" + str);
            }
            String substring = str.substring(0, indexOf);
            synchronized (this.f68372a) {
                aVar = this.f68372a.get(substring);
                if (aVar == null) {
                    aVar = new a(this.f68373b, this.f68375d, substring);
                    this.f68372a.put(substring, aVar);
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public InputStream a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!this.f68374c.get()) {
                if (!TextUtils.isEmpty(str)) {
                    return c(str.trim()).a(str);
                }
                throw new RuntimeException("relativePath empty");
            }
            throw new RuntimeException("released");
        }
        return (InputStream) invokeL.objValue;
    }

    public boolean b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!this.f68374c.get()) {
                if (!TextUtils.isEmpty(str)) {
                    return c(str.trim()).b(str);
                }
                throw new RuntimeException("relativePath empty");
            }
            throw new RuntimeException("released");
        }
        return invokeL.booleanValue;
    }

    private void b() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this.f68372a) {
                for (a aVar : this.f68372a.values()) {
                    aVar.a();
                }
                this.f68372a.clear();
            }
        }
    }

    public void a() throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f68374c.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("Loader", "release version res loader");
        b();
    }
}
