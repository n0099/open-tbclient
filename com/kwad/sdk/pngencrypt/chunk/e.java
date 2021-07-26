package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<PngChunk> f35985a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.k f35986b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35987c;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35985a = new ArrayList();
        this.f35987c = false;
        this.f35986b = kVar;
    }

    public static List<PngChunk> a(List<PngChunk> list, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, list, str, str2)) == null) ? str2 == null ? b.a(list, new c(str) { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f35988a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35988a = str;
            }

            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, pngChunk)) == null) ? pngChunk.f35955a.equals(this.f35988a) : invokeL.booleanValue;
            }
        }) : b.a(list, new c(str, str2) { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f35989a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f35990b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35989a = str;
                this.f35990b = str2;
            }

            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, pngChunk)) == null) {
                    if (pngChunk.f35955a.equals(this.f35989a)) {
                        if (!(pngChunk instanceof ae) || ((ae) pngChunk).c().equals(this.f35990b)) {
                            return !(pngChunk instanceof x) || ((x) pngChunk).c().equals(this.f35990b);
                        }
                        return false;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        }) : (List) invokeLLL.objValue;
    }

    public List<PngChunk> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35985a : (List) invokeV.objValue;
    }

    public List<? extends PngChunk> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? a(this.f35985a, str, str2) : (List) invokeLL.objValue;
    }

    public void a(PngChunk pngChunk, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, pngChunk, i2) == null) {
            pngChunk.a(i2);
            this.f35985a.add(pngChunk);
            if (pngChunk.f35955a.equals("PLTE")) {
                this.f35987c = true;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "ChunkList: read: " + this.f35985a.size();
        }
        return (String) invokeV.objValue;
    }
}
