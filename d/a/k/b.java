package d.a.k;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.v0.a;
import d.a.p0.s.q.b2;
/* loaded from: classes7.dex */
public class b extends d.a.k.a<d.a.p0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BjhArticleLayout j;
    public d.a.p0.s.q.a k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f43135e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43135e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f43135e;
                bVar.r(bVar.f43130e.j(), this.f43135e.k);
            }
        }
    }

    /* renamed from: d.a.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0619b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f43136a;

        public C0619b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43136a = bVar;
        }

        @Override // d.a.k.v0.a.b
        public boolean a(a.C0620a c0620a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0620a)) == null) {
                if (this.f43136a.k != null && this.f43136a.k.getThreadData() != null) {
                    d.a.q0.a0.m.a(this.f43136a.k.getThreadData().d0());
                    d.a.q0.a0.m.l(this.f43136a.j.getTitle(), this.f43136a.k.getThreadData().d0(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(context);
        this.j = bjhArticleLayout;
        bjhArticleLayout.setJumpToPbListener(this.l);
    }

    @Override // d.a.k.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    @Override // d.a.k.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.h();
            i(1, new C0619b(this));
        }
    }

    @Override // d.a.k.a
    public void l(d.a.q0.a0.b0<d.a.p0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b0Var) == null) {
            super.l(b0Var);
            this.j.setSubClickListener(b0Var);
        }
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            this.j.onChangeSkinType(tbPageContext, i2);
        }
    }

    public final void r(View view, d.a.d.k.e.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, nVar) == null) {
            d.a.p0.s.q.a aVar = this.k;
            if (((aVar instanceof d.a.q0.a0.e0.e) || (aVar instanceof b2)) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                if (nVar instanceof d.a.q0.a0.e0.e) {
                    d.a.q0.a0.e0.e eVar = (d.a.q0.a0.e0.e) this.k;
                    eVar.k = 1;
                    ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) eVar, view.getContext(), eVar.f54338e.W1 ? 2 : 1, false);
                    threadCardViewHolder.b().o(new a.C0620a(1));
                } else if (nVar instanceof b2) {
                    b2 b2Var = (b2) this.k;
                    b2Var.objType = 1;
                    ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) b2Var, view.getContext(), 3, false);
                    threadCardViewHolder.b().o(new a.C0620a(1));
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: s */
    public void a(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.k = aVar;
            this.j.a(aVar);
        }
    }
}
