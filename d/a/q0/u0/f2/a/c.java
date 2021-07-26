package d.a.q0.u0.f2.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.FrsProfessionPermissionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.s.a;
/* loaded from: classes8.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f63406e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f63407f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.u0.f2.a.a f63408g;

    /* renamed from: h  reason: collision with root package name */
    public d f63409h;

    /* renamed from: i  reason: collision with root package name */
    public int f63410i;

    /* loaded from: classes8.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f63412f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f63413g;

        public a(c cVar, String str, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63413g = cVar;
            this.f63411e = str;
            this.f63412f = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.f63413g.f63406e.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f63411e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.f63412f.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f63414e;

        public b(c cVar, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63414e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f63414e.dismiss();
            }
        }
    }

    /* renamed from: d.a.q0.u0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1676c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f63415e;

        public C1676c(c cVar, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63415e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f63415e.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(boolean z, int i2);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
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
        this.f63406e = tbPageContext;
        d.a.q0.u0.f2.a.a aVar = new d.a.q0.u0.f2.a.a();
        this.f63408g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f63407f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Z(this);
    }

    public final void b(d.a.q0.u0.f2.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && bVar.f63402f == 0) {
            if (!bVar.f63401e && bVar.f63404h == 2) {
                m(bVar.f63405i);
            }
            d dVar = this.f63409h;
            if (dVar != null) {
                dVar.c(bVar.f63401e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void c(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof d.a.q0.u0.f2.a.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof d.a.q0.u0.f2.a.b)) {
            d.a.q0.u0.f2.a.a aVar = (d.a.q0.u0.f2.a.a) mvcNetMessage.getRequestData();
            d.a.q0.u0.f2.a.b bVar = (d.a.q0.u0.f2.a.b) mvcSocketResponsedMessage.getData();
            if (aVar.f63400i != this.f63410i) {
                return;
            }
            int i2 = aVar.f63399h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                e(bVar, aVar.f63396e);
            } else if (i2 != 3) {
            } else {
                d(bVar, aVar.f63398g);
            }
        }
    }

    public final void d(d.a.q0.u0.f2.a.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, str) == null) || bVar == null) {
            return;
        }
        if (bVar.f63402f != 0) {
            if (StringUtils.isNull(bVar.f63403g)) {
                this.f63406e.showToast(R.string.neterror);
                return;
            } else {
                this.f63406e.showToast(bVar.f63403g);
                return;
            }
        }
        if (!bVar.f63401e) {
            int i2 = bVar.f63404h;
            if (i2 == 1) {
                l(bVar.f63405i, str);
            } else if (i2 == 3) {
                m(bVar.f63405i);
            }
        }
        d dVar = this.f63409h;
        if (dVar != null) {
            dVar.b(bVar.f63401e);
        }
    }

    public final void e(d.a.q0.u0.f2.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, bVar, i2) == null) || bVar == null) {
            return;
        }
        if (bVar.f63402f != 0) {
            if (StringUtils.isNull(bVar.f63403g)) {
                this.f63406e.showToast(R.string.neterror);
                return;
            } else {
                this.f63406e.showToast(bVar.f63403g);
                return;
            }
        }
        d dVar = this.f63409h;
        if (dVar != null) {
            dVar.a(bVar.f63401e, i2);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f63407f.Q()) {
            return;
        }
        this.f63407f.R();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            d.a.q0.u0.f2.a.a aVar = this.f63408g;
            aVar.f63399h = 1;
            aVar.f63398g = str;
            f();
        }
    }

    public void h(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048582, this, str, j) == null) {
            d.a.q0.u0.f2.a.a aVar = this.f63408g;
            aVar.f63398g = str;
            aVar.f63397f = j;
            aVar.f63399h = 3;
            f();
        }
    }

    public void i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) {
            d.a.q0.u0.f2.a.a aVar = this.f63408g;
            aVar.f63396e = i2;
            aVar.f63398g = str;
            aVar.f63399h = 2;
            f();
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f63409h = dVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f63410i = i2;
            this.f63408g.f63400i = i2;
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f63406e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.comfirm_imediate, new a(this, str2, aVar));
            aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
            aVar.create(this.f63406e);
            aVar.show();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f63406e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new C1676c(this, aVar));
            aVar.create(this.f63406e);
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof d.a.q0.u0.f2.a.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof d.a.q0.u0.f2.a.b)) {
            d.a.q0.u0.f2.a.a aVar = (d.a.q0.u0.f2.a.a) mvcNetMessage.getRequestData();
            d.a.q0.u0.f2.a.b bVar = (d.a.q0.u0.f2.a.b) mvcHttpResponsedMessage.getData();
            if (aVar.f63400i != this.f63410i) {
                return;
            }
            int i2 = aVar.f63399h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                e(bVar, aVar.f63396e);
            } else if (i2 != 3) {
            } else {
                d(bVar, aVar.f63398g);
            }
        }
    }
}
