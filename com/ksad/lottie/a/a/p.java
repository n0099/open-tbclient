package com.ksad.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes7.dex */
public class p implements l, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Path f33661a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33662b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f33663c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Path> f33664d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33665e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public r f33666f;

    public p(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33661a = new Path();
        this.f33662b = kVar.a();
        this.f33663c = fVar;
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.h, Path> a2 = kVar.b().a();
        this.f33664d = a2;
        aVar.a(a2);
        this.f33664d.a(this);
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f33665e = false;
            this.f33663c.invalidateSelf();
        }
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                b bVar = list.get(i2);
                if (bVar instanceof r) {
                    r rVar = (r) bVar;
                    if (rVar.b() == ShapeTrimPath.Type.Simultaneously) {
                        this.f33666f = rVar;
                        rVar.a(this);
                    }
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f33665e) {
                return this.f33661a;
            }
            this.f33661a.reset();
            this.f33661a.set(this.f33664d.e());
            this.f33661a.setFillType(Path.FillType.EVEN_ODD);
            com.ksad.lottie.d.f.a(this.f33661a, this.f33666f);
            this.f33665e = true;
            return this.f33661a;
        }
        return (Path) invokeV.objValue;
    }
}
