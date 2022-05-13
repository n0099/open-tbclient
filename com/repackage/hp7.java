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
public class hp7 extends eo<rp7, InterestedForumStyleAMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xp7 i;
    public yp7 j;

    /* loaded from: classes6.dex */
    public class a implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hp7 a;

        public a(hp7 hp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hp7Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof rp7)) {
                rp7 rp7Var = (rp7) roVar;
                if (this.a.i != null) {
                    this.a.i.d(rp7Var.a(), rp7Var.b(), i);
                }
                if (this.a.j != null) {
                    this.a.j.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hp7(Context context, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, rp7 rp7Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        c0(i, view2, viewGroup, rp7Var, interestedForumStyleAMoreViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public InterestedForumStyleAMoreViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03f2, viewGroup, false);
            } else {
                inflate = UbsABTestHelper.isInterestGuideStyleB() ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03f5, viewGroup, false) : null;
            }
            return new InterestedForumStyleAMoreViewHolder(inflate);
        }
        return (InterestedForumStyleAMoreViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, rp7 rp7Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp7Var, interestedForumStyleAMoreViewHolder})) == null) {
            g0(interestedForumStyleAMoreViewHolder);
            d0(interestedForumStyleAMoreViewHolder, rp7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void d0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder, rp7 rp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleAMoreViewHolder, rp7Var) == null) {
            interestedForumStyleAMoreViewHolder.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0921));
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                if (rp7Var.e()) {
                    interestedForumStyleAMoreViewHolder.b.setVisibility(0);
                } else {
                    interestedForumStyleAMoreViewHolder.b.setVisibility(8);
                }
            } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                if (rp7Var.e()) {
                    interestedForumStyleAMoreViewHolder.b.setVisibility(0);
                    interestedForumStyleAMoreViewHolder.e.setVisibility(8);
                    return;
                }
                interestedForumStyleAMoreViewHolder.b.setVisibility(8);
                interestedForumStyleAMoreViewHolder.e.setVisibility(0);
            }
        }
    }

    public void e0(xp7 xp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xp7Var) == null) {
            this.i = xp7Var;
        }
    }

    public void f0(yp7 yp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yp7Var) == null) {
            this.j = yp7Var;
        }
    }

    public final void g0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAMoreViewHolder) == null) {
            gs4 d = gs4.d(interestedForumStyleAMoreViewHolder.c);
            d.v(R.color.CAM_X0302);
            d.z(R.dimen.T_X07);
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                gs4.d(interestedForumStyleAMoreViewHolder.d).f(R.color.CAM_X0206);
            } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                gs4 d2 = gs4.d(interestedForumStyleAMoreViewHolder.b);
                d2.n(R.string.J_X17);
                d2.f(R.color.CAM_X0201);
                gs4 d3 = gs4.d(interestedForumStyleAMoreViewHolder.e);
                d3.n(R.string.J_X17);
                d3.f(R.color.CAM_X0201);
            }
        }
    }
}
