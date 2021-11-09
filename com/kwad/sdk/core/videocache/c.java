package com.kwad.sdk.core.videocache;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final File f65139a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.c f65140b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.a f65141c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.d.b f65142d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.b.b f65143e;

    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.b bVar, com.kwad.sdk.core.videocache.b.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, cVar, aVar, bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65139a = file;
        this.f65140b = cVar;
        this.f65141c = aVar;
        this.f65142d = bVar;
        this.f65143e = bVar2;
    }

    public File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new File(this.f65139a, this.f65140b.a(str)) : (File) invokeL.objValue;
    }
}
