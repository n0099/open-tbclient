package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class su7 extends du7<pr7, PbLoadMoreItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId o;
    public View.OnClickListener p;
    public int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su7(qy7 qy7Var, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(qy7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy7Var, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qy7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = bdUniqueId2;
        this.q = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    }

    @Override // com.repackage.du7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        c0(i, view2, viewGroup, (pr7) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public PbLoadMoreItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbLoadMoreItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d060d, viewGroup, false), this.o) : (PbLoadMoreItemViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, pr7 pr7Var, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pr7Var, pbLoadMoreItemViewHolder})) == null) {
            super.S(i, view2, viewGroup, pr7Var, pbLoadMoreItemViewHolder);
            if (pr7Var.b) {
                pbLoadMoreItemViewHolder.f(pr7Var.a);
            } else {
                pbLoadMoreItemViewHolder.e(pr7Var.a, this.q);
            }
            pbLoadMoreItemViewHolder.d(this.p);
            pbLoadMoreItemViewHolder.c();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }
}
