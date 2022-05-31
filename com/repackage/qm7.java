package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qm7 extends wm<an7, InterestedForumStyleAMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gn7 i;
    public hn7 j;

    /* loaded from: classes6.dex */
    public class a implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm7 a;

        public a(qm7 qm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm7Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof an7)) {
                an7 an7Var = (an7) jnVar;
                if (this.a.i != null) {
                    this.a.i.d(an7Var.a(), an7Var.b(), i);
                }
                if (this.a.j != null) {
                    this.a.j.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qm7(Context context, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, an7 an7Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        c0(i, view2, viewGroup, an7Var, interestedForumStyleAMoreViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public InterestedForumStyleAMoreViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03e8, viewGroup, false);
            } else {
                inflate = UbsABTestHelper.isInterestGuideStyleB() ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03eb, viewGroup, false) : null;
            }
            return new InterestedForumStyleAMoreViewHolder(inflate);
        }
        return (InterestedForumStyleAMoreViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, an7 an7Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, an7Var, interestedForumStyleAMoreViewHolder})) == null) {
            g0(interestedForumStyleAMoreViewHolder);
            d0(interestedForumStyleAMoreViewHolder, an7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void d0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder, an7 an7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleAMoreViewHolder, an7Var) == null) {
            interestedForumStyleAMoreViewHolder.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0927));
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                if (an7Var.e()) {
                    interestedForumStyleAMoreViewHolder.b.setVisibility(0);
                } else {
                    interestedForumStyleAMoreViewHolder.b.setVisibility(8);
                }
            } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                if (an7Var.e()) {
                    interestedForumStyleAMoreViewHolder.b.setVisibility(0);
                    interestedForumStyleAMoreViewHolder.e.setVisibility(8);
                    return;
                }
                interestedForumStyleAMoreViewHolder.b.setVisibility(8);
                interestedForumStyleAMoreViewHolder.e.setVisibility(0);
            }
        }
    }

    public void e0(gn7 gn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gn7Var) == null) {
            this.i = gn7Var;
        }
    }

    public void f0(hn7 hn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hn7Var) == null) {
            this.j = hn7Var;
        }
    }

    public final void g0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAMoreViewHolder) == null) {
            wq4 d = wq4.d(interestedForumStyleAMoreViewHolder.c);
            d.v(R.color.CAM_X0302);
            d.z(R.dimen.T_X07);
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                wq4.d(interestedForumStyleAMoreViewHolder.d).f(R.color.CAM_X0206);
            } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                wq4 d2 = wq4.d(interestedForumStyleAMoreViewHolder.b);
                d2.n(R.string.J_X17);
                d2.f(R.color.CAM_X0201);
                wq4 d3 = wq4.d(interestedForumStyleAMoreViewHolder.e);
                d3.n(R.string.J_X17);
                d3.f(R.color.CAM_X0201);
            }
        }
    }
}
