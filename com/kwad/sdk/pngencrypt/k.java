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
    public final int f73531a;

    /* renamed from: b  reason: collision with root package name */
    public final int f73532b;

    /* renamed from: c  reason: collision with root package name */
    public final int f73533c;

    /* renamed from: d  reason: collision with root package name */
    public final int f73534d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f73535e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f73536f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f73537g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f73538h;

    /* renamed from: i  reason: collision with root package name */
    public final int f73539i;

    /* renamed from: j  reason: collision with root package name */
    public final int f73540j;
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
        this.f73531a = i2;
        this.f73532b = i3;
        this.f73535e = z;
        this.f73537g = z3;
        this.f73536f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f73534d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f73533c = i4;
        boolean z4 = i4 < 8;
        this.f73538h = z4;
        int i7 = this.f73534d;
        int i8 = this.f73533c * i7;
        this.f73539i = i8;
        this.f73540j = (i8 + 7) / 8;
        int i9 = ((i8 * i2) + 7) / 8;
        this.k = i9;
        int i10 = i7 * this.f73531a;
        this.l = i10;
        this.m = z4 ? i9 : i10;
        int i11 = this.f73533c;
        if (i11 == 1 || i11 == 2 || i11 == 4) {
            if (!this.f73537g && !this.f73536f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f73533c);
            }
        } else if (i11 != 8) {
            if (i11 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f73533c);
            } else if (this.f73537g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f73533c);
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
                return this.f73535e == kVar.f73535e && this.f73533c == kVar.f73533c && this.f73531a == kVar.f73531a && this.f73536f == kVar.f73536f && this.f73537g == kVar.f73537g && this.f73532b == kVar.f73532b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (((((((((((this.f73535e ? 1231 : 1237) + 31) * 31) + this.f73533c) * 31) + this.f73531a) * 31) + (this.f73536f ? 1231 : 1237)) * 31) + (this.f73537g ? 1231 : 1237)) * 31) + this.f73532b;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "ImageInfo [cols=" + this.f73531a + ", rows=" + this.f73532b + ", bitDepth=" + this.f73533c + ", channels=" + this.f73534d + ", alpha=" + this.f73535e + ", greyscale=" + this.f73536f + ", indexed=" + this.f73537g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
