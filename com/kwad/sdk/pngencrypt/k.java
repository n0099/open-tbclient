package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f65976a;

    /* renamed from: b  reason: collision with root package name */
    public final int f65977b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65978c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65979d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f65980e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65981f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f65982g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f65983h;

    /* renamed from: i  reason: collision with root package name */
    public final int f65984i;
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
        this.f65976a = i2;
        this.f65977b = i3;
        this.f65980e = z;
        this.f65982g = z3;
        this.f65981f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f65979d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f65978c = i4;
        boolean z4 = i4 < 8;
        this.f65983h = z4;
        int i7 = this.f65979d;
        int i8 = this.f65978c * i7;
        this.f65984i = i8;
        this.j = (i8 + 7) / 8;
        int i9 = ((i8 * i2) + 7) / 8;
        this.k = i9;
        int i10 = i7 * this.f65976a;
        this.l = i10;
        this.m = z4 ? i9 : i10;
        int i11 = this.f65978c;
        if (i11 == 1 || i11 == 2 || i11 == 4) {
            if (!this.f65982g && !this.f65981f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f65978c);
            }
        } else if (i11 != 8) {
            if (i11 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f65978c);
            } else if (this.f65982g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f65978c);
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
                return this.f65980e == kVar.f65980e && this.f65978c == kVar.f65978c && this.f65976a == kVar.f65976a && this.f65981f == kVar.f65981f && this.f65982g == kVar.f65982g && this.f65977b == kVar.f65977b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (((((((((((this.f65980e ? 1231 : 1237) + 31) * 31) + this.f65978c) * 31) + this.f65976a) * 31) + (this.f65981f ? 1231 : 1237)) * 31) + (this.f65982g ? 1231 : 1237)) * 31) + this.f65977b;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ImageInfo [cols=" + this.f65976a + ", rows=" + this.f65977b + ", bitDepth=" + this.f65978c + ", channels=" + this.f65979d + ", alpha=" + this.f65980e + ", greyscale=" + this.f65981f + ", indexed=" + this.f65982g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
