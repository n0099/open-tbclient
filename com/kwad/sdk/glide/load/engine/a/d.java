package com.kwad.sdk.glide.load.engine.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes7.dex */
public class d implements a.InterfaceC0464a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f37968a;

    /* renamed from: b  reason: collision with root package name */
    public final a f37969b;

    /* loaded from: classes7.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37968a = j;
        this.f37969b = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.InterfaceC0464a
    public com.kwad.sdk.glide.load.engine.a.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            File a2 = this.f37969b.a();
            if (a2 == null) {
                return null;
            }
            if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
                return e.a(a2, this.f37968a);
            }
            return null;
        }
        return (com.kwad.sdk.glide.load.engine.a.a) invokeV.objValue;
    }
}
