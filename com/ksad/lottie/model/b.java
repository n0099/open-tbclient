package com.ksad.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33860a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33861b;

    /* renamed from: c  reason: collision with root package name */
    public final double f33862c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33863d;

    /* renamed from: e  reason: collision with root package name */
    public final int f33864e;

    /* renamed from: f  reason: collision with root package name */
    public final double f33865f;

    /* renamed from: g  reason: collision with root package name */
    public final double f33866g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f33867h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public final int f33868i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i2, int i3, double d3, double d4, @ColorInt int i4, @ColorInt int i5, double d5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {str, str2, Double.valueOf(d2), Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d3), Double.valueOf(d4), Integer.valueOf(i4), Integer.valueOf(i5), Double.valueOf(d5), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33860a = str;
        this.f33861b = str2;
        this.f33862c = d2;
        this.f33863d = i2;
        this.f33864e = i3;
        this.f33865f = d3;
        this.f33866g = d4;
        this.f33867h = i4;
        this.f33868i = i5;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int hashCode = (((((int) ((((this.f33860a.hashCode() * 31) + this.f33861b.hashCode()) * 31) + this.f33862c)) * 31) + this.f33863d) * 31) + this.f33864e;
            long doubleToLongBits = Double.doubleToLongBits(this.f33865f);
            return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f33867h;
        }
        return invokeV.intValue;
    }
}
