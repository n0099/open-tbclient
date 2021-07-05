package d.a.s0.w2.j0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.f0.b.f;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f69263a;

    /* renamed from: b  reason: collision with root package name */
    public final View f69264b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.w2.i0.c f69265c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f69266d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.n1.o.h.b f69267e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f69268f;

    public e(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69264b = view;
        this.f69263a = str;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    public final <T> T b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (T) this.f69264b.findViewById(i2) : (T) invokeI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f69264b.setVisibility(0);
            d.a.s0.w2.i0.c cVar = this.f69265c;
            if (cVar != null) {
                cVar.i(303);
                d.a.s0.w2.i0.e.b().d(this.f69265c);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f69264b.setVisibility(8);
        }
    }

    public void g(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            this.f69266d = advertAppInfo;
        }
    }

    public void h(d.a.s0.n1.o.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
        }
    }

    public void i(d.a.s0.n1.o.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f69267e = bVar;
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.f69268f = tbPageContext;
        }
    }

    public void k(d.a.s0.w2.i0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f69265c = cVar;
        }
    }

    public void l(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
        }
    }
}
