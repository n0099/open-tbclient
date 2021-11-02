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
    public final int f65977a;

    /* renamed from: b  reason: collision with root package name */
    public final int f65978b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65979c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65980d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f65981e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65982f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f65983g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f65984h;

    /* renamed from: i  reason: collision with root package name */
    public final int f65985i;
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
        this.f65977a = i2;
        this.f65978b = i3;
        this.f65981e = z;
        this.f65983g = z3;
        this.f65982f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f65980d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f65979c = i4;
        boolean z4 = i4 < 8;
        this.f65984h = z4;
        int i7 = this.f65980d;
        int i8 = this.f65979c * i7;
        this.f65985i = i8;
        this.j = (i8 + 7) / 8;
        int i9 = ((i8 * i2) + 7) / 8;
        this.k = i9;
        int i10 = i7 * this.f65977a;
        this.l = i10;
        this.m = z4 ? i9 : i10;
        int i11 = this.f65979c;
        if (i11 == 1 || i11 == 2 || i11 == 4) {
            if (!this.f65983g && !this.f65982f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f65979c);
            }
        } else if (i11 != 8) {
            if (i11 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f65979c);
            } else if (this.f65983g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f65979c);
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
                return this.f65981e == kVar.f65981e && this.f65979c == kVar.f65979c && this.f65977a == kVar.f65977a && this.f65982f == kVar.f65982f && this.f65983g == kVar.f65983g && this.f65978b == kVar.f65978b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (((((((((((this.f65981e ? 1231 : 1237) + 31) * 31) + this.f65979c) * 31) + this.f65977a) * 31) + (this.f65982f ? 1231 : 1237)) * 31) + (this.f65983g ? 1231 : 1237)) * 31) + this.f65978b;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ImageInfo [cols=" + this.f65977a + ", rows=" + this.f65978b + ", bitDepth=" + this.f65979c + ", channels=" + this.f65980d + ", alpha=" + this.f65981e + ", greyscale=" + this.f65982f + ", indexed=" + this.f65983g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
