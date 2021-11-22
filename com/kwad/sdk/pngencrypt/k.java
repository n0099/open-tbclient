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
    public final int f66889a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66890b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66891c;

    /* renamed from: d  reason: collision with root package name */
    public final int f66892d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f66893e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f66894f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f66895g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f66896h;

    /* renamed from: i  reason: collision with root package name */
    public final int f66897i;
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
        this.f66889a = i2;
        this.f66890b = i3;
        this.f66893e = z;
        this.f66895g = z3;
        this.f66894f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f66892d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f66891c = i4;
        boolean z4 = i4 < 8;
        this.f66896h = z4;
        int i7 = this.f66892d;
        int i8 = this.f66891c * i7;
        this.f66897i = i8;
        this.j = (i8 + 7) / 8;
        int i9 = ((i8 * i2) + 7) / 8;
        this.k = i9;
        int i10 = i7 * this.f66889a;
        this.l = i10;
        this.m = z4 ? i9 : i10;
        int i11 = this.f66891c;
        if (i11 == 1 || i11 == 2 || i11 == 4) {
            if (!this.f66895g && !this.f66894f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f66891c);
            }
        } else if (i11 != 8) {
            if (i11 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f66891c);
            } else if (this.f66895g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f66891c);
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
                return this.f66893e == kVar.f66893e && this.f66891c == kVar.f66891c && this.f66889a == kVar.f66889a && this.f66894f == kVar.f66894f && this.f66895g == kVar.f66895g && this.f66890b == kVar.f66890b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (((((((((((this.f66893e ? 1231 : 1237) + 31) * 31) + this.f66891c) * 31) + this.f66889a) * 31) + (this.f66894f ? 1231 : 1237)) * 31) + (this.f66895g ? 1231 : 1237)) * 31) + this.f66890b;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ImageInfo [cols=" + this.f66889a + ", rows=" + this.f66890b + ", bitDepth=" + this.f66891c + ", channels=" + this.f66892d + ", alpha=" + this.f66893e + ", greyscale=" + this.f66894f + ", indexed=" + this.f66895g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
