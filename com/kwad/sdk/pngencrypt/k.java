package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f36038a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36039b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36040c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36041d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36042e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36043f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36044g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36045h;

    /* renamed from: i  reason: collision with root package name */
    public final int f36046i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n;
    public long o;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = -1L;
        this.o = -1L;
        this.f36038a = i2;
        this.f36039b = i3;
        this.f36042e = z;
        this.f36044g = z3;
        this.f36043f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f36041d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f36040c = i4;
        boolean z4 = i4 < 8;
        this.f36045h = z4;
        int i7 = this.f36041d;
        int i8 = this.f36040c * i7;
        this.f36046i = i8;
        this.j = (i8 + 7) / 8;
        int i9 = ((i8 * i2) + 7) / 8;
        this.k = i9;
        int i10 = i7 * this.f36038a;
        this.l = i10;
        this.m = z4 ? i9 : i10;
        int i11 = this.f36040c;
        if (i11 == 1 || i11 == 2 || i11 == 4) {
            if (!this.f36044g && !this.f36043f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f36040c);
            }
        } else if (i11 != 8) {
            if (i11 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f36040c);
            } else if (this.f36044g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f36040c);
            }
        }
        if (i2 < 1 || i2 > 16777216) {
            throw new PngjException("invalid cols=" + i2 + " ???");
        } else if (i3 >= 1 && i3 <= 16777216) {
            if (this.l < 1) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i3 + " ???");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && k.class == obj.getClass()) {
                k kVar = (k) obj;
                return this.f36042e == kVar.f36042e && this.f36040c == kVar.f36040c && this.f36038a == kVar.f36038a && this.f36043f == kVar.f36043f && this.f36044g == kVar.f36044g && this.f36039b == kVar.f36039b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (((((((((((this.f36042e ? 1231 : 1237) + 31) * 31) + this.f36040c) * 31) + this.f36038a) * 31) + (this.f36043f ? 1231 : 1237)) * 31) + (this.f36044g ? 1231 : 1237)) * 31) + this.f36039b;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ImageInfo [cols=" + this.f36038a + ", rows=" + this.f36039b + ", bitDepth=" + this.f36040c + ", channels=" + this.f36041d + ", alpha=" + this.f36042e + ", greyscale=" + this.f36043f + ", indexed=" + this.f36044g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
