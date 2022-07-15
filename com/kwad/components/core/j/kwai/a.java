package com.kwad.components.core.j.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final b a;
    @NonNull
    public final com.kwad.components.core.j.b b;
    @Nullable
    public final List<String> c;
    public boolean d;
    public boolean e;
    @Nullable
    public d f;

    /* renamed from: com.kwad.components.core.j.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0512a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b a;
        public com.kwad.components.core.j.b b;
        public List<String> c;
        public boolean d;
        public boolean e;

        public C0512a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final C0512a a(@NonNull com.kwad.components.core.j.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.b = bVar;
                return this;
            }
            return (C0512a) invokeL.objValue;
        }

        public final C0512a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.a = bVar;
                return this;
            }
            return (C0512a) invokeL.objValue;
        }

        public final C0512a a(@Nullable List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                this.c = list;
                return this;
            }
            return (C0512a) invokeL.objValue;
        }

        public final C0512a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.d = true;
                return this;
            }
            return (C0512a) invokeZ.objValue;
        }

        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (com.kwad.components.ad.d.a.a.booleanValue() && (this.a == null || this.b == null)) {
                    throw new IllegalStateException("AdRequestParams build Illegal");
                }
                return new a(this, (byte) 0);
            }
            return (a) invokeV.objValue;
        }

        public final C0512a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.e = z;
                return this;
            }
            return (C0512a) invokeZ.objValue;
        }
    }

    public a(C0512a c0512a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0512a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c0512a.a;
        this.b = c0512a.b;
        this.c = c0512a.c;
        this.d = c0512a.d;
        this.e = c0512a.e;
    }

    public /* synthetic */ a(C0512a c0512a, byte b) {
        this(c0512a);
    }

    public static void a(@NonNull a aVar, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aVar, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            aVar.b.a(i, str, z);
        }
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, aVar, adResultData, z) == null) {
            boolean isAdResultDataEmpty = adResultData.isAdResultDataEmpty();
            com.kwad.components.core.j.b bVar = aVar.b;
            if (!isAdResultDataEmpty) {
                bVar.a(adResultData, z);
                return;
            }
            f fVar = f.f;
            bVar.a(fVar.p, fVar.q, z);
        }
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SceneImpl sceneImpl = this.a.a;
            if (sceneImpl != null) {
                return sceneImpl.getPosId();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SceneImpl sceneImpl = this.a.a;
            if (sceneImpl != null) {
                return sceneImpl.getAdNum();
            }
            return 1;
        }
        return invokeV.intValue;
    }
}
