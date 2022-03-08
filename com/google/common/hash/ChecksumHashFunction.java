package com.google.common.hash;

import c.i.c.a.n;
import c.i.c.d.f;
import c.i.c.d.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.zip.Checksum;
/* loaded from: classes7.dex */
public final class ChecksumHashFunction extends c.i.c.d.b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bits;
    public final g<? extends Checksum> checksumSupplier;
    public final String toString;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class b extends c.i.c.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Checksum f53460b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChecksumHashFunction f53461c;

        public /* synthetic */ b(ChecksumHashFunction checksumHashFunction, Checksum checksum, a aVar) {
            this(checksumHashFunction, checksum);
        }

        @Override // c.i.c.d.f
        public HashCode e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long value = this.f53460b.getValue();
                if (this.f53461c.bits == 32) {
                    return HashCode.fromInt((int) value);
                }
                return HashCode.fromLong(value);
            }
            return (HashCode) invokeV.objValue;
        }

        @Override // c.i.c.d.a
        public void update(byte b2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2) == null) {
                this.f53460b.update(b2);
            }
        }

        public b(ChecksumHashFunction checksumHashFunction, Checksum checksum) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {checksumHashFunction, checksum};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53461c = checksumHashFunction;
            n.p(checksum);
            this.f53460b = checksum;
        }

        @Override // c.i.c.d.a
        public void update(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) {
                this.f53460b.update(bArr, i2, i3);
            }
        }
    }

    public ChecksumHashFunction(g<? extends Checksum> gVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(gVar);
        this.checksumSupplier = gVar;
        n.f(i2 == 32 || i2 == 64, "bits (%s) must be either 32 or 64", i2);
        this.bits = i2;
        n.p(str);
        this.toString = str;
    }

    public int bits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bits : invokeV.intValue;
    }

    @Override // c.i.c.d.e
    public f newHasher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this, this.checksumSupplier.get(), null) : (f) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.toString : (String) invokeV.objValue;
    }
}
