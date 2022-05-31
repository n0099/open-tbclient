package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
/* loaded from: classes6.dex */
public class nw extends mw<om4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BjhArticleLayout f;
    public om4 g;
    public View.OnClickListener h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw a;

        public a(nw nwVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nwVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nwVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nw nwVar = this.a;
                nwVar.r(nwVar.a.j(), this.a.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements iy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw a;

        public b(nw nwVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nwVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nwVar;
        }

        @Override // com.repackage.iy.b
        public boolean a(iy.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.g != null && this.a.g.getThreadData() != null) {
                    yv5.a(this.a.g.getThreadData().getId());
                    yv5.l(this.a.f.getTitle(), this.a.g.getThreadData().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nw(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(context);
        this.f = bjhArticleLayout;
        bjhArticleLayout.setJumpToPbListener(this.h);
    }

    @Override // com.repackage.mw
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.mw
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.h();
            i(1, new b(this));
        }
    }

    @Override // com.repackage.mw
    public void l(nw5<om4> nw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nw5Var) == null) {
            super.l(nw5Var);
            this.f.setSubClickListener(nw5Var);
        }
    }

    @Override // com.repackage.cx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void r(View view2, jn jnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, jnVar) == null) {
            om4 om4Var = this.g;
            if (((om4Var instanceof uw5) || (om4Var instanceof ThreadData)) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (jnVar instanceof uw5) {
                    uw5 uw5Var = (uw5) this.g;
                    uw5Var.f = 1;
                    ThreadCardUtils.jumpToPB((om4) uw5Var, view2.getContext(), uw5Var.a.isFromHomPage ? 2 : 1, false);
                    threadCardViewHolder.c().o(new iy.a(1));
                } else if (jnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) this.g;
                    threadData.objType = 1;
                    ThreadCardUtils.jumpToPB((om4) threadData, view2.getContext(), 3, false);
                    threadCardViewHolder.c().o(new iy.a(1));
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bx
    /* renamed from: s */
    public void a(om4 om4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, om4Var) == null) {
            this.g = om4Var;
            this.f.a(om4Var);
        }
    }
}
