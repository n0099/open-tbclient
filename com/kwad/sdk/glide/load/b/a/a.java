package com.kwad.sdk.glide.load.b.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.a.j;
import com.kwad.sdk.glide.load.b.g;
import com.kwad.sdk.glide.load.b.m;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.r;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class a implements n<g, InputStream> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Integer> f37821a;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final m<g, g> f37822b;

    /* renamed from: com.kwad.sdk.glide.load.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0459a implements o<g, InputStream> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final m<g, g> f37823a;

        public C0459a() {
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
            this.f37823a = new m<>(500L);
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<g, InputStream> a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) ? new a(this.f37823a) : (n) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(426737241, "Lcom/kwad/sdk/glide/load/b/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(426737241, "Lcom/kwad/sdk/glide/load/b/a/a;");
                return;
            }
        }
        f37821a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((m) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public a(@Nullable m<g, g> mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37822b = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<InputStream> a(@NonNull g gVar, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            m<g, g> mVar = this.f37822b;
            if (mVar != null) {
                g a2 = mVar.a(gVar, 0, 0);
                if (a2 == null) {
                    this.f37822b.a(gVar, 0, 0, gVar);
                } else {
                    gVar = a2;
                }
            }
            return new n.a<>(gVar, new j(gVar, ((Integer) eVar.a(f37821a)).intValue()));
        }
        return (n.a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }
}
