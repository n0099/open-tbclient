package com.google.common.hash;

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
import d.f.d.a.n;
import d.f.d.d.b;
import d.f.d.d.d;
import d.f.d.d.e;
import d.f.d.d.f;
import java.io.Serializable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class SipHashFunction extends b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final e SIP_HASH_24;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final int f33407c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33408d;
    public final long k0;
    public final long k1;

    /* loaded from: classes7.dex */
    public static final class a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final int f33409d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33410e;

        /* renamed from: f  reason: collision with root package name */
        public long f33411f;

        /* renamed from: g  reason: collision with root package name */
        public long f33412g;

        /* renamed from: h  reason: collision with root package name */
        public long f33413h;

        /* renamed from: i  reason: collision with root package name */
        public long f33414i;
        public long j;
        public long k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, int i3, long j, long j2) {
            super(8);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)};
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
            this.f33411f = 8317987319222330741L;
            this.f33412g = 7237128888997146477L;
            this.f33413h = 7816392313619706465L;
            this.f33414i = 8387220255154660723L;
            this.j = 0L;
            this.k = 0L;
            this.f33409d = i2;
            this.f33410e = i3;
            this.f33411f = 8317987319222330741L ^ j;
            this.f33412g = 7237128888997146477L ^ j2;
            this.f33413h = 7816392313619706465L ^ j;
            this.f33414i = 8387220255154660723L ^ j2;
        }

        @Override // d.f.d.d.d
        public HashCode l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j = this.k ^ (this.j << 56);
                this.k = j;
                r(j);
                this.f33413h ^= 255;
                s(this.f33410e);
                return HashCode.fromLong(((this.f33411f ^ this.f33412g) ^ this.f33413h) ^ this.f33414i);
            }
            return (HashCode) invokeV.objValue;
        }

        @Override // d.f.d.d.d
        public void o(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                this.j += 8;
                r(byteBuffer.getLong());
            }
        }

        @Override // d.f.d.d.d
        public void p(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
                this.j += byteBuffer.remaining();
                int i2 = 0;
                while (byteBuffer.hasRemaining()) {
                    this.k ^= (byteBuffer.get() & 255) << i2;
                    i2 += 8;
                }
            }
        }

        public final void r(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                this.f33414i ^= j;
                s(this.f33409d);
                this.f33411f = j ^ this.f33411f;
            }
        }

        public final void s(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                for (int i3 = 0; i3 < i2; i3++) {
                    long j = this.f33411f;
                    long j2 = this.f33412g;
                    this.f33411f = j + j2;
                    this.f33413h += this.f33414i;
                    this.f33412g = Long.rotateLeft(j2, 13);
                    long rotateLeft = Long.rotateLeft(this.f33414i, 16);
                    this.f33414i = rotateLeft;
                    long j3 = this.f33412g;
                    long j4 = this.f33411f;
                    this.f33412g = j3 ^ j4;
                    this.f33414i = rotateLeft ^ this.f33413h;
                    long rotateLeft2 = Long.rotateLeft(j4, 32);
                    this.f33411f = rotateLeft2;
                    long j5 = this.f33413h;
                    long j6 = this.f33412g;
                    this.f33413h = j5 + j6;
                    this.f33411f = rotateLeft2 + this.f33414i;
                    this.f33412g = Long.rotateLeft(j6, 17);
                    long rotateLeft3 = Long.rotateLeft(this.f33414i, 21);
                    this.f33414i = rotateLeft3;
                    long j7 = this.f33412g;
                    long j8 = this.f33413h;
                    this.f33412g = j7 ^ j8;
                    this.f33414i = rotateLeft3 ^ this.f33411f;
                    this.f33413h = Long.rotateLeft(j8, 32);
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

    public SipHashFunction(int i2, int i3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)};
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
        this.f33407c = i2;
        this.f33408d = i3;
        this.k0 = j;
        this.k1 = j2;
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
                return this.f33407c == sipHashFunction.f33407c && this.f33408d == sipHashFunction.f33408d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) ((((SipHashFunction.class.hashCode() ^ this.f33407c) ^ this.f33408d) ^ this.k0) ^ this.k1) : invokeV.intValue;
    }

    @Override // d.f.d.d.e
    public f newHasher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this.f33407c, this.f33408d, this.k0, this.k1) : (f) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "Hashing.sipHash" + this.f33407c + "" + this.f33408d + "(" + this.k0 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.k1 + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
