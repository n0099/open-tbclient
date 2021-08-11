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
    public final int f72760a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f72761b;

    /* renamed from: c  reason: collision with root package name */
    public final String f72762c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f72763d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f72764e;

    /* renamed from: f  reason: collision with root package name */
    public long f72765f;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f72766g;

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
        this.f72763d = null;
        this.f72765f = 0L;
        this.f72764e = new byte[4];
        this.f72760a = i2;
        this.f72762c = str;
        this.f72761b = b.a(str);
        for (int i5 = 0; i5 < 4; i5++) {
            byte[] bArr = this.f72761b;
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
            byte[] bArr = this.f72763d;
            if (bArr == null || bArr.length < this.f72760a) {
                this.f72763d = new byte[this.f72760a];
            }
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f72765f = j2;
        }
    }

    public void a(boolean z) {
        int value;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (value = (int) this.f72766g.getValue()) == (c2 = com.kwad.sdk.pngencrypt.n.c(this.f72764e, 0))) {
            return;
        }
        String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f72762c, Long.valueOf(this.f72765f), Integer.valueOf(c2), Integer.valueOf(value));
        if (z) {
            com.kwad.sdk.core.d.a.a(new PngjException(format));
        } else {
            com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
            if (this.f72766g == null) {
                this.f72766g = new CRC32();
            }
            this.f72766g.update(bArr, i2, i3);
        }
    }

    public ByteArrayInputStream b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new ByteArrayInputStream(this.f72763d) : (ByteArrayInputStream) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f72765f : invokeV.longValue;
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
                String str = this.f72762c;
                if (str == null) {
                    if (dVar.f72762c != null) {
                        return false;
                    }
                } else if (!str.equals(dVar.f72762c)) {
                    return false;
                }
                return this.f72765f == dVar.f72765f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.f72762c;
            int hashCode = str == null ? 0 : str.hashCode();
            long j2 = this.f72765f;
            return ((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "chunkid=" + b.a(this.f72761b) + " len=" + this.f72760a;
        }
        return (String) invokeV.objValue;
    }
}
