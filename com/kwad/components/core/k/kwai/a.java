package com.kwad.components.core.k.kwai;

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
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final b EI;
    @NonNull
    public final com.kwad.components.core.k.b HN;
    @Nullable
    public List<String> HO;
    public boolean HP;
    public boolean HQ;
    @Nullable
    public d HR;

    /* renamed from: com.kwad.components.core.k.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0575a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b EI;
        public com.kwad.components.core.k.b HN;
        public boolean HP;
        public boolean HQ;

        public C0575a() {
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

        public final C0575a a(@NonNull com.kwad.components.core.k.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.HN = bVar;
                return this;
            }
            return (C0575a) invokeL.objValue;
        }

        public final C0575a aw(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.HP = true;
                return this;
            }
            return (C0575a) invokeZ.objValue;
        }

        public final C0575a ax(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.HQ = z;
                return this;
            }
            return (C0575a) invokeZ.objValue;
        }

        public final C0575a c(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
                this.EI = bVar;
                return this;
            }
            return (C0575a) invokeL.objValue;
        }

        public final a oo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (com.kwad.components.ad.d.a.aw.booleanValue() && (this.EI == null || this.HN == null)) {
                    throw new IllegalStateException("AdRequestParams build Illegal");
                }
                return new a(this, (byte) 0);
            }
            return (a) invokeV.objValue;
        }
    }

    public a(C0575a c0575a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0575a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.EI = c0575a.EI;
        this.HN = c0575a.HN;
        this.HP = c0575a.HP;
        this.HQ = c0575a.HQ;
    }

    public /* synthetic */ a(C0575a c0575a, byte b) {
        this(c0575a);
    }

    public static void a(@NonNull a aVar, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aVar, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            aVar.HN.a(i, str, z);
        }
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, aVar, adResultData, z) == null) {
            boolean isAdResultDataEmpty = adResultData.isAdResultDataEmpty();
            com.kwad.components.core.k.b bVar = aVar.HN;
            if (!isAdResultDataEmpty) {
                bVar.a(adResultData, z);
                return;
            }
            f fVar = f.Yd;
            bVar.a(fVar.errorCode, fVar.Qd, z);
        }
    }

    public final int getAdNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SceneImpl sceneImpl = this.EI.HS;
            if (sceneImpl != null) {
                return sceneImpl.getAdNum();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public final int getAdStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SceneImpl sceneImpl = this.EI.HS;
            if (sceneImpl != null) {
                return sceneImpl.adStyle;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final long getPosId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SceneImpl sceneImpl = this.EI.HS;
            if (sceneImpl != null) {
                return sceneImpl.getPosId();
            }
            return -1L;
        }
        return invokeV.longValue;
    }
}
