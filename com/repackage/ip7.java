package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleATitleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ip7 extends ho<sp7, InterestedForumStyleATitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ip7 ip7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(uoVar instanceof sp7)) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip7(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.a = context;
        this.d = bdUniqueId;
        V(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.ho
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, sp7 sp7Var, InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        a0(i, view2, viewGroup, sp7Var, interestedForumStyleATitleViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: Z */
    public InterestedForumStyleATitleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03ff, viewGroup, false);
            } else {
                inflate = UbsABTestHelper.isInterestGuideStyleB() ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0402, viewGroup, false) : null;
            }
            return new InterestedForumStyleATitleViewHolder(inflate);
        }
        return (InterestedForumStyleATitleViewHolder) invokeL.objValue;
    }

    public View a0(int i, View view2, ViewGroup viewGroup, sp7 sp7Var, InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sp7Var, interestedForumStyleATitleViewHolder})) == null) {
            if (sp7Var == null) {
                return view2;
            }
            c0(interestedForumStyleATitleViewHolder);
            b0(interestedForumStyleATitleViewHolder, sp7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void b0(InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder, sp7 sp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleATitleViewHolder, sp7Var) == null) {
            interestedForumStyleATitleViewHolder.b.setDefaultResource(R.drawable.obfuscated_res_0x7f08077d);
            interestedForumStyleATitleViewHolder.b.K(sp7Var.a(), 10, false);
            interestedForumStyleATitleViewHolder.c.setText(sp7Var.b());
        }
    }

    public final void c0(InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interestedForumStyleATitleViewHolder) == null) {
            vr4 d = vr4.d(interestedForumStyleATitleViewHolder.c);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            d.A(R.string.F_X02);
            if (UbsABTestHelper.isInterestGuideStyleB()) {
                vr4 d2 = vr4.d(interestedForumStyleATitleViewHolder.a);
                d2.n(R.string.J_X14);
                d2.f(R.color.CAM_X0201);
            }
        }
    }
}
