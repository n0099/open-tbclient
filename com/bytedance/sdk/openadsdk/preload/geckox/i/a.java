package com.bytedance.sdk.openadsdk.preload.geckox.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.aa;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.v;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public w f69078a;

    /* renamed from: b  reason: collision with root package name */
    public w f69079b;

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
                return;
            }
        }
        this.f69078a = new w.a().a(10L, TimeUnit.SECONDS).b(10L, TimeUnit.SECONDS).c(10L, TimeUnit.SECONDS).a();
        this.f69079b = new w.a().a(10L, TimeUnit.SECONDS).b(30L, TimeUnit.SECONDS).c(30L, TimeUnit.SECONDS).a();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.i.b
    public c a(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            ab b2 = this.f69078a.a(new z.a().a(str).a(aa.a(v.a("application/json; charset=utf-8"), str2)).d()).b();
            return new c(a(b2.g()), b2.c() == 200 ? b2.h().f() : null, b2.c(), b2.e());
        }
        return (c) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.i.b
    public void a(String str, long j2, com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.b bVar) throws Exception {
        Exception e2;
        int i2;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), bVar}) != null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                ab b2 = this.f69079b.a(new z.a().a().a(str).d()).b();
                i2 = b2.c();
                try {
                    bufferedInputStream = new BufferedInputStream(b2.h().c());
                } catch (Exception e3) {
                    e2 = e3;
                }
            } catch (Exception e4) {
                e2 = e4;
                i2 = 0;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read != -1) {
                    bVar.write(bArr, 0, read);
                } else {
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream);
                    return;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            bufferedInputStream2 = bufferedInputStream;
            throw new RuntimeException("downloadFile failed, code: " + i2 + ", url:" + str + ", caused by:" + e2.getMessage(), e2);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(bufferedInputStream2);
            throw th;
        }
    }

    private Map<String, String> a(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, sVar)) == null) {
            if (sVar == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str : sVar.b()) {
                hashMap.put(str, sVar.a(str));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
