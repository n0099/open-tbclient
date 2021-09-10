package com.kwad.sdk.pngencrypt.chunk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f73140a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f73141b;

    /* renamed from: c  reason: collision with root package name */
    public final String f73142c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f73143d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f73144e;

    /* renamed from: f  reason: collision with root package name */
    public long f73145f;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f73146g;

    public d(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73143d = null;
        this.f73145f = 0L;
        this.f73144e = new byte[4];
        this.f73140a = i2;
        this.f73142c = str;
        this.f73141b = b.a(str);
        for (int i5 = 0; i5 < 4; i5++) {
            byte[] bArr = this.f73141b;
            if (bArr[i5] < 65 || bArr[i5] > 122 || (bArr[i5] > 90 && bArr[i5] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            byte[] bArr = this.f73143d;
            if (bArr == null || bArr.length < this.f73140a) {
                this.f73143d = new byte[this.f73140a];
            }
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f73145f = j2;
        }
    }

    public void a(boolean z) {
        int value;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (value = (int) this.f73146g.getValue()) == (c2 = com.kwad.sdk.pngencrypt.n.c(this.f73144e, 0))) {
            return;
        }
        String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f73142c, Long.valueOf(this.f73145f), Integer.valueOf(c2), Integer.valueOf(value));
        if (z) {
            com.kwad.sdk.core.d.a.a(new PngjException(format));
        } else {
            com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
            if (this.f73146g == null) {
                this.f73146g = new CRC32();
            }
            this.f73146g.update(bArr, i2, i3);
        }
    }

    public ByteArrayInputStream b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new ByteArrayInputStream(this.f73143d) : (ByteArrayInputStream) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f73145f : invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                String str = this.f73142c;
                if (str == null) {
                    if (dVar.f73142c != null) {
                        return false;
                    }
                } else if (!str.equals(dVar.f73142c)) {
                    return false;
                }
                return this.f73145f == dVar.f73145f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.f73142c;
            int hashCode = str == null ? 0 : str.hashCode();
            long j2 = this.f73145f;
            return ((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "chunkid=" + b.a(this.f73141b) + " len=" + this.f73140a;
        }
        return (String) invokeV.objValue;
    }
}
