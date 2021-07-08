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
    public final int f35849a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35850b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35851c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35852d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f35853e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f35854f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f35855g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f35856h;

    /* renamed from: i  reason: collision with root package name */
    public final int f35857i;
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
        this.f35849a = i2;
        this.f35850b = i3;
        this.f35853e = z;
        this.f35855g = z3;
        this.f35854f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f35852d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f35851c = i4;
        boolean z4 = i4 < 8;
        this.f35856h = z4;
        int i7 = this.f35852d;
        int i8 = this.f35851c * i7;
        this.f35857i = i8;
        this.j = (i8 + 7) / 8;
        int i9 = ((i8 * i2) + 7) / 8;
        this.k = i9;
        int i10 = i7 * this.f35849a;
        this.l = i10;
        this.m = z4 ? i9 : i10;
        int i11 = this.f35851c;
        if (i11 == 1 || i11 == 2 || i11 == 4) {
            if (!this.f35855g && !this.f35854f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f35851c);
            }
        } else if (i11 != 8) {
            if (i11 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f35851c);
            } else if (this.f35855g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f35851c);
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
                return this.f35853e == kVar.f35853e && this.f35851c == kVar.f35851c && this.f35849a == kVar.f35849a && this.f35854f == kVar.f35854f && this.f35855g == kVar.f35855g && this.f35850b == kVar.f35850b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (((((((((((this.f35853e ? 1231 : 1237) + 31) * 31) + this.f35851c) * 31) + this.f35849a) * 31) + (this.f35854f ? 1231 : 1237)) * 31) + (this.f35855g ? 1231 : 1237)) * 31) + this.f35850b;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ImageInfo [cols=" + this.f35849a + ", rows=" + this.f35850b + ", bitDepth=" + this.f35851c + ", channels=" + this.f35852d + ", alpha=" + this.f35853e + ", greyscale=" + this.f35854f + ", indexed=" + this.f35855g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
