package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class PngChunk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f66806a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f66807b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f66808c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f66809d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.k f66810e;

    /* renamed from: f  reason: collision with root package name */
    public d f66811f;

    /* renamed from: g  reason: collision with root package name */
    public int f66812g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66813h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ChunkOrderingConstraint {
        public static final /* synthetic */ ChunkOrderingConstraint[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ChunkOrderingConstraint AFTER_IDAT;
        public static final ChunkOrderingConstraint AFTER_PLTE_BEFORE_IDAT;
        public static final ChunkOrderingConstraint AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        public static final ChunkOrderingConstraint BEFORE_IDAT;
        public static final ChunkOrderingConstraint BEFORE_PLTE_AND_IDAT;
        public static final ChunkOrderingConstraint NA;
        public static final ChunkOrderingConstraint NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1276416317, "Lcom/kwad/sdk/pngencrypt/chunk/PngChunk$ChunkOrderingConstraint;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1276416317, "Lcom/kwad/sdk/pngencrypt/chunk/PngChunk$ChunkOrderingConstraint;");
                    return;
                }
            }
            NONE = new ChunkOrderingConstraint("NONE", 0);
            BEFORE_PLTE_AND_IDAT = new ChunkOrderingConstraint("BEFORE_PLTE_AND_IDAT", 1);
            AFTER_PLTE_BEFORE_IDAT = new ChunkOrderingConstraint("AFTER_PLTE_BEFORE_IDAT", 2);
            AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED = new ChunkOrderingConstraint("AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED", 3);
            BEFORE_IDAT = new ChunkOrderingConstraint("BEFORE_IDAT", 4);
            AFTER_IDAT = new ChunkOrderingConstraint("AFTER_IDAT", 5);
            ChunkOrderingConstraint chunkOrderingConstraint = new ChunkOrderingConstraint(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA, 6);
            NA = chunkOrderingConstraint;
            $VALUES = new ChunkOrderingConstraint[]{NONE, BEFORE_PLTE_AND_IDAT, AFTER_PLTE_BEFORE_IDAT, AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED, BEFORE_IDAT, AFTER_IDAT, chunkOrderingConstraint};
        }

        public ChunkOrderingConstraint(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ChunkOrderingConstraint valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ChunkOrderingConstraint) Enum.valueOf(ChunkOrderingConstraint.class, str) : (ChunkOrderingConstraint) invokeL.objValue;
        }

        public static ChunkOrderingConstraint[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ChunkOrderingConstraint[]) $VALUES.clone() : (ChunkOrderingConstraint[]) invokeV.objValue;
        }

        public boolean isOk(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                if (this == NONE) {
                    return true;
                }
                if (this == BEFORE_IDAT) {
                    return i2 < 4;
                } else if (this == BEFORE_PLTE_AND_IDAT) {
                    return i2 < 2;
                } else if (this != AFTER_PLTE_BEFORE_IDAT) {
                    return this == AFTER_IDAT && i2 > 4;
                } else {
                    if (z) {
                        if (i2 < 4) {
                            return true;
                        }
                    } else if (i2 < 4 && i2 > 2) {
                        return true;
                    }
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        public boolean mustGoAfterIDAT() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this == AFTER_IDAT : invokeV.booleanValue;
        }

        public boolean mustGoAfterPLTE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED : invokeV.booleanValue;
        }

        public boolean mustGoBeforeIDAT() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT : invokeV.booleanValue;
        }

        public boolean mustGoBeforePLTE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this == BEFORE_PLTE_AND_IDAT : invokeV.booleanValue;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66813h = false;
        this.f66812g = -1;
        this.f66806a = str;
        this.f66810e = kVar;
        this.f66807b = b.b(str);
        this.f66808c = b.c(str);
        this.f66809d = b.d(str);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = this.f66811f;
            if (dVar != null) {
                return dVar.f66829a;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f66812g = i2;
        }
    }

    public abstract void a(d dVar);

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d dVar = this.f66811f;
            if (dVar != null) {
                return dVar.c();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f66811f = dVar;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "chunk id= " + this.f66806a + " (len=" + a() + " offset=" + b() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
