package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
@SuppressLint({"CI_StaticFieldLeak"})
/* loaded from: classes5.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final b f32329a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f32330b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f32331c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a f32332d;

    /* renamed from: e  reason: collision with root package name */
    public File f32333e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f32334f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1811773274, "Lcom/bytedance/sdk/openadsdk/preload/geckox/a/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1811773274, "Lcom/bytedance/sdk/openadsdk/preload/geckox/a/a/b;");
                return;
            }
        }
        f32329a = new d();
        f32330b = new f();
        f32331c = new e();
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

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, file, list) == null) {
            this.f32332d = aVar;
            this.f32333e = file;
            this.f32334f = list;
        }
    }
}
