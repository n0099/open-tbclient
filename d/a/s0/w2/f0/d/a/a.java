package d.a.s0.w2.f0.d.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.n1.o.l.e;
/* loaded from: classes9.dex */
public abstract class a implements e<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdCard f69159e;

    /* renamed from: f  reason: collision with root package name */
    public AdvertAppInfo f69160f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f69161g;

    /* renamed from: h  reason: collision with root package name */
    public Context f69162h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f69163i;
    public d.a.s0.n1.o.a j;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69163i = tbPageContext;
        this.f69162h = tbPageContext.getPageActivity();
    }

    public abstract void c();

    public void d(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard) == null) {
            this.f69159e = adCard;
            this.f69160f = adCard.getAdvertAppInfo();
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, obj) == null) && (obj instanceof AdCard)) {
            this.f69159e = (AdCard) obj;
            c();
            d(this.f69159e);
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void setAfterClickSchemeListener(d.a.s0.n1.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.j = aVar;
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void setDownloadAppCallback(d.a.s0.n1.o.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f69161g = z;
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }
}
