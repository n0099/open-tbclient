package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements com.kwad.sdk.pngencrypt.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65901a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65901a = z;
    }

    @Override // com.kwad.sdk.pngencrypt.g
    public final PngChunk a(d dVar, com.kwad.sdk.pngencrypt.k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, kVar)) == null) {
            PngChunk a2 = a(dVar.f65918c, kVar);
            if (a2 == null) {
                a2 = c(dVar.f65918c, kVar);
            }
            if (a2 == null) {
                a2 = b(dVar.f65918c, kVar);
            }
            a2.b(dVar);
            if (this.f65901a && dVar.f65919d != null) {
                a2.a(dVar);
            }
            return a2;
        }
        return (PngChunk) invokeLL.objValue;
    }

    public final PngChunk a(String str, com.kwad.sdk.pngencrypt.k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, kVar)) == null) {
            if (str.equals("IDAT")) {
                return new o(kVar);
            }
            if (str.equals("IHDR")) {
                return new q(kVar);
            }
            if (str.equals("PLTE")) {
                return new v(kVar);
            }
            if (str.equals("IEND")) {
                return new p(kVar);
            }
            if (str.equals("tEXt")) {
                return new ab(kVar);
            }
            if (str.equals("iTXt")) {
                return new r(kVar);
            }
            if (str.equals("zTXt")) {
                return new ag(kVar);
            }
            if (str.equals("bKGD")) {
                return new h(kVar);
            }
            if (str.equals("gAMA")) {
                return new l(kVar);
            }
            if (str.equals("pHYs")) {
                return new u(kVar);
            }
            if (str.equals("iCCP")) {
                return new n(kVar);
            }
            if (str.equals("tIME")) {
                return new ac(kVar);
            }
            if (str.equals("tRNS")) {
                return new ad(kVar);
            }
            if (str.equals("cHRM")) {
                return new i(kVar);
            }
            if (str.equals("sBIT")) {
                return new w(kVar);
            }
            if (str.equals("sRGB")) {
                return new y(kVar);
            }
            if (str.equals("hIST")) {
                return new m(kVar);
            }
            if (str.equals("sPLT")) {
                return new x(kVar);
            }
            if (str.equals("fdAT")) {
                return new k(kVar);
            }
            if (str.equals("acTL")) {
                return new g(kVar);
            }
            if (str.equals("fcTL")) {
                return new j(kVar);
            }
            return null;
        }
        return (PngChunk) invokeLL.objValue;
    }

    public final PngChunk b(String str, com.kwad.sdk.pngencrypt.k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, kVar)) == null) ? new af(str, kVar) : (PngChunk) invokeLL.objValue;
    }

    public PngChunk c(String str, com.kwad.sdk.pngencrypt.k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, kVar)) == null) {
            if (str.equals("oFFs")) {
                return new t(kVar);
            }
            if (str.equals("sTER")) {
                return new z(kVar);
            }
            return null;
        }
        return (PngChunk) invokeLL.objValue;
    }
}
