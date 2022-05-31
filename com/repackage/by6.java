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
/* loaded from: classes5.dex */
public class by6 extends wm<yw5, CardViewHolder<wv5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public wv5 l;
    public NEGFeedBackView.b m;
    public nw5<yw5> n;

    /* loaded from: classes5.dex */
    public class a extends nw5<yw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ by6 b;

        public a(by6 by6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {by6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = by6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, yw5 yw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yw5Var) == null) {
                int i = 2;
                if (this.b.l.w == view2) {
                    i = 1;
                } else if (view2 == this.b.l.l.getCommentContainer()) {
                    i = 5;
                } else if ((this.b.l.M() == null || view2.getId() != this.b.l.M().getId()) && (this.b.l.O() == null || view2.getId() != this.b.l.O().getId())) {
                    i = 0;
                }
                if (i != 0) {
                    jx6.d(yw5Var.a, this.b.i, yw5Var.q(), i);
                }
                vx6.j(view2, yw5Var, this.b.k);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
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
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public CardViewHolder<wv5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            wv5 wv5Var = new wv5(this.j, this.i);
            this.l = wv5Var;
            wv5Var.D(2);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.l.Y(bdUniqueId);
            }
            return new CardViewHolder<>(this.l);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, yw5 yw5Var, CardViewHolder<wv5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yw5Var, cardViewHolder})) == null) {
            yw5Var.I(yw5Var.position + 1);
            yw5Var.a.statFloor = yw5Var.q();
            wv5 c = cardViewHolder.c();
            c.b0(i + 1);
            c.l(yw5Var);
            c.n(this.n);
            c.C(this.m);
            jx6.h(yw5Var.a, this.i, yw5Var.q());
            vx6.p(yw5Var, this.k);
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
