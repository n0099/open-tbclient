package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f59375b;

    /* renamed from: c  reason: collision with root package name */
    public final int f59376c;

    /* renamed from: d  reason: collision with root package name */
    public final int f59377d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f59378e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f59379f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f59380g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f59381h;

    /* renamed from: i  reason: collision with root package name */
    public final int f59382i;

    /* renamed from: j  reason: collision with root package name */
    public final int f59383j;

    /* renamed from: k  reason: collision with root package name */
    public final int f59384k;
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
        this.a = i2;
        this.f59375b = i3;
        this.f59378e = z;
        this.f59380g = z3;
        this.f59379f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f59377d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f59376c = i4;
        boolean z4 = i4 < 8;
        this.f59381h = z4;
        int i7 = this.f59377d;
        int i8 = this.f59376c * i7;
        this.f59382i = i8;
        this.f59383j = (i8 + 7) / 8;
        int i9 = ((i8 * i2) + 7) / 8;
        this.f59384k = i9;
        int i10 = i7 * this.a;
        this.l = i10;
        this.m = z4 ? i9 : i10;
        int i11 = this.f59376c;
        if (i11 == 1 || i11 == 2 || i11 == 4) {
            if (!this.f59380g && !this.f59379f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f59376c);
            }
        } else if (i11 != 8) {
            if (i11 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f59376c);
            } else if (this.f59380g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f59376c);
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
                return this.f59378e == kVar.f59378e && this.f59376c == kVar.f59376c && this.a == kVar.a && this.f59379f == kVar.f59379f && this.f59380g == kVar.f59380g && this.f59375b == kVar.f59375b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (((((((((((this.f59378e ? 1231 : 1237) + 31) * 31) + this.f59376c) * 31) + this.a) * 31) + (this.f59379f ? 1231 : 1237)) * 31) + (this.f59380g ? 1231 : 1237)) * 31) + this.f59375b;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ImageInfo [cols=" + this.a + ", rows=" + this.f59375b + ", bitDepth=" + this.f59376c + ", channels=" + this.f59377d + ", alpha=" + this.f59378e + ", greyscale=" + this.f59379f + ", indexed=" + this.f59380g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
