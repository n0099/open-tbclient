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
public class t17 extends bn<m06, CardViewHolder<kz5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public kz5 d;
    public NEGFeedBackView.b e;
    public b06<m06> f;

    /* loaded from: classes7.dex */
    public class a extends b06<m06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t17 b;

        public a(t17 t17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, m06 m06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, m06Var) == null) {
                int i = 2;
                if (this.b.d.w == view2) {
                    i = 1;
                } else if (view2 == this.b.d.l.getCommentContainer()) {
                    i = 5;
                } else if ((this.b.d.M() == null || view2.getId() != this.b.d.M().getId()) && (this.b.d.O() == null || view2.getId() != this.b.d.O().getId())) {
                    i = 0;
                }
                if (i != 0) {
                    b17.d(m06Var.a, this.b.a, m06Var.n(), i);
                }
                n17.m(view2, m06Var, this.b.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t17(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
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
        this.e = null;
        this.f = new a(this);
        this.b = tbPageContext;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: u */
    public CardViewHolder<kz5> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kz5 kz5Var = new kz5(this.b, this.a);
            this.d = kz5Var;
            kz5Var.C(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.d.Y(bdUniqueId);
            }
            return new CardViewHolder<>(this.d);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, m06 m06Var, CardViewHolder<kz5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, m06Var, cardViewHolder})) == null) {
            m06Var.I(m06Var.position + 1);
            m06Var.a.statFloor = m06Var.n();
            kz5 a2 = cardViewHolder.a();
            a2.b0(i + 1);
            a2.i(m06Var);
            a2.n(this.f);
            a2.B(this.e);
            b17.i(m06Var.a, this.a, m06Var.n());
            n17.t(m06Var, this.c);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
