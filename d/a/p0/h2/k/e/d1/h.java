package d.a.p0.h2.k.e.d1;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.a;
import d.a.j.o;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.w0;
import d.a.p0.a0.b0;
/* loaded from: classes8.dex */
public class h extends d.a.p0.h2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public b2 f57236f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.r.q.a f57237g;

    /* renamed from: h  reason: collision with root package name */
    public o f57238h;

    /* renamed from: i  reason: collision with root package name */
    public View f57239i;

    /* loaded from: classes8.dex */
    public class a extends d.a.o0.r.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f57240e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57240e = hVar;
        }

        @Override // d.a.o0.r.q.a
        public w0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (w0) invokeV.objValue;
        }

        @Override // d.a.o0.r.q.a
        public b2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57240e.f57236f : (b2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f57241e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57241e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar;
            a.InterfaceC0609a interfaceC0609a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0609a = (hVar = this.f57241e).f57202c) == null) {
                return;
            }
            interfaceC0609a.a(hVar.f57237g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f57238h == null) {
                o oVar = new o(this.f57200a.getPageActivity());
                this.f57238h = oVar;
                oVar.n(Boolean.TRUE);
                this.f57238h.x("pb");
                this.f57238h.z(0);
                this.f57238h.F(this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f57200a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
                this.f57238h.G(false);
                this.f57238h.E(true);
            }
            View g2 = this.f57238h.g();
            this.f57239i = g2;
            return g2;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f57204e == i2) {
            return;
        }
        this.f57204e = i2;
        SkinManager.setBackgroundColor(this.f57239i, R.color.CAM_X0204);
        o oVar = this.f57238h;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f57203d = originalThreadInfo;
            this.f57236f = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f57237g = aVar;
            o oVar = this.f57238h;
            if (oVar != null) {
                oVar.a(aVar);
            }
        }
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public void d(a.InterfaceC0609a interfaceC0609a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0609a) == null) {
            super.d(interfaceC0609a);
            o oVar = this.f57238h;
            if (oVar != null) {
                oVar.A(interfaceC0609a);
            }
            View view = this.f57239i;
            if (view != null) {
                view.setOnClickListener(new b(this));
            }
        }
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            o oVar = this.f57238h;
            if (oVar != null) {
                oVar.l(this.f57201b);
            }
        }
    }
}
