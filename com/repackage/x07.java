package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class x07 extends ho<ey5, CardViewHolder<cx5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public cx5 l;
    public NEGFeedBackView.b m;
    public tx5<ey5> n;

    /* loaded from: classes7.dex */
    public class a extends tx5<ey5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x07 b;

        public a(x07 x07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tx5
        /* renamed from: d */
        public void a(View view2, ey5 ey5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ey5Var) == null) {
                int i = 2;
                if (this.b.l.w == view2) {
                    i = 1;
                } else if (view2 == this.b.l.l.getCommentContainer()) {
                    i = 5;
                } else if ((this.b.l.M() == null || view2.getId() != this.b.l.M().getId()) && (this.b.l.O() == null || view2.getId() != this.b.l.O().getId())) {
                    i = 0;
                }
                if (i != 0) {
                    f07.d(ey5Var.a, this.b.i, ey5Var.q(), i);
                }
                r07.j(view2, ey5Var, this.b.k);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x07(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = new a(this);
        this.j = tbPageContext;
        this.k = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: b0 */
    public CardViewHolder<cx5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cx5 cx5Var = new cx5(this.j, this.i);
            this.l = cx5Var;
            cx5Var.D(2);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.l.Y(bdUniqueId);
            }
            return new CardViewHolder<>(this.l);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, ey5 ey5Var, CardViewHolder<cx5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ey5Var, cardViewHolder})) == null) {
            ey5Var.I(ey5Var.position + 1);
            ey5Var.a.statFloor = ey5Var.q();
            cx5 c = cardViewHolder.c();
            c.b0(i + 1);
            c.l(ey5Var);
            c.n(this.n);
            c.C(this.m);
            f07.h(ey5Var.a, this.i, ey5Var.q());
            r07.p(ey5Var, this.k);
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
