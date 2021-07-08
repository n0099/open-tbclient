package d.a.p0.u0.f2.a;

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
import d.a.o0.r.s.a;
/* loaded from: classes8.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f62763e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f62764f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.u0.f2.a.a f62765g;

    /* renamed from: h  reason: collision with root package name */
    public d f62766h;

    /* renamed from: i  reason: collision with root package name */
    public int f62767i;

    /* loaded from: classes8.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f62769f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f62770g;

        public a(c cVar, String str, d.a.o0.r.s.a aVar) {
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
            this.f62770g = cVar;
            this.f62768e = str;
            this.f62769f = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.f62770g.f62763e.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f62768e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.f62769f.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f62771e;

        public b(c cVar, d.a.o0.r.s.a aVar) {
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
            this.f62771e = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f62771e.dismiss();
            }
        }
    }

    /* renamed from: d.a.p0.u0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1674c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f62772e;

        public C1674c(c cVar, d.a.o0.r.s.a aVar) {
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
            this.f62772e = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f62772e.dismiss();
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
        this.f62763e = tbPageContext;
        d.a.p0.u0.f2.a.a aVar = new d.a.p0.u0.f2.a.a();
        this.f62765g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f62764f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Z(this);
    }

    public final void b(d.a.p0.u0.f2.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && bVar.f62759f == 0) {
            if (!bVar.f62758e && bVar.f62761h == 2) {
                m(bVar.f62762i);
            }
            d dVar = this.f62766h;
            if (dVar != null) {
                dVar.c(bVar.f62758e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void c(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof d.a.p0.u0.f2.a.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof d.a.p0.u0.f2.a.b)) {
            d.a.p0.u0.f2.a.a aVar = (d.a.p0.u0.f2.a.a) mvcNetMessage.getRequestData();
            d.a.p0.u0.f2.a.b bVar = (d.a.p0.u0.f2.a.b) mvcSocketResponsedMessage.getData();
            if (aVar.f62757i != this.f62767i) {
                return;
            }
            int i2 = aVar.f62756h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                e(bVar, aVar.f62753e);
            } else if (i2 != 3) {
            } else {
                d(bVar, aVar.f62755g);
            }
        }
    }

    public final void d(d.a.p0.u0.f2.a.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, str) == null) || bVar == null) {
            return;
        }
        if (bVar.f62759f != 0) {
            if (StringUtils.isNull(bVar.f62760g)) {
                this.f62763e.showToast(R.string.neterror);
                return;
            } else {
                this.f62763e.showToast(bVar.f62760g);
                return;
            }
        }
        if (!bVar.f62758e) {
            int i2 = bVar.f62761h;
            if (i2 == 1) {
                l(bVar.f62762i, str);
            } else if (i2 == 3) {
                m(bVar.f62762i);
            }
        }
        d dVar = this.f62766h;
        if (dVar != null) {
            dVar.b(bVar.f62758e);
        }
    }

    public final void e(d.a.p0.u0.f2.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, bVar, i2) == null) || bVar == null) {
            return;
        }
        if (bVar.f62759f != 0) {
            if (StringUtils.isNull(bVar.f62760g)) {
                this.f62763e.showToast(R.string.neterror);
                return;
            } else {
                this.f62763e.showToast(bVar.f62760g);
                return;
            }
        }
        d dVar = this.f62766h;
        if (dVar != null) {
            dVar.a(bVar.f62758e, i2);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f62764f.Q()) {
            return;
        }
        this.f62764f.R();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            d.a.p0.u0.f2.a.a aVar = this.f62765g;
            aVar.f62756h = 1;
            aVar.f62755g = str;
            f();
        }
    }

    public void h(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048582, this, str, j) == null) {
            d.a.p0.u0.f2.a.a aVar = this.f62765g;
            aVar.f62755g = str;
            aVar.f62754f = j;
            aVar.f62756h = 3;
            f();
        }
    }

    public void i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) {
            d.a.p0.u0.f2.a.a aVar = this.f62765g;
            aVar.f62753e = i2;
            aVar.f62755g = str;
            aVar.f62756h = 2;
            f();
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f62766h = dVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f62767i = i2;
            this.f62765g.f62757i = i2;
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f62763e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.comfirm_imediate, new a(this, str2, aVar));
            aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
            aVar.create(this.f62763e);
            aVar.show();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f62763e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new C1674c(this, aVar));
            aVar.create(this.f62763e);
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof d.a.p0.u0.f2.a.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof d.a.p0.u0.f2.a.b)) {
            d.a.p0.u0.f2.a.a aVar = (d.a.p0.u0.f2.a.a) mvcNetMessage.getRequestData();
            d.a.p0.u0.f2.a.b bVar = (d.a.p0.u0.f2.a.b) mvcHttpResponsedMessage.getData();
            if (aVar.f62757i != this.f62767i) {
                return;
            }
            int i2 = aVar.f62756h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                e(bVar, aVar.f62753e);
            } else if (i2 != 3) {
            } else {
                d(bVar, aVar.f62755g);
            }
        }
    }
}
