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
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f38717a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f38718b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38719c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f38720d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f38721e;

    /* renamed from: f  reason: collision with root package name */
    public long f38722f;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f38723g;

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
        this.f38720d = null;
        this.f38722f = 0L;
        this.f38721e = new byte[4];
        this.f38717a = i2;
        this.f38719c = str;
        this.f38718b = b.a(str);
        for (int i5 = 0; i5 < 4; i5++) {
            byte[] bArr = this.f38718b;
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
            byte[] bArr = this.f38720d;
            if (bArr == null || bArr.length < this.f38717a) {
                this.f38720d = new byte[this.f38717a];
            }
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f38722f = j;
        }
    }

    public void a(boolean z) {
        int value;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (value = (int) this.f38723g.getValue()) == (c2 = com.kwad.sdk.pngencrypt.n.c(this.f38721e, 0))) {
            return;
        }
        String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f38719c, Long.valueOf(this.f38722f), Integer.valueOf(c2), Integer.valueOf(value));
        if (z) {
            com.kwad.sdk.core.d.a.a(new PngjException(format));
        } else {
            com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
            if (this.f38723g == null) {
                this.f38723g = new CRC32();
            }
            this.f38723g.update(bArr, i2, i3);
        }
    }

    public ByteArrayInputStream b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new ByteArrayInputStream(this.f38720d) : (ByteArrayInputStream) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38722f : invokeV.longValue;
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
                String str = this.f38719c;
                if (str == null) {
                    if (dVar.f38719c != null) {
                        return false;
                    }
                } else if (!str.equals(dVar.f38719c)) {
                    return false;
                }
                return this.f38722f == dVar.f38722f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.f38719c;
            int hashCode = str == null ? 0 : str.hashCode();
            long j = this.f38722f;
            return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "chunkid=" + b.a(this.f38718b) + " len=" + this.f38717a;
        }
        return (String) invokeV.objValue;
    }
}
