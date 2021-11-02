package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<PngChunk> f65924a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.k f65925b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65926c;

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
        this.f65924a = new ArrayList();
        this.f65926c = false;
        this.f65925b = kVar;
    }

    public static List<PngChunk> a(List<PngChunk> list, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, list, str, str2)) == null) ? str2 == null ? b.a(list, new c(str) { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f65927a;

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
                this.f65927a = str;
            }

            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, pngChunk)) == null) ? pngChunk.f65894a.equals(this.f65927a) : invokeL.booleanValue;
            }
        }) : b.a(list, new c(str, str2) { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f65928a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f65929b;

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
                this.f65928a = str;
                this.f65929b = str2;
            }

            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public boolean a(PngChunk pngChunk) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, pngChunk)) == null) {
                    if (pngChunk.f65894a.equals(this.f65928a)) {
                        if (!(pngChunk instanceof ae) || ((ae) pngChunk).c().equals(this.f65929b)) {
                            return !(pngChunk instanceof x) || ((x) pngChunk).c().equals(this.f65929b);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65924a : (List) invokeV.objValue;
    }

    public List<? extends PngChunk> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? a(this.f65924a, str, str2) : (List) invokeLL.objValue;
    }

    public void a(PngChunk pngChunk, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, pngChunk, i2) == null) {
            pngChunk.a(i2);
            this.f65924a.add(pngChunk);
            if (pngChunk.f65894a.equals("PLTE")) {
                this.f65926c = true;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "ChunkList: read: " + this.f65924a.size();
        }
        return (String) invokeV.objValue;
    }
}
