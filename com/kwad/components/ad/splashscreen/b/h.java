package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
/* loaded from: classes5.dex */
public abstract class h extends e {
    public static /* synthetic */ Interceptable $ic = null;
    public static long b = 400;
    public transient /* synthetic */ FieldHolder $fh;
    public Vibrator c;
    public com.kwad.components.ad.splashscreen.d.a d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-78998621, "Lcom/kwad/components/ad/splashscreen/b/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-78998621, "Lcom/kwad/components/ad/splashscreen/b/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void e() {
        com.kwad.components.ad.splashscreen.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (hVar = ((e) this).a) == null) {
            return;
        }
        com.kwad.components.ad.splashscreen.d.a aVar = this.d;
        if (aVar == null) {
            this.d = new com.kwad.components.ad.splashscreen.d.a(this, u(), ((e) this).a.c) { // from class: com.kwad.components.ad.splashscreen.b.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ h a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (AdTemplate) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.splashscreen.d.a
                @SuppressLint({"SetTextI18n"})
                public final void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        this.a.a(str);
                    }
                }
            };
        } else {
            aVar.a(hVar.c);
        }
        com.kwad.components.core.c.a.b bVar = ((e) this).a.f;
        if (bVar != null) {
            bVar.a(this.d);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            if (hVar == null) {
                return;
            }
            AdInfo i = com.kwad.sdk.core.response.a.d.i(hVar.c);
            j();
            g();
            if (com.kwad.sdk.core.response.a.a.I(i)) {
                e();
            }
            h();
            k();
            l();
            i();
        }
    }

    public abstract void a(String str);

    public abstract void d();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.i_();
            d();
        }
    }

    public abstract void j();

    public abstract void k();

    @Override // com.kwad.sdk.mvp.Presenter
    public void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.k_();
            az.b(u(), this.c);
        }
    }

    public abstract void l();

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Context u = u();
            if (u != null) {
                this.c = (Vibrator) u.getSystemService("vibrator");
            }
            az.a(u(), this.c);
        }
    }
}
