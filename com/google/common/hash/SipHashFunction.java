package com.google.common.hash;

import c.i.d.a.n;
import c.i.d.d.b;
import c.i.d.d.d;
import c.i.d.d.e;
import c.i.d.d.f;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public final class SipHashFunction extends b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final e SIP_HASH_24;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final int f70435c;

    /* renamed from: d  reason: collision with root package name */
    public final int f70436d;
    public final long k0;
    public final long k1;

    /* loaded from: classes10.dex */
    public static final class a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final int f70437d;

        /* renamed from: e  reason: collision with root package name */
        public final int f70438e;

        /* renamed from: f  reason: collision with root package name */
        public long f70439f;

        /* renamed from: g  reason: collision with root package name */
        public long f70440g;

        /* renamed from: h  reason: collision with root package name */
        public long f70441h;

        /* renamed from: i  reason: collision with root package name */
        public long f70442i;

        /* renamed from: j  reason: collision with root package name */
        public long f70443j;
        public long k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, int i3, long j2, long j3) {
            super(8);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70439f = 8317987319222330741L;
            this.f70440g = 7237128888997146477L;
            this.f70441h = 7816392313619706465L;
            this.f70442i = 8387220255154660723L;
            this.f70443j = 0L;
            this.k = 0L;
            this.f70437d = i2;
            this.f70438e = i3;
            this.f70439f = 8317987319222330741L ^ j2;
            this.f70440g = 7237128888997146477L ^ j3;
            this.f70441h = 7816392313619706465L ^ j2;
            this.f70442i = 8387220255154660723L ^ j3;
        }

        @Override // c.i.d.d.d
        public HashCode l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j2 = this.k ^ (this.f70443j << 56);
                this.k = j2;
                r(j2);
                this.f70441h ^= 255;
                s(this.f70438e);
                return HashCode.fromLong(((this.f70439f ^ this.f70440g) ^ this.f70441h) ^ this.f70442i);
            }
            return (HashCode) invokeV.objValue;
        }

        @Override // c.i.d.d.d
        public void o(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                this.f70443j += 8;
                r(byteBuffer.getLong());
            }
        }

        @Override // c.i.d.d.d
        public void p(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
                this.f70443j += byteBuffer.remaining();
                int i2 = 0;
                while (byteBuffer.hasRemaining()) {
                    this.k ^= (byteBuffer.get() & 255) << i2;
                    i2 += 8;
                }
            }
        }

        public final void r(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                this.f70442i ^= j2;
                s(this.f70437d);
                this.f70439f = j2 ^ this.f70439f;
            }
        }

        public final void s(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                for (int i3 = 0; i3 < i2; i3++) {
                    long j2 = this.f70439f;
                    long j3 = this.f70440g;
                    this.f70439f = j2 + j3;
                    this.f70441h += this.f70442i;
                    this.f70440g = Long.rotateLeft(j3, 13);
                    long rotateLeft = Long.rotateLeft(this.f70442i, 16);
                    this.f70442i = rotateLeft;
                    long j4 = this.f70440g;
                    long j5 = this.f70439f;
                    this.f70440g = j4 ^ j5;
                    this.f70442i = rotateLeft ^ this.f70441h;
                    long rotateLeft2 = Long.rotateLeft(j5, 32);
                    this.f70439f = rotateLeft2;
                    long j6 = this.f70441h;
                    long j7 = this.f70440g;
                    this.f70441h = j6 + j7;
                    this.f70439f = rotateLeft2 + this.f70442i;
                    this.f70440g = Long.rotateLeft(j7, 17);
                    long rotateLeft3 = Long.rotateLeft(this.f70442i, 21);
                    this.f70442i = rotateLeft3;
                    long j8 = this.f70440g;
                    long j9 = this.f70441h;
                    this.f70440g = j8 ^ j9;
                    this.f70442i = rotateLeft3 ^ this.f70439f;
                    this.f70441h = Long.rotateLeft(j9, 32);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639615020, "Lcom/google/common/hash/SipHashFunction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639615020, "Lcom/google/common/hash/SipHashFunction;");
                return;
            }
        }
        SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    }

    public SipHashFunction(int i2, int i3, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n.f(i2 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i2);
        n.f(i3 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i3);
        this.f70435c = i2;
        this.f70436d = i3;
        this.k0 = j2;
        this.k1 = j3;
    }

    public int bits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 64;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof SipHashFunction) {
                SipHashFunction sipHashFunction = (SipHashFunction) obj;
                return this.f70435c == sipHashFunction.f70435c && this.f70436d == sipHashFunction.f70436d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) ((((SipHashFunction.class.hashCode() ^ this.f70435c) ^ this.f70436d) ^ this.k0) ^ this.k1) : invokeV.intValue;
    }

    @Override // c.i.d.d.e
    public f newHasher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this.f70435c, this.f70436d, this.k0, this.k1) : (f) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "Hashing.sipHash" + this.f70435c + "" + this.f70436d + "(" + this.k0 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.k1 + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
