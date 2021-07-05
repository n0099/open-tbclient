package com.ksad.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.o;
/* loaded from: classes7.dex */
public class l implements com.ksad.lottie.model.content.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f33852a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f33853b;

    /* renamed from: c  reason: collision with root package name */
    public final g f33854c;

    /* renamed from: d  reason: collision with root package name */
    public final b f33855d;

    /* renamed from: e  reason: collision with root package name */
    public final d f33856e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final b f33857f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final b f33858g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((e) objArr[0], (m) objArr[1], (g) objArr[2], (b) objArr[3], (d) objArr[4], (b) objArr[5], (b) objArr[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, mVar, gVar, bVar, dVar, bVar2, bVar3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33852a = eVar;
        this.f33853b = mVar;
        this.f33854c = gVar;
        this.f33855d = bVar;
        this.f33856e = dVar;
        this.f33857f = bVar2;
        this.f33858g = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            return null;
        }
        return (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33852a : (e) invokeV.objValue;
    }

    public m<PointF, PointF> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33853b : (m) invokeV.objValue;
    }

    public g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33854c : (g) invokeV.objValue;
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33855d : (b) invokeV.objValue;
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33856e : (d) invokeV.objValue;
    }

    @Nullable
    public b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33857f : (b) invokeV.objValue;
    }

    @Nullable
    public b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33858g : (b) invokeV.objValue;
    }

    public o h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new o(this) : (o) invokeV.objValue;
    }
}
