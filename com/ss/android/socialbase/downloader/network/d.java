package com.ss.android.socialbase.downloader.network;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final double f69697a;

    /* renamed from: b  reason: collision with root package name */
    public final int f69698b;

    /* renamed from: c  reason: collision with root package name */
    public double f69699c;

    /* renamed from: d  reason: collision with root package name */
    public int f69700d;

    public d(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69699c = -1.0d;
        this.f69697a = d2;
        this.f69698b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            double d3 = 1.0d - this.f69697a;
            int i2 = this.f69700d;
            if (i2 > this.f69698b) {
                this.f69699c = Math.exp((d3 * Math.log(this.f69699c)) + (this.f69697a * Math.log(d2)));
            } else if (i2 > 0) {
                double d4 = (d3 * i2) / (i2 + 1.0d);
                this.f69699c = Math.exp((d4 * Math.log(this.f69699c)) + ((1.0d - d4) * Math.log(d2)));
            } else {
                this.f69699c = d2;
            }
            this.f69700d++;
        }
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69699c : invokeV.doubleValue;
    }
}
