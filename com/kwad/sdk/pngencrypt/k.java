package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f73032a;

    /* renamed from: b  reason: collision with root package name */
    public final int f73033b;

    /* renamed from: c  reason: collision with root package name */
    public final int f73034c;

    /* renamed from: d  reason: collision with root package name */
    public final int f73035d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f73036e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f73037f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f73038g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f73039h;

    /* renamed from: i  reason: collision with root package name */
    public final int f73040i;

    /* renamed from: j  reason: collision with root package name */
    public final int f73041j;
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
        this.f73032a = i2;
        this.f73033b = i3;
        this.f73036e = z;
        this.f73038g = z3;
        this.f73037f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f73035d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f73034c = i4;
        boolean z4 = i4 < 8;
        this.f73039h = z4;
        int i7 = this.f73035d;
        int i8 = this.f73034c * i7;
        this.f73040i = i8;
        this.f73041j = (i8 + 7) / 8;
        int i9 = ((i8 * i2) + 7) / 8;
        this.k = i9;
        int i10 = i7 * this.f73032a;
        this.l = i10;
        this.m = z4 ? i9 : i10;
        int i11 = this.f73034c;
        if (i11 == 1 || i11 == 2 || i11 == 4) {
            if (!this.f73038g && !this.f73037f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f73034c);
            }
        } else if (i11 != 8) {
            if (i11 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f73034c);
            } else if (this.f73038g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f73034c);
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
                return this.f73036e == kVar.f73036e && this.f73034c == kVar.f73034c && this.f73032a == kVar.f73032a && this.f73037f == kVar.f73037f && this.f73038g == kVar.f73038g && this.f73033b == kVar.f73033b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (((((((((((this.f73036e ? 1231 : 1237) + 31) * 31) + this.f73034c) * 31) + this.f73032a) * 31) + (this.f73037f ? 1231 : 1237)) * 31) + (this.f73038g ? 1231 : 1237)) * 31) + this.f73033b;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ImageInfo [cols=" + this.f73032a + ", rows=" + this.f73033b + ", bitDepth=" + this.f73034c + ", channels=" + this.f73035d + ", alpha=" + this.f73036e + ", greyscale=" + this.f73037f + ", indexed=" + this.f73038g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
