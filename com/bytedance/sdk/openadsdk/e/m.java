package com.bytedance.sdk.openadsdk.e;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.j.c.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class m extends b<c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f67445a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67446b;

    public m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67445a = new AtomicBoolean(false);
        this.f67446b = true;
        this.f67446b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.e.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67445a.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.c.a.a(this.f67446b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.e.b
    public void a(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (!this.f67445a.get()) {
                a();
            }
            if (this.f67445a.get()) {
                com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a(), this.f67446b);
            }
        }
    }
}
