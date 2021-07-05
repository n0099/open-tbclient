package com.kwad.sdk.emotion.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.emotion.c f37153a;

    /* renamed from: b  reason: collision with root package name */
    public final EmotionPackage f37154b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f37155c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f37156d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f37157e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f37158f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37159g;

    public b(EmotionPackage emotionPackage, com.kwad.sdk.emotion.c cVar, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {emotionPackage, cVar, runnable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37155c = new AtomicInteger(0);
        this.f37156d = new AtomicInteger(0);
        this.f37157e = new Object();
        this.f37153a = cVar;
        this.f37154b = emotionPackage;
        this.f37158f = runnable;
        this.f37159g = true;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                this.f37158f.run();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.emotion.a.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (z.a(this.f37154b, "未成功初始化emoji package但调用了get总数.") == null) {
                return 0;
            }
            z.a(this.f37154b.emotions, "未成功初始化emoji package但调用了get总数.");
            return this.f37154b.emotions.size();
        }
        return invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f37155c.incrementAndGet() < a() || this.f37156d.get() < a() || !this.f37159g) {
            return;
        }
        d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f37156d.incrementAndGet() < a() || this.f37155c.get() < a() || !this.f37159g) {
            return;
        }
        d();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f37159g) {
            synchronized (this.f37157e) {
                if (this.f37159g) {
                    if (this.f37153a != null) {
                        this.f37153a.a(this.f37154b);
                    }
                    this.f37159g = false;
                    f();
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f37159g) {
            synchronized (this.f37157e) {
                if (this.f37159g) {
                    if (this.f37153a != null) {
                        this.f37153a.a(this.f37154b, new IllegalStateException("download all cdn fail."));
                    }
                    this.f37159g = false;
                    f();
                }
            }
        }
    }
}
